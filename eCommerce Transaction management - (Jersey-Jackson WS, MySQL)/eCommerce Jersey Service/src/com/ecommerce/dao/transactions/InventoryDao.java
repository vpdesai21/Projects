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
import java.text.SimpleDateFormat;
import java.util.Date;

public class InventoryDao {
	public int getInventory(String product_id) {
		Connection conn = null;
		PreparedStatement statement  = null;
		int product_count = 0;
		
		try {
					
			conn = ConnectionManager.getMySqlConnection();
			String sql = "SELECT product_count FROM product_inventory WHERE product_id='"+ product_id + "'";
			statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				product_count = rs.getInt(Constants.PRODUCT_COUNT);
			}
			
			if(product_count > 0)
				return product_count;
			else
				return -1;
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public boolean updateInventory(String product_id, String product_count) {
		Connection conn = null;
		PreparedStatement statement  = null;
		
		try {		
			conn = ConnectionManager.getMySqlConnection();
			String sql = "UPDATE product_inventory SET product_count="+ product_count + " WHERE product_id='"+ product_id + "'";
			statement = conn.prepareStatement(sql);
			statement.executeUpdate(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isProductAvailable(String productId) {
		try {
			Mongo mongo = ConnectionManager.getMongoConnection();
			DB ecommerceDB = mongo.getDB("sampleProject");
			DBCollection products = ecommerceDB.getCollection("products");
			
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("productId", productId);
			
			DBCursor cursor = products.find(whereQuery);
			if(cursor.hasNext()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isWithinDateRange(String productId) {
		try {
			Mongo mongo = ConnectionManager.getMongoConnection();
			DB ecommerceDB = mongo.getDB("sampleProject");
			DBCollection products = ecommerceDB.getCollection("products");
			
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("productId", productId);
			
			String startDate = "";
			String endDate = "";
			
			DBCursor cursor = products.find(whereQuery);
			if(cursor.hasNext()) {
				DBObject dbo = cursor.next();
				startDate = (String)dbo.get("startDate");
				endDate = (String)dbo.get("endDate");
			}
			
			SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
			
			Date sd = format1.parse(startDate);
			Date ed = format1.parse(endDate);
			Date today = new Date();
			
			long diff1 = today.getTime() - sd.getTime();
			long diff2 = ed.getTime() - today.getTime();
			
			if(diff1>=0 && diff2>=0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
