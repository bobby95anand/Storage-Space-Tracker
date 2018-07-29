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
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try
		{
			PrintWriter out=response.getWriter();
			String nam=request.getParameter("nname");
			String pass=request.getParameter("npass");
			String cpas=request.getParameter("cpass");
			String sid=""+((int)(Math.random()*10000));
			String sql="insert into buyers values(?,?,?)";
			
			Connection cn=ConnectDatabase.getCn();
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, sid);
			ps.setString(2, nam);
			ps.setString(3, pass);
			
			if(pass.equals(cpas))		
		{
			ps.execute();
			RequestDispatcher rd=request.getRequestDispatcher("Ulogin.jsp");
			rd.include(request,response);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('REGISTRATION SUCCESSFULL : YOUR USERNAME IS "+nam+" YOUR PASSWORD IS "+pass+" and ONE TIME UID IS :"+sid+"');");
			out.println("</script>");
			
		}
			else
		{
			out.println("Password didnt match");
			RequestDispatcher rd=request.getRequestDispatcher("Regis.jsp");
			rd.include(request,response);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	


	
	}

}
