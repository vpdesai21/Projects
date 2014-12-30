package com.tcs.ilp.crud.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import com.tcs.ilp.crud.beans.NewsAndEvents;
import com.tcs.ilp.crud.dao.NewsAndEventsDao;




/**
 * This is the service class of NewsAndEvents. Here the business logic
 * is checked and the Controller class is linked to the DAO class.
 * 
 * @version 1.0
 * @creation 13/08/2012
 *
 */
public class NewsAndEventsService {

	private static NewsAndEventsDao newsEventsDao;
	
	
	
	/** This method is written to call the addNewsAndEvents method of 
	 *  NewsAndEventsDao class which takes reference of NewsAndEvents Bean class
	 *  as input and returns whether the NewsAndEvents is added successfully
	 *  via a boolean value .
	 *  (true = success , false = failure )
	 * 
	 * @author Vishwa Desai(588649)
	 * @throws ClassNotFoundException, SQLException, IOException
	 * @return boolean b
	 * 
	 *
	 */
	public boolean addNewsAndEvents(NewsAndEvents newsAndEvents) throws ClassNotFoundException, SQLException, IOException
	{
		newsEventsDao = new NewsAndEventsDao();
		
	//	this.storeImageOnServer(newsAndEvents);
		
		
		boolean b = newsEventsDao.addNewsAndEvents(newsAndEvents);
		return (b);
		
			
	}
	
	
	
	
	/** This method is written to call the deleteNewsAndEvents method of 
	 *  NewsAndEventsDao class which takes NewsAndEventsId
	 *  as input and returns whether the NewsAndEvents is deleted successfully
	 *  via a boolean value .
	 *  (true = success , false = failure )
	 * 
	 * @author Sangeet Mishra(675067)
	 * @throws ClassNotFoundException, SQLException
	 * @return boolean b
	 *
	 *
	 */

	public boolean deleteNewsAndEvents(String eventNewsId) throws ClassNotFoundException, SQLException
	{
		newsEventsDao = new NewsAndEventsDao();
		
		boolean b = newsEventsDao.deleteNewsAndEvents(eventNewsId);
		return (b);
		
			
	}
	
	
	
	/** This method is written to call the updateNewsAndEvents(NewsAndEvents newsAndEvents) method of 
	 *  NewsAndEventsDao class which takes reference of NewsAndEvents Bean class
	 *  as input and returns whether the NewsAndEvents is added successfully
	 *  via a boolean value .
	 *  (true = success , false = failure )
	 * 
	 * @author Vishwa Desai(588649)
	 * @throws SQLException, IOException
	 * @return int noOfRecords
	 *
	 *
	 */
	
	public int updateNewsAndEvents(NewsAndEvents newsAndEvents) throws SQLException, IOException
	{
		newsEventsDao = new NewsAndEventsDao();
		
		//this.updateImageOnServer(newsAndEvents);
		
		
		int noOfRecords = newsEventsDao.updateNewsAndEvents(newsAndEvents);
		
		
		
		return noOfRecords;
		
		
	}
	
	
	
	/** This method is written to call the getNewsAndEvents method of 
	 *  NewsAndEventsDao class which takes as input the newsEventId and
	 *  returns the Bean object of that particular newsEventId.
	 * 
	 * @author Sankalp Mohanty(676110)
	 * @throws SQLException
	 * @return NewsAndEvents newsAndEvent
	 * 
	 *
	 */
	
	public NewsAndEvents getNewsAndEvents(String eventNewsId) throws SQLException
	{

		newsEventsDao = new NewsAndEventsDao();
		NewsAndEvents newsAndEvent = newsEventsDao.getNewsAndEvents(eventNewsId);

		
		return newsAndEvent;
		
	}
	
	
	
	
	/** This method is written to call the getAllNewsAndEvents() method of 
	 *  NewsAndEventsDao class which returns an ArrayList of all the 
	 *  NewsAndEvents. 
	 * 
	 * @author Sankalp Mohanty(676110)
	 * @throws SQLException
	 * @return ArrayList<NewsAndEvents> newsAndEventList
	 * 
	 *
	 */
	
	public ArrayList<NewsAndEvents> getAllNewsAndEvents() throws SQLException
	{
		

		newsEventsDao = new NewsAndEventsDao();
		ArrayList<NewsAndEvents> newsAndEventList = newsEventsDao.getAllNewsAndEvents();

		
		return newsAndEventList;
		
	}
	
	
	
	
	
	/** This method is written to call the getAllNewsAndEvents(String tempDate) method of 
	 *  NewsAndEventsDao class which returns an ArrayList of all the 
	 *  NewsAndEvents Bean on that particular date (given as input).
	 * 
	 * @author Sankalp Mohanty(676110)
	 * @throws  SQLException
	 * @return ArrayList<NewsAndEvents> newsAndEventList
	 * 
	 *
	 */
	public ArrayList<NewsAndEvents> getAllNewsAndEvents(String tempDate) throws SQLException
	{
		
		newsEventsDao = new NewsAndEventsDao();
		ArrayList<NewsAndEvents> newsAndEventList = newsEventsDao.getAllNewsAndEvents(tempDate);
		
		return newsAndEventList;
		
	}
	
	
	
	
	
	/** This method is written to call the getAllDates() method of 
	 *  NewsAndEventsDao class which returns an ArrayList of distinct 
	 *  dates of events.
	 * 
	 * @author Vishwa Desai(588649)
	 * @throws SQLException
	 * @return ArrayList<String> dateList
	 * 
	 *
	 */
	
	public ArrayList<String> getAllDates() throws SQLException
	{
		newsEventsDao = new NewsAndEventsDao();
		ArrayList<String> dateList = newsEventsDao.getAllDates();
		
		return dateList;
	}
	
	
	
	
	/** This method is written to call the generateId() method of 
	 *  NewsAndEventsDao class which automatically generates an 
	 *  NewsAndEvents Id and returns it.
	 * 
	 * @author Vishwa Desai(588649)
	 * @throws SQLException
	 * @return String id
	 * 
	 *
	 */
	
	public String generateId() throws SQLException
	{
		newsEventsDao = new NewsAndEventsDao();
		String id = newsEventsDao.generateId();
		
		return id;
	}
	
	
	/** This method is written to store image which is selected by the admin/user on the server .
	 *  It takes input as a NewsEvents Bean and stores the image 
	 *  on a particular location on the server .
	 *  The path where it is stored is specified in the imagePath.properties file which is refered 
	 *  while storing .
	 * 
	 * @author Vishwa Desai(588649)
	 * @throws IOException
	 * 
	 *
	 */
	
	private void storeImageOnServer(NewsAndEvents newsAndEvents) throws IOException {
		
		NewsAndEventsService nService = new NewsAndEventsService();
		
		Properties prop = new Properties();

		File f = new File(newsAndEvents.getEventImage());
		
		byte[] b = new byte[4194304];
		
		FileInputStream fis = new FileInputStream(f);
		fis.read(b);
		
		InputStream input = nService.getClass().getResourceAsStream("/imagePath.properties");
		prop.load(input);
		
		String path = prop.getProperty("commonImagePath") ;
		String dbPath = prop.getProperty("databaseImagePath");
		
		String imageName= newsAndEvents.getEventNewsId()+".jpg";
		String imageLocation =  path+imageName;
		
		File f1 = new File(imageLocation);
		FileOutputStream fos = new FileOutputStream(f1);
		fos.write(b);
		fos.close();
		
		newsAndEvents.setEventImage(dbPath+imageName);
		
	}
	
	
	
	
	/** This method is written to update the image stored on the server for a particular news and events.
	 *  It takes input as a NewsEvents Bean and stores the image 
	 *  on a particular location on the server .
	 *  The path where it is stored is specified in the imagePath.properties file which is refered 
	 *  while storing .
	 * 
	 * @author Vishwa Desai(588649)
	 * @throws IOException
	 * 
	 *
	 */
	private void updateImageOnServer(NewsAndEvents newsAndEvents) throws IOException {
		
		NewsAndEventsService nService = new NewsAndEventsService();
		
		Properties prop = new Properties();
		
		InputStream input = nService.getClass().getResourceAsStream("/imagePath.properties");
		prop.load(input);
		
		String path = prop.getProperty("commonImagePath") ;
		String dbPath = prop.getProperty("databaseImagePath");
		
		
		String imageName= newsAndEvents.getEventNewsId()+".jpg";
		String imageLocation =  path+imageName;
		
		
		if(!newsAndEvents.getEventImage().equals("default"))
		{
		File f = new File(newsAndEvents.getEventImage());
		
		byte[] b = new byte[4194304];
			
		FileInputStream fis = new FileInputStream(f);
		fis.read(b);
		
	
		File f1 = new File(imageLocation);
		f1.delete();
		
		FileOutputStream fos = new FileOutputStream(f1);
		fos.write(b);
		fos.close();
		
		}
		
		newsAndEvents.setEventImage(dbPath+imageName);
		
			
		
			
		
	}
	
	
	
}
