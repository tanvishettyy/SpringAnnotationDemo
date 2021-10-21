package org.impelsys.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class IPAddressFilter
 */

@WebFilter(urlPatterns="/hello/*", description="Print IP address of request origin")
public class IPAddressFilter implements Filter {

    /**
     * Default constructor. 
     */
    public IPAddressFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("IpAddressfilter constructed");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("IpAddressfilter destroyed");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("IP address filter");
		String ipAddress=request.getRemoteAddr();
		System.out.println("Request originated from: "+ ipAddress);
		
		
		// pass the request along the filter chain
				chain.doFilter(request, response);
				
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
