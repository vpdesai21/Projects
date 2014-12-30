<%@page import="java.util.* , com.tcs.ilp.crud.beans.* " language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<%@ include file="./header-files.jsp" %> 

<title> Update Details of News And Events</title>
	
	
	
	<script type="text/javascript" src="<%=application.getContextPath() %>/js/validate.js"></script>
	
	<script type="text/javascript" src="<%=application.getContextPath() %>/js/calendar.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/global.css" />

	<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/pageDesign.css" />

	
</head>

	<body >

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

		
		<div style="position:absolute; top: 100px; left:280px; color:azure;">
	
			<form id="updateNewsEventsForm" onsubmit="return chkNewsEvents('updateNewsEventsForm')" action="<%=application.getContextPath() %>/updateNewsAndEvents" method="post" enctype="multipart/form-data">
				
				<table  cellspacing="20" align="center" border ="0">
				
				
				
				
					<%
					
					NewsAndEvents newsAndEvents = (NewsAndEvents)session.getAttribute("newsEventsForUpdate"); 
						
					if(newsAndEvents!=null)
					{
						String[] values = new String[2];
						values = newsAndEvents.getEventTime();
						
					%>
				
				
				<tr>
					<td><input type="hidden" name="newsEventsId" value="<%=newsAndEvents.getEventNewsId()%>" /></td>
				</tr>
				
				
				<tr>
				<td align="right"><b>Event Name/News :</b><div class="asterisk">*</div></td>
				<td><input class="one" type="text" id="eventNewsName" name="eventNewsName" value="<%=newsAndEvents.getEventNewsName().trim()%>"></td>
				</tr>
				
				<tr>
				<td align="right" ><b>Event Date :</b><div class="asterisk">*</div></td>
				<td><input class="one" type="text" id="myDate" name="myDate" value="<%=newsAndEvents.getEventDate().trim()%>" ></td>
				<td>
				<a href="#" onclick="displayDatePicker('myDate',this, 'mdy', '/');" >
				<img border="0" src="<%=application.getContextPath() %>/images/dp.png" alt="calendar" />
				</a>
				</td>
				</tr>
				
				<tr>
				<td align="right" ><b>Event Time (HH:MI):</b><div class="asterisk">*</div></td>
				
				<td>
					<input style="width:20px;opacity:60;filter:alpha(opacity=60); " type="text" id="hr" name="hr" value="<%=values[0].trim()%>" />
					
					<input style="width:20px;opacity:60;filter:alpha(opacity=60);" type="text" id="min" name="min" value="<%=values[1].trim()%>" />
					
					
				</td>
				
				</tr>
				
				<tr>
				<td align="right" ><b>Event Image :</b><div class="asterisk">*</div></td>
				<td><img src="<%=newsAndEvents.getEventImage()%>" height="200" width="200" /></td>
				<td><input style="opacity:60;filter:alpha(opacity=60);" class="one" type="file" id="eventImage" name="eventImage" value="#"  /></td>
				</tr>
				
				<tr>
				<td align="right" ><b>Event Description :</b><div class="asterisk">*</div></td>
				<td><textarea style="opacity:60;filter:alpha(opacity=60);" rows="10" cols="20" class="one" id="eventNewsDescription" name="eventNewsDescription"><%=newsAndEvents.getEventNewsDescription().trim()%> </textarea></td>
				</tr>
				
				
				<tr>
					<td><input type="hidden" name="requestType" value="updateNewsAndEvents"></input></td>
				</tr>
				
		
				<tr>
					<td align="right"><input class="bt" type="submit" id="go" value="Update"></td>
					<td align="left"><input class="bt" type="reset" id="reset" value="Reset"></td>
				</tr>
				
				<%
					}
				%>
				
				</table>
				
			
			</form>
		</div>
		
		
		
	<div style="position:relative; top:500px; left:800px;" >	
	<img src="<%=application.getContextPath() %>/images/newsicon.png"  width="120" height="130" />
	</div>
	
	</body>
</html>