<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JspTestFile</title>
</head>
<body>
	<!-- 声明变量用'!' -->
	<%!
		private int initVar = 0;
		private int serviceVar = 0;
		private int destoryVar = 0;
		
		public void jspInit() {
			initVar++;
			System.out.println("jspInit(): JSP被初始化了" + initVar + "次");
		}
		
		public void jspDestory() {
			destoryVar++;
			System.out.println("jspDestory(): JSP被销毁了" + destoryVar + "次");
		}
	%>
	
	<%
		serviceVar++;
		System.out.println("_jspService(): JSP共响应了" + serviceVar + "次请求");
		String content1 = "初始化次数: " + initVar;
		String content2 = "响应客户请求次数: " + serviceVar;
		String content3 = "销毁次数: " + destoryVar;
	%>
	<!-- 
		Localhost JSP 测试实例
		初始化次数: 1
		响应客户请求次数: 4
		销毁次数: 0
	 -->

	<h1>Localhost JSP 测试实例</h1>
	<p><%=content1%></p>
	<p><%=content2%></p>
	<p><%=content3%></p>
	
</body>
</html>