<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
 <body>
  	
  	<table border="1">
  		<tr>
  			<td>年级</td>
  			<td>专业</td>
  			<td>专业人数</td>
  			<td>课程名称</td>
  			<td>选修类型</td>
  			<td>学分</td>
  			<td>学时</td>
  			<td>实验</td>
  			<td>上机</td>
  			<td>起讫周序</td>
  			<td>任课教师</td>
  			<td>备注</td>
  			<td></td>
  		</tr>
  		
  		<c:forEach items="${list}" var="stu">
  			<tr>
  				<td>${stu.nianji }</td>
  				<td>${stu.zhuanye }</td>
  				<td>${stu.renshu }</td>
  				<td>${stu.mingcheng }</td>
  				<td>${stu.leixing }</td>
  				<td>${stu.xuefen }</td>
  				<td>${stu.xueshi }</td>
  				<td>${stu.shiyanxueshi }</td>
  				<td>${stu.shangjixueshi }</td>
  				<td>${stu.zhouxu }</td>
  				<td>${stu.jiaoshi }</td>
  				<td>${stu.beizhu }</td>
  			</tr>
  		</c:forEach>
  	</table>
  	
  	
  </body>
</html>
