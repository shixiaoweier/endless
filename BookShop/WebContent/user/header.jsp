<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <div class="header">
    <div class="logo"><a href="index.htm"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>
    <c:set var="path" value="${pageContext.request.contextPath}"></c:set>
    <c:set var="path" value="${pageContext.request.contextPath}"></c:set>
    <div id="menu">
      <ul>
        <li class="selected"><a href="${path }/user/index.jsp">首页</a></li>
        <li><a href="${path }/user/about.jsp">关于我们</a></li>
        <li><a href="${path }/user/category.jsp">图书</a></li>
        <li><a href="${path }/user/booklist.action">图书列表</a></li>
        <li><a href="${path }/user/myaccount.jsp">登录</a></li>
        <li><a href="${path }/user/register.jsp">注册</a></li>
        <li><a href="${path }/user/cartList.jsp">购物车</a></li>
        <li><a href="${path }/user/contact.jsp">联系</a></li>
      </ul>
    </div>
  </div>