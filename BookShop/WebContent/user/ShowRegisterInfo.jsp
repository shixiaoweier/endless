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
      <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>注册</div>
      <div class="feat_prod_box_details">
        <p class="details">阅读的最大理由是想摆脱平庸，早一天就多一份人生的精彩；迟一天就多一天平庸的困扰——余秋雨</p>
        <div class="contact_form">
          <div class="form_subtitle">create new account</div>
          <form name="register" action="register.action" method="post" onsubmit="return checkForm();" enctype="multipart/form-data" >
            <div class="form_row">
	            	<div class="terms" style="color:red">注册成功：您的注册信息为：</div>
	            	<div class="terms" style="color:red">已发送邮件到您的邮箱，请登录您的邮箱进行激活！</div>
	        </div>
            <div class="form_row">
              <label class="contact"><strong>用户名:</strong></label>
              <input type="text" class="contact_input" id="userName" name="username" placeholder=${user.username }/>
            </div>
            <div class="form_row">
              <label class="contact"><strong>密码:</strong></label>
              <input type="password" class="contact_input" id="password" name="password" placeholder="${user.password }"/>
            </div>
            <div class="form_row">
              <label class="contact"><strong>电子邮箱:</strong></label>
              <input type="text" class="contact_input" id="email" name="email" placeholder="${user.email }"/>
            </div>
            <div class="form_row">
              <label class="contact"><strong>地址:</strong></label>
              <input type="text" class="contact_input" id="address" name="address" placeholder="${user.address }"/>
            </div>
            <div class="form_row">
              <label class="contact"><strong>头像:</strong></label>
              <img class="contact_input" alt="头像" src="${originalPath}" width="50px" hight="50px"/>
            </div>
            <div class="form_row">
              <div class="terms">
                <input type="checkbox" name="terms" />
              	  我以阅读并同意 <a href="#">相关条款 &amp; 协议</a> </div>
            </div>
            <div class="form_row">
              <a href="${path }/user/myaccount.jsp" name="ok" class="register" style="font-size:20px"/>请登录 </a>
            </div>
          </form>
        </div>
      </div>
      <div class="clear"></div>
    </div>
	</div>
		<div ><%@ include file="right_content.jsp" %></div>
	<div class="clear"></div>
	<div ><%@ include file="footer.jsp" %></div>
</div>
</body>
</html>