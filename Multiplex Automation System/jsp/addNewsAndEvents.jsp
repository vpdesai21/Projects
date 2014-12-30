<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<%@ include file="./header-files.jsp" %> 

<title>News And Events</title>



	
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
	
			<form id="addNewsEventsForm" onsubmit="return chkNewsEvents('addNewsEventsForm')" action="<%=application.getContextPath() %>/addNewsAndEvents" method="post" enctype="multipart/form-data">
			
				<!-- <img style="position:absolute; top:10px; left:10px; opacity:50; filter:alpha(opacity=50);" src="<%=application.getContextPath() %>/images/newz.png"  />-->
				
				<table  cellspacing="10" align="center" border ="0">
				
				
				
				<tr>
				<td align="right" class="text-design"><b>Event Name/News :</b><div class="asterisk">*</div></td>
				<td><input class="one" type="text" id="eventNewsName" name="eventNewsName" ></td>
				</tr>
				
				<tr>
				<td align="right" class="text-design"> <b>Event Date :</b><div class="asterisk">*</div></td>
				<td><input class="one" type="text" id="myDate" name="myDate" readonly="readonly" ></td>
				<td>
				<a href="#" onclick="displayDatePicker('myDate',this, 'mdy', '/');" >
				<img border="0" src="../images/dp.png" alt="calendar" />
				</a>
				</td>
				</tr>
				
				<tr>
				<td align="right" class="text-design"><b>Event Time :</b><div class="asterisk">*</div></td>
				
				<td>
					<input style="width:20px;opacity:60;filter:alpha(opacity=60); " type="text" id="hr" name="hr"/>
					
					<input style="width:20px;opacity:60;filter:alpha(opacity=60);" type="text" id="min" name="min"/>
					
					
				</td>
				
				</tr>
				
				<tr>
				<td align="right" class="text-design"><b>Event Image :</b><div class="asterisk">*</div></td>
				<td><input style="opacity:60;filter:alpha(opacity=60);" class="one" type="file" id="eventImage" name="eventImage" /></td>
				</tr>
				
				<tr>
				<td align="right" class="text-design"><b>Event Description :</b><div class="asterisk">*</div></td>
				<td><textarea style="opacity:60;filter:alpha(opacity=60);" rows="10" cols="20" class="one" id="eventNewsDescription" name="eventNewsDescription"></textarea></td>
				</tr>
				
				
				<tr>
					<td><input type="hidden" name="requestType" value="addNewsAndEvents"></input></td>
				</tr>
				
		

				<tr>
					<td align="right"><input class="bt" type="submit" id="go" value="Add"></td>
					<td align="left"><input class="bt" type="reset" id="reset" value="Reset"></td>
				</tr>
				
				
				
				</table>

			</form>
		             
		
		</div>
		
		
		
		<div style="position:relative; top:200px; left:800px;" >	
			<img src="<%=application.getContextPath() %>/images/newsicon.png"  width="120" height="130" />
		</div>
	
	
	
	
	</body>
</html>