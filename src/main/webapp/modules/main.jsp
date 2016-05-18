<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bs-menu.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "post",
			//dataType : 'json',
			//contentType : 'application/json',
			url : "${pageContext.request.contextPath}/mainAction/initMenu",
			success : function(data, textStatus, jqXHR) {

				var menu = data.menu;
				$("#menuUL").append(menu);
			},
			error : function(data) {
				alert("error:" + data);
			}
		});
		
		$("#out").click(function(){
			$('#outForm').attr({
				action:"${pageContext.request.contextPath}/mainAction/logout",
				method:"post"
			});
			
			$('#outForm').submit();
		});
	});
</script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav" id="menuUL">
				<!-- <li class="active"><a href="#">Home</a></li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#"> 系统功能<span class="caret"></span></a>
					<ul class="bs-menu dropdown-menu">
						<li class="dropdown-submenu"><a href="#"> 用户管理 </a>
							<ul class="bs-submenu dropdown-menu">
								<li><a href="#">用户查询</a></li>
								<li><a href="#">用户添加</a></li>
							</ul>
						</li>
						<li><a href="#">角色管理</a></li>
						<li><a href="#">功能管理</a></li>
					</ul>
				</li>
				 -->
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">${username}</a></li>
				
				<li>
					<form class="navbar-form navbar-right" role="search">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="请输入关键字">
							<span class="input-group-btn">
								<button class="btn btn-default" type="button">Go!</button>
							</span>
						</div>
					</form>
				</li>
				<li>
					<form id="outForm"></form>
					<a href="#" id="out">退出</a>
				</li>
			</ul>

		</div>
	</div>
	</nav>


</body>
</html>