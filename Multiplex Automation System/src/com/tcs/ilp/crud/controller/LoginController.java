package com.tcs.ilp.crud.controller;


import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;


/*
 * @author Vishwa Desai(588649)
 * version 1.0
 * LoginController class
 * creation date: 13-08-2012
 * 
 */

public class LoginController extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	static final Logger logger = Logger.getLogger(LoginController.class);

	
	HttpSession ses=null;
	
	/*
	 * Overridden doGet method of HttpServlet.
	 * Receives all the HTTP requests of type Get. 
	 * It checks the requestType parameter and then calls other methods accordingly.
	 * parameters: HttpServletRequest and HttpServletResponse
	 * These parameters are used to receive Http requests and send Http response.
	 * return type: void.
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{	
		try
		{
		
			String requestType=request.getParameter("requestType");
			if(requestType.equals("login"))
			{
				checkLoginCredentials(request, response);
			}
			
			else if(requestType.equals("logout"))
			{
				logout(request,response);
			}	
		
		
		}
		catch(Exception e)
		{
			logger.error("Exception in Login COntroller . .");
			
		}
	}
	
	
	/*
	 * Overridden doPost method of HttpServlet.
	 * Receives all the Http requests of type Post. The doPost method has been implemented to call doGet method only.
	 * parameters: HttpServletRequest and HttpServletResponse
	 * These parameters are used to receive Http requests and send Http response.
	 * return type: void.
	 */
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		doGet(request,response);
	}
	
	
	
	/*
	 *  This method is used to check whether the userId and password entered by user are valid or not.
	 *  It calls checkUser method of UserService class.
	 * parameters: HttpServletRequest and HttpServletResponse
	 * These parameters are used to receive Http requests and send Http response.
	 * return type: void.
	 */
	public void checkLoginCredentials(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("userid");
		String pass=req.getParameter("password");
		
		if(id.equals(pass) && (id.equalsIgnoreCase("admin") || id.equalsIgnoreCase("customer")))
		{
			ses = req.getSession();
			ses.setAttribute("id", id);
			
			res.sendRedirect(getServletContext().getContextPath()+"/jsp/adminHome.jsp");
		}
		
		
	}
	
	
	/*
	 * This method is called when user logs out.
	 * parameters: HttpServletRequest and HttpServletResponse
	 * These parameters are used to receive Http requests and send Http response.
	 * return type: void.
	 */
	public void logout(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		ses=req.getSession();
		ses.invalidate();
		res.sendRedirect(getServletContext().getContextPath()+"/jsp/login.jsp");
	}
	
	
}
