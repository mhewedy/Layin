<%request.setAttribute("layout_file", "WEB-INF/layout/main_layout.jsp");%>

@title{
Sample usage for the template
}

@script{
	<script>
		/* Each javascript stmt should ends with a semicolon, and this is the only comment type allowed */
		$('#contents').html('This is the contents of the index.jsp page');  
	</script>
}

@body{
	<div id="contents"> </div>
}

