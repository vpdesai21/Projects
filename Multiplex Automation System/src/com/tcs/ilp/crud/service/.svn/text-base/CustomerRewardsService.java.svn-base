package com.tcs.ilp.crud.service;

import java.util.ArrayList;

import com.tcs.ilp.crud.beans.CustomerReward;
import com.tcs.ilp.crud.beans.RewardPoints;
import com.tcs.ilp.crud.dao.CustomerRewardsDao;
import com.tcs.ilp.crud.dao.RewardPointsDao;
/**
*  Class CustomerRewardsService - Contains the Business Logic
      * @author - Prantik(676339)   
      * @version  - 1.0    
      * @Class CustomerRewardsService
      * @Creation - 7-8-2012
*/
public class CustomerRewardsService 
{
	CustomerRewardsDao customerRewardsDao=null;
	CustomerReward customerReward=null;
	/**
	 * @Author - Prantik(676339)
	 * this method transfers control to getCustomerReward() of CustomerRewardDao class
	 * and returns a bean object of CustomerReward class
	 * 
	 * @param customerId
	 * @return CustomerReward
	 */
	
	public CustomerReward getCustomerRewards(String customerId)
	{
		customerRewardsDao=new CustomerRewardsDao();
		customerReward=customerRewardsDao.getCustomerReward(customerId);
		return customerReward;	
	}
	/**
	 *  @Author - Prantik(676339)
	 * this method transfers control to getAllCustomerReward() of CustomerRewardDao class
	 * and returns an arrayList of CustomerReward class
	 * 
	 * @return ArrayList<CustomerReward>
	 */
	
	
	public ArrayList<CustomerReward> getAllCustomerReward()
	{
		customerRewardsDao=new CustomerRewardsDao();
		ArrayList<CustomerReward> customerRewardList=new ArrayList<CustomerReward>();
		customerRewardList=customerRewardsDao.getAllCustomerReward();
		return customerRewardList;
		
	}
	/**
	 * @Author - Vivek(668543)
	 * this method allocate rewards to customer by calling getCustomerReward(), 
	 * getLastBookingPrice(),addCustomerReward(),updateCustomerReward() of CustomerRewardDao class
	 * and viewAllRewardPoints() of RewardPointsDao class.
	 * and returns a bean object of CustomerReward class
	 * 
	 * @param customerId
	 * @return CustomerReward
	 */
	 
	
	public CustomerReward allocateReward(String customerId){
		
		int i=0,totalprice=0,rewardBalance=0,carry=0,t=0;
		
		
		customerRewardsDao=new CustomerRewardsDao();
		customerReward=customerRewardsDao.getCustomerReward(customerId);
		CustomerReward crr=null;
		
		totalprice=customerRewardsDao.getLastBookingPrice(customerId);
		
		if(totalprice==0){
			return crr;
		}
		if(customerReward==null){
			t=1;
				carry=totalprice;
				ArrayList<RewardPoints> rewardList=new RewardPointsDao().viewAllRewardPoints();
				if(rewardList.size()>0){
					for(int j=0;j<rewardList.size();j++){
						
						if(totalprice>=rewardList.get(j).getStartRange() && totalprice<=rewardList.get(j).getEndRange()){
							rewardBalance=rewardList.get(j).getRewardPoints();
							carry=0;
							CustomerReward cr=new CustomerReward(customerId,rewardBalance,carry,"y","y");
							i=customerRewardsDao.addCustomerReward(cr);
							break;
						}
					}
				
			}
				if(i==0){
					CustomerReward cr=new CustomerReward(customerId,rewardBalance,carry,"y","y");
					i=customerRewardsDao.addCustomerReward(cr);
				}
		}
		else{
			t=1;
			
			 totalprice+=(int)customerReward.getCarryAmount();
			 rewardBalance=customerReward.getRewardPointsBalance();
				ArrayList<RewardPoints> rewardList=new RewardPointsDao().viewAllRewardPoints();
				carry=totalprice;
				if(rewardList.size()>0){
					for(int j=0;j<rewardList.size();j++){
						
						if(totalprice>=rewardList.get(j).getStartRange() && totalprice<=rewardList.get(j).getEndRange()){
							
							rewardBalance+=rewardList.get(j).getRewardPoints();
							carry=0;
							
							CustomerReward cr=new CustomerReward(customerId,rewardBalance,carry,"y","y");
							i=customerRewardsDao.updateCustomerReward(cr);
							
							
							break;
						}
					}
				}
				if(i==0){
					CustomerReward cr=new CustomerReward(customerId,rewardBalance,carry,"y","y");
					i=customerRewardsDao.updateCustomerReward(cr);
				}
			
		}
		
	
		if(t!=0){
			crr=new CustomerReward();
			crr.setRewardPointsBalance(rewardBalance);
			crr.setCarryAmount(carry);
		}
		return crr;
	}
}
