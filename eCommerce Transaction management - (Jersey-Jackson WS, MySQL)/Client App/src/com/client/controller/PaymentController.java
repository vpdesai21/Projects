package com.client.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


public class PaymentController extends HttpServlet 
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
			String productCount= (String)ses.getAttribute("productCount");
			String userId= (String)ses.getAttribute("userId");
			String addressId= (String)ses.getAttribute("addressId");

			String cardNumber = request.getParameter("cardNumber");
			String cardHolderName = request.getParameter("cardHolderName");
			String month = request.getParameter("month");
			String year = request.getParameter("year");
			String cvv = request.getParameter("cvv");
			String expirationDate = month+"/"+year;
			
			SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
			String formattedDate = format1.format(new Date());

			String paymentId = savePaymentDetails(userId, cardNumber, cardHolderName, expirationDate, cvv);
			if(paymentId != null && !paymentId.equalsIgnoreCase("")) {
				
				String transactionId = saveTransactionDetails(userId, addressId, paymentId, formattedDate);
				if(transactionId != null && !transactionId.equalsIgnoreCase("")) {
					
					String saveProductToOrderFlag = saveProductToTransaction(transactionId, productId, productCount);
					if(saveProductToOrderFlag != null && saveProductToOrderFlag.equalsIgnoreCase("success")) {
						updateProductInventory(productId, productCount);
						response.sendRedirect(getServletContext().getContextPath()+"/public/jsp/success.jsp");
					} else {
						ses.setAttribute("error_transaction", "yes");
						response.sendRedirect(getServletContext().getContextPath()+"/public/jsp/paymentDetails.jsp");
					}
				} else {
					ses.setAttribute("error_transaction", "yes");
					response.sendRedirect(getServletContext().getContextPath()+"/public/jsp/paymentDetails.jsp");
				}
			} else {
				ses.setAttribute("error_payment", "yes");
				response.sendRedirect(getServletContext().getContextPath()+"/public/jsp/paymentDetails.jsp");
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

	private String savePaymentDetails(String userId, String cardNumber, String cardHolderName,
			String expirationDate, String cvv) {
		
		String paymentId = null;
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8181/eCommerce/payment/save");

		String input = "{\"user_id\":\""+userId+"\", \"card_holder_name\":\""+cardHolderName+"\", \"expiration_date\":\""+expirationDate+"\" , \"card_number\":\""+cardNumber+"\" , \"cvv_code\":\""+cvv+"\"}";

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		
		if (response.getStatus() == 201 || response.getStatus() == 200) {
			paymentId = response.getEntity(String.class);
		}
		
		return paymentId;
	}
	
	private String saveTransactionDetails(String userId, String addressId, String paymentId, 
			String orderPlacedDate) {
		
		String transactionId = null;
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8181/eCommerce/transaction/save");

		String input = "{\"user_id\":\""+userId+"\", \"address_id\":\""+addressId+"\", \"payment_id\":\""+paymentId+"\" , \"order_placed_timestamp\":\""+orderPlacedDate+"\"}";

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		
		if (response.getStatus() == 201 || response.getStatus() == 200) {
			transactionId = response.getEntity(String.class);
		}
		
		return transactionId;
	}
	
	private String saveProductToTransaction(String transactionId,
			String productId, String productCount) {

		String successFlag = null;
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8181/eCommerce/productToTransaction/save");

		String input = "{\"order_id\":\""+transactionId+"\", \"product_id\":\""+productId+"\", \"product_quantity\":\""+productCount+"\"}";

		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		
		if (response.getStatus() == 201 || response.getStatus() == 200) {
			successFlag = response.getEntity(String.class);
		}
		return successFlag;
	}

	private void updateProductInventory(String productId, String productCount) {
		int remainingProductCount = 0;
		int inventoryProductCount = 0;
		@SuppressWarnings("unused")
		String updateSuccess = null;
		
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client client = Client.create(clientConfig);
		WebResource webResource1 = client.resource("http://localhost:8181/eCommerce/inventory/get");
		String input1 = "{\"product_id\":\""+productId+"\", \"product_count\":\""+productCount+"\"}";
		ClientResponse response1 = webResource1.type("application/json").post(ClientResponse.class, input1);
		if (response1.getStatus() == 201 || response1.getStatus() == 200) {
			inventoryProductCount = Integer.parseInt(response1.getEntity(String.class));
		}
		
		remainingProductCount = inventoryProductCount - Integer.parseInt(productCount);
		
		WebResource webResource2 = client.resource("http://localhost:8181/eCommerce/inventory/update");
		String input2 = "{\"product_id\":\""+productId+"\", \"product_count\":\""+remainingProductCount+"\"}";
		ClientResponse response2 = webResource2.type("application/json").post(ClientResponse.class, input2);
		if (response2.getStatus() == 201 || response2.getStatus() == 200) {
			updateSuccess = response2.getEntity(String.class);
		}
		
	}
}
