<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewprot" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap4.5.css' />">
<style>
h2 {
	text-align: center;
	margin-top: 100px;
	margin-bottom: 50px;
	text-shadow: 0 1px black;
}
.form-signUp {
	margin: 0 auto;
	width: 300px;
}
.title{
	font-size: 20px;
}
.button-group{
	margin-top: 25px;
}
</style>
</head>
<body class="container">
	<h2>signUp</h2>
	<form class="form-signUp" method="post" action="signUp">
		<sec:csrfInput/>
		<div class="form-group">
			<label class="title">username</label>
			<input type="text" name="username" class="form-control" required>
		</div>
		<div class="form-group">
			<label class="title">password</label>
			<input type="password" name="password" class="form-control" required>
		</div>
		<label class="title">authority</label>
		<div class="form-check">
			<input type="radio" id="basic" name="rolename"  class="form-check-input" value="BASIC" checked>
			<label class="form-check-label" for="basic">BASIC</label>
		</div>
		<div class="form-check">
			<input type="radio" id="manager" name="rolename" class="form-check-input" value="MANAGER">
			<label class="form-check-label" for="manager">MANAGER</label>
		</div>
		<div class="form-check">
			<input type="radio" id="admin" name="rolename" class="form-check-input" value="ADMIN">
			<label class="form-check-label" for="admin">ADMIN</label>
		</div>
		<div class="button-group text-center">
			<button type="submit" class="btn btn-primary">signUp</button>
			<button type="button" class="btn btn-primary" onclick="history.back()">cancel</button>
		</div>
	</form>
</body>
</html>