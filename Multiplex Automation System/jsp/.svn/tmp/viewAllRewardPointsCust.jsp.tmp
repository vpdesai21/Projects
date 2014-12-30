<%@ page import="java.util.*, com.tcs.ilp.crud.beans.RewardPoints" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reward Points</title>

<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/pageDesign.css" />
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/design.css" />

<%@ include file="./header-files.jsp" %>

<script type="text/javascript">

function sendRedirectPage(type)
{
	var radios = document.getElementsByTagName('input');
	 var value=0; 
	 for (var i = 0; i < radios.length; i++) {   
		   if ((radios[i].type === 'radio' && radios[i].checked)) 
		   {         // get value, set checked flag or do whatever you need to  
			          //value = radios[i].value;
		           value=1;
					break;
	        } 
      }
     if(value!=1){
		alert("Please select a Reward Point Detail to delete !!!");
		return;
     }
	
	if(type=="delete")
	{
		document.forms[0]["requestType"].value="deleteRewardPoints";
		var confirmDelete=confirm("Are you sure want to delete this Reward Point detail ? Click OK to confirm or CANCEL to exit");
		if(confirmDelete==true)
		{
		document.forms[0].submit();
		}
		else
		{
			return false;
		}
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


	<div class="rewardPoints">
		
		<form name="viewAllRewardPoints" method="post" action="<%=application.getContextPath() %>/deleteOrUpdateRewardPoints">
		
			<table align="center" cellspacing="20">
				
				<tr>
					<td align="right" style="color:khaki"><b>Start Range</b></td>
					<td align="right" style="color:khaki"><b>End Range</b></td>
					<td align="right" style="color:khaki"><b>Reward Points</b></td>
				</tr>
				
				<%ArrayList<RewardPoints> rewardList = (ArrayList<RewardPoints>)request.getAttribute("rewardList"); 
				RewardPoints rp=null;	
				if(rewardList!=null)
				{
				for(int i=0; i<rewardList.size(); i++){
						rp = rewardList.get(i);
						if(rp.getRewardId()!=null){
				%>
				<tr>
					<td align="right" ><%= rp.getStartRange()  %></td>
					<td align="right" ><%= rp.getEndRange()  %></td>
					<td align="right" ><%= rp.getRewardPoints() %></td>
				</tr>
				<% }}
				%>
				
			
				<%
				}
				%>
				
			</table>
		
		</form>

	</div>
	
	
	<div style="position:relative; top:-180px; left:800px;" >	
		<img src="<%=application.getContextPath() %>/images/stars.png"  width="120" height="130" />
	</div>
	

</body>
</html>