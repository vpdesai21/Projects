package com.ecommerce.service.transactions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.ecommerce.bean.Transaction;
import com.ecommerce.constants.Constants;
import com.ecommerce.dao.transactions.TransactionDao;

@Path("/transaction")
public class TransactionService {

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String saveTransaction(Transaction transactionDetails, 
			@Context HttpServletRequest req) {
		TransactionDao transactionDao = new TransactionDao();
		int successTransactionId = transactionDao.saveTransaction(transactionDetails.getUser_id(), transactionDetails.getAddress_id(), transactionDetails.getPayment_id(), transactionDetails.getOrder_placed_timestamp());

		if(successTransactionId != -1)
			return String.valueOf(successTransactionId);
		else
			return Constants.EMPTY_STRING;
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String updateTransaction(Transaction transactionDetails, 
			@Context HttpServletRequest req) {
		TransactionDao transactionDao = new TransactionDao();
		boolean updateSuccessful = transactionDao.updateTransaction(transactionDetails.getOrder_id(), transactionDetails.getOrder_updated_timestamp(), transactionDetails.getIs_cancelled());

		if(updateSuccessful)
			return Constants.SUCCESS;
		else
			return Constants.FAILURE;
	}
	
	@POST
	@Path("/getAll")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transaction> getAllTransactions(Transaction transactionDetails, 
			@Context HttpServletRequest req) {
		TransactionDao transactionDao = new TransactionDao();
		List<Transaction> orderList = new ArrayList<Transaction>();
		orderList = transactionDao.getAllTransactions(transactionDetails.getUser_id());
		
		if(orderList != null && orderList.size() > 0)
			return orderList;
		else
			return null;
	}
}
