package com.hand.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.entity.User;
import com.hand.service.CheckUser;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private CheckUser cu = new CheckUser();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=====进入doPost方法=========");
		String userName = req.getParameter("uname");
		String password = req.getParameter("pwd");

		System.out.println("用户名==>"+userName);
		System.out.println("密码==>" + password);
		if(userName == null  ){
			System.out.println("checkServlet密码或用户名为空");


			//请求转发，不可以转发其他页面
			req.getRequestDispatcher("error.jsp").forward(req, resp);

		}
		else{

			User user = new User();
			user.setName(userName);
			//			user.setPasswod(password);
			boolean flag = cu.check(user);

			if(flag){
				req.getRequestDispatcher("success.jsp").forward(req, resp);

			}else{
				req.getRequestDispatcher("error.jsp").forward(req, resp);
			}


		}

	}
}
