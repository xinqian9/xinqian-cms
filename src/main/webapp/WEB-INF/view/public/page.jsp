<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item">
		      <a class="page-link" href="javascript:gopage(${page.prePage==0?1:page.prePage})" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <c:forEach items="${page.navigatepageNums}" var="p">
			    <li class="page-item"><a class="page-link" href="javascript:gopage(${p})">${p}</a></li>
		    
		    </c:forEach>
		    <li class="page-item">
		      <a class="page-link" href="javascript:gopage(${page.nextPage==0?page.pages:page.nextPage})" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
</body>
</html>