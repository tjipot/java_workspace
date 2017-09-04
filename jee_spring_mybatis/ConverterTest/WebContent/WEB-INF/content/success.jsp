<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Conversion Service Test</title>
</head>
<body>
	登录名: ${requestScope.user.loginname }<br>
	<!-- 这里发生了String到Date的转换, 
		 也因为此jsp和服务器(tomcat)和UserController同在一个运行空间中, requestScope传值也就不是问题 -->
	生日: <fmt:formatDate value="${requestScope.user.birthday}" pattern="yyyy年MM月dd日"/><br>
	<!-- 终端输出:
		 四月 12, 2017 8:36:51 下午 org.fkit.controller.UserController register
		 信息: User [loginname=jack, birthday=Fri Jan 01 00:00:00 CST 2016] -->
</body>
</html>