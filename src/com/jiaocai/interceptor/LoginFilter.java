package com.jiaocai.interceptor;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiaocai.model.Account;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(asyncSupported=true,filterName="loginFilter",urlPatterns="*.jsp")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		Account account = (Account) session.getAttribute("account");
		String requestURI=req.getRequestURI(); 
	
		if(requestURI.endsWith(".jsp"))
		{
			requestURI = req.getRequestURI(); 
			System.out.println("请求路径:"+requestURI);
		}
		String logonRequest=req.getContextPath()+"/pages/login.jsp"; 
		if(!(requestURI.equals(logonRequest))) 
			   if(account==null){
			   // res.sendRedirect("/zhenxiang/page/admin/page/login.jsp");
				   request.setAttribute("msg", "请先登录！");
				request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			    return;
			   } 
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
