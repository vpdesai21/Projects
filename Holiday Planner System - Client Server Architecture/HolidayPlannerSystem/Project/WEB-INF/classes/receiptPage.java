import java.io.*;
import java.rmi.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class receiptPage extends HttpServlet
{

int mem;

public void insertFamily(String[][] info)
{
DatabaseAccessInterface dai=null;
String serviceURL=null;
String st = "localhost";
int port = 1099;
//change values whenever needed ..
		
		
		try
		{
		serviceURL="rmi://"+st+":"+port+"/DatabaseAccessServer";
		dai = (DatabaseAccessInterface)Naming.lookup(serviceURL);
		
		
		dai.insertFamilyData(info);
		
		
		}
		catch(Exception e)
		{}
	
}


public String[] getReceipt()
{
DatabaseAccessInterface dai=null;
String serviceURL=null;
String st = "localhost";
int port = 1099;
//change values whenever needed ..
String[] str = null;
		
		try
		{
		serviceURL="rmi://"+st+":"+port+"/DatabaseAccessServer";
		dai = (DatabaseAccessInterface)Naming.lookup(serviceURL);
		
		
		str = dai.getReceiptData();
		
		
		
		}
		catch(Exception e)
		{}

return str;
}

public String getMemberReceipt()
{
DatabaseAccessInterface dai=null;
String serviceURL=null;
String st = "localhost";
int port = 1099;
//change values whenever needed ..
String[][] str = null;
String chk="";
		
		try
		{
		serviceURL="rmi://"+st+":"+port+"/DatabaseAccessServer";
		dai = (DatabaseAccessInterface)Naming.lookup(serviceURL);
		str = dai.getMembers();
		
		mem = str.length;
		
		for(int i=0;i<str.length;i++)
		{
		chk+="<tr style=\"font-size:20px;text-align:center;\">\n"+
			"<td style=\"font-weight:bold\">"+str[i][0]+"</td>\n"+
			"<td>"+str[i][1]+"</td>\n"+
			"</tr>\n";
		}
		
		}
		catch(Exception e)
		{}

return chk;
}

public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException
{

	String addr=InetAddress.getLocalHost().getHostAddress();
	FileOutputStream fos;
	String[][] data = new String[10][3];
	
	for(int i=0;i<10;i++)
	{
	data[i][0]=req.getParameter("fname"+(i+1));
	data[i][1]=req.getParameter("lname"+(i+1));
	data[i][2]=req.getParameter("bdate"+(i+1));
	}
	
	
	String page=null;
	
	insertFamily(data);
	
	fos = new FileOutputStream("D://Apache/webapps/Project/html/receiptShow.html");
	
	String[] st = getReceipt();
	String sta = getMemberReceipt();
	//---------------------------------------------------------------------------
	page = 
	"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN \">"+

	"<HTML>\n"+
	"<TITLE>Travel Planning System</TITLE>\n"+

	"<HEAD>\n"+
	
	"</HEAD>\n"+
	"<BODY style= \"overflow:scroll; background-image:url('/Project/images/end.png') ; background-repeat:no-repeat;  \"  >\n"+
					
	"<div style=\"background:black; color:white; position:relative; top:222px; left:252px; width:700px ; height:500px;\">"+
	
	"<table style=\"position:relative; top:0px; left:50px; width:80% ; color:white; \" border=\"0\">\n"+
			"<tr style=\"font-size:25px;text-decoration:underline;text-align:center;\">\n"+
			"<td colspan=3>RECEIPT</td>\n"+
			"</tr>\n"+
			
			"<tr style=\"font-size:20px;\">\n"+
			"<td style=\"font-weight:bold;text-align:right;\">Package Name :</td>\n"+
			"<td style=\"text-align:left;\">"+st[0]+"</td>\n"+
			"</tr>\n"+
			
			"<tr style=\"font-size:20px;\">\n"+
			"<td style=\"font-weight:bold;text-align:right;\">Package Details :</td>\n"+
			"<td style=\"text-align:left;\">"+st[1]+"</td>\n"+
			"</tr>\n"+
			
			
			"<tr style=\"font-size:20px;\">\n"+
			"<td style=\"font-weight:bold;text-align:right;\">Tour Manager :</td>\n"+
			"<td style=\"text-align:left;\">"+st[2]+" ("+st[3]+")</td>\n"+
			"</tr>\n"+
		
			
			"<tr style=\"font-size:20px;\">\n"+
			"<td colspan=3><hr></td>\n"+
			"</tr>\n"+
			
			"<tr style=\"font-size:25px;text-decoration:underline;text-align:center;\">\n"+
			"<td colspan=3>MEMBER DETAILS</td>\n"+
			"</tr>\n"+
			
			//in loop
			sta+
			//---
			
			
			"<tr style=\"font-size:20px;\">\n"+
			"<td colspan=3><hr></td>\n"+
			"</tr>\n"+
			
			"<tr style=\"font-size:25px;text-decoration:underline;text-align:center;\">\n"+
			"<td colspan=3>TARRIF DETAILS</td>\n"+
			"</tr>\n"+
			
			"<tr style=\"font-size:20px;text-align:center;font-weight:bold;text-decoration:underline; \">\n"+
			"<td>Package Tarrif(per Person)</td>\n"+
			"<td>Number Of Members</td>\n"+
			"<td>Total</td>\n"+
			"</tr>\n"+
			
			"<tr style=\"font-size:20px;text-align:center;\">\n"+
			"<td>Rs."+st[4]+"</td>\n"+
			"<td>"+mem+"</td>\n"+
			"<td>Rs."+(mem*Integer.parseInt(st[4]))+"</td>\n"+
			"</tr>\n"+
			
			"<tr style=\"font-size:20px;\">\n"+
			"<td colspan=3><hr></td>\n"+
			"</tr>\n"+ 
			
			"<tr style=\"font-size:25px;text-decoration:underline;text-align:center;\">\n"+
			"<td colspan=3><form><input type=\"button\" onClick=\"window.print()\" value=\"Print\" /></form></td>\n"+
			"</tr>\n"+
			
	"</table>\n"+
	"</div>\n"+
	
	"</BODY>\n"+
	"</HTML>";
	//---------------------------------------------------------------------------------------
    
	fos.write(page.getBytes());
	fos.close();
	
	res.sendRedirect("http://"+addr+":8181/Project/html/receiptShow.html");

}



}