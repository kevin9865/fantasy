<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FANTASY</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		$('form').submit(function() {
			var username = $("#username").val();
			var password = $("#password").val();

			var user = {
				username : username,
				password : password
			};
			var aMenu = JSON.stringify(user);

			$.ajax({
				type : "post",
				url : "login/query",
				data : "orderJson=" + aMenu
			});
		});
		
	});
</script>
</head>


<body>
	<form>
	用户名:<input type="text" id="username"></input> 
	密码:<input type="text" id="password"></input>
	<button type="button" id="save">提交</button>
	<input type="submit" value="测试">
	</form>
	<form action="${pageContext.request.contextPath}/login/query" method="post">
		<input type="submit" value="测试1">
	</form>
</body>
</html>