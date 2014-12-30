package com.tcs.ilp.crud.beans;
/**
* this is the bean class
      * @author-vivek(668543)     
      * @version-1.0
      * @Class RewardPoints
      * @Creation 7/8/2012
    */


public class RewardPoints {
	private String rewardId;
	private int startRange,endRange,rewardPoints;


	/**
	 * @author-vivek(668543)
	 * @return the rewardId
	 */
	
	public String getRewardId() {
		return rewardId;
	}

	/**
	 *  @author-vivek(668543)
	 * @param rewardId the rewardId to set
	 */
	
	public void setRewardId(String rewardId) {
		this.rewardId = rewardId;
	}

	/**
	 *  @author-vivek(668543)
	 * @return the startRange
	 */
	
	public int getStartRange() {
		return startRange;
	}

	/**
	 *  @author-vivek(668543)
	 * @param startRange the startRange to set
	 */
	
	public void setStartRange(int startRange) {
		this.startRange = startRange;
	}

	/**
	 *  @author-vivek(668543)
	 * @return the endRange
	 */
	
	public int getEndRange() {
		return endRange;
	}

	/**
	 *  @author-vivek(668543)
	 * @param endRange the endRange to set
	 */
	
	public void setEndRange(int endRange) {
		this.endRange = endRange;
	}

	/**
	 *  @author-vivek(668543)
	 * @return the rewardPoints
	 */
	
	public int getRewardPoints() {
		return rewardPoints;
	}

	/**
	 *  @author-vivek(668543)
	 * @param rewardPoints the rewardPoints to set
	 */
	
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	/**
	 *  @author-vivek(668543)
	 *  default constructor
	 */
	public RewardPoints() {
		
	}

	/**
	 *  @author-vivek(668543)
	 *  parameterized constructor
	 */
	
	public RewardPoints(int startRange, int endRange,
			int rewardPoints) {
		this.startRange = startRange;
		this.endRange = endRange;
		this.rewardPoints = rewardPoints;
	}

	



}
