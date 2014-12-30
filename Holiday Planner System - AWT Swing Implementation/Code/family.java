import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.*;


public class family extends JPanel implements ActionListener,ItemListener, Runnable
{
JButton b1,b2 ;
JPanel head;
Font f1,f2,f3;
JTextField tf1,tf3,ta1,ta2;
int nn;
JLabel a,l1,l2,l3,l4,la1,la2,la3,la4,lftitle,l111;
JPanel jp1,jp2,jp3;
JLabel le1,le2,le3,le4;
JLabel lf[]= new JLabel[100];

JComboBox jcb1,jcb2,jcb3,jcb4;
JRadioButton jrb1,jrb2;
Thread t;
ButtonGroup bg;
int cnt,c=0;
String d,m,y,uname,packageid,rid,source;

String[] det = new String[100];
int f,fc,dd,mm,yy;

invoice in;

family(invoice io)
{

setLayout(null);
setBounds(0,0,1280,1024);


//----------------------------initializatiom of var
in=io;
cnt=1;c=1;
//-------------------------


a = new JLabel(new ImageIcon("C:\\project\\images\\family.png"));
a.setBounds(00,00,1280,1024);

f1 =new Font("Arial",Font.PLAIN,18);
f2 =new Font("Arial",Font.PLAIN,20);
f3 =new Font("Arial",Font.PLAIN,12);

/* head = new JPanel();
head.setBounds(0,0,1280,100);
head.setBackground(Color.white);
add(head); */


//---------first panel for number of family members and current location-----------
jp1 = new JPanel();
jp1.setLayout(null);
jp1.setBounds(1,101,300,1000);
jp1.setBorder(null); 
jp1.setOpaque(false);


//-----second panel for family member details---------
jp2 = new JPanel();
jp2.setLayout(null);
jp2.setBounds(301,101,700,1000);
jp2.setBorder(null);
jp2.setOpaque(false);

//-----third panel for displaying jst name of family members entered -----------------------
jp3 = new JPanel();
jp3.setLayout(null);
jp3.setBounds(1001,101,1280,1000);
jp3.setBorder(null);
jp3.setOpaque(false);





//====================================panel 2 components=======================================

//---first name-------------
la1 =new JLabel("First Name:",JLabel.RIGHT);
la1.setBounds(110,200,200,30);
la1.setForeground(Color.white);
la1.setFont(f2);

ta1 = new JTextField();
ta1.setBorder(null);
ta1.setBounds(320,200,180,30);
ta1.setForeground(Color.white);
ta1.setOpaque(false);
ta1.setEditable(false);
//ta1.setBorder(null);
ta1.setFont(f1);

le1=new JLabel();
le1.setBounds(530,200,300,30);
le1.setForeground(Color.white);
le1.setFont(f3);

//=---------last name------------------
la2 =new JLabel("Last Name:",JLabel.RIGHT);
la2.setBounds(110,250,200,30);
la2.setForeground(Color.white);
la2.setFont(f2);


ta2 = new JTextField();
ta2.setBorder(null);
ta2.setBounds(320,250,180,30);
ta2.setForeground(Color.white);
ta2.setOpaque(false);
ta2.setEditable(false);
//ta2.setBorder(null);
ta2.setFont(f1);

le2=new JLabel();
le2.setBounds(530,250,300,30);
le2.setForeground(Color.white);
le2.setFont(f3);

//----DOB------------------------------
la3 =new JLabel("Birth Date:",JLabel.RIGHT);
la3.setBounds(110,300,200,30);
la3.setForeground(Color.white);
la3.setFont(f2);

jcb1= new JComboBox();
jcb1.addItem(" - -");
for(int i=1;i<32;i++)
jcb1.addItem(""+i);
jcb1.setBounds(320,300,50,30);
jcb1.setBackground(Color.black);
jcb1.setForeground(Color.white);
jcb1.setFont(f1);


jcb2= new JComboBox();
jcb2.addItem(" - -");
for(int i=1;i<13;i++)
jcb2.addItem(""+i);
jcb2.setBounds(375,300,50,30);
jcb2.setBackground(Color.black);
jcb2.setForeground(Color.white);
jcb2.setFont(f1);

jcb3= new JComboBox();
jcb3.addItem("- - - -");
for(int i=1950;i<2012;i++)
jcb3.addItem(""+i);
jcb3.setBounds(430,300,70,30);
jcb3.setBackground(Color.black);
jcb3.setForeground(Color.white);
jcb3.setFont(f1);

le3=new JLabel();
le3.setBounds(530,300,300,30);
le3.setForeground(Color.white);
le3.setFont(f3);

//-----------gender----------------
la4 =new JLabel("Gender:" ,JLabel.RIGHT);
la4.setBounds(110,350,200,30);
la4.setForeground(Color.white);
la4.setFont(f2);

//radio Button
jrb1 =new JRadioButton("Male",true);
jrb1.setBounds(320,350,80,30);
//jrb1.setBackground(Color.black);
jrb1.setForeground(Color.white);
jrb1.setOpaque(false);
jrb1.setFont(f1);

jrb2 =new JRadioButton("Female");
jrb2.setBounds(420,350,90,30);
//jrb2.setBackground(Color.black);
jrb2.setForeground(Color.white);
jrb2.setOpaque(false);
jrb2.setFont(f1);

bg = new ButtonGroup();
bg.add(jrb1);
bg.add(jrb2);

//--------------next button-----------
b2 = new JButton("Enter Next Member Details");
b2.setBounds(200 ,400 , 300 ,30);
b2.addActionListener(this);
b2.setEnabled(false);

le4=new JLabel("*Member Entered Successfully");
le4.setBounds(200,450,300,30);
le4.setForeground(Color.white);
le4.setVisible(false);
le4.setFont(f3);

jp2.add(b2);
jp2.add(ta1);
jp2.add(la1);
jp2.add(ta2);
jp2.add(la2);
jp2.add(jcb1);
jp2.add(jcb2);
jp2.add(jcb3);
jp2.add(jrb1);
jp2.add(jrb2);
jp2.add(la3);
jp2.add(la4);
jp2.add(le1);
jp2.add(le2);
jp2.add(le3);
jp2.add(le4);

//====================================panel 3 components=======================================

lftitle = new JLabel("Members entered :");
lftitle.setBounds(30,200,280,30);
lftitle.setForeground(Color.white);
lftitle.setFont(f2);
jp3.add(lftitle);


for (int i=0;i<10;i++)
{
lf[i] = new JLabel();
lf[i].setBounds(30,240+i*30,240,30);
lf[i].setForeground(Color.white);
lf[i].setFont(f1);
jp3.add(lf[i]);
}



//====================================panel 1 components=======================================

l111 = new JLabel("**not valid number",JLabel.CENTER);
l111.setBounds(0,300,300,30);
l111.setForeground(Color.white);
l111.setFont(f3);
l111.setVisible(false);
jp1.add(l111);




l1 = new JLabel("Number of Members :",JLabel.CENTER);
l1.setBounds(0,200,300,30);
l1.setForeground(Color.white);
l1.setFont(f2);
jp1.add(l1);


tf1 = new JTextField();
tf1.setBounds(140,240,25,30);
tf1.setBorder(null);
tf1.setForeground(Color.white);
tf1.setOpaque(false);
tf1.setFont(f2);
jp1.add(tf1);




l2 = new JLabel("Current Location : ",JLabel.CENTER);
l2.setBounds(0,330,300,30);
l2.setForeground(Color.white);
l2.setFont(f2);
jp1.add(l2);


jcb4= new JComboBox();
jcb4.addItem("   - - - - - - - - - - - - -");

// put an array of locations
jcb4.addItem("Agartala");
jcb4.addItem("Ahmedabad");
jcb4.addItem("Aizawal");
jcb4.addItem("Bengaluru");
jcb4.addItem("Bhopal");
jcb4.addItem("Bhuvaneshwar");
jcb4.addItem("Chandigarh");
jcb4.addItem("Chennai");
jcb4.addItem("Dehradun");
jcb4.addItem("Delhi");
jcb4.addItem("Gangtok");
jcb4.addItem("Hyderabad");
jcb4.addItem("Imphal");
jcb4.addItem("Itanagar");
jcb4.addItem("Jaipur");
jcb4.addItem("Kohima");
jcb4.addItem("Kolkata");
jcb4.addItem("Lucknow");
jcb4.addItem("Mumbai");
jcb4.addItem("Panaji");
jcb4.addItem("Patna");
jcb4.addItem("Ranchi");
jcb4.addItem("Shillong");
jcb4.addItem("Shimla");
jcb4.addItem("Srinagar");
jcb4.addItem("Trivandrum");
jcb4.setBounds(50,370,200,30);
jcb4.setFont(f1);
jcb4.setSelectedIndex(0);
jcb4.setForeground(Color.white);
jcb4.setBackground(Color.black);
jp1.add(jcb4);


b1 = new JButton("Submit");
b1.setBounds(90 ,420 , 120 ,30);
b1.addActionListener(this);
jp1.add(b1);


//---------------------------------------------------------------------------------------

jcb1.addItemListener(this);
jcb2.addItemListener(this);
jcb3.addItemListener(this); 
jcb4.addItemListener(this);  


add(jp1);
add(jp2);
add(jp3);
add(a);

}

public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();

 if(s.equals("Enter Next Member Details"))
{
le1.setText("");
le2.setText("");
le3.setText("");
mainchk(f);
}

else if(s=="Finish")
{
 f=1;
le1.setText("");
le2.setText("");
le3.setText("");
mainchk(f);
}
else if(s=="Submit")
{
l111.setVisible(false);
textchk();}


}


public  void itemStateChanged(ItemEvent ie)
{
d=jcb1.getSelectedItem().toString();
m=jcb2.getSelectedItem().toString();
y=jcb3.getSelectedItem().toString();
//str=jcb4.getSelectedItem().toString();
}
 


//----------------check for panel 1----------------------------------------------
void textchk()
{
boolean m,n,o;
m=n=o=true;

String x = tf1.getText();


if(x.length() == 0)
m=false;

if(jcb4.getSelectedIndex()==0 )
o=false;

if(m  && o)
{
try
{
cnt = Integer.parseInt(tf1.getText()) ;

if(cnt==0)
{
throw new Exception();
}

t=new Thread(this,"seatentry");
t.start();


source =""+ jcb4.getSelectedItem();
System.out.println("mmmmmmmmmmmmmmmmmmmmmmmm       "+source);


b2.setEnabled(true);
b1.setEnabled(false);
tf1.setEditable(false);

ta1.setEditable(true);
ta2.setEditable(true);
jcb4.setEnabled(false);

if(cnt==1)
{b2.setLabel("Finish");}


countfamily();

}

catch(Exception e)
{
System.out.println("exception in no of members...");
System.out.println(e);
l111.setVisible(true);

}
}

}


public void run()
{
Connection c;
Statement st;
String que;

try{
Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();
que="update selects set noofseats ="+tf1.getText()+"where uname='"+uname+"' and pid='"+packageid+"'";
st.executeQuery(que);

que="update selects set source = '"+jcb4.getSelectedItem()+"' where uname='"+uname+"' and pid='"+packageid+"'";
st.executeQuery(que);

que="update travelpackage set availseats = availseats - "+tf1.getText()+" where pid='"+packageid+"'";
st.executeQuery(que);

st.close();
c.close();
}

catch(Exception e)
{

System.out.println("exception in family seatno...........");
System.out.println(e);
}

}


void countfamily()
{
Connection c;
Statement st;
ResultSet rs;
String que;

try{
Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();
que="select count(*) from family where uname='"+uname+"'";
rs = st.executeQuery(que);



while(rs.next())
{
fc=rs.getInt(1);
}
  
rs.close();
st.close();
c.close();
}

catch(Exception e)
{

System.out.println("exception in family count...........");
System.out.println(e);
}


}

//=============check for panel 2========================================================

void mainchk(int v)
{

boolean p=fnamechk();
boolean q=lnamechk();
boolean r=dtchk();

if(!p)
{//fname fields
//ta1.setText("");
le1.setText("*not entered ");
le4.setVisible(false);
}

if(!q)
{//lname fields
//ta2.setText("");
le2.setText("*not entered ");
le4.setVisible(false);
}


if(!r)
{//date 
jcb1.setSelectedIndex(0);
jcb2.setSelectedIndex(0);
jcb3.setSelectedIndex(0);
le3.setText("*invalid date ");
le4.setVisible(false);
} 

if(p && q && r)
{
if(v==0)
{
if(c==cnt-1)
    { 
     b2.setLabel("Finish");
	}
   


//add in database--------------------------------

dataentry();
lf[nn].setText(ta1.getText() +" "+ta2.getText());
nn++;

//------------------------------------------------

c++;
ta1.setText("");
ta2.setText("");
jcb1.setSelectedIndex(0);
jcb2.setSelectedIndex(0);
jcb3.setSelectedIndex(0);

le4.setVisible(true);

}

else
{

//add in database
dataentry();

cleardata();
//create or redirect to next frame.............................
setVisible(false);
b2.setEnabled(false);
in.setdata(uname,packageid,rid,source);
in.setVisible(true);
}

}

}




//first name 
boolean fnamechk()
{
//System.out.println("fname");
String b=ta1.getText();
if(b.length()==0)
return false;
else
return true;

}

//last name
boolean lnamechk()
{
//System.out.println("lname");
String b=ta2.getText();
if(b.length()==0 )
return false;
else
return true;

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


void transfer(String u,String p,String r)
{uname=u;packageid=p;rid=r;}

void dataentry()
{
fc++;
String fid="f"+fc;
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

//packageid="p001"; //to be removed later......

Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=con.createStatement();
que="insert into family values('"+fid+"','"+uname+"','"+ta1.getText()+" "+ta2.getText()+"','"+cc+"','"+dd+"-"+months[mm]+"-"+yy+"','"+packageid+"',0)";

//System.out.println(que);

st.executeQuery(que);
  
st.close();
con.close();
}

catch(Exception eee)
{
System.out.println("exception in family data entry...");
System.out.println(eee);
}


}



void cleardata()
{
c=1;
ta1.setText("");
ta2.setText("");
ta1.setEditable(false);
ta2.setEditable(false);

jcb1.setSelectedIndex(0);
jcb2.setSelectedIndex(0);
jcb3.setSelectedIndex(0);

tf1.setText("");

tf1.setEditable(true);

jcb4.setSelectedIndex(0);
jcb4.setEnabled(true);

for (int i=0;i<10;i++)
{
lf[i].setText("");
}

b2.setLabel("Enter Next Member Details");
b2.setEnabled(false);
b1.setEnabled(true);

le4.setVisible(false);  //member entered successfully thing

}



}


