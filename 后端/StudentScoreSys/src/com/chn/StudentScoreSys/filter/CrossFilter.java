package com.chn.StudentScoreSys.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CrossFilter
 */
@WebFilter("/*")
public class CrossFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CrossFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String origin = request.getHeader("Origin");
//		System.out.println(origin);
		response.addHeader("Access-Control-Allow-Origin", origin);
		response.addHeader("Allow", "GET,OPTIONS,POST");
		response.addHeader("Access-Control-Allow-Headers", "Content-Type,Access-Control-Allow-Origin,Access-Control-Allow-Credentials");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
