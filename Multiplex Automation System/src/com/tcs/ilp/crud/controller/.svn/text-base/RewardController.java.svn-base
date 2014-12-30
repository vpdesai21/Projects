package com.tcs.ilp.crud.controller;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tcs.ilp.crud.beans.CustomerReward;
import com.tcs.ilp.crud.beans.RewardPoints;
import com.tcs.ilp.crud.service.CustomerRewardsService;
import com.tcs.ilp.crud.service.RewardPointsService;
import com.tcs.ilp.crud.utility.RewardAllocationRangeAlreadyExists;
//import com.tcs.ilp.crud.utility.RewardIdAlreadyExists;

@SuppressWarnings({ "serial" })
/**
* RewardController Class - Controls the flow
      * @author - Vivek (668543)  
      * @version  - 1.0    
      * @Class RewardController
      * @Creation - 7-8-2012
*/


public class RewardController extends HttpServlet
{
	public static final Logger logger = Logger.getLogger(RewardController.class);
	RewardPointsService rewardPointsService;
	CustomerRewardsService customerRewardService;
	/*
	 * @author-vivek(668543)
	 * this method is to get request from jsp page when method is "get"
	 *	@param request
	 * @param response
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestType=request.getParameter("requestType");

	    if(requestType.equalsIgnoreCase("addRewardPoints"))
		{
			addRewardPoints(request,response);
		}
		else if(requestType.equalsIgnoreCase("deleteRewardPoints"))
		{
			deleteRewardPoints(request,response);
		}
		else if(requestType.equalsIgnoreCase("viewAllRewardPoints"))
		{
			viewAllRewardPoints(request,response);
		}
		else if(requestType.equalsIgnoreCase("getCustomerReward"))
		{
			getCustomerReward(request,response);
		}
		else if(requestType.equalsIgnoreCase("getAllCustomerReward"))
		{
			getAllCustomerReward(request,response);
		}
		else if(requestType.equalsIgnoreCase("allocateReward"))
		{
			allocateReward(request, response);
		}
	}
	/*
	 * @author-vivek(668543)
	 * this method is to get request from jsp page when method is "post"
	 * @param request
	 * @param response
	 */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	/**
	 * @author-prantik(676339)
	 * this method displays all the records of customer regarding rewardPoints
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	
	private void getAllCustomerReward(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		
		customerRewardService = new CustomerRewardsService();
		ArrayList<CustomerReward> customerRewardList=customerRewardService.getAllCustomerReward();
		//HttpSession session = request.getSession();
		request.setAttribute("customerRewardList",customerRewardList);
		RequestDispatcher rd=request.getRequestDispatcher("jsp/getAllCustomerReward.jsp");
		try
		{
		rd.forward(request,response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.error("Exception Occurred :"+e);
		}
	}
	/**
	 * @author-prantik(676339)
	 * this method returns a reward details of a particular customer
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	private void getCustomerReward(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		
		customerRewardService = new CustomerRewardsService();
		CustomerReward customerReward=new CustomerReward();
		String customerId=request.getParameter("customerId");
		customerReward=customerRewardService.getCustomerRewards(customerId);
		HttpSession session = request.getSession();
		session.setAttribute("customerReward", customerReward);
		try
		{
			
			session.setAttribute("flag", "flag");
			response.sendRedirect("./jsp/getCustomerReward.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.error("Exception Occurred :"+e);
		}
	}
	/**
	 *  @author-sonali(675528)
	 * this method displays the reward points table
	 *
	 * 
	 * @param request
	 * @param response
	 */
			
	private void viewAllRewardPoints(HttpServletRequest request,
			HttpServletResponse response) {
		ArrayList <RewardPoints> rewardList;
		rewardList=new RewardPointsService().viewAllRewardPoints();
		
		request.setAttribute("rewardList", rewardList);
		RequestDispatcher rd=request.getRequestDispatcher("./jsp/viewAllRewardPoints.jsp");
		try {
			rd.forward(request, response);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 	@author-sonali(675528)
	 * this method deletes a record of reward points table
	 * 
	 * @param request
	 * @param response
	 */		

	private void deleteRewardPoints(HttpServletRequest request,
			HttpServletResponse response) {
		String rewardId=request.getParameter("rewardId");
		int noOfRowsDeleted=new RewardPointsService().deleteRewardPoints(rewardId);
		if (noOfRowsDeleted!=0)
		{
			viewAllRewardPoints(request, response);
			/*try
			{
				response.sendRedirect("./jsp/deleteRewardPointsSuccess.jsp");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
		}
	}
	/**
	 * @author-prantik(676339)
	 * this method is used for updating a reward details of customer
	 
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
			
	/*private void updateRewardPoints(HttpServletRequest request,HttpServletResponse response) throws IOException 
	{
		String rewardId=request.getParameter("rewardId");
		String startRangeStr = request.getParameter("startRange");
		String endRangeStr = request.getParameter("endRange");
		String rewardPointsStr = request.getParameter("rewardPoints");
		int startRange = Integer.parseInt(startRangeStr);
		int endRange = Integer.parseInt(endRangeStr);
		int rewardPoints = Integer.parseInt(rewardPointsStr);
		logger.debug(rewardId+" "+startRange+" "+endRange+" "+rewardPoints);
		RewardPoints rewardPoint = new RewardPoints();
		rewardPointsService = new RewardPointsService();
		rewardPoint.setRewardId(rewardId);
		rewardPoint.setStartRange(startRange);
		rewardPoint.setEndRange(endRange);
		rewardPoint.setRewardPoints(rewardPoints);

		int i=rewardPointsService.updateRewardPoints(rewardPoint);
		response.sendRedirect("./jsp/updateRewardPointsSuccess.jsp");
		
	}*/
	/**
	 *  @author-prantik(676339)
	 * this method redirects control to update page with all data
	 * 
	 * @param request
	 * @param response
	 */
	 
	/*private void setupForUpdateRewardPoints(HttpServletRequest request,HttpServletResponse response) 
	{
		String rewardId = request.getParameter("rewardId");
		rewardPointsService = new RewardPointsService();
		RewardPoints rewardPoints = rewardPointsService.viewRewardPoints(rewardId);
		//HttpSession session = request.getSession();
		request.setAttribute("rewardPoints", rewardPoints);
		RequestDispatcher rd=request.getRequestDispatcher("./jsp/updateRewardPoints.jsp");
		
		try 
		{
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}*/
	/**
	 *  @author-sonali(675528)
	 * this method is used for adding a reward range to reward points
	 *  table
	 * 
	 * @param request
	 * @param response
	 */
	
	private void addRewardPoints(HttpServletRequest request,
			HttpServletResponse response) {
		RewardPoints rewardPoints = new RewardPoints();
		rewardPoints.setStartRange(Integer.parseInt(request.getParameter("startRange")));
		rewardPoints.setEndRange(Integer.parseInt(request.getParameter("endRange")));
		rewardPoints.setRewardPoints(Integer.parseInt(request.getParameter("rewardPoints")));
		
		try {
			new RewardPointsService().addRewardPoints(rewardPoints);
			response.sendRedirect("./jsp/addRewardPointsSuccess.jsp");
		} 
		catch(RewardAllocationRangeAlreadyExists r){
			try {
				HttpSession session=request.getSession();
				session.setAttribute("exception", r.toString());
				response.sendRedirect("./jsp/addRewardPoints.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
	/**
	 * @author-vivek(668543)
	 * this method is used to allocate reward to a particular customer
	 * 
	 * @param request
	 * @param response
	 */

	private void allocateReward(HttpServletRequest request,
			HttpServletResponse response){
		
		String customerId=request.getParameter("customerId");
		customerRewardService=new CustomerRewardsService();
		CustomerReward cr=customerRewardService.allocateReward(customerId);
	
		HttpSession session=request.getSession();

		session.setAttribute("customerReward", cr);
		session.setAttribute("id", customerId);
		try {
			response.sendRedirect("./jsp/allocateReward.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
