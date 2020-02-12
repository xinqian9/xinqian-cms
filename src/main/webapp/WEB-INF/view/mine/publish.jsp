<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<style>
	#text{
		height: 30px;
		width: 300px;
	}
	#opt1,#opt2{
		width: 200px;
	}
</style>
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="/resource/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="/resource/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="/resource/kindeditor/plugins/code/prettify.js"></script>
	<script charset="utf-8" src="/resource/kindeditor/kindeditor-all.js"></script>
    <script charset="utf-8" src="/resource/kindeditor/lang/zh-CN.js"></script>
	<script
		src="/resource/js/jquery-3.2.1.js"></script>

	<script>
		KindEditor.ready(function(K) {
			window.editor1 = K.create('textarea[name="content1"]', {
				cssPath : '/resource/kindeditor/plugins/code/prettify.css',
				uploadJson : '/resource/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '/resource/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
		/* function query(){
		alert(editor1.html())
			//alert( $("[name='content1']").attr("src"))
		} */
		$(function(){
			//加载所有栏目 追加到下拉框
			$.post("/article/selectChannels",{},function(json){
				alert(typeof(json))
				$.each(json,function(i,val){
					$("[name='channel_id']").append("<option value="+val.id+">"+val.name+"</option>")
				})
			},"json")
		})
		
		function changeCategory(id){
			alert(id);
			
			$.post("/article/selectCategorys",{"id":id},function(json){
				$.each(json,function(i,val){
					$("[name='category_id']").append("<option value="+val.id+">"+val.name+"</option>")
				})
			},"json")
			$("#opt2 option:gt(0)").remove();
		}
		
		function addArticle(){
			//异步请求 上传 副文本编辑器
			//序列化表单数据  带文件
			var formData=new FormData($("#f1")[0]);
			//封装副文本编辑器的内容
			formData.append("content",editor1.html());
			//ajax添加
			$.ajax({
				// 告诉jQuery不要去处理发送的数据
				processData:false,
				// 告诉jQuery不要去设置Content-Type请求头
				contentType:false,
				url:"/article/addArticle",
				type:"post",
				data:formData,
				dataType:"json",
				success:function(msg){
					if(msg){
						alert("发布完成！");
						$("#center").load("article/selectArticles");
					}else{
						alert("发布失败！")
					}
				}
			})
			
		}
	</script>
</head>
<body>
	<%=htmlData%>
	<form name="example" method="post" action="demo.jsp" id="f1" enctype="multipart/form-data">
		文章标题：
		<input id="text" class="form-control form-control-lg" type="text" placeholder="请输入..." style="width: 700px;height: 30px" name="title"><br>
		<textarea name="content1" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
		<br />
		<div class="form-inline">
			文章栏目：<select name="channel_id" class="form-control" id="opt1" onchange="changeCategory(this.value)">
					<option>--请选择栏目--</option>
				</select>
			文章分类：<select name="category_id" class="form-control" id="opt2">
					<option>--请选择分类--</option>
				</select>
		
		</div><br>
		标题图片：
		<input type="file" name="myfile"><br><br>
		
		<p align="center">
			<button type="button" class="btn btn-primary" onclick="addArticle()">发布文章</button>
		</p>

	</form>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>