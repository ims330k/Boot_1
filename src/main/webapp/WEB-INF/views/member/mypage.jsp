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
<h2>my page</h2>
<table class="table border-table">
<tr><td>id</td><td>${sessionScope.member.id}</td></tr>
<tr><td>pw</td><td>${sessionScope.member.pw}</td></tr>
<tr><td>name</td><td>${sessionScope.member.name}</td></tr>
<tr><td>email</td><td>${sessionScope.member.email}</td></tr>
<tr>
	<td><img src="../upload/${memberFile.oname}"></td>
	<td><br><br><br><br><br><br><br><a class="btn btn-primary" href="./memberFileDown?fnum=${memberFile.fnum}">fileDown</a></td>
</tr>
</table>
</div>
</body>
</html>