<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/user/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/style/style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<center>
	<table  border="1" width="80%" cellpadding="0" cellspacing="0">
		<tr>
			<td height="27px" style="border-color: #F6F6F6;">书ID</td>
			<td style="border-color: #F6F6F6;">书名</td>
			<td style="border-color: #F6F6F6;">作者</td>
			<td style="border-color: #F6F6F6;">价格</td>
			<td style="border-color: #F6F6F6;">书的类别ID</td>
			<td style="border-color: #F6F6F6;">操作</td>
		</tr>
		<c:forEach items="${booklist}" var="book">
			<tr>
				<td height="27px" style="border-color: #F6F6F6;">${book.book_id }</td>
				<td height="27px" style="border-color: #F6F6F6;">${book.book_name}</td>
				<td height="27px" style="border-color: #F6F6F6;">${book.book_auth }</td>
				<td height="27px" style="border-color: #F6F6F6;">${book.book_price }</td>
				<td height="27px" style="border-color: #F6F6F6;">${book.bookType.type_id }</td>
				<td height="27px" style="border-color: #F6F6F6;">
						<a href="admin_deleteBook.action?book_id=${book.book_id }">删除</a>||<a href="updateBook.action?book_id=${book.book_id}">修改</a>
				</td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>