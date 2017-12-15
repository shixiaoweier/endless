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
		 	
		 	<h1>${username }您好，欢迎来到您的订单详情</h1>
			<table>
				<tr>
					<td>订单ID</td>
					<td>商品ID</td>
					<td>数量</td>
					<td>单价</td>
				</tr>
				
				<c:forEach items="${orderDetailList }" var="odl">
					<tr>
						<td>${odl.order.order_id}</td>
						<td>${odl.book_id}</td>
						<td>${odl.number }</td>
						<td>${odl.price }</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						总价：${pay}
					</td>
				</tr>
			</table>
		</div>
		<div ><%@ include file="right_content.jsp" %></div>
	</div>
	<div class="clear"></div>
	<div ><%@ include file="footer.jsp" %></div> 
</div>
</body>
</html>