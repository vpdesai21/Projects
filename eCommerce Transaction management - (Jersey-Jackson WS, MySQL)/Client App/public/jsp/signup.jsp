<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="./header-files.jsp"%>
<title>Sign Up</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="order-wall">
				<div class="inner-wall">
					<h1>Sign Up</h1>
					<form class="form-horizontal">
						<div class="input-row form-group">
							<label class="control-label col-xs-3" for="inputEmail">Email:</label>
							<div class="col-xs-9">
								<input type="email" class="form-control" id="inputEmail"
									placeholder="Email" required>
							</div>
						</div>
						<div class="input-row form-group">
							<label class="control-label col-xs-3" for="inputPassword">Password:</label>
							<div class="col-xs-9">
								<input type="password" class="form-control" id="inputPassword"
									placeholder="Password" required>
							</div>
						</div>
						<div class="input-row form-group">
							<label class="control-label col-xs-3" for="confirmPassword">Confirm
								Password:</label>
							<div class="col-xs-9">
								<input type="password" class="form-control" id="confirmPassword"
									placeholder="Confirm Password" required>
							</div>
						</div>
						<div class="input-row form-group">
							<label class="control-label col-xs-3" for="firstName">First
								Name:</label>
							<div class="col-xs-9">
								<input type="text" class="form-control" id="firstName"
									placeholder="First Name" required>
							</div>
						</div>
						<div class="input-row form-group">
							<label class="control-label col-xs-3" for="lastName">Last
								Name:</label>
							<div class="col-xs-9">
								<input type="text" class="form-control" id="lastName"
									placeholder="Last Name" required>
							</div>
						</div>
						<div class="input-row form-group">
							<label class="control-label col-xs-3">Date of Birth:</label>
							<div style="display:inline; float:left; width:30px; margin-right:20px;" class="col-xs-3">
								<input style="width: 100%;" type="text" class="form-control" id="month"
									placeholder="MM" required>
							</div>
							<div style="display:inline; float:left; width:30px; margin-right:20px;" class="col-xs-3">
								<input style="width: 100%;" type="text" class="form-control" id="date"
									placeholder="DD" required>
							</div>
							<div style="display:inline; float:left; width:40px; margin-right:80px;" class="col-xs-3">
								<input style="width: 100%;" type="text" class="form-control" id="year"
									placeholder="YYYY" required>
							</div>
						</div>
						<div class="input-row form-group">
							<div class="col-xs-offset-3 col-xs-9">
								<label class="checkbox-inline"> <input type="checkbox"
									value="news"> Send me latest news and updates.
								</label>
							</div>
						</div>
						<div class="input-row form-group">
							<div class="col-xs-offset-3 col-xs-9">
								<label class="checkbox-inline"> <input type="checkbox"
									value="agree" required> I agree to the <a href="#">Terms
										and Conditions</a>.
								</label>
							</div>
						</div>
						<br>
						<div class="input-row form-group">
							<div class="col-xs-offset-3 col-xs-9">
								<input type="submit" class="btn btn-primary" value="Submit">
								<input type="reset" class="btn btn-default" value="Reset">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>