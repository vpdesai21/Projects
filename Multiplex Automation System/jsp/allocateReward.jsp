<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.tcs.ilp.crud.beans.CustomerReward"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/pageDesign.css" />

<%@ include file="./header-files.jsp" %>
<title>Reward Points</title>
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

			<%
			int rewardBalance=0,carryAmount=0;
			CustomerReward cr=(CustomerReward)session.getAttribute("customerReward");
				String id=(String)session.getAttribute("id");
			if(cr!=null){
			rewardBalance=cr.getRewardPointsBalance();
			carryAmount=cr.getCarryAmount();
			}
			%>

			<div style="position:absolute; top: 120px; left:280px; color:azure;">
				<form name="allocateReward" action="<%=application.getContextPath() %>/allocateReward">
					
					<table align="center">
					
					<tr>
					
						<td ><b>Customer Id : </b></td>
						<%if(id==null) {%>
						
						<td><input type="text" name="customerId" value="" maxlength="10"></input></td>
						<%
						}else{ %>
						
						<td><input type="text" name="customerId" value=<%=id%> maxlength="10"></input></td>
						<%} %>
						
						<td><input class="bt" type="submit" name="go" value="Allocate"></input>
						
						<% 
						if(rewardBalance==0 && carryAmount==0 && id!=null){
							id="";
						%>
						
						<font color="red">enter correct customer id</font>
						<%} %>
						</td>
					
					</tr>
					<%
					if(rewardBalance!=0 || carryAmount!=0){ 
					
					%>
					
					<tr>
						<td>
							<br/>
						</td>
					</tr>
					
					
					<tr>
						<td ><b>Reward Points : </b></td>
						<td><%=rewardBalance%> </td>
						<td></td>
					</tr>
					
					
					<tr>
						<td ><b>Carry Amount : </b></td>
						<td> <%=carryAmount%> </td>
						<td></td>
					</tr>
					
					<tr>
						<td>
							<br/>
						</td>
					</tr>
					
					<%if(carryAmount==0)
						{%>
					<tr><td colspan="3"><font color="khaki" size="4"><b>Reward Point allocated successfully !!!</b></font></td></tr>
					<%}
					else 
					{%>
					<tr><td colspan="3"><font color="red" size="4"><b>Not sufficient Movie Booking amount for Reward Point allocation !!!<br></br> Amount added to Carry Amount !!!</b></font></td></tr>
					<%
					}
					}
					session.removeAttribute("customerReward");
					session.removeAttribute("id");%>
					
					<tr>
						<td><input type="hidden" name="requestType" value="allocateReward"></input></td>
						<td></td>
					</tr>
					
					</table>
				
				</form>
			</div>
			
			
	<div style="position:relative; top:100px; left:800px;" >	
		<img src="<%=application.getContextPath() %>/images/stars.png"  width="120" height="130" />
	</div>
			
	</body>
</html>