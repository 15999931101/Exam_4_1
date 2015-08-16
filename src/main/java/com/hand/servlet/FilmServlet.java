package com.hand.servlet;

import java.awt.List;
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

 
   


public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FilmDao filmDao = new FileDaoImp();
	
	
	
    public FilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("========doPost执行========");
		System.out.println();
		String id=null;
		
		String title =  req.getParameter("title");
		String description =  req.getParameter("description");
		String language =  req.getParameter("select1");
	 
		if(language.equals("English") ){
			id ="1";
		}
		if(language.equals("Italian")){
			id ="2";
		}
		if(language.equals("Japanese") ){
			id ="3";
		}
		if(language.equals("Mandarin")){
			id ="4";
		}
		if(language.equals("French") ){
			id ="5";
		}
		if(language.equals("German") ){
			id ="6";
		}
		
		
		System.out.println(title+"\t"+description+"\t"+language);
		System.out.println(id);
		Film film = new Film();
		
		film.setTitle(title);
		film.setDescription(description);
        film.setLanguage(id);
        
		
		System.out.println(title +"\t"+title+"\t"+description+"\t"+id);
		Connection conn =getConnection();
		try {
         
			filmDao.save(conn, film);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
