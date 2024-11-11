<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>My virtual library</title>
	</head>
	<body bgColor="#ffffff">
		<center>
			<hr>
			<br>
			<h1>
				<font size="+3">Virtual Library</font>
			</h1>
		</center>
		<br>
		<hr>
		<p><b>Online library</b></p>
		<c:url var="url" value="/library/catalog"/>
		<p><b><a href="${url}?add=">Start purchase</a></b></p>
		<br>
		<hr>
		<center>
			<em>Copyright © 2010 Livraria Virtual. </em>
		</center>
	</body>
</html>