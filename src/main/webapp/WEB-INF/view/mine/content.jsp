<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>详情</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css" />
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<style type="text/css">
	#a1{
		color: #eeeff0;
	}
</style>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		
		<div class="row">
			<div style="height: 30px;background-color: red" class="col-md-12" align="right">
				<font style="padding-left:900px;color: #eeeff0">
					<a href="/index/" id="a1">返回上一级</a>
				
				</font>	
			</div>
			<div class="col-md-12" style="background-color: white">
				<img alt="" src="/resource/images/111.jpg" width="200" height="100" class="">
				&nbsp;&nbsp;&nbsp;
				<font style="font-size:25px;color: red;font-family:'宋体';font-weight: bolder;">CMS详情页</font>
			</div>
		</div>
		<div class="col-md-12" style="background-color: #eeeff0;height: 1000px" align="center">
			<h2 style="font-weight: bolder;">${article.title}</h2>
			<div class="col-md-10" style="height: 800px;">
				<p style="font-size: 14px">来源：${article.user.username}&nbsp;&nbsp;&nbsp;
					创建时间：<fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd hh:mm:ss"/>
				</p>
				<font style="font-size: 17px">
					${article.content }
				</font><br>
				<img alt="" src="/pic/${article.picture }" width="300px" height="200px">
			</div>
		</div>
	
	</div>
</body>
</html>