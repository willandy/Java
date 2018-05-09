<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fun(){
	window.location="JSP基本处理详解2.jsp";
}
function fun2(){
	window.location="JSP基本处理详解2.jsp?uid=admin";
}
function fun3(){
	/* get方法传参 */
	window.open("JSP基本处理详解2.jsp?uid=admin");
}
function fun4(){
	/* post方法传参 */
	var uid = document.getElementById("uid").value;
	if(uid==""){
		alert("请输入用户名");
		return false;
	}else{
		return true;
	}
}
</script>
</head>
<body>
      <!-- 链接到JSP基本处理详解2-->
      <a href="JSP基本处理详解2.jsp">JSP基本处理详解2</a>
      <!-- 链接到JSP基本处理详解2，弹出新窗口-->
      <a href="JSP基本处理详解2.jsp" target="_blank">JSP基本处理详解2</a>
      <!-- 相对路径链接到JSP基本处理详解2,./指当前文件夹,../指上一级 -->
      <a href="./JSP基本处理详解2.jsp">JSP基本处理详解2</a>
      <a href="../pages/JSP基本处理详解2.jsp">JSP基本处理详解2</a>
      <!-- 绝对路径链接到JSP基本处理详解2 -->
      <a href="http://localhost:8900/will_JSP/pages/JSP基本处理详解2.jsp">JSP基本处理详解2</a><!-- 用这种方式的缺点是，如果不是本项目，路径将会出错 -->
      <a href="<%=request.getContextPath() %>/pages/JSP基本处理详解2.jsp">JSP基本处理详解2</a><!-- request.getContextPath()得到网站的域名 -->
      <!-- 链接到JSP基本处理详解2，并传参 -->
      <a href="JSP基本处理详解2.jsp?uid=admin">JSP基本处理详解2</a>
      <!-- 使用js链接到JSP基本处理详解2 -->
      <a href='javascript:window.location="JSP基本处理详解2.jsp";'>JSP基本处理详解2</a> <!-- js代码写在这里，没有可读性 -->
      <a href='javascript:fun();'>JSP基本处理详解2</a>
      <!-- 使用js链接到JSP基本处理详解2，并传参 -->
      <a href='javascript:fun2();'>JSP基本处理详解2</a><!-- 这个传参 -->
      <!-- 使用js链接到JSP基本处理详解2，弹出新窗口，并传参 -->
      <a href='javascript:fun3();'>JSP基本处理详解2</a><!-- 新窗口，并传参 -->
     <!-- ---------------------以下是post提交表单---------------------------- -->
      <!-- submit提交表单 -->
      <form action="JSP基本处理详解2.jsp" method="post">
        <input type="text" name="uid"/>
        <input type="submit" value="提交表单"/>
      </form>
      <!-- 验证后提交表单 -->
      <form action="JSP基本处理详解2.jsp" method="post">
        <input type="text" name="uid" id="uid"/><!-- 记住本页面id唯一 -->
        <input type="submit" value="提交表单" onclick="return fun4();"/><!-- 之所以加上return，是因为上面js写了return -->
      </form>
      <!-- url方式提交表单 -->
      <form action="JSP基本处理详解2.jsp?uid=admin" method="post">
        <input type="submit" value="提交表单"/>
      </form>
      <!-- hidden方式提交表单 -->
      <form action="JSP基本处理详解2.jsp" method="post">
       <input type="hidden" name="uid" id="uid2" value="admin"/>
       <input type="submit" value="提交表单"/>
       <script type="text/javascript">
       /* 动态传参 */
        document.getElementById("uid2").value="admin2";
       </script>
      </form>
      <!-- button+js提交表单 -->
      <form id="form1" action="JSP基本处理详解2.jsp" method="post">
       <input type="text" name="uid"/>
       <input type="button" value="提交表单" onclick='document.getElementById("form1").submit();'/>
      </form>
      <!-- <a>+js提交表单 -->
       <form id="form2" action="JSP基本处理详解2.jsp" method="post">
       <input type="text" name="uid"/>
       <a href='javascript:document.getElementById("form2").submit();'>提交表单</a>
      </form>
</body>
</html>