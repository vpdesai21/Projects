<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="./logout.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="./header-files.jsp" %>

<title>Reward Points</title>

</head>

<body>

<%@ include file="./header.jsp" %>
<div id="navigation-block">
        	
            
            <ul id="sliding-navigation">
                <li class="sliding-element"><a class="one" href="<%=application.getContextPath() %>/jsp/adminHome.jsp">Home</a></li>
				
				<% if(session.getAttribute("id").equalsIgnoreCase("admin"))
				{
				
				%>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/addRewardPoints.jsp">Add Reward Point Details</a></li>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/viewAllRewardPoints?requestType=viewAllRewardPoints">View & Delete All Reward Point Details</a></li>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/viewRewardPoints?requestType=viewRewardPoints">View All Reward Point Details</a></li>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/allocateReward.jsp">Allocate Reward Points</a></li>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/getCustomerReward.jsp">View Reward Points for Customer</a></li>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/getAllCustomerReward?requestType=getAllCustomerReward">View Customer Reward Points Table</a></li>
				<%
				}
				else if(session.getAttribute("id").equalsIgnoreCase("customer"))
				{
				
				%>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/viewRewardPoints?requestType=viewRewardPoints">View All Reward Point Details</a></li>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/getAllCustomerReward?requestType=getAllCustomerReward">View Customer Reward Points Table</a></li>
				<% } %>
				
            </ul>
        </div>

	<div style="position:relative; top:120px; left:800px;" >	
		<img src="<%=application.getContextPath() %>/images/stars.png"  width="120" height="130" />
	</div>
	
</body>
</html>