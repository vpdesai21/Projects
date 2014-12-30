<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   errorPage="errorPageAmenities.jsp"  pageEncoding="ISO-8859-1"import="java.util.*,com.tcs.ilp.crud.beans.*"%>
<%@ include file="./logout.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/css/design.css" />

<%@ include file="./header-files.jsp" %> 

<title> Amenities </title>

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


		<div>
			<table class="amenityTypes" align="center" cellspacing="10px">
			<% ArrayList<AmenityType> amenityTypeList = (ArrayList<AmenityType>)session.getAttribute("amenityTypeList"); %>
						<% for(int i=0; i< amenityTypeList.size(); i+=2){ 
							AmenityType amenityType1 = amenityTypeList.get(i);
							AmenityType amenityType2 = amenityTypeList.get(i+1);
						%>
				<tr>
					<td  align="left">
						<a style="text-decoration:none;color:azure;" class="a" href="<%=application.getContextPath() %>/getAllAmenitiesByType?requestType=getAllAmenitiesByType&amenityTypeId=<%=amenityType1.getAmenityTypeId()%>&typeName=<%=amenityType1.getAmenityTypeName()%>">
							<img border="0" src="<%=application.getContextPath() %>/images/amenities/<%=amenityType1.getAmenityTypeId()%>.jpg"  width="100" height="100" />
						</a>
						<%=amenityType1.getAmenityTypeName() %>
					</td>
					
					
					<td align="left">
						<a style="text-decoration:none;color:azure;" class="a" href="<%=application.getContextPath() %>/getAllAmenitiesByType?requestType=getAllAmenitiesByType&amenityTypeId=<%=amenityType2.getAmenityTypeId()%>&typeName=<%=amenityType2.getAmenityTypeName()%>">
							<img  border="0"  src="<%=application.getContextPath() %>/images/amenities/<%=amenityType2.getAmenityTypeId()%>.jpg"  width="100" height="100" />
						</a>
						<%=amenityType2.getAmenityTypeName() %>
					</td>
					
				</tr>
				<%} %>
			</table>

		</div>
		
		
		
		<div style="position:relative; top:-40px; left:820px;" >	
			<img src="<%=application.getContextPath() %>/images/cinema.png"  width="120" height="130" />
		</div>
</body>
</html>