<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login</title>
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap4.5.css' />">
<style type="text/css">
body{
	margin: 0 auto;
	width: 15%;
	padding-top: 10%;
	min-width: 200px;
}
.username{
	margin-top: 20px;
}
.password{
	margin-bottom: 20px;
}
.checkbox{
	margin-bottom: 10px;
}
</style>
</head>
<body class="text-center">
	<form class="form-signin" method="post">
		<sec:csrfInput/>
		<h1 class="h3 font-weight-normal">Please Login</h1>
		<input type="text" name="username" class="form-control username" placeholder="id" required> 
		<input type="password" name="password" class="form-control password" placeholder="Password" required>
		<div class="checkbox">
			<label> <input type="checkbox" name="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
	</form>
	<c:if test="${param.error != null}">
		<h2>${param.error }</h2>
	</c:if>
</body>
</html>