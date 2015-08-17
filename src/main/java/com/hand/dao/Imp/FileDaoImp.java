package com.hand.dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.FilmDao;
import com.hand.entity.Film;



public class FileDaoImp implements FilmDao {
    

	public ResultSet get(Connection conn) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("SELECT f.film_id,f.title,f.description,l.name  FROM  film f,LANGUAGE l  WHERE f.language_id=l.language_id ");

	 
		return ps.executeQuery();
		
	}

	public void save(Connection conn, Film film) throws SQLException {
		
		
		System.out.println(film.getLanguage());
		String rental_duration="6";
		String rental_rate="1.00";
		String replacement_cost="20.00";
		String last_update="2015-8-16 ";
		
		String insertSql = "insert into film(title,description,language_id,"
				+ "rental_duration,rental_rate,replacement_cost,last_update) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(insertSql);	
		
		ps.setString(1, film.getTitle());
		ps.setString(2, film.getDescription());
		ps.setString(3, film.getLanguage());	
		ps.setString(4, rental_duration);
		ps.setString(5, rental_rate);
		ps.setString(6, replacement_cost);	
		ps.setString(7, last_update);
			
		ps.execute();
		System.out.println("添加成功");
		
	}

	public void update(Connection conn, int id, Film film) throws SQLException {
//		System.out.println(film.getLanguage());
//		String rental_duration="6";
//		String rental_rate="1.00";
//		String replacement_cost="20.00";
//		String last_update="2015-8-16 ";
		
		String insertSql = "update film set title=?,description=?,language_id=? where film_id = ?";
		PreparedStatement ps = conn.prepareStatement(insertSql);	
		
		ps.setString(1, film.getTitle());
		ps.setString(2, film.getDescription());
		ps.setString(3, film.getLanguage_id());	
		ps.setLong(4, film.getFilm_id());	

			
		ps.execute();
		System.out.println("更新成功");
		
	}

	public void delete(Connection conn, Film film) throws SQLException {
		String insertSql = "delete from film where film_id=?";
		PreparedStatement ps = conn.prepareStatement(insertSql);	
		
		ps.setLong(1, film.getFilm_id());			
		ps.execute();
		System.out.println("删除成功");
		
		
	}
}
