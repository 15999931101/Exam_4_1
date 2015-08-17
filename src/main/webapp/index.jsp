<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

主页面！<br/><br/>
<%
		String flag = "";
		Object obj = session.getAttribute("flag");
		if (obj != null) {
			flag = obj.toString();
		}
		if (flag.equals("login_success")) {
	%>
	<a href="<%=request.getContextPath()%>/LogoutServlet">退出</a><br/><br/>
	
    
	<%
		} else {
	%>
	<a href="<%=request.getContextPath()%>/login.jsp">登录</a><br/><br/>
	<%
		}
	%>

<a href ="showfilm.jsp">显示File记录</a><br/><br/>
<a href ="addfilm.jsp">添加File记录</a><br/><br/>
<a href ="updatefilm.jsp">更新File记录</a><br/><br/>
<a href ="deletefilm.jsp">删除File记录</a><br/><br/>
</body>
</html>