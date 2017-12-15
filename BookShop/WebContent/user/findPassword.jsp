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
    //判断邮箱
   var email_ = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;   
    
    //获得input对象
    var username = document.getElementById("username");
    var email = document.getElementById("email");
    
     if(username == null || username.value == ""){
        alert("用户名不能为空");
         return false;
     }else if(email == null || password.value == ""){
        alert("邮箱不能为空");
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
	          <div class="form_subtitle">请找回您的密码</div>
	          <form name="register" action="findPassword.action" method="post" >
	            <div class="form_row">
	            <c:if test="${message!=null }">
	            	<div class="terms">${message}</div>
	            </c:if>
	              <label class="contact"><strong>用户名:</strong></label>
	              <input type="text" class="contact_input" name="username" id="username" placehoder="用户名/邮箱/手机号码"  />
	            </div>
	            <div class="form_row">
	              <label class="contact"><strong>您的有效邮箱:</strong></label>
	              <input type="text" class="contact_input" name="email" id="email" />
	            </div>
	            <div class="form_row">
	              <input type="submit" class="register" value="找回密码" />
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