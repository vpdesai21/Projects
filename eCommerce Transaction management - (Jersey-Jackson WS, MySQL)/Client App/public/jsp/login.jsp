
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<%@ include file="./header-files.jsp" %> 

<title>eCommerce Client</title>

</head>

<body>

<div id="login-page" class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign in</h1>
            <div class="account-wall">
                <img class="profile-img" src="../img/photo.png" alt=""/>
                <form class="form-signin" action="<%=application.getContextPath() %>/login" >
                	<input type="hidden" name="requestType" value="login"/> 
	                <input type="email" name="userid" class="form-control" placeholder="Email" required autofocus />
	                <input type="password" name="password" class="form-control" placeholder="Password" required />
	                <%
	                String errorLogin = (String)session.getAttribute("error_login");
	                if(errorLogin!=null && errorLogin.equalsIgnoreCase("yes")) {
	                %>
	                <p class="pull-left text-error">Invalid Username or Password</p>
	                <% } %>
	                <button class="btn btn-lg btn-primary btn-block" type="submit">
	                    Sign in
	                </button>
	                <label class="checkbox pull-left">
	                    <input type="checkbox" value="remember-me">
	                    Remember me
	                </label>
	                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="<%=application.getContextPath() %>/public/jsp/signup.jsp" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>


</body>
</html>