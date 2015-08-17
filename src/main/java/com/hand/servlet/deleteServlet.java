package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.FilmDao;
import com.hand.dao.Imp.FileDaoImp;
import com.hand.entity.Film;

/**
 * Servlet implementation class deleteServlet
 */
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FilmDao filmDao = new FileDaoImp();
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("========doPost执行========");
	
		int  film_id;		
		film_id =Integer.parseInt(req.getParameter("film_id"));
		Film film = new  Film();
		film.setFilm_id(film_id);
		Connection conn =getConnection();
		try {
			filmDao.delete(conn, film);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("index.jsp");
	
	}
	
	public static Connection getConnection(){
		Connection conn =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//用来注册mysql的jdbc程序
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","");//连接数据库

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;		
	}

}
