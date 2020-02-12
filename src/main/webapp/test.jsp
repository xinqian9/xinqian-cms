<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 响应式布局 -->
<meta name="viewport" content="width=device-width, inital-scale=1.0">
<title>Insert title here</title>
<!-- 引入bootstrap -->
<link href="/resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<!-- container：样式 一般加到最大的div上 -->
	<div class="container">
		<!-- 上 -->
		<div class="row" style="background-color: red;height: 200px"></div>
		<!-- 下 -->
		<div class="row">
			<!-- 下左 -->
			<div class="col-md-3" style="background-color: pink;height: 400px"></div>
			<!-- 下右 -->
			<div class="col-md-9" style="background-color: orange;height: 400px"></div>
		</div>
	</div>
</body>
</html>