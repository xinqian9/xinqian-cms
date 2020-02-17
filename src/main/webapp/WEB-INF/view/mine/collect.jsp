<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css" />
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function gopage(pageNum){
		alert(pageNum)
		var url="/collect/selectCollects?pageNum="+pageNum;
		$("#center").load(url);
	}
	
	/* $(function(){
			if("${msg}"=="删除成功！"){
				alert("删除成功！");
				$("#container").load("/collect/selectCollects");
			}if("${msg}"=="删除失败！"){
				alert("删除失败！");
				location.reload();
			}
		}) */
	function deleteCollect(id){
		/* $.ajax({
			url:"/collect/deleteCollect",
			data:{"id":id},
			dataType:"json",
			type:"post",
			function(result){
				if(result){
					alert("删除成功！");
					$("#center").load("/collect/selectCollects");
				}else{
					alert("删除失败！");
				}
			}
		}) */
		$.post("/collect/deleteCollect",{"id":id},function(result){
			if(result){
				alert("删除成功！");
				$("#center").load("/collect/selectCollects");
			}else{
				alert("删除失败！");
			}
		
		},"json")
	}

</script>
</head>
<body>
	<div id="c">
	
		<h5 style="margin-top: 20px">我的收藏夹</h5>
		<hr color="red">
		<button type="button" class="btn btn-light" onclick="toAdd()">新建收藏夹</button>
		<hr>
		<div>
			<ul class="list-group">
				<c:forEach items="${list}" var="c">
					<li class="list-group-item">
					<a href="#">${c.text}</a><br>
					时间：<fmt:formatDate value="${c.created}" pattern="yyyy-MM-dd hh:mm:ss"/>
					<a href="javascript:deleteCollect(${c.id})" style="margin-left: 300px">删除</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<jsp:include page="/WEB-INF/view/public/page.jsp"></jsp:include>
	</div>
</body>
</html>