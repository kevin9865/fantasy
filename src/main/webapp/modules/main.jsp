<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "post",
			//dataType : 'json',
			//contentType : 'application/json',
			url : "${pageContext.request.contextPath}/mainAction/test",
			success : function(data, textStatus, jqXHR) {
				
				var username=data.data.username;
				$("#username").val(username);
			},
			error : function(data) {
				alert("error:" + data);
			}
		});
	});
</script>
</head>
<body>
${username}登陆成功<br/>
<input type="text" name="username" id="username">
</body>
</html>