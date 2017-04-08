package domain;

import java.sql.*;

public class Validate
{
    public static boolean checkUser(String username,String pass) 
    {
     boolean st = false;
     try{

        Class.forName("org.hsqldb.jdbc.JDBCDriver");

	 //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:hsqldb:hsql//localhost/workdb","SA","");
        PreparedStatement ps =con.prepareStatement
                            ("select * from register where username=? and pass=?");
        ps.setString(1, username);
        ps.setString(2, pass);
        ResultSet rs =ps.executeQuery();
        st = rs.next();
       
     }catch(Exception e)
     {
         e.printStackTrace();
     }
        return st;                 
 }   
}
