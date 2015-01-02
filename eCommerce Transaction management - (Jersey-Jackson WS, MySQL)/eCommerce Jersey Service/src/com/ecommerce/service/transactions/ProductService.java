package com.ecommerce.service.transactions;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.ecommerce.bean.Product;
import com.ecommerce.constants.Constants;
import com.ecommerce.dao.transactions.ProductDao;

@Path("/productToTransaction")
public class ProductService {

	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String saveProductToTransaction(Product product) {
		ProductDao productDao = new ProductDao();
		boolean successFlag = productDao.saveProductToTransaction(product.getOrder_id(), product.getProduct_id(), product.getProduct_quantity());
		
		if(successFlag)
			return Constants.SUCCESS;
		else
			return Constants.FAILURE;
	}
	
	@POST
	@Path("/getProductDetails")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String getProductDetails(Product product) {
		ProductDao productDao = new ProductDao();
		String productDetails = productDao.getProductDetails(product.getOrder_id());
		
		if(productDetails != null && !productDetails.equalsIgnoreCase(""))
			return productDetails;
		else
			return Constants.EMPTY_STRING;
	}
	
	@POST
	@Path("/getProductCount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String getProductCount(Product product) {
		ProductDao productDao = new ProductDao();
		String productCount = productDao.getProductCount(product.getOrder_id());
		
		if(productCount != null && !productCount.equalsIgnoreCase(""))
			return productCount;
		else
			return "0";
	}
	
	@POST
	@Path("/getProductId")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String getProductId(Product product) {
		ProductDao productDao = new ProductDao();
		String productDetails = productDao.getProductId(product.getOrder_id());
		
		if(productDetails != null && !productDetails.equalsIgnoreCase(""))
			return productDetails;
		else
			return Constants.EMPTY_STRING;
	}
}
