package com.ecommerce.dao.transactions;

import com.ecommerce.bean.Transaction;
import com.ecommerce.constants.Constants;
import com.ecommerce.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {

	public int saveTransaction(String user_id, String address_id,
			String payment_id, String order_placed_timestamp) {
		Connection conn = null;
		PreparedStatement statement  = null;
		int order_id = 0;

		try {

			conn = ConnectionManager.getMySqlConnection();
			String sql = "INSERT INTO order_transaction(user_id, address_id, payment_id, order_placed_timestamp) "+
							"VALUES( '"+ user_id +"', "+ address_id +", "+ payment_id +", STR_TO_DATE('"+ order_placed_timestamp +"', '%m/%d/%Y')) ";

			statement = conn.prepareStatement(sql);
			statement.executeUpdate(sql);
			
			String sql2 = "SELECT MAX(order_id) FROM order_transaction";
			statement = conn.prepareStatement(sql2);
			ResultSet rs = statement.executeQuery();
			while(rs.next())
				order_id = Integer.parseInt(rs.getString(1));
			
			return order_id;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public boolean updateTransaction(String order_id, String order_updated_timestamp,
			String is_cancelled) {
		Connection conn = null;
		PreparedStatement statement  = null;

		try {

			conn = ConnectionManager.getMySqlConnection();
			String sql = "UPDATE order_transaction SET order_updated_timestamp=STR_TO_DATE('"+order_updated_timestamp+"', '%m/%d/%Y'), is_cancelled='"+is_cancelled+"' WHERE order_id='"+order_id+"' ";
			statement = conn.prepareStatement(sql);
			statement.executeUpdate(sql);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Transaction> getAllTransactions(String user_id) {
		Connection conn = null;
		PreparedStatement statement  = null;
		List<Transaction> orderList = new ArrayList<Transaction>();

		try {

			conn = ConnectionManager.getMySqlConnection();
			String sql = "SELECT * FROM order_transaction WHERE user_id= '"+ user_id +"'";
			statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Transaction t = new Transaction();
				t.setOrder_id(String.valueOf(rs.getInt(1)));
				t.setUser_id(rs.getString(2));
				t.setAddress_id(String.valueOf(rs.getInt(3)));
				t.setPayment_id(String.valueOf(rs.getInt(4)));
				t.setOrder_placed_timestamp(rs.getDate(5).toString());
				String updateTimestamp = rs.getDate(6) != null ? rs.getDate(6).toString() : Constants.EMPTY_STRING;
				t.setOrder_updated_timestamp(updateTimestamp);
				String cancelledFlag = rs.getString(7) != null ? rs.getString(7) : Constants.EMPTY_STRING;
				t.setIs_cancelled(""+cancelledFlag);
				orderList.add(t);
			}
			
			return orderList;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
