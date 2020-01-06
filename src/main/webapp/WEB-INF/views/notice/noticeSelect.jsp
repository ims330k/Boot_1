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

  <span>num : ${noticeVO.num}</span>
  <div class="form-group">
  <h3>title</h3>
    <input class="form-control" id="title" value="${noticeVO.title}" readonly="readonly">
  </div>
  
  <div class="form-group">
  <h3>writer</h3>
    <input class="form-control" id="writer" value="${noticeVO.writer}" readonly="readonly">
  </div>

 <div class="form-group">
  <h3>contents</h3>
    <div >
    ${noticeVO.contents}
    </div>
    </div>

<input type="button" class="btn btn-primary" value="수정" id="update">
<input type="button" class="btn btn-danger" value="삭제" id="del">
<input type="button" class="btn btn-warning" value="목록" id="list">
</div>
<script type="text/javascript">
$('#list').click(function(){
	location.href="./noticeList";
});
$('#update').click(function(){
	location.href="./noticeUpdate";
});
$('#del').click(function(){
	location.href="./noticeDelete";
});
</script>
</body>
</html>