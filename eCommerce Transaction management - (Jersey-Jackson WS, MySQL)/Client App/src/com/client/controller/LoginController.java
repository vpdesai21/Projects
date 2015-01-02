package com.client.controller;


import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(LoginController.class);
	private static final ClientConfig clientConfig = new DefaultClientConfig();
	HttpSession ses=null;

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
			e.printStackTrace();
			logger.error(e.toString());

		}
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		doGet(request,response);
	}

	public void checkLoginCredentials(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		String id=req.getParameter("userid");
		String pass=req.getParameter("password");
		boolean validCredentials = false;

		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8181/eCommerce/users/authenticate");

		String input = "{\"username\":\""+id+"\",\"password\":\""+pass+"\"}";

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

		if (response.getStatus() == 201 || response.getStatus() == 200) {
			String output = response.getEntity(String.class);
			if(output != null && !output.equalsIgnoreCase(""))
				validCredentials = true;
			else
				validCredentials = false;
		}

		if(validCredentials)
		{
			ses = req.getSession();
			ses.setAttribute("userId", id);
			String prodId = (String)ses.getAttribute("productId");
			if(prodId != null) {
				if(checkAvailabilityOfProduct(prodId))
					res.sendRedirect(getServletContext().getContextPath()+"/public/jsp/orderDetails.jsp");
				else
					res.sendRedirect(getServletContext().getContextPath()+"/public/jsp/productAvailibility.jsp");
			} else {
				res.sendRedirect(getServletContext().getContextPath()+"/viewAllTransactions");
			}
		} else {
			ses = req.getSession();
			ses.setAttribute("error_login", "yes");
			res.sendRedirect(getServletContext().getContextPath()+"/public/jsp/login.jsp");
		}
	}

	private boolean checkAvailabilityOfProduct(String prodId) {
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8181/eCommerce/inventory/checkAvailibility");

		String input = "{\"product_id\":\""+prodId+"\"}";
		String output = "";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);

		if (response.getStatus() == 201 || response.getStatus() == 200) {
			output = response.getEntity(String.class);
		}
		
		if(output.equalsIgnoreCase("available")) {
			return true;
		} else {
			return false;
		}
	}

	public void logout(HttpServletRequest req,HttpServletResponse res) throws Exception
	{
		ses=req.getSession();
		ses.invalidate();
		res.sendRedirect(getServletContext().getContextPath()+"/public/jsp/login.jsp");
	}


}
