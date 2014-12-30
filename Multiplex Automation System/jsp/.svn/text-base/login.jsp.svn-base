
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<%@ include file="./header-files.jsp" %> 

<title>Multiplex Automation System</title>

<link rel="stylesheet" type="text/css" href="../css/design.css" />

<link rel="stylesheet" type="text/css" href="../css/pageDesign.css" />

<script type="text/javascript">
function chkLogin()
{
	var un = document.forms[1]["userid"].value;
	var ps = document.forms[1]["password"].value;

	
	if(un==null || un=="")
	{
	alert("Please Enter Username !! ");
	return false;
	}
	if(ps==null || ps=="")
	{
	alert("Please Enter Password !! ");
	return false;
	}
	
	
}


</script>
</head>

<body>

<%@ include file="./header.jsp" %>


<div>
<img src="<%=application.getContextPath() %>/images/welcome1.png"  style="position:absolute; top:200px; left:45px;" border="none" />
</div>

<div>
	<div class="two">
	
	<form action="#" name="selectLocationForm">
		<table cellspacing="10px">
		
		
			<tr>
				<td>Select Location :</td>
				<td>
					<select name="location" id="location" >
					<option value="select">------select-------</option>
					<option value="loc1">Pune</option>
					<option value="loc2">Vadodara</option>
					<option value="loc3">Delhi</option>
					<option value="loc4">Kolkata</option>
				</select>
				</td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center">
					<input class="bt" type="submit" value="Go">
				</td>
				
				<td>
					<input type="hidden" name="requestType" value="#"/> 
				</td>
			</tr>
			
	
			
		</table>
	</form>
	
	
	</div>


	<div class="one">
		<%String status=(String)session.getAttribute("loginstatus"); 
		if(status!=null)
		{
			if(status.equalsIgnoreCase("failed"))
			{
		%>
		<p style="color: red">User-Id or Password Invalid</p>
		<%		
			}
			session.invalidate();
		}
		%>
		<form onsubmit="return chkLogin()" action="<%=application.getContextPath() %>/login" name="loginform">
			<table cellspacing="10px">
			
			
				<tr>
					<td>USER-ID :</td>
					<td>
						<input type="text" name="userid">
					</td>
				</tr>
				
				<tr>
					<td>PASSWORD :</td>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input class="bt"  type="submit" value="Login" />
					</td>
					
					<td>
						<input type="hidden" name="requestType" value="login"/> 
					</td>
				</tr>
				
				
				
				<tr>
					<td colspan="2" align="center">
						<a href="guestLogin?requestType=guestlogin" >Proceed as Guest</a>
					</td>
				</tr>
				
				
				<tr>
					<td colspan="2" align="center">
						<a href="signup?requestType=signup" style="color: white;">Sign Up !!</a>
					</td>
				</tr>
				
				
				<tr>
					<td colspan="2" align="center">
						<a href="forgotPassword?requestType=forgotPassword" style="color: white;">Forgot Password?</a>
					</td>
				</tr>
				
			</table>
		</form>
		
		
	</div>

</div>
	


</body>
</html>