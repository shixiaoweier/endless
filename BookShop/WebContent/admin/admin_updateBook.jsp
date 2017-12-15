<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/user/taglib.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>更新图书信息</title>
<link href="${pageContext.request.contextPath}/style/style.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
<center><br />
<form action="admin_updateBook.action" name="addform" id="addform"
	method="post"><br />
<br />
<table border="0">
	<tr>
		<td>图书名称</td>
		<td><input type="hidden" name="book_id" id="id" value="${book.book_id}" />
		<input type="text" name="book_name" id="product"
			value="${book.book_name}" /></td>
	</tr>
	<tr>
		<td>图书价格</td>
		<td><input type="text" name="book_price" id="price"
			value="${book.book_price }" /></td>
	</tr>
	
	<tr>
		<td>图书作者</td>
		<td><input type="text" name="book_auth" id="author"
			value="${book.book_auth}" /></td>
	</tr>	
	<tr>
		<td>图书类型ID</td>
		<td><input type="text" name="type_id" id="publisher"
		 value="${book.bookType.type_id}"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" name="bt1" id="bt1" value="提交" />
		 <input type="reset" name="bt2" id="bt2" value="重置" /> <input type="button"
			name="button" value="返回产品列表"
			onclick="javascript:document.location='admin_booklist.action'" />
		</td>
	</tr>
</table>
</form>

</center>
</body>
</html>