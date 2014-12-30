package com.tcs.ilp.crud.utility;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;
/**
* Creates connection to database
      * @author-vishwa(588649)     
      * @version-1.0      
      * @Class ConnectionUtil
      * @Creation 7/8/2012
    
*/

public class ConnectionUtil {
	
	public static final Logger logger = Logger.getLogger(ConnectionUtil.class);
	
	private static String driverName ;
	private static String url ;
	@SuppressWarnings("unused")
	private static String ipAddress;
	@SuppressWarnings("unused")
	private static int port;
	@SuppressWarnings("unused")
	private static String schema ;
	private static String userName ;
	private static String password ;
	
	/**
	 *  @author-vishwa(588649) 
	 * 	This method initialized driverName,url,ipAdress,schema,userName,
	 * password with help of db.properties
	 * 
	 */
	
	
	public static void initDatabaseConnection()
	{
		ConnectionUtil c = new ConnectionUtil();
		Properties prop = new Properties();
		
		try
		{
		InputStream input = c.getClass().getResourceAsStream("/db.properties");
		prop.load(input);
		
		driverName = prop.getProperty("driverName"); 
		url = prop.getProperty("url");
		ipAddress = prop.getProperty("ipAddress"); 
		port = Integer.parseInt(prop.getProperty("port"));
		schema = prop.getProperty("schema");
		userName = prop.getProperty("userName");
		password = prop.getProperty("password");
		
		}
		catch(IOException e)
		{
			logger.error("IOException in ConnectionUtil initDatabseConnection . . ");
		}
		
		
		
	}
	
	/*
	 *  @author-vishwa(588649)
	 *  This establish connection with database
	 * */
	
	public static Connection getConnection()
	{
		initDatabaseConnection();
		Connection conn = null;
		try
		{
			Class.forName(driverName);
			conn = DriverManager.getConnection(url , userName , password);		
		}
		catch(ClassNotFoundException e)
		{
			logger.error("Class not found Exception  in ConnectionUtil connectToDatabase. . ");
		}
		catch(SQLException e)
		{
			logger.error("SQL Exception in ConnectionUtil connectToDatabase. . ");
		}
		catch(Exception e)
		{
			logger.error("Exception  in ConnectionUtil  connectToDatabase. . ");
		}
	return conn;
		
	}
	
	/*
	 *  @author-vishwa(588649)
	 *  This method closes the database connection
	 *  
	 *  @param con
	 * */
	
	public static void closeConnection(Connection con)
	{
		try
		{	
				con.close();
		}
		catch(SQLException e)
		{
			logger.error("SQL Exception in ConnectionUtil  disConnect. . ");
		}
		catch(Exception e)
		{
			logger.error("Exception in ConnectionUtil disConnect . . ");
		}
	}
	
	/*
	 *  @author-vishwa(588649)
	 *  It displays driver name, user name and password
	 * */
	
	public static void displayDetails()
	{
		logger.info("\n DRIVER NAME : "+driverName+"\n URL : "+url+"\n USERNAME : "+userName+"\n PASSWORD : "+password);
	}
	
	
	
}

//=======================End Of ConnectionUtil Class==================
