<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FANTASY</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.json-2.4.js"></script>
<script type="text/javascript">
	$(function() {
		//$('#unLab').html("1245");
		$('#subForm').click(function(){
			$('form').attr({
				action:"${pageContext.request.contextPath}/login/loginCheck",
				method:"post"
			});
			
			$('form').submit();
		});

		//$('#save').submit("",function(){});
		$('#subAjax').click(function() {
			//var username = $("#username").val();
			//var password = $("#password").val();

			//var user = {
			//	username : username,
			//	password : password
			//};
			
			var userForm = $("#loginForm").serializeArray()
			
			$.ajax({
				type : "post",
				//dataType : 'json',
				//contentType : 'application/json',
				url : "${pageContext.request.contextPath}/login/query",
				data : userForm,
				success : function(data, textStatus, jqXHR) {
					//alert("成功"+data+","+textStatus+","+jqXHR.responseText);
					//$.each(data.data, function(i, item) {
					//	alert("i=" + i + ",username=" + item.username+",password"+item.password);
					//});
					if(data.flag=="0"){
						$('#unLab').html(data.data.error);
					}else{
						$('form').attr({
							action:"${pageContext.request.contextPath}/main/initMenu",
							method:"post"
						});
						
						$('form').submit();
					}
				},
				error : function(data) {
					alert("error:" + data);
				}
			});
		});
	});
	
</script>
</head>
<body>
	<form id="loginForm">
		用户名:<input type="text" name="username" id="username"></input><br/>
		密码:<input type="text" name="password" id="password"></input><br/>
		<label id="unLab"></label><br/>
		<input type="button" value="ajax提交" id="subAjax">
		<input type="button" value="form提交" id="subForm">
	</form>

</body>
</html>