/**
 * 
 */
package com.tcs.ilp.crud.controller;

import java.io.File;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;




import javax.servlet.http.HttpServletRequest;


import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tcs.ilp.crud.beans.Amenity;
import com.tcs.ilp.crud.beans.AmenityType;
import com.tcs.ilp.crud.service.AmenityService;
import com.tcs.ilp.crud.service.AmenityTypeService;
import com.tcs.ilp.crud.utility.AmenityAlreadyExistsException;


/**
* This class performs operation based on the requestType.
      * @author neelesh(669049)    
      * @version 1.0     
      * @Class name AmenityController
      * @Creation Date 7-8-2012
     * @ History
*/
public class AmenityController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	static final Logger logger = Logger.getLogger(AmenityController.class);
	
	
	private Amenity amenity;
	private AmenityService amenityService;
	
	private AmenityType amenityType;
	private AmenityTypeService amenityTypeService;
	
	
/**
 * @author 669049
 * @param HttpServletRequest , HttpServletResponse 
 * @return void
 */

	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
		HashMap<String,String> parameter=new HashMap<String, String>();
		FileItem imageItem=null;
		if (isMultipart){
			
			FileItemFactory factory = new DiskFileItemFactory(); 
			ServletFileUpload upload = new ServletFileUpload(factory); 
			List items = null; 
			try { 
				items = upload.parseRequest(request); 
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
			if (requestType.equalsIgnoreCase("addAmenity")) {

				addAmenity(request, response,parameter,imageItem);

			}else if (requestType.equalsIgnoreCase("updateAmenity")) {

				updateAmenity(request, response,parameter,imageItem);

			}
			
		}
		else{
		String requestType = request.getParameter("requestType");

		 if (requestType.equalsIgnoreCase("getAmenity")) {

			getAmenity(request, response);

		} else if (requestType.equalsIgnoreCase("getAllAmenities")) {

			getAllAmenities(request, response);

		}else if (requestType.equalsIgnoreCase("getAllAmenitiesByType")) {

			getAllAmenitiesByType(request, response);

		}else if (requestType.equalsIgnoreCase("getAmenityType")) {

			getAmenityType(request, response);

		}else if (requestType.equalsIgnoreCase("getAllAmenityTypes")) {

			getAllAmenityTypes(request, response);

		} else if (requestType.equalsIgnoreCase("setupForAddAmenity")) {

			setupForAddAmenity(request, response);

		}else if (requestType.equalsIgnoreCase("setupForUpdateAmenity")) {

			setupForUpdateAmenity(request, response);

		}  else if (requestType.equalsIgnoreCase("deleteAmenity")) {

			deleteAmenity(request, response);

		}
	}
}
	
	
	/**
	 * @author 669049
	 * @param HttpServletRequest request, HttpServletResponse response
	 * @return void 
	 */
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

	 
	/**
	  *This method sets the amenity details into the session.
	  * @author neelesh(669049)
	  * @param		<HttpServletRequest req,HttpServletResponse res> <instance of HttpServletRequest and HttpServletResponse>
	  * @return		<none> <none>
	  * @exception 		<none>
	  * @since			<JDK 1.6>
	  * @see			<getAllAmenity() of the service >
	  */
	

	
	
	private void setupForAddAmenity(HttpServletRequest request,
			HttpServletResponse response){
		amenityTypeService = new AmenityTypeService();
		ArrayList<AmenityType> amenityTypeList = new ArrayList<AmenityType>();
		try{
			amenityTypeList = amenityTypeService.getAllAmenityTypes();
		}catch (Exception e) {
			logger.error("Error Occured during get AmenityTypes in Controller:"+e);
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("amenityTypeList", amenityTypeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/addAmenity.jsp");
		try{
			rd.forward(request, response);
		}catch(Exception e){
			logger.error("Exception Occured in Controller: "+e);
		}
		
	}

	/**
	 *This method add the Amenity.
	 * @author neelesh(669049)
	 * @since			<JDK 1.6>
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	
	
	public void addAmenity(HttpServletRequest request,
			HttpServletResponse response,HashMap<String, String> parameter,FileItem imageItem) throws ServletException,IOException{
		amenityTypeService = new AmenityTypeService();
		amenityService = new AmenityService();
		String amenityId=null;
		try {
			amenityId = amenityService.genarateId();
			logger.debug("amenityId:"+amenityId);
		} catch (SQLException e2) {
			
			e2.printStackTrace();
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
			
		}
		String amenityName = parameter.get("amenityName");
		String amenityTypeId = parameter.get("amenityTypeId");
		String amenityDescription = parameter.get("amenityDescription");
		String amenityImage="";
		if(imageItem!=null)
			amenityImage = imageItem.getName();
		
		
		 
		try{
			amenityType = amenityTypeService.getAmenityType(amenityTypeId);
		}catch (Exception e) {
			logger.error(e);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
		
		
		amenity = new Amenity();
		amenity.setAmenityId(amenityId);
		amenity.setAmenityName(amenityName);
		amenity.setAmenityType(amenityType);
		amenity.setAmenityImage(amenityImage);
		amenity.setAmenityDescription(amenityDescription);

		amenity=uploadAmenityImage(amenity,"add","",request,imageItem);
		
		int numberOfAmenityAdded=0;
		try {
			numberOfAmenityAdded = amenityService.addAmenity(amenity);
			if(numberOfAmenityAdded==1)
			response.sendRedirect("./getAllAmenitiesByType?requestType=getAllAmenitiesByType&amenityTypeId="+amenityTypeId);
		//	RequestDispatcher rd = request.getRequestDispatcher("/jsp/addAmenitySuccess.jsp");
		//		rd.forward(request, response);
			
	
		}
		catch (AmenityAlreadyExistsException e1) {
			logger.error(e1.toString());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/addAmenity.jsp");
			request.setAttribute("amenityAlreadyExistsException", e1.toString());
			rd.forward(request, response);
			
		
		} catch (IOException e) {
			e.printStackTrace();
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}catch (Exception e) {
		
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}

	}
/**
 * This method gives  amenity details.
 * @author 669049
 * @param request
 * @param response
 * @throws IOException 
 */
	
	
	public void getAmenity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String amenityId = request.getParameter("amenityId");
		amenityService = new AmenityService();
		try{
			amenity = amenityService.getAmenity(amenityId);
		}catch (Exception e) {
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
			
		}
		

		HttpSession session = request.getSession();

		session.setAttribute("amenity", amenity);
	}
	/**
	 * This method gives amenitytype details.
	 * @param request
	 * @param response
	 */
	
	
	public void getAmenityType(HttpServletRequest request,
			HttpServletResponse response)throws IOException {
		String amenityTypeId = request.getParameter("amenityTypeId");
		amenityTypeService = new AmenityTypeService();
		try{
			amenityType = amenityTypeService.getAmenityType(amenityTypeId);
		}catch (Exception e) {
		
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
		

		HttpSession session = request.getSession();

		session.setAttribute("amenityType", amenityType);
	}

	/**
	 *This method gives all amenity details.
	 *  @author Neelesh(669049)
	 * @param		<HttpServletRequest req,HttpServletResponse res> <instance of HttpServletRequest and HttpServletResponse>
	 * @return		<none> <none>
	 * @exception 		<none>
	 * @since			<JDK 1.6>
	 * @see			<getAllAmenities() of the service >
	 */
	
	
	public void getAllAmenities(HttpServletRequest request,
			HttpServletResponse response) {
		amenityService = new AmenityService();
		ArrayList<Amenity> amenityList=null;
		try{
		 amenityList = amenityService.getAllAmenities();
		}catch (Exception e) {
			logger.error("Error Occured during get All Amenities: "+e);
		}
		HttpSession session = request.getSession();

		session.setAttribute("amenityList", amenityList);
		
		try {
		
			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/getAllAmenity.jsp");		
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error Occured during get All Amenities: "+e);
		}
	}
		
	/**
	 * This method gives all AmeniTytypes details.
	 *  @author Neelesh(669049)
	 * @param		<HttpServletRequest req,HttpServletResponse res> <instance of HttpServletRequest and HttpServletResponse>
	 * @return		<none> <none>
	 * @throws IOException 
	 * @exception 		<none>
	 * @since			<JDK 1.6>
	 * @see			<getAllAmenityTypes() of the service >
		 */

	public void getAllAmenityTypes(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		amenityService = new AmenityService();
		amenityTypeService =new AmenityTypeService();
		ArrayList<AmenityType> amenityTypeList = new ArrayList<AmenityType>();
		try{
			
			amenityTypeList = amenityTypeService.getAllAmenityTypes();
		
		}catch (Exception e) {
			logger.error("Error:"+e);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
		
		HttpSession session = request.getSession();

		session.setAttribute("amenityTypeList", amenityTypeList);
		
		try {
			
			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/getAllAmenityTypes.jsp");		
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error"+e);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
	}
	/**
	 * This method gives allAmenities details based on their types
	 * @author 669049
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void getAllAmenitiesByType(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String amenityTypeId = request.getParameter("amenityTypeId");
		amenityService = new AmenityService();
		ArrayList<Amenity> amenityList=null;
		try{
		 amenityList = amenityService.getAllAmenitiesByType(amenityTypeId);
		}catch (Exception e) {
			logger.error("Error in get All Amenity Types"+e);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
		HttpSession session = request.getSession();

		session.setAttribute("amenityList", amenityList);
		
		try {
		
			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/viewAllAmenities.jsp");		
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error"+e);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
	}
	/**
	 *This method delete the amenities.
	 *  @author Mukul(675250)
	 * @param		<HttpServletRequest req,HttpServletResponse res> <instance of HttpServletRequest and HttpServletResponse>
	 * @return		<none> <none>
	 * @throws IOException 
	 * @exception 		<none>
	 * @since			<JDK 1.6>
	 * @see			<deleteAmenity() of the service >
	 */

	public void deleteAmenity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String amenityId = request.getParameter("amenityId");
		String amenityTypeId = request.getParameter("amenityTypeId");
		String amenityName = request.getParameter("typeName");
		amenityService = new AmenityService();
		int numberOfAmenitysDeleted=0;
		try{
			 numberOfAmenitysDeleted = amenityService.deleteAmenity(amenityId);
		}catch (SQLException e) {
		
			logger.error(e);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
		deleteAmenityImage(amenityId);
		if(numberOfAmenitysDeleted != 0){
			try {
				response.sendRedirect("./getAllAmenitiesByType?requestType=getAllAmenitiesByType&amenityTypeId="+amenityTypeId+"&typeName"+amenityName);
				//response.sendRedirect("./jsp/deleteAmenitySuccess.jsp");
			} catch (IOException e) {
				e.printStackTrace();
				response.sendRedirect("./jsp/errorPageAmenities.jsp");
			}
		}else response.sendRedirect("./jsp/errorPageAmenities.jsp");
		
	}
	/**
	 *This method sets  the amenities details into the session.
	 *  @author Mukul(675250)
	 * @param		<HttpServletRequest req,HttpServletResponse res> <instance of HttpServletRequest and HttpServletResponse>
	 * @return		<none> <none>
	 * @throws IOException 
	 * @exception 		<none>
	 * @since			<JDK 1.6>
	 * 
	 */

	private void setupForUpdateAmenity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String amenityId = request.getParameter("amenityId");
		amenityService = new AmenityService();
		try {
			amenity = amenityService.getAmenity(amenityId);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
			logger.error(e1);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			logger.error(e1);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
		
		amenityTypeService = new AmenityTypeService();
		ArrayList<AmenityType> amenityTypeList=null;;
		try {
			amenityTypeList = amenityTypeService.getAllAmenityTypes();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
			logger.error(e1);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			logger.error(e1);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}

		HttpSession session = request.getSession();

		session.setAttribute("amenity", amenity);
		session.setAttribute("amenityTypeList", amenityTypeList);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/updateAmenity.jsp");
		try{
			rd.forward(request, response);
		}catch(Exception e){
			logger.error("Exception Occured: "+e);
			logger.error(e);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
		
	}
	/**
	 *This method updates the promotionalOffers.
	 *  @author Mukul(675250)
	 * @param		<HttpServletRequest req,HttpServletResponse res> <instance of HttpServletRequest and HttpServletResponse>
	 * @return		<none> <none>
	 * @throws IOException 
	 * @exception 		<none>
	 * @since			<JDK 1.6>
	 */

	private void updateAmenity(HttpServletRequest request,
			HttpServletResponse response,HashMap<String, String> parameter,FileItem imageItem) throws IOException {
		String amenityId = parameter.get("amenityId");
		String amenityName = parameter.get("amenityName");
		String amenityTypeId = parameter.get("amenityTypeId");
		String amenityTypeName = request.getParameter("typeName");
		
		String amenityDescription = parameter.get("amenityDescription");
		String amenitydefaultImage = parameter.get("amenitydefaultImage");
		String amenityImage="";
		if(imageItem!=null)
			amenityImage = imageItem.getName();
		
		amenity = new Amenity();
		amenityService = new AmenityService();
		amenityTypeService = new AmenityTypeService();
		try {
			amenityType = amenityTypeService.getAmenityType(amenityTypeId);
		} catch (SQLException e1) {
		
			e1.printStackTrace();
			logger.error(e1);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		} catch (ClassNotFoundException e1) {
		
			e1.printStackTrace();
			logger.error(e1);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
		
		amenity.setAmenityId(amenityId);
		amenity.setAmenityName(amenityName);
		amenity.setAmenityType(amenityType);
		amenity.setAmenityImage(amenityImage);
		amenity.setAmenityDescription(amenityDescription);
	
		try {
			amenity=uploadAmenityImage(amenity,"update",amenitydefaultImage,request,imageItem);
		} catch (IOException e2) {
			e2.printStackTrace();
			logger.error(e2);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
		try {
			amenityService.updateAmenity(amenity);
		} catch (SQLException e1) {
		
			e1.printStackTrace();
			logger.error(e1);
			response.sendRedirect("./jsp/errorPageAmenities.jsp");
		}
		response.sendRedirect("./getAllAmenitiesByType?requestType=getAllAmenitiesByType&amenityTypeId="+amenityTypeId+"&typeName"+amenityTypeName);
		
		//response.sendRedirect("./jsp/updateSuccess.jsp");
		
		
		
	}
	/**
	 * @author (Neelesh(669049))
	 * @method uploadAmenityImage
	 * @return Amenity 
	 * @param amenity  <Amenity>
	 * @throws IOException 
	 * @description this method uploade Amenity to the file
	 */
	public Amenity uploadAmenityImage(Amenity amenity,String flag,String amenitydefaultImage,HttpServletRequest  request,FileItem imageItem) throws IOException{
		
		String imagePath=null;
		
		
		if(!amenity.getAmenityImage().equals(""))
		{						
						if (!imageItem.isFormField()){
							
								imagePath=getServletContext().getRealPath("/") 
								+"SystemImages\\Amenities\\"+amenity.getAmenityId()+".jpg";
								File savedFile = new File(imagePath); 
								try {
									imageItem.write(savedFile);
								} catch (Exception e) {
									e.printStackTrace();
								} 
								String dbImagePath="SystemImages\\Amenities\\"+amenity.getAmenityId()+".jpg";
								amenity.setAmenityImage(dbImagePath);
								
						}
					
		}else{
				if(flag.equals("add")){
					imagePath ="SystemImages\\Amenities\\"+"default"+".jpg";
						amenity.setAmenityImage(imagePath);
				}else{
					imagePath =  amenitydefaultImage;
					amenity.setAmenityImage(imagePath);
					
				}
		}
			
		
			   
		return amenity;
	}
	
	public void deleteAmenityImage(String amenityId){
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
		+"SystemImages\\Amenities\\"+amenityId+".jpg";
		File f = new File(imagePath);
		f.delete();
	}
	
}
