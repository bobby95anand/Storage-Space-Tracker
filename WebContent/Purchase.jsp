<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession(false);
String id=(String)session.getAttribute("uid");
session=request.getSession(false);
String id1=(String)session.getAttribute("user");
%>
<%@page import="model.*,java.sql.*" %>
<table align="right">
<tr><td>HELLO</td><td><%=id1 %></td></tr>
</table>

<% 
	try
		{
		 PrintWriter pw =response.getWriter();
			Connection cn=ConnectDatabase.getCn();
			String pid=request.getParameter("check");
			String prc=null;
			String sql1="select spacesize from spacestatus where spaceid=?";
			PreparedStatement ps1=cn.prepareStatement(sql1);
			ps1.setString(1, pid);
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				prc=rs.getString(1);
			}
			System.out.println(prc);
			String sql="insert into bookedspaces values(?,?,?)";
			PreparedStatement ps =cn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pid);
			ps.setString(3, prc);
			ps.execute();
			String sql2="update spacestatus set status='true' where spaceid=?";
			PreparedStatement ps2 =cn.prepareStatement(sql2);
			ps2.setString(1, pid);
			ps2.execute();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('PURCHASE SUCCESSFULL ');");
			out.println("</script>");
			
			RequestDispatcher rd=request.getRequestDispatcher("Ulogin.jsp");
			rd.forward(request, response);
			session.invalidate();
			
			
%>
<%} catch(Exception e){
		System.out.println(e);
		}%>

</body>
</html>