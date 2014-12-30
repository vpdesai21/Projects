<%@page import="java.util.* , com.tcs.ilp.crud.beans.* " language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<%@ include file="./header-files.jsp" %> 



<title>Delete Or Update News And Events</title>


<script type="text/javascript">

function checkSendDate()
{
	var i = document.forms[0]["selectedDate"].selectedIndex;

	if(i!=0)
	{
	return true;
	}
	else
	{
		alert("\n Please Select Date to View News And Events !!\n");
		return false;
	}
}



function confirmDelete()
{
	
	var b = confirm("Are You Sure You Want to Delete the Record .\n Click OK to Proceed . Click Cancel to Undo .");

	return b;
}	


</script>

<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/pageDesign.css" />
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/design.css" />

<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/content-display.css" />

	<script type="text/javascript"> 
		$(document).ready(function(){
		$(".flip").click(function(){
			var id1=$(this).attr('id'); 
		       $("#"+id1+"d").slideToggle("medium");
		       $("#"+id1+"i").slideToggle("medium");
			   $("div.panel:not(#"+id1+"d)").slideUp("medium");
			   $("img.panel:not(#"+id1+"i)").slideUp("medium");
			   //$(".panel").slideup("medium");
			   //$(".panel").slideup("medium");
		  });
		});
	</script>
		 

</head>
<body>

<%@ include file="./header.jsp" %>

		<div id="navigation-block">
        	
            
            <ul id="sliding-navigation">
                <li class="sliding-element"><a class="one" href="<%=application.getContextPath() %>/jsp/adminHome.jsp">Home</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/addNewsAndEvents.jsp">Add News And Events</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/getAllNewsAndEvents?requestType=getAllNewsAndEvents">View All News And Events</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/deleteOrUpdateNewsAndEvents?requestType=getAllDates">Update News And Events</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/deleteOrUpdateNewsAndEvents?requestType=getAllDates">Delete News And Events</a></li>
            </ul>
        </div>



		<div class="newsEvents">
		
		<form name="getListOfNewsAndEventsForm" onSubmit="return checkSendDate()" action="<%=application.getContextPath() %>/deleteOrUpdateNewsAndEvents">
		
	
			<table cellspacing="10px" align="center" >
			
			<tr>
				<td><input type="hidden" name="requestType" value="getListOfNewsAndEvents"></td>
			</tr>
			
			<tr>
				<td style="text-decoration:none;">Select Date : </td>
			
				<td>
				<select name="selectedDate" >
				<option value="00/00/0000">- Select Date -</option>
			
			<%
					
			ArrayList<String> dateList = (ArrayList<String>)session.getAttribute("dateList"); 
			
			if(dateList!=null)
			{
			for(int i=0; i<dateList.size(); i++){
				String date = dateList.get(i);
				
				if(date!=null){
			%>
			
				  
				  <option value="<%=date%>"><%=date%></option>
				 
				
			<%
				}
			}
			
			}
			%>
			
			
			
				</select>
				</td>
			 
			 <td>
			 	<input class="bt" type="submit" name="getListOfNewsAndEvents" value="Proceed" />
			 </td>
			 
			</tr>
			
			</table>
			
			
		</form>
			
			<%
			String flagForDisplay="false";
						
			flagForDisplay = (String)session.getAttribute("isListRetrieved");
			
			if(flagForDisplay.equals("true"))
			{
			%>
			
			
		<form name="deleteOrUpdateNewsAndEventsForm" action="#">
		
			<table>
	
	
			
			<%
			
			ArrayList<NewsAndEvents> newsEventsList = (ArrayList<NewsAndEvents>)session.getAttribute("newsEventsList"); 
			NewsAndEvents newsAndEvents = null;	
			if(newsEventsList!=null)
			{
				for(int i=0; i<newsEventsList.size(); i++)
				{
					newsAndEvents = newsEventsList.get(i);
						
					if(newsAndEvents.getEventNewsId()!=null)
					{
			%>
			
			<tr>
				<td>
					<a href="#"><p class="flip" style="color:white; text-decoration: none; font-size:20; " id="<%= newsAndEvents.getEventNewsId()  %>" ><%= newsAndEvents.getEventNewsName()  %></p></a>
					
					<div  class="panel" id="<%= newsAndEvents.getEventNewsId()  %>d" >
			
						<table >
							<tr >
								<td  style="width:200px;text-align:center;">
									<img class="panel"  id="<%= newsAndEvents.getEventNewsId()  %>i" src="<%= newsAndEvents.getEventImage()  %>"width="150" height="150" align="center"/>
								</td>
								
								<td valign="top">
									<table style="width:500px;">
										
										<tr>
											<td style="color: azure; "><%= newsAndEvents.getEventNewsDescription() %></td>
										</tr>
										
										<tr>
											<td style="color: azure; "><%= newsAndEvents.getEventDateTime() %></td>
										</tr>
										
										<tr>
											<td>
												<a style="color: khaki; "  href="<%=application.getContextPath() %>/deleteOrUpdateNewsAndEvents?requestType=setupForUpdateNewsAndEvents&newsEventsId=<%=newsAndEvents.getEventNewsId() %>">Edit</a>
												&nbsp;
												<a style="color: khaki; " onclick="return confirmDelete()" href="<%=application.getContextPath() %>/deleteOrUpdateNewsAndEvents?requestType=deleteNewsAndEvents&newsEventsId=<%=newsAndEvents.getEventNewsId() %>">Delete</a>
											</td>
										</tr>
					
									</table>
								</td>
								
							</tr>
						</table>
			
					</div>
				</td>
				
			</tr>
				
				
			<%
					}
				}
			}
		
			
			}
			%>
			
			</table>
			
			
		</form>

	</div>

	
	<div style="position:relative; top:-40px; left:820px;" >	
		<img src="<%=application.getContextPath() %>/images/newsicon.png"  width="120" height="130" />
	</div>
	
</body>
</html>