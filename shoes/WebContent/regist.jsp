<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><font size="5px" color="blue">注册</font></center>
	<form action="RegistServlet" method="post">
		<table align="center" valign="center" border="1px" bordercolor="wihte">	
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="user_name" name="user_name"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="user_password" name="user_password"/></td>
			</tr>
			<tr align="center">
				<td colspan="2" ><input type="submit" value="注册" bgcolor="#cccccc"/></td>
			</tr>
		</table>
	</form>
</body>
</html>