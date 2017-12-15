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
		 <h1>${username }您好，欢迎来到您的购物车</h1>
		 	<c:if test="${msg!=null }">
	            	<div class="terms">${msg}</div>
	        </c:if>
			<table>
				<tr>
					<td></td>
					<td>用户ID</td>
					<td>书ID</td>
					<td>书名</td>
					<td>数量</td>
					<td>单价</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${cartlist }" var="cart">
					<tr>
						<td><input type="checkbox"></td>
						<td>${cart.user_id }</td>
						<td>${cart.book_id}</td>
						<td>${cart.book_name}</td>
						<td>${cart.number }</td>
						<td>${cart.price }</td>
						<td>
							<a href="deleteCartBook.action?book_id=${cart.book_id}">删除商品</a>
						</td>
					</tr>
				</c:forEach>
				
				<div class="form_row">
					<a href="booklist.action" class="register">继续添加</a>
					 || <a href="creatOrder.action?user_id=${cart.user.id}" class="register">生成订单</a>
					 || <a href="cleanCart.action?user_id=${cart.user.id}" class="register">清空购物车</a>
	            </div>
			</table>
		</div>
		<div ><%@ include file="right_content.jsp" %></div>
	</div>
	<div class="clear"></div>
	<div ><%@ include file="footer.jsp" %></div> 
</div>
</body>
</html>