<%@page import="java.net.URLEncoder"%>
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
    //post请求下的中文乱码格式
    //设置请求的编码格式
    request.setCharacterEncoding("utf-8");
    //设置响应的编码格式
    //response.setCharacterEncoding("utf-8");
    
    //get请求下的中文乱码的处理方式一：因为get是url传参，但是这种处理方式要每个都转码
   String username = request.getParameter("username");
    /*String user = new String(username.getBytes("iso-8859-1"),"utf-8"); */
    //get请求下中文乱码方法二：修改tomcat端口号，添加URIEncoding="utf-8"
    
    //现在做页面跳转
    if(username.equals("admin")){
    	//提示用户已存在，不能注册
    	//转发
    	request.setAttribute("message", "该用户已存在，不能注册!");
    	//页面转发的两种形式
    	//<jsp:param value="admin" name="userName"/>//但是要注意不能写在java中
    	//方法二
    	request.getRequestDispatcher("userCreate.jsp").forward(request, response);
    }else{
    	//提示注册成功
    	//重定向
    	//采用request，index.jsp是获取到message的值的
    	//request.setAttribute("message", "注册成功!");
    	//如果想获取message的值，就要用session
    	session.setAttribute("message", "注册成功!");
    	//session.setMaxInactiveInterval(5);//session有效期设置
    	
    	//现在测试cookie
    	session.setAttribute("user", username);
    	//Cookie cookie =new Cookie("user",username);
    	//但是用上面的cookie，如果输入的是中文，就会报错，所以下面需要字节码转换
    	Cookie cookie = new Cookie("user",URLEncoder.encode(username, "UTF-8"));
    	cookie.setMaxAge(60*60);
    	//这里之所以是response，是因为cookie是服务器给的响应
    	response.addCookie(cookie);
    	
    	response.sendRedirect("../pages/index.jsp?flag=success");
    	//如果是传递了参数flag，那么sendRedirect就表示服务器发送了302状态玛，然后引号里面是请求该页面
    }
    
    String password = request.getParameter("password");
    out.println("username:"+username+"<br/>");
    out.println("password:"+password+"<br/>");
    out.println(request.getParameter("con_password")+"<br/>");
    String email = request.getParameter("email");
    %>
    email:<%=email %>
</body>
</html>