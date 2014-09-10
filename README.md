Layin
=====

It is as simple as possible, and very easy to use utility Layout class.

### Usage:

** Filter 
You should use the filter LayoutFilter.java in your web app.

** for layout file: 
(example: https://github.com/MuhammadHewedy/Layin/blob/master/WEB-INF/layout/main_layout.jsp)

In your layout file you have 4 request variables:

1. requestScope.title: used as a placeholder for page title
2. requestScope.script: used as a placeholder for javascirpts
3. requestScope.body: used as a placeholder for body contents
4. requestScope.path: has special use, as it should append any relative URL in the laytout file


** In the jsp pages that need to use the templates: 
(example: https://github.com/MuhammadHewedy/Layin/blob/master/index.jsp)

1. Reference the layout file by setting attribute named "layout_file" in top of JSP page.
2. Then you will have three sections 
  - @title contains the title 
  - @script contains your javascirpts that need to have in your jsp (
    - should include js in <script> tage.
    - in js code, only comments that looks like /* ... */ is allowed.
    - any js statement should ends with a semi colon.
  - @body contains the HTML body of your JSP page


