<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style type="text/css">
body{
  color: #000;
  font-size:14px;  
  margin:20px auto;
}
</style>

</head>
<body>  
<center>
	
	<%
	
		Object obj = request.getAttribute("msg");
		if(obj != null){
			out.println(obj.toString());
		}else{
			out.println("无");
		}

	%>
	
	</center>
	<br/>     
<form action="<%=request.getContextPath()%>/LoginServlet" method="post" name="loginForm" >
<table border="1" cellpadding="5" cellspacing="0" bgcolor="silver" align="center">
<tr>
  <td colspan="2" align="center" bgcolor="#E7899">用户登录</td>
</tr>
<tr>
  <td>用户名：</td>
  <td><input type="text" name = "uname"></td>
</tr>
<tr>
   <td>密码：</td>
  <td><input type="password" name = "pwd"></td>
</tr>
<tr>
  <td colspan="2" align="center" >
    <input type="submit" name= "sumbit"  >
    <input type="reset" name="reset">
  </td>
</tr>

</table>
</form>
</body>
</html>