import java.io.*;
import java.rmi.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class registerProcessed extends HttpServlet
{


public boolean checkDB(String u)
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
		chk = dai.checkUserExists(u);
		
		}
		catch(Exception e)
		{}
	return chk;
}

public void insertUser(String u, String p,String f,String l,String b,String g,String a,String ph,String e)
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
		dai.insertUserProfile(u,p,f,l,b,g,a,ph,e);
		
		}
		catch(Exception exp)
		{}
	
}



public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException,IOException
{

	String addr=InetAddress.getLocalHost().getHostAddress();
	FileOutputStream fos;
	String uname = req.getParameter("username");
	String pwd = req.getParameter("password1");
	String fname = req.getParameter("firstname");
	String lname = req.getParameter("lastname");
	String gen = req.getParameter("gender");
	String dt = req.getParameter("birthdate").trim();
	String add = req.getParameter("address");
	String phno = req.getParameter("phoneno");
	String email = req.getParameter("email");
	
	int m = Integer.parseInt(dt.substring(0,2));
	String[] months={"","jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
	String mon= months[m];
	String date = dt.substring(3,5)+"-"+mon+"-"+dt.substring(8,10);
	
	if(checkDB(uname))//check if username already exists
	{
	res.sendRedirect("http://"+addr+":8181/Project/html/registerUser.html?value=false");
	
	}
	else
	{
	insertUser(uname,pwd,fname,lname,date,gen,add,phno,email);
	res.sendRedirect("http://"+addr+":8181/Project/html/registerUser.html?value=true");
	
	}
}



}