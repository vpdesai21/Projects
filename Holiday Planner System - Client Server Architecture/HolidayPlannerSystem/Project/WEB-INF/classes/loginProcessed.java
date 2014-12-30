import java.io.*;
import java.rmi.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class loginProcessed extends HttpServlet
{


public boolean checkDB(String u , String p)
{
DatabaseAccessInterface dai=null;
boolean chk=false;
String serviceURL=null;

String st = "localhost";
int port = 1099;
//change values whenever needed ..
		
		
		try
		{
		serviceURL="rmi://"+st+":"+port+"/DatabaseAccessServer";
		dai = (DatabaseAccessInterface)Naming.lookup(serviceURL);
		chk = dai.checkValidLogin(u,p);
		
		
		}
		catch(Exception e)
		{}
	return chk;
}


public String getPrev(String u)
{
DatabaseAccessInterface dai=null;
String chk="";
String[][] str=null;
String serviceURL=null;

String st = "localhost";
int port = 1099;
//change values whenever needed ..
		
		
		try
		{
		serviceURL="rmi://"+st+":"+port+"/DatabaseAccessServer";
		dai = (DatabaseAccessInterface)Naming.lookup(serviceURL);
		str = dai.getPrevTours(u);
		
		for(int i =0;i<str.length;i++)
		{
			if(str[i][0]==null)
				break;
			
			chk+=	"<tr style=\"width:100%;height:110px;\">"+
					"<td style=\"width:110px\">"+
					"<a name=\"pid\" href=\"/Project/tourPackages?pid="+str[i][0]+"\">"+
					"<img border=\"0\" width=\"100\" height=\"100\" src=\""+str[i][3]+"\">"+
					"</a>"+
					"</td>"+
					"<td><div style=\"font-size:20px;text-decoration:underline;\">"+str[i][1]+"</div><b>"+str[i][2]+"</b></td>"+
					"</tr>";
			
			
		}
		}
		catch(Exception e)
		{}
	return chk;
}


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


public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException
{

	String addr=InetAddress.getLocalHost().getHostAddress();
	FileOutputStream fos;
	String uname = req.getParameter("username");
	String pwd = req.getParameter("password");
	
	String page=null;
	
	
	String content = getProfile(uname);
	String cont = getPrev(uname);
	
	fos = new FileOutputStream("D://Apache/webapps/Project/html/userProfile.html");
	
	
	if(checkDB(uname,pwd) && uname.equals("admin") && !pwd.equals(""))
	{
	res.sendRedirect("http://"+addr+":8181/Project/html/adminmenu.html");
	
	Cookie c = new Cookie("username",uname);
	res.addCookie(c);
	}
	else if(checkDB(uname,pwd) && !uname.equals("") && !pwd.equals(""))
	{

	Cookie c = new Cookie("username",uname);
	res.addCookie(c);
	//---------------------------------------------------------------------------
	page = 
	"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN \">\n"+

	"<HTML>\n"+
	"<TITLE>Travel Planning System</TITLE>\n"+

	"<HEAD>"+
	"<script type=\"text/javascript\" language=\"JavaScript\">"+

	"function checkCheckBoxes(theForm) {"+
		"if ("+
		"theForm.north.checked == false &&"+
		"theForm.west.checked == false &&"+
		"theForm.east.checked == false &&"+
		"theForm.south.checked == false) "+
		"{"+
			"alert ('Please Select a Region before Proceeding !!');"+
			"return false;"+
		"} else { 	"+
			"return true;"+
		"}"+
	"}"+

	"</script>"+
	
	"</HEAD>\n"+
	"<BODY style= \"overflow:scroll; background-image:url('/Project/images/profile.png') ; background-repeat:no-repeat;\"  >\n"+
					
	"<div style=\"position:relative ; top:350px; left:980px; color:white; font-weight:bold; font-size:30px; width:200px ; height:250px; margin:20px 20px; \">\n"+

	"<p style=\"text-decoration:underline;font-size:20px;\">Select Region</p>\n"+

	"<form name= \"input\" onsubmit=\"return checkCheckBoxes(this)\" action=\" /Project/profileProcessed \" method= \"post\">\n"+
	"<input type=\"checkbox\" name=\"north\" value=\"n\" /> North<br />\n"+
	"<input type=\"checkbox\" name=\"west\" value=\"w\" /> West<br />\n"+
	"<input type=\"checkbox\" name=\"south\" value=\"s\" /> South<br />\n"+
	"<input type=\"checkbox\" name=\"east\" value=\"e\" /> East<br />\n"+
	"<input style=\"margin:20px 30px;font-weight:bold;font-size:18px;width:100px;\" type =\"submit\" name=\"Submit\" value=\"Go\"/>\n"+
	"</form>\n"+

	"</div>\n"+
	
	"<div style=\" position:absolute; top:270px ; left:26px; overflow-y:scroll ; overflow-x:hidden; width:315px; height:380px; color:white; \">\n"+
	
	"<table style=\"color:white;width:100%;\"  border=\"0\" cellspacing=\"1\" cellpadding=\"1\" >"+	
	cont+
	"</table> \n"+
		
	"</div>\n"+ 

	"<div style=\" position:relative ; top:0px; left:600px; width:300px; height:380px;\">\n"+
	"<table style=\"color:white;width:100%; font-weight:bold ; font-size:20px;\"  border=\"0\" cellspacing=\"1\" cellpadding=\"1\" >"+	
	content+
	
	"</table>"+
	
	"</div>\n"+
	
	
	
	"</BODY>\n"+
	"</HTML>";
	//---------------------------------------------------------------------------------------
    
	fos.write(page.getBytes());
	fos.close();
	


	
	res.sendRedirect("http://"+addr+":8181/Project/html/userProfile.html");
	
	}
	else
	{
	
	res.sendRedirect("http://"+addr+":8181/Project/html/home.html?value=false");
	
	}
}



}