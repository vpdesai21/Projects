<%
	response.setHeader( "Pragma", "no-cache" );  
	response.setHeader( "Cache-Control", "no-cache" );   
	response.setDateHeader( "Expires", 0 );


	if(session.getAttribute("id")==null)
	{
		response.sendRedirect("http://localhost:3000/productCatalog");
	}
%>
