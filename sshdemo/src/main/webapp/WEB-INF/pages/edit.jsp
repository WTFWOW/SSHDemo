<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="studentEdit.do" method="post">
		<input type="hidden" value="${student.id}" name="id"></br>
		学生姓名:<input type="text" value="${student.name }" name="name"></br>
		学生年龄:<input type="text" value="${student.age }"/ name="age"></br>
		学生电话:<input type="text" value="${student.phoneNumber }" name="phoneNumber"></br>
		<input type="submit" value="修改">
	</form>
</body>
</html>