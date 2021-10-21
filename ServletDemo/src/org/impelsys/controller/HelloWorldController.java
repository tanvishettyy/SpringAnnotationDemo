package org.impelsys.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/hello",initParams={
@WebInitParam(name="driverName",value=" oracle.jdbc.odbc.OracleDriver"),
@WebInitParam(name="dbUserName",value="user1")
})  														//request mapping (use fwd slash/)
															//<servername>:portnum/<appname>/hello ->this type of request handled here .

public class HelloWorldController extends HttpServlet {  	//this is servlet. 1st loads and instantiated thn init method
		

	private String userName;
	private int hitCounter;
	//called only first time a request is received
	
	public void init(ServletConfig config) throws ServletException
	{
		ServletContext context=config.getServletContext();
	
		String projectName = context.getInitParameter("projectName");
		String driverName=config.getInitParameter("driverName");
		//startup activities
		//jdbc code
		System.out.println("Loading driver  "+driverName);
		System.out.println("Intializing project: "+projectName);
	 	System.out.println("Intializing HelloWorldController");
	}
	//service method handles incoming request
	//doGet handles only get request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		hitCounter++;
		System.out.println("Handling incoming request....");
		response.setContentType("text/html");  //MIME type
		//response.setContentType("text/json"); 
		
		PrintWriter pw = response.getWriter();         //to write on page
		userName =request.getParameter("userName");
		pw.println("<div bgcolor=\"#ff87eD\">");
		pw.println("<h3>");
		pw.println("Heloo " +userName+"  You are the visitor number: "+hitCounter);
		pw.println("</h3>");
		pw.println("</div>");
		/*ServletContext context = request.getSession().getServletContext(); //context is global and can be used by any other servlets
		context.setAttribute("hitCounter", hitCounter);*/
		
	}
  //handles only post request
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		//hitCounter++;
		System.out.println("Handles Post request");
		
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-store");//fresh page fetch 
		response.setDateHeader("Expires",0); //never store under no circumstance
		/*RequestDispatcher reqDispatcher = request.getRequestDispatcher("secondServlet");//dispatching of 
		reqDispatcher.include(request, response);*/
		
		PrintWriter pw = response.getWriter();
		userName =request.getParameter("userName");
		pw.println("Heloo " +userName);
		
		/*HttpSession session =request.getSession();
		session.setAttribute("userName", userName);*/

		System.out.println("Redirecting to second servlet"); //redirects to 2nd page
		response.setStatus(307);  //use original requests method and body
		response.sendRedirect("secondServlet");
		
		//save username
		//cookie code
		/*Cookie userCookie = new Cookie("uname",userName);
		userCookie.setMaxAge(0); //milisecond. 0-> immediate expiration.-1->deleted once browser is shutdown
		response.addCookie(userCookie);
		*/
		/*pw.println("<form action='secondServlet'>");
		pw.println("<input type='submit' value='Go in'>");
		pw.println("</form>");
		*/
		
		/*RequestDispatcher reqDispatcher = request.getRequestDispatcher("secondServlet");//dispatching of 
		reqDispatcher.forward(request, response);*/
		//reqDispatcher.include(request, response);
	}
	
	//destroy method called after removing servlet instance from the 
	public void destroy()     //called only once like init method
	{
		//do clean up activities
		System.out.println("In destroy");
	}
}
