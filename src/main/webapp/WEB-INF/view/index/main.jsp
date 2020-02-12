<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css" />
<link  rel="stylesheet" type="text/css" 
	href="/resource/css/cms.css"/>
<link  rel="stylesheet" type="text/css" 
	href="/resource/css/index.css"/>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<style type="text/css">
	#a1{
		color: #eeeff0;
	}
	#a2{
		font-weight: bolder;
	}
	
</style>
<script type="text/javascript">
function gopage(pageNum){
	if("${article.channel_id}"==null){
		var url="/article/selectArticles?pageNum="+pageNum+"&hot=1";
		$("#hotArticles").load(url);			
	}else{
		var url="/article/selectArticles?pageNum="+pageNum+"&channel_id=${article.channel_id}";
		$("#cateArticles").load(url);
	}
}

</script>
</head>
<body>
	<div style="height: 30px;background-color: black" class="col-md-12" align="right">
			<jsp:include page="/WEB-INF/view/index/top.jsp"></jsp:include>

	</div>
	<div class="container">
		
		<!--顶部  -->
		<div class="row">
			<div class="col-md-12" style="background-color: white">
				<img alt="" src="/resource/images/111.jpg" width="200" height="100" class="">
				&nbsp;&nbsp;&nbsp;
				<font style="font-size:25px;color: red;font-family:'宋体';font-weight: bolder;">CMS首页</font>
			</div>
		</div>
		
		
		<!-- 中 -->
		<div class="row">
			<!--所有的栏目  -->
			<!-- 中左 -->
			<div class="col-md-2 min_h_500">
			<ul class="">
  				<li class="channel-item ${article.channel_id==null?'active':''}"><a href="/main?hot=1" id="a2">热门</a></li>
				<c:forEach items="${channelList}" var="c">
  						<li class="channel-item ${article.channel_id==c.id?'active':''}"><a href="/main?channel_id=${c.id}" id="a2">${c.name}</a></li>
				</c:forEach>
			</ul>
			</div>
			<!-- 中中 -->
			<div class="col-md-7 split min_h_500">
				<!-- 第一次进入，没有选择栏目，默认显示轮播图和热门文章 -->
				<c:if test="${article.channel_id==null}">
					<!-- 轮播图 -->
					<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
					  <ol class="carousel-indicators">
					    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
					    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
					    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
					  </ol>
					  <div class="carousel-inner">
					  	<c:forEach items="${slideList }" var="s" varStatus="i">
						    <div class="carousel-item ${i.index==0?'active':'' }">
						      <img src="/pic/${s.picture}" class="d-block w-100" alt="..." width="300px" height="230px">
						      <div class="carousel-caption d-none d-md-block">
						        <h5>${s.title}</h5>
						        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
						      </div>
						    </div>
					    </c:forEach>
					  </div>
					  
					  <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="sr-only">Previous</span>
					  </a>
					  <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="sr-only">Next</span>
					  </a>
					</div>
					<!--热门文章  -->
					<div id="hotArticles">
						<ul class="list-unstyled">
							<c:forEach items="${hotArticles}" var="a">
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
				</c:if>
				<!--选择了栏目，显示栏目下的文章 和分类-->
				<c:if test="${article.channel_id!=null}">
				<!--栏目下的分类菜单  -->
				<div class="subchannel">
						<ul class="sub-list" style="width: 660px;">
							<li class="sub-item ${article.category_id==null?'sub-selected':'' }"><a
									href="/main/?channel_id=${article.channel_id }">全部</a></li>
							<c:forEach items="${categories}" var="category">

								<li class="sub-item ${article.category_id==category.id?'sub-selected':''}"><a
									href="/main/?channel_id=${article.channel_id}&category_id=${category.id}">${category.name}</a></li>
							</c:forEach>

						</ul>
				</div>
				<hr>
				<!--热门文章  -->
					<div id="cateArticles">
						<ul class="list-unstyled">
							<c:forEach items="${cateArticles}" var="a">
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
				</c:if>
				
			</div>
			<div class="col-md-3 split min_h_500">
				<div class="card" style="width: 18rem">
					<div class="card-header">最新文章</div>
					<ul class="list-group list-group-flush">
						<c:forEach items="${newArticles}" var="a">
							<li class="list-group-item"><a href="">${a.title}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		
		</div>
		<!--下-->
		<!-- <div class="row" style="padding-top: 50px">
			<div class="col-md-12">
				<p class="text-center">@1710D Cdsj 1710D版权所有</p>
			</div>
		</div> -->
	
	</div>
</body>
</html>