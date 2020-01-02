<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<form action="memberJoin" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="id">id:</label>
    <input type="text" class="form-control" id="id" name="id">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd" name="pw">
  </div>
  <div class="form-group">
    <label for="pwd2">Password2:</label>
    <input type="password" class="form-control" id="pwd2" >
  </div>
  <div class="form-group">
    <label for="name">name:</label>
    <input type="text" class="form-control" id="name" name="name" placeholder="name">
  </div>
  <div class="form-group">
    <label for="email">email:</label>
    <input type="text" class="form-control" id="email" name="email" placeholder="email">
  </div>
  <div class="form-group">
    <label for="id">files:</label>
    <input type="file" class="form-control" id="files" name="file" placeholder="files">
  </div>
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button type="submit" class="btn btn-default">Submit</button>
</form>
</div>

</body>
</html>