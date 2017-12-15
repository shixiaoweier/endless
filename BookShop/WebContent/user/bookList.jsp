 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/user/style.css" />
</head>
<body>
<div id="wrap">
	<div ><%@ include file="header.jsp" %></div>
	<div id="center_content">
		 <div class="left_content">
			<table>
				<tr>
					<td>书ID</td>
					<td>书名</td>
					<td>作者</td>
					<td>价格</td>
					<td>书的类别ID</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${booklist }" var="book">
					<tr>
						<td>${book.book_id }</td>
						<td>${book.book_name}</td>
						<td>${book.book_auth }</td>
						<td>${book.book_price }</td>
						<td>${book.bookType.type_id }</td>
						<td>
							<a href="addCart.action?book_id=${book.book_id}&&book_name=${book.book_name}&&price=${book.book_price}">添加购物车</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div ><%@ include file="right_content.jsp" %></div>
	</div>
	<div class="clear"></div>
	<div ><%@ include file="footer.jsp" %></div> 
</div>
</body>
</html>