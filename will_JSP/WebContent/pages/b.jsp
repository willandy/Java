<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
    out.println("b.jsp===========<br/>");
    out.println("id:"+request.getParameter("id")+"<br/>");
    request.setAttribute("name", "zhangsan");
    out.println("name:"+request.getAttribute("name")+"<br/>");
    %>
    <a href="c.jsp?class=test01">链接到c.jsp，参数class=test01,requestBC诞生</a>
</body>
</html>