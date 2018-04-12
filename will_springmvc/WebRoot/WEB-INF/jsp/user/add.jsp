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
         <!-- 不指定action，那么请求提交/add ,这里不指定action，那么后台requestMapping里面参数
           value值就相当于action
         -->
         <%-- <fm:form modelAttribute="user" method="post">
              <!-- 这里的path，就相当于input text里面的name属性 -->
              ID:<fm:input path="id"/><br/>
              username:<fm:input path="userName"/><br/>
              password:<fm:input path="password"/><br/>
              email:<fm:input path="email"/><br/>
              <input type="submit" value="提交"/>
         </fm:form> --%>
         <!-- 现在指定action -->
         <!-- modelAttribute="user"：这句话可以获取model中key为user的对象属性 -->
        <%--  <fm:form modelAttribute="user" action="addsave" method="post" enctype="multipart/form-data">
              <!-- 这里的path，就相当于input text里面的name属性 -->
              ID:<fm:input path="id"/><br/>
              username:<fm:input path="userName"/><br/><fm:errors path="userName"></fm:errors><br/>
              password:<fm:input path="password"/><br/><fm:errors path="password"></fm:errors><br/>
              email:<fm:input path="email"/><br/><fm:errors path="email"></fm:errors>
              attach:<input type="file" name="attach"/><br/>
              <input type="submit" value="提交"/>
         </fm:form> --%>
         
         <fm:form modelAttribute="user" action="addsave" method="post" enctype="multipart/form-data">
              <!-- 这里的path，就相当于input text里面的name属性 -->
              ID:<fm:input path="id"/><br/>
              username:<fm:input path="userName"/><br/><fm:errors path="userName"></fm:errors><br/>
              password:<fm:input path="password"/><br/><fm:errors path="password"></fm:errors><br/>
              email:<fm:input path="email"/><br/><fm:errors path="email"></fm:errors>
              <!-- 实现多文件上传 -->
              attach:<input type="file" name="attachs"/><br/>
              <input type="file" name="attachs"/><br/>
              <input type="file" name="attachs"/><br/>
              <input type="submit" value="提交"/>
         </fm:form>
</body>
</html>