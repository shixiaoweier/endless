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
<script type="text/javascript">
function checkForm(){
    //判断登陆名
    var userName_ = /^[a-zA-Z_0-9]{3,10}$/;
    //判断密码
    var password_ = /^[a-zA-Z_0-9]{3,20}$/;
    //判断验证码
    var verification_ = /\d{4}/;
    
    //获得input对象
    var username = document.getElementById("userName");
    var password = document.getElementById("password");
    var verification = document.getElementById("verification");
    
     if(username == null || username.value == ""){
        alert("用户名不能为空");
         return false;
     }else if(username.value.match(userName_)==null){
        alert("用户名不正确");
        return false;
     } else if(password == null || password.value == ""){
        alert("密码不能为空");
         return false;
     }else if(password.value.match(password_) == null){
        alert("密码不正确");
        return false;
     }else if(verification == null || verification.value == ""){
        alert("请填写验证码");
         return false; 
     } else if(verification.value.match(verification_) == null){
        alert("验证码不正确");
        return false;
     }
     return true;
}
</script>
<div id="wrap">
	<div ><%@ include file="header.jsp" %></div>
	<div id="center_content">
		 <div class="left_content">
	      <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>My account</div>
	      <div class="feat_prod_box_details">
	        <p class="details"> 阅读的最大理由是想摆脱平庸，早一天就多一份人生的精彩；迟一天就多一天平庸的困扰——余秋雨 </p>
	        <div class="contact_form">
	          <div class="form_subtitle">请登录我的账户</div>
	          <form name="register" action="login.action"   method="post" onsubmit="return checkForm();">
	            <div class="form_row">
	            <c:if test="${message!=null }">
	            	<div class="terms">${message}</div>
	            </c:if>
	            <c:if test="${msg!=null }">
	            	<div class="terms">${msg}</div>
	            </c:if>
	              <label class="contact"><strong>用户名:</strong></label>
	              <input type="text" class="contact_input" name="username" id="userName" placehoder="用户名/邮箱/手机号码"  />
	            </div>
	            <div class="form_row">
	              <label class="contact"><strong>密码:</strong></label>
	              <input type="password" class="contact_input" name="password" id="password" />
	            </div>
	            <div class="form_row">
		              <label class="contact"><strong>验证码:</strong></label>
		              <input type="text" class="contact_input" name="verification" id="verification" />
		              <div class="terms"><img alt="" src="${pageContext.request.contextPath}/common/yanzhengma.jsp" />
		              </div>
		        </div>
	            <div class="form_row">
	              <div class="terms">
	                <input type="checkbox" name="terms" /> 记住我
	                <a href="findPassword.jsp">找回密码</a>
	              </div>
	            </div>
	            <div class="form_row">
	              <input type="submit" class="register" value="登录" />
	            </div>
	          </form>
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