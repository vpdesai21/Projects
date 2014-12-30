import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.*;

class home extends JPanel implements ActionListener ,KeyListener

{
//public:

JButton b1,b2,b01,b02;
//JPanel p1,p2;
JLabel l1,l2,l3;
Font f1,f2,f3;
JTextField tf1,tf2;
JPasswordField jp;
JLabel a;
JPanel head;
reg r1;
profile p;
admin ad;
JButton lg;
String uname,a1;
 
home(reg r2,profile p1,admin adm,JButton log  )
{
//super(s);
setLayout(null);
setBounds(0,0,1280,1024);
p=p1;
ad=adm;
r1=r2;
lg=log;

a = new JLabel(new ImageIcon("C:\\project\\images\\home.png"));
a.setBounds(00,00,1280,1024);

f1 =new Font("Arial",Font.PLAIN,15);
f2 =new Font("Arial",Font.PLAIN,28);
f3 =new Font("Arial",Font.PLAIN,22);

/* head = new JPanel();
head.setLayout(null);
head.setBounds(0,0,1280,100);
head.setBackground(Color.white);
add(head); */

l1 =new JLabel("USERNAME :",JLabel.RIGHT);
l1.setBounds(330,225,260,30);
l1.setForeground(Color.white);
l1.setFont(f2);

l2 =new JLabel("PASSWORD :",JLabel.RIGHT);
l2.setBounds(330,275,260,30);
l2.setForeground(Color.white);
l2.setFont(f2);


b1=new JButton("Sign In");
b1.setBounds(650,340,100,30);
b1.setFont(f1);
b1.addActionListener(this);

b2=new JButton("Sign Up");
b2.setBounds(650,440,100,30);
b2.setFont(f1);
b2.addActionListener(this);

tf1= new JTextField();
tf1.setBounds(610,225,180,30);
tf1.setBorder(null);
tf1.setForeground(Color.white);
tf1.setFont(f2);
tf1.setOpaque(false);

jp= new JPasswordField();
jp.setBounds(610,275,180,30);
jp.setBorder(null);
jp.setFont(f2);
jp.setForeground(Color.white);
jp.addActionListener(this);
jp.setOpaque(false);
jp.addKeyListener(this);

l3 =new JLabel();
l3.setBounds(600,385,200,30);
l3.setForeground(Color.white);
l3.setFont(f1);


add(b1);
add(b2);
add(tf1);
add(jp);
add(l1);
add(l2);
add(l3);

add(a);

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
{maincheck();}
}

 public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();

if (s=="Sign In")
{maincheck();}

else if(s=="Sign Up")
{
tf1.setText("");
jp.setText("");
r1.show();}

}

void maincheck()
{
boolean a=loginchk();

if(!a)
{
jp.setText("");
tf1.setText("");
l3.setText("*invalid username/password");
}

else
{
setVisible(false);
tf1.setText("");
jp.setText("");
l3.setText("");

if(a1.equals("admin"))
{
ad.adlog();
ad.setVisible(true);}
else
{p.redirect(lg,a1);
p.setVisible(true);}

}

}


boolean loginchk()
{

//System.out.println("uname");
 a1=tf1.getText();
if(a1.length()==0 )
return false;

//System.out.println("password");
char[] m=jp.getPassword();
String b=new String(m);
if(b.length()==0)
return false;

//TRY TO REMOVE SPCES PROBLEM FROM THE START
a1=a1.trim();
a1=a1.toLowerCase();
b=b.trim();


//open the database connection and check validity
Connection c;
Statement st;
ResultSet rs;
String que;
try{

Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:RAJ","scott","tiger");
st=c.createStatement();
que="select password from user1 where uname='"+a1+"'";
rs = st.executeQuery(que);



while(rs.next())
{

if(rs.getString(1).equals(b))
{
return true;
}
}
  
rs.close();
st.close();
c.close();
}

catch(Exception e)
{

System.out.println("exception in home...........");
System.out.println(e);
}

//-------------------------------------
return false;

}




}






