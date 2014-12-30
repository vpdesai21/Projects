<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="./logout.jsp" %>
<%@ page import="com.tcs.ilp.crud.beans.RewardPoints" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/viewAllRewardPoints?requestType=viewAllRewardPoints">View All Reward Point Details</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/allocateReward.jsp">Allocate Reward Points</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/getCustomerReward.jsp">View Reward Points for Customer</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/getAllCustomerReward?requestType=getAllCustomerReward">View Customer Reward Points Table</a></li>
            </ul>
        </div>


	<%RewardPoints rp=new RewardPoints();
	rp=(RewardPoints)request.getAttribute("rewardPoints");
	int st,en,rp1;
	String id;
	id=rp.getRewardId();
	st=rp.getStartRange();
	en=rp.getEndRange();
	rp1=rp.getRewardPoints();
	%>
	
	
	<div style="position:absolute; top: 100px; left:280px; color:azure;" >
		<form name="updateRewardPoints" id="updateRewardPointsForm" onsubmit="return chkRewardPoints()" action="updateRewardPoints" method="post">
		<table cellspacing="20" align="center" border ="0">
		<tr>
		<td align="right" ><b>Reward Id :</b><div style="position:relative;margin-top:-20px;left:10px; color:red; font-size:12px">*</div></td>
		<td><input class="one" type="text" name="rewardId" id="rId" value=<%=id%> readonly="readonly"></td>
		</tr>
		<tr>
		<td align="right" ><b>Total Movie Price (Starting Range) :</b><div style="position:relative;margin-top:-20px;left:10px; color:red; font-size:12px">*</div></td>
		<td><input class="one" type="text" name="startRange" id="start" value=<%=st%>></td>
		</tr>
		
		<tr>
		<td align="right"><b>Total Movie Price (Ending Range) :</b><div style="position:relative;margin-top:-20px;left:10px; color:red; font-size:12px">*</div></td>
		<td><input class="one" type="text" name="endRange" id="end" value=<%=en%>></td>
		</tr>
		
		
		<tr>
		<td align="right" ><b>Reward Points :</b><div style="position:relative;margin-top:-20px;left:10px; color:red; font-size:12px">*</div></td>
		<td><input class="one" type="text" name="rewardPoints" id="points" value=<%=rp1%>></td>
		</tr>
		
		<tr>
		<td><input type="hidden" name="requestType" value="updateRewardPoints"></input></td>
		</tr>
		<tr><td colspan="3" align="center"><input class="bt" type="submit" id="go" value="Update">&nbsp&nbsp
		
		<input class="bt" type="reset" id="reset" value="Reset" onclick="return confirmReset()"></td></tr>
		
		</table>
		</form>
		
	</div>
	
	
	<div style="position:relative; top:50px; left:800px;" >	
		<img src="<%=application.getContextPath() %>/images/stars.png"  width="120" height="130" />
	</div>
	
	
	 
	</body>
</html>