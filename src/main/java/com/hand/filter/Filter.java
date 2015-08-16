package com.hand.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.hand.entity.User;
import com.hand.service.CheckUser;

/**
 * Servlet Filter implementation class Filter
 */
public class Filter implements javax.servlet.Filter {

    private CheckUser cu = new CheckUser();
    public Filter() {
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
		System.out.println("=====进入doPost方法=========");
		String userName = req.getParameter("uname");
		String password = req.getParameter("pwd");

		System.out.println("用户名==>"+userName);
		System.out.println("密码==>" + password);
		if(userName == null  ){
			System.out.println("checkServlet密码或用户名为空");


			//请求转发，不可以转发其他页面
			req.getRequestDispatcher("login.jsp").forward(req, resp);

		}
		else{

			User user = new User();
			user.setName(userName);
			//			user.setPasswod(password);
			boolean flag = cu.check(user);

			if(flag){
				req.getRequestDispatcher("success.jsp").forward(req, resp);

			}else{
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}


		}	
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
