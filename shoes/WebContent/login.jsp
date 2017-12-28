<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript">
	function check() {
		var username = document.getElementById("user_name").value;
		var password = document.getElementById("user_password").value;
		var checkcode = document.getElementById("user_code").value;
		if (user_name=="") {
			alert("用户名不能为空!");
		} else if(user_password==""){
			alert("密码不能为空!");
		}else if(user_code==""){
			alert("验证码不能为空!");
		}
	}
	function  reload() {
		var code=document.getElementById("code");
		code.src="ImageServlet?nocache="+new Date().getTime();
	}
</script>
</head>
<body>
<center><font size="5px" color="blue">登录</font></center>
	<form action="LoginServlet" method="post" onsubmit="return check()">
		<table align="center" valign="center" border="1px" bordercolor="wihte">	
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="user_name" name="user_name"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="user_password" name="user_password"/></td>
			</tr>
			<tr>
				<td>验证码：</td>
				<td><input type="text" id="user_code" name="user_code"/><img src="ImageServlet" id="code" onclick="reload()"></td>
			</tr>
			<tr align="center">
				<td><input type="submit" value="登录" bgcolor="#cccccc"/></td>
				<td><a href="regist.jsp">注册</a></td>
			</tr>
		</table>
	</form>
</body>
</html>