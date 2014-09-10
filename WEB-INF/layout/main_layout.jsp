<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
         <title>${requestScope.title}</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
	</head>	
	<body>
		<!-- source (modified): http://www.w3schools.com/html/html_layout.asp -->
		<div id="container" style="width:500px">
		<div id="header" style="background-color:#FFA500;">
			<h1 style="margin-bottom:0;">Main Title of Web Page</h1></div>
			<div id="menu" style="background-color:#FFD700;height:200px;width:100px;float:left;">
				Left menu
			</div>
			<div id="content" style="background-color:#EEEEEE;height:200px;width:400px;float:left;">
					${requestScope.body}
			</div>
			
			<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">Copyright © W3Schools.com</div>
		</div>
		<script src="${requestScope.path}../resources/jquery-1.11.0.min.js"></script>
		${requestScope.script}
	</body>
</html>
