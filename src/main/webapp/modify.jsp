<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import ="java.sql.DriverManager" %>
<%@page import ="java.sql.PreparedStatement" %>
<%@page import ="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="<%=request.getContextPath()%>/FilmServlet" method="post">
		<table border="1" cellpadding="5" cellspacing="0" bgcolor="silver"
			align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E7899">更新电影表记录</td>
			</tr>
			<tr>
				<td>title</td>
				<td><input type="text" name="title" value="<%=request.getParameter("title") %>"></td>
			</tr>
			<tr>
				<td>description</td>
				<td><input type="text" name="description" value="<%=request.getParameter("description") %>"></td>
			</tr>
			<tr>
				<td>language</td>
				<td><input type="text" name="language" value="<%=request.getParameter("language") %>"></td>
				
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="添加">
					<input type="reset" name="重置"></td>
			</tr>

		</table>


	</form>
</body>
</html>