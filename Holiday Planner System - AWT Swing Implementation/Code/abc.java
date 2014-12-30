import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

class jfrm extends JFrame implements ActionListener
{

JButton a,b;
jfrm(String st)
{
super(st);
a=new JButton("CLICK");
a.setBounds(50,50,100,50);
a.addActionListener(this);

b= new JButton(new ImageIcon(""));
b.setBounds(200,200,100,100);
b.addActionListener(this);

add(a);
add(b);
}

public void actionPerformed(ActionEvent ae)
{
String s= ae.getActionCommand();

if(s=="CLICK")
b.setIcon(new ImageIcon("C:\\project\\images\\5.png"));

}
}

class abc 
{
public static void main(String []st)
{
jfrm j = new jfrm("TRIAL");
j.setLocation(100,100);
j.setSize(500,500);
j.setLayout(null);
j.setVisible(true);

}


}
