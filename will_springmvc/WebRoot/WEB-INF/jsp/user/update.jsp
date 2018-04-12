<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <fm:form modelAttribute="user" method="post">
          ID:{id}<br/>
          username:<fm:input path="userName"/><br/><fm:errors path="userName"></fm:errors><br/>
          password:<fm:input path="password"/><br/><fm:errors path="password"></fm:errors><br/>
          email:<fm:input path="email"/><br/><fm:errors path="email"></fm:errors>
          <input type="submit" value="提交">
      </fm:form>
</body>
</html>