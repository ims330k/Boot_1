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
<form:form action="noticeWrite" modelAttribute="noticeVO" method="post" enctype="multipart/form-data" id="frm">
  <div class="form-group">
  <h3>title</h3>
    <form:input path="title" class="form-control" id="title"/>
    <form:errors path="title"/>
  </div>
  
  <div class="form-group">
  <h3>writer</h3>
    <form:input path="writer" class="form-control" id="writer"/>
    <form:errors path="writer"/>
  </div>
  
  <div class="form-group">
  <h3>contents</h3>
    <form:textarea path="contents" class="form-control" id="contents"/>
    <form:errors path="contents"/>
  </div>
  
<!--   <div class="form-group"> -->
<!--   <h3>files</h3> -->
<!--     <input type="file" class="form-control" id="files" name="file" placeholder="files"> -->
<!--   </div> -->
  
<input type="button" class="btn" value="add file" id="add">
  <div id="files" class="col-sm-12"></div>
  
  
<button class="btn btn-primary">submit</button>
</form:form>
</div>
  
<script type="text/javascript">
$('#contents').summernote({
    placeholder: 'write contents',
    height: 400
  });



</script>
<script type="text/javascript" src="../js/fileCount.js"></script>
</body>
</html>