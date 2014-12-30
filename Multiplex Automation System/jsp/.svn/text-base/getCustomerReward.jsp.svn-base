<%@ page import="com.tcs.ilp.crud.beans.CustomerReward" language="java" contentType="text/html; charset=ISO-8859-1"
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



		<div style="position:absolute; top: 120px; left:280px; color:azure;"> 
		
			<form name="getCustomerReward" action="<%=application.getContextPath() %>/getCustomerReward">
				
				<table align="center">
				
				<% CustomerReward cr=(CustomerReward)session.getAttribute("customerReward"); 
				String flag=(String)session.getAttribute("flag");%>
				
				
				<tr>
				<td align="right"><b>Customer Id:</b></td>
				
				<%if(cr==null) {%>
				<td><input type="text" name="customerId" value="" maxlength="10"></input></td> 
				<td> <input type="submit" name="go" value="View"></input></td>
				
				<%if (flag!=null) { %>
				<font color="red">Enter correct Customer ID</font>
				
				<%}}
				else { %>
				
				<td><input type="text" name="customerId" value=<%=cr.getCustomerId()%> maxlength="10"></input></td> 
				<td> <input type="submit" name="go" value="View"></input></td>
				
				</tr>
				
				
				<tr>
				<td align="right" ><b>Reward Points Balance:</b></td>
				<td><%=cr.getRewardPointsBalance()%> </td>
				</tr>
				
				
				<tr>
				<td align="right" ><b>Carry Amount:</b></td>
				<td><%=cr.getCarryAmount()%></td>
				</tr>
				
				
				<tr>
				<td align="right"><b>Flag Movie Price:</b></td>
				<td><%=cr.getFlagMoviePrice()%></td>
				</tr>
				
				
				<tr>
				<td align="right"><b>Flag Snacks:</b></td>
				<td><%=cr.getFlagSnacks()%></td>
				</tr>
				<%} %>
				
				
				<tr>
				<td><input type="hidden" name="requestType" value="getCustomerReward"></input></td>
				<td></td>
				</tr>
				
				</table>
				
			</form>
		
		</div>		

	
	<div style="position:relative; top:100px; left:800px;" >	
		<img src="<%=application.getContextPath() %>/images/stars.png"  width="120" height="130" />
	</div>

	<% session.removeAttribute("customerReward");
	session.removeAttribute("flag");%>





</body>
</html>