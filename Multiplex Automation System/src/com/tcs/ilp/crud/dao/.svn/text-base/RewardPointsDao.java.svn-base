package com.tcs.ilp.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.tcs.ilp.crud.utility.Constants;
import com.tcs.ilp.crud.utility.RewardAllocationRangeAlreadyExists;
import com.tcs.ilp.crud.beans.RewardPoints;
import com.tcs.ilp.crud.utility.ConnectionUtil;

/**
* RewardPointsDao Class - Connects to Database & performs operations
      * @author - Vivek   
      * @version  - 1.0    
      * @Class RewardPointsDao
      * @Creation - 7-8-2012
*/
public class RewardPointsDao {	
	public static final Logger logger = Logger.getLogger(RewardPointsDao.class);

	/**
	 * @Author - Vivek(668543) & Sonali(675528)
	 * This method connects to the database & adds
	 *  a records of reward point detail
	 * 
	 * @param rewardPoints
	 * @return int<no of rows added>
	 * @throws RewardAllocationRangeAlreadyExists 
	 */
	
	public int addRewardPoints(RewardPoints rewardPoints) throws RewardAllocationRangeAlreadyExists  
	{
		Connection con=null;
		
		PreparedStatement pst=null;
		ResultSet rs=null;
		con=ConnectionUtil.getConnection();
		int noOfRowsInserted=0;
			String s="SELECT * FROM "+Constants.REWARD_POINTS+" WHERE "+Constants.S_RANGE+"=?";
			
			String sq="INSERT INTO "+Constants.REWARD_POINTS+" VALUES(?,?,?,?) ";
			try{
				pst=con.prepareStatement(s);
				pst.setInt(1,rewardPoints.getStartRange());
				rs=pst.executeQuery();
				
				if(!rs.next()){
					pst=con.prepareStatement(sq);
					pst.setString(1, generateId());
					pst.setInt(2, rewardPoints.getStartRange());
					pst.setInt(3, rewardPoints.getEndRange());
					pst.setInt(4, rewardPoints.getRewardPoints());
					noOfRowsInserted=pst.executeUpdate();
				}
				else{
					throw new RewardAllocationRangeAlreadyExists();
				}
				
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
		
		return noOfRowsInserted;
	}
	
	/**
	 *  @Author - Vivek(668543) & Sonali(675528)
	 * This method connects to the database & updates a record of a particular
	 *  reward point detail from the reward Id
	 * 
	 * @param rewardPoints
	 * @return int<no of rows updated>
	 */
	 
	public int updateRewardPoints(RewardPoints rewardPoints) 
	{
		Connection con=null;
		PreparedStatement pst=null;
	
		con=ConnectionUtil.getConnection();
		int noOfRowsUpdated=0;
		String sq="UPDATE "+Constants.REWARD_POINTS+" SET "+Constants.S_RANGE+"=?,"+Constants.E_RANGE+"=?,"+Constants.R_POINTS+"=? WHERE "+Constants.R_ID+"=?";
		try
		{
		pst=con.prepareStatement(sq);
		pst.setInt(1,rewardPoints.getStartRange());
		pst.setInt(2,rewardPoints.getEndRange());
		pst.setInt(3, rewardPoints.getRewardPoints());
		pst.setString(4, rewardPoints.getRewardId());
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
	 *  @Author - Vivek(668543) & Sonali(675528)
	 * This method connects to the database & retrieves 
	 * the records of a particular reward point detail from the reward Id
	 * 
	 * @param rewardId
	 * @return RewardPoints<reward detail for particular list>
	 */

	public RewardPoints viewRewardPoints(String rewardId)
	{
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		RewardPoints rewardPoints1=null;
		con=ConnectionUtil.getConnection();
		String sq="SELECT * FROM "+Constants.REWARD_POINTS+" WHERE "+Constants.R_ID+"=?";
		try{
		pst=con.prepareStatement(sq);
		pst.setString(1,rewardId);
		rs=pst.executeQuery();
		while(rs.next())
		{
			rewardPoints1=new RewardPoints();
			rewardPoints1.setRewardId(rs.getString(1));
			rewardPoints1.setStartRange(rs.getInt(2));
			rewardPoints1.setEndRange(rs.getInt(3));
			rewardPoints1.setRewardPoints(rs.getInt(4));
			
		}
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
		return rewardPoints1;
	}
	
	/**
	 * @Author - Vivek(668543) & Sonali(675528)
	 * This method connects to the database & retrieves 
	 * all the records of reward points details
	 * 
	 * @return ArrayList<RewardPoints>
	 */
	
	public ArrayList<RewardPoints> viewAllRewardPoints() 
	{
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		RewardPoints rewardPoints1=null;
		ArrayList <RewardPoints> rewardList=new ArrayList<RewardPoints>();
		con=ConnectionUtil.getConnection();
		String sq="SELECT * FROM "+Constants.REWARD_POINTS+" ORDER BY "+Constants.R_POINTS;
		try{
		pst=con.prepareStatement(sq);
		
		rs=pst.executeQuery();
		while(rs.next())
		{
			rewardPoints1=new RewardPoints();
			rewardPoints1.setRewardId(rs.getString(1));
			rewardPoints1.setStartRange(rs.getInt(2));
			rewardPoints1.setEndRange(rs.getInt(3));
			rewardPoints1.setRewardPoints(rs.getInt(4));
			rewardList.add(rewardPoints1);
		}
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
		return rewardList;
	}
	
	/**
	 * @Author - Vivek(668543) & Sonali(675528)
	 * This method connects to the database & deletes
	 *  the record of a particular reward point detail from the reward Id
	 * 
	 * @param rewardId
	 * @return int <no of rows deleted>
	 */

	
	public int deleteRewardPoints(String rewardId)
	{
		int noOfRowsDeleted=0;
		Connection con=null;
		PreparedStatement pst=null;
		con=ConnectionUtil.getConnection();
		String sq="DELETE FROM "+Constants.REWARD_POINTS+" WHERE "+Constants.R_ID+"=?";
		try{
		pst=con.prepareStatement(sq);
		pst.setString(1,rewardId);
		noOfRowsDeleted=pst.executeUpdate();
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
		return noOfRowsDeleted;
	}
	
	/**
	 *  @Author - Vivek(668543)
	 * This method connects to the database & adds 
	 * the auto-generated Reward Id to a record
	 * 
	 * @return String<reward id>
	 */

	public String generateId()
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//int i=0;
		String rewardId=null; 
		
		try 
		{
			con = ConnectionUtil.getConnection();
			
			
			String sql = "SELECT "+Constants.R_ID+" AS RID FROM "+Constants.REWARD_POINTS ;
			pst = con.prepareStatement(sql);
			
			String t=null;
			rs = pst.executeQuery();
			rewardId = "RID0";
				
				while(rs.next()){
					t= rs.getString(1);
					if(t.length()>rewardId.length())
					{
						rewardId=t;
					}
					else if(t.length()==rewardId.length() && t.compareTo(rewardId)>0)
					{
						rewardId=t;
					}
				}
			
							
					String temp =rewardId.substring(3,rewardId.length());
					int cnt = Integer.parseInt(temp);
					cnt++;
					rewardId = "RID"+cnt;
		
	
			
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

		return rewardId ;
	}
}
