<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>

<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/js/jquery.validate.js"></script>
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="/resource/css/index.css">
<link rel="stylesheet" type="text/css" href="/resource/css/bootstrap.css" />
<script type="text/javascript">
	function register(){
		var username=$("#username").val();
		var password=$("#password").val();
		var checkpwd=$("#checkpwd").val();
		//验证非空
		if(username==null || password==null || checkpwd==null || username=='' || password=='' || checkpwd==''){
			$("#alert").html("均不能为空");
			$("#alert").show();
		}
			//验证两次密码输入一致
			if(password!=checkpwd){
				$("#alert").html("两次密码输入必须一致");
				$("#alert").show();
			}
				//去注册
				$.post("/user/reg",$("#registerForm").serialize(),function(json){
					alert(json.msg)
					if(json.msg=="true"){
						$("#alert").hide();
						location.href="/user/login";
					}else{
						$("#alert").html(json.msg);
						$("#alert").show();
					}
				},"json");
	}
</script>
</head>
<body>
	<!-- 头部导航 -->
	<jsp:include page="/WEB-INF/view/index/top.jsp"></jsp:include>
	
	<div class="container-fluid" style="margin-top: 6px;">
		<div class="row offset-4" style="margin-top: 180px;">
			<div class="col-4">
				<h1>欢迎回来</h1>
				<div class="alert alert-success" id="alert" role="alert" style="display: none"></div>
				<form id="registerForm">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入用户名" id="username" name="username">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="请输入密码" id="password" name="password">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="请确认密码" id="checkpwd" name="checkpwd">
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="role"
							id="exampleRadios1" value="0" checked> <label
							class="form-check-label" for="exampleRadios1"> 用户 </label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="form-check-input" type="radio" name="role"
							id="exampleRadios2" value="1"> <label
							class="form-check-label" for="exampleRadios2"> 管理员</label>
					</div>
					<div class="row">
						<div class="col-4">
							<button type="button" class="btn btn-primary" onclick="register();">注册</button>
						</div>
						<div class="col-8">
							<small id="emailHelp" class="form-text text-muted">已有帐号，去<a href="/user/login">登录</a></small>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	
</body>
</html>