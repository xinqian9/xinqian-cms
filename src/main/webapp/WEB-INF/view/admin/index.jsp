<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>管理员后台</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/resource/css/sb-admin.css" />
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//给左侧导航栏中所有的连接绑定点击事件
	$(function(){
		$(".nav-link").click(function(){
			//获得跳转的路径
			var url=$(this).attr("data");
			//跳转到url,查询的结果在index的内容部分显示content-wrapper
			$("#content-wrapper").load(url);
		})
	})
	
	
</script>
</head>
<body id="page-top">
	<!-- 后台管理系统顶部 -->
	<jsp:include page="top.jsp" />
	<div id="wrapper">
		<!-- 后台管理系统左部菜单 -->
		<jsp:include page="left.jsp" />
		<!-- 中间内容显示区域 -->
		<div id="content-wrapper">

			<div class="container-fluid">
				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">后台首页</a></li>
					<li class="breadcrumb-item active">概览</li>
				</ol>

				<!-- Icon Cards-->
				<br /> <br />
				<h1 align="center">欢迎光临后台管理系统</h1>
				
				</div>

			</div>

			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright Â© Your Website 2019</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->


</body>
</html>