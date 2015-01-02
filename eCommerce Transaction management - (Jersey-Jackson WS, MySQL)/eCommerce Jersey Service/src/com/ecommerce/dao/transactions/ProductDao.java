package com.ecommerce.dao.transactions;

import com.ecommerce.constants.Constants;
import com.ecommerce.util.ConnectionManager;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDao {

	public boolean saveProductToTransaction(String order_id, String product_id, String product_quantity) {
		Connection conn = null;
		PreparedStatement statement  = null;
		
		try {
					
			conn = ConnectionManager.getMySqlConnection();
			String sql = "INSERT INTO order_to_product(order_id, product_id, product_quantity) "+
							"VALUES( '"+ order_id + "', '"+ product_id + "', "+ product_quantity + " ) ";
			statement = conn.prepareStatement(sql);
			statement.executeUpdate(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getProductDetails(String order_id) {
		Connection conn = null;
		PreparedStatement statement  = null;
		String product_id = null;
		String productName = null;

		Mongo mongo = null;
		
		try {
					
			conn = ConnectionManager.getMySqlConnection();
			String sql = "SELECT product_id FROM order_to_product WHERE order_id='"+order_id+"'";
			statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next())
				product_id = rs.getString(1);
			
			if(product_id != null) {
				mongo = ConnectionManager.getMongoConnection();
				DB ecommerceDB = mongo.getDB("sampleProject");
				DBCollection products = ecommerceDB.getCollection("products");

				BasicDBObject whereQuery = new BasicDBObject();
				whereQuery.put("productId", product_id);

				DBCursor cursor = products.find(whereQuery);
				if(cursor.hasNext()) {
					DBObject dbo = cursor.next();
					productName = (String)dbo.get("productName");
				}
			}
			return productName;
			
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.EMPTY_STRING;
		}
	}

	public String getProductCount(String order_id) {
		Connection conn = null;
		PreparedStatement statement  = null;
		String product_quantity = null;
		try {
					
			conn = ConnectionManager.getMySqlConnection();
			String sql = "SELECT product_quantity FROM order_to_product WHERE order_id='"+order_id+"'";
			statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next())
				product_quantity = rs.getString(1);
			
			return product_quantity;
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.EMPTY_STRING;
		}
	}
	
	
	public String getProductId(String order_id) {
		Connection conn = null;
		PreparedStatement statement  = null;
		String product_id = null;
		
		try {
					
			conn = ConnectionManager.getMySqlConnection();
			String sql = "SELECT product_id FROM order_to_product WHERE order_id='"+order_id+"'";
			statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next())
				product_id = rs.getString(1);
			
			if(product_id != null) {
				return product_id;
			}
			return Constants.EMPTY_STRING;
			
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.EMPTY_STRING;
		}
	}
	
	
}
