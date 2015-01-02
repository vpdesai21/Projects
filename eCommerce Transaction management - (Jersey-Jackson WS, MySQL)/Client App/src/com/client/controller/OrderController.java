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


public class OrderController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(OrderController.class);
	private static final ClientConfig clientConfig = new DefaultClientConfig();
	HttpSession ses=null;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{	
		try
		{
			ses = request.getSession();
			String productId= (String)ses.getAttribute("productId");
			String userId= (String)ses.getAttribute("userId");
			
			String quantity = request.getParameter("quantity");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zipcode = request.getParameter("zipcode");
			
			if(checkProductAvailability(productId, quantity)) {
				ses.setAttribute("productCount", quantity);
				String addressId = saveShippingAddressDetails(userId, address1, address2, city, state, zipcode);
				if(addressId != null && !addressId.equalsIgnoreCase("")) {
					ses.setAttribute("addressId", addressId);
					response.sendRedirect(getServletContext().getContextPath()+"/public/jsp/paymentDetails.jsp");
				} else {
					ses.setAttribute("error_address", "yes");
					response.sendRedirect(getServletContext().getContextPath()+"/public/jsp/orderDetails.jsp");
				}
			} else {
				ses.setAttribute("error_quantity", "yes");
				response.sendRedirect(getServletContext().getContextPath()+"/public/jsp/orderDetails.jsp");
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

	private boolean checkProductAvailability(String productId, String quantity) throws Exception
	{
		String isAvailable = null;
	
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8181/eCommerce/inventory/check");

		String input = "{\"product_id\":\""+productId+"\", \"product_count\":\""+quantity+"\"}";

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		
		if (response.getStatus() == 201 || response.getStatus() == 200) {
			isAvailable = response.getEntity(String.class);
		}
		
		if(isAvailable!=null && isAvailable.equalsIgnoreCase("available"))
			return true;
		else
			return false;		
	}
	

	private String saveShippingAddressDetails(String userId, String address1, String address2,
			String city, String state, String zipcode) {
		
		String addressId = null;
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8181/eCommerce/address/save");

		String input = "{\"user_id\":\""+userId+"\", \"address_line1\":\""+address1+"\", \"address_line2\":\""+address2+"\" , \"city\":\""+city+"\" , \"state\":\""+state+"\" , \"zipcode\":\""+zipcode+"\"}";

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		
		if (response.getStatus() == 201 || response.getStatus() == 200) {
			addressId = response.getEntity(String.class);
		}
		
		return addressId;
	}

}
