<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="./logout.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@ include file="./header-files.jsp" %>

<title>Administrator Home</title>



<script type="text/javascript">  

     $(document).ready(function() {  

         $('#coin-slider').coinslider({ height:400 ,width: 720, navigation: true, delay: 3000 });  

     });  

</script> 


</head>

<body>

	<%@ include file="./header.jsp" %>
	
	<div id="navigation-block">
        	
            
            <ul id="sliding-navigation">
			
			
                <li class="sliding-element"><a class="one" href="<%=application.getContextPath() %>/jsp/adminHome.jsp">Home</a></li>
				   
				<% if(session.getAttribute("id").equalsIgnoreCase("admin"))
				{
				
				%>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/newsAndEvents.jsp">News And Events</a></li>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/amenities.jsp">Amenities</a></li>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/rewardPoints.jsp">Reward Points</a></li>
					<li class="sliding-element"><a href="#">Movies</a></li>
					<li class="sliding-element"><a href="#">Users</a></li>
					<li class="sliding-element"><a href="#">Customers</a></li>
					<li class="sliding-element"><a href="#">Booking Details</a></li>
					<li class="sliding-element"><a href="#">Snacks</a></li>
					<li class="sliding-element"><a href="#">Promotional offers</a></li>
					
				<%
				}
				else if(session.getAttribute("id").equalsIgnoreCase("customer"))
				{
				
				%>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/newsAndEvents.jsp">News And Events</a></li>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/amenities.jsp">Amenities</a></li>
					<li class="sliding-element"><a href="<%=application.getContextPath() %>/jsp/rewardPoints.jsp">Reward Points</a></li>
					<li class="sliding-element"><a href="#">Movies</a></li>
					<li class="sliding-element"><a href="#">Booking Details</a></li>
					<li class="sliding-element"><a href="#">Snacks</a></li>
					<li class="sliding-element"><a href="#">Promotional offers</a></li>
								
				
				<% } %>
				
            </ul>
    </div>

	<div>

		 <div id='coin-slider'>
						
			  <a href="#">  
			        <img src='<%=application.getContextPath() %>/images/slide-show/1.jpg' />  
				    <span>  
				       This is default description
				    </span>  
		      </a>  
			     
			     
			  <a href="#">  
			        <img src='<%=application.getContextPath() %>/images/slide-show/2.jpg' />  
				    <span>  
				       This is default description
				    </span>  
		      </a>  
			  
			  
			  <a href="#">  
			        <img src='<%=application.getContextPath() %>/images/slide-show/3.jpg' />  
				    <span>  
				       This is default description
				    </span>  
		      </a>
		      
		      
		      
		      <a href="#">  
			        <img src='<%=application.getContextPath() %>/images/slide-show/4.jpg' />  
				    <span>  
				       This is default description
				    </span>  
		      </a>  
			       
			        
			  <a href="#">  
			        <img src='<%=application.getContextPath() %>/images/slide-show/5.jpg' />  
				    <span>  
				       This is default description
				    </span>  
		      </a>  
			     
			
			    <a href="#">  
			        <img src='<%=application.getContextPath() %>/images/slide-show/6.jpg' />  
				    <span>  
				       This is default description
				    </span>  
		      </a>  
			     
			     
			  <a href="#">  
			        <img src='<%=application.getContextPath() %>/images/slide-show/7.jpg' />  
				    <span>  
				       This is default description
				    </span>  
		      </a>  
			  
			  
			  <a href="#">  
			        <img src='<%=application.getContextPath() %>/images/slide-show/8.jpg' />  
				    <span>  
				       This is default description
				    </span>  
		      </a>
		      
		      
		      
		      <a href="#">  
			        <img src='<%=application.getContextPath() %>/images/slide-show/9.jpg' />  
				    <span>  
				       This is default description
				    </span>  
		      </a>  
			       
			
		</div> 


</div>



</body>

</html>