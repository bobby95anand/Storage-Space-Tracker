<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="border:solid;border-color:black;height:220px;" bgcolor="silver ">
<%@page import="model.*,java.sql.*"%>
<%
session=request.getSession(false);
String uid=(String)session.getAttribute("uid");
session=request.getSession(false);
String uname=(String)session.getAttribute("user");
%>
<table align="right">
<tr><td>HELLO</td><td><%=uname %></td></tr>
<tr><td><a href=Ulogin.jsp>Sign Out</a></td></tr>
</table>
<%
try
{
	Connection cn=ConnectDatabase.getCn();
	String sql="select * from bookedspaces where uid=?";
	PreparedStatement ps=cn.prepareStatement(sql);
	ps.setString(1, uid);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){

%>
<table border="2" style ="border: solid;border-color:gray;background: white ; margin-left:400px; margin-top:50px; float:left;">
<tr><td>YOUR ID</td><td>SPACE ID</td><td>SPACE TAKEN</td></tr>
	<tr>
	<td><%=rs.getString(1) %></td><td><%=rs.getString(2) %></td><td><%=rs.getString(3) %></td>
	</tr>
	</table>
	
	<%} 
	else
	{
		RequestDispatcher rd=request.getRequestDispatcher("No.jsp");
		rd.include(request, response);
		
	}
	%>
	
<%
}
catch(Exception e)
{
	System.out.println(e);
}
%>

</body>
</html>