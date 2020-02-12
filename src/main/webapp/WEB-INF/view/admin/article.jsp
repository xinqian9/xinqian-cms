<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.dropdown-item{
		width: 200px;
	}
	#text{
		height: 30px;
	}
	
</style>
<script type="text/javascript">
	function changeStatus(status,obj){
		//获得谁要修改状态 修改为那种状态
		/* var status=$(obj).val();

		$.post("/article/updateArticle",{id:id,status:status},function(msg){
			$(obj).parent().text(status==1?"审核通过":"审核未通过");
		}); */
		var id=$(obj).val();
		alert(id);
		$.post("/article/updateArticle",{id:id,status:status},function(msg){
			if(msg){
				alert("审核成功！");
				$("#content-wrapper").load("/article/selectsByAdmin");
			}else{
				alert("审核失败！");
			}
		});
	}
	function searchArticle(){
		var title=$("[name='title']").val();
		var status=$("[name='status']").val();
		var url="/article/selectsByAdmin?title="+title+"&status="+status;
		$("#content-wrapper").load(url);
	}
	
	//分页
	function gopage(pageNum){
		var url="/article/selectsByAdmin?pageNum="+pageNum+"&"+$("#form").serialize();
		$("#content-wrapper").load(url);
	}
	//查看详情
	function look(id){
		id=id;
		$.post("/article/selectArticleById",{id:id},
			function(obj){
				$(".modal-body").html(obj.content);
				$(".modal-title").html(obj.title);
				$("[name='id']").val(obj.id);
			})
	}	

</script>
</head>
<body>
	<div style="padding: 0 20px 0 20px">
	<form id="form">
		<div class="form-group  form-inline">
			
				文章标题：<input id="text" class="form-control form-control-lg" type="text" placeholder="请输入..." name="title" value="${article.title}">
				&nbsp;&nbsp;
				状态：<select name=status class="dropdown-item" style="width:140" size=1>
						<option value="">--请选择--</option>
						<option value="0" ${article.status==0?'selected':'' }>待审</option>
						<option value="1" ${article.status==1?'selected':'' }>审核通过</option>
						<option value="-1" ${article.status==-1?'selected':'' }>审核未通过</option>
					</select>
				<button type="button" class="btn btn-primary" onclick="searchArticle()">Search</button>
			
		</div>
		</form><br>
		<br>
		<table class="table table-bordered">
			<tr align="center">
				<td>编号</td>
				<td>文章标题</td>
				<td>文章内容</td>
				<td>标题图片</td>
				<td>作者</td>
				<td>点击量</td>
				<td>是否热门</td>
				<td>是否审核通过</td>
				<td>创建时间</td>
				<td>详情</td>
			</tr>

			<c:forEach items="${list}" var="a" varStatus="count">
				<tr align="center">
					<td>${a.id}</td>
					<td>${a.title}</td>
					<td>${a.content}</td>
					<td>
						<img alt="" src="/pic/${a.picture}" width="40px" height="40px">
					</td>
					<td>${a.user.username}</td>
					<td>${a.hits}</td>
					<td>${a.hot}</td>
					<td id="td">
						<%-- ${a.status} --%> 
						<%-- <c:if test="${a.status==0}">
						<select name=status onchange="changeStatus(${a.id},this)">
							<option value="0">--待审--</option>
							<option value="1">审核通过</option>
							<option value="-1">审核未通过</option>
						</select>--%>
						<c:if test="${a.status==0}">
							待审
						</c:if> 
						<c:if test="${a.status==1}">
							审核通过
						</c:if> 
						<c:if test="${a.status==-1}">
							审核未通过
						</c:if>
					</td>
					<td>${a.created}</td>
					<td>
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" onclick="look(${a.id})">详情</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 引入分页的页面 -->
		<jsp:include page="/WEB-INF/view/public/page.jsp"></jsp:include>
	</div>

	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel"></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success"
						data-dismiss="modal" name="id" onclick="changeStatus(1,this)">通过</button>
					<button type="button" name="id" class="btn btn-danger" onclick="changeStatus(-1,this)">不通过</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>