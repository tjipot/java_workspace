<!-- 注意prefix="form", 故运行时可认form开头的标签 -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FromTest JSP Page</title>
</head>
<body>
	<!-- 前缀form之后才是Spring MVC标签库的form标签 -->
	<!-- form标签和input标签的示例 -->
	<!-- path属性指定要绑定的model对象中的值: username, etc. -->
	<!-- 由于jsp是在服务器上处理并返回的, 故这些标签也是由服务器(和相应库)处理:
		 服务器'直接'填充model的数据到'username', etc. -->
	<form:form method="post" action="register">
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td>Sex:</td> 
				<td><form:input path="sex"/></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><form:input path="age"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>