<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="${pageContext.request.contextPath}/notice/noticeList">notice</a></li>
      <li><a href="#">Page 2</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    
     <c:if test="${not empty sessionScope.member}">
    	 <li><a href="${pageContext.request.contextPath}/member/mypage"><span class="glyphicon glyphicon-user"></span> Mypage</a></li>
     	 <li><a href="${pageContext.request.contextPath}/member/memberLogOut"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
     </c:if>
     <c:if test="${empty sessionScope.member}">
     	 <li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     	 <li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
     </c:if>
    </ul>
  </div>
</nav>