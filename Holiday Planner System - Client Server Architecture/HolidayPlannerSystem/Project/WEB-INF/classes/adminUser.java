import java.io.*;
import java.rmi.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class adminUser extends HttpServlet
{


public String getBooking()
{
DatabaseAccessInterface dai=null;
String chk[][] =null;
String serviceURL=null;
String msg = "";

String st = "localhost";
int port = 1099;
//change values whenever needed ..
		
		
		try
		{
		serviceURL="rmi://"+st+":"+port+"/DatabaseAccessServer";
		dai = (DatabaseAccessInterface)Naming.lookup(serviceURL);
		chk = dai.fetchBookingData();
		
		
		
		
		for(int i =0;i<chk.length;i++)
		{
			
			
			
			if(chk[i][0]==null)
				break;
			
			msg+=	"<tr style=\"width:100%; text-align:center;\">"+
					"<td>"+chk[i][0]+"</td>"+
					"<td>"+chk[i][1]+"</td>"+
					"<td>"+chk[i][2]+"</td>"+
					"<td>"+chk[i][3]+"</td>"+
					"<td>"+chk[i][4]+"</td>"+
					
					"</tr>";
			
		}
		
		}
		catch(Exception e)
		{}
	return msg;
}


public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException
{

	
	FileOutputStream fos;
	
	
	String page=null;
	
	
	String addr=InetAddress.getLocalHost().getHostAddress();
	
	
	
	String content = getBooking();

	fos = new FileOutputStream("D://Apache/webapps/Project/html/adminUserBooking.html");
	//---------------------------------------------------------------------------
	page = 
	page = 
	"<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">"+

	"<html>"+
	"<title>Travel Planning System</title>"+

	"<head>"+
	"</head>"+
	"<body style= \"overflow:scroll; background-image:url('/Project/images/tour.png') ; background-repeat:no-repeat;\"  >"+
	
	"<div style=\" border-style:groove; border-width:2px; position:absolute; top:195px ; overflow-y:scroll ; overflow-x:hidden; width:50%; height:400px; color:white; margin-left:25%;\">"+
	
		
	
	"<table style=\"color:white;width:100%;\"  border=\"0\" cellspacing=\"1\" cellpadding=\"1\" >"+	
	
	"<tr style=\"text-decoration:underline; font-weight:bold; font-size:20px; color:white; text-align:center; \">"+
	"<th>Name</th>"+
	"<th>Package Name</th>"+
	"<th>Booking Date/Time</th>"+
	"<th>Seats</th>"+
	"<th>Phone No.</th>"+	
	"</tr>"+
	
	"<tr><td colspan=\"5\"><hr></td></tr>"+
	
	content+
	
	"</table>"+
		
	
	"</div>"+ 	
	
	"<form style=\"position:relative; top:600px; left:600px;\"><input type=\"button\" onClick=\"window.print()\" value=\"Print\" /></form>\n"+
		 
			
	"</body>"+
	"</html>";
		  
	 
	 fos.write(page.getBytes());
	 fos.close();
	 res.sendRedirect("http://"+addr+":8181/Project/html/adminUserBooking.html");
	 
   
	
	
}



}