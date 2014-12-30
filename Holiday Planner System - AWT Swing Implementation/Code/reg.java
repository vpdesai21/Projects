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

public class reg  extends JDialog implements ActionListener , ItemListener, KeyListener
{

//public:
  //home hm;
  JTextArea jta;
  ButtonGroup bg;
  JComboBox jcb1,jcb2,jcb3;
  JButton b1;
  JButton b2;
  JPanel p1,p2;
  JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
  JLabel le1,le2,le3,le4,le5,le6,le7,le8,le9,le10;
  Font f1,f2,f3;
  JTextField tf1,tf2,tf3,tf4,tf5,tf6;
  JPasswordField jp1,jp2;
  JLabel a;
  JRadioButton jrb1,jrb2;
  String d,m,y;
  int dd,mm,yy;
  JPanel head;
  String pass;// to store password
  
  
public reg(JFrame parent)
{
super(parent,"Registration",true);
setLayout(null);

setMinimumSize(new Dimension(650,550));

a = new JLabel(new ImageIcon("C:\\project\\images\\reg1.png"));
a.setBounds(00,00,650,550);

f1 =new Font("Arial",Font.PLAIN,18);
f2 =new Font("Arial",Font.PLAIN,20);
f3 =new Font("Arial",Font.PLAIN,12);





b1=new JButton("Go..");
b1.setBounds(200,470,100,30);
b1.setFont(f1);
b1.addActionListener(this);

// username--------------------------------------------------
l1 =new JLabel("Username:",JLabel.RIGHT);
l1.setBounds(30,50,200,30);
l1.setForeground(Color.white);
l1.setFont(f2);


tf1= new JTextField();
tf1.setBorder(null);
tf1.setBounds(260,50,180,30);
tf1.setForeground(Color.white);
tf1.setOpaque(false);
tf1.setFont(f1);
tf1.addKeyListener(this);

le1 = new JLabel();
le1.setBounds(470,50,300,30);
le1.setForeground(Color.white);
le1.setFont(f3);

//password-----------------------------------------------------------

l2 =new JLabel("Enter Password:",JLabel.RIGHT);
l2.setBounds(30,90,200,30);
l2.setForeground(Color.white);
l2.setFont(f2);

jp1= new JPasswordField();
jp1.setBorder(null);
jp1.setBounds(260,90,180,30);
jp1.setForeground(Color.white);
jp1.setFont(f1);
jp1.setOpaque(false);

le2=new JLabel();
le2.setBounds(470,90,300,30);
le2.setForeground(Color.white);
le2.setFont(f3);

//password-------------------------------------------------------------

l3 =new JLabel("Confirm Password:",JLabel.RIGHT);
l3.setBounds(30,130,200,30);
l3.setForeground(Color.white);
l3.setFont(f2);

jp2= new JPasswordField();
jp2.setBorder(null);
jp2.setBounds(260,130,180,30);
jp2.setForeground(Color.white);
jp2.setFont(f1);
jp2.setOpaque(false);
jp2.addKeyListener(this);

le3=new JLabel();
le3.setBounds(340,130,300,30);
le3.setForeground(Color.white);
le3.setFont(f3);

//first name-----------------------------------------------------

l4 =new JLabel("First Name:",JLabel.RIGHT);
l4.setBounds(30,170,200,30);
l4.setForeground(Color.white);
l4.setFont(f2);

tf2= new JTextField();
tf2.setBorder(null);
tf2.setBounds(260,170,180,30);
tf2.setForeground(Color.white);
tf2.setFont(f1);
tf2.setOpaque(false);
tf2.addKeyListener(this);

le4=new JLabel();
le4.setBounds(470,170,300,30);
le4.setForeground(Color.white);
le4.setFont(f3);


//last name-----------------------------------------------------

l5 =new JLabel("Last Name:",JLabel.RIGHT);
l5.setBounds(30,210,200,30);
l5.setForeground(Color.white);
l5.setFont(f2);

tf3= new JTextField();
tf3.setBorder(null);
tf3.setBounds(260,210,180,30);
tf3.setForeground(Color.white);
tf3.setFont(f1);
tf3.setOpaque(false);
tf3.addKeyListener(this);

le5=new JLabel();
le5.setBounds(470,210,300,30);
le5.setForeground(Color.white);
le5.setFont(f3);

//birth date----------------------------------------------------------

l6 =new JLabel("Birth Date:",JLabel.RIGHT);
l6.setBounds(30,250,200,30);
l6.setForeground(Color.white);
l6.setFont(f2);

// choice
jcb1= new JComboBox();
jcb1.addItem(" - -");
for(int i=1;i<32;i++)
jcb1.addItem(""+i);
jcb1.setBorder(null);
jcb1.setBounds(260,250,50,30);
jcb1.setForeground(Color.white);
jcb1.setBackground(Color.black);
//jcb1.setOpaque(false);

jcb2= new JComboBox();
jcb2.addItem(" - -");
for(int i=1;i<13;i++)
jcb2.addItem(""+i);
jcb2.setBorder(null);
jcb2.setBounds(315,250,50,30);
jcb2.setForeground(Color.white);
jcb2.setBackground(Color.black);
//jcb2.setOpaque(false);

jcb3= new JComboBox();
jcb3.addItem(" - - - -");
for(int i=1950;i<2012;i++)
jcb3.addItem(""+i);
jcb3.setBorder(null);
jcb3.setBounds(370,250,70,30);
jcb3.setForeground(Color.white);
jcb3.setBackground(Color.black);
//jcb3.setOpaque(false);

jcb1.setFont(f1);
jcb2.setFont(f1);
jcb3.setFont(f1);

le6=new JLabel();
le6.setBounds(470,250,300,30);
le6.setForeground(Color.white);
le6.setFont(f3);



//Gender-----------------------------------------------------

l7 =new JLabel("Gender:",JLabel.RIGHT);
l7.setBounds(30,290,200,30);
l7.setForeground(Color.white);
l7.setFont(f2);

//radio Button
jrb1 =new JRadioButton("Male",true);
jrb1.setBounds(260,290,80,30);
//jrb1.setBackground(Color.black);
jrb1.setForeground(Color.white);
jrb1.setFont(f1);
jrb1.setOpaque(false);


jrb2 =new JRadioButton("Female");
jrb2.setBounds(350,290,90,30);
//jrb2.setBackground(Color.black);
jrb2.setForeground(Color.white);
jrb2.setFont(f1);
jrb2.setOpaque(false);

bg = new ButtonGroup();

le7=new JLabel();
le7.setBounds(470,290,300,30);
le7.setForeground(Color.white);
le7.setFont(f3);


//address-------------------------------------------

l8 =new JLabel("Address:",JLabel.RIGHT);
l8.setBounds(30,330,200,30);
l8.setForeground(Color.white);
l8.setFont(f2);

tf4= new JTextField();
tf4.setBorder(null);
tf4.setBounds(260,330,180,30);
tf4.setForeground(Color.white);
tf4.setFont(f1);
tf4.setOpaque(false);
tf4.addKeyListener(this);

le8=new JLabel();
le8.setBounds(470,330,300,30);
le8.setForeground(Color.white);
le8.setFont(f3);

//phone -------------------------------------------------

l9 =new JLabel("Phone number:",JLabel.RIGHT);
l9.setBounds(30,370,200,30);
l9.setForeground(Color.white);
l9.setFont(f2);

tf5= new JTextField();
tf5.setBorder(null);
tf5.setBounds(260,370,180,30);
tf5.setForeground(Color.white);
tf5.setFont(f1);
tf5.setOpaque(false);
tf5.addKeyListener(this);

le9=new JLabel();
le9.setBounds(470,370,300,30);
le9.setForeground(Color.white);
le9.setFont(f3);


//e mail -----------------------------------------------------

l10 =new JLabel("E-mail ID:",JLabel.RIGHT);
l10.setBounds(30,410,200,30);
l10.setForeground(Color.white);
l10.setFont(f2);

tf6= new JTextField();
tf6.setBorder(null);
tf6.setBounds(260,410,180,30);
tf6.setForeground(Color.white);
tf6.setFont(f1);
tf6.setOpaque(false);
tf6.addKeyListener(this);

le10=new JLabel();
le10.setBounds(470,410,300,30);
le10.setForeground(Color.white);
le10.setFont(f3);


//-------------------------------------------------
add(b1);

add(jp1);
add(jp2);
 
add(tf1);
add(tf2);
add(tf3);
add(tf4);
add(tf5);
add(tf6);


add(jcb1);
add(jcb2);
add(jcb3);

bg.add(jrb1);
bg.add(jrb2);
add(jrb1);
add(jrb2);

 add(l1);
 add(l2);
 add(l3);
 add(l4);
 add(l5);
 add(l6);
 add(l7);
 add(l8);
 add(l9);
 add(l10);
 



 add(le1);
 add(le2);
 add(le3);
 add(le4);
 add(le5);
 add(le6);
 add(le7);
 add(le8);
 add(le9);
 add(le10);

 
  add(a);
jcb1.addItemListener(this);
jcb2.addItemListener(this);
jcb3.addItemListener(this);
 


addWindowListener( new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
tf1.setText("");
jp1.setText("");
jp2.setText("");
tf2.setText("");
tf3.setText("");
tf4.setText("");
tf5.setText("");
tf6.setText("");
jcb1.setSelectedIndex(0);
jcb2.setSelectedIndex(0);
jcb3.setSelectedIndex(0);
le1.setText("");
le2.setText("");
le3.setText("");
le4.setText("");
le5.setText("");
le6.setText("");
le7.setText("");
le8.setText("");
le9.setText("");
le10.setText("");
dispose();
}
});


}

 public void actionPerformed(ActionEvent ae)
{
String ss= ae.getActionCommand();
le1.setText("");
le2.setText("");
le3.setText("");
le4.setText("");
le5.setText("");
le6.setText("");
le7.setText("");
le8.setText("");
le9.setText("");
le10.setText("");

if(ss=="Go..")
{
maincheck();
}

} 


public void keyReleased(KeyEvent ke)
{
}

public void keyPressed(KeyEvent ke)
{

}

public void keyTyped(KeyEvent ke)
{
if(ke.getKeyChar()=='\n')
{
le1.setText("");
le2.setText("");
le3.setText("");
le4.setText("");
le5.setText("");
le6.setText("");
le7.setText("");
le8.setText("");
le9.setText("");
le10.setText("");
maincheck();}
}


 public void itemStateChanged(ItemEvent ie)
{
d=jcb1.getSelectedItem().toString();
m=jcb2.getSelectedItem().toString();
y=jcb3.getSelectedItem().toString();

//m=jcb2.getSelectedItem();
//y=jcb3.getSelectedItem();
}
 
 
//main check
void maincheck()
{
boolean a=availchk();
boolean b=passchk();
boolean c=dtchk();
boolean d=phnochk();
boolean e=fnamechk();
boolean f=lnamechk();
boolean g=addchk();
boolean h=mailchk();


if(!a)
{//username
jp1.setText("");
jp2.setText("");
tf1.setText("");
le1.setText("*not entered");
}

if(!b)
{//passwd
jp1.setText("");
jp2.setText("");

}

if(!c)
{//date 
jp1.setText("");
jp2.setText("");
jcb1.setSelectedIndex(0);
jcb2.setSelectedIndex(0);
jcb3.setSelectedIndex(0);

le6.setText("*invalid date ");
} 

if(!d)
{//phoneno
jp1.setText("");
jp2.setText("");
tf5.setText("");

le9.setText("*invalid phoneno");
}

if(!e)
{//fname fields
jp1.setText("");
jp2.setText("");

le4.setText("*not entered ");
}

if(!f)
{//lname fields
jp1.setText("");
jp2.setText("");

le5.setText("*not entered ");

}

if(!g)
{//addr fields
jp1.setText("");
jp2.setText("");
le8.setText("*not entered ");
}

if(!h)
{//mail addr fields
jp1.setText("");
jp2.setText("");
tf6.setText("");
le10.setText("*invalid email id ");

}

if ( a && b && c && d && e && f && g && h)
{
//------------------------enter in database
int flag=0;
String cc;
boolean gen;
gen=jrb1.isSelected();


if(gen){cc="m";}
else{cc="f";}

String[] months={"","jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
Connection con;
Statement st;

String que;
try{

Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=con.createStatement();
String un1=tf1.getText();
un1= un1.toLowerCase();

que="insert into user1 values('"+un1+"','"+pass+"','"+tf2.getText()+"','"+tf3.getText()+"','"+dd+"-"+months[mm]+"-"+yy+"','"+tf4.getText()+"',"+tf5.getText()+",'"+tf6.getText()+"','"+cc+"')";

st.executeQuery(que);

st.close();
con.close();
}

catch(Exception eee)
{
flag=1;
tf1.setText("");
jp1.setText("");
jp2.setText("");
le1.setText("*username not available");
System.out.println("exception in registration");
System.out.println(eee);
}
 
//------------dtabase entered----------------------------
if(flag==0)
{
tf1.setText("");
jp1.setText("");
jp2.setText("");
tf2.setText("");
tf3.setText("");
tf4.setText("");
tf5.setText("");
tf6.setText("");
jcb1.setSelectedIndex(0);
jcb2.setSelectedIndex(0);
jcb3.setSelectedIndex(0);
dispose();
}
//setVisible(false);
//hm.setVisible(true);

}



}


//date check
boolean dtchk()
{
//System.out.println("date");
if((jcb1.getSelectedIndex()==0) || (jcb2.getSelectedIndex()==0) || (jcb3.getSelectedIndex()==0))
return false;



dd=Integer.parseInt(d);
mm=Integer.parseInt(m);
yy=Integer.parseInt(y); 
 
 
if( (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8|| mm == 10|| mm == 12) && dd <32)
return true;
if( (mm == 4 || mm == 6 || mm == 9 || mm == 11) && dd <31)
return true;

if( yy%4 !=0 && dd < 29)
 return true;

 if( yy%4 == 0  && dd < 30)
{
	if(yy%100 ==0)
	{
	if(yy% 400 ==0 && dd<30)
	return true;
	if(yy% 400 !=0 && dd>28)
	return false;
	}
	
	return true;
}
else
return false;
}

//password check
boolean passchk()
{
//System.out.println("password");
char[] m=jp1.getPassword();
char[] n=jp2.getPassword();
String a=new String(m);
String b=new String(n);

//System.out.println("ss"+a+"ss");

if(a.length()==0 || b.length()==0)
{le2.setText("**Password not entered");
return false;}

if(a.equals(b))
{pass=a;
return true;}
else
{
le2.setText("**Password mismatch");
return false;
}

}

//phone no check
boolean phnochk()
{
//System.out.println("phone no");
String s=tf5.getText();


if(s.length()==0)
return false;
if(s.length()<=11)
return true;
else
return false;
}


//availability check
boolean availchk()
{
//System.out.println("uname");
String a=tf1.getText();
if(a.length()==0 )
return false;

// check in database ..

else
return true;
//------------data base check over
//return false;
}

//first name 
boolean fnamechk()
{
//System.out.println("fname");
String b=tf2.getText();
if(b.length()==0)
return false;
else
return true;

}

//last name
boolean lnamechk()
{
//System.out.println("lname");
String b=tf3.getText();
if(b.length()==0 )
return false;
else
return true;

}

//address 
boolean addchk()
{
//System.out.println("address");
String b=tf4.getText();
if(b.length()==0 )
return false;
else
return true;
}
//email id
boolean mailchk()
{
//System.out.println("email address");
String b=tf6.getText();
if(b.length()==0 )
return false;

boolean f=false;
boolean g=false;

for(int i=0;i<b.length();i++)
{
if(b.charAt(i)=='@')
{f=true;}
if(b.charAt(i)=='.')
{g=true;}
}


if (f && g)
return true;
else
return false;
}

}




