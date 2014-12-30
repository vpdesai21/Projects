//package panels;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.*;

public class tour extends JPanel implements ActionListener 
{
   int height;
  family f; 
  JButton b1,load,back ;
  Font f1,f2,f3,f4,f5,f6,f7;
  JLabel[][] data=new JLabel[10][100]; 
  JLabel[] la= new JLabel[21];
  JLabel[] la2= new JLabel[21];
  JLabel[] lab= new JLabel[21];
  JLabel[] imlab= new JLabel[10];
  JLabel[] loctitle= new JLabel[10];
  JLabel[] hottitle= new JLabel[10];
  JLabel[] locdays= new JLabel[10];
  JLabel insruct,lp1,lp2;
  JLabel a,lab1,loadlabel,insruct2,ltitle,lpname,availseats,maxseats,nod,minfo,lcost,lname,lid,lph; 
  JPanel jp1,jp2,jp3;
  JTextArea jta;
  JScrollPane jsp1,jsp2;
   
  // Container cn;
  int count ;
  int cnt;
  int im=0,NOC=0;
  JButton b[]= new JButton[21];
  String[] st;
  String str,temp,uname,packageid,pckid,rid;
  int n;
  
  
public tour(family fm, JButton back)
{

setLayout(null);
setBounds(0,0,1280,768);
  f=fm; 
this.back=back;
  
f1 =new Font("Arial",Font.PLAIN,18);
f2 =new Font("Arial",Font.PLAIN,20);
f3 =new Font("Arial",Font.PLAIN,12);
f4 =new Font("Arial",Font.PLAIN,15);
f5=new Font("Arial",Font.BOLD,40);
f6=new Font("Arial",Font.BOLD,25);
f7=new Font("Comic",Font.PLAIN,25);



a = new JLabel(new ImageIcon("C:\\project\\images\\tour.png"));
a.setBounds(00,00,1280,1024); 
 
 cnt =21;   //MAX no of packages
  
//cn = getContentPane();


 //--------------description of packages in panel1-------------

jp1 = new JPanel();
jp1.setLayout(null);
jp1.setBorder(null);
jp1.setLocation(0,195);
//jp1.setPreferredSize(new Dimension(300,500+(cnt-4)*110));
jp1.setBackground(Color.black);
jp1.setPreferredSize(new Dimension(300,500)); //this size is irrelevant as it will be set again...saumil



 for(int i =1; i < cnt;i++)
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
 
 //------------------------------------
 

for(int i =1; i < cnt;i++)
 {
 lab[i] = new JLabel(new ImageIcon("c:\\project\\images\\bg.png"));
 b[i] = new JButton();
 //b[i] = new JButton(new ImageIcon(""));
// b.setBounds(20,(i*110)+20,100,100); 
// b.setActionCommand(pid[i]);
 b[i].addActionListener(this);
 jp1.add(b[i]);
 jp1.add(lab[i]);
 }

// extra label for indicating old memories...........

lp1= new JLabel("Old",JLabel.CENTER);
lp1.setFont(f7);
lp1.setForeground(Color.white);
lp1.setBounds(0,200,300,40);
lp1.setVisible(false);
jp1.add(lp1); 

lp2= new JLabel("Memories...",JLabel.CENTER);
lp2.setFont(f7);
lp2.setForeground(Color.white);
lp2.setBounds(0,240,300,40);
lp2.setVisible(false);
jp1.add(lp2); 




// ---------------------------------------PANEL2------------------------------------

jp2 = new JPanel();
jp2.setLayout(null);
jp2.setBorder(null);
jp2.setLocation(300,195);
jp2.setPreferredSize(new Dimension(700,500));
jp2.setBackground(Color.black);

//initial instruction

insruct = new JLabel("click on the package button to see details...",JLabel.CENTER);
insruct.setFont(f4);
insruct.setForeground(Color.white);
insruct.setBounds(50,50,600,50);
jp2.add(insruct); 

insruct2 = new JLabel("you already booked this package...",JLabel.CENTER);
insruct2.setFont(f4);
insruct2.setForeground(Color.white);
insruct2.setBounds(50,50,600,50);
insruct2.setVisible(false);
jp2.add(insruct2); 


 //--------------------------------title label
ltitle = new JLabel("",JLabel.CENTER);
ltitle.setFont(f5);
ltitle.setForeground(Color.white);
ltitle.setBounds(50,50,600,50);
jp2.add(ltitle); 
height =110;

 
 //-------------------------location titles
for(int i=1;i<10;i++)
{
loctitle[i]=new JLabel();
loctitle[i].setFont(f6);
loctitle[i].setForeground(Color.white);
jp2.add(loctitle[i]);
}

 //-------------------------hotel titles
for(int i=1;i<10;i++)
{
hottitle[i]=new JLabel();
hottitle[i].setFont(f2);
hottitle[i].setForeground(Color.white);
jp2.add(hottitle[i]);
}


//------------------------------duration at the place...........

for(int i=1;i<10;i++)
{
locdays[i]=new JLabel();
locdays[i].setFont(f6);
locdays[i].setForeground(Color.white);
jp2.add(locdays[i]);
}

//  only images for location
for(int i =0; i < 10;i++)
 {
 imlab[i] = new JLabel(new ImageIcon(""));
 jp2.add(imlab[i]);
 }



//-------------------------data--------------- 
 
 for(int j=0;j<10;j++)
 {
for(int i=0;i<100;i++)
{
data[j][i]=new JLabel();
data[j][i].setFont(f4);
data[j][i].setForeground(Color.white);
jp2.add(data[j][i]);
}
}

//-----------------------------------jp3 -------------------------------

jp3 = new JPanel();
jp3.setBounds(1000,195,280,505);
jp3.setLayout(null);
jp3.setBackground(Color.black);
 

  //labels for extreme right side-----------------------

lpname= new JLabel();
lpname.setFont(f4);
lpname.setForeground(Color.white);
lpname.setBounds(20,30,240,30);
jp3.add(lpname); 
 
nod = new JLabel();
nod.setFont(f4);
nod.setForeground(Color.white);
nod.setBounds(20,60,240,30);
jp3.add(nod);
 
maxseats = new JLabel();
maxseats.setFont(f4);
maxseats.setForeground(Color.white);
maxseats.setBounds(20,90,240,30);
jp3.add(maxseats);
 
availseats = new JLabel();
availseats.setFont(f4);
availseats.setForeground(Color.white);
availseats.setBounds(20,120,240,30);
jp3.add(availseats);
 
lcost = new JLabel();
lcost.setFont(f4);
lcost.setForeground(Color.white);
lcost.setBounds(20,150,240,30);
jp3.add(lcost);

 
minfo = new JLabel("TOUR MANAGER INFO");
minfo.setFont(f2);
minfo.setVisible(false);
minfo.setForeground(Color.white);
minfo.setBounds(20,180,240,30);
jp3.add(minfo);
 
lname= new JLabel();
lname.setFont(f4);
lname.setForeground(Color.white);
lname.setBounds(20,210,240,30);
jp3.add(lname); 
 
lph= new JLabel();
lph.setFont(f4);
lph.setForeground(Color.white);
lph.setBounds(20,240,240,30);
jp3.add(lph); 
 
lid= new JLabel();
lid.setFont(f4);
lid.setForeground(Color.white);
lid.setBounds(20,270,240,30);
jp3.add(lid); 
 

//-----------------------------------------------------

 
 
int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;
jsp1= new JScrollPane(jp1,v,h);
jsp1.setBounds(0, 195, 300, 505);
add(jsp1, BorderLayout.CENTER);

jsp2= new JScrollPane(jp2,v,h);
jsp2.setBounds(301, 195, 700, 505);
add(jsp2, BorderLayout.CENTER);


b1 = new JButton("Click Here To Book This Package");
b1.setBounds(10,455,240,30); 
b1.addActionListener(this);
b1.setVisible(false);
jp3.add(b1);

add(jp3);
add(a);

}


 public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
im=0;
NOC =0;
height =20;
for(int j=0;j<10;j++)
{
imlab[j].setVisible(false);
 for(int i=0;i<100;i++)
{data[j][i].setText("");}
}
insruct.setVisible(false);
insruct2.setVisible(false);
jp2.setPreferredSize(new Dimension(700,500));
 
//System.out.println(s);
 
if(s.equals("Click Here To Book This Package"))
{

boolean b=selectsentry();

if(b)
{
cleardata(true);
setVisible(false);
f.transfer(uname,packageid,rid);
back.setVisible(false);
f.setVisible(true);
}
else
{
cleardata(false);
insruct2.setVisible(true);
}


}

else 
{
str="";
b1.setVisible(true);
getdata(s);
}

} 


void getdata(String p)
{
packageid=p;
Connection c;
Statement st;
ResultSet rs,rs2;
String que;
String pname,tmid,datafile,imagefile,iconfile;
int days,max,avail,cost;
String name,email,ph;



try{

Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();
que="select * from travelpackage where pid='"+packageid+"'";
//System.out.println(que);
rs = st.executeQuery(que);


while(rs.next())
{
pname=rs.getString("pname");
days=rs.getInt("noofdays");
tmid=rs.getString("tmid");
max=rs.getInt("maxseats");
avail=rs.getInt("availseats");
datafile=rs.getString("datafile");
imagefile=rs.getString("imagefile");
rid= rs.getString("region_id");

cost=rs.getInt("cost");

//ltitle.setText(pname);
lpname.setText    ("package name    : "+pname);
nod.setText       ("Number of days   : "+days);
maxseats.setText  ("Maximum seats   : "+max);
availseats.setText("Available seats     : "+avail);
lcost.setText     ("Cost                     : "+cost);
display(true,imagefile,datafile);


rs2 = st.executeQuery("select tmname,phno,email from tourmanager where tmid='"+tmid+"'");

while(rs2.next())
{
name=rs2.getString("tmname");
email=rs2.getString("email");
ph=rs2.getString("phno");

minfo.setVisible(true);
lname.setText("name: "+name);
lph.setText  ("phone no: "+ph);
lid.setText  ("id: "+email); 
}

}


  
  
rs.close();
st.close();
c.close();
}

catch(Exception e)
{
System.out.println("exception in tour getdata1...........");
System.out.println(e);
}

fetchdata();

}




void fetchdata()
{


Connection c;
Statement st;
ResultSet rs,rs2;
String que;
String lid,days,datafile,imagefile,datafile2;
int locno,ii=0;
String locname,hname;



try{

Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();
que="select c.*, l.*, h.* from contains c , location l, hotel h where l.lid=c.lid and h.hid=c.hid and pid='"+packageid+"'";
//System.out.println(que);
rs = st.executeQuery(que);


while(rs.next())
{
 lid=rs.getString("lid");
locno=rs.getInt("locno");
days=rs.getString("noofdays"); 


ii++;
locname=rs.getString("lname");
datafile=rs.getString("datafile");
imagefile=rs.getString("imagefile1");
datafile2=rs.getString(12);
hname=rs.getString("hname");

System.out.println("--------------------------------"+locname);

loctitle[ii].setText(locname);
loctitle[ii].setBounds(50,height,600,50);
height+=40;



locdays[ii].setText(days);
locdays[ii].setBounds(50,height,600,30);
height+=30; 


display(true,imagefile,datafile);

hottitle[ii].setText("Hotel: "+hname);
hottitle[ii].setBounds(50,height+10,600,50);
height+=50;

display(false,"",datafile2); 
 
 }



  
  
rs.close();
st.close();
c.close();
}

catch(Exception e)
{
System.out.println("exception in tour fetchdaata..........");
System.out.println(e);
}



}

void display(boolean status,String imagefile,String dt)
{
//-------------------------------fileloop--------------
str="";
NOC++;

if(status)
{
im++;
imlab[im].setIcon(new ImageIcon(imagefile));
imlab[im].setBounds(50,height,600,200);
imlab[im].setVisible(true);
height+=210;
}

System.out.println("display.........");

try{
FileInputStream fin = new FileInputStream(dt);

n=0;

while(n!=-1)
{
n=fin.read();
str=str+ (char)n;
}

System.out.println(str.length());

fin.close();
}
catch(Exception e){}

int size=88;

count = str.length()/size +2;
System.out.println(count);

st =new String[count];
//data= new JLabel[count];

 for(int i=0;i<count;i++)
{st[i]="";} 


int k=0,c,track;

for(int i=0;i<count;i++)
   {
temp="";
c=-1;
track=0;
       
	   for(;k<str.length();k++)
		{
		c++;
		if(str.charAt(k)==' ' ){track=c;}
		
		if(c>size || str.length()-1==k){break;}
		
	    temp= temp+str.charAt(k);
		
		
		}
		
		
		if(track!=size && k<str.length()-1)
	    {
			k=k-(size-track);
			
			for(int m=0;m<track;m++)
			{
			    st[i]=st[i]+temp.charAt(m); 
		    }
			
			
		}
		else
		{
		st[i]=temp;
		}
		


    }

 
 jp2.setPreferredSize(new Dimension(700,height + count*20 ));  //to be set later
 
 
 
 int i;
for( i=0;i<count;i++)
{
//System.out.println(st[i]);
data[NOC][i].setText(st[i]);
data[NOC][i].setBounds(50,height + i*20,600,20);
}

height+=i*20;
System.out.println("---------------------------------->");
}



void cleardata(boolean bb)
{
im=0;
height =30;

if(bb)
{
for(int i=1;i<cnt;i++)
{
la[i].setText("");
la2[i].setText("");
b[i].setVisible(false);
lab[i].setVisible(false);

}

insruct.setVisible(true);
insruct2.setVisible(false);
}

imlab[0].setVisible(false);

for(int i=1;i<10;i++)
{
imlab[i].setVisible(false);
loctitle[i].setText("");
locdays[i].setText("");
}

for(int i=0;i<10;i++)
{
for(int j=0;j<100;j++)
{data[i][j].setText("");}
}

b1.setVisible(false); 
ltitle.setText("");
lpname.setText("");
nod.setText("");
maxseats.setText("");
availseats.setText("");
lcost.setText("");
minfo.setVisible(false);
lname.setText("");
lph.setText("");
lid.setText("");
jp1.setPreferredSize(new Dimension(300,500));
jp2.setPreferredSize(new Dimension(700,500));

}



void loadicon(String u,boolean nnn,boolean www,boolean sss,boolean eee)
{
uname =u;
int i=0;
int nn,ww,ss,ee;
nn=ww=ss=ee=0;

if(nnn){nn=1;}
if(www){ww=2;}
if(sss){ss=3;}
if(eee){ee=4;}


 
Connection c;
Statement st;
ResultSet rs;
String que,sp,sd,iconfile;

try{

Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();

que="select pid,pname,discription,iconimage from travelpackage where region_id in ("+nn+","+ww+","+ss+","+ee+")";
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

if (i>4)
{
jp1.setPreferredSize(new Dimension(300,20+(110*i)));
}

la[i].setText(sp);
la2[i].setText(sd);

b[i].setIcon(new ImageIcon(iconfile));

b[i].setBounds(20,((i-1)*110)+5,100,100);
lab[i].setBounds(0,((i-1)*110),300,110);
b[i].setActionCommand(pckid);
b[i].setVisible(true);

la[i].setText(sp);
la2[i].setText(sd);

}
  
rs.close();
st.close();
c.close();
}

catch(Exception e)
{
System.out.println("exception in tour...........");
System.out.println(e);

}


}



boolean selectsentry()
{
Connection c;
Statement st;
String que;
try{

Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();
que="insert into selects(uname,pid,pdate) values('"+uname+"','"+packageid+"',sysdate)";
st.executeQuery(que);


  
st.close();
c.close();
return true;
}

catch(Exception e)
{

System.out.println("exception in tour selects entry...........");
System.out.println(e);
return false;
}


}


}



