<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<!-- 数据展示 -->
	<table width="80%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		<tr class="main_trbg_tit" align="center">
			<td>编号</td>
			<td>商品名</td>
			<td>分类</td>
			<td>描述</td>
			<td>库存数量</td>
			<td>价格</td>
			<td>重量</td> 
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
<!-- 			<td>Hello</td> -->
		</tr>
		</c:forEach><!-- foreach结束 -->
	</table>
	
</body>
</html>