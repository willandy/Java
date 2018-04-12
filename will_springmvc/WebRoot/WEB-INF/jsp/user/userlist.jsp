<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath() %>/statics/css/main.css" rel="stylesheet" style="text/css">
<title>Insert title here</title>
</head>
<body>
     ====用户列表===<br/>
     <!-- 注意这里的userList，model是map类型的，它是键值对类型的数据，所以userList
     单个记录不是user对象，而是一个键值，var里面取得值就是value值
       -->
       <!-- 这里是用于添加页面 -->
       <a href="add">添加</a><br/>
       <!-- 显示UserController里在用户登录方法里，获取的user对象 -->
            当前用户:${loginUser.userName} <br/>
       <!-- 方法一：全局变量，实现对象列表,对应UserController里面的model传参 -->
      <c:forEach items="${userList }" var="ul">
         id:${ul.value.id }------
         <a href="view/${ul.value.id} ">userName:${ul.value.userName }------</a>
         password:${ul.value.password }------
         email:${ul.value.email }
         <a href="${ul.value.id}/update ">修改</a>
         <a href="${ul.value.id}/delete ">删除</a><br/>
     </c:forEach> 
     
     <!-- 对象传参 方法二：采用HttpServletRequest方式 -->
     <!-- 这里的userList就不再是map形式的，而是arrayList格式的，
          单条数据就是user对象了，可以直接获取值了
      -->
 <%--     <c:forEach items="${userList }" var="user">
        id:${user.id }~~~~~~
        userName:${user.userName }~~~~~~
        password:${user.password }~~~~~~
        email:${user.email }~~~~~~<br/>
     </c:forEach> --%>
     
</body>
</html>