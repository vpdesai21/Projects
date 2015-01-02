package com.ecommerce.dao.transactions;

import com.ecommerce.constants.Constants;
import com.ecommerce.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddressDao {

	public int saveAddress(String user_id, String address_line1,
			String address_line2, String city, String state, String zipcode) {
		Connection conn = null;
		PreparedStatement statement  = null;
		int address_id = 0;
		
		try {
					
			conn = ConnectionManager.getMySqlConnection();
			String sql = "INSERT INTO user_address(user_id, address_line1, address_line2, city, state, zip_code) "+
							"VALUES( '"+ user_id + "', '"+ address_line1 + "', '"+ address_line2 + "', '"+ city + "', '"+ state + "', "+ zipcode + ") ";
			statement = conn.prepareStatement(sql);
			statement.executeUpdate(sql);
			
			String sql2 = "SELECT MAX(address_id) FROM user_address";
			statement = conn.prepareStatement(sql2);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
				address_id = Integer.parseInt(rs.getString(1));
			
			return address_id;
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public String getFullAddress(String address_id) {
		Connection conn = null;
		PreparedStatement statement  = null;
		String fullAddress = "";
		
		try {
					
			conn = ConnectionManager.getMySqlConnection();
			String sql = "SELECT * FROM user_address WHERE address_id='"+address_id+"'";
			statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				fullAddress = fullAddress + rs.getString(3) + ", "
										  + rs.getString(4) + ", "
										  + rs.getString(5) + ", "
										  + rs.getString(6) + " "
										  + rs.getString(7);
			}
			
			return fullAddress;
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.EMPTY_STRING;
		}
	}
	
	
	
}
