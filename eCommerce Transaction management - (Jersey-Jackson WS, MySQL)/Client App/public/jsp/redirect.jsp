<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="./header-files.jsp" %>

<script>
$( document ).ready(function() {
	var opts = {
		  lines: 13, // The number of lines to draw
		  length: 20, // The length of each line
		  width: 10, // The line thickness
		  radius: 30, // The radius of the inner circle
		  corners: 1, // Corner roundness (0..1)
		  rotate: 0, // The rotation offset
		  direction: 1, // 1: clockwise, -1: counterclockwise
		  color: '#000', // #rgb or #rrggbb or array of colors
		  speed: 1, // Rounds per second
		  trail: 60, // Afterglow percentage
		  shadow: false, // Whether to render a shadow
		  hwaccel: false, // Whether to use hardware acceleration
		  className: 'spinner', // The CSS class to assign to the spinner
		  zIndex: 2e9, // The z-index (defaults to 2000000000)
		  top: '50%', // Top position relative to parent
		  left: '50%' // Left position relative to parent
		};
		var target = document.getElementById('spinner');
		var spinner = new Spinner(opts).spin(target);
});

</script>
<title>Redirecting...</title>
</head>
<body>
<div id="spinner"></div>
<% 
String productId = request.getParameter("productId");
session.setAttribute("productId", productId);

if(session.getAttribute("userId")!=null) {
	response.sendRedirect(application.getContextPath()+"/public/jsp/orderDetails.jsp");
} else {
	response.sendRedirect(application.getContextPath()+"/public/jsp/login.jsp");
}
%>

</body>
</html>