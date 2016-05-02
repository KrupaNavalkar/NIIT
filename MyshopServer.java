import java.io.*;
import java.sql.*;
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

public class MyshopServer implements Runnable
	{
	ServerSocket ss;
	Socket s;
	//InetAddress i;
	Thread t;
protected MyshopServer()
{
	
	try
	{
		ss = new  ServerSocket(1818,5);
		t =new Thread(this);
		System.out.println("  SERVER STARTING ON 192.168.16.2" +" AT PORT NUMBER 1818");

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
new MyshopServer();
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
	Shopper s1;
	Recipient re;
	Shopping sg; 	
	Object ob;

	ObjectInputStream ois;
	

protected Connect(Socket s)
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
		System.out.println("  CANNOT SERIALIZE CONCERNED FORM CLASS.");
	}
	catch(NotSerializableException nse)
	{
		System.out.println(" CONCERNED FORM CANNOT BE SERIALIZED");
	}
	catch(IOException ioe)
	{
		System.out.println("  CANNOT READ FROM  STREAM");
	}
	catch(Exception x)
	{
		System.out.println("  ERROR"+x);
	}
}
	

public void submit()
{
	try
	{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con;
			//establish connection with data source
			con=DriverManager.getConnection("jdbc:odbc:ajosh","user6","");
			
			if(ob instanceof Registration)
		{
			r = (Registration)ob;
			//create the statement object
			PreparedStatement st=con.prepareStatement("insert into aj_registrationform values(?,?,?,?,?,?,?,?,?)");

			st.setString(1,r.Name);
			st.setString(2,r.Address);
			st.setString(3,r.City);
			st.setString(4,r.State);
			st.setString(5,r.Country);
			st.setString(6,r.Registration);
			st.setString(7,r.Password);
			st.setString(8,r.Bankname);
			st.setString(9,r.Accountno);

			st.executeUpdate();
		}
	/*catch(Exception x)
	{
		System.out.println("ERROR LISTENING REGISTRATION  DETAIL RECORD" + x);

	}*/
		if(ob instanceof Shopper)
		{
			s1 = (Shopper)ob;
			//create the statement object
			PreparedStatement st=con.prepareStatement("insert into aj_shopper values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			st.setString(1,s1.shopperid1);
			st.setString(2,s1.password1);
			st.setString(3,s1.confirmpassword1);
			st.setString(4,s1.firstname1);
			st.setString(5,s1.lastname1);
			st.setString(6,s1.address1);
			st.setString(7,s1.phone1);
			st.setString(8,s1.emailid1);
			st.setString(9,s1.country1);
			st.setString(10,s1.countryid1);
			st.setString(11,s1.state1);
			st.setString(12,s1.city1);
			st.setString(13,s1.zipcode1);
			st.setString(14,s1.creditcardno1);
			st.setString(15,s1.creditcardtype1);
			st.setString(16,s1.creditcardexpirydate1);

			st.executeUpdate();
		}
	/*catch(Exception x)
	{
		System.out.println("ERROR LISTENING SHOPPER RECORD" + x);

	}*/
		if(ob instanceof Recipient)
		{
				
			re = (Recipient)ob;
			//create the statement object
			PreparedStatement st=con.prepareStatement("insert into aj_recipient values(?,?,?,?,?,?,?,?,?,?)");

			st.setString(1,re.orderno2);
			st.setString(2,re.firstname2);
			st.setString(3,re.lastname2);
			st.setString(4,re.address2);
			st.setString(5,re.city2);
			st.setString(6,re.state2);
			st.setString(7,re.country2);
			st.setString(8,re.countrycode2);
			st.setString(9,re.zipcode2);
			st.setString(10,re.phone2);
			

			st.executeUpdate();
		}
	/*catch(Exception x)
	{
		System.out.println("ERROR LISTENING RECIPIENT RECORD" + x);

	}*/
		if(ob instanceof Shopping)
		{
		
			sg = (Shopping)ob;
			//create the statement object
	

			PreparedStatement st=con.prepareStatement("insert into aj_shopping values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			st.setString(1,sg.name3);

			st.setString(2,sg.address3);
			st.setString(3,sg.city3);
			st.setString(4,sg.state3);
			st.setString(5,sg.country3);
			st.setString(6,sg.registrationno3);
			st.setString(7,sg.password3);
			st.setString(8,sg.code3);
			st.setString(9,sg.itemname3);
			st.setString(10,sg.quantity3);
			st.setString(11,sg.itemprice3);
			st.setString(12,sg.totalprice3);
			st.setString(13,sg.bankname3);
			st.setString(14,sg.accountno3);
		

			st.executeUpdate();
		}
	}
	catch(Exception x)
	{
		System.out.println("ERROR LISTENING  RECORD" + x);

	}
     }
}