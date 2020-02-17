<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.css" />
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<style type="text/css">
	#a1{
		color: #eeeff0;
	}
	
</style>
<script type="text/javascript">
	function gopage(pageNum){
		var url="/article/selectArticles?pageNum="+pageNum;
		$("#center").load(url);
	}
</script>
</head>
<body>


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
							<br> ${a.user.username}&nbsp;${a.created}
						</div></li>
					<hr>
				</c:forEach>
				<jsp:include page="/WEB-INF/view/public/page.jsp"></jsp:include>
			</ul>
		</div>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        ...
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>