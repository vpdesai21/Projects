package test.com.tcs.ilp.crud.test_utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.tcs.ilp.crud.utility.ConnectionUtil;

public class ConnectionUtilTestCase 
{
	public static final Logger logger = Logger.getLogger(ConnectionUtilTestCase.class);
	public static void main(String[] args) {
		
		Connection con=ConnectionUtil.getConnection();
		if(con!=null){
			logger.debug("Connection Successfully established with the Database");
			logger.debug("Test Case passed: ConnectionUtilTestCases");
		}else{
			logger.debug("Connection to the database failed !!");
			logger.debug("Test Case Failed: ConnectionUtilTestCases");
		}
		try{
		Statement st = con.createStatement();

		ResultSet rs=st.executeQuery("SELECT * from TBL_GROUP_C_AMENITIES_TYPE");

		while(rs.next()){
			logger.debug(rs.getString(2));
		}
		}
		catch(Exception e){
			logger.error(e);
		}
	}
}
