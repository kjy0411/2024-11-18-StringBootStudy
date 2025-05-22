<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row{
	margin: 0px auto;
	wid 960px;
}
p{
	overflow:hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
.continaer{
	margin-top: 50px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<c:forEach var="vo" items="${list}">
				<div class="col-md-3">
				<div class="thumbnail">
					<a href="/detail?fno=${vo.fno} }">
						<img src="https://www.menupan.com${vo.poster}" style="wid230px;height: 120px">
						<div class="caption">
							<p>${vo.name}</p>
						</div>
					</a>
				</div>
			</div>
			</c:forEach>
		</div>
		<div class="row text-center" style="margin-top: 20px">
			<ul class="pagination">
				<c:if test="${startPage>1}">
					<li><a href="/list?page=${startPage-1}">&laquo;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<li class="${curpage==i?'active':''}"><a href="/list?page=${i}">${i}</a></li>
				</c:forEach>
				<c:if test="${endPage<totalpage}">
					<li><a href="/list?page=${endPage+1}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>