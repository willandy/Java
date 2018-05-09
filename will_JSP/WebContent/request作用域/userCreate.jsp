<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
 function checkform(){
	 //如果想在提交表单前验证，就可以在这里写js代码
	 //js代码
	 //return true;
	 //return false;
	 //document.getElementBydId("dataForm").submit();
 }
</script>
<body>
<form name ="dataForm" id="dataForm" action="doUserCreate.jsp" method="get" onsubmit="return checkform()"><!-- onsubmit是指提交表单前验证 -->
	<table class="tb" border="0" cellspacing="5" cellpadding="0" align="center">
		<tr><td align="center" colspan="2" style="text-align:center;" class="text_tabledetail2">用户注册</td></tr>
		<tr>
			<td class="text_tabledetail2">用户名</td>
			<td><input type="text" name="username" value=""/></td>
		</tr>
		<tr>
			<td class="text_tabledetail2">密码</td>
			<td><input type="password" name="password" value=""/></td>
		</tr>
		<tr>
			<td class="text_tabledetail2">确认密码</td>
			<td><input type="password" name="con_password" value=""/></td>
		</tr>
		<tr>
			<td class="text_tabledetail2">email</td>
			<td><input type="text" name="email" value=""/></td>
		</tr>

		<tr>
			<td style="text-align:center;" colspan="2">				
				<button type="submit" class="page-btn" name="save">注册</button>
				<button type="button" class="page-btn" name="return">返回</button>
			</td>
		</tr>
	</table>
	<%
	  Object mess = request.getAttribute("message");
	if(null!=mess){
		out.println(mess.toString());
	}
	%>
	
</form>
</body>
</html>