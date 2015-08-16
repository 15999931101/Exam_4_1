<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import ="java.sql.DriverManager" %>
<%@page import ="java.sql.PreparedStatement" %>
<%@page import ="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn;

Class.forName("com.mysql.jdbc.Driver");//用来注册mysql的jdbc程序
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","lin051477515");//连接数据库
String sql="select name from language";
PreparedStatement ps1 = conn.prepareCall(sql);	
ResultSet rs =ps1.executeQuery(sql);//执行sql语句
ArrayList list = new ArrayList();
while(rs.next()){
	int i=0;
	list.add(i++,rs.getString(1));
}



%>

	<form action="<%=request.getContextPath()%>/FilmServlet" method="post">
		<table border="1" cellpadding="5" cellspacing="0" bgcolor="silver"
			align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E7899">添加电影表记录</td>
			</tr>
			<tr>
				<td>title：</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>description</td>
				<td><input type="text" name="description"></td>
			</tr>
			<tr>
				<td>language</td>
				<td><select id="select1" name="select1">
						<option value="请选择" selected="selected">请选择</option>
						<%
							for (int i = 0; i < list.size(); i++) {
						%>
						<option value="<%=list.get(i).toString() %>">
							<%=list.get(i).toString()%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="添加">
					<input type="reset" name="重置"></td>
			</tr>

		</table>


	</form>


</body>
</html>