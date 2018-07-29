package controller;
import model.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ulogin
 */
@WebServlet("/Ulogin")
public class Ulogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
		PrintWriter out =response.getWriter();
		String uis=request.getParameter("uname");
		String pass=request.getParameter("upass");
		String sql="select uid from buyers where name=? and password=?";
		Connection cn=ConnectDatabase.getCn();
		PreparedStatement ps=cn.prepareStatement(sql);
		ps.setString(1, uis);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			HttpSession session=request.getSession();
			session.setAttribute("uid", rs.getString(1));
			HttpSession session1=request.getSession();
			session1.setAttribute("user", uis);
			RequestDispatcher rd=request.getRequestDispatcher("Redirect.jsp");
			rd.forward(request, response);
		}
		else
		{
			out.println("ID/Password not found please REGISTER");
			RequestDispatcher rd=request.getRequestDispatcher("Ulogin.jsp");
			rd.include(request, response);
			
		}
		
	}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
