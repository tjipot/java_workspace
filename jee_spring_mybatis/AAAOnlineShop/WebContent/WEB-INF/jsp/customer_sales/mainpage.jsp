<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%
	// session在JSP(HttpSession,与容器)中是自动包含的;
	Date sessionCreateTime = new Date(session.getCreationTime());
	Date lastAccessTime = new Date(session.getLastAccessedTime());
	
	String title = "";
	Integer visitCount = new Integer(0);
	String visitCountKey = new String("VisitCount");
	String userSessionId = new String("userID");
	String userId = new String("user_abc");
	
	if(session.isNew()) {
		title = "Welcome New Comer!";
		session.setAttribute(userSessionId, userId);	// key-value;
		session.setAttribute(visitCountKey, visitCount);
	}else{
		visitCount = (Integer) session.getAttribute(visitCountKey);
		visitCount++;
		userId = (String)session.getAttribute(userSessionId);
		session.setAttribute(visitCountKey, visitCount);
	}
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sales Item Page</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
</head>



<body>

	<div id="container" style="width:80%">

		<!-- 每个页面都有的头部TOP_DIV -->
		<div id="header" style="background-color:#99C2FF;height:50px;"><!-- color:#e5f0ff -->
			<h1 style="margin-bottom:0;">Online Shop</h1>
			<p align="right">
				<a href="http://www.baidu.com">购物车</a>
				&nbsp;/&nbsp;
				<a href="http://www.baidu.com">登录</a>
				&nbsp;-&nbsp;
				<a href="http://www.163.com">注册</a>
			</p>
		</div>

		<div id="menu" style="background-color:#e5f0ff;height:700px;width:100px;float:left;"></div>

		<!-- 中部区域:数据展示 -->
		<table width="82%" border="5" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
			<tr class="main_trbg_tit" align="center">
				<td>编号</td>
				<td>商品名</td>
				<td>分类</td>
				<td>描述</td>
				<td>库存数量</td>
				<td>价格</td>
				<td>重量</td>
				<td>添加商品</td>
			</tr>
			
			<c:forEach items="${requestScope.salesItems}" var="sales_item" varStatus="stat">
				<tr id="data_${stat.index}" class="main_trbg" align="center">
					<td>${sales_item.item_id }</td>
					<td>${sales_item.item_name}</td>
					<td>${sales_item.item_category}</td>
					<td>${sales_item.item_description}</td>
					<td>${sales_item.item_amount}</td>
					<td>${sales_item.item_price}</td>
					<td>${sales_item.item_weight}</td>
					<!-- '添加'逻辑应该是存储到session中, 并不需要页面跳转 -->
<%-- 					<td><a href="${ctx}/employee/updateEmployee?flag=1&id=${employee.id}">添加</a></td> --%>
					<!-- "ctx"="${pageContext.request.contextPath}":交由SpringMVC的@Controller处理  -->
					<td><% out.println((String) session.getAttribute(userSessionId)); %></td>
				</tr>
			</c:forEach><!-- foreach结束 -->
		</table>
	
		<p><a href="${ctx}/sessiontest">sessiontest</a></p>
	
		<!-- 每个页面都有的底部BOTTOM_DIV -->		
		<div id="footer" style="background-color:#99C2FF;height:40px;clear:both;text-alogn:center;">Copyright © UNIVESRE</div>
	
	</div>
</body>
</html>