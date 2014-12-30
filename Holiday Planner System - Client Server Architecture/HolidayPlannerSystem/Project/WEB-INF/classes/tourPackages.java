import java.io.*;
import java.rmi.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class tourPackages extends HttpServlet
{

public String getHeaderPack(String pid)
{

DatabaseAccessInterface dai=null;
String chk="";
String filedata="";
byte[] b;
String serviceURL=null;
String [] cont=null;
String st = "localhost";
int port = 1099;
//change values whenever needed ..
		
		
		try
		{
		serviceURL="rmi://"+st+":"+port+"/DatabaseAccessServer";
		dai = (DatabaseAccessInterface)Naming.lookup(serviceURL);
		cont = dai.getHead(pid);
		
		File f = new File(cont[1]);
		FileInputStream fis = new FileInputStream(f);
		b = new byte[(int)f.length()];
		fis.read(b);
		filedata = new String(b);
		fis.close();
		
		chk = "<tr style=\"width:100%;\">"+
		"<td><img src=\""+cont[0]+"\" /></td>"+
		"</tr>"+
		
		"<tr>"+
		"<td><div style=\"width:560px;padding:10px;text-align:justify;\">"+filedata+"</div></td>"+
		"</tr>";
			
		}
		catch(Exception e)
		{}
	return chk;
}

public String sidebar(String pid)
{

DatabaseAccessInterface dai=null;
String chk="";
String serviceURL=null;
String [] cont=null;
String st = "localhost";
int port = 1099;
//change values whenever needed ..
		
		
		try
		{
		serviceURL="rmi://"+st+":"+port+"/DatabaseAccessServer";
		dai = (DatabaseAccessInterface)Naming.lookup(serviceURL);
		cont = dai.getSidebar(pid);
		
		chk = "<p style=\"text-decoration:underline; font-size:30px;\">"+cont[0]+"<br/></p>"+
			"<p style=\"font-size:15px;\">"+"Number Of Days: "+cont[1]+"<br/>"+
			"Maximum Seats: "+cont[2]+"<br/>"+
			"Available Seats: "+cont[3]+"<br/>"+
			"Cost : Rs."+cont[4]+"<br/></p>"+
			"<p style=\"text-decoration:underline; font-size:25px;\">Tour Manager Info<br/></p>"+
			"<p style=\"font-size:15px;\">"+"Name: "+cont[5]+"<br/>"+
			"Contact No.: "+cont[7]+"<br/>"+
			"E-mail Id: "+cont[6]+"<br/></p>";
		
			
			
		
		
		
		}
		catch(Exception e)
		{chk=e.toString();}
	return chk;


}

public String getLocationPack(String pid)
{
FileInputStream fis;
File f;
DatabaseAccessInterface dai=null;
String chk="";
byte[] b1,b2;
String serviceURL=null;
String [][] cont=null;
String st = "localhost";
int port = 1099;
String lfile,hfile;
//change values whenever needed ..
		
		
		try
		{
		serviceURL="rmi://"+st+":"+port+"/DatabaseAccessServer";
		dai = (DatabaseAccessInterface)Naming.lookup(serviceURL);
		cont = dai.getLocation(pid);
		
			for(int i=0;i<5;i++)
			{
				if(cont[i][0]==null)
				break;
				
					f = new File(cont[i][3]);
					fis = new FileInputStream(f);
					b1 = new byte[(int)f.length()];
					fis.read(b1);
					lfile = new String(b1);
					fis.close();
					
					
					f = new File(cont[i][5]);
					fis = new FileInputStream(f);
					b2 = new byte[(int)f.length()];
					fis.read(b2);
					hfile = new String(b2);
					fis.close();
					
					
				chk+="<tr style=\"width:100%;height:50px;\">"+
				"<td style=\"font-size:30px;text-decoration:underline;font-weight:bold;\">"+cont[i][0]+"</td>"+
				"</tr>"+
				
				"<tr>"+
				"<td style=\"font-size:20px\">("+cont[i][1]+")</td>"+
				"</tr>"+
				
				"<tr style=\"width:100%;\">"+
				"<td><img src=\""+cont[i][2]+"\" /></td>"+
				"</tr>"+
				
				"<tr>"+
				"<td><div style=\"width:560px;padding:10px;text-align:justify;\">"+lfile+"</div></td>"+
				"</tr>"+
				
				"<tr style=\"width:100%;height:50px;font-size:20px;text-decoration:underline;\">"+
				"<td><b>"+cont[i][4]+"</b></td>"+
				"</tr>"+
				
				"<tr>"+
				"<td><div style=\"width:560px;padding:10px;text-align:justify\"> "+hfile+"</div></td>"+
				"</tr>";
				
			}
		}
		catch(Exception e)
		{chk=e.toString();}
	return chk;
}



public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException
{

	String addr=InetAddress.getLocalHost().getHostAddress();
	String page="";
	FileOutputStream fos = new FileOutputStream("D://Apache/webapps/Project/html/selectedTour.html");
	
	String pid = req.getParameter("pid");
	
	Cookie c = new Cookie("packageid",pid);
	res.addCookie(c);
	
	String h = getHeaderPack(pid);
	String d= getLocationPack(pid);
	String s= sidebar(pid);
	
	page = 
	"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">"+

	"<HTML>"+
	"<TITLE>Travel Planning System</TITLE>"+

	"<HEAD>"+
	"<script>"+
		"function validateForm()"+
		"{"+
		"var x=document.forms[\"input\"][\"members\"].value;"+
		

		"if (x==null || x==\"\")"+
		  "{"+
		  "alert(\"Please Enter Number of Members before Booking Package\");"+
		  "return false;"+
		  "}"+
		"}"+
	"</script>"+
	"</HEAD>"+
	"<BODY style= \"overflow:scroll; background-image:url('/Project/images/tour.png') ; background-repeat:no-repeat;\"  >"+
		
		
		"<div style=\" border-style:groove;border-width:2px; ;position:absolute; top:195px ;left:0px; overflow-y:scroll ; overflow-x:hidden; width:70%; height:500px; color:white; background:black;\">"+
		
			"<table style=\"color:white;width:100%;position:relative ; left:150px;\"  border=\"0\" cellspacing=\"1\" cellpadding=\"1\" >"+
		
			h+
			d+
			"</table>"+
		
		"</div>" +
		
		"<div style=\"position:relative; left:940px ; top:190px; background:black; color:white; width:27%; height:460px; padding:20px;\">"+
		s+
		
			"<form onsubmit=\"return validateForm()\" style=\"position:absolute; top:400px;\"name= \"input\" action=\" /Project/familyInput \" method= \"post\">"+
				"NUMBER OF MEMBERS : <input style=\"position:relative; left:5px; width:60px; height:30px; font-size:20px;\" type= \"text\" name= \"members\" />"+
				"<input style=\" position:relative; top:0px; left:15px; width:100px; height:30px; text-align:center; font-weight:bold;  font-size:20px; \" name= \"Submit\" value=\"Proceed\" type=\"submit\" />"+
			"</form>"+


		"</div>"+
					
	"</BODY>"+
	"</HTML>";

		  
	  
   fos.write(page.getBytes());
   fos.close();
   res.sendRedirect("http://"+addr+":8181/Project/html/selectedTour.html");
}


}