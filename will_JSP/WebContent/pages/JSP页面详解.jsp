<!-- 第一行代码是指令元素，它包含了服务器处理该JSP页面所需的各种信息,例如保存该文件的字符集信息。指令元素的内容不会发送到浏览器 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- <!DOCTYPE>标签，提供了浏览器解析该页面所使用的HTML规范，例如该页面被解析时，浏览器采用HTML 4.01Transitional规范 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- HTML标签，这些标签都会被发送到浏览器,然后被解析成图形化的界面显示给用户 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- CSS样式，用于设置各种标签的样式 -->
<style type="text/css"></style>

<!-- js脚本，用于在客户端实现功能或和用户进行交互 -->
<script type="text/javascript"></script>
</head>
<body>
      <!-- java小脚本：用来请求处理阶段要执行的java代码,out用来输出
      以《%！开头的是声明，它可以用来声明全局变量和定义方法
       -->
      <%String test="test"; %>
      <!-- 以《%=是表达式，在请求处理时，这些表达式的值会被转换成字符串，并显示在页面上 -->
      <%=test %>
</body>
</html>