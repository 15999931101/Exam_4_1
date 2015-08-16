<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import ="java.sql.DriverManager" %>
<%@page import ="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#td{
  width: 20;
  height: 30;
}

</style>
</head>
<body>
	<%
	Connection conn;
	
	Class.forName("com.mysql.jdbc.Driver");//用来注册mysql的jdbc程序
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","lin051477515");//连接数据库
	String sql="SELECT f.film_id,f.title,f.description,l.name  FROM  film f,LANGUAGE l  WHERE f.language_id=l.language_id";
	PreparedStatement ps1 = conn.prepareCall(sql);	
	ResultSet rs =ps1.executeQuery(sql);//执行sql语句

	%>
<table>
	<% 
	out.println("<tr><td>"+"\t"+"film_id"+"</td><td>" +"film"+"</td><td>"+"description"+"</td><td>"+"language"
            +"</td><td>");
	while(rs.next()){
        out.println("<tr><td>"+rs.getString(1)+"</td><td>" +rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"
                +rs.getString(4)+"</td><td>");
    }

	%>
	</table>
</body>
</html>