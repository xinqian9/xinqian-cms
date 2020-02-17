<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript">
	function add(text){
		//判断用户有没有登录
		//如果没有登录，则去登陆
		var user='${sessionScope.user}';
		if(user==""){
			location.href="/user/login";
		}else{
			//如果已经登录，去收藏
			//ajax收藏 text(title) url
			//获得收藏夹的地址==当前页面的访问地址
			var url=window.location.href;
			alert(url)
			$.post("/collect/addCollect",{text:text,url:url},function(msg){
				if(msg==-1){
					alert("url地址不合法");
				}else if(msg==0){
					alert("收藏失败，请重试");
				}else{
					alert("收藏成功！");
				}
			},"json")
		}
	}
	function gopage(pageNum){
		//var url="/article/selectsComments?pageNum="+pageNum;
		var id='${article.id}'
		location.href="/article/selectArticleById?id="+id+"&pageNum="+pageNum;
	}
	
	function addComment(){
		var content=$("#content").val();
		var id='${article.id}';
		$.post("/comment/addComment",{"article.id":id,content:content},function(result){
			if(result>0){
				alert("评论成功！")
				location.reload();
			}else{
				alert("评论失败，请稍后重试！")
			}
		},"json");
	}

</script>
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
		<div class="col-md-12" style="background-color: #eeeff0;height: 3000px" align="center">
			<h2 style="font-weight: bolder;">${article.title}</h2>
			<div class="col-md-10" style="height: 800px;">
				<p style="font-size: 14px">来源：${article.user.username}&nbsp;&nbsp;&nbsp;
					创建时间：<fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd hh:mm:ss"/>
				</p>
				<font style="font-size: 17px">
					${article.content }
				</font><br>
				<img alt="" src="/pic/${article.picture }" width="300px" height="200px">
				<br><br>
				<button type="button" class="btn btn-info" style="margin-left: 500px" onclick="add('${article.title}')">☆收藏</button>
				<hr color="red">
			<c:if test="${sessionScope.user==null}">
				<h5 style="color: red">请登录后评论！</h5>
			</c:if>
			<c:if test="${sessionScope.user!=null}">
				<textarea rows="3" cols="118" id="content"></textarea>
				<button type="button" class="btn btn-secondary" style="margin-left: 750px" onclick="addComment()">提交评论</button>
			</c:if>
			<ul class="list-group list-group-flush">
			<c:forEach items="${list}" var="comment">
				  <li class="list-group-item">
				  ${comment.user.nickname}&nbsp;&nbsp;&nbsp;&nbsp;${comment.created}
				  <br>${comment.content }
				  </li>
			</c:forEach>
			</ul>
			<jsp:include page="/WEB-INF/view/public/page.jsp"></jsp:include>
			</div>
			
		</div>
		
		
	</div>
	
</body>
</html>