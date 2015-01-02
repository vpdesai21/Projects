
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<%@ include file="./header-files.jsp"%>

<title>Success</title>

</head>

<body>
	<div class="container">
		<div class="row">
			<div class="order-wall">
				<div class="inner-wall">
					<img src="../img/error.png" alt="Error Transaction">
					<br/>
					<label class="checkbox pull-left text-error">
	                    Sorry. The product you want to buy is not available for sale.
	                </label>
					<a href="http://localhost:3000/productCatalog" ><span class="col-xs-10"><strong>Return to Product Catalog</strong></span></a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>