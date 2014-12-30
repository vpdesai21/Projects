import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.*;
//=================================================================================

class frm extends JFrame implements ActionListener
{
admin a;
tour t;
profile p;
reg r1;
home h1,h2;
family f;
invoice i;
JButton logout;
JButton back;
 
 
frm(String sst) 
{

super(sst);
setMinimumSize(new Dimension(1280,768));

logout = new JButton("LOGOUT");
logout.setBounds(1000,50,110,30);
logout.addActionListener(this);
logout.setVisible(false);
add(logout);


back = new JButton("BACK");
back.setBounds(900,50,110,30);
back.addActionListener(this);
back.setVisible(false);
add(back);

i = new invoice("INVOICE");
i.setVisible(false);
add(i);


 f = new family(i);
f.setVisible(false);
add(f);


t = new tour(f,back);
t.setVisible(false);
add(t); 


 p= new profile(t,back);
p.setVisible(false);
 add(p);



 
r1 = new reg(null);
r1.setLocation(315,150);
r1.setSize(650,580);
//r1.setVisible(false);
//add(r1);

a= new admin(logout);
a.setVisible(false);
add(a);


h1 = new home(r1,p,a,logout);
add(h1);


addWindowListener( new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
});





}



public void actionPerformed(ActionEvent ae)
{
String stm = ae.getActionCommand();

if(stm=="LOGOUT")
{

	logout.setVisible(false);
	p.setVisible(false);
	i.setVisible(false);
	t.setVisible(false);
	f.setVisible(false);
	h1.setVisible(true);
back.setVisible(false);
a.setVisible(false);
	
p.cleardata();
//i.cleardata();
t.cleardata(true);	
f.cleardata();
i.cleardata();
}

else if(stm=="BACK")
{
t.setVisible(false);
t.cleardata(true);
p.setVisible(true);
back.setVisible(false);
}

}





}



//======================================================================================

public class start 
{
public static void main(String st[])
{


frm base = new frm("TRAVELERS' GUIDE");
base.setSize(1280,768);
base.setLayout(null);
base.setVisible(true);



}
}