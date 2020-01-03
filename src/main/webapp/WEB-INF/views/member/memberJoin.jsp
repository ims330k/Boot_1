<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>
<div class="container">
<h1>Join</h1>

<form:form action="memberJoin" modelAttribute="memberVO" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="id">id:</label>
    <form:input path="id" class="form-control" id="id"/>
    <form:errors path="id"/>
  </div>
  
  <div class="form-group">
    <label for="pwd">Password:</label>
    <form:password path="pw" class="form-control" id="pw"/>
    <form:errors path="pw"/>
  </div>
  
  <div class="form-group">
    <label for="pwd">Password2:</label>
    <form:password path="pw2" class="form-control" id="pw2"/>
    <form:errors path="pw2"/>
  </div>
  
  <div class="form-group">
    <label for="pwd">name:</label>
    <form:password path="name" class="form-control" id="name"/>
    <form:errors path="name"/>
  </div>
  
  <div class="form-group">
    <label for="pwd">email:</label>
    <form:password path="email" class="form-control" id="email"/>
    <form:errors path="email"/>
  </div>
  
  <div class="form-group">
    <label for="id">files:</label>
    <input type="file" class="form-control" id="files" name="file" placeholder="files">
  </div>
  
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
</form:form>
</div>

</body>
</html>