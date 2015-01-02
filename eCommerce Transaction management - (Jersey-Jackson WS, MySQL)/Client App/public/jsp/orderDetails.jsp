<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="./header-files.jsp"%>
<title>Buy</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="order-wall">
				<div class="inner-wall">
					<form class="form-horizontal" id="orderForm" action="<%=application.getContextPath() %>/order">
						
						<label class="col-xs-10"><strong>Product
									Details</strong></label>
						
						<div class="input-row form-group">
							<label class="col-xs-2 control-label">Product Quantity</label>
							<div class="col-xs-5">
								<select id="quantity" name="quantity" class="form-control" required>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
									<option>7</option>
									<option>8</option>
									<option>9</option>
									<option>10</option>
								</select>
							</div>
							<%
			                String errorQuantity = (String)session.getAttribute("error_quantity");
			                if(errorQuantity!=null && errorQuantity.equalsIgnoreCase("yes")) {
			                %>
			                <label class="col-xs-2 pull-right text-error">Please select less quantity</label>
			                <% } %>
						</div>
						<br/>
						<label class="col-xs-10"><strong>Shipping
									Details</strong></label>
						
						<div class="input-row form-group">
							<label class="col-xs-2 control-label">Address Line 1</label>
							<div class="col-xs-10">
								<input id="address1" name="address1" type="text"
									class="form-control" placeholder="Address line 1" required>
							</div>
						</div>
						<div class="input-row form-group">
							<label class="col-xs-2 control-label">Address Line 2</label>
							<div class="col-xs-10">
								<input id="address2" name="address2" type="text"
									class="form-control" placeholder="Address line 2" required>
							</div>
						</div>
						<div class="input-row form-group">
							<label class="col-xs-2 control-label">City</label>
							<div class="col-xs-10">
								<input id="city" name="city" type="text" class="form-control"
									placeholder="City" required>
							</div>
						</div>
						<div class="input-row form-group">
							<label class="col-xs-2 control-label">State</label>
							<div class="col-xs-5">
								<select id="state" name="state" name="state"
									class="form-control" required>
									<option value="AL">AL</option>
									<option value="AK">AK</option>
									<option value="AZ">AZ</option>
									<option value="AR">AR</option>
									<option value="CA">CA</option>
									<option value="CO">CO</option>
									<option value="CT">CT</option>
									<option value="DE">DE</option>
									<option value="DC">DC</option>
									<option value="FL">FL</option>
									<option value="GA">GA</option>
									<option value="HI">HI</option>
									<option value="ID">ID</option>
									<option value="IL">IL</option>
									<option value="IN">IN</option>
									<option value="IA">IA</option>
									<option value="KS">KS</option>
									<option value="KY">KY</option>
									<option value="LA">LA</option>
									<option value="ME">ME</option>
									<option value="MD">MD</option>
									<option value="MA">MA</option>
									<option value="MI">MI</option>
									<option value="MN">MN</option>
									<option value="MS">MS</option>
									<option value="MO">MO</option>
									<option value="MT">MT</option>
									<option value="NE">NE</option>
									<option value="NV">NV</option>
									<option value="NH">NH</option>
									<option value="NJ">NJ</option>
									<option value="NM">NM</option>
									<option value="NY">NY</option>
									<option value="NC">NC</option>
									<option value="ND">ND</option>
									<option value="OH">OH</option>
									<option value="OK">OK</option>
									<option value="OR">OR</option>
									<option value="PA">PA</option>
									<option value="RI">RI</option>
									<option value="SC">SC</option>
									<option value="SD">SD</option>
									<option value="TN">TN</option>
									<option value="TX">TX</option>
									<option value="UT">UT</option>
									<option value="VT">VT</option>
									<option value="VA">VA</option>
									<option value="WA">WA</option>
									<option value="WV">WV</option>
									<option value="WI">WI</option>
									<option value="WY">WY</option>
								</select>
							</div>
						</div>
						<div class="input-row form-group">
							<label class="col-xs-2 control-label">Zip Code</label>
							<div class="col-xs-10">
								<input id="zipcode" name="zipcode" type="text"
									class="form-control" placeholder="Zip Code" required>
							</div>
						</div>
						<%
			                String errorAddress = (String)session.getAttribute("error_address");
			                if(errorAddress!=null && errorAddress.equalsIgnoreCase("yes")) {
			                %>
			                <label class="col-xs-2 pull-right text-error">Sorry. Please enter order details again</label>
			                <% } %>
						<div class="input-row form-group">
							<div class="col-xs-2">
								<button class="btn btn-lg btn-primary btn-block" type="submit">Proceed
									To Payment</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>