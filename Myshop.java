import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.*;
import java.io.*;
import java.net.*;

class Registration extends Object implements Serializable
{
	String Name,Address,City,State,Country,Registration,Password,Bankname,Accountno;
}

class Shopper extends Object implements Serializable
{
	String shopperid1,password1,confirmpassword1,firstname1,lastname1,address1,phone1,emailid1,country1,countryid1,state1,city1,zipcode1,creditcardno1,creditcardtype1,creditcardexpirydate1;
}

class Recipient extends Object implements Serializable
{
	String orderno2,firstname2,lastname2,address2,city2,state2,country2,countrycode2,zipcode2,phone2;
}

class Shopping extends Object implements Serializable
{
	String name3,address3,city3,state3,country3,registrationno3,password3,code3,itemname3,quantity3,itemprice3,totalprice3,bankname3,accountno3;
}

public class Myshop extends JApplet implements Runnable

{
JPanel p;
JPanel p3;
JPanel p1;
JPanel p2;
JPanel panel;

ImageIcon i,i1,i2,i3,i4,i5;

//adding control to p
	JLabel labela;
	JLabel labelb;
	JLabel labelc;

//ading control to p3
	JLabel labelName;
	JLabel labelAddress;
	JLabel labelCity;
	JLabel labelState;
	JLabel labelCountry;
	JLabel labelRegistration_no;
	JLabel labelPassword;
	JLabel labelBankName;
	JLabel labelAccount_no;
	
	JTextField textName;
	JTextField textAddress;
	JComboBox comboCity;
	JComboBox comboState;
	JComboBox comboCountry;
	JTextField textRegistration_no;
	JPasswordField textPassword;
	JTextField textBankName;
	JTextField textAccount_no;
	JButton b9,b10,b11;


//adding control to p1;
	
	
	JLabel labelShopperId1;
	JLabel labelPassword1;	
 	JLabel labelConfirmpassword1;
    	JLabel labelFirstName1;
	JLabel labelLastName1;
        JLabel labelAddress1;
        JLabel labelPhone1;
	JLabel labelEmailId1;
  	JLabel labelCountry1;
	JLabel labelCountryId1;
  	JLabel labelState1;
	JLabel labelCity1;
	JLabel labelZipcode1;
	JLabel labelCreditcardno1;
	JLabel labelCreditcardtype1;
	JLabel labelCreditcardExpirydate1;
	

       
	JTextField textShopperId1;
      	JPasswordField textPassword1;
  	JPasswordField textConfirmpassword1;
        JTextField textFirstName1;
        JTextField textLastName1;
   	JTextField textAddress1;
      	JTextField textPhone1;
 	JTextField textEmailId1;
	JTextField textCountry1;
        JTextField textCountryId1;
	JTextField textState1;
        JTextField textCity1;
	JTextField textZipcode1;
	JTextField textCreditcardno1;
	JTextField textCreditcardtype1;
 	JTextField textCreditcardExpirydate1;

//adding controls to  the p2
	JLabel l;
	JLabel labelRecOrderno2;
	JLabel labelRecFirstName2;
	JLabel labelRecLastName2;
	JLabel labelRecAddress2;
	JLabel labelRecCity2;
	JLabel labelRecState2;
	JLabel labelRecCountry2;
	JLabel labelRecCountrycode2;
	JLabel labelRecZipcode2;
	JLabel labelRecPhone2;
	JLabel l1;
	JLabel l2;

	JTextField textRecOrderno2;
	JTextField textRecFirstName2;
	JTextField textRecLastName2;
	JTextField textRecAddress2;
	JTextField textRecCity2;
	JTextField textRecState2;
	JTextField textRecCountry2;
	JTextField textRecCountrycode2;
	JTextField textRecZipcode2;
	JTextField textRecPhone2;

//adding controlto panel


	JLabel labelName3;
	JLabel labelAddress3;
	JLabel labelCity3;
	JLabel labelState3;
	JLabel labelCountry3;
	JLabel labelRegistration_no3;
	JLabel labelPassword3;
	JLabel labelItemCode3;
	JLabel labelItemName3;
	JLabel labelQuantity3;
	JLabel labelItemPrice3;
	JLabel labelTotalprice3;
	JLabel labelBankName3;
	JLabel labelAccount_no3;
	
	JTextField textName3;
	JTextField textAddress3;
	JComboBox comboCity3;
	JComboBox comboState3;
	JComboBox comboCountry3;
	JTextField textRegistration_no3;
	JPasswordField textPassword3;
	JTextField textItemCode3;
	JTextField textItemName3;
	JTextField intQuantity3;
	JTextField intItemPrice3;
	JTextField intTotalprice3;
	JTextField textBankName3;
	JTextField textAccount_no3;
	JButton b6,b7,b8;


	GridBagLayout gl;
	GridBagConstraints gbc;

	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;

	//declare thread variable
	Thread datetimeThread;
	//Thread animationThread;
	//declare date
	Date date;
	//declare gregcalendar
	GregorianCalendar calendar;
	//declare string variable to store daata on status bar
	String strDate,strTime,strStatus;

	public void init()
	{
		createAppletContent();
	}
	public void createAppletContent()
	{
	
		i=new ImageIcon("boy.gif");
		i1=new ImageIcon("babylaugh.gif");
		i2=new ImageIcon("Cat.gif");
		i3=new ImageIcon("welcome.gif");
		i4=new ImageIcon("123.gif");
		i5=new ImageIcon("monkey.gif");	

	
		Container content = getContentPane();
		content.setLayout(new GridLayout());
		JTabbedPane tabbedPane = new JTabbedPane();

		content.add(tabbedPane);
//initializing p
		labela = new JLabel(i5);
		labelb = new JLabel(i4);
		labelc = new JLabel(i3);

//INITIALIZING P3

		labelName = new JLabel("Full Name :");
		labelAddress = new JLabel("Address :");
		labelCity = new JLabel("City :");
		labelState = new JLabel("State :");
		labelCountry= new JLabel("Country :");
		labelRegistration_no = new JLabel("RegistrationNo :");
		labelPassword = new JLabel("Password :");
		labelBankName = new JLabel("Bank Name :");
		labelAccount_no = new JLabel("AccountNo :");


		textName = new JTextField(20);
		textAddress =new JTextField(25);
		String City[] = {"MUMBAI","DELHI","LAHORE","KABUL","COLOMBO","CAIRO","WASHINGTON","COLCUTTA","CHENNAI","LAHORE","BANGLORE","FRANCE"};
		comboCity = new JComboBox(City);
		comboCity.setMaximumRowCount(4);
	
		String State[] = {"MAHARASHTRA","KERALA","ANDHRA-PRADESH","RAJASTHAN","KASHMIR","ORRISA","WEST BENGAL","MADHYA PRADESH","UTTAR PRADESH","MAIPUR","MEGHALAYA","WESTBENGAL","TAMILNADU","BIHAR","KARNATAKA","ASSAM"};
		comboState = new JComboBox(State);
		comboState.setMaximumRowCount(4);

		String Country[] = {"INDIA","TIBET","SRI LANKA","EGYPT","INDONASIA","MALAYSIA","FRANCE","PAKISTHAN","CHINA","CHILE","TIBET","U.K","ARGENTINA"};
		comboCountry =new JComboBox(Country);
		comboCountry.setMaximumRowCount(4);

		textRegistration_no = new JTextField(20);
 		textPassword = new JPasswordField(10);
		textBankName = new JTextField(15);
		textAccount_no=new JTextField(10);

		b9 = new JButton("ACCEPT");
		validateAction accept=new validateAction();
		b9.addActionListener(accept);

		b10 = new JButton("OK");

		b11 = new JButton("CLEAR");
		validateAction clear=new validateAction();
		b11.addActionListener(clear);

	

//INITALIZING P1
	
		labelShopperId1 = new JLabel("Shopper ID");
                labelPassword1 = new JLabel("Password");
		labelConfirmpassword1 = new JLabel("Confirm Password");
		labelFirstName1 = new JLabel("FirstName");
		labelLastName1 = new JLabel("LastName");
 		labelAddress1 = new JLabel("Address");
	   	labelPhone1 = new JLabel("Phone");
		labelEmailId1 = new JLabel("Email-Id");
		labelCountry1 = new JLabel("Country");
		labelCountryId1 = new JLabel ("Country Id");
                labelState1 = new JLabel("State");
       		labelCity1 = new JLabel ("City");
		labelZipcode1 = new JLabel("Zip Code");
		labelCreditcardno1 = new JLabel("Credit Card No.");
		labelCreditcardtype1 = new JLabel("Credit Card Type");
  		labelCreditcardExpirydate1 = new JLabel ("Credit Card Expiry Date");
		 
                textShopperId1 = new JTextField(10);
		//textShopperId.addActionListener(this);

		textPassword1 = new JPasswordField(10);
		//textPassword.addActionListener(this);

		textConfirmpassword1 = new JPasswordField(10);
		//textConfirmpassword.addActionListener(this);

		textFirstName1 = new JTextField(20);
		//textFirstName.addActionListener(this);

		textLastName1 = new JTextField(20);
		//textLastName.addActionListener(this);

		textAddress1 = new JTextField(30);
		//textAddress.addActionListener(this);

 		textPhone1 = new JTextField(7);
		//textPhone.addActionListener(this);

		textEmailId1 = new JTextField(15);
		//textEmailId.addActionListener(this);

		textCountry1 = new JTextField(10);
		//textCountry.addActionListener(this);

		textCountryId1 = new JTextField(10);
		//textCountryId.addActionListener(this);

		textState1 = new JTextField(10);
		//textState.addActionListener(this);

		textCity1 = new JTextField(10);
		//textCity.addActionListener(this);

 		textZipcode1 = new JTextField(7);
		//textZipcode.addActionListener(this);

		textCreditcardno1 = new JTextField(16);
		//textCreditcardno.addActionListener(this);

		textCreditcardtype1  = new JTextField(15);
		//textCreditcardtype.addActionListener(this);

		textCreditcardExpirydate1 = new JTextField(9);
		//textCreditcardExpirydate.addActionListener(this);


// initialisation -recipient
		l = new JLabel(i);
		labelRecOrderno2 = new JLabel(" Order Number ");
		labelRecFirstName2 = new JLabel("FirstName");
		labelRecLastName2 = new JLabel ("LastName");
		labelRecAddress2 = new JLabel ("Address");
		labelRecCity2 = new JLabel ("City");
		labelRecState2 = new JLabel("State");
		labelRecCountry2 = new JLabel("Country");
		labelRecCountrycode2 = new JLabel (" Country Code");
		labelRecZipcode2 = new JLabel ("Zip Code");
		labelRecPhone2 =new JLabel (" Phone");
		l1 = new JLabel(i1);
		l2 = new JLabel(i2);	

		textRecOrderno2 = new JTextField(5);
		//textRecOrderno.addActionListener(this);

		textRecFirstName2 = new JTextField(10);
		//textRecFirstName.addActionListener(this);

		textRecLastName2 = new JTextField(10);
		//textRecLastName.addActionListener(this);

		textRecAddress2 = new JTextField(30);
		//textRecAddress.addActionListener(this);

		textRecCity2 = new JTextField(10);
		//textRecCity.addActionListener(this);

		textRecState2 = new JTextField(10);
		//textRecState.addActionListener(this);


		textRecCountry2 = new JTextField(10);

		textRecCountrycode2 = new JTextField(5);
		//textRecCountrycode.addActionListener(this);

		textRecZipcode2 = new JTextField(7);
		//textRecZipcode.addActionListener(this);

		textRecPhone2 = new JTextField(7);
		//textRecPhone.addActionListener(this);

		b1=new JButton("Accept");
		//b1.addActionListener(this);

		b2 = new JButton ("Clear");
		//b2.addActionListener(this);

		b3 = new JButton ("OK");
		//b3.addActionListener(this);

		b4 = new JButton ("Clear");
		//b4.addActionListener(this);

		b5 = new JButton ("Accept");
		//b5.addActionListener(this);


		gl = new GridBagLayout();
 		gbc = new GridBagConstraints();

//initializing shopping panel

	labelName3 = new JLabel("Name :");
	labelAddress3 = new JLabel("Address :");
	labelCity3 = new JLabel("City :");
	labelState3 = new JLabel("State :");
	labelCountry3= new JLabel("Country :");
	labelRegistration_no3 = new JLabel("RegistrationNo :");
	labelPassword3 = new JLabel("Password :");
	labelItemCode3 = new JLabel("ItemCode :");
	labelItemName3 = new JLabel("ItemName :");
	labelQuantity3 = new JLabel("Quantity Purchased :");
	labelItemPrice3 = new JLabel("ItemPrice per unit :");
	labelTotalprice3 = new JLabel("Amount Payable :");
	labelBankName3 = new JLabel("Bank Name :");
	labelAccount_no3 = new JLabel("AccountNo :");
	

	textName3 = new JTextField(15);
	textAddress3 =new JTextField(18);
	String City3[] = {"MUMBAI","DELHI","COLCUTTA","CHENNAI","LAHORE","BANGLORE","FRANCE"};
	comboCity3 = new JComboBox(City3);
	comboCity3.setMaximumRowCount(3);

	String State3[] = {"MAHARASHTRA","KERALA","WESTBENGAL","TAMILNADU","BIHAR","KARNATAKA","ASSAM"};
	comboState3 = new JComboBox(State3);
	comboState3.setMaximumRowCount(3);

	String Country3[] = {"INDIA","PAKISTHAN","CHINA","CHILE","TIBET","U.K","ARGENTINA"};
	comboCountry3 =new JComboBox(Country3);
	comboCountry3.setMaximumRowCount(3);

	textRegistration_no3 = new JTextField(20);
 	textPassword3 = new JPasswordField(10);
	textItemCode3 = new JTextField(5);
	textItemName3 = new JTextField(20);
	intQuantity3 = new JTextField(5);
	intTotalprice3 = new JTextField(6);
	intTotalprice3.setEnabled(false);
	intItemPrice3 = new JTextField(5);
	textBankName3 = new JTextField(15);
	textAccount_no3=new JTextField(10);

	b6 = new JButton("ACCEPT");
	validateAction vz = new validateAction();
	b6.addActionListener(vz);
	

	b7 = new JButton("OK");

	b8 = new JButton("CLEAR");
	validateAction vx = new validateAction();
	b8.addActionListener(vx);

		
		p=new JPanel();
		welcome();
		
		p3=new JPanel();
		registrationform();

		p1 = new JPanel();
		shopper();

		p2= new JPanel();
		recipient();
		
		panel=new JPanel();
		shopping();


		tabbedPane.addTab("Welcome",null,p,"welcome");
		tabbedPane.addTab("Registration Form",null,p3,"registrationform");
        	tabbedPane.addTab("Shopper Details",null,p1,"ShopperDetails");
                tabbedPane.addTab("Recipient Details",null,p2,"RecipientDetails");
                tabbedPane.addTab("Go Shopping ",null,panel,"goshopping");
}// end of createAppletContent embedded in init()

public void welcome()
{
		p.setBackground(Color.black );

		p.setLayout(gl);
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		gbc.gridx =-90;			
		gbc.gridy =-100;
		gl.setConstraints(labela,gbc);
                p.add (labela);

		p.setLayout(gl);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 100;			
		gbc.gridy = 90;
		gl.setConstraints(labelb,gbc);
                p.add (labelb);
		
		p.setLayout(gl);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;			
		gbc.gridy = -90;
		gl.setConstraints(labelc,gbc);
                p.add (labelc);

}// end for welcome
public void registrationform()
{
		p3.setLayout(gl);
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gl.setConstraints(labelName,gbc);
		p3.add(labelName);
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 2;
		gl.setConstraints(textName,gbc);
		p3.add(textName);

		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 5;
		gl.setConstraints(labelAddress,gbc);
		p3.add(labelAddress);
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 5;
		gl.setConstraints(textAddress,gbc);
		p3.add(textAddress);
	
	
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 8;
		gl.setConstraints(labelCity,gbc);
		p3.add(labelCity);
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 8;
		gl.setConstraints(comboCity,gbc);
		p3.add(comboCity);
	
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 11;
		gl.setConstraints(labelState,gbc);
		p3.add(labelState);

		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 11;
		gl.setConstraints(comboState,gbc);
		p3.add(comboState);

		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 14;
		gl.setConstraints(labelCountry,gbc);
		p3.add(labelCountry);
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 14;
		gl.setConstraints(comboCountry,gbc);
		p3.add(comboCountry);

		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 17;
		gl.setConstraints(labelRegistration_no,gbc);
		p3.add(labelRegistration_no );
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 17;
		gl.setConstraints(textRegistration_no,gbc);
		p3.add(textRegistration_no );
	
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 20;
		gl.setConstraints(labelPassword,gbc);
		p3.add(labelPassword);
        	gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 20;
		gl.setConstraints(textPassword,gbc);
		p3.add(textPassword);

	
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 38;
		gl.setConstraints(labelBankName,gbc);
		p3.add(labelBankName);
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 38;
		gl.setConstraints(textBankName,gbc);
		p3.add(textBankName);
	
	
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 41;
		gl.setConstraints(labelAccount_no,gbc);
		p3.add(labelAccount_no);
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 41;
		gl.setConstraints(textAccount_no,gbc);
		p3.add(textAccount_no);
	
		gbc.anchor =GridBagConstraints.SOUTHEAST;
		gbc.gridx = 8;
		gbc.gridy = 90;
		gl.setConstraints(b9,gbc);
		p3.add(b9);
		
		gbc.anchor =GridBagConstraints.SOUTHEAST;
		gbc.gridx = 11;
		gbc.gridy = 90;
		gl.setConstraints(b10,gbc);
		p3.add(b10);
	
		gbc.anchor =GridBagConstraints.SOUTHEAST;
		gbc.gridx = 14;
		gbc.gridy = 90;
		gl.setConstraints(b11,gbc);
		p3.add(b11);	
}

public void shopper()
{
		//p1.setBackground(Color.blue );
	


		p1.setLayout(gl);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 5;
		gl.setConstraints(labelShopperId1,gbc);
                p1.add (labelShopperId1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 5;
		gl.setConstraints(textShopperId1,gbc);
		p1.add (textShopperId1);


		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 8;
		gl.setConstraints(labelPassword1,gbc);
		p1.add(labelPassword1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 8;
		gl.setConstraints(textPassword1,gbc);
		p1.add(textPassword1);


		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 11;
		gl.setConstraints(labelConfirmpassword1,gbc);
  		p1.add(labelConfirmpassword1);

 		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 11;
		gl.setConstraints(textConfirmpassword1,gbc);
		p1.add(textConfirmpassword1);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy= 14;
		gl.setConstraints(labelFirstName1,gbc);
		p1.add(labelFirstName1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy =14;
		gl.setConstraints(textFirstName1,gbc);
		p1.add(textFirstName1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy =17;
		gl.setConstraints(labelLastName1,gbc);
		p1.add(labelLastName1);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy =17;
		gl.setConstraints(textLastName1,gbc);
		p1.add(textLastName1);
 
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy =20;
		gl.setConstraints(labelAddress1,gbc);
                p1.add(labelAddress1);

 		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy =20;
		gl.setConstraints(textAddress1,gbc);
		p1.add(textAddress1);


		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy =23;
		gl.setConstraints(labelPhone1,gbc);
		p1.add(labelPhone1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy =23;
		gl.setConstraints(textPhone1,gbc);
		p1.add(textPhone1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy =26;
		gl.setConstraints(labelEmailId1,gbc);
         	p1.add(labelEmailId1);
	
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy =26;
		gl.setConstraints(textEmailId1,gbc);
		p1.add(textEmailId1);
 
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy =32;
		gl.setConstraints(labelCountry1,gbc);
		p1.add(labelCountry1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy =32;
		gl.setConstraints(textCountry1,gbc);
		p1.add(textCountry1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy =35;
		gl.setConstraints(labelCountryId1,gbc);
 		p1.add(labelCountryId1);
	
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy =35;
		gl.setConstraints(textCountryId1,gbc);
		p1.add(textCountryId1);


		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx =1;
		gbc.gridy =38;
		gl.setConstraints(labelState1,gbc);
  		p1.add(labelState1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy =38;
		gl.setConstraints(textState1,gbc);
		p1.add(textState1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy =41;
		gl.setConstraints(labelCity1,gbc); 
		p1.add(labelCity1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy =41;
		gl.setConstraints(textCity1,gbc);
		p1.add(textCity1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx =1;
		gbc.gridy =44;
		gl.setConstraints(labelZipcode1,gbc);
		p1.add(labelZipcode1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx=4;
		gbc.gridy=44;
		gl.setConstraints(textZipcode1,gbc);
		p1.add(textZipcode1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy =47;
		gl.setConstraints(labelCreditcardno1,gbc);
		p1.add(labelCreditcardno1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 4;
		gbc.gridy = 47;
		gl.setConstraints(textCreditcardno1,gbc);
		p1.add(textCreditcardno1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 50;
		gl.setConstraints(labelCreditcardtype1,gbc);
		p1.add(labelCreditcardtype1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx= 4;
		gbc.gridy = 50;
		gl.setConstraints(textCreditcardtype1,gbc);
		p1.add(textCreditcardtype1);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 1;
		gbc.gridy = 53;
		gl.setConstraints(labelCreditcardExpirydate1,gbc);
		p1.add(labelCreditcardExpirydate1);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx=4;
		gbc.gridy=53;
		gl.setConstraints(textCreditcardExpirydate1,gbc);
		p1.add(textCreditcardExpirydate1);

		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.gridx = 9;
		gbc.gridy = 57;
		gl.setConstraints(b1,gbc);
		p1.add(b1);
		validateAction vb = new validateAction();
		b1.addActionListener(vb);

	

		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.gridx = 18;
		gbc.gridy = 57;
		gl.setConstraints(b2,gbc);
		p1.add(b2);
		validateAction v = new validateAction();
		b2.addActionListener(v);

		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.gridx = 13;
		gbc.gridy = 57;
		gl.setConstraints(b3,gbc);
		p1.add(b3);

	 datetimeThread = new Thread(this);
    	 datetimeThread.start();
}  
  public void run()
{ 
    while (datetimeThread != null)
    {
       display();
       try
       {
       datetimeThread.sleep(1000);
       }
       catch(InterruptedException e)
	{
	showStatus("Thread Interrupted");
	}        
    }//end for while loop  			
}//end for run
public void display()
{
  date = new Date();
  calendar = new GregorianCalendar();
  calendar.setTime(date);
  strTime = calendar.get(Calendar.HOUR)+ ": "+calendar.get(Calendar.MINUTE)+": " + calendar.get(Calendar.SECOND);
  strDate = calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DATE)+"/"+calendar.get(Calendar.YEAR);
  strStatus = strTime+"      "+strDate;
  showStatus(strStatus);
}


	


	
	   		
//position tor recipient
	public void recipient()
	{
		//p2.setBackground(Color.blue);

		p2.setLayout(gl);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
         	gbc.gridy = -5;
		gl.setConstraints(l,gbc);
		p2.add(l);

		p2.setLayout(gl);
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
         	gbc.gridy = 5;
		gl.setConstraints(labelRecOrderno2,gbc);
		p2.add(labelRecOrderno2);

   		
		gbc.anchor =GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 5;
		gl.setConstraints(textRecOrderno2,gbc);
		p2.add(textRecOrderno2);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 8;
		gl.setConstraints(labelRecFirstName2,gbc);
		p2.add(labelRecFirstName2);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 8;
  		gl.setConstraints(textRecFirstName2,gbc);
		p2.add(textRecFirstName2);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 11;
		gl.setConstraints(labelRecLastName2,gbc);
		p2.add(labelRecLastName2);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 11;
		gl.setConstraints(textRecLastName2,gbc);
		p2.add(textRecLastName2);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 14;
		gl.setConstraints(labelRecAddress2,gbc);
		p2.add(labelRecAddress2);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 14;
		gl.setConstraints(textRecAddress2,gbc);
		p2.add(textRecAddress2);

	
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 20;
		gl.setConstraints(labelRecCity2,gbc);
		p2.add(labelRecCity2);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 20;
		gl.setConstraints(textRecCity2,gbc);
		p2.add(textRecCity2);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 23;
		gl.setConstraints(labelRecState2,gbc);
		p2.add(labelRecState2);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 23;
		gl.setConstraints(textRecState2,gbc);
		p2.add(textRecState2);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 26;
		gl.setConstraints(labelRecCountry2,gbc);
		p2.add(labelRecCountry2);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 26;
		gl.setConstraints(textRecCountry2,gbc);
		p2.add(textRecCountry2);

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 29;
		gl.setConstraints(labelRecCountrycode2,gbc);
		p2.add(labelRecCountrycode2);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 29;
		gl.setConstraints(textRecCountrycode2,gbc);
		p2.add(textRecCountrycode2);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx =  0;
		gbc.gridy = 32;
		gl.setConstraints(labelRecZipcode2,gbc);
		p2.add(labelRecZipcode2);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 32;
		gl.setConstraints(textRecZipcode2,gbc);
		p2.add(textRecZipcode2);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 0;
		gbc.gridy = 35;
		gl.setConstraints(labelRecPhone2,gbc);
		p2.add(labelRecPhone2);
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.gridx = 3;
		gbc.gridy = 35;
		gl.setConstraints(textRecPhone2,gbc);
		p2.add(textRecPhone2);
				

		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.gridx = 12;
		gbc.gridy = 38;
		gl.setConstraints(b4,gbc);
		p2.add(b4);
		validateAction vc = new validateAction();
                b4.addActionListener(vc);

	
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.gridx = 8;
		gbc.gridy = 38;
		gl.setConstraints(b5,gbc);
		p2.add(b5);
		validateAction vd = new validateAction();
                b5.addActionListener(vd);

		gbc.anchor = GridBagConstraints.SOUTHWEST;
		gbc.gridx = 11;
		gbc.gridy = -5;
		gl.setConstraints(l1,gbc);
		p2.add(l1);
		
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		gbc.gridx = 14;
		gbc.gridy =40;
		gl.setConstraints(l2,gbc);
		p2.add(l2);
}
public void shopping()
{

	panel.setLayout(gl);
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 2;
	gl.setConstraints(labelName3,gbc);
	panel.add(labelName3);
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 2;
	gl.setConstraints(textName3,gbc);
	panel.add(textName3);

	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 5;
	gl.setConstraints(labelAddress3,gbc);
	panel.add(labelAddress3);
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 5;
	gl.setConstraints(textAddress3,gbc);
	panel.add(textAddress3);


	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 8;
	gl.setConstraints(labelCity3,gbc);
	panel.add(labelCity3);
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 8;
	gl.setConstraints(comboCity3,gbc);
	panel.add(comboCity3);
	
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 11;
	gl.setConstraints(labelState3,gbc);
	panel.add(labelState3);

	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 11;
	gl.setConstraints(comboState3,gbc);
	panel.add(comboState3);

	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 14;
	gl.setConstraints(labelCountry3,gbc);
	panel.add(labelCountry3);
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 14;
	gl.setConstraints(comboCountry3,gbc);
	panel.add(comboCountry3);

	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 17;
	gl.setConstraints(labelRegistration_no3,gbc);
	panel.add(labelRegistration_no3 );
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 17;
	gl.setConstraints(textRegistration_no3,gbc);
	panel.add(textRegistration_no3 );

	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 20;
	gl.setConstraints(labelPassword3,gbc);
	panel.add(labelPassword3);
        gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 20;
	gl.setConstraints(textPassword3,gbc);
	panel.add(textPassword3);

	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 23;
	gl.setConstraints(labelItemCode3,gbc);
	panel.add(labelItemCode3);
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 23;
	gl.setConstraints(textItemCode3,gbc);
	panel.add(textItemCode3);

	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 26;
	gl.setConstraints(labelItemName3,gbc);
	panel.add(labelItemName3 );
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 26;
	gl.setConstraints(textItemName3,gbc);
	panel.add(textItemName3);

 	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 29;
	gl.setConstraints(labelQuantity3,gbc);
	panel.add(labelQuantity3);
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 29;
	gl.setConstraints(intQuantity3,gbc);
	panel.add(intQuantity3 );


	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 32;
	gl.setConstraints(labelItemPrice3,gbc);
	panel.add(labelItemPrice3);
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 32;
	gl.setConstraints(intItemPrice3,gbc);
	panel.add(intItemPrice3);

	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 35;
	gl.setConstraints(labelTotalprice3,gbc);
	panel.add(labelTotalprice3);
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 35;
	gl.setConstraints(intTotalprice3,gbc);
	panel.add(intTotalprice3);

	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 38;
	gl.setConstraints(labelBankName3,gbc);
	panel.add(labelBankName3);
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 38;
	gl.setConstraints(textBankName3,gbc);
	panel.add(textBankName3);


	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 1;
	gbc.gridy = 41;
	gl.setConstraints(labelAccount_no3,gbc);
	panel.add(labelAccount_no3);
	gbc.anchor =GridBagConstraints.NORTHWEST;
	gbc.gridx = 4;
	gbc.gridy = 41;
	gl.setConstraints(textAccount_no3,gbc);
	panel.add(textAccount_no3);
	
	gbc.anchor =GridBagConstraints.SOUTHEAST;
	gbc.gridx = 8;
	gbc.gridy = 90;
	gl.setConstraints(b6,gbc);
	panel.add(b6);

	gbc.anchor =GridBagConstraints.SOUTHEAST;
	gbc.gridx = 11;
	gbc.gridy = 90;
	gl.setConstraints(b7,gbc);
	panel.add(b7);
	
	gbc.anchor =GridBagConstraints.SOUTHEAST;
	gbc.gridx = 14;
	gbc.gridy = 90;
	gl.setConstraints(b8,gbc);
	panel.add(b8);

        	
}
	class validateAction implements ActionListener
			{

public void actionPerformed(ActionEvent evt)
	{

	Object objt = evt.getSource();
	if(objt==b9)
	{
		String Name = textName.getText();
			if (Name.length() == 0 )
			{
				getAppletContext().showStatus("NAME CANNOT BE EMPTY");
				return;
			}
		String Address = textAddress.getText();
			if (Address.length()==0)
			{
				showStatus("ADDRESS CANNOT BE EMPTY");
				return;
			}
		String Registration_no = textRegistration_no.getText();
			if (Registration_no.length()==0)
			{
				showStatus("ENTER REGISTRATION NUMBER");
				return;
			}
		String Password = textPassword.getText();
			if (Password.length()==0)
			{       showStatus("ENTER PASSWORD");
				return;
			}
		String BankName = textBankName.getText();
			if (BankName.length()<=5)
			{
				showStatus(" NO SHORT FORM ALLOWED ENTER CORRECT BANK NAME");
				return;
			}	
		String Account_no = textAccount_no.getText();
			if (Account_no.length()==0)
			{
				showStatus("ENTER ACCOUNT NUMBER");
				return;
			}
		   try
		{
		Socket s = new Socket("192.168.16.2",1818);
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		Registration r = new Registration();
		r.Name=textName.getText();
		r.Address=textAddress.getText();
		r.City=(String)comboCity.getSelectedItem();
		r.State=(String)comboState.getSelectedItem();
		r.Country=(String)comboCountry.getSelectedItem();
		r.Registration=textRegistration_no.getText();
		r.Password=textPassword.getText();
		r.Bankname=textBankName.getText();
		r.Accountno=textAccount_no.getText();
		oos.writeObject((Registration)r);
		}
		catch(Exception e)
		{
		showStatus("ERROR SENDING DATA");
		}
		
	}
		if (objt==b11)
		{
		showStatus("CLEAR");
	
		textName.setText("");

		textAddress.setText("");

		textRegistration_no.setText("");

		textPassword.setText("");

		textBankName.setText("");

		textAccount_no.setText("");
	}
	
		Object obj = evt.getSource();
		if(objt==b1)
		{
			String ShopperId = textShopperId1.getText();
			if(ShopperId.length()== 0)
			{
				getAppletContext().showStatus("ShopperId Cannot be empty");
				return;
			}
			String Password = textPassword1.getText();
			if (Password.length()<=4)
			{
				getAppletContext().showStatus("Password cannot be less than four character");
				return;
			}
			
			
			String Confirmpassword = textConfirmpassword1.getText();
			if (Confirmpassword.length()== 0)
			{
				getAppletContext().showStatus("Confirmpassword field cannot be empty");
				return;
			}

			
			String FirstName = textFirstName1.getText();
			if(FirstName.length()==0)
			{
				getAppletContext().showStatus("FirstName cannot be empty");
				return;
			}

			String LastName = textLastName1.getText();
			if (LastName.length() == 0)
			{
				getAppletContext().showStatus("LastName cannot be empty");
				return;
			}

			String Address = textAddress1.getText();
			if (Address.length() == 0)
			{
				getAppletContext().showStatus("Address cannot be empty");
				return;
			}
			String Phone = textPhone1.getText();
			if (Phone.length() == 0)
			{
				getAppletContext().showStatus("Phone cannot be empty");
				return;
			}
			String EmailId = textEmailId1.getText();
			if (EmailId.length() == 0)
			{
				getAppletContext().showStatus("EmailId Cannot be empty");
				return;
			}
			String Country = textCountry1.getText();
			if (Country.length() == 0)
			{
				getAppletContext().showStatus("Country cannot be empty");
				return;
			}
			String CountryId  = textCountryId1.getText();
			if(CountryId.length() == 0 )
			{
				getAppletContext().showStatus("Country Id cannot be empty");
				return;
			}
			String State = textState1.getText();
			if(State.length() == 0)
			{
				getAppletContext().showStatus("State cannot be empty");
				return;
			}
			String City =textCity1.getText();
			if (City.length() == 0 )
			{
				getAppletContext().showStatus("city Cannot be empty");
				return;
			}
			String  Zipcode = textZipcode1.getText();
			if (Zipcode.length() ==0)
			{
				getAppletContext().showStatus("Zip Code cannot be empty");
				return;
			}
			String Creditcardno = textCreditcardno1.getText();
			if (Creditcardno.length() == 0)
			{
				getAppletContext().showStatus("Credit Card No. cannot be empty");
 				return;
			}
			String Creditcardtype = textCreditcardtype1.getText();
			if (Creditcardtype.length()== 0)

			{
				getAppletContext().showStatus("Credit Card Type cannot be empty");
                              return;
			}


			String CreditcardExpirydate = textCreditcardExpirydate1.getText();
			if(CreditcardExpirydate.length()== 0 )
			{
				getAppletContext().showStatus("Expirydate cannot be empty");
				return;
			}
			//System.out.println(Confirmpassword.compareTo(Password));
			if (!(Confirmpassword.compareTo(Password)==0))
			{
				getAppletContext().showStatus("Confirm password ");
				return;
			}
		/*	try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection co;
			//establish connection with data source
			co=DriverManager.getConnection("jdbc:odbc:ajosh");
			//create the statement object
			PreparedStatement st=co.prepareStatement("insert into aj_shopper(cshopperid,cPassword,cConfirmpassword ,vFirstName ,vLastName ,vAddress ,cphone,cEmailId ,cCountry ,cCountryId ,cState ,cCity ,cZipcode ,cCreditcardno ,cCreditcardtype ,dCreditcardExpirydate)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//fill the parameter value
			st.setString(1,textShopperId1.getText());
			st.setString(2,textPassword1.getText());
 			st.setString(3,textConfirmpassword1.getText());
 			st.setString(4,textFirstName1.getText());
 			st.setString(5,textLastName1.getText());
 			st.setString(6,textAddress1.getText());
 			st.setString(7,textPhone1.getText());
 			st.setString(8,textEmailId1.getText());
 			st.setString(9,textCountry1.getText());
 			st.setString(10,textCountryId1.getText());
 			st.setString(11,textState1.getText());
 			st.setString(12,textCity1.getText());
 			st.setString(13,textZipcode1.getText());	
 			st.setString(14,textCreditcardno1.getText());
 			st.setString(15,textCreditcardtype1.getText());
 			st.setString(16,textCreditcardExpirydate1.getText());

			//insert the record into the sstatement
			st.executeUpdate();
			}
			catch(Exception exception)
			{
		System.out.println("ERROR ENCONTERED WHILE UPDATING DATA IN SHOPPER DATABASE"+exception);
			}*/
		 try
		{
		Socket s = new Socket("192.168.16.2",1818);
		ObjectOutputStream oos0 = new ObjectOutputStream(s.getOutputStream());
		Shopper s1 = new Shopper();
		s1.shopperid1=textShopperId1.getText();
		s1.password1=textPassword1.getText();
		s1.confirmpassword1=textConfirmpassword1.getText();
		s1.firstname1=textFirstName1.getText();
		s1.lastname1=textLastName1.getText();
		s1.address1=textAddress1.getText();
		s1.phone1=textPhone1.getText();
		s1.emailid1=textEmailId1.getText();
		s1.country1=textCountry1.getText();
		s1.countryid1=textCountryId1.getText();
		s1.state1=textState1.getText();
		s1.city1=textCity1.getText();
		s1.zipcode1=textZipcode1.getText();
		s1.creditcardno1=textCreditcardno1.getText();
		s1.creditcardtype1=textCreditcardtype1.getText();
		s1.creditcardexpirydate1=textCreditcardExpirydate1.getText();
		oos0.writeObject((Shopper)s1);
			}
			catch(Exception e)
			{
			showStatus("ERROR SENDING DATA TO SHOPPER DATA BASE");
			}

		}
	
		if(objt==b2)

			{
			showStatus("CLEARING SHOPPER DETAIL");

			textShopperId1.setText("");

		      	textPassword1.setText("");
	  		textConfirmpassword1.setText("");
		        textFirstName1.setText("");
	        	textLastName1.setText("");
		   	textAddress1.setText("");
	      		textPhone1.setText("");
		 	textEmailId1.setText("");
			textCountry1.setText("");
		        textCountryId1.setText("");
			textState1.setText("");
		        textCity1.setText("");
			textZipcode1.setText("");
			textCreditcardno1.setText("");
			textCreditcardtype1.setText("");
 			textCreditcardExpirydate1.setText("");
			}



		

	
	//Object obj1 = evt.getSource();
	if(objt==b5)
	{
		String RecOrderno = textRecOrderno2.getText();
			if (RecOrderno.length() == 0 )
			{
				getAppletContext().showStatus("Order Number cannot be empty");
				return;
			}

			String RecFirstName = textRecFirstName2.getText();
			if (RecFirstName.length()==0)
			{
				getAppletContext().showStatus("FirstName cannot be empty");
				return;
			}
			
			String RecLastName =textRecLastName2.getText();
			if (RecLastName.length() == 0)
			{
				getAppletContext().showStatus("LastName cannot be empty");
				return;
			}
			String RecAddress = textRecAddress2.getText();
			if (RecAddress.length() ==0)
			{
				getAppletContext().showStatus("Address cannot be empty");
				return;
			}
			String RecCity = textRecCity2.getText();
			if (RecCity.length() == 0 )
			{
				getAppletContext().showStatus("City cnnot be empty");
				return;
			}
			String RecState = textRecState2.getText();
			if (RecState.length() == 0)
			{

				getAppletContext().showStatus("State cannot be empty");
				return;
			}
				
			String RecCountry = textRecCountry2.getText();
			if (RecCountry.length() ==0)
			{
				getAppletContext().showStatus("Country cannot be empty");
				return;
			}

			String RecCountrycode = textRecCountrycode2.getText();
			if (RecCountrycode.length() ==0)
			{
				getAppletContext().showStatus("Country Code cannot be empty");
				return;
			}
			String RecZipcode = textRecZipcode2.getText();
			if (RecZipcode.length() == 0)
			{
				getAppletContext().showStatus(" ZipCode cannot be Empty");
				return;
			}
			String RecPhone = textRecPhone2.getText();
			if (RecPhone.length() == 0 )
			{
				getAppletContext().showStatus("Phone cannot be empty");
				return;
			}
		/*	try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection co;
			//establish connection with data source
			co=DriverManager.getConnection("jdbc:odbc:ajosh");
			//create the statement object
			PreparedStatement st=co.prepareStatement("insert into aj_recipient(cRecOrderNo,vRecFirstName,vRecLastName,vRecAddress,cRecCity,cRecState,cRecCountry,cRecCountrycode,cRecZipcode,cRecphone)values(?,?,?,?,?,?,?,?,?,?)");
			//fill the parameter value
			st.setString(1,textRecOrderno2.getText());
			st.setString(2,textRecFirstName2.getText());
 			st.setString(3,textRecLastName2.getText());
 			st.setString(4,textRecAddress2.getText());
 			st.setString(5,textRecCity2.getText());
 			st.setString(6,textRecState2.getText());
 			st.setString(7,textRecCountry2.getText());
 			st.setString(8,textRecCountrycode2.getText());
 			st.setString(9,textRecZipcode2.getText());
 			st.setString(10,textRecPhone2.getText());
			
			//insert the record into the sstatement
			st.executeUpdate();
			}
			catch(Exception exception)
			{
		System.out.println("ERROR ENCONTERED WHILE UPDATING DATA IN RECIPIENT DATABASE"+exception);
			}*/
			try
			{
			Socket s = new Socket("192.168.16.2",1818);

		ObjectOutputStream oos1 = new ObjectOutputStream(s.getOutputStream());
		Recipient re = new Recipient();
		re.orderno2=textRecOrderno2.getText();
		re.firstname2=textRecFirstName2.getText();
		re.lastname2=textRecLastName2.getText();
		re.address2=textRecAddress2.getText();
		re.city2=textRecCity2.getText();
		re.state2=textRecState2.getText();
		re.country2=textRecCountry2.getText();
		re.countrycode2=textRecCountrycode2.getText();
		re.zipcode2=textRecZipcode2.getText();
		re.phone2=textRecPhone2.getText();
		oos1.writeObject((Recipient)re);
			}
			catch(Exception e)
			{
			showStatus("ERROR SENDING DATA TO RECIPIENT DATA BASE");
			}

		}
		if(objt==b4)
			{
			showStatus("CLEARING RECIPIENT DETAIL");
			
			textRecOrderno2.setText("");
			textRecFirstName2.setText("");
			textRecLastName2.setText("");
			textRecAddress2.setText("");
			textRecCity2.setText("");
			textRecState2.setText("");
			textRecCountry2.setText("");
			textRecCountrycode2.setText("");
			textRecZipcode2.setText("");
			textRecPhone2.setText("");
			}
		
		if(objt==b6)
			{
			String Name = textName3.getText();
			if(Name.length()== 0)
			{
				getAppletContext().showStatus("NAME CANNOT BE EMPTY");
				return;
			}
			String Address = textAddress3.getText();
			if (Address.length()==0)
			{
				getAppletContext().showStatus("ADDRESS CANNOT BE EMPTY");
				return;
			}		
					
			String Registration_no= textRegistration_no3.getText();
			if(Registration_no.length()==0)
			{
			getAppletContext().showStatus("REGISTRATION NUMBER CANNOT BE EMPTY");
				return;
			}

			String Password = textPassword3.getText();
			if (Password.length()==4)
			{
		getAppletContext().showStatus("PASSWORD CANNOT BE LESS THAN OUR CHARACTER");
				return;
			}

			String ItemCode = textItemCode3.getText();
			if(ItemCode.length() == 0)
			{
				getAppletContext().showStatus("ITEM CODE CANNOT BE EMPTY");
				return;
			}
			String ItemName = textItemName3.getText();
			if (ItemName.length() == 0)
			{
				getAppletContext().showStatus("ITEM NAME CANNOT BE EMPTY");
				return;
			}
			String Quantity = intQuantity3.getText();
			if (Quantity.length() == 0)
			{
				getAppletContext().showStatus("QUANTITY CANNOT BE EMPTY");
				return;
			}
			String ItemPrice = intItemPrice3.getText();
			if (ItemPrice.length() == 0)
			{
				getAppletContext().showStatus("GOOD NOT SOLD FREE OF COST");
				return;
			}
	/*		int a = Integer.parseInt(Quantity);
		
			int b = Integer.parseInt(ItemPrice);
		
			int c = a*b;
		

			String totalprice  = String.valueOf(c);
			inttotalprice3.setText(totalprice);*/
			

			String BankName = textBankName3.getText();
			if(BankName.length() == 0)
			{
				getAppletContext().showStatus("BANK NAME PLEASE");
				return;
			}
			String Account_no =textAccount_no3.getText();
			if (Account_no.length() == 0 )
			{
				getAppletContext().showStatus("ENTER ACCOUNT NUMBER");
				return;
			}
			int a = Integer.parseInt(Quantity);
		
			int b = Integer.parseInt(ItemPrice);
		
			int c = a*b;
		

			String totalprice  = String.valueOf(c);
			intTotalprice3.setText(totalprice);
			
			try
		{
		Socket s = new Socket("192.168.16.2",1818);
		ObjectOutputStream oos2 = new ObjectOutputStream(s.getOutputStream());
		Shopping sg = new Shopping();

		sg.name3=textName3.getText();
		sg.address3=textAddress3.getText();
		sg.city3=(String)comboCity3.getSelectedItem();
		sg.state3=(String)comboState3.getSelectedItem();
		sg.country3=(String)comboCountry3.getSelectedItem();
		sg.registrationno3=textRegistration_no3.getText();
		sg.password3=textPassword3.getText();
		sg.code3=textItemCode3.getText();
		sg.itemname3=textItemName3.getText();
		sg.quantity3=intQuantity3.getText();
		sg.itemprice3=intItemPrice3.getText();
		sg.totalprice3=intTotalprice3.getText();
		sg.bankname3=textBankName3.getText();
		sg.accountno3=textAccount_no3.getText();

		oos2.writeObject((Shopping)sg);
		}
		catch(Exception e)
		{
		showStatus("ERROR SENDING DATA TO  GO SHOPPING DATA BASE");
		}	
	}
	if(objt==b8)
	{
	showStatus("CLEARING SHOPPING FORM");
	textName3.setText("");

 	textAddress3.setText("");
	
	textRegistration_no3.setText("");

	textPassword3.setText("");

	textItemCode3.setText("");

	textItemName3.setText("");

	intQuantity3.setText("");

	intItemPrice3.setText("");

	intTotalprice3.setText("");

	textBankName3.setText("");

	textAccount_no3.setText("");

	

}

}//end for actionPerformed
}//end for validateAction
}// end for Myshop

