<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.right{float: right;}
.left{float: left;}
.tableHead{font-weight: bold; font-size: 16px;}
</style>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>
<div class="container">

	<table class="table table-border">
		<tr class="tableHead">
			<td>NUM</td><td>TITLE</td><td>WRITER</td><td>DATE</td><td>HIT</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.num}</td>
				<td><a href="./noticeSelect?num=${vo.num}">${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td>${vo.regDate}</td>
				<td>${vo.hit}</td>
			</tr>
		</c:forEach>
	</table>
		
			<div class="form-group left">
				<select class="form-control" id="sel1" name="kind">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</div>
			<div class="input-group">
				<div>
					<input type="text" class="form-control" placeholder="Search" name="search" >
				</div>
				
			</div>
				
				<div class="left">
				<input type="button" class="btn btn-primary " value="search" style="display: inline-block;">
				</div>
		
		<ul class="pager">
			<li><a href="#">Prev</a></li>
			
			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><a>${i}</a></li>				
			</c:forEach>
			
			<li><a href="#">Next</a></li>
		</ul>
		<input type="button" class="btn btn-warning" value="write" id="write">
	</div>
	
	<script type="text/javascript">
	$('#write').click(function(){
		location.href="./noticeWrite";
		});
	</script>
</body>
</html>