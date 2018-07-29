<%@page import="java.io.PrintWriter"%>
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
<form action="Purchase.jsp">
<h1>FREE STORAGE SPACE </h1>
 <table border="2" style ="border: solid;border-color:gray;background: white ; margin-left:400px; float:left;">
<tr><th>SPACE SIZE</th><th>STATUS</th><th>SELECT</th></tr>
<%
try{
	int x=0;
	String sql="select * from spacestatus where status='false'";
	Connection cn=ConnectDatabase.getCn();
	PreparedStatement ps=cn.prepareStatement(sql);
	PrintWriter pw=response.getWriter();
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		
%>
<tr>
<td><%=rs.getString(2)%></td><td><%=rs.getString(3)%></td><td><input type="radio" name="check" value="<%=rs.getString(1)%>"></td></tr>

<%}	/* out.println("<script type=\"text/javascript\">");
	out.println("alert('NO SPACE FREE');");
	out.println("</script>");
	 */
	
%>

<%}catch(Exception e){
	System.out.println(e);
}%>
<tr><th colspan="8"><input type="submit" value="BUY"/></th></tr>
</table> 
 </form>
</body>
</html>