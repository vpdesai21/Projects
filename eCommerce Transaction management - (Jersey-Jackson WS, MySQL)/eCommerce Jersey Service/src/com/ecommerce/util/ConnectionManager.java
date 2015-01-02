package com.ecommerce.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.ecommerce.constants.Constants;
import com.mongodb.Mongo;

public class ConnectionManager {

	public static Connection getMySqlConnection() {
		Connection connection = null;
		Properties prop = new Properties();
		String driverName ;
		String url ;
		String ipAddress;
		String schema ;
		String userName ;
		String password ;
		
		try {
			InputStream input = new ConnectionManager().getClass().getResourceAsStream("/com/ecommerce/properties/mysql.properties");
			prop.load(input);
			driverName = prop.getProperty(Constants.MYSQL_DRIVER_NAME); 
			url = prop.getProperty(Constants.MYSQL_URL);
			ipAddress = prop.getProperty(Constants.MYSQL_IP_ADDRESS); 
			schema = prop.getProperty(Constants.MYSQL_SCHEMA);
			userName = prop.getProperty(Constants.MYSQL_USER_NAME);
			password = prop.getProperty(Constants.MYSQL_PASSWORD);
			String connectionString = url + "/" + ipAddress + "/" + schema + "?" + "user=" + userName + "&" + "password=" + password;
			
			Class.forName(driverName);
			connection = DriverManager.getConnection(connectionString);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Mongo getMongoConnection() {
		Mongo mongoClient = null;
		Properties prop = new Properties();
		String ipAddress;
		int port ;
		
		try {
			InputStream input = new ConnectionManager().getClass().getResourceAsStream("/com/ecommerce/properties/mongo.properties");
			prop.load(input);
			ipAddress = prop.getProperty(Constants.MONGO_IP_ADDRESS); 
			port = Integer.parseInt(prop.getProperty(Constants.MONGO_PORT));
			
			mongoClient = new Mongo( ipAddress , port );
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return mongoClient;
	}
	
	

}