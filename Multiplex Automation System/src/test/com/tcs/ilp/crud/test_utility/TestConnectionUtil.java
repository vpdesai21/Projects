package test.com.tcs.ilp.crud.test_utility;

import java.sql.Connection;

import org.apache.log4j.Logger;


import com.tcs.ilp.crud.utility.ConnectionUtil;

public class TestConnectionUtil {
	
	public static final Logger logger = Logger.getLogger(TestConnectionUtil.class);

	public static void main(String[] args) {
		
		Connection conn = null;
		
		conn = ConnectionUtil.getConnection();
		
		if(conn!=null)
		{
			logger.debug("\n Test Case : Success \n Connection to database established  . . \n ");
			logger.debug("\n Connection Details . . \n ");
			
			ConnectionUtil.displayDetails();
		}
		else
		{
			logger.debug("\n Test Case : Failed \n Connection to database failed . .\n  ");
		}
			
		
		if(conn!=null)
			ConnectionUtil.closeConnection(conn);
		
		
	}

}
