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
	      <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>特色书</div>
	      <div class="feat_prod_box">
	        <div class="prod_img"><a href="details.htm"><img src="images/prod1.gif" alt="" title="" border="0" /></a></div>
	        <div class="prod_det_box">
	          <div class="box_top"></div>
	          <div class="box_center">
	            <div class="prod_title">我喜欢生命本来的样子</div>
	            <p class="details">阅读的最大理由是想摆脱平庸，早一天就多一份人生的精彩；迟一天就多一天平庸的困扰——余秋雨</p>
	            <a href="details.htm" class="more">-更多细节 -</a>
	            <div class="clear"></div>
	          </div>
	          <div class="box_bottom"></div>
	        </div>
	        <div class="clear"></div>
	      </div>
	      <div class="feat_prod_box">
	        <div class="prod_img"><a href="details.htm"><img src="images/prod2.gif" alt="" title="" border="0" /></a></div>
	        <div class="prod_det_box">
	          <div class="box_top"></div>
	          <div class="box_center">
	            <div class="prod_title">左胸第四根肋骨往里一寸的地方</div>
	            <p class="details">阅读的最大理由是想摆脱平庸，早一天就多一份人生的精彩；迟一天就多一天平庸的困扰——余秋雨</p>
	            <a href="details.htm" class="more">- 更多细节 -</a>
	            <div class="clear"></div>
	          </div>
	          <div class="box_bottom"></div>
	        </div>
	        <div class="clear"></div>
	      </div>
	      <div class="title"><span class="title_icon"><img src="images/bullet2.gif" alt="" title="" /></span>新书</div>
	      <div class="new_products">
	        <div class="new_prod_box"> <a href="details.htm">JAVA</a>
	          <div class="new_prod_bg"> <span class="new_icon"><img src="images/new_icon.gif" alt="" title="" /></span> <a href="details.htm"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a> </div>
	        </div>
	        <div class="new_prod_box"> <a href="details.htm">JAVAEE</a>
	          <div class="new_prod_bg"> <span class="new_icon"><img src="images/new_icon.gif" alt="" title="" /></span> <a href="details.htm"><img src="images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a> </div>
	        </div>
	        <div class="new_prod_box"> <a href="details.htm">JAVAC</a>
	          <div class="new_prod_bg"> <span class="new_icon"><img src="images/new_icon.gif" alt="" title="" /></span> <a href="details.htm"><img src="images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a> </div>
	        </div>
	      </div>
	      <div class="clear"></div>
    </div>
		<div ><%@ include file="right_content.jsp" %></div>
	<div class="clear"></div>
	<div ><%@ include file="footer.jsp" %></div>
</div>
</body>
</html>
