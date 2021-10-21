package org.impelsys.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(urlPatterns={"/hello","/secondServlet"}, servletNames={"SecondController","LoginController"})    //classname //authenticationservlet registered to second servlet and login controller servlet
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
    	System.out.println("IPAddressfilter destroyed");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Authenticationfilter destroyed");
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		//chk if user looged in for every request
		
		System.out.println("Authentication Filter");
		
		HttpServletRequest req=(HttpServletRequest)request;    //since HttpServletRequest cant be used in method signature
		HttpServletResponse res =(HttpServletResponse)response; 
		
		HttpSession session =req.getSession(false);
		String userName=null;
		
		if(session!=null)
			 userName = (String)session.getAttribute("userName");
		  // userName=(String) session.getAttribute("userName");
		if(userName!=null){
		// pass the request along the filter chain
			System.out.println("User already logged in...");
		  chain.doFilter(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	

}
