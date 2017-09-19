<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ include file="/WEB-INF/pages/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<!-- BootStrap  core CSS -->
<link rel="stylesheet" href="${basePath}/resource/bootstrap.min.css" />
<script type="text/javascript">
	function update(obj){
		var tds=$(obj).parent().parent().find("td");
		$("#id").val(tds.eq(0).text());
		$("#name").val(tds.eq(1).text());
		$("#age").val(tds.eq(2).text());
		$("#phoneNumber").val(tds.eq(3).text());
		$("#myEdit").modal("show");
	}
</script>
</head>
<body>
	<table class="table table-hover">
		<tr>
			<td>学生id</td>
			<td>学生姓名</td>
			<td>学生年龄</td>
			<td>学生电话</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${student}" var="stu">
			<tr>
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.age}</td>
				<td>${stu.phoneNumber}</td>
				<td>
					<button type="button"  class="btn btn-primary" onclick="update(this)">
						修改
					</button>
					<a href="studentDel.do?id=${stu.id}">
						<input type="button" name="del" value="删除" class="btn btn-danger">
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<table class="table table-hover">
		<tr>
			<td align="center">共${page.totalRecords}条记录, 共${page.totalPages}页, 当前第${page.pageNo}页     <br> 
				<a href="login.html?pageNo=${page.topPageNo}">
					<input type="button" name="firstPage" value="首页" class="btn btn-info" />
				</a>	                   
				<c:choose>
					<c:when test="${page.pageNo!=1}">
						<a href="login.html?pageNo=${page.previousPageNo}">
							<input type="button" name="previousPage" value="上一页" class="btn btn-info" />
						</a>
					</c:when>
					<c:otherwise>
						<input type="button" disabled="disabled" name="previousPage" value="上一页" class="btn btn-info" />
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${page.pageNo!=page.totalPages}">
						<a href="login.html?pageNo=${page.nextPageNo}">
							<input type="button" name="nextPage"  value="下一页" class="btn btn-info" />
						</a>
					</c:when>
					<c:otherwise>
						<input type="button" disabled="disabled" name="nextPage" value="下一页" class="btn btn-info" />
					</c:otherwise>
				</c:choose>
				<a href="login.html?pageNo=${page.bottomPageNo}">
					<input type="button" name="lastPage" value="尾页"  class="btn btn-info" />
				</a>
			</td>
		</tr>
		<tr>
			<td style="text-align:center">
				<button type="button"  class="btn btn-success" data-toggle="modal" data-target="#myAdd">
					增加
				</button>
			</td>
		</tr>
	</table>
	
	<!-- 增加学生页面 -->
	<div class="modal fade" id="myAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">增加学生页面</h4>
	      </div>
	      <form action="studentAdd.do" method="post">
		      <div class="modal-body">     	
		        		<div class="form-group">
			        		<label>学生姓名</label>
							<input type="text" placeholder="学生姓名" name="name" class="form-control"/></br>
						</div>
						<div class="form-group">
							<label>学生年龄</label>
							<input type="text" placeholder="学生年龄" name="age" class="form-control"></br>
						</div>
						<div class="form-group">
							<label>学生电话</label>
							<input type="text" placeholder="学生电话" name="phoneNumber" class="form-control"></br>
						</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="submit" class="btn btn-primary" >增加学生</button>
		      </div>
	      </form>
	    </div>
	  </div>
	</div>	
	
	<!-- 修改学生页面 -->
	<div class="modal fade" id="myEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">修改学生界面</h4>
	      </div>
	      <form action="studentEdit.do" method="post">
	      <input id="id" type="hidden"  name="id"/>
	      <div class="modal-body">
	       		<div class="form-group">
	        		<label>学生姓名</label>
					<input id="name" name="name" class="form-control"/></br>
				</div>
				<div class="form-group">
					<label>学生年龄</label>
					<input id="age" name="age" class="form-control"></br>
				</div>
				<div class="form-group">
					<label>学生电话</label>
					<input id="phoneNumber" name="phoneNumber" class="form-control"></br>
				</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="submit" class="btn btn-primary">修改学生信息</button>
	      </div>
	      </form>	
	    </div>
	  </div>
	</div>
	
	
	
	
	
	<!-- Bootstrap core JavaScript -->
	<script src="${basePath}/resource/jquery-3.2.0.min.js"></script>
	<script src="${basePath}/resource/bootstrap.min.js"></script>
	
	
	
</body>
</html>