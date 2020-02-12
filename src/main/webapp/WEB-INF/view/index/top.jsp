<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
	#a1{
		color: white;
		line-height:15px;
	}
</style>
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css" />
<div class="container-fulid">

	<div style="padding-left: 1000px;margin-left: 20px">
		<!-- 右边登录注册 -->
		<ul class="nav">
			<!-- 如果没有登录  显示登录或者注册的超链接    -->
			<c:if test="${sessionScope.user==null }">
				<li class="nav-item"><a class="nav-link" href="/user/reg" id="a1">注册</a></li>
				<li class="nav-item"><a class="nav-link" href="/user/login" id="a1">登录</a></li>
				
			
			</c:if>
			<!-- 如果登录了  显示个人中心的超链接 -->
			<c:if test="${sessionScope.user!=null }">
					<li class="nav-item"><a class="nav-link" href="/inded" id="a1">欢迎${sessionScope.user.username}</a></li>
					<li class="nav-item"><a class="nav-link" href="/index" id="a1">个人中心</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/loginout" id="a1">退出</a></li>
			</c:if>




		</ul>

	</div>
</div>