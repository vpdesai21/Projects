package test.com.tcs.ilp.crud.test_dao;

import java.util.ArrayList;

import com.tcs.ilp.crud.beans.CustomerReward;
import com.tcs.ilp.crud.dao.CustomerRewardsDao;
import com.tcs.ilp.crud.service.CustomerRewardsService;

public class CustomerRewardTestCases 
{
	CustomerRewardsDao test1=new CustomerRewardsDao();
	public void allocateReward()
	{
		CustomerRewardsService crs=new CustomerRewardsService();
		crs.allocateReward("CID1");
		System.out.println("");
	}
	public void getAllCustomerReward()
	{
		ArrayList<CustomerReward> crList=test1.getAllCustomerReward();
		System.out.println(crList.size()+" "+crList.get(0).getCustomerId());
	}
	public void getCustomerRewards()
	{
		CustomerReward cr=test1.getCustomerReward("CID1");
		System.out.println(""+cr.getCarryAmount());
	}
	public void addCustomerReward()
	{
		CustomerReward cr=new CustomerReward("CID2",100,200,"y","n");
		int cr1=test1.addCustomerReward(cr);
		System.out.println(""+cr1);
	}
	public static void main(String args[])
	{
		CustomerRewardTestCases test=new CustomerRewardTestCases();
		
		//test.addCustomerReward();
		//test.getCustomerRewards();
		//test.getCustomerRewards(customerId);
		test.getAllCustomerReward();
		//test.allocateReward();
	}
	
}
