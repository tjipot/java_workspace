<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%
	Date createTime = new Date(session.getCreationTime());
	Date lastAccessTime = new Date(session.getLastAccessedTime());
	HashMap<Integer, Integer> test = new HashMap<Integer, Integer>();
	String msg = "", msg1 = "welcome new comer", msg2 = "welcome old comer";
	int tmp;
	
	test.put(1, 3);
	tmp = test.get(1);
	
	if(session.isNew()) {
		session.setAttribute("Key1", "Haoran1"); msg = msg1; test.put(1, 1);
	}else{
		msg = msg2; tmp = test.get(1); test.put(1, tmp+1);
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SessionTest</title>
</head>

<body>

	<div id="container" style="width:80%">
		
		<!-- 每个页面都有的头部TOP_DIV -->
		<div id="header" style="background-color:#99C2FF;height:50px;"><!-- color:#e5f0ff -->
			<h1 style="margin-bottom:0;">Online Shop</h1>
			<p align="right">
				<a href="${ctx}/shoppingcart">购物车</a>
				&nbsp;/&nbsp;
				<a href="http://www.baidu.com">登录</a>
				&nbsp;-&nbsp;
				<a href="http://www.163.com">注册</a>
			</p>
		</div>
	
		<div id="menu" style="background-color:#e5f0ff;height:700px;width:100px;float:left;"></div>
	
		<!-- 中部区域:数据展示 -->
		<table id="salesTable" width="82%" border="5" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
			<tr class="main_trbg_tit" align="center">
				<td>编号</td>
				<td>商品名</td>
				<td>分类</td>
				<td>描述</td>
				<td>库存数量</td>
				<td>价格</td>
				<td>重量</td>
				<td>添加商品</td>
				<td>Count</td>
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
<%-- 					<td><% out.println((String) session.getAttribute(userSessionId)); %></td> --%>
				<td><button onClick="add(${stat.index})">Add</button></td>
				<td id="demo_${stat.index}" name="demo_${stat.index}">0</td>
			</tr>
			</c:forEach><!-- foreach结束 -->
			
			<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
			<td><button onClick="toShoppingCart()">MyCart</button></td><td></td>
		</table>
	
		<script>
		function toShoppingCart(){
			var table = document.getElementById("salesTable");
			var rowsNum = table.rows.length - 1;
			var refLink = "http://localhost:8080/AAAOnlineShop/shoppingcart?";
			for(var i = 0; i <= parseInt(rowsNum)-2; i++) {
				var tmpId = "demo_" + i;
				if(i != 7) {
					refLink = refLink + tmpId + "=" + document.getElementById(tmpId).innerHTML + "&";	
				}else{
					refLink = refLink + tmpId + "=" + document.getElementById(tmpId).innerHTML;
				}
			}
			/* alert(refLink); */
			window.location.href=refLink;
		}
	
		function add(arg1){
			var count1 = parseInt(document.getElementById("demo_"+arg1).innerHTML);
			count1 = count1 + 1;
			document.getElementById("demo_"+arg1).innerHTML=count1;
		}
		</script>
	
	<%-- 		<p><a href="${ctx}/sessiontest">sessiontest</a></p> --%>
	
		<!-- 每个页面都有的底部BOTTOM_DIV -->		
		<div id="footer" style="background-color:#99C2FF;height:40px;clear:both;text-alogn:center;">Copyright © UNIVESRE</div>
	
	</div>

<!-- 	<div><p>Session Test</p></div> -->
<!-- 	<p>点击这里来创建变量，并显示结果。</p> -->
<!-- 	<button onclick="myFunction()">点击这里</button> -->
<!-- 	<p id="demo"></p> -->
<!-- 	<script> -->
<!-- // 		var count = 0; -->
<!-- // 		function myFunction(){ -->
<!-- // 			count = count + 1; -->
<!-- // 			document.getElementById("demo").innerHTML=count; } -->
<!-- 	</script> -->
<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<th>Session Id</th> -->
<!-- 			<th>Session Type</th> -->
<!-- 			<th>Session Value</th> -->
<!-- 		</tr> -->

<!-- 		<tr> -->
<%-- 		<td><% out.print(session.getId()); %></td> --%>
<%-- 		<td><% out.print(msg); %></td> --%>
<%-- 		<td><% out.print(test.put((Integer)1, (Integer)(test.get(1)+1))); %></td> --%>
<!-- 		</tr> -->
<!-- 	</table> -->

</body>
</html>