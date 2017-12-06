package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class MyFirstHsqlConnection
{
    public MyFirstHsqlConnection()
    {
          
    try
    { 
        // Treiberklasse laden
      Class.forName( "org.hsqldb.jdbcDriver" ); 
    } 
    catch ( ClassNotFoundException e ) 
    { 
      System.err.println( "Treiberklasse nicht gefunden!" ); 
      return; 
    } 
  
    Connection con = null; 
  
    try
    { 
      con = DriverManager.getConnection(  
              "jdbc:hsqldb:file:home/mobilitycalculator/hsqldb; shutdown=true", "root", "" ); 
      Statement stmt = con.createStatement(); 
  
      // Alle Kunden ausgeben
      String sql = "SELECT * FROM Customer";
      ResultSet rs = stmt.executeQuery(sql); 
  
      while ( rs.next() ) 
      {
        String id = rs.getString(1);
        String firstName = rs.getString(2);
        String lastName = rs.getString(3);
        System.out.println(id + ", " + firstName + " " + lastName);
      }
       
      // Resultset schließen
      rs.close(); 
  
      // Statement schließen
      stmt.close(); 
    } 
    catch ( SQLException e ) 
    { 
      e.printStackTrace(); 
    } 
    finally
    { 
      if ( con != null ) 
      {
        try { 
            con.close(); 
            } catch ( SQLException e ) { 
                e.printStackTrace(); 
            }
      }
    } 
    }
     
    public static void main(String[] args)
    {
        new MyFirstHsqlConnection();
    }
}