<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index</title>
<link rel="stylesheet" href="<c:url value='resources/css/bootstrap4.5.css' />">
<script type="text/javascript" src="<c:url value='resources/js/jquery-3.5.1.js' />"></script>
<style type="text/css">
header{
	display: flex;
	justify-content: space-between;
	background-color: #b2bec3;
	height: 100px;
	padding-left: 30px;
	padding-right: 30px;
}
.login-section, .title{
	display: flex;
	align-items: center;
}
.login-section a{
	margin-left: 5px;
}
.user{
	font-size: 18px;
	margin-right: 20px;
	color: #34495e;
	text-shadow: 0 1px #34495e;
}
table{
	text-align: center;
}
tbody tr{
	cursor: pointer;
}
.search-section{
	display: flex;
	margin-bottom: 30px;
}
.searchbar{
	margin-left: 10px;
	margin-right: 10px;
}
.search-option{
	width: 20%;
}
.search-btn{
	width: 20%;
}
</style>
</head>
<body>
	<div class="container">
		<header>
			<section class="title">
				<h1>simple board<small class="text-muted">[spring+myBatis]</small></h1>
			</section>
			<section class="login-section">
				<sec:authorize var="isAuthenticated" access="isAuthenticated()" />
				<c:if test="${!isAuthenticated}">
					<a href="/signUp" class="btn btn-primary">signUp</a>
					<a href="/login" class="btn btn-primary">login</a>
				</c:if>
				<c:if test="${isAuthenticated}">
					<span class="user">welcome <sec:authentication property="principal.username"/></span>
					<form action="/logout" method="post">
						<sec:csrfInput/>
						<a href="#" class="btn btn-primary" onclick="this.parentNode.submit()">logout</a>
					</form>
				</c:if>
			</section>
		</header>
		<div class="content">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>title</th>
						<th>writer</th>
						<th>hit</th>
						<th>regdate</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${list}">
						<tr>
							<td>${board.bno}</td>
							<td>${board.title}</td>
							<td>${board.writer}</td>
							<td>${board.hit}</td>
							<td>${board.regdate.toString().substring(0,10)}</td>
							<input type="hidden" value="${board.bno}">
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5" style="text-align: right;">
						<sec:authorize access="isAuthenticated()">
							<a href="/writeForm" class="btn btn-primary">글 작성</a>
						</sec:authorize>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<section class="page-section">
			<ul class="pagination justify-content-center">
				<c:if test="${page.startPage == 1}">
			    	<li class="page-item disabled"><a class="page-link" tabindex="-1" aria-disabled="true" href="#">Previous</a></li>
				</c:if>
				<c:if test="${page.startPage > 1}">
			    	<li class="page-item"><a class="page-link" href="${page.startPage-1}">Previous</a></li>
				</c:if>
			    <c:forEach var="index" begin="${page.startPage}" end="${page.endPage}">
			    	<c:if test="${index == page.currentPage }">
				    	<li class="page-item active"><a class="page-link" href="${index}">${index}</a></li>
			    	</c:if>
			    	<c:if test="${index != page.currentPage }">
				    	<li class="page-item"><a class="page-link" href="${index}">${index}</a></li>
			    	</c:if>
			    </c:forEach>
			    <c:if test="${page.endPage == page.pageCount}">
				    <li class="page-item disabled"><a class="page-link" tabindex="-1" aria-disabled="true" href="#">Next</a></li>
			    </c:if>
			    <c:if test="${page.endPage < page.pageCount}">
				    <li class="page-item"><a class="page-link"href="${page.endPage+1}">Next</a></li>
			    </c:if>
			</ul>
		</section>
		<section class="search-section">
			<select class="form-control search-option">
				<option value="title">title</option>
				<option value="writer">writer</option>
				<option value="title_writer">title+writer</option>
			</select>
			<input type="text" class="form-control searchbar">
			<button type="button" class="btn btn-primary search-btn">검색</button>
		</section>
		<form id="f1" action="/search">
			<input type="hidden" name="option" value="${page.option}">
			<input type="hidden" name="keyword" value="${page.keyword}">
			<input type="hidden" name="currentPage" value="${page.currentPage}">
		</form>
	</div>
	<script>
		const select = document.querySelector(".search-option");
		const searchBar = document.querySelector(".searchbar");
		const searchBtn = document.querySelector(".search-btn");
		
		searchBtn.addEventListener("click", searchList);
		$(".page-link").on("click", movePage);		
		$("tbody > tr").on("click", readContent);
		
		function readContent(e){
			location.href = "/viewContent/"+e.currentTarget.children[0].innerText;
		}


		function movePage(e){
			e.preventDefault();
			formObj = document.querySelector("#f1");
			formObj.elements.currentPage.value = e.currentTarget.getAttribute("href");
			formObj.submit();
		}


		function searchList(){
			formObj = document.querySelector("#f1");
			formObj.elements.option.value = select.value;
			formObj.elements.keyword.value = searchBar.value;
			formObj.elements.currentPage.value = "1";
			formObj.submit();
		}
	</script>
</body>
</html>