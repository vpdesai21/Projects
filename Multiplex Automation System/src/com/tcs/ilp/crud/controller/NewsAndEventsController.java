package com.tcs.ilp.crud.controller;


import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.tcs.ilp.crud.beans.Amenity;
import com.tcs.ilp.crud.beans.NewsAndEvents;
import com.tcs.ilp.crud.dao.NewsAndEventsDao;
import com.tcs.ilp.crud.service.AmenityService;
import com.tcs.ilp.crud.service.NewsAndEventsService;

/**
* Controller class of newsAndEvents which is used to connect UI with service of newsAndEvents
      * @version 1.0     
      * @Class name NewsAndEventsController
      * @Creation Date 8/8/2012
     * @ History
*/




public class NewsAndEventsController extends HttpServlet {
	
	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	static final Logger logger=Logger.getLogger(NewsAndEventsDao.class);
	
	private NewsAndEventsService newsEventService;
	private HttpSession session;
	private ArrayList<NewsAndEvents> newsEventsList;

	public void doGet(HttpServletRequest req , HttpServletResponse resp)
	{
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req); 
		HashMap<String,String> parameter=new HashMap<String, String>();
		FileItem imageItem=null;
		if (isMultipart){
			
			FileItemFactory factory = new DiskFileItemFactory(); 
			ServletFileUpload upload = new ServletFileUpload(factory); 
			List items = null; 
			try { 
				items = upload.parseRequest(req); 
			} catch (FileUploadException e) { 
					e.printStackTrace(); 
			} 
			Iterator itr = items.iterator(); 
			while (itr.hasNext())  
			{ 
				FileItem item = (FileItem) itr.next(); 
				if(item.isFormField()){
					  String key = item.getFieldName(); 
	                  String value = item.getString();
	                  parameter.put(key, value);
				}else{
					imageItem=item;
				}
					
			}
			String requestType = parameter.get("requestType");
			if (requestType.equalsIgnoreCase("addNewsAndEvents")) {

				this.addNewsAndEvents(req, resp,parameter,imageItem);

			}else if (requestType.equalsIgnoreCase("updateNewsAndEvents")) {

				this.updateNewsAndEvents(req, resp,parameter,imageItem);

			}
			
		}
		else{
		String type = req.getParameter("requestType");
		
		if(type.equalsIgnoreCase("deleteNewsAndEvents"))
		{
			this.deleteNewsAndEvents(req , resp);
		}
		else if(type.equalsIgnoreCase("getAllNewsAndEvents"))
		{
			this.getAllNewsAndEvents(req , resp);
		}
		else if(type.equalsIgnoreCase("getListOfNewsAndEvents"))
		{
			this.getListOfNewsAndEvents(req , resp);
		}
		else if(type.equalsIgnoreCase("getAllDates"))
		{
			this.getAllDates(req , resp);
		}
		else if(type.equalsIgnoreCase("setupForUpdateNewsAndEvents"))
		{
			this.setupForUpdateNewsAndEvents(req , resp);
		}
	}
		
		
		
			
	}
	

	public void doPost(HttpServletRequest req , HttpServletResponse resp)
	{
		this.doGet(req, resp);
	}
	
	
	
	
	/**
	 * This Method retrieves all the News and Events Details
	 *  and sends them to the UI 
	 * @author : Sankalp Mohanty(676110)
	 * @version 1.0
	 * @creation 13/08/2012
	 * @param		<HttpServletRequest req,HttpServletResponse resp>
	 * @return		<Redirects to success or failure>
	 * @exception   <Redirects to error page>
	 * @since		<JDK 1.6>
	 * @see			<getAllNewsAndEvents(),ConnectionUtil.closeConnection(con) >
	 */

	
	private void getAllNewsAndEvents(HttpServletRequest req,
			HttpServletResponse resp){
		
		newsEventService = new NewsAndEventsService();
		
		try
		{
		
			
			newsEventsList = newsEventService.getAllNewsAndEvents();
			
			
			session = req.getSession();
			session.setAttribute("allNewsEventsList", newsEventsList);
			
			
			resp.sendRedirect("./jsp/getAllNewsAndEvents.jsp");
			
		}
		catch(Exception e)
		{
		
			session = req.getSession();
			session.setAttribute("errorMessage", "Sorry !! No Records Found !!");
			
			try 
			{
				resp.sendRedirect("./jsp/errorPageNewsEvents.jsp");
			} 
			catch (IOException e1)
			{
				logger.error("IOException errorPageNewsEvents.jsp . . .");
			}
			
		
		}
	}
	//=================================================================
	
	
	
	


	/**
	 * This Method passes the News and Events Details to the service 
	 * class and returns a true value to the session
	 * @author : Vishwa Desai(588649)
	 * @version 1.0
	 * @creation 13/08/2012
	 * @param		<HttpServletRequest req,HttpServletResponse resp>
	 * @return		<Redirects to success or failure>
	 * @exception   <Redirects to error page>
	 * @since		<JDK 1.6>
	 * @see			<addNewsAndEvents(newsAndEvents),generateId(),storeImageOnServer(),ConnectionUtil.closeConnection(con) >
	 */
	
	
	private void addNewsAndEvents(HttpServletRequest req,
			HttpServletResponse resp,HashMap<String, String> parameter,FileItem imageItem) {
		
		NewsAndEvents newsAndEvents = null;
		String eventNewsId =null;
		String eventNewsName = null;
		String eventDateTime = null;
		String eventImage = null;
		String eventNewsDescription = null;
		
		try
		{
				
			newsEventService = new NewsAndEventsService();
		
			
			eventNewsName = parameter.get("eventNewsName");
			eventDateTime = parameter.get("myDate")+" "+parameter.get("hr")+":"+parameter.get("min");
			eventImage  = imageItem.getName();
			eventNewsDescription = parameter.get("eventNewsDescription");
			eventNewsId = newsEventService.generateId();
			
					
			newsAndEvents = new NewsAndEvents(eventNewsId,eventNewsName,eventDateTime,eventImage,eventNewsDescription);
			
			newsAndEvents=uploadNewsAndEventsImage(newsAndEvents,"add",req,imageItem);
			
			boolean b = newsEventService.addNewsAndEvents(newsAndEvents);
			
			if(b)
			{
				session = req.getSession();
				session.setAttribute("message", "News And Events Successfully Added");
				
				resp.sendRedirect("./jsp/newsEventsSuccess.jsp");
			
			}
			else
			{
				session = req.getSession();
				session.setAttribute("errorMessage","Error in Add News Events");
				
				try 
				{
					resp.sendRedirect("./jsp/errorPageNewsEvents.jsp");
				} 
				catch (IOException e1)
				{
					logger.error("IOException errorPageNewsEvents.jsp . . .");
				}
				
			}
			
		}
		catch(Exception e)
		{

			session = req.getSession();
			session.setAttribute("errorMessage", "Sorry !! Cant Add NewsAndEvents  !!");
			
			try 
			{
				resp.sendRedirect("./jsp/errorPageNewsEvents.jsp");
			} 
			catch (IOException e1)
			{
				logger.error("IOException errorPageNewsEvents.jsp . . .");
			}
		}
	}
	//=================================================================
	
	


	
	/**
	 * This method gives the list of all dates in the news and events
	 * and set it to session
	 * @author : Vishwa Desai(588649)
	 * @version 1.0
	 * @creation 13/08/2012
	 * @param		<HttpServletRequest req,HttpServletResponse resp>
	 * @return		<Redirects to deleteOrUpdateNewsEvents Page>
	 * @exception   <none>
	 * @since		<JDK 1.6>
	 * @see			<getAllDates(),ConnectionUtil.closeConnection(con) >
	 */
	 

	private void getAllDates(HttpServletRequest req, HttpServletResponse resp) {
	
		ArrayList<String> dateList=null;
		
		try
		{
			newsEventService = new NewsAndEventsService();
			dateList = newsEventService.getAllDates();
			
			session = req.getSession();
			session.setAttribute("dateList",dateList);
			
			session.setAttribute("isListRetrieved","false");
			
			resp.sendRedirect("./jsp/deleteOrUpdateNewsEvents.jsp");
				
			
			
		}
		catch (Exception e) 
		{
			
			session = req.getSession();
			session.setAttribute("errorMessage","Sorry !! No Records Found !!");
			
			try 
			{
				resp.sendRedirect("./jsp/errorPageNewsEvents.jsp");
			} 
			catch (IOException e1)
			{
				logger.error("IOException errorPageNewsEvents.jsp . . .");
			}
			
		}
		
		
	}
	//=================================================================
	
	
	
	
	/**
	 * This method gives the list of news and events for a specific date
	 * and set it to session
	 * @author : Vishwa Desai(588649)
	 * @version 1.0
	 * @creation 13/08/2012
	 * @param		<HttpServletRequest req,HttpServletResponse resp>
	 * @return		<Redirects to deleteOrUpdateNewsEvents Page>
	 * @exception   <none>
	 * @since		<JDK 1.6>
	 * @see			<getListOfNewsAndEvents(),ConnectionUtil.closeConnection(con) >
	 */
	 
	private void getListOfNewsAndEvents(HttpServletRequest req, HttpServletResponse resp) {
		
		try
		{
				
			newsEventService = new NewsAndEventsService();
			
			
			String selectedDate = req.getParameter("selectedDate");		
			
			newsEventsList  = newsEventService.getAllNewsAndEvents(selectedDate);
			
			session = req.getSession();
			session.setAttribute("newsEventsList", newsEventsList);
			session.setAttribute("isListRetrieved", "true");
			
			
			resp.sendRedirect("./jsp/deleteOrUpdateNewsEvents.jsp");
			
			
		}
		catch(Exception e)
		{

			session = req.getSession();
			session.setAttribute("errorMessage", "Sorry !! No Records Found !!");
			
			try 
			{
				resp.sendRedirect("./jsp/errorPageNewsEvents.jsp");
			} 
			catch (IOException e1)
			{
				logger.error("IOException errorPageNewsEvents.jsp . . .");
			}
		}
		
		
		
	}
	//=================================================================
	
	

	
	

	/**
	 * This method deletes a particular news and event record
	 * and set it to session
	 * @author : Sangeet Mishra(675067)
	 * @version 1.0
	 * @creation 13/08/2012
	 * @param		<HttpServletRequest req,HttpServletResponse resp>
	 * @return		<Redirects to newsAndEventsSuccess Page>
	 * @exception   <Redirects to error Page>
	 * @since		<JDK 1.6>
	 * @see			<deleteNewsAndEvents(),ConnectionUtil.closeConnection(con) >
	 */
	
	private void deleteNewsAndEvents(HttpServletRequest req,
			HttpServletResponse resp) {

		
		newsEventService = new NewsAndEventsService();
		
		try
		{
			
			String eventNewsId = req.getParameter("newsEventsId"); 
			
			deleteNewsAndEventImage(eventNewsId);
			
			boolean b = newsEventService.deleteNewsAndEvents(eventNewsId);
			
			if(b)
			{
				
			session = req.getSession();
			session.setAttribute("message", "News And Events Successfully Deleted");
			
			resp.sendRedirect("./jsp/newsEventsSuccess.jsp");
			}
			else
			{
				session = req.getSession();
				session.setAttribute("errorMessage","Error in Delete News Events");
				
				try 
				{
					resp.sendRedirect("./jsp/errorPageNewsEvents.jsp");
				} 
				catch (IOException e1)
				{
					logger.error("IOException errorPageNewsEvents.jsp . . .");
				}
				
			}
		} 
		catch (Exception e) 
		{
			session = req.getSession();
			session.setAttribute("errorMessage","Sorry !! Cant Delete News And Events !!");
			
			try 
			{
				resp.sendRedirect("./jsp/errorPageNewsEvents.jsp");
			} 
			catch (IOException e1)
			{
				logger.error("IOException errorPageNewsEvents.jsp . . .");
			}
		}
	}
	//=================================================================
	
	

	/**
	 * Method to fetch the details of the selected event or news and set  
	 * them to the session so that they can be populated in the 
	 * required fields on update page 
	 * 
	 * @author : Vishwa Desai(588649)
	 * @version  1.0
	 * @creation  13/08/2012
	 * @param		<HttpServletRequest req,HttpServletResponse resp>
	 * @return		<Redirects to newsAndEventsSuccess Page>
	 * @exception   <Redirects to error Page>
	 * @since		<JDK 1.6>
	 * @see			<setupForUpdateNewsAndEvents(),ConnectionUtil.closeConnection(con) >
	 */
	
	private void setupForUpdateNewsAndEvents(HttpServletRequest req, HttpServletResponse resp) 
	{
	
		NewsAndEvents newsAndEvents=new NewsAndEvents();
		
		String eventNewsId=req.getParameter("newsEventsId");
		
		newsEventService = new NewsAndEventsService(); 
		
		try 
		{
			
		newsAndEvents=newsEventService.getNewsAndEvents(eventNewsId);
		
		
		
		session=req.getSession();
		
		session.setAttribute("newsEventsForUpdate",newsAndEvents);
		
		resp.sendRedirect("./jsp/updateNewsAndEvents.jsp");
			
		}catch(Exception e)
		{
			logger.error("Exception occured in setup for update in controller....");
		}
		
	
		
		
		
	}
	//=================================================================
	
	
	
	
	/**
	 * Method to update the selected event or news  
	 * 
	 * @author : Vishwa Desai(588649)
	 * @version  1.0
	 * @creation  13/08/2012
	 * @param		<HttpServletRequest req,HttpServletResponse resp>
	 * @return		<Redirects to newsAndEventsSuccess Page>
	 * @exception   <Redirects to error Page>
	 * @since		<JDK 1.6>
	 * @see			<updateNewsAndEvents(),updateImageOnServer(),ConnectionUtil.closeConnection(con) >
	 */
	
	private void updateNewsAndEvents(HttpServletRequest req,
			HttpServletResponse resp,HashMap<String, String> parameter,FileItem imageItem) {
		
		NewsAndEvents newsAndEvents = null;
		String eventNewsId =null;
		String eventNewsName = null;
		String eventDateTime = null;
		String eventImage = "";
		String eventNewsDescription = null;
		
		try
		{
				
			newsEventService = new NewsAndEventsService();
		
			
			eventNewsName = parameter.get("eventNewsName");
			eventDateTime = parameter.get("myDate")+" "+parameter.get("hr")+":"+parameter.get("min");
			
			eventNewsDescription = parameter.get("eventNewsDescription");
			eventNewsId = parameter.get("newsEventsId"); 
			
			
			if(imageItem!=null)
				eventImage = imageItem.getName();
			
					
			newsAndEvents = new NewsAndEvents(eventNewsId,eventNewsName,eventDateTime,eventImage,eventNewsDescription);
			
			newsAndEvents=uploadNewsAndEventsImage(newsAndEvents,"update",req,imageItem);
			
			int noOfRecords = newsEventService.updateNewsAndEvents(newsAndEvents);
			
			if(noOfRecords!=0)
			{
				session = req.getSession();
				session.setAttribute("message", "News And Events Successfully Updated !! ");
				
			resp.sendRedirect("./jsp/newsEventsSuccess.jsp");
			}
			else
			{
				session = req.getSession();
				session.setAttribute("errorMessage","Sorry !! Cant Update News And Events !!");
				
				try 
				{
					resp.sendRedirect("./jsp/errorPageNewsEvents.jsp");
				} 
				catch (IOException e1)
				{
					logger.error("IOException in redirecting errorPageNewsEvents.jsp . . .");
				}
				
			}
		} 
		catch (Exception e) 
		{
			session = req.getSession();
			session.setAttribute("errorMessage","Sorry !! Cant Update News And Events !!");
			
			try 
			{
				resp.sendRedirect("./jsp/errorPageNewsEvents.jsp");
			} 
			catch (IOException e1)
			{
				logger.error("IOException errorPageNewsEvents.jsp . . .");
			}
		}
	}
	//=================================================================
	
	
	public NewsAndEvents uploadNewsAndEventsImage(NewsAndEvents newsAndEvents,String flag,HttpServletRequest  request,FileItem imageItem) throws IOException{
		
		String imagePath=null;
		
		
		if(!newsAndEvents.getEventImage().equals(""))
		{						
						if (!imageItem.isFormField()){
						
								imagePath=getServletContext().getRealPath("/") 
								+"SystemImages\\NewsAndEvents\\"+newsAndEvents.getEventNewsId()+".jpg";
								File savedFile = new File(imagePath); 
								try {
									imageItem.write(savedFile);
								} catch (Exception e) {
									e.printStackTrace();
									System.out.println("exception in image upload");
									//throw e;
								} 
								String dbImagePath="..\\SystemImages\\NewsAndEvents\\"+newsAndEvents.getEventNewsId()+".jpg";
								newsAndEvents.setEventImage(dbImagePath);
								
						}
					
		}else{
				imagePath =  "..\\SystemImages\\NewsAndEvents\\"+newsAndEvents.getEventNewsId()+".jpg";;
				newsAndEvents.setEventImage(imagePath);
				
			
	}
		
	
			
		
			   
		return newsAndEvents;
	}
	
	public void deleteNewsAndEventImage(String newsAndEventsId){
		AmenityService amenityService =new AmenityService();
	/*	Properties prop = new Properties();
		InputStream input = amenityService.getClass().getResourceAsStream("/imagePath.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = prop.getProperty("amenityImagePath") ;*/
		String imagePath=getServletContext().getRealPath("/") 
		+"SystemImages\\NewsAndEvents\\"+newsAndEventsId+".jpg";
		File f = new File(imagePath);
		f.delete();
	}
	
	
}
//=======================End Of NewsAndEventsController Class===========
