<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/user/style.css" />
</head>
<script>
	function checkForm(){
		//用户名
		var username_=/[^\w]|[0-9a-zA-Z_]/;
		var username=document.getElementById("userName");
		//密码
		var password_=/[^\w]|[a-zA-Z_0-9]/;
		var password=document.getElementById("password");
		//电子邮箱
		var email_ = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;   
		var email=document.getElementById("email");
		//电话
		var telephone_=/^\d{11}$/;
		var telephone=document.getElementById("telephone");
		//地址
		var adress_=/[^\w]|[a-zA-Z_0-9]/;
		var adress=document.getElementById("adress");
		if(username==null || username.value==""){
			alert("用户名不能为空");
			return false;
		}else if(username.value.match(username_)==null){
			return false;
			alert("用户名格式不正确");
		} else if(username.value.length < 3 || username.value.length > 10){
	        alert("用户名最小不能3位，最大不能超过10位");
	         return false;
	     }else if(password == null || password.value == ""){
	         alert("密码不能为空");
	         return false;
	     }else if(password.value.match(password_) == null){
	         alert("您输入的密码与规定类型不匹配");
	         return false;
	      }else if(email.value.indexOf("@")<0){
	         alert("您输入的邮箱格式不正确");
	         return false;
	      }/* else if(telephone==null || telephone.value==""){
			return false;
			alert("电话不能为空");
		}else if(telephone.value.match(telephone_)==null){
			return false;
			alert("电话格式不正确");
		} */
		return true;
	}
	function checkpwd(){
		var p1=document.register.password.value;
		var p2=document.register.checkpassword.value;
		if(p1!=p2){
			document.getElementById("msg").innerHTML="两次输入密码不一致请，重新输入";
			return false;
		}else{
			document.getElementById("msg").innerHTML="确认密码成功";
		}
	}
</script>
<body>
<div id="wrap">
	<div ><%@ include file="header.jsp" %></div>
	<div id="center_content">
	<div class="left_content">
      <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>注册</div>
      <div class="feat_prod_box_details">
        <p class="details" font-colour="red">快来注册吧，注册后把你喜欢的书带回家~</p><br><p class="details">阅读的最大理由是想摆脱平庸，早一天就多一份人生的精彩；迟一天就多一天平庸的困扰——余秋雨</p>
        <div class="contact_form">
          <div class="form_subtitle">create new account</div>
          <form name="register" action="register.action" method="post" enctype="multipart/form-data" onsubmit="return checkForm();"  >
            <div class="form_row">
	            <c:if test="${message!=null }">
	            	<div class="terms" style="color:red">${message}</div>
	            </c:if>
	        </div>
            <div class="form_row">
              <label class="contact"><strong>用户名:</strong></label>
              <input type="text" class="contact_input" id="userName" name="username" placeholder="3-10位数字、字母、下划线"/>
            </div>
            <div class="form_row">
              <label class="contact"><strong>密码:</strong></label>
              <input type="password" class="contact_input" id="password" name="password" placeholder="6-15位数字、字母"/>
            </div>
             <div class="form_row">
              <label class="contact"><strong>确认密码:</strong></label>
              <input type="text" class="contact_input"  id="telephone" name="checkpassword" onchange="checkpwd()" placeholder="请输入确认密码"/><br>
              <div id="msg" style="color:red"></div>
            </div>
            <div class="form_row">
              <label class="contact"><strong>电子邮箱:</strong></label>
              <input type="text" class="contact_input" id="email" name="email" placeholder="请输入符合格式的邮箱"/>
            </div>
            <div class="form_row">
              <label class="contact"><strong>地址:</strong></label>
              <input type="text" class="contact_input" id="address" name="address" placeholder="可选填"/>
            </div>
            <div class="form_row">
              <label class="contact"><strong>上传头像:</strong></label>
              <input type="file" class="contact_input"  name="img" value="上传"/>
            </div>
            <div class="form_row">
              <div class="terms">
                <input type="checkbox" name="terms" />
              	  我以阅读并同意 <a href="#">相关条款 &amp; 协议</a> </div>
            </div>
            <div class="form_row">
              <input type="submit" name="ok" class="register" value="注册" />
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