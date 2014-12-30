<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<%@ include file="./header-files.jsp" %> 

<link rel="stylesheet" type="text/css" href="css/design.css" />

<title> News & Events Success Page</title>

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

	<div style="position:relative; top:-150px; left:100px;">
		<h2 align="center" style="position:relative; top:50px; text-decoration:none;color:lawngreen;"><%= session.getAttribute("message")%>!!</h2>
		<img src="<%=application.getContextPath() %>/images/success.png" alt="cinema" align="center" style="position:relative; top:100px; left:370px;" width="150" height="160" /> 
	</div>
	
	
	<div style="position:relative; top:-10px; left:820px;" >	
		<img src="<%=application.getContextPath() %>/images/newsicon.png"  width="120" height="130" />
	</div>
	


</body>
</html>