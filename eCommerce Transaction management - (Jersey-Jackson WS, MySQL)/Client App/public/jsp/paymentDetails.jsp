<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="./header-files.jsp"%>
<title>Pay</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="order-wall">
				<div class="inner-wall">
					<form class="form-horizontal" id="paymentForm" action="<%=application.getContextPath() %>/payment">
						
						<label class="col-xs-10"><strong>Payment
									Details</strong></label>
						
						<div class="input-row form-group">
							<label class="col-xs-2 control-label">Card Number</label>
							<div class="col-xs-10">
								<input id="cardNumber" name="cardNumber" type="text"
									class="form-control" placeholder="Card Number" required maxlength="16">
							</div>
						</div>
						
						<div class="input-row form-group">
							<label class="col-xs-2 control-label">Card Holder Name</label>
							<div class="col-xs-10">
								<input id="cardHolderName" name="cardHolderName" type="text"
									class="form-control" placeholder="Card Holder Name" required >
							</div>
						</div>
						
						<div class="input-row form-group">
							<label class="col-xs-2 control-label">Expiration Date</label>
							<div class="col-xs-10">
								<div class="row">
									<div style="display:inline; float:left; width:30px; margin-right:10px;" class="col-xs-4">
										<input style="width: 100%;" id="month" name="month" type="text" class="form-control"
												placeholder="MM" maxlength="2" required >
									</div>
									<div style="display:inline; float:left; margin-right:10px;  margin-left:10px; font-size:1.3em;" >/</div>
									<div style="display:inline; float:left; width:40px; margin-right:10px;" class="col-xs-4">
										<input style="width: 100%;" id="year" name="year" type="text" class="form-control"
												placeholder="YYYY" maxlength="4" required >
									</div>
								</div>
							</div>
						</div>
						
						<div class="input-row form-group">
							<label class="col-xs-2 control-label">CVV #</label>
							<div class="col-xs-10">
								<input style="width: 30px;" id="cvv" name="cvv" type="password"
									class="form-control" placeholder="CVV" maxlength="3" required >
							</div>
						</div>
							<%
			                String errorPayment = (String)session.getAttribute("error_payment");
							String errorTransaction = (String)session.getAttribute("error_transaction");
			                if((errorPayment!=null && errorPayment.equalsIgnoreCase("yes")) || (errorTransaction!=null && errorTransaction.equalsIgnoreCase("yes"))) {
			                %>
			                <label class="col-xs-2 pull-right text-error">Sorry. Please enter payment details again</label>
			                <% } %>
						<div class="input-row form-group">
							<div class="col-xs-2">
								<button class="btn btn-lg btn-primary btn-block" type="submit">Pay</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>