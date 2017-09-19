<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath="";
 
if(request.getServerPort()==80){
	basePath=request.getScheme()+"://"+request.getServerName()+path;
}else{
	basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
}
pageContext.setAttribute("basePath",basePath );
%>