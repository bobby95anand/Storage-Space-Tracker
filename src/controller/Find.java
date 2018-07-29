package controller;
import model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Find
 */
@WebServlet("/Find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try
		{
		PrintWriter out =response.getWriter();
		String uis=request.getParameter("name");
		String uid=request.getParameter("uid");
		String sql="select password from buyers where name=? and uid=?";
		Connection cn=ConnectDatabase.getCn();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, uis);
		ps.setString(2, uid);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{		
			out.println("<script type=\"text/javascript\">");
			out.println("alert('YOUR PASSWORD IS :"+rs.getString(1)+"');");
			out.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("Ulogin.jsp");
			rd.include(request,response);
			
		}
		else
		{
			out.println("USERNAME NOT FOUND!");
			RequestDispatcher rd=request.getRequestDispatcher("Find.jsp");
			rd.include(request, response);
			
		}
		
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
