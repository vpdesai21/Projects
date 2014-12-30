package com.tcs.ilp.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.tcs.ilp.crud.beans.CustomerReward;
import com.tcs.ilp.crud.utility.ConnectionUtil;
import com.tcs.ilp.crud.utility.Constants;
/**
*  Class CustomerRewardsDao - Connects to Database & performs operations
      * @author - Prantik(676339)   
      * @version  - 1.0    
      * @Class CustomerRewardsDao
      * @Creation - 7-8-2012
*/
public class CustomerRewardsDao 
{
public static final Logger logger=Logger.getLogger(CustomerRewardsDao.class);

/**
 * @Author - Prantik(676339)
 * This method connects to the database & retrieves the records of a particular customer regarding 
 * rewardPoints
 * 
 * @param customerId
 * @return
 */
	

public CustomerReward getCustomerReward(String customerId)
		{
			Connection conn=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			CustomerReward customerReward=null;
			try
			{
				conn=ConnectionUtil.getConnection();
				String query="SELECT * FROM "+Constants.CUSTOMER_REWARD+" WHERE "+Constants.C_ID+"=?";
				pst=conn.prepareStatement(query);
				pst.setString(1,customerId);	
				rs=pst.executeQuery();
				while(rs.next())
				{
					customerId=rs.getString(Constants.C_ID);
					String customerRewardId=rs.getString(Constants.C_R_ID);
					int rewardPointsBalance=rs.getInt(Constants.R_P_BALANCE);
					int carryAmount=rs.getInt(Constants.C_AMOUNT);
					String flagMoviePrice=rs.getString(Constants.FLAG_PRICE);
					String flagSnacks=rs.getString(Constants.FLAG_SNACKS);
					
					customerReward=new CustomerReward();
					customerReward.setCarryAmount(carryAmount);
					customerReward.setCustomerId(customerId);
					customerReward.setCustomerRewardId(customerRewardId);
					customerReward.setFlagMoviePrice(flagMoviePrice);
					customerReward.setFlagSnacks(flagSnacks);
					customerReward.setRewardPointsBalance(rewardPointsBalance);
					
				}
			}
			catch(SQLException se)
			{
				se.printStackTrace();
				logger.error("Exception Occurred"+se);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					if (pst != null)
						pst.close();
					if (rs != null)
						rs.close();
					if (conn != null)
						ConnectionUtil.closeConnection(conn);
				} 
				catch (SQLException se) 
				{
					se.printStackTrace();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			return customerReward;
		}

/**
 * @Author - Prantik(676339)
 * This method connects to the database & retrieves all the records of customers 
 * regarding rewardPoints
 * 
 * @return ArrayList<CustomerReward>
 */

	public ArrayList<CustomerReward> getAllCustomerReward()
	{
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		CustomerReward customerReward=null;
		ArrayList<CustomerReward> customerRewardList=new ArrayList<CustomerReward>();
		try
		{
			conn=ConnectionUtil.getConnection();
			String query="SELECT * FROM "+Constants.CUSTOMER_REWARD+" ORDER BY "+Constants.C_R_ID;
			pst=conn.prepareStatement(query);	
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				String customerId=rs.getString(Constants.C_ID);
				String customerRewardId=rs.getString(Constants.C_R_ID);
				int rewardPointsBalance=rs.getInt(Constants.R_P_BALANCE);
				int carryAmount=rs.getInt(Constants.C_AMOUNT);
				String flagMoviePrice=rs.getString(Constants.FLAG_PRICE);
				String flagSnacks=rs.getString(Constants.FLAG_SNACKS);
					
				customerReward=new CustomerReward();
				customerReward.setCarryAmount(carryAmount);
				customerReward.setCustomerId(customerId);
				customerReward.setCustomerRewardId(customerRewardId);
				customerReward.setFlagMoviePrice(flagMoviePrice);
				customerReward.setFlagSnacks(flagSnacks);
				customerReward.setRewardPointsBalance(rewardPointsBalance);
				customerRewardList.add(customerReward);
			}
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			logger.error("Exception Occurred"+se);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if (pst != null)
					pst.close();
				if (rs != null)
					rs.close();
				if (conn != null)
					ConnectionUtil.closeConnection(conn);
			} 
			catch (SQLException se) 
			{
				se.printStackTrace();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return customerRewardList;
		
	}

	
	/**
	 *  @Author - Vivek(668543)
	 * This method connects to the database & allocates rewardPoints to a particular customer based
	 *  on his movie booking price
	 * 
	 * @param customerReward
	 * @return
	 */
	
	public int addCustomerReward(CustomerReward customerReward){
		Connection con=null;
		PreparedStatement pst=null;
		con=ConnectionUtil.getConnection();
		int noOfRowsInserted=0;
		CustomerReward cr=getCustomerReward(customerReward.getCustomerId());
		if(cr!=null)
		{
			
		}
		else
		{
			String sq="INSERT INTO "+Constants.CUSTOMER_REWARD+" VALUES(?,?,?,?,?,?)";
			try{
			pst=con.prepareStatement(sq);
			pst.setString(1, generateId());
			pst.setString(2, customerReward.getCustomerId());
			pst.setInt(3, customerReward.getRewardPointsBalance());
			pst.setInt(4, customerReward.getCarryAmount());
			pst.setString(5, customerReward.getFlagMoviePrice());
			pst.setString(6,customerReward.getFlagSnacks());
			
			
			noOfRowsInserted=pst.executeUpdate();
			}
			catch (SQLException se) {
				se.printStackTrace();
				logger.error("Exception have occured " + se);
				
			}		
			finally{
				try {
					if (pst != null)
						pst.close();
					if (con != null)
						ConnectionUtil.closeConnection(con);
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return noOfRowsInserted;
	}
	/**
	 * @Author - Vivek(668543)
	 * This method connects to the database & updates the allocation of rewardPoints to a particular customer 
	 * based on his movie booking price
	 * 
	 * @param customerReward
	 * @return updateCustomerReward
	 */
	
	public int updateCustomerReward(CustomerReward customerReward){
		Connection con=null;
		PreparedStatement pst=null;
		con=ConnectionUtil.getConnection();
		int noOfRowsUpdated=0;
		String sql="UPDATE "+Constants.CUSTOMER_REWARD +" SET "+Constants.R_P_BALANCE+"=?,"+Constants.C_AMOUNT+"=?,"+Constants.FLAG_PRICE+"=?,"+Constants.FLAG_SNACKS+"=? WHERE "+Constants.C_ID+"=?";
		try{
			pst=con.prepareStatement(sql);
			
			pst.setInt(1, customerReward.getRewardPointsBalance());
			pst.setInt(2, customerReward.getCarryAmount());
			pst.setString(3, customerReward.getFlagMoviePrice());
			pst.setString(4, customerReward.getFlagSnacks());
			pst.setString(5, customerReward.getCustomerId());
			
			
			
			noOfRowsUpdated=pst.executeUpdate();
		}
		catch (SQLException se) {
			se.printStackTrace();
			logger.error("Exception have occured " + se);
			
		}		
		finally{
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					ConnectionUtil.closeConnection(con);
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return noOfRowsUpdated;
	}
	
	/**
	 *  @Author - Vivek(668543)
	 * This method connects to the database & adds the 
	 * auto-generated CustomerReward Id to a record
	 * 
	 * @return String<generated id>
	 */
	

	
	
	public String generateId()
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String customerRewardId=null; 
		
		try 
		{
			con = ConnectionUtil.getConnection();
			
			String sql = "SELECT "+Constants.C_R_ID+" AS CRID FROM "+Constants.CUSTOMER_REWARD ;
			pst = con.prepareStatement(sql);
			
			String t=null;
			rs = pst.executeQuery();
			customerRewardId = "CRID0";
				
				while(rs.next()){
					t= rs.getString(1);
					if(t.length()>customerRewardId.length())
					{
						customerRewardId=t;
					}
					else if(t.length()==customerRewardId.length() && t.compareTo(customerRewardId)>0)
					{
						customerRewardId=t;
					}
				}
			
							
					String temp =customerRewardId.substring(4,customerRewardId.length());
					int cnt = Integer.parseInt(temp);
					cnt++;
					customerRewardId = "CRID"+cnt;
		
		
			
		}
		catch(SQLException e)
		{
			logger.error("SQLException in RewardPointsDao generateId . . .");
		}
		catch(NullPointerException e)
		{
			logger.error("NullPointerException in RewardPointsDao generateId . . .");
		}
		catch(Exception e)
		{
			logger.error("Exception in RewardPointsDao generateId . . .");
		}
		finally
		{
			ConnectionUtil.closeConnection(con);
		}

		return customerRewardId ;
	}
	
	
	
	/**
	 *  @Author - Vivek(668543)
	 * This method connects to the database & retrieves the records of a particular customer regarding last 
	 * movie booking price
	 * 
	 * @param customerId
	 * @return int<total price>
	 */
	
	public int getLastBookingPrice(String customerId){
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		int totalPrice=0;
		String sql="SELECT TOTAL_PRICE FROM TBL_GROUPB_MOVIE_BOOKING WHERE USER_ID=?";
		try {
			conn=ConnectionUtil.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, customerId);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				totalPrice=rs.getInt(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalPrice;
	}
}
