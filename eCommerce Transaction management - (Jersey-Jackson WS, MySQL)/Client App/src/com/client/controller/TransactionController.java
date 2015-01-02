package com.client.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.client.bean.TransactionDetails;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class TransactionController extends HttpServlet 
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
			String userId= (String)ses.getAttribute("userId");
			String orderId= null;
			String addressId= null;

			if(request.getParameter("deleteRequest") != null && request.getParameter("deleteRequest").equalsIgnoreCase("true")) {
				String order_id = request.getParameter("order_id");
				boolean flag = cancelTransaction(order_id);
				if(flag)
					updateInventory(order_id);

				response.sendRedirect(getServletContext().getContextPath()+"/viewAllTransactions");
			} else {

				List<TransactionDetails> transactionDetailsList = new ArrayList<TransactionDetails>();

				String transactions = getAllTransactions(userId);
				if(transactions != null && !transactions.equalsIgnoreCase("")) {

					JSONArray transactionArray = new JSONArray(transactions);
					for (int i = 0; i < transactionArray.length(); i++) {

						TransactionDetails transaction = new TransactionDetails();
						JSONObject transactionObject = transactionArray.getJSONObject(i);

						orderId = transactionObject.getString("order_id");
						transaction.setOrder_id(orderId);

						addressId = transactionObject.getString("address_id");
						String addressDetails = getAddressDetails(addressId);
						transaction.setShipping_address(addressDetails);

						String productDetails = getProductDetails(orderId);
						transaction.setProduct_details(productDetails);

						String productCount = getProductCount(orderId);
						transaction.setProduct_quantity(productCount);

						String orderDate = transactionObject.getString("order_placed_timestamp");
						transaction.setOrder_date(orderDate);

						String isCancelled = transactionObject.getString("is_cancelled");
						transaction.setIs_cancelled(isCancelled);

						if(isCancelled.equalsIgnoreCase("y")) {
							transaction.setOrder_status("Cancelled");
						}
						else {
							String status = getStatusBasedOnOrderTime(orderDate);
							transaction.setOrder_status(status);
						}

						transactionDetailsList.add(transaction);
					}

					if(transactionDetailsList.size() > 0) {
						ses.setAttribute("transactionDetails", transactionDetailsList);
						response.sendRedirect(getServletContext().getContextPath()+"/public/jsp/transactions.jsp");
					}

				} else {
					ses.setAttribute("error_generic", "yes");
					response.sendRedirect(getServletContext().getContextPath()+"/public/jsp/success.jsp");
				}
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




	private String getAllTransactions(String userId) {
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		String listOfTransactions = null;
		Client client = Client.create(clientConfig);
		WebResource webResource1 = client.resource("http://localhost:8181/eCommerce/transaction/getAll");
		String input1 = "{\"user_id\":\""+userId +"\"}";
		ClientResponse response1 = webResource1.type("application/json").post(ClientResponse.class, input1);
		if (response1.getStatus() == 201 || response1.getStatus() == 200) {
			listOfTransactions = response1.getEntity(String.class);
		}

		return listOfTransactions;
	}




	private String getAddressDetails(String addressId) {
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		String addressDetails = null;
		Client client = Client.create(clientConfig);
		WebResource webResource1 = client.resource("http://localhost:8181/eCommerce/address/get");
		String input1 = "{\"address_id\":\""+addressId +"\"}";
		ClientResponse response1 = webResource1.type("application/json").post(ClientResponse.class, input1);
		if (response1.getStatus() == 201 || response1.getStatus() == 200) {
			addressDetails = response1.getEntity(String.class);
		}

		return addressDetails;
	}



	private String getProductDetails(String orderId) {
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		String productDetails = null;
		Client client = Client.create(clientConfig);
		WebResource webResource1 = client.resource("http://localhost:8181/eCommerce/productToTransaction/getProductDetails");
		String input1 = "{\"order_id\":\""+orderId +"\"}";
		ClientResponse response1 = webResource1.type("application/json").post(ClientResponse.class, input1);
		if (response1.getStatus() == 201 || response1.getStatus() == 200) {
			productDetails = response1.getEntity(String.class);
		}

		return productDetails;
	}




	private String getProductCount(String orderId) {
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		String productCount = null;
		Client client = Client.create(clientConfig);
		WebResource webResource1 = client.resource("http://localhost:8181/eCommerce/productToTransaction/getProductCount");
		String input1 = "{\"order_id\":\""+orderId +"\"}";
		ClientResponse response1 = webResource1.type("application/json").post(ClientResponse.class, input1);
		if (response1.getStatus() == 201 || response1.getStatus() == 200) {
			productCount = response1.getEntity(String.class);
		}

		return productCount;
	}



	private boolean cancelTransaction(String order_id) {
		SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
		String formattedDate = format1.format(new Date());

		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		String updateSuccessFlag = null;
		Client client = Client.create(clientConfig);
		WebResource webResource1 = client.resource("http://localhost:8181/eCommerce/transaction/update");
		String input1 = "{\"order_id\":\""+order_id +"\", \"order_updated_timestamp\":\""+ formattedDate +"\", \"is_cancelled\":\"Y\"}";
		ClientResponse response1 = webResource1.type("application/json").post(ClientResponse.class, input1);
		if (response1.getStatus() == 201 || response1.getStatus() == 200) {
			updateSuccessFlag = response1.getEntity(String.class);
		}

		if(updateSuccessFlag!=null && updateSuccessFlag.equalsIgnoreCase("success"))
			return true;
		else
			return false;
	}



	private void updateInventory(String order_id) {
		String product_id = null;
		String product_count = null;
		String product_inventory = null;
		@SuppressWarnings("unused")
		String updateSuccess = null;

		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource1 = client.resource("http://localhost:8181/eCommerce/productToTransaction/getProductId");
		String input1 = "{\"order_id\":\""+order_id +"\"}";
		ClientResponse response1 = webResource1.type("application/json").post(ClientResponse.class, input1);
		if (response1.getStatus() == 201 || response1.getStatus() == 200) {
			product_id = response1.getEntity(String.class);
		}

		product_count = getProductCount(order_id);

		WebResource webResource2 = client.resource("http://localhost:8181/eCommerce/inventory/get");
		String input2 = "{\"product_id\":\""+product_id+"\"}";
		ClientResponse response2 = webResource2.type("application/json").post(ClientResponse.class, input2);
		if (response2.getStatus() == 201 || response2.getStatus() == 200) {
			product_inventory = response2.getEntity(String.class);
		}

		int updatedCount = Integer.parseInt(product_inventory)  + Integer.parseInt(product_count);

		WebResource webResource3 = client.resource("http://localhost:8181/eCommerce/inventory/update");
		String input3 = "{\"product_id\":\""+product_id +"\", \"product_count\":\""+updatedCount +"\"}";
		ClientResponse response3 = webResource3.type("application/json").post(ClientResponse.class, input3);
		if (response3.getStatus() == 201 || response3.getStatus() == 200) {
			updateSuccess = response3.getEntity(String.class);
		}

	}





	private String getStatusBasedOnOrderTime(String orderDate) {
		try {
			String status = null;
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date orderTime = format1.parse(orderDate);
			Date currentDate = new Date();
			long diffInMillies = currentDate.getTime() - orderTime.getTime();
			if(diffInMillies >= (3*86400000))
				status = "Delivered";
			else
				status = "Shipped";

			return status;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}
}
