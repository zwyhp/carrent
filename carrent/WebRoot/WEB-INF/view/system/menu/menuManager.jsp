<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>菜单管理</title>
</head>
 <!-- 如果使用framest的包含页面  主页面不能有body -->
 	<frameset cols="260,*" border="1">
 		<frame src="${ctx}/sys/toMenuLeft.action" name="left">
 		<frame src="${ctx}/sys/toMenuRight.action" name="right">
 	</frameset>
</html>