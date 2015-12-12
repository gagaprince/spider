<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>这是一个测试</title>
</head>
<body>
<h2><c:out value="${name}"></c:out>!!!!啊啊啊</h2>
<h2><c:out value="${aaa}"></c:out>!!!!啊啊啊</h2>
</body>
</html>
