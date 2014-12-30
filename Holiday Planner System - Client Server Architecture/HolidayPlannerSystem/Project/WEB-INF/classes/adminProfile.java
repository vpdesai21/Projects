import java.io.*;
import java.rmi.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class adminProfile extends HttpServlet
{


public String getProfile(String u)
{
DatabaseAccessInterface dai=null;
String chk[] =new String[7];
String serviceURL=null;
String msg = "";

String st = "localhost";
int port = 1099;
//change values whenever needed ..
		
		
		try
		{
		serviceURL="rmi://"+st+":"+port+"/DatabaseAccessServer";
		dai = (DatabaseAccessInterface)Naming.lookup(serviceURL);
		chk = dai.fetchUserData(u);
		
		
		
		
		for(int i =0;i<chk.length;i++)
		{
			
			
			msg+=	"<tr style=\"width:100%;height:50px;\">"+
					"<td>"+chk[i]+"</td>"+
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
	
	
	
	String content = getProfile("admin");

	fos = new FileOutputStream("D://Apache/webapps/Project/html/adminProfile.html");
	//---------------------------------------------------------------------------
	page = 
	"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN \">\n"+

	"<HTML>\n"+
	"<TITLE>Travel Planning System</TITLE>\n"+

	"<HEAD>"+
	
	
	"</HEAD>\n"+
	"<BODY style= \"overflow:scroll; background-image:url('/Project/images/adminprofile.png') ; background-repeat:no-repeat;\"  >\n"+
					
	
	"<div style=\" position:relative ; top:270px; left:600px; width:300px; height:380px;\">\n"+
	"<table style=\"color:white;width:100%; font-weight:bold ; font-size:20px;\"  border=\"0\" cellspacing=\"1\" cellpadding=\"1\" >"+	
	content+
	
	"</table>"+
	
	"</div>\n"+
	
	
	
	"</BODY>\n"+
	"</HTML>";
	//---------------------------------------------------------------------------------------
    
	fos.write(page.getBytes());
	fos.close();
	


	
	res.sendRedirect("http://"+addr+":8181/Project/html/adminProfile.html");
	
}



}