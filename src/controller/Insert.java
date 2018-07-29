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
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try
		{
			PrintWriter out=response.getWriter();
			String prc=request.getParameter("size");
			String status="false";
			String sid=""+((int)(Math.random()*10000));
			String sql="insert into spacestatus values(?,?,?)";
			
			Connection cn=ConnectDatabase.getCn();
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, sid);
			ps.setString(2, prc);
			ps.setString(3, status);
			ps.execute();
			RequestDispatcher rd=request.getRequestDispatcher("Modify.jsp");
			rd.include(request,response);
			out.println("<script type=\"text/javascript\">");
			out.println("alert('DATA INSERTED ');");
			out.println("</script>");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


	
	
	}

}
