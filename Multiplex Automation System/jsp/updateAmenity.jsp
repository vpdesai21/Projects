<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"errorPage="errorPageAmenities.jsp" import="java.util.*,com.tcs.ilp.crud.beans.*"%>
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

	
	<div class="amenities">
		<table>
			<tr>
				<td>
				<% Amenity amenity = (Amenity)session.getAttribute("amenity"); %>
				<img src='<%=amenity.getAmenityImage() %>' width="350" height="290" />
				</td>
				
				<td style="height:200px;width:550px;text-align:top;">
				<form name="amenitiesForm"  action="<%=application.getContextPath() %>/updateAmenity" onsubmit="return validateamenitiesForm()" method="post" enctype="multipart/form-data">
				<table>
							
							<tr>
								<td>Name<sup>*</sup></td>
								<td><input type="text" name="amenityName" value='<%=amenity.getAmenityName() %>'/></td>
								<td><p id="1"class="red"></p></td>
							</tr>
							
							<tr>
								<td>Amenity Type<sup>*</sup></td>
								<td>
									<select name="amenityTypeId">
									<% ArrayList<AmenityType> amenityTypeList = (ArrayList<AmenityType>)session.getAttribute("amenityTypeList"); %>
									<% for(int i=0; i< amenityTypeList.size(); i++){ 
										AmenityType amenityType = amenityTypeList.get(i);
										if(amenityType.getAmenityTypeId().equals(amenity.getAmenityType().getAmenityTypeId())){
									%>
									<option value='<%= amenityType.getAmenityTypeId()%>' selected="selected" > <%= amenityType.getAmenityTypeName() %> </option>
									<% }else{ %>
									<option value='<%= amenityType.getAmenityTypeId()%>' > <%= amenityType.getAmenityTypeName() %> </option>
									<%}} %>
									</select>
								</td>
							
							<td></td>
							
							</tr>
							
							
							
							
							<tr>
								<td>Amenity Image<sup>(not mandatory)</sup></td>
								<td><input type="file" name="amenityImage" value='<%=amenity.getAmenityImage() %>' /></td>
								<td><p id="2"class="red"></p></td>
							</tr>
							
							<tr>
								<td>Description<sup>*</sup>
								<td><textarea name="amenityDescription"  rows="5" cols="20"><%=amenity.getAmenityDescription() %></textarea></td>
								<td><p id="3"class="red"></p></td>
							</tr>
		
							<tr>
								<td><input type="hidden" name="amenityId" value='<%=amenity.getAmenityId() %>' /></td>
							</tr>
							
							
							
							<tr>
								<td><input type="hidden" name="amenitydefaultImage" value='<%=amenity.getAmenityImage() %>' /></td>
							</tr>
							
							
							<tr>
								<td><input type="hidden" name="requestType" value="updateAmenity" /></td>
								<td><input class="bt" type="submit" value="Update" />
								<input class="bt" type="reset" value="Reset"></td>
							</tr>
		
						
					</table>
					</form>
				</td>
			</tr>
		
		
		</table>
	</div>
	
	
	
		<div style="position:relative; top:0px; left:820px;" >	
			<img src="<%=application.getContextPath() %>/images/cinema.png"  width="120" height="130" />
		</div>
	
</body>
</html>