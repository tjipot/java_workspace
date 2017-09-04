<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Shopping Cart</title>
</head>
<body>
	
	<!-- 中部区域:数据展示 -->
	<table width="82%" border="5" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		
		<tr><th><h1>Your Purchases</h1></th><th></th></tr>
		
		<tr class="main_trbg_tit" align="center">
		<th>Cart Item Id</th>
		<th>Count</th>
		</tr>

		<c:forEach items="${requestScope.cartItems}" var="items_in_cart">	<!-- shit,field写错弄半天 -->				
		<tr class="main_trbg" align="center">	
		<td><c:out value="${items_in_cart.key}"></c:out></td>
		<td><c:out value="${items_in_cart.value}"></c:out></td>
		</tr>
		</c:forEach>
	
		<tr><td></td><td><button onClick="payOrder()">Pay</button></td></tr>
	
	</table>
	
	<%Enumeration<String> enu = request.getParameterNames();
	while(enu.hasMoreElements()) { String itemId = (String) enu.nextElement(); }
	StringBuffer sb = request.getRequestURL(); String url = sb.toString(); System.out.println(url);%>
	<!-- <h1><%=url %></h1> --><!-- http://localhost:8080/AAAOnlineShop/WEB-INF/jsp/customer_sales/shoppingcart.jsp -->

</body>
</html>
