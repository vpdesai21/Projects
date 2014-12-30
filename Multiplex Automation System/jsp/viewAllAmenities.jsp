<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   errorPage="errorPageAmenities.jsp"  pageEncoding="ISO-8859-1"import="java.util.*,com.tcs.ilp.crud.beans.*"%>
<%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="./header-files.jsp" %>
	
<title> View Amenities </title>
	

	
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

	<body >
	
	<%@ include file="./header.jsp" %>
	
		<div id="navigation-block">
        	
            
            <ul id="sliding-navigation">
                <li class="sliding-element"><a class="one" href="<%=application.getContextPath() %>/jsp/adminHome.jsp">Home</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/setupForAddAmenity?requestType=setUpForAddAmenity">Add Amenities</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/getAllAmenityTypes?requestType=getAllAmenityTypes">View All Amenities</a></li>
            </ul>
        </div>
	
	
	
	
	
	<%ArrayList<Amenity> amenityList= (ArrayList<Amenity>)session.getAttribute("amenityList");%>

	
	<div class="amenities">

	<h2 style="margin:10px 5px;"><%=request.getParameter("typeName") %></h2>
	
	<table >
	
	<% if(amenityList.size()==0){%>
	
	<tr>
		<td><h2 style="text-decoration:none;color:azure;">No Amenities  Left Here!</h2></td>
		
		<td></td>
	</tr>
	
	<%}
	for(int i=0; i<amenityList.size(); i++){%>
	
	<% Amenity amenity =amenityList.get(i);%>
	
	<tr>
		<td>
			<a href="#"><p class="flip" style="color:white; text-decoration: none; font-size:20; " id="<%=amenity.getAmenityId() %>" ><%=amenity.getAmenityName()   %></p></a>
			
			<div  class="panel" id="<%=amenity.getAmenityId() %>d" >
	
				<table >
					<tr >
						<td  style="width:200px;text-align:center;">
							<img class="panel"  id="<%=amenity.getAmenityId() %>i" src="<%=amenity.getAmenityImage() %>"width="150" height="150" align="center"/>
						</td>
						
						<td valign="top">
							<table style="width:500px;">
								<tr>
									<td style="color: azure; "><%=amenity.getAmenityDescription()   %></td>
								</tr>
								
								<tr>
									<td>
										<a style="color: khaki; "  href="<%=application.getContextPath() %>/setupForUpdateAmenity?requestType=setupForUpdateAmenity&amenityId=<%=amenity.getAmenityId() %>&amenityName=<%=amenity.getAmenityType().getAmenityTypeName()%>">Edit</a>
										&nbsp;
										<a style="color: khaki; " onclick="return validateAmenityDelete()" href="<%=application.getContextPath() %>/deleteAmenity?requestType=deleteAmenity&amenityId=<%=amenity.getAmenityId()%>&amenityTypeId=<%=amenity.getAmenityType().getAmenityTypeId()%>&amenityName=<%=amenity.getAmenityType().getAmenityTypeName()%>">Delete</a>
									</td>
								</tr>
							</table>
						</td>
						
					</tr>
				</table>
	
			</div>
		</td>
	</tr>
	<% }%>
	
	
	</table>
	
	</div>
	
	
	<div style="position:relative; top:-40px; left:820px;" >	
			<img src="<%=application.getContextPath() %>/images/cinema.png"  width="120" height="130" />
		</div>
	
</body>
</html>