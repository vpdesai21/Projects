<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"errorPage="errorPageAmenities.jsp" %>
<%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="./header-files.jsp" %>

	<title> Amenities </title>
		
	<link rel="stylesheet" type="text/css" href="../css/pageDesign.css" />

	
	</head>

	<body >
	
	<%@ include file="./header.jsp" %>
	
		<div id="navigation-block">
        	
            
            <ul id="sliding-navigation">
                <li class="sliding-element"><a class="one" href="<%=application.getContextPath() %>/jsp/adminHome.jsp">Home</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/setupForAddAmenity?requestType=setUpForAddAmenity">Add Amenities</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/getAllAmenityTypes?requestType=getAllAmenityTypes">View All Amenities</a></li>
            </ul>
        </div>
<h2 style="text-decoration:none;color:azure">Delete Amenities Success</h2>
</body>
</html>