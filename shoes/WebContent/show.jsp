<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<title>商品信息</title>
</head>
<body>
	<table align="center">
		<tr>
			<th>ID</th>
			<th>SIZE</th>
			<th>TYPE</th>
			<th>PRICE</th>
		</tr>
		<c:forEach items="${LIST }" var="shoe" varStatus="id">
			<tr>
				<td>${shoe.shoe_id }</td>
				<td>${shoe.shoe_size }</td>
				<td>${shoe.shoe_type}</td>
				<td>${shoe.shoe_price}</td>
			</tr>
		</c:forEach>
	</table>
	<center>${BAR}</center>
</body>
</html>