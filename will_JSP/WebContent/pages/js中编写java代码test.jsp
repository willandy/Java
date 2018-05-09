<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
  function clickbutton(){
	  <%
	  //在js中编写java代码，如果要输出就要写完整的js代码
	   out.println("alert('click button!');");
	   String temp="test";
	   out.println("document.getElementById('text01').value='"+temp+"'");
	  %> 
  }
  function clickbutton02(){
	  alert("clickbutton02");
  }
  function load(){
	  document.getElementById("button02").onclick=clickbutton02();
  }
</script>
<body onload="load();">

<input type="text" id="text01" value=""/>
<input type="button" value="button01" onclick="clickbutton()"/>
<input type="button" value="button02" id="button02"/>

</body>
</html>