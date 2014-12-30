import java.io.*;
import java.rmi.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class profileProcessed extends HttpServlet
{

public String checkTours(boolean nn ,boolean ww ,boolean ss ,boolean ee  )
{
DatabaseAccessInterface dai=null;
String chk="";
String serviceURL=null;
String [][] cont = null;
String st = "localhost";
int port = 1099;
//change values whenever needed ..
		
		
		try
		{
		serviceURL="rmi://"+st+":"+port+"/DatabaseAccessServer";
		dai = (DatabaseAccessInterface)Naming.lookup(serviceURL);
		cont = dai.getPackages(nn,ww,ss,ee);
		
		
		
		for(int i =0;i<cont.length;i++)
		{
			if(cont[i][0]==null)
				break;
			
			chk+=	"<tr style=\"width:100%;height:110px;\">"+
					"<td style=\"width:110px\">"+
					"<a name=\"pid\" href=\"/Project/tourPackages?pid="+cont[i][0]+"\">"+
					"<img border=\"0\" width=\"100\" height=\"100\" src=\""+cont[i][3]+"\">"+
					"</a>"+
					"</td>"+
					"<td><div style=\"font-size:20px;text-decoration:underline;\">"+cont[i][1]+"</div><b>"+cont[i][2]+"</b></td>"+
					"</tr>";
			
			
		}
		
		}
		catch(Exception e)
		{}
	return chk;
}



public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException
{
	FileOutputStream fos;
	String page=null;
	
	String addr = InetAddress.getLocalHost().getHostAddress();
	boolean n = (req.getParameter("north")!=null);
	boolean s = (req.getParameter("south")!=null);
	boolean e = (req.getParameter("east")!=null);
	boolean w = (req.getParameter("west")!=null);
	
	
	
	String content = checkTours(n,w,s,e);
	
	fos = new FileOutputStream("D://Apache/webapps/Project/html/selectedRegions.html");
	
	page = 
	"<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">"+

	"<html>"+
	"<title>Travel Planning System</title>"+

	"<head>"+
	"</head>"+
	"<body style= \"overflow:scroll; background-image:url('/Project/images/tour.png') ; background-repeat:no-repeat;\"  >"+
	
	"<div style=\" border-style:groove; border-width:2px; position:absolute; top:195px ; overflow-y:scroll ; overflow-x:hidden; width:50%; height:400px; color:white; margin-left:25%;\">"+
	
		
	
	"<table style=\"color:white;width:100%;\"  border=\"0\" cellspacing=\"1\" cellpadding=\"1\" >"+	
	content+
	"</table>"+
		
	
	"</div>"+ 	
	
	
	"</body>"+
	"</html>";
		  
	 
	 fos.write(page.getBytes());
	 fos.close();
	 res.sendRedirect("http://"+addr+":8181/Project/html/selectedRegions.html");
	 
   
	
}




}