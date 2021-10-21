package org.impelsys.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(value="/secondServlet",initParams={
		@WebInitParam(name="fileName",value=" file.txt")
}
)
public class SecondController extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("Intializing SecondController");
	}
	//service method handles incoming request
	//doGet handles only get request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException//need to make dopost else error
	{
		System.out.println("Handling post request in second controller");
		PrintWriter out = response.getWriter();
		//Cookie cookie[]=request.getCookies();
		//String userName=null;
		
		HttpSession session=request.getSession(false);//will not create a new session if already exists 
		String userName=null;
		
		if(session!=null)
			userName = (String)session.getAttribute("userName");
		
		
	//	String userName=request.getParameter("userName");
		/*if(cookie!=null)
		{
			userName=cookie[0].getValue();
		}	*/
		if(userName==null)
			out.println("Invalid User!");
			else 
				response.setContentType("text/html");
				out.println("<html> <body bgcolor='green'>");
				out.println("Hello: " +userName+" !You are in 2nd page" );
				out.println("</body></html>");
	}
}
