import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

import java.sql.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
public class ToyUniverse extends JApplet implements Runnable
{

 JTabbedPane tb;
	JScrollPane sp;
	JPanel regPanel;
	JPanel recpPanel;
	JPanel odPanel;
	GridBagLayout gb;
	GridBagConstraints gbc;


	Thread datimeThread;
	Date date;
	GregorianCalendar calendar;
        String strDate,strTime,strStatus,strStatus1;

        JLabel regShopperId;
	JLabel regPassword;
	JLabel regFirstName;
	JLabel regLastName;
	JLabel regAddress;
	JLabel regEmail;
	JLabel regCity;
	JLabel regState;
	JLabel regCountry;
	JLabel regCountryId;
	JLabel regCreditCardNo;
        JLabel regCreditCardType;
	JLabel regExpiryDate;
        
        JButton submit;
        

        JTextField textregShopperId;
	JPasswordField textregPassword;
	JTextField textregFirstName;
	JTextField textregLastName;
	JTextField textregAddress;
	JTextField textregEmail;
	JTextField textregCity;
	JTextField textregState;
	JTextField textregCountry;
	JTextField textregCountryId;
	JTextField textregCreditCardNo;
	JTextField textregCreditCardType;
	JTextField textregExpiryDate;

        JLabel label1;
	JLabel label2;	
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
   
	JLabel recpOrderNo;
	JLabel recpFirstName;
	JLabel recpLastName;
	JLabel recpAddress;
	JLabel recpCity;
	JLabel recpState;
	JLabel recpCountryId;
	JLabel recpZipCode;
	JLabel recpPhone;

	JButton recpsubmit;
	

	JTextField textrecpOrderNo;
	JTextField textrecpFirstName;
	JTextField textrecpLastName;
	JTextField textrecpAddress;
	JTextField textrecpCity;
	JTextField textrecpState;
	JTextField textrecpCountryId;
	JTextField textrecpZipCode;
	JTextField textrecpPhone;

	JLabel odOrderNo;
	JLabel odToyId;
	JLabel odQty;
	JLabel odGiftWrap;
	JLabel odWrapperId;
	JLabel odToyCost;

	JTextField textodOrderNo;
	JTextField textodToyId;
	JTextField textodQty;
	JComboBox comboodGiftWrap;
	JTextField textodWrapperId;
	JTextField textodToyCost;

	JButton odsubmit;
	
	
	public void init()
	{	
		tb = new JTabbedPane();
		regPanel = new JPanel();
		recpPanel = new JPanel();	
		odPanel = new JPanel();
		gb = new GridBagLayout();
		gbc = new GridBagConstraints();
		regPanel.setLayout(gb);
		recpPanel.setLayout(gb);
		odPanel.setLayout(gb);
		gbc.anchor = GridBagConstraints.NORTHWEST;

		regPanel.setBackground(Color.pink);
		regPanel.setForeground(Color.blue);
		recpPanel.setBackground(Color.yellow);
		recpPanel.setForeground(Color.blue);
		odPanel.setBackground(Color.green);
		odPanel.setForeground(Color.black);
		datimeThread = new Thread(this);
		
		
		label1 = new JLabel("");
		label2 = new JLabel("");
		label3 = new JLabel("");
		label4 = new JLabel("");
		label5 = new JLabel("");
		label6 = new JLabel("");


		date = new Date();
		calendar = new GregorianCalendar();
		datimeThread.start();


        	regShopperId = new JLabel("SHOPPER ID");
		regPassword = new JLabel("PASSWORD");
		regFirstName = new JLabel("FIRST NAME");
		regLastName = new JLabel("LAST NAME");
		regAddress =new JLabel("ADDRESS");
		regEmail = new JLabel("E-MAIL");
		regCity = new JLabel("CITY");
		regState = new JLabel("State");
		regCountry = new JLabel("COUNTRY");
		regCountryId = new JLabel("COUNTRY ID");
		regCreditCardNo = new JLabel("CREDITCARD NUMBER");
		regCreditCardType = new JLabel("CREDITCARD TYPE");
		regExpiryDate = new JLabel("EXPIRY DATE");

		submit = new JButton("SUBMIT");
validateAction v=new validateAction();
		submit.addActionListener(v);


		textregShopperId = new JTextField(5);
		textregPassword = new JPasswordField(7);
		textregFirstName = new JTextField(15);
		textregLastName = new JTextField(15);
		textregAddress =new JTextField(15);
		textregEmail = new JTextField(15);
		textregCity = new JTextField(10);
		textregState =new JTextField(15);
		textregCountry = new JTextField(10);
		textregCountryId = new JTextField(5);
		textregCreditCardNo = new JTextField(15);
		textregCreditCardType = new JTextField(10);
		textregExpiryDate = new JTextField(10);		
		
		recpOrderNo = new JLabel("ORDER NO");
		recpFirstName = new JLabel("FIRST NAME");
		recpLastName = new JLabel("LAST NAME");
		recpAddress = new JLabel("ADDRESS");
		recpCity = new JLabel("CITY");
		recpState = new JLabel("STATE");
		recpCountryId = new JLabel("COUNTRY ID");
		recpZipCode = new JLabel("ZIP CODE");
		recpPhone = new JLabel("PHONE");
		
		recpsubmit = new JButton("SUBMIT");
validateAction v1=new validateAction();
		recpsubmit.addActionListener(v1);
	


		textrecpOrderNo = new JTextField(5);	
		textrecpFirstName = new JTextField(15);
		textrecpLastName = new JTextField(15);
		textrecpAddress = new JTextField(15);
		textrecpCity = new JTextField(10);
		textrecpState = new JTextField(10);
		textrecpCountryId = new JTextField(5);
		textrecpZipCode = new JTextField(10);
		textrecpPhone = new JTextField(10);

		odOrderNo = new JLabel("ORDER ID");
		odToyId = new JLabel("TOY ID");
		odQty = new JLabel("QUATITY");
		odGiftWrap = new JLabel("GIFTWRAP");
		odWrapperId = new JLabel("WRAPPER ID");
		odToyCost = new JLabel("TOY COST");

		textodOrderNo = new JTextField(5);
		textodToyId = new JTextField(5);
		textodQty = new JTextField(5);
		
 
                String wrap[] = {"YES","NO"};
		comboodGiftWrap = new JComboBox(wrap);
		textodWrapperId = new JTextField(5);
		textodToyCost = new JTextField(15);
		
		odsubmit = new JButton("SUBMIT");
validateAction v2=new validateAction();
		odsubmit.addActionListener(v2);
		

		gbc.gridx = 1;
		gbc.gridy = 1;
		gb.setConstraints(regShopperId,gbc);
		regPanel.add(regShopperId);

		gbc.gridx =3;
		gbc.gridy = 1;
		gb.setConstraints(textregShopperId,gbc);
		regPanel.add(textregShopperId);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gb.setConstraints(regPassword,gbc);
		regPanel.add(regPassword);
	
		gbc.gridx = 3;
		gbc.gridy = 3;
		gb.setConstraints(textregPassword,gbc);
		regPanel.add(textregPassword);				

		gbc.gridx = 1;
		gbc.gridy = 7;
		gb.setConstraints(regFirstName,gbc);
		regPanel.add(regFirstName); 

		gbc.gridx = 3;
		gbc.gridy = 7;
		gb.setConstraints(textregFirstName,gbc);
		regPanel.add(textregFirstName); 

		gbc.gridx = 1;
		gbc.gridy = 11;
		gb.setConstraints(regLastName,gbc);
		regPanel.add(regLastName); 

		gbc.gridx = 3;
		gbc.gridy = 11;
		gb.setConstraints(textregLastName,gbc);
		regPanel.add(textregLastName); 

		gbc.gridx = 1;
		gbc.gridy = 14;
		gb.setConstraints(regAddress,gbc);
		regPanel.add(regAddress); 

		gbc.gridx = 3;
		gbc.gridy = 14;
		gb.setConstraints(textregAddress,gbc);
		regPanel.add(textregAddress);

		gbc.gridx = 1;
		gbc.gridy = 17;
		gb.setConstraints(regEmail,gbc);
		regPanel.add(regEmail);  

		gbc.gridx = 3;
		gbc.gridy = 17;
		gb.setConstraints(textregEmail,gbc);
		regPanel.add(textregEmail);  
		
 		gbc.gridx = 1;
		gbc.gridy = 21;
		gb.setConstraints(regCity,gbc);
		regPanel.add(regCity);  

		gbc.gridx = 3;
		gbc.gridy = 21;
		gb.setConstraints(textregCity,gbc);
		regPanel.add(textregCity);  

		gbc.gridx = 1;
		gbc.gridy = 24;
		gb.setConstraints(regState,gbc);
		regPanel.add(regState);  

		gbc.gridx = 3;
		gbc.gridy = 24;
		gb.setConstraints(textregState,gbc);
		regPanel.add(textregState);  

		gbc.gridx = 1;
		gbc.gridy = 27;
		gb.setConstraints(regCountry,gbc);
		regPanel.add(regCountry);  

		gbc.gridx = 3;
		gbc.gridy = 27;
		gb.setConstraints(textregCountry,gbc);
		regPanel.add(textregCountry);  

		gbc.gridx = 1;
		gbc.gridy = 30;
		gb.setConstraints(regCountryId,gbc);
		regPanel.add(regCountryId);  

		gbc.gridx = 3;
		gbc.gridy = 30;
		gb.setConstraints(textregCountryId,gbc);
		regPanel.add(textregCountryId);  

		gbc.gridx = 1;
		gbc.gridy = 33;
		gb.setConstraints(regCreditCardNo,gbc);
		regPanel.add(regCreditCardNo);  

		gbc.gridx = 3;
		gbc.gridy = 33;
		gb.setConstraints(textregCreditCardNo,gbc);
		regPanel.add(textregCreditCardNo);  

		gbc.gridx = 1;
		gbc.gridy = 36;
		gb.setConstraints(regCreditCardType,gbc);
		regPanel.add(regCreditCardType);  

		gbc.gridx = 3;
		gbc.gridy = 36;
		gb.setConstraints(textregCreditCardType,gbc);
		regPanel.add(textregCreditCardType);  

		gbc.gridx = 1;
		gbc.gridy = 39;
		gb.setConstraints(regExpiryDate,gbc);
		regPanel.add(regExpiryDate);  

		gbc.gridx = 3;
		gbc.gridy = 39;
		gb.setConstraints(textregExpiryDate,gbc);
		regPanel.add(textregExpiryDate);  

		gbc.gridx = 4;
		gbc.gridy = 43;
		gb.setConstraints(submit,gbc);
		regPanel.add(submit);

		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gb.setConstraints(recpOrderNo,gbc);
		recpPanel.add(recpOrderNo);

		gbc.gridx = 3;
		gbc.gridy = 1;
		gb.setConstraints(textrecpOrderNo,gbc);
		recpPanel.add(textrecpOrderNo);		

		gbc.gridx = 1;
		gbc.gridy = 3;
		gb.setConstraints(recpFirstName,gbc);
		recpPanel.add(recpFirstName);

		gbc.gridx = 3;
		gbc.gridy = 3;
		gb.setConstraints(textrecpFirstName,gbc);
		recpPanel.add(textrecpFirstName);

		gbc.gridx = 1;
		gbc.gridy = 7;
		gb.setConstraints(recpLastName,gbc);
		recpPanel.add(recpLastName);

		gbc.gridx = 3;
		gbc.gridy = 7;
		gb.setConstraints(textrecpLastName,gbc);
		recpPanel.add(textrecpLastName);

		gbc.gridx = 1;
		gbc.gridy = 11;
		gb.setConstraints(recpAddress,gbc);
		recpPanel.add(recpAddress);

		gbc.gridx = 3;
		gbc.gridy = 11;
		gb.setConstraints(textrecpAddress,gbc);
		recpPanel.add(textrecpAddress);

		gbc.gridx = 1;
		gbc.gridy = 14;
		gb.setConstraints(recpCity,gbc);
		recpPanel.add(recpCity);

		gbc.gridx = 3;
		gbc.gridy = 14;
		gb.setConstraints(textrecpCity,gbc);
		recpPanel.add(textrecpCity);

		gbc.gridx = 1;
		gbc.gridy = 17;
		gb.setConstraints(recpState,gbc);
		recpPanel.add(recpState);

		gbc.gridx = 3;
		gbc.gridy = 17;
		gb.setConstraints(textrecpState,gbc);
		recpPanel.add(textrecpState);

		gbc.gridx = 1;
		gbc.gridy = 20;
		gb.setConstraints(recpCountryId,gbc);
		recpPanel.add(recpCountryId);

		gbc.gridx = 3;
		gbc.gridy = 20;
		gb.setConstraints(textrecpCountryId,gbc);
		recpPanel.add(textrecpCountryId);

		gbc.gridx = 1;
		gbc.gridy = 23;
		gb.setConstraints(recpZipCode,gbc);
		recpPanel.add(recpZipCode);

		gbc.gridx = 3;
		gbc.gridy = 23;
		gb.setConstraints(textrecpZipCode,gbc);
		recpPanel.add(textrecpZipCode);

		gbc.gridx = 1;
		gbc.gridy = 26;
		gb.setConstraints(recpPhone,gbc);
		recpPanel.add(recpPhone);

		gbc.gridx = 3;
		gbc.gridy = 26;
		gb.setConstraints(textrecpPhone,gbc);
		recpPanel.add(textrecpPhone);

		gbc.gridx = 4;
		gbc.gridy = 29;
		gb.setConstraints(recpsubmit,gbc);
		recpPanel.add(recpsubmit);

		
		gbc.gridx = 5;
		gbc.gridy = 1;
		gb.setConstraints(label1,gbc);
		regPanel.add(label1);

		gbc.gridx = 5;
		gbc.gridy = 3;
		gb.setConstraints(label3,gbc);
		regPanel.add(label3);
	
		gbc.gridx = 5;
		gbc.gridy = 1;
		gb.setConstraints(label2,gbc);
		recpPanel.add(label2);

		gbc.gridx = 5;
		gbc.gridy = 3;
		gb.setConstraints(label4,gbc);
		recpPanel.add(label4);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gb.setConstraints(odOrderNo,gbc);
		odPanel.add(odOrderNo);

		gbc.gridx = 3;
		gbc.gridy = 1;
		gb.setConstraints(textodOrderNo,gbc);
		odPanel.add(textodOrderNo);
	
		gbc.gridx = 1;
		gbc.gridy = 3;
		gb.setConstraints(odToyId,gbc);
		odPanel.add(odToyId);		

		gbc.gridx = 3;
		gbc.gridy = 3;
		gb.setConstraints(textodToyId,gbc);
		odPanel.add(textodToyId);	

		gbc.gridx = 1;
		gbc.gridy = 7;
		gb.setConstraints(odQty,gbc);
		odPanel.add(odQty);		

		gbc.gridx = 3;
		gbc.gridy = 7;
		gb.setConstraints(textodQty,gbc);
		odPanel.add(textodQty);		

		gbc.gridx = 1;
		gbc.gridy = 10;
		gb.setConstraints(odGiftWrap,gbc);
		odPanel.add(odGiftWrap);		

		gbc.gridx = 3;
		gbc.gridy = 10;
		gb.setConstraints(comboodGiftWrap,gbc);
		odPanel.add(comboodGiftWrap);

		gbc.gridx = 1;
		gbc.gridy = 13;
		gb.setConstraints(odWrapperId,gbc);
		odPanel.add(odWrapperId);		

		gbc.gridx = 3;
		gbc.gridy = 13;
		gb.setConstraints(textodWrapperId,gbc);
		odPanel.add(textodWrapperId);		

				
		gbc.gridx = 1;
		gbc.gridy = 19;
		gb.setConstraints(odToyCost,gbc);
		odPanel.add(odToyCost);		

		gbc.gridx = 3;
		gbc.gridy = 19;
		gb.setConstraints(textodToyCost,gbc);
		odPanel.add(textodToyCost);		

		gbc.gridx = 4;
		gbc.gridy = 23;
		gb.setConstraints(odsubmit,gbc);
		odPanel.add(odsubmit);				

		
		gbc.gridx = 5;
		gbc.gridy = 1;
		gb.setConstraints(label5,gbc);
		odPanel.add(label5);

		gbc.gridx = 5;
		gbc.gridy = 3;
		gb.setConstraints(label6,gbc);
		odPanel.add(label6);
	
		tb.addTab("SHOPPER",null,regPanel,"ENTER YOUR DETAILS");
		tb.addTab("RECIPIENT",null,recpPanel,"ENTER RECIPIENT DETAILS");
		tb.addTab("ORDER DETAILS",null,odPanel,"ENTER YOUR ORDER DETAILS");

		getContentPane().add(tb);
	}



public void run()
	{
		while(datimeThread != null)
		{
			display();
			try
			{
				datimeThread.sleep(1000);
			}
	 		catch(InterruptedException e)
			{
				showStatus("thread interrupted");
			}
		}
	}

public void display()
	{
		calendar.setTime(date);
strTime=calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);

String strDate1,strDate2;
strDate1=calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.YEAR);

 		label1.setText(strTime);
		label3.setText(strDate);
		label2.setText(strTime);
		label4.setText(strDate);
	        label5.setText(strTime);
		label6.setText(strDate);
	
	}



class validateAction implements ActionListener
{ 
public void actionPerformed(ActionEvent e)
{
	
Object obj = e.getSource();

		if(obj == submit)
		{
			String Id = textregShopperId.getText();
			if(Id.length() == 0)
			{
				getAppletContext().showStatus("SHOPPER ID CANNOT BE NULL");
				return;
			}
			String password = textregPassword.getText();
			if(password.length() == 0)
			{
				getAppletContext().showStatus("PASSWORD CANNOT BE NULL");
				return;
			}
			String FName = textregFirstName.getText();
			if(FName.length() == 0)
			{
				getAppletContext().showStatus("FIRSTNAME CANNOT BE NULL");
				return;
			}
			String credit = textregCreditCardNo.getText();
			if(credit.length() == 0)
			{
				getAppletContext().showStatus("CREDIT CARD NUMBER CANNOT BE NULL");
				return;
			}
			String type = textregCreditCardType.getText();
			if (type.length() == 0)
			{
				getAppletContext().showStatus("CREDIT CARD TYPE CANNOT BE NULL");
				return;
			}
			String expdate = textregExpiryDate.getText();
			if(expdate.length() == 0)
			{
				getAppletContext().showStatus("EXPIRY DATE CANNOT BE NULL");
				return;
			}
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con;
			//establish connection with data source
			con=DriverManager.getConnection("jdbc:odbc:ToyUniverse","user1","");
			//create the statement object
			PreparedStatement stat=con.prepareStatement("insert into Shopper(cShopperId,cPassword,vFirstName,vLastName,vAddress,vEmailId ,cCity ,cState ,cCountry ,cCountryId ,cCreditCardNo ,cCreditCardType ,dExpiryDate)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//fill the parameter values
			stat.setString(1,textregShopperId.getText());
			stat.setString(2,textregPassword.getText());
 			//stat.setString(3,textConfirmPassword.getText());
 			stat.setString(4,textregFirstName.getText());
 			stat.setString(5,textregLastName.getText());
 			stat.setString(6,textregAddress.getText());
 			//stat.setString(7,textregPhone.getText());
 			stat.setString(8,textregEmail.getText());
 			stat.setString(12,textregCity.getText());
 			stat.setString(11,textregState.getText());
			stat.setString(9,textregCountry.getText());
 			stat.setString(10,textregCountryId.getText());
 			//stat.setString(13,textregZipcode.getText());	
 			stat.setString(14,textregCreditCardNo.getText());
 			stat.setString(15,textregCreditCardType.getText());
 			stat.setString(16,textregExpiryDate.getText());

			//insert the record into the statement
			stat.executeUpdate();
			}
			catch(Exception exception)
			{
				System.out.println("ERROR ENCOUNTERED WHILE ENTERING DATA IN TOYUNIVERSE DATABASE"+exception);
			}
		}

		


	
		if(obj == recpsubmit)
		{
			String order = textrecpOrderNo.getText();
			if(order.length() == 0)
			{
				getAppletContext().showStatus("ORDER NO CANNOT BE NULL");
				return;
			}
			String name = textrecpFirstName.getText();
			if(name.length() == 0)
			{
				getAppletContext().showStatus("FIRST NAME CANNOT BE NULL");
				return;
			}
			String namel = textrecpLastName.getText();
			if(namel.length() == 0)
			{
				getAppletContext().showStatus("LAST NAME CANNOT BE NULL");
				return;			
			}
			String address = textrecpAddress.getText();
			if(address.length() == 0)
			{	
				getAppletContext().showStatus("ADDRESS CANNOT BE NULL");
				return;
			}
			String city = textrecpCity.getText();
			if(city.length() == 0)
			{
				getAppletContext().showStatus("CITY CANNOT BE NULL");
				return;
			}
			String state = textrecpState.getText();
			if(state.length() == 0)
			{
				getAppletContext().showStatus("STATE CANNOT BE NULL");
				return;
			}
			String country = textrecpCountryId.getText();
			if(country.length() == 0)
			{
				getAppletContext().showStatus("COUNTRY ID CANNOT BE NULL");
				return;
			}
			String zip = textrecpZipCode.getText();
			if(zip.length() == 0)
			{
				getAppletContext().showStatus("ZIPCODE CANNOT BE NULL");
				return;
			}

				String phone = textrecpPhone.getText();
			if(phone.length() == 0)
			{
				getAppletContext().showStatus("PHONE CANNOT BE NULL");
				return;
			}
	else
			{
				getAppletContext().showStatus("");

			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con;
			//establish connection with data source
			con=DriverManager.getConnection("jdbc:odbc:ToyUniverse","user1","");
			//create the statement object
			PreparedStatement stat=con.prepareStatement("insert into Recipient(cOrderNo,vFirstName,vLastName,vAddress,cCity,cState,cCountryId,cZipcode,cPhone) values(?,?,?,?,?,?,?,?,?)");
			//fill the parameter values
			stat.setString(1,textrecpOrderNo.getText());
			stat.setString(2,textrecpFirstName.getText());
 			stat.setString(3,textrecpLastName.getText());
 			stat.setString(4,textrecpAddress.getText());
 			stat.setString(5,textrecpCity.getText());
 			stat.setString(6,textrecpState.getText());
 			//stat.setString(7,textrecpCountry.getText());
 			stat.setString(8,textrecpCountryId.getText());
 			stat.setString(9,textrecpZipCode.getText());
 			stat.setString(10,textrecpPhone.getText());
			
			//insert the record into the table
			stat.executeUpdate();
			}
			catch(Exception exception)
			{
				System.out.println("ERROR ENCOUNTERED WHILE ENTERING DATA IN THE DATABASE"+exception);
			}

		}


}
		

	if(obj == odsubmit)
		{
			String odno = textodOrderNo.getText();
			if(odno.length() == 0)
			{
				getAppletContext().showStatus("ORDER ID CANNOT BE NULL");
				return;	
			}
			String toyid = textodToyId.getText();
			if(toyid.length() == 0)
			{
				getAppletContext().showStatus("TOY ID CANNOT BE NULL");
				return;	
			}			
			String odqty = textodQty.getText();
			if(odqty.length() == 0)
			{
				getAppletContext().showStatus("QUANTITY CANNOT BE NULL");
				return;	
			}		
			String toycost = textodToyCost.getText();
			if(toycost.length() == 0)
			{
				getAppletContext().showStatus("TOY COST CANNOT BE NULL");
				return;	
			}
else
{

		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con;
			//establish connection with data source
			con=DriverManager.getConnection("jdbc:odbc:ToyUniverse","user1","");
			//create the statement object
			PreparedStatement stat=con.prepareStatement("insert into OrderDetail(cOrderNo,cToyId,siQty,cGiftWrap,cWrapperId,mToyCost) values(?,?,?,?,?,?)");
			//fill the parameter values
			stat.setString(1,textodOrderNo.getText());
			stat.setString(2,textodToyId.getText());
 			stat.setString(3,textodQty.getText());
 			stat.setString(4,(String)comboodGiftWrap.getSelectedItem());
 			stat.setString(5,textodWrapperId.getText());
 			stat.setString(6,textodToyCost.getText());
 			
			
			//insert the record into the table
			stat.executeUpdate();
			}
			catch(Exception exception)
			{
				System.out.println("ERROR ENCOUNTERED WHILE ENTERING DATA IN THE DATABASE"+exception);
			}


		
	}

}

}
}
}