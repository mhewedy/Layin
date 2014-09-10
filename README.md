Layin
=====

It is as simple as possible, and very easy to use Servlet-based Layout Utility.

### Usage:

####Filter 
You should use the filter [LayoutFilter.java](https://github.com/MuhammadHewedy/Layin/blob/master/WEB-INF/src/LayoutFilter.java) in your web app.

####layout file: 
In your layout file you have 4 request variables:

1. `requestScope.title`: Used as a placeholder for page title.
2. `requestScope.script`: Used as a placeholder for javascript.
3. `requestScope.body`: Used as a placeholder for body contents.
4. `requestScope.path`: Has special use, as it should append any relative URL in the layout file.

[Layout Example](https://github.com/MuhammadHewedy/Layin/blob/master/WEB-INF/layout/main_layout.jsp)


####JSP pages that uses the Layout

1. Reference the layout file by setting attribute named `layout_file` in top of the JSP page.
2. Then you will have three sections 
  - `@title` contains the title of the JSP page.
  - `@script` contains your javascirpts that need to have in your JSP:
	    - Should include javascript in `<script>` tage.
	    - In Javascript code, only comments that looks like `/* ... */` is allowed.
	    - Any Javascript statement should ends with a semi colon.
  - `@body` contains the HTML body of your JSP page.

[JSP page Example](https://github.com/MuhammadHewedy/Layin/blob/master/index.jsp)


