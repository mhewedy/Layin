
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;


@WebFilter(filterName="layoutFilter", urlPatterns="*.jsp")
public class LayoutFilter implements Filter {
	
	private static final Map<String, Pattern> SECTION_PATTERNS = new HashMap<String, Pattern>();
	
    public LayoutFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		response.setCharacterEncoding("UTF-8");
		
	    final CopyPrintWriter writer = new CopyPrintWriter(response.getWriter());

		// source: http://stackoverflow.com/questions/3242236#3242482
		chain.doFilter(request, new HttpServletResponseWrapper((HttpServletResponse) response) {
	        @Override public PrintWriter getWriter() {
	            return writer;
	        }
	    });
		
		String layoutFile = (String) request.getAttribute("layout_file");
		
		if (layoutFile != null){	// if the jsp uses a layout
			
			if (layoutFile.lastIndexOf('/') > 0) {
				String path = layoutFile.substring(0, layoutFile.lastIndexOf('/') + 1);
				request.setAttribute("path", path);
			}
			
			String jspContent = writer.getCopy().replaceAll("\\s+", " ");
			
			for (Entry<String, Pattern> entry : SECTION_PATTERNS.entrySet()) {
				Matcher matcher = entry.getValue().matcher(jspContent);
				
				if (matcher.find()) {
					String section = matcher.group(1);
					request.setAttribute(entry.getKey(), section);
				}
			}
			request.getRequestDispatcher(layoutFile).forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	
	class CopyPrintWriter extends PrintWriter {

	    private StringBuilder copy = new StringBuilder();

	    public CopyPrintWriter(Writer writer) {
	        super(writer);
	    }

	    @Override
	    public void write(int c) {
	        copy.append((char) c); // It is actually a char, not an int.
	        super.write(c);
	    }

	    @Override
	    public void write(char[] chars, int offset, int length) {
	        copy.append(chars, offset, length);
	        super.write(chars, offset, length);
	    }

	    @Override
	    public void write(String string, int offset, int length) {
	        copy.append(string, offset, length);
	        super.write(string, offset, length);
	    }

	    public String getCopy() {
	        return copy.toString();
	    }
	}
	
	static {
		SECTION_PATTERNS.put("title", Pattern.compile("@title\\s*\\{(.*?)\\}"));
		SECTION_PATTERNS.put("script", Pattern.compile("@script\\s*\\{.*(<script>.*</script>).*\\}"));
		SECTION_PATTERNS.put("body", Pattern.compile("@body\\s*\\{(.*?)\\}"));
	}
}

