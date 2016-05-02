//<applet code=login height=300 width=150></applet>
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
 
public class login extends JApplet implements ActionListener
{
JLabel l1;
JTextField t1;
JLabel l2;
JPasswordField t2;
JButton b1;
	
	GridBagLayout g1;
	GridBagConstraints gbc;



	public void init()
	{
		CreateApplet();
	}
	public void CreateApplet()
		{
			g1 = new GridBagLayout();
			gbc = new GridBagConstraints();

			 Container c = getContentPane();
			 c.setLayout(new GridLayout());
			 l1=new JLabel("User Name:");
			 t1=new JTextField(10);
			 l2=new JLabel("Password");
			 t2=new JPasswordField(10);
			 b1 =new JButton("OK");

		/*	c.add(l1);
			c.add(t1);
			c.add(l2);	
			c.add(t2);
			c.add(b1);*/
			gbc.anchor =GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 2;
			g1.setConstraints(l1,gbc);
			c.add(l1);
	
			gbc.anchor =GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 2;
			g1.setConstraints(t1,gbc);
			c.add(t1);

			gbc.anchor =GridBagConstraints.NORTHWEST;
			gbc.gridx = 1;
			gbc.gridy = 2;
			g1.setConstraints(l2,gbc);
			c.add(l2);
	
			gbc.anchor =GridBagConstraints.NORTHWEST;
			gbc.gridx = 4;
			gbc.gridy = 2;
			g1.setConstraints(t2,gbc);
			c.add(t2);

			gbc.anchor =GridBagConstraints.SOUTHEAST;
			gbc.gridx = 14;
			gbc.gridy = 90;
			g1.setConstraints(b1,gbc);
			c.add(b1);
	




			b1.addActionListener(this);
		}
public void actionPerformed(ActionEvent e)
	{
		Object o =e.getSource();
		if(o==b1)
		{
			Date date=new Date();
			GregorianCalendar gcal=new GregorianCalendar();
			gcal.setTime(date);

			String entry = "User"+t1.getText() + "Loggedin"+gcal.get(Calendar.HOUR)+":"
			+gcal.get(Calendar.MINUTE)+"Date:"+gcal.get(Calendar.MONTH)+"/"+gcal.get(Calendar.DATE)+"/"+
			gcal.get(Calendar.YEAR);

		try
		{
			RandomAccessFile logFile=new RandomAccessFile("log.txt","rw");
			logFile.seek(logFile.length());
			logFile.writeBytes(entry);
	 	 }
		catch(IOException x)
		{
			showStatus("CANNOT WRITE ON TO THE LOG FILE"+x);
		}
	}
}
}