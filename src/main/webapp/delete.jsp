<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/deleteServlet" method="post">
		<table border="1" cellpadding="5" cellspacing="0" bgcolor="silver"
			align="center" width="500">
			<tr>
			<td colspan="4" align="center" bgcolor="#E7899"><a href="index.jsp">返回主页面</a></td>
		   </tr>
		   
			<tr>
				<td colspan="2" align="center" bgcolor="#E7899">删除电影表记录</td>
			</tr>
			<tr style="">
				<td>film_id</td>
				<td width="300"><input type="text" name="film_id" value="<%=request.getParameter("film_id") %>"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" name="删除">
					
			</tr>

		</table>


	</form>
</body>
</html>