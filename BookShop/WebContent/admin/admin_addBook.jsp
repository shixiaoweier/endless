<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../style/style.css" rel="stylesheet" type="text/css" />
<title>addProduct</title>

<script type="text/javascript" language="javascript">
function addbt(){
  if(document.getElementById("product").value==""){
   		alert("商品名称不能为空！");
   		document.getElementById("product").focus();
   }else if(document.getElementById("price").value==""){
   		alert("商品价格不能为空！");
   		document.getElementById("price").focus();
   }else{ document.addform.submit();}
    }
   
</script>	

</head>
<body>

<center>
<form action="admin_addBook.action" name="addform" id="addform"
	method="post" ><br />
<br />
<table border="0">
	<tr>
		<td>商品名称</td>
		<td><input type="text" name="book_name" id="product" /></td>
	</tr>
	<tr>
		<td>商品价格</td>
		<td><input type="text" name="book_price" id="price" value=""/></td>
	</tr>
	<tr>
		<td>所属类别</td>
		<td><input type="text" name="type_id" id="type" value=""/></td>
	</tr>
	<tr>
		<td>作者</td>
		<td><input type="text" name="book_auth" id="author" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="button" name="bt1" id="bt1" value="添加商品"
			onclick="addbt();" /> <input type="reset" name="bt2" id="bt2"
			value="重置" /> 
		</td>
	</tr>

</table>
</form>
</center>

</body>
</html>