package com.ecommerce.service.transactions;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import com.ecommerce.bean.Inventory;
import com.ecommerce.constants.Constants;
import com.ecommerce.dao.transactions.InventoryDao;

@Path("/inventory")
public class InventoryService {

	@POST
	@Path("/check")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String checkInventory(Inventory productInventory) {		
		
		InventoryDao inventoryDao = new InventoryDao();
		String productId = productInventory.getProduct_id(); 
		int productCount = Integer.parseInt(productInventory.getProduct_count());
		
		boolean mongoFlag = inventoryDao.isProductAvailable(productId);
		boolean mysqlFlag = false;

		if(mongoFlag) {
			if ( inventoryDao.getInventory(productId) - productCount >= 0) {
				mysqlFlag = true;
			}
		}
			
		if(mysqlFlag && mongoFlag)
			return Constants.AVAILABLE;
		
		return Constants.EMPTY_STRING;
	}
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String updateInventory(Inventory productInventory) {		
		
		InventoryDao inventoryDao = new InventoryDao();
		
		boolean updateFlag = inventoryDao.updateInventory(productInventory.getProduct_id(), productInventory.getProduct_count());
			
		if(updateFlag)
			return Constants.SUCCESS;
		
		return Constants.FAILURE;
	}
	
	@POST
	@Path("/get")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String getInventory(Inventory productInventory) {		
		
		InventoryDao inventoryDao = new InventoryDao();
		
		int product_count = inventoryDao.getInventory(productInventory.getProduct_id());
			
		return String.valueOf(product_count);
	}
	
	@POST
	@Path("/checkAvailibility")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String checkMongoAvailibility(Inventory productInventory) {		
		
		InventoryDao inventoryDao = new InventoryDao();
		String productId = productInventory.getProduct_id(); 
		
		boolean mongoFlag = inventoryDao.isProductAvailable(productId);
		boolean dateFlag = false;
		
		if(mongoFlag) {
			dateFlag = inventoryDao.isWithinDateRange(productId);
		}
			
		if(dateFlag && mongoFlag)
			return Constants.AVAILABLE;
		
		return Constants.EMPTY_STRING;
	}
}
