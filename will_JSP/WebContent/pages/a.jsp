<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <!-- 写一个a页面，跳转到b页面，那么ab的request作用域诞生 -->
  <a href="b.jsp?id=123">链接到b.jsp，参数id=123,requestAB诞生</a>
</body>
</html>