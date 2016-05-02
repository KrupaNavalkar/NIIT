// Software developed for Toy Universe Shopping Mall

import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.sql.*;
import java.net.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


class Registration extends Object implements Serializable
{
 String regShopperId, regPassword, regFirstName, regLastName, regAddress, regEmail, regCity, regState, regCountry, regCountryId, regCreditCardNo, regCreditCardType, regExpiryDate;
}

class Recipient extends Object implements Serializable
{
 String recpOrderNo, recpFirstName, recpLastName, recpAddress, recpCity, recpState, recpCountryCode, recpZipCode, recpPhone;
}

class OrderDetail extends Object implements Serializable
{
 String odOrderNo, odToyId, odQty, odGiftWrap, odWrapperId, odMessage, odToyCost;
}
	
public class ToyUniverse extends JApplet implements Runnable
{

 	JTabbedPane tb;
	JPanel regPanel;
	JPanel recpPanel;
	JPanel odPanel;
        JPanel welPanel;
	GridBagLayout gb;
	GridBagConstraints gbc;

	ImageIcon logoImage,logoImage1,logoImage2;

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
	JLabel regHeart;
        
        JButton submit;
        JButton reset;

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
	JLabel recpCountryCode;
	JLabel recpZipCode;
	JLabel recpPhone;
	JLabel recpHeart;
	
	JButton recpsubmit;
	JButton recpreset;

	JTextField textrecpOrderNo;
	JTextField textrecpFirstName;
	JTextField textrecpLastName;
	JTextField textrecpAddress;
	JTextField textrecpCity;
	JTextField textrecpState;
	JTextField textrecpCountryCode;
	JTextField textrecpZipCode;
	JTextField textrecpPhone;

	JLabel odOrderNo;
	JLabel odToyId;
	JLabel odQty;
	JLabel odGiftWrap;
	JLabel odWrapperId;
	JLabel odMessage;
	JLabel odToyCost;
        JLabel odHeart;

	JTextField textodOrderNo;
	JTextField textodToyId;
	JTextField textodQty;
	JComboBox comboodGiftWrap;
	JTextField textodWrapperId;
	JTextField textodMessage;
	JTextField textodToyCost;

	JButton odsubmit;
	JButton odreset;

	JLabel welMusicBox;
	JLabel welHeartBlank;
	JLabel welHeartBlank1;
        JLabel welAnimation;

	String welMessage[]={"Welcome","to the","World of Toys","Toy Universe"};
	int counter;
        Thread animationThread;

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
//change color
		regPanel.setBackground(Color.red);
		regPanel.setForeground(Color.black);
		recpPanel.setBackground(Color.red);
		recpPanel.setForeground(Color.black);
		odPanel.setBackground(Color.black);
		odPanel.setForeground(Color.red);
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

		welAnimation = new JLabel("  ");
  		Container content = getContentPane();
		JPanel welPanel = new JPanel();
		//welPanel.setLayout(new FlowLayout());
		//welPanel.add(welAnimation);
		welPanel.setBackground(Color.black);	
		content.add(welPanel);
		animationThread = new Thread(this);
		animationThread.start();	
		
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
		reset = new JButton("RESET");
		validateAction v=new validateAction();
		submit.addActionListener(v);
		validateAction va=new validateAction();
		reset.addActionListener(va);

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
		recpCountryCode = new JLabel("COUNTRY CODE");
		recpZipCode = new JLabel("ZIP CODE");
		recpPhone = new JLabel("PHONE");
		
		recpsubmit = new JButton("SUBMIT");
		recpreset = new JButton("RESET");
		validateAction v1=new validateAction();
		recpsubmit.addActionListener(v1);
		validateAction v1a=new validateAction();
		recpreset.addActionListener(v1a);

		textrecpOrderNo = new JTextField(5);	
		textrecpFirstName = new JTextField(15);
		textrecpLastName = new JTextField(15);
		textrecpAddress = new JTextField(15);
		textrecpCity = new JTextField(10);
		textrecpState = new JTextField(10);
		textrecpCountryCode = new JTextField(5);
		textrecpZipCode = new JTextField(10);
		textrecpPhone = new JTextField(10);

		odOrderNo = new JLabel("ORDER ID");
		odToyId = new JLabel("TOY ID");
		odQty = new JLabel("QUATITY");
		odGiftWrap = new JLabel("GIFTWRAP");
		odWrapperId = new JLabel("WRAPPER ID");
		odMessage = new JLabel("MESSAGE");
		odToyCost = new JLabel("TOY COST");

		textodOrderNo = new JTextField(5);
		textodToyId = new JTextField(5);
		textodQty = new JTextField(5);
		

                String wrap[] = {"YES","NO"};
		comboodGiftWrap = new JComboBox(wrap);
		textodWrapperId = new JTextField(5);
		textodMessage = new JTextField(15);
		textodToyCost = new JTextField(15);
		
		odsubmit = new JButton("SUBMIT");
               	odreset = new JButton("RESET");
		validateAction v2=new validateAction();
		odsubmit.addActionListener(v2);
                validateAction v2a=new validateAction();
		odreset.addActionListener(v2a);
		
		Icon logoImage = new ImageIcon("heart2.gif");
		odHeart = new JLabel(logoImage);
		recpHeart = new JLabel(logoImage);		
		regHeart = new JLabel(logoImage);
		
		Icon logoImage1 = new ImageIcon("heartblank.gif");
		Icon logoImage2 = new ImageIcon("musicbox.gif");
		welMusicBox = new JLabel(logoImage2);
		welHeartBlank = new JLabel(logoImage1);
		welHeartBlank1 = new JLabel(logoImage1);

//public void Welcome()
	   // {    
		gbc.gridx = 0;
		gbc.gridy = 0;
		gb.setConstraints(welHeartBlank,gbc);
		welPanel.add(welHeartBlank);

		
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = 1;
		gb.setConstraints(welMusicBox,gbc);
		welPanel.add(welMusicBox);
				
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = 0;
		gb.setConstraints(welHeartBlank1,gbc);
		welPanel.add(welHeartBlank1);

		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = 0;
		gb.setConstraints(welAnimation,gbc);
		welPanel.add(welAnimation);
          //  }     


//public void Registration()
         //   {    
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

		gbc.gridx = 0;
		gbc.gridy = 0;
		gb.setConstraints(regHeart,gbc);
		regPanel.add(regHeart);


		gbc.gridx = 5;
		gbc.gridy = 43;
		gb.setConstraints(reset,gbc);
		regPanel.add(reset);

          //  }                 
//public void Recipient()
        //    {    
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
		gb.setConstraints(recpCountryCode,gbc);
		recpPanel.add(recpCountryCode);

		gbc.gridx = 3;
		gbc.gridy = 20;
		gb.setConstraints(textrecpCountryCode,gbc);
		recpPanel.add(textrecpCountryCode);

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

		gbc.gridx = 0;
		gbc.gridy = 0;
		gb.setConstraints(recpHeart,gbc);
		recpPanel.add(recpHeart);

		gbc.gridx = 5;
		gbc.gridy = 29;
		gb.setConstraints(recpreset,gbc);
		recpPanel.add(recpreset);

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
         //   }    

//public void OrderDetail()
      //      {    
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
		gbc.gridy = 16;
		gb.setConstraints(odMessage,gbc);
		odPanel.add(odMessage);		

		gbc.gridx = 3;
		gbc.gridy = 16;
		gb.setConstraints(textodMessage,gbc);
		odPanel.add(textodMessage);		
		
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
		gbc.gridy = 23;
		gb.setConstraints(odreset,gbc);
		odPanel.add(odreset);				

		gbc.gridx = 5;
		gbc.gridy = 1;
		gb.setConstraints(label5,gbc);
		odPanel.add(label5);

		gbc.gridx = 5;
		gbc.gridy = 3;
		gb.setConstraints(label6,gbc);
		odPanel.add(label6);

		//gbc.anchor = GridBagConstraints.SOUTHEAST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gb.setConstraints(odHeart,gbc);
		odPanel.add(odHeart);
          //  }    

		tb.addTab("WELCOME",null,welPanel,"WELCOME TO TOY UNIVERSE");
		tb.addTab("SHOPPER",null,regPanel,"ENTER YOUR DETAILS");
		tb.addTab("RECIPIENT",null,recpPanel,"ENTER RECIPIENT DETAILS");
		tb.addTab("ORDER DETAILS",null,odPanel,"ENTER YOUR ORDER DETAILS");
		
		getContentPane().add(tb);
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

		if(obj == reset)	
		{
			textregShopperId.setText(" "); 
			textregPassword.setText(" ");
			textregFirstName.setText(" ");
			textregLastName.setText(" ");
			textregEmail.setText(" ");
			textregAddress.setText(" ");
			textregCity.setText(" ");
			textregState.setText(" ");
			textregCountryId.setText(" ");
			textregCreditCardNo.setText(" ");
			textregCreditCardType.setText(" ");
			textregExpiryDate.setText(" ");
		}
		try
		{
		Socket s = new Socket("192.168.16.2",2020);
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		Registration r = new Registration();
		r.regShopperId=textregShopperId.getText();
		r.regPassword=textregPassword.getText();
		r.regFirstName=textregFirstName.getText();
		r.regLastName=textregLastName.getText();
		r.regAddress=textregAddress.getText();
		r.regEmail=textregEmail.getText();
		r.regCity=textregCity.getText();
		r.regState=textregState.getText();
		r.regCountry=textregCountry.getText();
		r.regCountryId=textregCountryId.getText();
		r.regCreditCardNo=textregCreditCardNo.getText();
		r.regCreditCardType=textregCreditCardType.getText();
		r.regExpiryDate=textregExpiryDate.getText();
		oos.writeObject((Registration)r);
		oos.close();
System.out.println("Registration detais sent");
		}
		catch(Exception e1)
		{
		showStatus("ERROR SENDING DATA");
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
			String country = textrecpCountryCode.getText();
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
		if(obj == recpreset)
		{
			textrecpOrderNo.setText(" ");
			textrecpFirstName.setText(" ");
			textrecpLastName.setText(" ");
			textrecpAddress.setText(" ");
			textrecpCity.setText(" ");
			textrecpState.setText(" ");
			textrecpCountryCode.setText(" ");
			textrecpZipCode.setText(" ");
			textrecpPhone.setText(" ");			
		}

else
			{
				getAppletContext().showStatus("");

			 try
			{
			Socket s = new Socket("192.168.16.2",2020);
			ObjectOutputStream oos0 = new ObjectOutputStream(s.getOutputStream());
			Recipient r1 = new Recipient();
			r1.recpOrderNo=textrecpOrderNo.getText();
			r1.recpFirstName=textrecpFirstName.getText();
			r1.recpLastName=textrecpLastName.getText();
			r1.recpAddress=textrecpAddress.getText();
			r1.recpCity=textrecpCity.getText();
			r1.recpState=textrecpState.getText();
			r1.recpCountryCode=textrecpCountryCode.getText();
			r1.recpZipCode=textrecpZipCode.getText();
			r1.recpPhone=textrecpPhone.getText();
			oos0.writeObject((Recipient)r1);
			oos0.close();
System.out.println("Recipient data Sent");

			}
			catch(Exception e1)
			{
			showStatus("ERROR SENDING DATA TO THE DATA BASE");
			}

}//else
}//if
		

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

		if(obj == odreset)
		{
			textodOrderNo.setText(" ");
			textodToyId.setText(" ");
			textodQty.setText(" ");
			textodWrapperId.setText(" ");
			textodMessage.setText(" ");
			textodToyCost.setText(" ");			
		}
else
{

			try
		{
		Socket s = new Socket("192.168.16.2",2020);
		ObjectOutputStream oos1 = new ObjectOutputStream(s.getOutputStream());
		OrderDetail r2 = new OrderDetail();
		r2.odOrderNo=textodOrderNo.getText();
		r2.odToyId=textodToyId.getText();
		r2.odQty=textodQty.getText();
		r2.odGiftWrap=(String)comboodGiftWrap.getSelectedItem();	
		r2.odWrapperId=textodWrapperId.getText();
		r2.odToyCost=textodToyCost.getText();
		r2.odMessage=textodMessage.getText();
		oos1.writeObject((OrderDetail)r2);
		oos1.close();
System.out.println("Order Details Sent to the Server");
		}
		catch(Exception e1)
		{
		showStatus("ERROR SENDING DATA");
		}

}//else
}
}//act
}//val

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
		for(;;)
 		{
			displayWelcome();
			try
			{
				animationThread.sleep(1000);
			}	
			catch(InterruptedException e)
			{
				showStatus("thread interrupted");
			}
		}
	
	}

public void display()
	{
		date= new Date();
		calendar = new GregorianCalendar();
		calendar.setTime(date);
		strTime = calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
		strDate = calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.YEAR);
		strStatus = strTime;
		strStatus1 = strDate;
 		label1.setText(strStatus);
		label3.setText(strStatus1);
		label2.setText(strStatus);
		label4.setText(strStatus1);
		label5.setText(strStatus);
		label6.setText(strStatus1);
	
	}

public void displayWelcome()
        {
		
		
		Font font = new Font("Times Roman", Font.BOLD,12);
 		welAnimation.setFont(font);
		welAnimation.setText(welMessage[counter]);       
		counter++;
		if(counter>=4)
		{
			counter=0;
		}	
		
	}
public void paint(Graphics g)
{

 Font myFont = new Font("SuperFrench", Font.BOLD + Font.ITALIC,14);
 g.setFont(myFont);	
 g.drawString("Welcome to Toy Universe - The World of Toys",100,100);

}


}
