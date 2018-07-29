package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ConnectDatabase;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
		try
		{
			PrintWriter out=response.getWriter();
			String nam=request.getParameter("id");
			//String sql1="select * from spacestatus where status='false'";
			String sql="delete from spacestatus where spaceid=? and status= 'false'";
			Connection cn=ConnectDatabase.getCn();
			//PreparedStatement ps1=cn.prepareStatement(sql1);
			PreparedStatement ps=cn.prepareStatement(sql);
			//ResultSet rs=ps1.executeQuery();
			/*out.println("<h2>VALID SPACES FOR DELETION</h2>");
			out.println("<table border=\"2\" style =\"border: double;border-color:white;background:red;\">");
			out.println("<tr><th>SPACE ID</th><th>SPACE SIZE</th><th>STATUS</th></tr>");
			
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"<td>"+rs.getString(3)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");*/
			ps.setString(1, nam);
			if(ps.executeUpdate()!=0)
			{
			RequestDispatcher rd=request.getRequestDispatcher("Modify.jsp");
			rd.include(request,response);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('RECORD DELETED ');");
			out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('INVALID RECORD INPUT ');");
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("Delete.jsp");
				rd.include(request,response);
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	
	}

}
