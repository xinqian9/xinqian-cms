<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#text{
		height: 30px;
		width: 300px;
	}
</style>
<script type="text/javascript">
	//分页
	/* $(function(){
		$(".page-link").click(function(){
			var url=$(this).attr("data");
			$("#content-wrapper").load(url);
		})
	})  */
	function searchUser(){
		var username=$("[name=username]").val();
		var url="/user/selectUsers?username="+username;
		$("#content-wrapper").load(url);
	}
	function lock(id,obj){
		var lock=$(obj).text()=="改为正常"?0:1;
		//调用方法 修改标签
		$.post(
			"/user/updateLocked",
			{id:id,locked:lock},
			function(msg){
				$(obj).text(lock==0?"改为禁用":"改为正常");
				$(obj).attr("class",lock==0?"btn btn-primary":"btn btn-secondary");
			}
		);
	}
	//分页
	function gopage(pageNum){
		var url="/user/selectUsers?pageNum="+pageNum+"&"+$("#form").serialize();
		$("#content-wrapper").load(url);
	}
</script>
</head>
<body>
<div style="padding: 0 20px 0 20px">

		<div class="form-inline">
			<form id="form">
				用户姓名：<input id="text" class="form-control form-control-lg" type="text" placeholder="请输入..." name="username" value="${username}">
				&nbsp;&nbsp;
				<button type="button" class="btn btn-primary" onclick="searchUser()">Search</button>
			
			</form>
		</div><br>
		<table class="table table-bordered">
			<tr align="center">
				<td>序号</td>
				<td>用户名</td>
				<td>昵称</td>
				<td>性别</td>
				<td>生日</td>
				<td>注册日期</td>
				<td>修改日期</td>
				<td>状态</td>
			</tr>
			
			<c:forEach items="${list}" var="u" varStatus="count">
				<tr align="center">
					<td>${u.id}</td>
					<td>${u.username}</td>
					<td>${u.password}</td>
					<td>${u.gender}</td>
					<td>${u.birthday}</td>
					<td>${u.created}</td>
					<td>${u.updated}</td>
					<td>
						<c:if test="${u.locked==0}">
							<button type="button" class="btn btn-primary" onclick="lock(${u.id},this)">改为禁用</button>
						</c:if>
						<c:if test="${u.locked==1}">
							<button type="button" class="btn btn-secondary" onclick="lock(${u.id},this)">改为正常</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 引入分页的页面 -->
		<jsp:include page="/WEB-INF/view/public/page.jsp"></jsp:include>

	</div>
</body>
</html>