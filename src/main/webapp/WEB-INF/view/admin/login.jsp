<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title></title>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/js/jquery.validate.js"></script>
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="/resource/css/index.css">
<link rel="stylesheet" type="text/css" href="/resource/css/bootstrap.css" />
<script type="text/javascript">
	function login(){
		//登录之前  先验证非空
		//获得用户输入的用户名和密码
		var username=$("#username").val();
		var password=$("#password").val();
		if(username=='' || password==''){
			$("#alert").html("用户名或密码不能为空");
			$("#alert").show();
			return;
		} 
		//如果验证通过 去登陆
		$.post("/login",$("#loginForm").serialize(),function(json){
			alert(json.msg)
			if(json.msg=="true"){//登录成功
				//跳转到主页面
				
				$("#alert").hide();
				location.href="/admin";
			}else{
				$("#alert").html(json.msg);
				$("#alert").show();
			}
		},"json")
	}
	
</script>
</head>
<body>
	<!-- 头部导航 -->
	<jsp:include page="/WEB-INF/view/index/top.jsp"></jsp:include>
	<div class="container-fulid" style="margin-top: 6px;">
		<div class="row offset-4" style="margin-top: 180px;">
			<div class="col-5">
				<h1>欢迎回来</h1>
				<h3 style="color: red">${error}</h3>
				 <div class="alert alert-success" id="alert" role="alert" style="display: none"></div>
				<form id="loginForm">
					<div class="form-group">
						<input type="email" class="form-control" id="username"
							name="username" placeholder="请输入用户名">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="请输入密码"
							id="password" name="password">
					</div>
					
					<div class="row">
						<div class="col-4">
							<button type="button" class="btn btn-primary" onclick="login();">登录</button>
						</div>
						<div class="col-8">
							<small id="emailHelp" class="form-text text-muted">没有帐号，去<a
								href="/user/reg">注册</a></small>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>