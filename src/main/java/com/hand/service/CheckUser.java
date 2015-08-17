package com.hand.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.hand.dao.UserDao;
import com.hand.dao.Imp.UserDaoImp;
import com.hand.entity.User;

public class CheckUser {

	
	
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
	
	
	
	public boolean check(User user){
		Connection conn =null;

		UserDao userDao = new UserDaoImp();
		try {
           
		    conn = getConnection();
         	System.out.println("数据已连接！"+conn);
			conn.setAutoCommit(false);
			ResultSet rs = userDao.get(conn, user);
			
			while(rs.next()){
				 return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}			
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
}

