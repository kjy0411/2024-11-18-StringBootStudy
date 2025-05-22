<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<table class="table">
				<tr>
					<td width="40%" class="text-center" rowspan="9">
						<img src="https://www.menupan.com${vo.poster }" style="widows: 380px;height: 300px;" class="img-rounded">
					</td>
					<td width="60%" colspan="2">
						<h3>${vo.name }&nbsp;<span style="color: orange;">${vo.score }</span></h3>
					</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray;">음식종류</td>
					<td width="45%">${vo.type }</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray;">주소</td>
					<td width="45%">${vo.address }</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray;">전화</td>
					<td width="45%">${vo.phone }</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray;">가격대</td>
					<td width="45%">${vo.price }</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray;">주차</td>
					<td width="45%">${vo.parking }</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray;">영업시간</td>
					<td width="45%">${vo.time }</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray;">테마</td>
					<td width="45%">${vo.theme }</td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<td>
						${vo.content }
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>