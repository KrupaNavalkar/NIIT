import java.io.*;
import java.sql.*;
import java.net.*;

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

public class Server implements Runnable
	{
	ServerSocket ss;
	Socket s;
	//InetAddress i;
	Thread t;
public Server() //public
{
	
	try
	{
		ss = new  ServerSocket(2020,5);
		t =new Thread(this);
		System.out.println("  SERVER STARTING ON 192.168.16.2" +" AT PORT NUMBER 2020");

		t.start();
	}
	catch(Exception x)
	{
		System.out.println("  ERROR STARTING SERVER"+x);
		System.out.println("  STOPPING THE SERVER");
		System.out.println("  QUITTING.............");
		System.exit(1);
	}
}
public static void main(String[] args)
{
new Server();
}
public void run()
	{
	while(true)
	{
	try
	{
		s = ss.accept();
	/*	s00 = ss.accept();
		s01 = ss.accept();
		s02 = ss.accept();*/
 
		Connect c = new Connect(s);
	}
	catch(Exception x)
	{
		System.out.println("  ERROR LISTENING SERVER"+x);
		System.out.println("  QUITTING..............");
		System.exit(1);
	}
    }//end of while
  }//end of run
}//end of class server

class Connect
{
	Registration r;
	Recipient r1;
	OrderDetail r2;
	Object ob;

	ObjectInputStream ois;
	

public Connect(Socket s) //public
{
	
	try
	{
		ois = new ObjectInputStream(s.getInputStream());
		ob = ois.readObject();
		//r = (Registration) ois.readObject();	
		submit();
	}
	catch(InvalidClassException ice)
	{
		System.out.println("CANNOT SERIALIZE CONCERNED FORM CLASS.");
	}
	catch(NotSerializableException nse)
	{
		System.out.println("CONCERNED FORM CANNOT BE SERIALIZED");
	}
	catch(IOException ioe)
	{
		System.out.println("CANNOT READ FROM STREAM");
	}
	catch(Exception x)
	{
		System.out.println("  ERROR"+x);
	}
}//end of constructor


public void submit()
{
	try
	{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con;
			//establish connection with data source
			con=DriverManager.getConnection("jdbc:odbc:Krupa","user1","");
			
			if(ob instanceof Registration)
		{
try
{
			r = (Registration)ob;
			//create the statement object
			PreparedStatement stat=con.prepareStatement("insert into ShopperK values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//fill the parameter values
			stat.setString(1,r.regShopperId);
			stat.setString(2,r.regPassword);
 			//stat.setString(3,r.ConfirmPassword);
 			stat.setString(3,r.regFirstName);
 			stat.setString(4,r.regLastName);
 			stat.setString(5,r.regAddress);
 			//stat.setString(7,r.regPhone);
 			stat.setString(6,r.regEmail);
 			stat.setString(7,r.regCity);
 			stat.setString(8,r.regState);
			stat.setString(9,r.regCountry);
 			stat.setString(10,r.regCountryId);
 			//stat.setString(13,r.regZipcode);	
 			stat.setString(11,r.regCreditCardNo);
 			stat.setString(12,r.regCreditCardType);
 			stat.setString(13,r.regExpiryDate);
			stat.executeUpdate();
System.out.println("reg data saved");

}
	catch(Exception x)
	{
		System.out.println("ERROR LISTENING REGISTRATION  DETAIL RECORD" + x);

	}

}//if		
			if(ob instanceof Recipient)
		{
try{
				
			r1 = (Recipient)ob;
			//create the statement object
			PreparedStatement stat=con.prepareStatement("insert into RecipientK values(?,?,?,?,?,?,?,?,?)");
			//fill the parameter values
			stat.setString(1,r1.recpOrderNo);
			stat.setString(2,r1.recpFirstName);
 			stat.setString(3,r1.recpLastName);
 			stat.setString(4,r1.recpAddress);
 			stat.setString(5,r1.recpCity);
 			stat.setString(6,r1.recpState);
 			//stat.setString(7,r1.recpCountry);
 			stat.setString(7,r1.recpCountryCode);
 			stat.setString(8,r1.recpZipCode);
 			stat.setString(9,r1.recpPhone);

			stat.executeUpdate();
System.out.println("Rec details added");
		}

	catch(Exception x)
	{
		System.out.println("ERROR LISTENING RECIPIENT RECORD" + x);

	}
}//if
		if(ob instanceof OrderDetail)
		{
		
try
{
			r2 = (OrderDetail)ob;
			//create the statement object
	
                        PreparedStatement stat=con.prepareStatement("insert OrderDetailK values(?,?,?,?,?,?,convert(money,?))");
			//fill the parameter values
			stat.setString(1,r2.odOrderNo);
			stat.setString(2,r2.odToyId);
 			stat.setString(3,r2.odQty);
 			stat.setString(4,r2.odGiftWrap);
 			stat.setString(5,r2.odWrapperId);
 			stat.setString(6,r2.odMessage);
 			stat.setString(7,r2.odToyCost);
			System.out.println(r2.odToyCost);
			stat.executeUpdate();
System.out.println("Data Saved");
		}
	catch(Exception x)
	{
		System.out.println("ERROR LISTENING  RECORD" + x);

	}
     }//if
}//try
catch(Exception x2)
{
System.out.println("Error " + x2);
}


}
}
