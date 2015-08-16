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
 * Servlet implementation class updateServlet
 */
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	private FilmDao filmDao = new FileDaoImp();
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("========doPost执行========");
		System.out.println();
		String language_id=null;
		int  film_id;
		
		String title =  req.getParameter("title");
		String description =  req.getParameter("description");
		String language =  req.getParameter("select1");
		film_id =Integer.parseInt(req.getParameter("film_id"));
		if(language.equals("English") ){
			language_id ="1";
		}
		if(language.equals("Italian")){
			language_id ="2";
		}
		if(language.equals("Japanese") ){
			language_id ="3";
		}
		if(language.equals("Mandarin")){
			language_id ="4";
		}
		if(language.equals("French") ){
			language_id ="5";
		}
		if(language.equals("German") ){
			language_id ="6";
		}
		
		
		System.out.println(title+"\t"+description+"\t"+language);
		System.out.println(language_id);
		Film film = new Film();
		
		film.setTitle(title);
		film.setDescription(description);
        film.setLanguage(language_id);
        
		
	
		Connection conn =getConnection();
		try {
   
			
			filmDao.update(conn, film_id, film);

			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}
	
	
	public static Connection getConnection(){
		Connection conn =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//用来注册mysql的jdbc程序
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","lin051477515");//连接数据库

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;		
	}

}
