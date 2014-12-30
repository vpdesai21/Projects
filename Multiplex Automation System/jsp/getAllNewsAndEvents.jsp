<%@page import="java.util.* , com.tcs.ilp.crud.beans.* " language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="./logout.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<%@ include file="./header-files.jsp" %> 


<title> View News And Events </title>

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

	
			
			<% ArrayList<NewsAndEvents> newsAndEventsList = (ArrayList<NewsAndEvents>)session.getAttribute("allNewsEventsList");
			%>	
	
		<form name="getAllNewsAndEventsForm" action="<%=application.getContextPath() %>/getAllNewsAndEvents" method="get">
	
			
			<table >
			
			<% for(int i=0; i<newsAndEventsList.size(); i++){
				NewsAndEvents newsAndEvents = newsAndEventsList.get(i);
				if(newsAndEvents.getEventNewsId()!=null){
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
					
									</table>
								</td>
								
							</tr>
						</table>
			
					</div>
				</td>
				
			</tr>
			
		
			<% }}
				
			%>
			
			
						
			</table>
			
			
		
		</form>	
</div>

<div style="position:relative; top:-40px; left:820px;" >	
			<img src="<%=application.getContextPath() %>/images/newsicon.png"  width="120" height="130" />
		</div>
	


</body>
</html>