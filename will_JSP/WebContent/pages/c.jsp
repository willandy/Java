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
      out.println("c.jsp===================<br/>");
      out.println("id:"+request.getParameter("id")+"<br/>");
      out.println("name"+request.getAttribute("name")+"<br/>");
      out.println("clss:"+request.getParameter("class")+"<br/>");
      %>
      <!-- 如果用链接方式，d页面取不到class的值 -->
      <a href="d.jsp">链接到d.jsp，requestCD诞生</a>
      <!-- 如果用jsp:forward就是转发，可以取到class的值，转发就相当于c和d页面整合
                  ，相当于作用域延长了 -->
      <%-- <jsp:forward page="d.jsp"/> --%>
</body>
</html>