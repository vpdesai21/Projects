package com.ecommerce.service.transactions;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.ecommerce.bean.PaymentDetails;
import com.ecommerce.constants.Constants;
import com.ecommerce.dao.transactions.PaymentDao;

@Path("/payment")
public class PaymentService {

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String savePaymentDetails(PaymentDetails paymentDetails) {
		PaymentDao paymentDao = new PaymentDao();
		int successPaymentId = paymentDao.savePaymentDetails(paymentDetails.getUser_id(), paymentDetails.getCard_holder_name(), paymentDetails.getExpiration_date(), paymentDetails.getCard_number(), paymentDetails.getCvv_code());
		
		if(successPaymentId != -1)
			return String.valueOf(successPaymentId);
		else
			return Constants.EMPTY_STRING;
	}
}
