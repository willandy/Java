<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
测试：
  <%
    String user =(String)request.getAttribute("username");
    out.print(user);
   %>
   <!-- 值是存在model里 -->
    <h1>welcome,Spring MVC!</h1>
    <c:out value="${username} "></c:out>
</body>
</html>