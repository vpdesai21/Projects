
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,com.client.bean.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<%@ include file="./header-files.jsp"%>

<script type="text/javascript">
	function beforeSubmitClick(orderId) {
		$("#order_id").val(orderId);
		$("#TransactionForm").submit();
	}
</script>
<title>Order History</title>

</head>

<body>
	<div class="container">
		<div class="row">
			<div class="transaction-wall">
				<div class="inner-wall">
					<form class="form-horizontal" id="TransactionForm"
						action="<%=application.getContextPath()%>/deleteTransaction">
						<input type="hidden" name="deleteRequest" id="deleteRequest"
							value="true" /> <input type="hidden" name="order_id"
							id="order_id" />
						<table id="transactions-table">
							<thead>
								<tr>
									<th>Order Details</th>
									<th>Order Placed On</th>
									<th>Shipping Details</th>
									<th>Product Details</th>
									<th>Quantity</th>
									<th>Shipping Status</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<%
									ArrayList<TransactionDetails> transactionDetailsList = (ArrayList<TransactionDetails>) session
											.getAttribute("transactionDetails");

									if (transactionDetailsList != null) {
										for (int i = 0; i < transactionDetailsList.size(); i++) {
											TransactionDetails transaction = transactionDetailsList
													.get(i);
								%>
								<tr>
									<td><%=transaction.getOrder_id()%></td>
									<td><%=transaction.getOrder_date()%></td>
									<td><%=transaction.getShipping_address()%></td>
									<td><%=transaction.getProduct_details()%></td>
									<td><%=transaction.getProduct_quantity()%></td>
									<td><%=transaction.getOrder_status()%></td>
									<td>
										<%
											if (transaction.getOrder_status().equalsIgnoreCase(
															"shipped")) {
														if (transaction.getIs_cancelled() != null
																&& transaction.getIs_cancelled()
																		.equalsIgnoreCase("n")) {
										%>
										<button class="btn btn-lg btn-primary btn-block"
											onclick="beforeSubmitClick('<%=transaction.getOrder_id()%>')">Cancel</button>
										<%
											}
													}
										%>
									</td>
								</tr>
								<tr>
									<td colspan="7"><hr /></td>
								</tr>
								<%
									}
									} else {
								%>
								<tr>
									<td>
										<p class="pull-left">No previous purchases</p>
										<p>
											<a class="pull-left"
												href="http://localhost:3000/productCatalog"><strong>Start
													Shopping</strong></a>
										</p>
									</td>
								</tr>
								<%
									}
								%>
								<%
									String errorGeneric = (String) session
											.getAttribute("error_generic");
									if (errorGeneric != null && errorGeneric.equalsIgnoreCase("yes")) {
								%>
								<p class="pull-left text-error">Technical issues. Please try
									again.</p>
								<%
									}
								%>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>