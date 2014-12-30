import javax.swing.*;
import javax.swing.table.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


class invoice extends JPanel implements ActionListener
{
JButton b1;
java.awt.Font f1,f2,f3;
JPanel jp1;
JLabel a,l1,l2;
JLabel ptitle,pn,pl,pm,pd,pnv,plv,pmv,pdv;
JLabel btitle;
JTable jt;
JLabel ctitle,ic,trc,toc,iv,trv,tov;
String uname,packageid,rid,source;
int packprice;

String[] ob1=new String[3];
String cname[] = {"Name","Birtyhdate","Gender"};
//String  values[][]=new String[10][];
String  values[][]={/*{"Saumil Pandya","20","M"},{"Prayag Pandya","14","M"},{"Pinky Pandya","15","F"}*/};
DefaultTableModel model;

invoice(String s)
{

setLayout(null);
setBounds(0,0,1280,1024);




a = new JLabel(new ImageIcon("c:\\project\\images\\end.png"));
a.setBounds(0,0,1280,960);

f1 =new java.awt.Font("Arial",java.awt.Font.PLAIN,18);
f2 =new java.awt.Font("Arial",java.awt.Font.PLAIN,20);
f3 =new java.awt.Font("Arial",java.awt.Font.PLAIN,12);

jp1 = new JPanel();
jp1.setLayout(null);
//jp1.setBorder(null);
//jp1.setOpaque(false);
jp1.setBounds(260,200,700,500);
jp1.setBackground(Color.black);
jp1.setForeground(Color.white);

//package details-----------------------------

ptitle = new JLabel("PACKAGE DETAILS",JLabel.CENTER);
ptitle.setBounds(0,10,700,20);
ptitle.setFont(f2);
ptitle.setForeground(Color.white);
jp1.add(ptitle);

//---------------
pn = new JLabel("Package Name : ",JLabel.RIGHT);
pn.setBounds(20,40,250,20);
pn.setFont(f1);
pn.setForeground(Color.white);
jp1.add(pn);

pnv = new JLabel("",JLabel.LEFT);
pnv.setBounds(270,40,300,20);
pnv.setFont(f1);
pnv.setForeground(Color.white);
jp1.add(pnv);

//--------------
pl = new JLabel("Package Locations : ",JLabel.RIGHT);
pl.setBounds(20,70,250,20);
pl.setFont(f1);
pl.setForeground(Color.white);
jp1.add(pl);

plv = new JLabel("",JLabel.LEFT);
plv.setBounds(270,70,300,20);
plv.setFont(f1);
plv.setForeground(Color.white);
jp1.add(plv);

//----------------
pm = new JLabel("Package Manager : ",JLabel.RIGHT);
pm.setBounds(20,100,250,20);
pm.setFont(f1);
pm.setForeground(Color.white);
jp1.add(pm);

pmv = new JLabel("",JLabel.LEFT);
pmv.setBounds(270,100,300,20);
pmv.setFont(f1);
pmv.setForeground(Color.white);
jp1.add(pmv);
//-----------------

pd = new JLabel("Package Date : ", JLabel.RIGHT);
pd.setBounds(20,130,250,20);
pd.setFont(f1);
pd.setForeground(Color.white);
jp1.add(pd);

pdv = new JLabel("",JLabel.LEFT);
pdv.setBounds(270,130,300,20);
pdv.setFont(f1);
pdv.setForeground(Color.white);
jp1.add(pdv);

//-------------------


l1 = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
l1.setBounds(0,150,700,10);
l1.setForeground(Color.white);



//booking details of family members----------

btitle = new JLabel("BOOKING DETAILS",JLabel.CENTER);
btitle.setBounds(0,160,700,20);
btitle.setFont(f2);
btitle.setForeground(Color.white);
jp1.add(btitle);

model=new DefaultTableModel(values,cname);

jt  = new JTable(model);
jt.setBackground(Color.black);
jt.setForeground(Color.white);
jt.setOpaque(false);
jt.setBounds(10,220,680,150);
jt.setEnabled(false);
jp1.add(jt);




l2 = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
l2.setBounds(0,340,700,10);
l2.setForeground(Color.white);

ctitle = new JLabel("TARIFF DETAILS",JLabel.CENTER);
ctitle.setBounds(0,350,700,20);
ctitle.setFont(f2);
ctitle.setForeground(Color.white);
jp1.add(ctitle);

//---------------
ic = new JLabel("Package Tariff(per person): ",JLabel.RIGHT);
ic.setBounds(20,375,250,20);
ic.setFont(f1);
ic.setForeground(Color.white);
jp1.add(ic);

iv = new JLabel("",JLabel.LEFT);
iv.setBounds(270,375,300,20);
iv.setFont(f1);
iv.setForeground(Color.white);
jp1.add(iv);


//---------------
trc = new JLabel("Transport Tariff : ",JLabel.RIGHT);
trc.setBounds(20,400,250,20);
trc.setFont(f1);
trc.setForeground(Color.white);
jp1.add(trc);

trv = new JLabel("",JLabel.LEFT);
trv.setBounds(270,400,300,20);
trv.setFont(f1);
trv.setForeground(Color.white);
jp1.add(trv);


//---------------
toc = new JLabel("Total Tariff : ",JLabel.RIGHT);
toc.setBounds(20,425,250,20);
toc.setFont(f1);
toc.setForeground(Color.white);
jp1.add(toc);

tov = new JLabel("",JLabel.LEFT);
tov.setBounds(270,425,300,20);
tov.setFont(f1);
tov.setForeground(Color.white);
jp1.add(tov);

//---------------------------------------------------------------------
//pdf file write.....

b1 = new JButton("Print Invoice");
b1.setBounds(530,650,150,30);
b1.addActionListener(this);
add(b1);

jp1.add(l1);
jp1.add(l2);


add(jp1);
add(a);



}


public void actionPerformed(ActionEvent ae)
{
String s = ae.getActionCommand();
if(s=="Print Invoice")
{
//write pdf code...
Document document = new Document();
try {
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\project\\invoice\\"+uname+packageid+".pdf"));
    document.open();
    PdfContentByte contentByte = writer.getDirectContent();
    PdfTemplate template = contentByte.createTemplate(500, 500);
    Graphics2D g2 = template.createGraphics(500, 500);
    jp1.print(g2);
    g2.dispose();
    contentByte.addTemplate(template, 30, 300);
} catch (Exception e) {
    e.printStackTrace();
}
finally{
    if(document.isOpen()){
        document.close();
    }
}



}

}


void setdata(String u,String pkid, String r,String s)
{

System.out.println("entered in setdata...........");

uname=u;
packageid=pkid;
rid=r;
source=s;

Connection c;
Statement st;
ResultSet rs;
String que;

try{

Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();
que="select p.*,t.* from travelpackage p, tourmanager t where p.tmid=t.tmid and pid='"+packageid+"'";
rs = st.executeQuery(que);



while(rs.next())
{
pnv.setText(rs.getString("pname"));
plv.setText(rs.getString("discription"));
String tms=rs.getString("tmname")+" ("+rs.getString("phno")+")";
pmv.setText(tms);
pdv.setText("12/05/2011");
int pamt=rs.getInt("cost");
iv.setText("Rs: "+pamt);
packprice=pamt;
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

fetchdata();
}

void fetchdata()
{

String dest="";
if(rid.equals("1")){dest="delhi";}
else if(rid.equals("2")){dest="mumbai";}
else if(rid.equals("3")){dest="bengaluru";}
else if(rid.equals("4")){dest="kolkata";}

Connection c;
Statement st;
ResultSet rs;
String que,s1,s2,s3;
int iiii=0;

int money=0,no=0,count=0;
try{

Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();
que="select cost from trans where source='"+source+"' and lower(destination)='"+dest+"'";
rs = st.executeQuery(que);

while(rs.next())
{money= rs.getInt("cost");}

trv.setText("Rs."+money);
 
que="select count(*) from family where uname='"+uname+"' and pid='"+packageid+"'";
rs=st.executeQuery(que);

while(rs.next())
{no= rs.getInt(1);}

 long tot=no*money + no * packprice;
 tov.setText("Rs."+tot);
 
 //JTABLE ENTRY..................
 
que="select * from family where uname='"+uname+"' and pid='"+packageid+"'";
rs=st.executeQuery(que);

while(rs.next())
{
s1=rs.getString("fname");
String mp=rs.getString("birthdate"); 
String yyyy= mp.substring(0,4);
String mm= mp.substring(5,7);
String dd= mp.substring(8,10);
mp=dd+"-"+mm+"-"+yyyy;

String gn=rs.getString("gender");
String gn2="";
if(gn.equals("m")) {gn2="Male";}
else {gn2="Female";}  


ob1[0]=s1;
 ob1[1]=mp;
 ob1[2]=gn2;
 
 
model.insertRow(iiii,ob1);

iiii++;
count++;
}
 
 /*  //ob1[] ={"saumil pandya","20","male"};
 ob1[0]="saumil";
 ob1[1]="20";
 ob1[2]="male";
 
 
model.insertRow(jt.getRowCount(),ob1);
model.insertRow(jt.getRowCount(),new Object[]{"vishwa desai ","20","male"});
model.insertRow(jt.getRowCount(),new Object[]{"raj desai","20","male"});
model.insertRow(jt.getRowCount(),new Object[]{"keyur Gosai","20","male"});
  */
 
 
 
rs.close();
st.close();
c.close();
}

catch(Exception e)
{

System.out.println("exception in invoice fetchdata...........");
System.out.println(e);
}


}


void cleardata()
{
pnv.setText("");
plv.setText("");
pmv.setText("");
pdv.setText("");
iv.setText("");
trv.setText("");
trv.setText("");
 tov.setText("");

}

}