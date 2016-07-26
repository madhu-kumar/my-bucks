package com.bucks;

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
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter("/SecurityFilter")
public class SecurityFilter implements Filter {

    /**
     * Default constructor.
     */
    public SecurityFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = ( HttpServletRequest ) servletRequest;
		HttpServletResponse httpServletResponse = ( HttpServletResponse ) servletResponse;

		String requestURL = httpServletRequest.getRequestURI();
		if("/".equalsIgnoreCase( requestURL)){
			httpServletResponse.sendRedirect("index.html");
		}else if("/index.html".equalsIgnoreCase( requestURL) || requestURL.contains("partial")){
			chain.doFilter(servletRequest,servletResponse);
		}else{
			httpServletResponse.sendRedirect("index.html#"+requestURL);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
