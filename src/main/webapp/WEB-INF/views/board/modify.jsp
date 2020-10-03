<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>modify</title>
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap4.5.css' />">
<script type="text/javascript" src="<c:url value='/resources/js/jquery-3.5.1.js' />"></script>
<style type="text/css">
header{
	display: flex;
	justify-content: space-between;
	background-color: #b2bec3;
	height: 100px;
	padding-left: 30px;
	padding-right: 30px;
}
.title{
	display: flex;
	align-items: center;
}
.button-section{
	text-align: center
}
</style>
</head>
<body>
	<div class="container">
		<header>
			<section class="title">
				<h1>simple board<small class="text-muted">[spring+myBatis]</small></h1>
			</section>
		</header>
		<br>
		<div class="content">
			<form action="/modify" method="post">
				<sec:csrfInput/>
				<input type="hidden" name="bno" value="${board.bno}">
				<input type="hidden" name="hit" value="${board.hit}">
				<div class="form-group">
					<label for="title">title</label>
					<input type="text" class="form-control" name="title" value="${board.title}">
				</div>
				<div class="form-group">
					<label for="writer">writer</label>
					<input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
				</div>
				<div class="form-group">
					<label for="content">content</label>
					<textarea class="form-control" name="content" rows="10">${board.content}</textarea>
				</div>
				<div class="button-section">
					<button type="button" class="btn btn-primary" onclick="history.back()">취소</button>
					<button type="submit" class="btn btn-warning">수정</button>  
				</div>
			</form>
			<br>
		</div>
	</div>
</body>
</html>