//package panels;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.sql.*;

// later to be changed to file2

public class profile  extends JPanel implements ActionListener 

{

//public :
   String uname; 
   tour t; 
  JCheckBox cb1,cb2,cb3,cb4;
  JButton b1,b2;
  JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
  JLabel le1,le2,le3,le4,le5,le6,le7,le8,le9,le10,l11,l12,l13,l14;
  JLabel la[]=new JLabel[10];
  JLabel la2[]=new JLabel[10];
 JButton b[]= new JButton[10];
 
  Font f1,f2,f3,f4;
  JLabel a;
  JButton back;
  JScrollPane jsp1;
  JPanel jp1;
  //boolean n,s,e,w;


public profile(tour tr,JButton back)
{
//super(s);


setLayout(null);
setBounds(0,0,1280,1024);
 t=tr;
 this.back=back;
a = new JLabel(new ImageIcon("C:\\project\\images\\profile.png"));
a.setBounds(00,00,1280,1024);


f1 = new Font("Arial",Font.PLAIN,18);
f2 = new Font("Arial",Font.PLAIN,20);
f3 = new Font("Arial",Font.PLAIN,12);
f4 = new Font("Arial",Font.PLAIN,16);


b1=new JButton("Proceed..");
b1.setBounds(1010,550,150,30);
b1.setFont(f1);
b1.setForeground(Color.black);
b1.addActionListener(this);


//-------------------------------memories---------------------

jp1 = new JPanel();
jp1.setLayout(null);
jp1.setBorder(null);
jp1.setLocation(0,0);
//jp1.setOpaque(false);
jp1.setBackground(Color.black);
jp1.setPreferredSize(new Dimension(300,370)); //this size is irrelevant as it will be set again...saumil



for(int i =1; i < 10;i++)
 {
 b[i] = new JButton();
 b[i].addActionListener(this);
 jp1.add(b[i]);
 }

 

 for(int i =1; i < 10;i++)
 {
 la[i] = new JLabel();
 la[i].setBounds(130,((i-1)*110)+20,150,30); 
 la[i].setFont(f4);
 la[i].setForeground(Color.white);
 jp1.add(la[i]);
 
 la2[i] = new JLabel();
 la2[i].setBounds(130,((i-1)*110)+50,150,30); 
 la2[i].setFont(f4);
 la2[i].setForeground(Color.white);
 jp1.add(la2[i]);
 }

 
int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
jsp1= new JScrollPane(jp1,v,h);
jsp1.setBounds(30, 270, 310, 380);
add(jsp1, BorderLayout.CENTER);


//---------------------------------------------------panel 1 oVER-----------

// username--------------------------------------------------
l1 =new JLabel("Username:",JLabel.RIGHT);
l1.setBounds(320,280,200,30);
l1.setForeground(Color.white);
l1.setFont(f2);

le1 =new JLabel();
le1.setBounds(540,280,200,30);
le1.setForeground(Color.white);
le1.setFont(f2);


//first name-------------------------------------------------------------

l3 =new JLabel("First Name:",JLabel.RIGHT);
l3.setBounds(320,320,200,30);
l3.setForeground(Color.white);
l3.setFont(f2);

le3 =new JLabel();
le3.setBounds(540,320,200,30);
le3.setForeground(Color.white);
le3.setFont(f2);

//last name-----------------------------------------------------

l4 =new JLabel("Last Name:",JLabel.RIGHT);
l4.setBounds(320,360,200,30);
l4.setForeground(Color.white);
l4.setFont(f2);

le4 =new JLabel();
le4.setBounds(540,360,200,30);
le4.setForeground(Color.white);
le4.setFont(f2);

//birth date-----------------------------------------------------

l5 =new JLabel("Birth Date:",JLabel.RIGHT);
l5.setBounds(320,400,200,30);
l5.setForeground(Color.white);
l5.setFont(f2);

le5 =new JLabel();
le5.setBounds(540,400,400,30);
le5.setForeground(Color.white);
le5.setFont(f2);

//Gender----------------------------------------------------------

l6 =new JLabel("Gender:",JLabel.RIGHT);
l6.setBounds(320,440,200,30);
l6.setForeground(Color.white);
l6.setFont(f2);

le6 =new JLabel();
le6.setBounds(540,440,200,30);
le6.setForeground(Color.white);
le6.setFont(f2);


//address-----------------------------------------------------

l7 =new JLabel("Address:",JLabel.RIGHT);
l7.setBounds(320,480,200,30);
l7.setForeground(Color.white);
l7.setFont(f2);

le7 =new JLabel();
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

le9 =new JLabel();
le9.setBounds(540,560,200,30);
le9.setForeground(Color.white);
le9.setFont(f2);


//e mail -----------------------------------------------------

l10 =new JLabel("E-mail ID:",JLabel.RIGHT);
l10.setBounds(320,600,200,30);
l10.setForeground(Color.white);
l10.setFont(f2);

le10 =new JLabel();
le10.setBounds(540,600,400,30);
le10.setForeground(Color.white);
le10.setFont(f2);



 


//---north south east west check boxes-----------------
cb1 = new JCheckBox("NORTH" );
cb1.setBounds(1040,360,100,30);
cb1.setBackground(Color.black);
cb1.setForeground(Color.white);
cb1.setBorder(null);
//cb1.setSelected(true);
cb1.setFont(f1);
cb1.setOpaque(false);


cb2 = new JCheckBox("WEST" );
cb2.setBounds(1040,400,100,30);
cb2.setBackground(Color.black);
cb2.setForeground(Color.white);
cb2.setBorder(null);
cb2.setFont(f1);
cb2.setOpaque(false);

cb3 = new JCheckBox("SOUTH" );
cb3.setBounds(1040,440,100,30);
cb3.setBackground(Color.black);
cb3.setForeground(Color.white);
cb3.setBorder(null);
cb3.setFont(f1);
cb3.setOpaque(false);

cb4 = new JCheckBox("EAST" );
cb4.setBounds(1040,480,100,30);
cb4.setBackground(Color.black);
cb4.setForeground(Color.white);
cb4.setBorder(null);
cb4.setFont(f4);
cb4.setOpaque(false);

//heading for north -south-east-west -----------------
l11 =new JLabel("Select The Region",JLabel.CENTER);
l11.setBounds(987,290,200,20);
l11.setForeground(Color.white);
l11.setFont(f4);

l12 =new JLabel("Where you wish to",JLabel.CENTER);
l12.setBounds(990,310,200,20);
l12.setForeground(Color.white);
l12.setFont(f4);

l13 =new JLabel("spend your HOLIDAYS",JLabel.CENTER);
l13.setBounds(990,330,200,20);
l13.setForeground(Color.white);
l13.setFont(f4);




 add(b1);


 add(l1);
 add(l3);
 add(l4);
 add(l5);
 add(l6);
 add(l7);
 add(l8);
 add(l9);
 add(l10);
 add(l11);
 add(l12);
 add(l13);


 add(le1);
 add(le3);
 add(le4);
 add(le5);
 add(le6);
 add(le7);
 add(le8);
 add(le9);
 add(le10);

 add(cb1);
 add(cb2);
 add(cb3);
 add(cb4);
 
 add(a);  //  ani pachi kashu mukvu nahi.............
 
 
}

 public void actionPerformed(ActionEvent ae)
{
boolean n,w,s,e;
String ss= ae.getActionCommand();


if(ss=="Proceed.." )
{
n=cb1.isSelected();
w=cb2.isSelected();
s=cb3.isSelected();
e=cb4.isSelected();
         if (n || w || s || e)
		{
		setVisible(false);
		cb1.setSelected(false);
        cb2.setSelected(false);
        cb3.setSelected(false);
        cb4.setSelected(false);
		
		t.lp1.setVisible(false);
		t.lp2.setVisible(false);
        t.insruct.setVisible(true);
		
		t.loadicon(uname,n,w,s,e);
		back.setVisible(true);
		t.setVisible(true);
		}
}

else
{
setVisible(false);
t.lp1.setVisible(true);
t.lp2.setVisible(true);
t.insruct.setVisible(false);
t.getdata(ss);
back.setVisible(true);
t.setVisible(true);
}

}




void redirect(JButton j,String uname)
{
j.setVisible(true);
this.uname=uname;

Connection c;
Statement st;
ResultSet rs;
String que;

try{

Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();

que="select * from user1 where uname='"+uname+"'";
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

 
le1.setText(uname);
le3.setText(rs.getString("fname"));
le4.setText(rs.getString("lname"));
le5.setText(mp);
le6.setText(gn2);
le7.setText(rs.getString("addr"));
le9.setText(rs.getString("phno"));
le10.setText(rs.getString("email"));
}
  
rs.close();
st.close();
c.close();
}

catch(Exception e)
{
System.out.println("exception profile...");
System.out.println(e);
}

getmemories();
}



void getmemories()
{
int i=0;

 Connection c;
Statement st;
ResultSet rs;
String que,sp,sd,iconfile,pckid;



try{

Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();

que=" select distinct(t.pid) , pname,discription ,iconimage from travelpackage t, family f  where t.pid=f.pid and   uname='"+uname+"'";
rs = st.executeQuery(que);


while(rs.next())
{
i++;

pckid =rs.getString(1);
sp=rs.getString(2);
sd=rs.getString(3);
iconfile=rs.getString(4);
//fetch image file and label and show here ......
//b.setLabel(new ImageIcon(ss2));
//------------------------------------------the above statement should be executed somehow...

if (i>3)
{
jp1.setPreferredSize(new Dimension(300,20+(110*i)));
}


la[i].setText(sp);
la2[i].setText(sd);


b[i].setIcon(new ImageIcon(iconfile));


b[i].setBounds(20,((i-1)*110)+5,100,100);
b[i].setActionCommand(pckid);
b[i].setVisible(true);


}
  
rs.close();
st.close();
c.close();
}

catch(Exception e)
{
System.out.println("exception in profile memories...........");
System.out.println(e);
}


}




void cleardata()
{
        cb1.setSelected(false);
        cb2.setSelected(false);
        cb3.setSelected(false);
        cb4.setSelected(false);

		

for(int i=1;i<10;i++)
{
la[i].setText("");
la2[i].setText("");
b[i].setVisible(false);
}


jp1.setPreferredSize(new Dimension(300,370));
	
}




}



