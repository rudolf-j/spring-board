<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>viewBoard</title>
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
			<div class="form-group">
				<label for="title">title</label>
				<input type="text" class="form-control" value="${board.title}" readonly>
			</div>
			<div class="form-group">
				<label for="writer">writer</label>
				<input type="text" class="form-control" value="${board.writer}" readonly>
			</div>
			<div class="form-group">
				<label for="content">content</label>
				<textarea class="form-control" rows="10" readonly>${board.content}</textarea>
			</div>
			<div class="button-section">
				<sec:authorize access="isAuthenticated()">
					<c:set var="curruser"><sec:authentication property="principal.username"/></c:set>
				</sec:authorize>
				<a class="btn btn-primary" onclick="history.back()">목록</a>
				<c:if test="${curruser == board.writer }">
					<a class="btn btn-warning btn-modify">수정</a> 
					<a class="btn btn-danger" href="/delete/${board.bno}">삭제</a> 
				</c:if>
			</div>
			<br>
		</div>
		<form class="f1" action="/modifyForm" method="post">
			<sec:csrfInput/>
			<input type="hidden" name="bno" value="${board.bno}">
			<input type="hidden" name="title" value="${board.title}">
			<input type="hidden" name="writer" value="${board.writer}">
			<input type="hidden" name="content" value="${board.content}">
			<input type="hidden" name="hit" value="${board.hit}">
		</form>
	</div>
	<script>
		const btnMod = document.querySelector(".btn-modify");
		const formObj = document.querySelector(".f1");
		btnMod.addEventListener("click", moveModForm);
		
		function moveModForm(e){
			console.log("click");
			e.preventDefault();
			formObj.submit();
		}
	</script>
</body>
</html>