package com.tcs.ilp.crud.dao;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;



import com.tcs.ilp.crud.beans.NewsAndEvents;
import com.tcs.ilp.crud.utility.Constants;
import com.tcs.ilp.crud.utility.ConnectionUtil;




 

/**
 * This class is written for connecting with the database and to perform
 * the CRUD operations.
 * @version 1.0
 * @creation 13/08/2012
 *
 */
public class NewsAndEventsDao  {

	
	static final Logger logger=Logger.getLogger(NewsAndEventsDao.class);
	
	public ArrayList<NewsAndEvents> newsAndEventList;
	
	NewsAndEvents newsAndEvents;
	
	
	/** This method is written to addNewsAndEvents of 
	 *  NewsAndEventsDao class which takes reference of NewsAndEvents Bean class
	 *  as input and returns whether the NewsAndEvents is added successfully
	 *  via a boolean value .
	 *    
	 *  (true = success , false = failure )
	 * 
	 * @author Vishwa Desai(588649)
	 * @throws SQLException, IOException
	 * @return boolean isSuccess
	 *
	 */
    public boolean addNewsAndEvents(NewsAndEvents newsAndEvents) throws SQLException, IOException {
    	Connection con=null;
    	PreparedStatement pst=null;
 
    	boolean isSuccess= false;
    	
    
		
    	try
    	{   
    		con = ConnectionUtil.getConnection();
    		con.setAutoCommit(false);
    		
    		String sql = "INSERT INTO TBL_GROUP_C_EVENT_NEWS VALUES (?, ?, TO_DATE(?,'MM/DD/YYYY HH24:MI:SS'), ?, ?)";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, newsAndEvents.getEventNewsId());
			pst.setString(2, newsAndEvents.getEventNewsName());
			pst.setString(3, newsAndEvents.getEventDateTime());
			pst.setString(4, newsAndEvents.getEventImage());
			pst.setString(5, newsAndEvents.getEventNewsDescription());
			
			pst.executeUpdate();
			con.commit();
			
			isSuccess=true;
    	}
		catch(SQLException e)
		{
			logger.error("SQLException in NewsAndEventsDao addNewsAndEvents . . .");
			throw e;
		}
		catch(NullPointerException e)
		{
			logger.error("NullPointerException in NewsAndEventsDao addNewsAndEvents . . .");
			throw e;
		}
		catch(Exception e)
		{
			logger.error("Exception in NewsAndEventsDao addNewsAndEvents . . .");
		}
		finally
		{
		
			pst.close();
			ConnectionUtil.closeConnection(con);
		}
		
		return isSuccess;
    }
    
  //*********add news and events method ends*************
    
    

    /**
     * This method gets a particular news and event record from the database.
	 * The News and Events ID is passed as parameter to the method.
	 * The output is that the method returns particular news and event record.
     * 
	 * @author Sankalp Mohanty(676110)
	 * @return NewsAndEvents newsAndEvents
	 * @throws SQLException
	 * 
	 *
	 *
	 */
	public NewsAndEvents getNewsAndEvents(String tempEventsNewsId) throws SQLException {

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		
				
		try {
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql = "SELECT "+Constants.E_N_ID+","+Constants.E_N_NAME+",TO_CHAR("+Constants.E_DATE_TIME+",'MM/DD/YYYY HH24:MI:SS') AS EVENT_DATE_TIME,"+Constants.E_IMAGE+","+Constants.E_N_DESCRIPTION+" FROM TBL_GROUP_C_EVENT_NEWS WHERE EVENT_NEWS_ID=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, tempEventsNewsId);

			rs = pst.executeQuery();
			
			if (rs.next()) {
				String eventNewsId = rs.getString(Constants.E_N_ID);
				String eventNewsName = rs.getString(Constants.E_N_NAME);
				String eventDateTime = rs.getString(Constants.E_DATE_TIME);
				String eventImageLocation =  rs.getString(Constants.E_IMAGE);
				String eventNewsDescription = rs.getString(Constants.E_N_DESCRIPTION);
				
			
				newsAndEvents = new NewsAndEvents();
				newsAndEvents.setEventNewsId(eventNewsId);
				newsAndEvents.setEventNewsName(eventNewsName);
				newsAndEvents.setEventDateTime(eventDateTime);
				newsAndEvents.setEventImage(eventImageLocation);
				newsAndEvents.setEventNewsDescription(eventNewsDescription);
				
				con.commit();
			}
		}
		catch(SQLException e)
		{
			logger.error("SQLException in NewsAndEventsDao getNewsAndEvents . . .");
			throw e;
		}
		catch(NullPointerException e)
		{
			logger.error("NullPointerException in NewsAndEventsDao getNewsAndEvents . . .");
			throw e;
		}
		catch(Exception e)
		{
			logger.error("Exception in NewsAndEventsDao getNewsAndEvents . . ."+e);
		}
		finally
		{
			rs.close();
			pst.close();
			ConnectionUtil.closeConnection(con);
		}

		return newsAndEvents ;
	}
	
	//*********get news and events method ends*************

	
	
	
	
	
	/**
	 * This method gets all news and event records from the database.
	 * The output is that the method returns an arraylist of news and events.
	 *
	 * @author Sankalp Mohanty(676110)
	 * @return List of all News And Events
	 * @throws SQLException
	 * 
	 *
	 */

	public ArrayList<NewsAndEvents> getAllNewsAndEvents() throws SQLException {
	
		newsAndEventList = new ArrayList<NewsAndEvents>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT "+Constants.E_N_ID+","+Constants.E_N_NAME+",TO_CHAR("+Constants.E_DATE_TIME+",'MM/DD/YYYY') AS EVENT_DATE_TIME,"+Constants.E_IMAGE+","+Constants.E_N_DESCRIPTION+" FROM TBL_GROUP_C_EVENT_NEWS";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				String eventNewsId = rs.getString(Constants.E_N_ID);
				String eventNewsName = rs.getString(Constants.E_N_NAME);
				String eventDateTime = rs.getString(Constants.E_DATE_TIME);
				String eventImageLocation =  rs.getString(Constants.E_IMAGE);
				String eventNewsDescription = rs.getString(Constants.E_N_DESCRIPTION);
				
			
				newsAndEvents = new NewsAndEvents();
				newsAndEvents.setEventNewsId(eventNewsId);
				newsAndEvents.setEventNewsName(eventNewsName);
				newsAndEvents.setEventDateTime(eventDateTime);
				newsAndEvents.setEventImage(eventImageLocation);
				newsAndEvents.setEventNewsDescription(eventNewsDescription);

				newsAndEventList.add(newsAndEvents);
			}
		}
		catch(SQLException e)
		{
			logger.error("SQLException in NewsAndEventsDao getAllNewsAndEvents . . .");
			throw(e);
		}
		catch(NullPointerException e)
		{
			logger.error("NullPointerException in NewsAndEventsDao getAllNewsAndEvents . . .");
			throw e;
		}
		catch(Exception e)
		{
			logger.error("Exception in NewsAndEventsDao getAllNewsAndEvents . . .");
		}
		finally
		{
			rs.close();
			pst.close();
			ConnectionUtil.closeConnection(con);
		}
	
		return newsAndEventList; 
      }
	

	//*********get all news and events method ends*************
	
	
	
	
	
	/**
	 * This method gets  news and event records from the database of a particular Date.
	 * The output is that the method returns an arraylist of news and events.
	 *
	 * @author Sankalp Mohanty(676110)
	 * @return ArrayList<NewsAndEvents> newsAndEventList
	 * @throws SQLException
	 * 
	 *
	 *
	 */

	public ArrayList<NewsAndEvents> getAllNewsAndEvents(String tempDate) throws SQLException {
	
		newsAndEventList = new ArrayList<NewsAndEvents>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT "+Constants.E_N_ID+","+Constants.E_N_NAME+",TO_CHAR("+Constants.E_DATE_TIME+",'MM/DD/YYYY') AS "+Constants.E_DATE_TIME+","+Constants.E_IMAGE+","+Constants.E_N_DESCRIPTION+" FROM TBL_GROUP_C_EVENT_NEWS WHERE TO_CHAR("+Constants.E_DATE_TIME+",'MM/DD/YYYY') =? ";
			pst = con.prepareStatement(sql);
			pst.setString(1,tempDate);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String eventNewsId = rs.getString(Constants.E_N_ID);
				String eventNewsName = rs.getString(Constants.E_N_NAME);
				String eventDateTime = rs.getString(Constants.E_DATE_TIME);
				String eventImageLocation =  rs.getString(Constants.E_IMAGE);
				String eventNewsDescription = rs.getString(Constants.E_N_DESCRIPTION);
				
			
				newsAndEvents = new NewsAndEvents();
				newsAndEvents.setEventNewsId(eventNewsId);
				newsAndEvents.setEventNewsName(eventNewsName);
				newsAndEvents.setEventDateTime(eventDateTime);
				newsAndEvents.setEventImage(eventImageLocation);
				newsAndEvents.setEventNewsDescription(eventNewsDescription);
				
				
				newsAndEventList.add(newsAndEvents);
			}
		}
		catch(SQLException e)
		{
			logger.error("SQLException in NewsAndEventsDao getAllNewsAndEvents . . .");
			throw(e);
		}
		catch(NullPointerException e)
		{
			logger.error("NullPointerException in NewsAndEventsDao getAllNewsAndEvents . . .");
			throw e;
		}
		catch(Exception e)
		{
			logger.error("Exception in NewsAndEventsDao getAllNewsAndEvents . . .");
		}
		finally
		{
			ConnectionUtil.closeConnection(con);
		}
	
		return newsAndEventList; 
      }
	

	//*********get all news and events method ends*************
	
	

	 
			
	
	/***
	 * This method updates a particular news and event record in the database.
	 * The News and Events bean object is passed as parameter to the method.
	 * The output is that the method returns a int value
	 * specifying if the number of records updated.
	 * 
	 * @author Vishwa Desai(588649)
	 * @param NewsAndEvents newsAndEvents
	 * @return int noOfRecords
	 * @throws SQLException,FileNotFoundException
	 * 
	 * 
	 */
	public int updateNewsAndEvents(NewsAndEvents newsAndEvents) throws SQLException,FileNotFoundException
	{
		Connection con = null;
		PreparedStatement pSt = null;
		int noOfRecords = 0;
		
		try
		{
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			
			pSt = con.prepareStatement("UPDATE TBL_GROUP_C_EVENT_NEWS SET "+Constants.E_N_NAME+"=? , "+Constants.E_DATE_TIME+"=TO_DATE(?,'MM/DD/YYYY HH24:MI') , "+Constants.E_IMAGE+"=? , "+Constants.E_N_DESCRIPTION+"=? WHERE "+Constants.E_N_ID+"=?");
			
			
			pSt.setString(1, newsAndEvents.getEventNewsName());
			pSt.setString(2, newsAndEvents.getEventDateTime());
			pSt.setString(3, newsAndEvents.getEventImage());
			pSt.setString(4, newsAndEvents.getEventNewsDescription());
			pSt.setString(5, newsAndEvents.getEventNewsId());
			
			noOfRecords = pSt.executeUpdate();
			
			con.commit();
		}
		catch(SQLException e)
		{
			logger.error("SQLException in NewsAndEventsDao updateNewsAndEvents  . . .");
			throw e;
		}
		catch(NullPointerException e)
		{
			logger.error("NullPointerException in NewsAndEventsDao updateNewsAndEvents . . .");
			throw e;
		}
		catch(Exception e)
		{
			logger.error("Exception in NewsAndEventsDao updateNewsAndEvents . . .");
		}
		finally
		{
		
			pSt.close();
			ConnectionUtil.closeConnection(con);
		}
	
	return noOfRecords;
		
	}
	//*********update news and events method ends*************
	
	

	/**
	 * This method deletes a particular news and event record from the database.
	 *
	 * The News and Events id is passed as parameter to the method.
	 *
	 * The output is that the method returns a boolean value
	 * specifying if the deletion is successful or not.
	 *
	 *(true - success , false - failure )
	 * 
	 * @author Sangeet Mishra(675067)
	 * @throws SQLException , ClassNotFoundException 
	 * @return boolean isSuccess
	 * 
	 */

	public boolean deleteNewsAndEvents(String eventNewsId) throws ClassNotFoundException, SQLException
	{
		Connection con=null;
		PreparedStatement pst=null;
		boolean isSuccess= false;
		
	
		try
		{
			con=ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			
			pst=con.prepareStatement("DELETE FROM TBL_GROUP_C_EVENT_NEWS WHERE "+Constants.E_N_ID+"=?");
			pst.setString(1, eventNewsId);
			
			int i = pst.executeUpdate();
		
			if(i!=0)
			{
			con.commit();
			isSuccess=true;
			}
			
		}
		catch(SQLException e)
		{
			logger.error("SQLException in NewsAndEventsDao deleteNewsAndEvents . . .");
			throw(e);
		}
		catch(NullPointerException e)
		{
			logger.error("NullPointerException in NewsAndEventsDao deleteNewsAndEvents. . .");
			throw e;
		}
		catch(Exception e)
		{
			logger.error("Exception in NewsAndEventsDao deleteNewsAndEvents . . .");
		}
		finally
		{
			
			pst.close();
			ConnectionUtil.closeConnection(con);
		}
		return isSuccess;
		}
	
	//*********delete news and events method ends*************
	
	
	
	/**
	 * This method returns a list of  distinct dates of all news or events. 
	 * 
	 * @author Vishwa Desai(588649)
	 * @return ArrayList<String> dateList
	 * @throws SQLException
	 */
	public ArrayList<String> getAllDates() throws SQLException
	{
		
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs = null;
	ArrayList<String> dateList = new ArrayList<String>();
	
		try
		{
			con=ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			
			pst=con.prepareStatement("SELECT DISTINCT(TO_CHAR("+Constants.E_DATE_TIME+",'MM/DD/YYYY')) AS EVENT_DATE FROM TBL_GROUP_C_EVENT_NEWS ");
		
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				String temp = rs.getString("EVENT_DATE");
				
				dateList.add(temp);
			}
			
			
		}
		catch(SQLException e)
		{
			logger.error("SQLException in NewsAndEventsDao getAllDates . . .");
			throw e;
		}
		catch(NullPointerException e)
		{
			logger.error("NullPointerException in NewsAndEventsDao getAllDates. . .");
			throw e;
		}
		catch(Exception e)
		{
			logger.error("Exception in NewsAndEventsDao getAllDates . . .");
		}
		finally
		{
			rs.close();
			pst.close();
			ConnectionUtil.closeConnection(con);
		}
	
	return dateList;
	}

	//*********getAllDates method ends*************
	
	
	
	/**
	 * This method auto generates ID for record entered by the admin/user .
	 * 
	 * @author Vishwa Desai(588649)
	 * @return String eventNewsId
	 * @throws SQLException
	 * 
	*/
	
	
	public String generateId() throws SQLException
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String eventNewsId=null; 
		String t = null;
		
		try 
		{
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			
			String sql = "SELECT "+Constants.E_N_ID+" FROM TBL_GROUP_C_EVENT_NEWS ";
			pst = con.prepareStatement(sql);
			

			rs = pst.executeQuery();
			
			String max = "NE_ID_0";
			
			
			while(rs.next())
			{
				t = rs.getString(Constants.E_N_ID);
				
				if(max.length() < t.length())
				{
					max=t;					
				}
				else if( max.length()== t.length() && max.compareTo(t) < 0)
				{
					max = t;
				}
			}
			
			
			
					String temp = max.substring(6,max.length());
					int cnt = Integer.parseInt(temp);
					cnt++;
					eventNewsId = "NE_ID_"+cnt;
					
				
			
			con.commit();
			
		}
		catch(SQLException e)
		{
			logger.error("SQLException in NewsAndEventsDao generateId . . .");
			throw e;
		}
		catch(NullPointerException e)
		{
			logger.error("NullPointerException in NewsAndEventsDao generateId . . .");
			throw e;
		}
		catch(Exception e)
		{
			logger.error("Exception in NewsAndEventsDao generateId . . .");
		}
		finally
		{
			rs.close();
			pst.close();
			ConnectionUtil.closeConnection(con);
		}

		return eventNewsId ;
	}
	
	//*********generateId method ends*************
	

	
	
	
	
}