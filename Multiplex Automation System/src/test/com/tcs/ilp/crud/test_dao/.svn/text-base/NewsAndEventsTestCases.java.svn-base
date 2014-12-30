package test.com.tcs.ilp.crud.test_dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.tcs.ilp.crud.beans.NewsAndEvents;
import com.tcs.ilp.crud.dao.NewsAndEventsDao;


/**
 * @author sangeet(675067)& sankalp(676110)
 *
 */
   public class NewsAndEventsTestCases {
    	  
		public static final Logger logger=Logger.getLogger(NewsAndEventsTestCases.class);
	    static NewsAndEventsDao newsAndEventsDao = new NewsAndEventsDao();
		
		public static void addNewsAndEventsTest() throws SQLException, IOException 
		{
			NewsAndEvents newsAndEvents = new NewsAndEvents();
			 
			 newsAndEvents.setEventNewsId("NE001"); 
			 newsAndEvents.setEventNewsName("Rock Concert"); 
			 newsAndEvents.setEventDateTime("24/02/2013 12:20PM"); 
			 newsAndEvents.setEventImage("http://asdasds"); 
		     newsAndEvents.setEventNewsDescription("Rock Concert By JAL Band"); 
  
		     boolean b=newsAndEventsDao.addNewsAndEvents(newsAndEvents);    
		    
			if(b==true)
			{
				logger.debug("\nTest Case Passed: addNewsAndEventsTest \n ");
				newsAndEvents.display();
			}
			else
			{
				logger.debug("\nTest Case Failed: addNewsAndEventsTest \n\n ");
			}
		}
		

		public static void getNewsAndEventsTest() throws Exception {
			
			NewsAndEvents newsAndEvents = newsAndEventsDao.getNewsAndEvents("NE001");
			         
		        if(newsAndEvents != null)
			      {
			    	  logger.debug("\n Test Case Passed: getNewsAndEventsTest\n\n ");
			    	  newsAndEvents.display();
			      }
			      else
			      {
			    	  logger.debug("\n Test Case Failed: getNewsAndEventsTest\n\n");
			      }
		}
		  
		
		public static void getAllNewsAndEventsTest() throws SQLException {
			
			    ArrayList<NewsAndEvents> newsAndEventsList = new ArrayList<NewsAndEvents>();
				newsAndEventsList=newsAndEventsDao.getAllNewsAndEvents();
				if(newsAndEventsList.size()>0)
				{
					logger.debug("\nTest Case Passed: getAllNewsAndEventsTest \n\n ");
					
					for(int i=0; i<newsAndEventsList.size(); i++) {
						NewsAndEvents newsAndEvents = newsAndEventsList.get(i);
						newsAndEvents.display();
					}
				}
				else
				{
					logger.debug("\nTest Case Failed: getAllNewsAndEventsTest \n\n ");
				}
			}
			
			
			
		public static void getAllNewsAndEventsTest(String Date) throws SQLException {
			
		    ArrayList<NewsAndEvents> newsAndEventsList = new ArrayList<NewsAndEvents>();
			newsAndEventsList=newsAndEventsDao.getAllNewsAndEvents(Date);
			if(newsAndEventsList.size()>0)
			{
				logger.debug("\nTest Case Passed: getAllNewsAndEventsTest with matching Date \n\n ");
				
				for(int i=0; i<newsAndEventsList.size(); i++) {
					NewsAndEvents newsAndEvents = newsAndEventsList.get(i);
					newsAndEvents.display();
				}
			}
			else
			{
				logger.debug("\nTest Case Failed: getAllNewsAndEventsTest with matching Date \n\n ");
			}
		}
		
		
		
		public static void updateNewsAndEventsTest(NewsAndEvents newsAndEvents) throws SQLException {
			
			int noOfRecords = 0;
			try {
				noOfRecords = newsAndEventsDao.updateNewsAndEvents(newsAndEvents);
			} catch (FileNotFoundException e) 
			{
				
				e.printStackTrace();
			}		
			
		    if(noOfRecords!=0)
			{
				logger.debug("\nTest Case Passed: updateNewsAndEventsTest \n ");
				newsAndEvents.display();
				}
			else
			{
				logger.debug("\nTest Case Failed: updateNewsAndEventsTest \n\n ");
			}
		}
		
		
		
		public static void deleteNewsAndEventsTest(String eventNewsId) throws ClassNotFoundException, SQLException  {
			
			
			logger.debug("Deleting News And Events with ID:"+eventNewsId);
			boolean b = newsAndEventsDao.deleteNewsAndEvents(eventNewsId);
			
			if(b==true)
			{
				logger.debug("\nTest Case Passed: deleteNewsAndEventsTest \n ");
				
			}
			else
			{
				logger.debug("\nTest Case Failed: deleteNewsAndEventsTest \n\n ");
			}
		}
		
		
		public static void main(String[] args) throws SQLException,Exception
		{   
			//addNewsAndEventsTest();
			//getNewsAndEventsTest();
			getAllNewsAndEventsTest();
			//getAllNewsAndEventsTest("20/02/2013");
			//updateNewsAndEventsTest(new NewsAndEvents("NE02","DJ","24/02/2013 12:20PM","http://asdasd","DJ Suman Show"));
			//deleteNewsAndEventsTest("NE001");
		}
		

	

}
