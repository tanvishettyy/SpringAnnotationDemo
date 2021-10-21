package org.impelsys.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginController  extends HttpServlet {

	private static final long serialVersionUID =1L;
	public LoginController(){
		
	}
	
	/*public void init(ServletConfig config) throws ServletException
	{
		System.out.println("Intializing SecondController");
	}
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException//need to make dopost else error
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException//need to make dopost else error
, ServletException
	{
		HttpSession session =request.getSession(true);
		session.setAttribute("userName", request.getParameter("userName"));
		RequestDispatcher rd = request.getRequestDispatcher("welcome.html");//dispatching of 
		rd.include(request, response);
		//response.sendRedirect("welcome.html");
	}
	
}
