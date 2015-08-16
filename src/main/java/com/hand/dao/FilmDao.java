package com.hand.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.entity.Film;
import com.hand.entity.User;



public interface FilmDao {


	public void save (Connection conn,Film film) throws SQLException;
	public void update(Connection conn,int film_id, Film film) throws SQLException;
	public void delete(Connection conn ,Film film) throws SQLException;
	public ResultSet get(Connection conn ) throws SQLException;
}
