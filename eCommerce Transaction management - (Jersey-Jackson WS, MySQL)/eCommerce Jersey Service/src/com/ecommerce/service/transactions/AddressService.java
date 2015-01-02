package com.ecommerce.service.transactions;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.ecommerce.bean.Address;
import com.ecommerce.constants.Constants;
import com.ecommerce.dao.transactions.AddressDao;

@Path("/address")
public class AddressService {

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String saveAddress(Address addressDetails) {
		AddressDao addressDao = new AddressDao();
		int successAddressId = addressDao.saveAddress(addressDetails.getUser_id(), addressDetails.getAddress_line1(), addressDetails.getAddress_line2(), addressDetails.getCity(), addressDetails.getState(), addressDetails.getZipcode());
		
		if(successAddressId != -1)
			return String.valueOf(successAddressId);
		else
			return Constants.EMPTY_STRING;
	}
	
	@POST
	@Path("/get")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String getAddress(Address addressDetails) {
		AddressDao addressDao = new AddressDao();
		String fullAddress = addressDao.getFullAddress(addressDetails.getAddress_id());
		
		if(fullAddress != null && !fullAddress.equalsIgnoreCase(""))
			return fullAddress;
		else
			return Constants.EMPTY_STRING;
	}
}
