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
	      <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>My account</div>
	      <div class="feat_prod_box_details">
	        <p class="details"> 阅读的最大理由是想摆脱平庸，早一天就多一份人生的精彩；迟一天就多一天平庸的困扰——余秋雨 </p>
	        <div class="contact_form">
	          <div class="form_subtitle">成功找回密码</div>
		 			<div style="color:red"> ${name}您好，您的密码为${p}</div>
	        </div>
	      </div>
	      <div class="clear"></div>
		</div>
		<div ><%@ include file="right_content.jsp" %></div>
	</div>
	<div class="clear"></div>
	<div ><%@ include file="footer.jsp" %></div> 
</div>
</body>
</html>