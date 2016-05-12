<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FANTASY</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		
		
		/* $('#save').click(function(){
			$('form').attr({
				action:"${pageContext.request.contextPath}/login/query",
				method:"post"
			});
			
			$('form').submit();
		}); */
		
		
		//$('#save').submit("",function(){});
		
		$('#save').click(function(){
			var username = $("#username").val();
			var password = $("#password").val();
			
			var user = {
				username : username,
				password : password
			};
			var userJson = JSON.stringify(user);
			$.ajax({
				type:"post",
				dataType : 'json',
                url:"${pageContext.request.contextPath}/login/query",  
                data:user,
                success:function(response,status,xhr){  
                    alert(response);  
                },
                error:function(e) {  
                    alert("出错："+e);  
                }  
			});
		});
	});
	
</script>
</head>
<body>
	
		用户名:<input type="text" name="username" id="username"></input> 
		密码:<input type="text" name="password" id="password"></input>
		<input type="button" value="测试" id="save" >
	

</body>
</html>