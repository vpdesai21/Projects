package com.ecommerce.dao.users;

import com.ecommerce.bean.User;
import com.ecommerce.constants.Constants;
import com.ecommerce.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	public User isAuthentic(String username, String password) {
		User user = null;
		Connection conn  = null;
		PreparedStatement statement = null ;
		String retrievedPassword = null;
		String firstname = null;
		String lastname = null;
		String dob = null;
		
		try {
			
			conn = ConnectionManager.getMySqlConnection();
			String sql = "SELECT * FROM user WHERE user_id = '"+ username + "'";
			statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);

			while (result.next()){
				retrievedPassword = result.getString(Constants.PASSWORD);
				firstname = result.getString(Constants.FIRST_NAME);
				lastname = result.getString(Constants.LAST_NAME);
				dob = result.getDate(Constants.DOB).toString();
			}
			
			if(password.equalsIgnoreCase(retrievedPassword))
				user = new User(username, retrievedPassword, firstname, lastname, dob);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public boolean signup(String username, String password, String firstname, String lastname, String dob) {
		Connection conn = null;
		PreparedStatement statement  = null;
		
		try {
					
			conn = ConnectionManager.getMySqlConnection();
			String sql = "INSERT INTO user VALUES(?, ?, ?, ?, STR_TO_DATE(?,'%m/%d/%Y')) ";

			statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, firstname);
			statement.setString(4, lastname);
			statement.setString(5, dob);
			statement.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
