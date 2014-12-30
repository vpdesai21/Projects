package com.tcs.ilp.crud.service;


import java.util.ArrayList;

import com.tcs.ilp.crud.beans.RewardPoints;
import com.tcs.ilp.crud.dao.RewardPointsDao;
import com.tcs.ilp.crud.utility.RewardAllocationRangeAlreadyExists;

/**
*  Class RewardPointsService - Contains the Business Logic
      * @author - Sonali(675528)   
      * @version  - 1.0    
      * @Class RewardPointsService
      * @Creation - 7-8-2012
*/

public class RewardPointsService {
	/**
	 * @Author - Sonali(675528)
	 * this method transfers control to addRewardPoints() of RewardPointsDao class
	 * and returns a noOfRowsAdded.
	 * 
	 * @param rewardPoints
	 * @return int <no of rows added>
	 * @throws RewardAllocationRangeAlreadyExists 
	 */
	
	public int addRewardPoints(RewardPoints rewardPoints) throws RewardAllocationRangeAlreadyExists
	{
		return new RewardPointsDao().addRewardPoints(rewardPoints);
	}

	/**
	 *  @Author - Prantik(676339)
	 *  this method transfers control to updateRewardPoints() of RewardPointsDao class
	 * and returns a noOfRowsUpdated.
	 * 
	 * @param rewardPoints
	 * @return int<no of rows updated>
	 */

	public int updateRewardPoints(RewardPoints rewardPoints) 
	{
		return new RewardPointsDao().updateRewardPoints(rewardPoints);
	}

	/**
	 * @Author - Sonali(675528)
	 *  this method transfers control to viewRewardPoints() of RewardPointsDao class
	 * and returns a bean object of RewardPoints.
	 * 
	 * @param rewardId
	 * @return RewardPoints<reward detail for a reward id>
	 */
	
	public RewardPoints viewRewardPoints(String rewardId)
	{
		return new RewardPointsDao().viewRewardPoints(rewardId);
	}
	
	/**
	 * @Author - Sonali(675528)
	 * this method transfers control to viewAllRewardPoints() of RewardPointsDao class
	 * and returns an arrayList of RewardPoints class
	 * 
	 * @return ArrayList<RewardPoints>
	 */

	public ArrayList<RewardPoints> viewAllRewardPoints()
	{
		return new RewardPointsDao().viewAllRewardPoints();
	}
	
	/**
	 *  @Author - Sonali(675528)
	 * this method transfers control to deleteRewardPoints() of RewardPointsDao class
	 * and returns a noOfRowsDeleted.
	 * 
	 * @param rewardId
	 * @return int <no of rows deleted>
	 */

	public int deleteRewardPoints(String rewardId)
	{
		return new RewardPointsDao().deleteRewardPoints(rewardId);
	}
}
