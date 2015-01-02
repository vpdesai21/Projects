package com.ecommerce.dao.transactions;

import com.ecommerce.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PaymentDao {

	public int savePaymentDetails(String user_id,
			String card_holder_name, String expiration_date,
			String card_number, String cvv_code) {
		Connection conn = null;
		PreparedStatement statement  = null;
		int payment_id = 0;
		
		try {
					
			conn = ConnectionManager.getMySqlConnection();
			String sql = "INSERT INTO user_payment_details(user_id, card_holder_name, expiration_date, card_number, cvv_code) "+
							"VALUES( '"+ user_id +"', '"+ card_holder_name +"', STR_TO_DATE('"+ expiration_date +"','%m/%Y'), "+ card_number +", "+ cvv_code +") ";

			statement = conn.prepareStatement(sql);
			statement.executeUpdate(sql);
			
			String sql2 = "SELECT MAX(payment_id) FROM user_payment_details";
			statement = conn.prepareStatement(sql2);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
				payment_id = Integer.parseInt(rs.getString(1));
			
			return payment_id;
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
}
