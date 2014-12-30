<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="./header-files.jsp" %>

<title>Reward Points</title>

	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/pageDesign.css" />
	<script type="text/javascript" src="<%=application.getContextPath() %>/js/validate.js"></script>
	<script type="text/javascript">
		function rewardRange()
		{
			var st=document.forms[0]["start"].value;
			if(st=="500")
			{
				document.forms[0]["end"].value="700";
				document.forms[0]["points"].value="50";
			}
			else if(st=="701")
			{
				document.forms[0]["end"].value="1000";
				document.forms[0]["points"].value="80";
			}
			else if(st=="1001")
			{
				document.forms[0]["end"].value="1300";
				document.forms[0]["points"].value="100";
			}
			else if(st=="1301")
			{
				document.forms[0]["end"].value="9999";
				document.forms[0]["points"].value="200";
			}
			
		}
			
	</script>
	
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



	<div style="position:absolute; top: 100px; left:280px; color:azure;">
	
	<%String exception=(String)session.getAttribute("exception"); 
	if(exception!=null){
	%>
	<font color="red"><%=exception %></font>
	<%} %>
		<form name="addRewardPoints" id="addRewardPointsForm" onsubmit="return chkRewardPoints()" action="<%=application.getContextPath() %>/addRewardPoints" method="post">
			
			<!-- <img style="position:absolute; top:10px; left:10px; opacity:50; filter:alpha(opacity=50);" src="<%=application.getContextPath() %>/images/gifts.png" />-->
			
			<table cellspacing="20" align="center" border ="0">
	
				<tr>
				<td align="right" ><b>Total Movie Price (Starting Range) :</b><div style="position:relative;margin-top:-20px;left:10px; color:red; font-size:12px">*</div></td>
				<td>
					<select class="one"  name="startRange" id="start" onchange="rewardRange()">
						<option value="select">-------------select-------------</option>
						<option value="500">500</option>
						<option value="701">701</option>
						<option value="1001">1001</option>
						<option value="1301">1301</option>
					</select>
				</td>
				</tr>
				
				<tr>
				<td align="right" ><b>Total Movie Price (Ending Range) :</b><div style="position:relative;margin-top:-20px;left:10px; color:red; font-size:12px">*</div></td>
				<td>
				
					<input class="one" type="text" name="endRange" id="end" readonly="readonly">
					
				</td>
				</tr>
				
				
				<tr>
				<td align="right" ><b>Reward Points :</b><div style="position:relative;margin-top:-20px;left:10px; color:red; font-size:12px">*</div></td>
				<td><input class="one" type="text" name="rewardPoints" id="points" readonly="readonly"></td>
				</tr>
				
				<tr>
				<td><input type="hidden" name="requestType" value="addRewardPoints"></input></td>
				</tr>
				<tr><td colspan="3"align="center"><input class="bt" type="submit" id="go" value="Add">
				
				&nbsp;&nbsp;<input class="bt" type="reset" id="reset" value="Reset" onclick="return confirmReset()"></td></tr>
			
			</table>
			<%session.removeAttribute("exception"); %>
			
		</form>
		
		
	</div>
	
		
	<div style="position:relative; top:50px; left:800px;" >	
		<img src="<%=application.getContextPath() %>/images/stars.png"  width="120" height="130" />
	</div>
	
	 
	</body>
</html>