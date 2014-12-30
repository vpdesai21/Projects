import java.io.*;
import java.rmi.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class familyInput extends HttpServlet
{



public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException
{

	String addr=InetAddress.getLocalHost().getHostAddress();;
	FileOutputStream fos;
	String n = req.getParameter("members");
	int no = Integer.parseInt(n);
	
	
	String page=null;
	
	
	
	
	fos = new FileOutputStream("D://Apache/webapps/Project/html/familyData.html");
	
	//----------------------------------------------------------------------------------
	
	String str1 ="";
	
	for(int i=0;i<no;i++)
	{
	
	
	str1 += "var x"+(i+1)+"=document.forms[\"myForm\"][\"fname"+(i+1)+"\"].value;\n"+
		"var y"+(i+1)+"=document.forms[\"myForm\"][\"lname"+(i+1)+"\"].value;\n"+
		"var z"+(i+1)+"=document.forms[\"myForm\"][\"bdate"+(i+1)+"\"].value;\n"+
		
		"if (x"+(i+1)+"==null || x"+(i+1)+"==\"\" || y"+(i+1)+"==null || y"+(i+1)+"==\"\" || z"+(i+1)+"==null || z"+(i+1)+"==\"\" )\n"+
			  "{\n"+
			  "alert(\"All Fields are mandatory. Error in Member["+(i+1)+"]\");\n"+
			  "return false;\n"+
			  "}\n"+
		"if(!(isDate(z"+(i+1)+")))\n"+
			  "{\n"+
			  
			  "alert(\"Invalid BirthDate"+(i+1)+"(mm/dd/yyyy)!!\");\n"+
			  "return false;\n"+
			  "}\n";
	
	}
	
	
	
	String stra = "";
	
	for(int i=0;i<no;i++)
	{
	stra += "<tr style=\"text-align:center;font-size:20px;text-decoration:underline;\">\n"+
					"<td colspan=2> ENTER DETAILS FOR MEMBER "+(i+1)+"</td>\n"+
					"</tr>\n"+
					
					"<tr>\n"+
					"<td>FIRST NAME : </td>\n"+
					"<td><input style=\" width:200px; height:30px; background-color:black; color:white; font-size:20px;\" type= \"text\" name= \"fname"+(i+1)+"\" /></td>\n"+
					"</tr>\n"+		
					
					"<tr>\n"+
					"<td>LAST NAME   : </td>\n"+
					"<td><input style=\" width:200px; height:30px; background-color:black; color:white; font-size:20px;\" type= \"text\" name= \"lname"+(i+1)+"\" />\n"+
					"</td>\n"+
					"</tr>\n"+	
					
					"<tr>\n"+
					"<td>BIRTHDATE   : </td>\n"+
					"<td><input style=\"width:200px; height:30px; background-color:black; color:white; font-size:20px;\" type= \"text\" name= \"bdate"+(i+1)+"\" />\n"+
					"</td>\n"+
					"</tr>";	
	
	}
	
	
	
	
	
	
	//---------------------------------------------------------------------------
	page = 
		"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n"+

		"<HTML>\n"+
		"<TITLE>Travel Planning System</TITLE>\n"+

		"<HEAD>\n"+
		"<script>\n"+
		"function isDate(txtDate)\n "+
		"{\n"+
			"var objDate,  // date object initialized from the txtDate string\n"+
				"mSeconds, // txtDate in milliseconds\n"+
				"day,      // day\n"+
				"month,    // month\n"+
				"year;     // year\n"+
			// date length should be 10 characters (no more no less)
			"if (txtDate.length !== 10) {\n"+
				"return false;\n"+
			"}\n"+
			// third and sixth character should be '/'
			"if (txtDate.substring(2, 3) !== '/' || txtDate.substring(5, 6) !== '/') {\n"+
				"return false;\n"+
			"}\n"+
			// extract month, day and year from the txtDate (expected format is mm/dd/yyyy)
			// subtraction will cast variables to integer implicitly (needed
			// for !== comparing)
			"month = txtDate.substring(0, 2) - 1; // because months in JS start from 0\n"+
			"day = txtDate.substring(3, 5) - 0;\n"+
			"year = txtDate.substring(6, 10) - 0;\n"+
			// test year range
			"if (year < 1000 || year > 3000) {\n"+
				"return false;\n"+
			"}\n"+
			// convert txtDate to milliseconds
			"mSeconds = (new Date(year, month, day)).getTime();\n"+
			// initialize Date() object from calculated milliseconds
			"objDate = new Date();\n"+
			"objDate.setTime(mSeconds);\n"+
			// compare input date and parts from Date() object
			// if difference exists then date isn't valid
			"if (objDate.getFullYear() !== year ||\n"+
				"objDate.getMonth() !== month ||\n"+
				"objDate.getDate() !== day) {\n"+
				"return false;\n"+
			"}\n"+
			// otherwise return true
			"return true;\n"+
		"}\n"+
		"function validateForm()\n"+
		"{\n"+
		 str1+
		"}\n"+
		"</script>\n"+
		"</HEAD>\n"+
		"<BODY style= \"overflow:scroll; background-image:url('/Project/images/family.png') ; background-repeat:no-repeat;\"  >\n"+
			
			
			"<div style=\" border-style:groove;border-width:2px; ;position:absolute; top:205px ; left:50px; overflow-y:scroll ; overflow-x:hidden; width:50%; height:450px; color:white; margin-left:25%;\">\n"+
				
					
					"<form name=\"myForm\" onsubmit=\"return validateForm()\" action=\"/Project/receiptPage \"  method=\"post\">\n"+
					
					"<table style=\"position:relative; top:50px; left:100px; width:70% ; color:white; \" border=\"0\">\n"+
					
					stra+
					
					"</table>\n"+

						"<input style=\" position:relative; top:80px; left:200px; width:200px; height:40px; text-align:center; font-weight:bold;  font-size:20px; \" name= \"Submit\" value=\"Book Package\" type=\"submit\" />\n"+
				
					"</form>\n"+
			"</div>\n"+ 	

						
		"</BODY>\n"+
		"</HTML>";
	//---------------------------------------------------------------------------------------
    
	fos.write(page.getBytes());
	fos.close();
	
	res.sendRedirect("http://"+addr+":8181/Project/html/familyData.html");
	
	}
	
}

