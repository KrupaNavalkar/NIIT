import java.io.*;
import java.sql.*;
import java.net.*;

class Applicant extends Object implements Serializable
{
String appId,appName,appAdd,appPos;
}
public class Server implements Runnable
{

ServerSocket ss;
Socket s;
Thread t;
public Server()
{
try
{

ss = new ServerSocket(1717,1000);
t = new Thread(this);
System.out.println("Server Starting on .....");
System.out.println("192.168.16.2" + "at port number 1717....");
t.start();
}

catch (Exception e)
{
System.out.println("Error starting server....\n"+e);
System.out.println("Stopping the server....");
System.out.println("Quitting....");
System.exit(1);
}
}

public static void main (String[] args)
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
    Connect c = new Connect(s);
   }
catch (Exception e)
{
  System.out.println(Error listing server....\n" + e);
System.out.println("Quitting.....");
System.exit(1);
}

}//end of while
}//end of run
}//end of class server

class Connect
{
    Applicant a ;
    ObjectInputStream ois;
    public Connect(Socket s)
{
  ois = new ObjectInputStream(s.getInputStream());
  a = (Applicant)ois.readObject();
  submit();
}
catch(InvalidClassException ice)
{
    System.out.println("Cannot serialize Applicant class");
}
catch(NotserializableException nse)
{
    System.out.println("Applicant class not serialized");
}
catch(IOException ioe)
{
    System.out.println("Cannot read from stream");
}
catch(Exception e)
{
   System.out.println("Error  \n" + e);
}

}//end of constructor

public void submit()
{
try
   {
    Class.forName("sun.jdbc.JdbcOdbcDriver");
    Connection con = 
DriverManager.getConnection("jdbc:odbc:mp";"user1","");
PreparedStatement stat = con.prepareStatement("insert
into applicant values(?,?,?,?)");

stat.setString(1,a.appId);
stat.setString(2,a.appName);
stat.setString(3,a.appAdd);
stat.setString(4,a.appPos);

stat.executeUpdate();
}
catch (Exception ex)
{
System.out.println("Error inserting record....\n" + ex);
}

}
}
