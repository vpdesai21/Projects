package test.com.tcs.ilp.crud.test_dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.tcs.ilp.crud.beans.RewardPoints;
import com.tcs.ilp.crud.dao.RewardPointsDao;
import com.tcs.ilp.crud.utility.RewardAllocationRangeAlreadyExists;


public class RewardPointsTestCases {
	public static final Logger logger = Logger.getLogger
	(RewardPointsTestCases.class);
	RewardPoints rewardPoints=null;

//	//public void addRewardPoints() throws RewardIdAlreadyExists{
//		//return new RewardPointsDao().addRewardPoints(rewardPoints);
//		//rewardPoints=new RewardPoints("1",100,200,500);
//		int numberOfRowsInserted =new RewardPointsDao().addRewardPoints(rewardPoints);
//		if(numberOfRowsInserted==1){
//			logger.debug("Reward Points added");
//			logger.debug("Test Case Passed: addRewardPointsTestCase");
//		}else{
//			logger.error("Reward Points adition failed");
//			logger.error("Test Case Failed: addRewardPointsTestCase");
//		}
//	//}

	public void addRewardPoints() throws RewardAllocationRangeAlreadyExists{
		//return new RewardPointsDao().addRewardPoints(rewardPoints);
		rewardPoints=new RewardPoints(6001,9999,200);
		int numberOfRowsInserted =new RewardPointsDao().addRewardPoints(rewardPoints);
		if(numberOfRowsInserted==1){
			logger.debug("Reward Points added");
			logger.debug("Test Case Passed: addRewardPointsTestCase");
		}else{
			logger.error("Reward Points adition failed");
			logger.error("Test Case Failed: addRewardPointsTestCase");
		}
	}


	public void updateRewardPoints() {
		//return new RewardPointsDao().updateRewardPoints(rewardId);

		//rewardPoints=new RewardPoints("1",100,200,600);

		rewardPoints=new RewardPoints(500,1399,50);
		rewardPoints.setRewardId("RID8");

		int numberOfRowsInserted =new RewardPointsDao().updateRewardPoints(rewardPoints);
		if(numberOfRowsInserted==1){
			logger.debug("Reward Points updated");
			logger.debug("Test Case Passed: updateRewardPointsTestCase");
		}else{
			logger.error("Reward Points updation failed");
			logger.error("Test Case Failed: updateRewardPointsTestCase");
		}
	}

	public void viewRewardPoints(){
		//return new RewardPointsDao().viewRewardPoints(rewardId);
		rewardPoints=new RewardPointsDao().viewRewardPoints("RID1");
		if(rewardPoints!=null){
			logger.info(rewardPoints.getRewardId());
			logger.debug("  sucess");
		}
		else{
			logger.error("failure");
		}
	}
	
	public void viewAllRewardPoints() {
		//return new RewardPointsDao().viewAllRewardPoints();
		ArrayList<RewardPoints> rpList=null;
		rpList=new RewardPointsDao().viewAllRewardPoints();
		if(rpList!=null){
			for(int i=0;i<rpList.size();i++){
				logger.info(rpList.get(i).getRewardPoints());
			}
		}
		else{
			logger.error("failure");
		}
	}
	
	public void deleteRewardPoints(){
		//return new RewardPointsDao().deleteRewardPoints(rewardId);
		int del=new RewardPointsDao().deleteRewardPoints("1");
		if(del==1){
			logger.debug("  sucess");
		}
		else{
			logger.error("failure");
		}
	}

//	public static void main(String s[]) throws RewardIdAlreadyExists{
//		RewardPointsTestCases rt=new RewardPointsTestCases();
//		//rt.addRewardPoints();
//		//rt.updateRewardPoints();
//		//rt.viewRewardPoints();
//		//rt.viewAllRewardPoints();
//		rt.deleteRewardPoints();
//	}

	public static void main(String s[]) {
		RewardPointsTestCases rt=new RewardPointsTestCases();
		//rt.addRewardPoints();
		//rt.updateRewardPoints();
		//rt.viewRewardPoints();
		rt.viewAllRewardPoints();
		//rt.deleteRewardPoints();
	}

}
