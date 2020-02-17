<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>个人中心</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css" />
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<style type="text/css">
	#a1{
		color: #eeeff0;
	}
	
	#a2{
		color: #000;
	}
</style>
<script type="text/javascript">
	$(function(){
		
		$(".list-group-item").click(function(){
			var url=$(this).attr("data");
			$("#center").load(url);
			//把active样式去除
			$(".list-group-item").attr("class","list-group-item");
			$(this).attr("class","list-group-item active");
		})
		
	})
	
	function gopage(pageNum){
		var url="/article/selectArticles?pageNum="+pageNum+"";
		$("#center").load(url);
	}
</script>
</head>
<body>
	<div class="container">
		<div style="height: 30px;background-color: red" class="col-md-12" align="right">
			<font style="padding-left:900px;color: #eeeff0">欢迎${sessionScope.user.username}&nbsp;&nbsp;&nbsp;
				<a href="/main" id="a1">返回主页</a>
			
			</font>	
		</div>
		<!--顶部  -->
		<div class="row">
			<div class="col-md-12" style="background-color: white">
				<img alt="" src="/resource/images/111.jpg" width="200" height="100" class="">
				&nbsp;&nbsp;&nbsp;
				<font style="font-size:25px;color: red;font-family:'宋体';font-weight: bolder;">CMS个人中心</font>
			</div>
		</div>
		<div class="row">
			<!-- 导航栏 -->
			<div class="col-md-2" style="padding-top: 10px">
			<nav class="nav flex-column">
				<a class="list-group-item active" style="padding-top: 20px" href="#" data="/article/selectArticles" >查看文章</a>
				<a class="list-group-item "  style="padding-top: 20px" href="javascript:void(0)" data="/article/toAdd">发布文章</a>
				<a class="list-group-item "  style="padding-top: 20px" href="javascript:void(0)" data="/collect/selectCollects">我的收藏夹</a>
				<a class="list-group-item "  style="padding-top: 20px" href="#" data="/article/addArticle">资料管理</a>
			</nav>
			
			</div>
			<!-- 中间区域显示内容 -->
			<div class="col-md-10" id="center"
				style="background-color: #eeeff0; height: 600px">
				<div style="padding-top: 10px">
					<ul class="list-unstyled">
						<c:forEach items="${list}" var="a">
							<li class="media text-center"><img src="/pic/${a.picture}"
								class="mr-3" alt="..." width="190px" height="150px">
								<div class="media-body" style="padding-top: 10px">
									<h4 class="mt-0 mb-1"
										style="padding-top: 40px; font-weight: bolder;">
										<a href="/article/selectArticleById?id=${a.id}" id="a2">${a.title}</a>
									</h4>
									<br> ${a.user.username}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										发布时间：<fmt:formatDate value="${a.created}" pattern="yyyy-MM-dd hh:mm:ss"/>
								</div></li>
							<hr>
						</c:forEach>
						<jsp:include page="/WEB-INF/view/public/page.jsp"></jsp:include>
					</ul>
				</div>
				<!-- 引用富文本编辑器 -->
				<div style="display: none">
					<jsp:include page="/resource/kindeditor/jsp/demo.jsp"></jsp:include>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>