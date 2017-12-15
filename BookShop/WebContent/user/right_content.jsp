<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="right_content">
      <div class="languages_box"> <span class="red">快来购物吧！</span> <a href="login.jsp" class="selected">登录</a> <a href="register.jsp">注册</a> <a href="getOrder.action">我的订单</a> </div>
      <div class="cart">
        <div class="title"><a href="getMyCart.action"><span class="title_icon"><img src="${pageContext.request.contextPath }/user/images/cart.gif" alt="" title="" /></span>我的购物车</a></div>
        <div class="home_cart_content"> 3 x items | <span class="red">TOTAL: 100$</span> </div>
        <a href="cart.htm" class="view_cart">view cart</a> </div>
      <div class="title"><span class="title_icon"><img src="${pageContext.request.contextPath }/user/images/bullet3.gif" alt="" title="" /></span>About Our Store</div>
      <div class="about">
      	<p>
        	<img src="${pageContext.request.contextPath }images/about.gif"  class="right" />
        	
			<form name="search" action="search.action"   method="post" >
	            <div class="form_row">
	              <div>请输入：热门商品/最新商品/类别的ID/商品的ID </div> 
	              <input type="text" class="contact" name="search"  />
	              <input type="submit" value="搜索" />
	            </div>
	        </form>	
	        
	     </p>  
      </div>
      <div class="right_box">
        <div class="title"><span class="title_icon"><img src="${pageContext.request.contextPath }/user/images/bullet4.gif" alt="" title="" /></span>Promotions</div>
        <div class="new_prod_box"> <a href="details.htm">product name</a>
          <div class="new_prod_bg"> <span class="new_icon"><img src="${pageContext.request.contextPath }/user/images/promo_icon.gif" alt="" title="" /></span> <a href="details.htm"><img src="${pageContext.request.contextPath }/user/images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a> </div>
        </div>
        <div class="new_prod_box"> <a href="details.htm">product name</a>
          <div class="new_prod_bg"> <span class="new_icon"><img src="${pageContext.request.contextPath }/user/images/promo_icon.gif" alt="" title="" /></span> <a href="details.htm"><img src="${pageContext.request.contextPath }/user/images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a> </div>
        </div>
        <div class="new_prod_box"> <a href="details.htm">product name</a>
          <div class="new_prod_bg"> <span class="new_icon"><img src="${pageContext.request.contextPath }/user/images/promo_icon.gif" alt="" title="" /></span> <a href="details.htm"><img src="${pageContext.request.contextPath }/user/images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a> </div>
        </div>
      </div>
      <div class="right_box">
        <div class="title"><span class="title_icon"><img src="${pageContext.request.contextPath }/user/images/bullet5.gif" alt="" title="" /></span>分类</div>
        <ul class="list">
          <li><a href="#">饰品</a></li>
          <li><a href="#">书籍礼物</a></li>
          <li><a href="#">特价</a></li>
          <li><a href="#">假期 gifts</a></li>
          <li><a href="#">饰品</a></li>
          <li><a href="#">书籍礼物</a></li>
          <li><a href="#">特价</a></li>
          <li><a href="#">假期</a></li>
          <li><a href="#">饰品</a></li>
          <li><a href="#">书籍礼物</a></li>
          <li><a href="#">特价</a></li>
        </ul>
        <div class="title"><span class="title_icon"><img src="${pageContext.request.contextPath }/user/images/bullet6.gif" alt="" title="" /></span>伙伴</div>
        <ul class="list">
          <li><a href="#">accesories</a></li>
          <li><a href="#">books gifts</a></li>
          <li><a href="#">specials</a></li>
          <li><a href="#">hollidays gifts</a></li>
          <li><a href="#">accesories</a></li>
          <li><a href="#">books gifts</a></li>
          <li><a href="#">specials</a></li>
          <li><a href="#">hollidays gifts</a></li>
          <li><a href="#">accesories</a></li>
        </ul>
      </div>
    </div>