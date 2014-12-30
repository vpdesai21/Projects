<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="errorPageAmenities.jsp" import="java.util.*,com.tcs.ilp.crud.beans.*"%>
<%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="./header-files.jsp" %>

<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/design.css" />
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/pageDesign.css" />

<title>Amenities</title>

</head>

<body>

	<%@ include file="./header.jsp" %>
		<div id="navigation-block">
        	
            
            <ul id="sliding-navigation">
                <li class="sliding-element"><a class="one" href="<%=application.getContextPath() %>/jsp/adminHome.jsp">Home</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/setupForAddAmenity?requestType=setUpForAddAmenity">Add Amenities</a></li>
                <li class="sliding-element"><a href="<%=application.getContextPath() %>/getAllAmenityTypes?requestType=getAllAmenityTypes">View All Amenities</a></li>
            </ul>
        </div>

	
		<% String amenityAlreadyExistsException = (String)request.getAttribute("amenityAlreadyExistsException"); %>

		<div style="position:absolute; top: 100px; left:280px; color:azure;">
		
			<form name="amenitiesForm" onsubmit="return validateamenitiesForm()" action="<%=application.getContextPath() %>/addAmenity" method="post" enctype="multipart/form-data">
			
				<img style="position:absolute; top:10px; left:10px; opacity:50; filter:alpha(opacity=50);" src="<%=application.getContextPath() %>/images/pop.png" />
			
				<table  cellspacing="20" align="center" border ="0">
	
					<% if(amenityAlreadyExistsException!=null){ %>
					<tr> <td colspan="2"><font color="red" size="4"><%=amenityAlreadyExistsException %></font></td></tr>
					<% } %>
						
						
						<tr>
						<td>Amenity Name<sup>*</sup></td>
						<td><input type="text" name="amenityName" /></td>
						<td><p id="1"class="red"></p></td>
						</tr>
						
						<tr>
						<td>Amenity Type<sup>*</sup></td>
						<td>
							<select name="amenityTypeId">
							<% ArrayList<AmenityType> amenityTypeList = (ArrayList<AmenityType>)session.getAttribute("amenityTypeList"); %>
							<% for(int i=0; i< amenityTypeList.size(); i++){ 
								AmenityType amenityType = amenityTypeList.get(i);
							%>
							<option value='<%= amenityType.getAmenityTypeId()%>' > <%= amenityType.getAmenityTypeName() %> </option>
							<% } %></select>
						</td>
						<td></td>
						</tr>
						
						
						<tr>
						<td >Amenity Image<sup>(not mandatory)</sup></td>
						<td><input type="file" name="amenityImage" /></td>
						<td><p id="2"class="red"></p>
						</td>
						</tr>
						
						
						<tr>
						<td >Description<sup>*</sup>
						<td>
							<textarea name="amenityDescription" rows="5" cols="20"></textarea>
						</td>
						<td><p id="3"class="red"></p></td>
						</tr>
						
						<tr>
						<td><input type="hidden" name="requestType" value="addAmenity" /></td>
						<td>
						<input class="bt" type="submit" value="Submit" />
						<input class="bt" type="reset" value="Reset">
						</td>
						</tr>
	
					
					</table>
			</form>
		</div>

	
		<div style="position:relative; top:240px; left:820px;" >	
			<img src="<%=application.getContextPath() %>/images/cinema.png"  width="120" height="130" />
		</div>
</body>
</html>