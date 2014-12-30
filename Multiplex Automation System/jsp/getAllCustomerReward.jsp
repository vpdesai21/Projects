<%@ page import="com.tcs.ilp.crud.beans.CustomerReward,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<%@ include file="./header-files.jsp" %>

	<title>Reward Points</title>

	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/pageDesign.css" />
	
	
	</head>

<body>

<%@ include file="./header.jsp" %>

		<div id="navigation-block">
        	
            
            <ul id="sliding-navigation">
                <li class="sliding-element"><a class="one" href="<%=application.getContextPath() %>/jsp/adminHome.jsp">Home</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/addRewardPoints.jsp">Add Reward Point Details</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/viewAllRewardPoints?requestType=viewAllRewardPoints">View & Delete All Reward Point Details</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/viewRewardPoints?requestType=viewRewardPoints">View All Reward Point Details</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/allocateReward.jsp">Allocate Reward Points</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/getCustomerReward.jsp">View Reward Points for Customer</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/getAllCustomerReward?requestType=getAllCustomerReward">View Customer Reward Points Table</a></li>
            </ul>
        </div>


		<div class="rewardPoints">
		
		<form name="getAllCustomerReward" method="post" action="<%=application.getContextPath() %>/getAllCustomerReward">
			<table style="margin-top:0%;border-style:groove;" align="center" cellspacing="10">
			
			
			<tr>
			<td align="right" style="color:khaki"><b>Customer ID</b></td>
			<td align="right" style="color:khaki"><b>Reward Points Balance</b></td>
			<td align="right" style="color:khaki"><b>Carry Amount</b></td>
			<td align="right" style="color:khaki"><b>Flag for Movie Price</b></td>
			<td align="right" style="color:khaki"><b>Flag for Snacks</b></td>
			</tr>
			
			
			<% ArrayList<CustomerReward> customerRewardList=(ArrayList<CustomerReward>)request.getAttribute("customerRewardList");
			CustomerReward cr=null;
			if(customerRewardList!=null)
			{
			for(int i=0; i<customerRewardList.size(); i++){
				cr = customerRewardList.get(i);
			
			if(cr.getCustomerRewardId()!=null){
			%>
			
			<tr>
			<td align="right" ><%=cr.getCustomerId() %></td>
			<td align="right" ><%=cr.getRewardPointsBalance() %></td>
			<td align="right" ><%=cr.getCarryAmount() %></td>
			<td align="right" ><%=cr.getFlagMoviePrice() %></td>
			<td align="right" ><%=cr.getFlagSnacks() %></td>
			</tr>
			
			<tr><% }} %></tr>
			<%
			}
			%>
			
			<tr>
			<td>
			<input type="hidden" name="requestType" value="getAllCustomerReward"></input></td>
			</tr>
			
			</table>
			
		</form>
		
		</div>

</body>
</html>