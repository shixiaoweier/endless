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
		 	<h1>${username }您好，欢迎查看您的订单</h1>
		 	<c:if test="${msg!=null }">
	            	<div class="terms">${msg}</div>
	        </c:if>
			<table>
				<tr>
					<td>订单ID</td>																																			
					<td>用户ID</td>
					<td>订单状态</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${orderlist }" var="order">
					<tr>
						<td>${order.order_id}</td>
						<td>${order.user.id}</td>
						<td>${order.order_state }</td>
						<td>
							<a href="getOrderDetail.action?order_id=${order.order_id }">查看订单详情</a>
							||<a href="cancleOrder.action?order_id=${order.order_id }">取消订单</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="form_row">
					<a href="cleanOrder.action">删除所有订单</a>
	         </div>
		</div>
		<div ><%@ include file="right_content.jsp" %></div>
	</div>
	<div class="clear"></div>
	<div ><%@ include file="footer.jsp" %></div> 
</div>
</body>
</html>