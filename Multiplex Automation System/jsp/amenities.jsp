<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="./logout.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="./header-files.jsp" %>

<title>Amenities</title>

</head>

<body>

<%@ include file="./header.jsp" %>
		<div id="navigation-block">
        	
            
            <ul id="sliding-navigation">
                <li class="sliding-element"><a class="one" href="<%=application.getContextPath() %>/jsp/adminHome.jsp">Home</a></li>
				
					   
				<% if(session.getAttribute("id").equalsIgnoreCase("admin"))
				{
				
				%>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/setupForAddAmenity?requestType=setUpForAddAmenity">Add Amenities</a></li>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/getAllAmenityTypes?requestType=getAllAmenityTypes">View All Amenities</a></li>
					
				<%
				}
				else if(session.getAttribute("id").equalsIgnoreCase("customer"))
				{
				
				%>
				
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/getAllAmenityTypes?requestType=getAllAmenityTypes">View All Amenities</a></li>
					
				<% } %>
            </ul>
        </div>

		<div style="position:relative; top:200px; left:800px;" >	
			<img src="<%=application.getContextPath() %>/images/cinema.png"  width="120" height="130" />
		</div>
		
</body>
</html>