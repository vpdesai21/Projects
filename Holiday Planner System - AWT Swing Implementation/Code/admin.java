import javax.swing.table.*;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.*;


public class admin extends JPanel implements ActionListener,ItemListener
{
java.awt.Font f2;
JPanel jp1,jp2,jp3,jp4;
JButton  b1 , b2 , b3 , b4;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
JLabel le1,le2,le3,le4,le5,le6,le7,le8,le9,le10;
JLabel a,a2,a3,a4;
JScrollPane jsp,jsp1;
JTable jt,jt1;
JComboBox jcb;
JLabel jl;
JButton l;
DefaultTableModel d1,d2;

String values[][] =new String[0][];
String val[][] =new String[0][];


String cname1[] = {"Name","Package Name","Booking Date","Seats","Contact No."};
String cnm[] = {"Package Name","Locations","Region","Available Seats","Tariff"};
String ob[]=new String[5];
String ob2[]=new String[5];

admin(JButton logout)
{
setLayout(null);
setBounds(0,0,1280,1024);

a= new JLabel(new ImageIcon("C:\\project\\images\\adminintro.png"));
a.setBounds(0,0,1280,1024);

f2 = new java.awt.Font("Arial",java.awt.Font.PLAIN,20);


l= logout;


//=============INTRO PANEL=============================
jp1 = new JPanel();
jp1.setBounds(0,0,1280,1024);
jp1.setOpaque(false);
jp1.setLayout(null);

b1= new JButton( new ImageIcon("c:\\project\\images\\adminb1.png"));
b1.setBounds(500,350,300,100);
b1.setActionCommand("PROFILE");
b1.addActionListener(this);

b2= new JButton(new ImageIcon("c:\\project\\images\\adminb2.png"));
b2.setBounds(500,450,300,100);
b2.setActionCommand("USER DETAILS");
b2.addActionListener(this);


b3= new JButton(new ImageIcon("c:\\project\\images\\adminb3.png"));
b3.setBounds(500,550,300,100);
b3.setActionCommand("PACKAGE DETAILS");
b3.addActionListener(this);

jp1.add(b1);
jp1.add(b2);
jp1.add(b3);
//==================================================

//=======PROFILE===================================
jp2 = new JPanel();
jp2.setBounds(0,0,1280,1024);
jp2.setLayout(null);
jp2.setVisible(false);

a2 = new JLabel(new ImageIcon("C:\\project\\images\\adminprofile.png"));
a2.setBounds(00,00,1280,1024);

// username--------------------------------------------------
l1 =new JLabel("Username:",JLabel.RIGHT);
l1.setBounds(320,280,200,30);
l1.setForeground(Color.white);
l1.setFont(f2);

le1 =new JLabel("Admin");
le1.setBounds(540,280,200,30);
le1.setForeground(Color.white);
le1.setFont(f2);


//first name-------------------------------------------------------------

l3 =new JLabel("First Name:",JLabel.RIGHT);
l3.setBounds(320,320,200,30);
l3.setForeground(Color.white);
l3.setFont(f2);

le3 =new JLabel("Holiday planner");
le3.setBounds(540,320,200,30);
le3.setForeground(Color.white);
le3.setFont(f2);

//last name-----------------------------------------------------

l4 =new JLabel("Last Name:",JLabel.RIGHT);
l4.setBounds(320,360,200,30);
l4.setForeground(Color.white);
l4.setFont(f2);

le4 =new JLabel("-");
le4.setBounds(540,360,200,30);
le4.setForeground(Color.white);
le4.setFont(f2);

//birth date-----------------------------------------------------

l5 =new JLabel("Birth Date:",JLabel.RIGHT);
l5.setBounds(320,400,200,30);
l5.setForeground(Color.white);
l5.setFont(f2);

le5 =new JLabel("25-02-1987");
le5.setBounds(540,400,400,30);
le5.setForeground(Color.white);
le5.setFont(f2);

//Gender----------------------------------------------------------

l6 =new JLabel("Gender:",JLabel.RIGHT);
l6.setBounds(320,440,200,30);
l6.setForeground(Color.white);
l6.setFont(f2);

le6 =new JLabel("male");
le6.setBounds(540,440,200,30);
le6.setForeground(Color.white);
le6.setFont(f2);


//address-----------------------------------------------------

l7 =new JLabel("Address:",JLabel.RIGHT);
l7.setBounds(320,480,200,30);
l7.setForeground(Color.white);
l7.setFont(f2);

le7 =new JLabel("Vadodara");
le7.setBounds(540,480,200,30);
le7.setForeground(Color.white);
le7.setFont(f2);

//address2-------------------------------------------

l8 =new JLabel("",JLabel.RIGHT);
l8.setBounds(320,520,200,30);
l8.setForeground(Color.white);
l8.setFont(f2);

le8 =new JLabel();
le8.setBounds(540,520,200,30);
le8.setForeground(Color.white);
le8.setFont(f2);

//phone -------------------------------------------------

l9 =new JLabel("Phone number:",JLabel.RIGHT);
l9.setBounds(320,560,200,30);
l9.setForeground(Color.white);
l9.setFont(f2);

le9 =new JLabel("9998989999");
le9.setBounds(540,560,200,30);
le9.setForeground(Color.white);
le9.setFont(f2);


//e mail -----------------------------------------------------

l10 =new JLabel("E-mail ID:",JLabel.RIGHT);
l10.setBounds(320,600,200,30);
l10.setForeground(Color.white);
l10.setFont(f2);

le10 =new JLabel("admin@holidayplanner.com");
le10.setBounds(540,600,500,30);
le10.setForeground(Color.white);
le10.setFont(f2);


 jp2.add(l1);
 jp2.add(l3);//note : the values will already be fetched here so direct set le1-le10 here
 jp2.add(l4);
 jp2.add(l5);
 jp2.add(l6);
 jp2.add(l7);
 jp2.add(l8);
 jp2.add(l9);
 jp2.add(l10);
 jp2.add(le1);
 jp2.add(le3);
 jp2.add(le4);
 jp2.add(le5);
 jp2.add(le6);
 jp2.add(le7);
 jp2.add(le8);
 jp2.add(le9);
 jp2.add(le10);

jp2.add(a2);
//=============================================================

//===========USER DETAILS====================================
jp3 = new JPanel();
jp3.setBounds(0,0,1280,1024);
jp3.setLayout(null);
jp3.setVisible(false);

a3 = new JLabel(new ImageIcon("C:\\project\\images\\adminuser.png"));
a3.setBounds(00,00,1280,1024);


 


					 

				
d1=new DefaultTableModel(values,cname1);				

jt  = new JTable(d1);
jt.setBackground(Color.black);
jt.setForeground(Color.white);
jt.setOpaque(false);
jt.setBounds(210,206,800,470);
jt.setEnabled(false);

int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
jsp = new JScrollPane(jt,v,h);
jsp.setBounds(209,205,801,471);
jsp.setBackground(Color.black);

/* 
jl = new JLabel("Filter (Sort By) : ");
jl.setBounds(1050,260,100,30);
jl.setForeground(Color.white);

jcb = new JComboBox();
jcb.setBounds(1050,300,150,50);
jcb.setBackground(Color.black);
jcb.setForeground(Color.white);
jcb.addItem("Name");
jcb.addItem("Package"); 

jp3.add(jl);
jp3.add(jcb);
*/

jp3.add(jsp);
jp3.add(a3);
//====================================================


//========PACKAGE DETAILS================================

jp4 = new JPanel();
jp4.setBounds(0,0,1280,1024);
jp4.setLayout(null);
jp4.setVisible(false);

a4 = new JLabel(new ImageIcon("C:\\project\\images\\adminpack.png"));
a4.setBounds(00,00,1280,1024);

d2=new DefaultTableModel(val,cnm);				


jt1  = new JTable(d2);
jt1.setBackground(Color.black);
jt1.setForeground(Color.white);
jt1.setOpaque(false);
jt1.setBounds(210,206,800,470);
jt1.setEnabled(false);

int v1 = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h1 = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
jsp1 = new JScrollPane(jt1,v,h);
jsp1.setBounds(209,205,801,471);
jsp.setBackground(Color.black);

jp4.add(jsp1);
jp4.add(a4);


//====================================================
//==================back button======================
b4 = new JButton("BACK");
b4.setBounds(20,220,100,30);
b4.addActionListener(this);
b4.setVisible(false);


add(b4);
add(jp1);
add(jp2);
add(jp3);
add(jp4);
add(a);
}

public void actionPerformed(ActionEvent ae)
{
String s = ae.getActionCommand();
if(s=="PROFILE")
{
jp1.setVisible(false);
jp2.setVisible(true);
b4.setVisible(true);
}
if(s=="USER DETAILS")
{
jp1.setVisible(false);
jp3.setVisible(true);
b4.setVisible(true);
}
if(s=="PACKAGE DETAILS")
{
jp1.setVisible(false);
jp4.setVisible(true);
b4.setVisible(true);
}
if(s=="BACK")
{

	if(jp2.isVisible())
	{
	jp2.setVisible(false);
	jp1.setVisible(true);
	b4.setVisible(false); 
	}
	if(jp3.isVisible())
	{
	jp3.setVisible(false);
	jp1.setVisible(true);
	b4.setVisible(false); 
	}
	if(jp4.isVisible())
	{
	jp4.setVisible(false);
	jp1.setVisible(true);
	b4.setVisible(false); 
	}
	
}


}

public void adlog()
{
l.setVisible(true);
setdata();
}


public void setdata()
{

Connection c;
Statement st;
ResultSet rs;
String que;
String[] ob1=new String[5];
String s1,s2,s3,s4,s5,s6;
int iiii=0;

try{

Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
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




ob[0]=s1+" "+s6;
ob[1]=s2;
ob[2]=s3;
ob[3]=s4;
ob[4]=s5;

d1.insertRow(iiii,ob);
iiii++;
}
  
rs.close();
st.close();
c.close();
}

catch(Exception e)
{

System.out.println("exception in invoice...........");
System.out.println(e);
}

setdata2();

}

void setdata2()
{

Connection c;
Statement st;
ResultSet rs;
String que;
String[] ob1=new String[5];
String rid,s1,s2,s3="",s4,s5,s6;
int iiii=0;

try{

Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();
que="select * from travelpackage";
rs = st.executeQuery(que);



while(rs.next())
{
s1=rs.getString("pname");
s2=rs.getString("discription");
rid=rs.getString("region_id");
s4=rs.getString("availseats");
s5=rs.getString("cost");



if(rid.equals("1")){s3="North";}
else if(rid.equals("2")){s3="West";}
else if(rid.equals("3")){s3="South";}
else if(rid.equals("4")){s3="East";}


ob2[0]=s1;
ob2[1]=s2;
ob2[2]=s3;
ob2[3]=s4;
ob2[4]=s5;

d2.insertRow(iiii,ob2);
iiii++;
}
  
rs.close();
st.close();
c.close();
}

catch(Exception e)
{

System.out.println("exception in admin fetch...........");
System.out.println(e);
}


}

public void itemStateChanged(ItemEvent ie)
{
/*
int n= jcb.getSelectedIndex();
if(n==0)
sort by username
else if(n==1)
sort by package name
*/
}



}

