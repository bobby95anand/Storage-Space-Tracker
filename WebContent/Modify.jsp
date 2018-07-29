<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="border:solid;border-color:black;height:220px;" bgcolor="silver">
<%@page import="java.sql.*,model.*" %>
<table align="right">
<tr><td>WELCOME ADMIN</td></tr>
<tr><td><a href=Alogin.jsp>Sign out</a></td></tr>
</table>
<table border="2" style ="border: solid;border-color:gray; margin-left:400px; margin-top:10px;background:white  ;">
<tr><th>SPACE ID</th><th>SPACE SIZE</th><th>STATUS</th></tr>
<%
try{
	String sql="select * from spacestatus";
	Connection cn=ConnectDatabase.getCn();
	PreparedStatement ps=cn.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
%>
<tr>
<td><%=rs.getString(1)%></td><td><%=rs.getString(2)%></td><td><%=rs.getString(3)%></td></tr>
<% }%>
<%}catch(Exception e){
	System.out.println(e);
}%>
</table>
<p>
<form action="Insert.jsp">
<table style ="border:double;background:gray; height:100; width:250;float:left;margin-left:400px;  margin-right:10px;">
<tr><th colspan="8"><font style="font-size: 24;color:white;text-decoration: underline;">INSERT DATA</font></th></tr>
<tr><th colspan="8"><input type="submit" value="Insert"></th></tr>
</table>
</form>
<form action="Delete.jsp">
<table style ="border:double;background:gray;height:100; width:250;float:left;margin-right: 10px;">
<tr><th colspan="8"><font style="font-size: 24;color: white;text-decoration: underline;">DELETE DATA</font></th></tr>
<tr><th colspan="8"><input type="submit" value="Delete">
</table>
</form>
</body>
</html>