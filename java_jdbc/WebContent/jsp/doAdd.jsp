<%@page import="java.util.Date"%>
<%@page import="entity.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../css/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <%
          //设置请求的字符编码UTF-8
          request.setCharacterEncoding("UTF-8");
          String categoryId = request.getParameter("categoryId");
          String title = request.getParameter("title");
          String author = request.getParameter("author");
          String summary = request.getParameter("summary");
          String content = request.getParameter("newscontent");
          
          //从请求中取出数据，提交数据库
          News news = new News();
          news.setAuthor(author);
          news.setCategoryId(Integer.parseInt(categoryId));
          news.setContent(content);
          news.setSummary(summary);
          news.setTitle(title);
          news.setCreateDate(new Date());
          if(newsServiceImpl.add(news)){//成功
        	  //转发
        	 // request.getRequestDispatcher("../newsDetailList.jsp").forward(request, response);
             //现在采用<jsp:forward>来进行跳转
      %>
      <jsp:forward page="../newsDetailList.jsp"></jsp:forward>
      <%} %>
</body>
</html>