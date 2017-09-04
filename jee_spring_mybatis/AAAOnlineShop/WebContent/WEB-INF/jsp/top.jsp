<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>人事管理系统 ——后台登录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<!-- top区域的条幅: 显示登录信息/注销退出, 以及当前用户和时间 -->
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr><td width="320" height="80" class="topbg"><img src="${ctx}/images/top_logo.gif" width="320" height="80"></td>
		<td class="topbg">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr><td height="50" class="toplink" align="right">
				<img src="${ctx}/images/top_home.gif">&nbsp;&nbsp;
				<a href="javascript:void(0);">网站首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="${ctx}/images/top_exit.gif">&nbsp;&nbsp;
				<a href="javascript:void(0);" id="exit">注销退出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td></tr>
			<tr><td height="30" class="topnavbg"><table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr><td width="60"><img src="${ctx}/images/StatBarL.gif" width="60" height="30"></td>
					<td class="topnavlh" align="left"><img src="${ctx}/images/StatBar_admin.gif">&nbsp;&nbsp;当前用户：【${sessionScope.user_session.username}】</td>
					<td class="topnavlh" align="right"><img src="${ctx}/images/StatBar_time.gif">&nbsp;&nbsp;<span id="nowTime"></span></td>
					<td width="3%"></td>
				</tr>
			</table></td></tr>
			</table>
		</td>
	</tr>
	</table>
</body>
</html>