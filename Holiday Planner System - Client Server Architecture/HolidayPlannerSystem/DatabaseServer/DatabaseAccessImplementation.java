import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
import java.sql.*;



public class DatabaseAccessImplementation extends UnicastRemoteObject implements DatabaseAccessInterface
{
String uname,packid;

public DatabaseAccessImplementation() throws RemoteException 
{uname="";
packid="";
 }

public Connection Connect() throws RemoteException
{
Connection con=null;

		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:vishwa/vishwa@localhost:1521:XE");
		//change host and port whenever needed ..
		}
		catch(Exception exp)
		{}
return con;
}

public void disConnect(Connection c) throws RemoteException
{
	try
	{
	c.close();
	}
	catch(Exception exp)
	{}
}


public boolean checkValidLogin(String u , String p) throws RemoteException
{
Connection c;
Statement st;
ResultSet rs;
String que;
	
	try
	{

	c = Connect();

	st=c.createStatement();
	que="select password from user1 where uname='"+u+"'";
	rs = st.executeQuery(que);


		while(rs.next())
		{
			if(rs.getString(1).equals(p))
			{
			uname=u;
			return true;
			}
		}

	 
	rs.close();
	st.close();


	disConnect(c);

	return false;
	}
	catch(Exception e)
	{}

return false;
}




public String[] fetchUserData(String u) throws RemoteException
{
Connection c;
Statement st;
ResultSet rs;
String que;
String str[]= new String[7];	
	try
	{

	c = Connect();

	st=c.createStatement();
	que="select * from user1 where uname='"+u+"'";
	rs = st.executeQuery(que);
	

		while(rs.next())
		{
		String gn2;
		String gn=rs.getString("gender");

		if(gn.equals("m")) {gn2="Male";}
		else {gn2="Female";}  

		String mp=rs.getString("birthdate"); 
		String yyyy= mp.substring(0,4);
		String mm= mp.substring(5,7);
		String dd= mp.substring(8,10);
		mp=dd+"-"+mm+"-"+yyyy;

		 str[0] = u;
		 str[1] = rs.getString("fname")+" "+rs.getString("lname");
		 str[2] = gn2;
		 str[3] = mp;
		 str[4] = rs.getString("addr");
		 str[5] = rs.getString("phno");
		 str[6] = rs.getString("email");
		 

		return str;

		}

	 
	rs.close();
	st.close();


	disConnect(c);

	return str;
	}
	catch(Exception e)
	{}

return str;
}


public String[][] getPackages(boolean nnn,boolean www,boolean sss,boolean eee)
{
int i=0;
int nn,ww,ss,ee;
nn=ww=ss=ee=0;
String[][] sa=new String[20][4];

if(nnn){nn=1;}
if(www){ww=2;}
if(sss){ss=3;}
if(eee){ee=4;}


 
Connection c;
Statement st;
ResultSet rs;
String que,sp,sd,iconfile;

try{
c=Connect();
st=c.createStatement();

que="select pid,pname,description,iconimage from travelpackage where region_id in ("+nn+","+ww+","+ss+","+ee+")";
rs = st.executeQuery(que);



while(rs.next())
{
sa[i][0]=rs.getString("pid");
sa[i][1]=rs.getString("pname");
sa[i][2]=rs.getString("description");
sa[i][3]=rs.getString("iconimage");
i++;
}
  
rs.close();
st.close();
disConnect(c);
}

catch(Exception e)
{}

return sa;
}


public boolean checkUserExists(String u) throws RemoteException
{
Connection c;
Statement st;
ResultSet rs;
String que;
	
	try
	{

	c = Connect();

	st=c.createStatement();
	que="select uname from user1";
	rs = st.executeQuery(que);


		while(rs.next())
		{
			if(rs.getString(1).equals(u))
			{
			return true;
			}
		}

	 
	rs.close();
	st.close();


	disConnect(c);

	return false;
	}
	catch(Exception e)
	{}

return false;
}

public void insertUserProfile(String u, String p,String f,String l,String b,String g,String a,String ph,String e) throws RemoteException
{
Connection con;
Statement st;

String que;
try{

con = Connect();
st=con.createStatement();

que="insert into user1 values('"+u+"','"+p+"','"+f+"','"+l+"','"+b+"','"+a+"',"+ph+",'"+e+"','"+g+"')";
st.executeQuery(que);

st.close();

disConnect(con);

}
catch(Exception exp)
{}

}


public String[] getHead(String pid) throws RemoteException
{

packid=pid; //class variable
Connection con;
Statement st;
ResultSet rs;
String que;
String[] r=new String[2];
try{

con = Connect();
st=con.createStatement();

que="select imagefile,datafile from travelPackage where pid='"+pid+"'";
rs = st.executeQuery(que);

while(rs.next())
{

r[0] = rs.getString("imagefile");
r[1] = rs.getString("datafile");

}

st.close();

disConnect(con);

}
catch(Exception exp)
{}
return r;
}


public String[][] getLocation(String pid) throws RemoteException
{
int i=0;
Connection con;
Statement st;
ResultSet rs;
String que;
String[][] r=new String[5][6];
try{

con = Connect();
st=con.createStatement();

que="select c.*, l.*, h.* from contains c , location l, hotel h where l.lid=c.lid and h.hid=c.hid and pid='"+pid+"'";
rs = st.executeQuery(que);

while(rs.next())
{

r[i][0]=rs.getString("lname");
r[i][1]=rs.getString("noofdays"); 
r[i][2]=rs.getString("imagefile1");
r[i][3]=rs.getString("datafile");
r[i][4]=rs.getString("hname");
r[i][5]=rs.getString(12);
i++;
}

st.close();

disConnect(con);

}
catch(Exception exp)
{}
return r;
}


public String[] getSidebar(String pid) throws RemoteException
{

Connection con;
Statement st;
ResultSet rs;
String que;
String[] r=new String[8];




try{

con = Connect();
st=con.createStatement();


que="select t.*,tm.* from travelpackage t, tourmanager tm where tm.tmid=t.tmid and pid='"+pid+"'";
rs = st.executeQuery(que);

	while(rs.next())
	{
	r[0]=rs.getString("pname");
	r[1]=rs.getString("noofdays");
	r[2]=rs.getString("maxseats");
	r[3]=rs.getString("availseats");
	r[4]=rs.getString("cost");

	r[5]=rs.getString("tmname");
	r[6]=rs.getString("email");
	r[7]=rs.getString("phno");


	}

	st.close();
	disConnect(con);

}
catch(Exception exp)
{}
return r;


}



public void insertFamilyData(String[][] arr) throws RemoteException
{

Connection con;
Statement st;
ResultSet rs;
String que;
int i;
	try{

		con = Connect();
		st=con.createStatement();
		
		
		
		
				
		que="select count(*) from family where uname='"+uname+"'";
		rs= st.executeQuery(que);
		int n=0;
		
		
		while(rs.next())
		{
		n=rs.getInt(1);
		}
		
		for ( i=0;i<arr.length;i++)
		{
			if(arr[i][0]==null)
			break;
			
			String ss=arr[i][0]+" "+arr[i][1];
			que="insert into family values ('f"+(n+1+i)+"','"+uname+"','"+ss+"','"+arr[i][2]+"','"+packid+"')";
			st.executeQuery(que);
		}

		
		
		que="insert into selects values('"+uname+"','"+packid+"',sysdate,"+i+")";
		st.executeQuery(que);
		
		
		
		que="update travelpackage set availseats=availseats-"+i+" where pid='"+packid+"'";
		st.executeQuery(que);
		
		st.close();

		disConnect(con);
	}

catch(Exception exp)
{}

}


public String[][] getPrevTours(String un) throws RemoteException
{

Connection c;
Statement st;
ResultSet rs;
String que;
int i=0;
String[][] sa=new String[20][4];

	try{

		c = Connect();
		st=c.createStatement();		
		que="select distinct(t.pid) , pname,description ,iconimage from travelpackage t, selects s  where t.pid=s.pid and   uname='"+un+"'";
		rs = st.executeQuery(que);

	while(rs.next())
	{
	sa[i][0]=rs.getString(1);
	sa[i][1]=rs.getString("pname");
	sa[i][2]=rs.getString("description");
	sa[i][3]=rs.getString("iconimage");
	i++;
	}
	  
	rs.close();
	st.close();
	disConnect(c);
	}

	catch(Exception e)
	{}

	return sa;


}


public String[] getReceiptData() throws RemoteException
{

Connection con;
Statement st;
ResultSet rs;
String que;
String[] r=new String[5];


try{

con = Connect();
st=con.createStatement();


que="select t.*,tm.* from travelpackage t, tourmanager tm where tm.tmid=t.tmid and pid='"+packid+"'";
rs = st.executeQuery(que);

	while(rs.next())
	{
	r[0]=rs.getString("pname");
	r[1]=rs.getString("description");
	r[2]=rs.getString("tmname");
	r[3]=rs.getString("phno");
	r[4]=rs.getString("cost");
	}

	
	
	
	st.close();
	disConnect(con);

}
catch(Exception exp)
{}
return r;




}



public String[][] getMembers() throws RemoteException
{

Connection con;
Statement st;
ResultSet rs;
String que;
String[][] r=null;


try{

	con = Connect();
	st=con.createStatement();
	
	que="select count(*) from family where uname='"+uname+"' and pid='"+packid+"'";
	rs = st.executeQuery(que);
	int no=0;
	
	while(rs.next())
	{
	no= rs.getInt(1);
	}
	
	r =new String[no][2];
	que="select fname,birthdate from family where uname='"+uname+"' and pid='"+packid+"'";
	rs = st.executeQuery(que);
	int i=0;
	while(rs.next())
	{
	r[i][0]=rs.getString("fname");
	r[i][1]=rs.getString("birthdate");
	i++;
	}
	
	
	st.close();
	disConnect(con);

}
catch(Exception exp)
{}
return r;




}


public String[][] fetchBookingData() throws RemoteException
{
Connection c=null;
ResultSet rs=null;
Statement st=null;
String que;
String ob[][] = new String[50][5];
String s1,s2,s3,s4,s5,s6;
int i=0;

try{

c = Connect();
st=c.createStatement();
que="select p.*,u.*,s.* from user1 u, travelpackage p, selects s where s.pid=p.pid and s.uname=u.uname";
rs = st.executeQuery(que);

		while(rs.next())
		{
		s1=rs.getString("fname");
		s6=rs.getString("lname");

		s2=rs.getString("pname");
		s3=rs.getString("pdate");
		s4=rs.getString("noofseats");
		s5=rs.getString("phno");


		ob[i][0]=s1+" "+s6;
		ob[i][1]=s2;
		ob[i][2]=s3;
		ob[i][3]=s4;
		ob[i][4]=s5;

		i++;
		}

rs.close();
st.close();
disConnect(c);
}
catch(Exception exp)
{}
return ob;

}


public String[][] fetchPackageData() throws RemoteException
{

Connection c=null;
ResultSet rs=null;
Statement st=null;
String que;
String ob2[][] = new String[20][5];
String s1,s2;
String s3= null;
String s4,s5,s6,rid;
int i=0;

try
{
c = Connect();
st=c.createStatement();
que="select * from travelpackage";
rs = st.executeQuery(que);



		while(rs.next())
		{
		s1=rs.getString("pname");
		s2=rs.getString("description");
		rid=rs.getString("region_id");
		s4=rs.getString("availseats");
		s5=rs.getString("cost");



		if(rid.equals("1")){s3="North";}
		else if(rid.equals("2")){s3="West";}
		else if(rid.equals("3")){s3="South";}
		else if(rid.equals("4")){s3="East";}


		ob2[i][0]=s1;
		ob2[i][1]=s2;
		ob2[i][2]=s3;
		ob2[i][3]=s4;
		ob2[i][4]=s5;

		i++;
		}
  
rs.close();
st.close();
disConnect(c);
}
catch(Exception exp)
{}

return ob2;
}


}