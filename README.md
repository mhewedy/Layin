Layin
=====
`Layin` built to remove duplicate in your JSP pages. It is the simplest ever template framework you can see. (**it consists only from 1 java source file**).

Suppose you have a webapp of 5 JSP pages, each the same header, footer and a left pane.

You have 2 Option:   

1. To have the 5 pages contains the HTML code for the header, footer and left page, and when you need to change the footer, you have to change in the 5 pages.   
2. To use some template engine like `freemarker`,  `Apache Velocity` or `Apache tiles`, but you need to face some learning curve, besides your webapp might be simple and you need to keep it simple.

####So what is the solution?
The solution is  `Layin`.  That's it, `Layin` is the simplest ever template framework. All you need to know is very very simple rules, an all you will find in this readme page. see the next section "[Usage](#Usage)".

### Usage:
Three components the things you need to know about, the Filter<i class="icon-cog"></i>, the Layout file(s) <i class="icon-folder-open"></i> and your JSPs <i class="icon-file"></i>.

####<i class="icon-cog"></i>The Filter 
Copy this Java Servlet Filter [LayoutFilter.java](https://github.com/MuhammadHewedy/Layin/blob/master/WEB-INF/src/LayoutFilter.java) to your Servlet-based webapp. (regardless of the web framework you use)

####<i class="icon-folder-open"></i>The Layout file(s): 
It is a simple JSP page that contains the Header, Footer and navigation pane (or any other generic markup you use in your webapp)

You need to know about 4 request variables:

1. `requestScope.title`: Represents the page title.
2. `requestScope.script`:Represents the javascript code for JSP page.
3. `requestScope.body`: Represents the JSP page body contents.
4. `requestScope.path`: Has special use, as it should prepend any relative URL in the layout file.

See example here: [Layout Example](https://github.com/MuhammadHewedy/Layin/blob/master/WEB-INF/layout/main_layout.jsp)

>You can have multiple Layout files as you like.

####<i class="icon-file"></i>JSP pages that uses the Layout 
It is the JSP pages that componse your app (like: `Order.jsp`, `AddCustomer.jsp` , etc ... )

1. Reference the layout file by setting attribute named `layout_file` in top of the JSP page.
2. Then you will have three sections 
  - `@title` contains the title of the JSP page.
  - `@script` contains your javascirpts that need to have in your JSP:
	    - Should include javascript in `<script>` tage.
	    - In Javascript code, only comments that looks like `/* ... */` is allowed.
	    - Any Javascript statement should ends with a semi colon.
  - `@body` contains the HTML body of your JSP page.

See example here: [JSP page Example](https://github.com/MuhammadHewedy/Layin/blob/master/index.jsp)
