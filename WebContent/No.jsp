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
<%@page import="model.*,java.sql.*"%>

<%
try{
	int x=0;
	String sql="select * from spacestatus where status='false'";
	Connection cn=ConnectDatabase.getCn();
	PreparedStatement ps=cn.prepareStatement(sql);
	PrintWriter pw=response.getWriter();
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
		RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
		rd.include(request,response);
		
%>
	
<%}else
{
	out.println("NO FREE SPACES AVAILABLE");
	RequestDispatcher rd=request.getRequestDispatcher("Not.jsp");
	rd.include(request,response);
	/* out.println("<script type=\"text/javascript\">");
	out.println("alert('NO SPACE FREE');");
	out.println("</script>");
	 */
}
	
%>

<%}catch(Exception e){
	System.out.println(e);
}%>

</body>
</html>