package hsqlDB;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.Car;




public class MobilityHSQLDB {
	private static Connection con; 
	private Statement st;
	private static ResultSet rs;
	private static String[] categoryList; 
	

    public MobilityHSQLDB()
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
    	//TODO Lockprolematik pruefen: https://stackoverflow.com/questions/3968595/database-lock-acquisition-failure-and-hsqldb 
      con = DriverManager.getConnection("jdbc:hsqldb:file:home; shutdown=true", "root", "" ); 
      //Statement stmt = con.createStatement(); 
  /*
      // Alle Kunden ausgeben
      String sql = "select * from mr_fzkat";
      ResultSet rs = stmt.executeQuery(sql); 
  
      while ( rs.next() ) 
      {
        String id = rs.getString(1);
        String name = rs.getString(2);
        System.out.println("ID:" + id + ", Bezeicnung: " + name );
      }
       
      // Resultset schließen
      rs.close(); 
  
      // Statement schließen
      stmt.close(); 
      
  	Statement stmt = con.createStatement(); 
	String sql = "SELECT f.FZKAT_ID, f.FZKAT_Name, t.TAR_STD  FROM mr_fzkat as f INNER JOIN mr_tarife as t ON t.FZKat_ID = f.FZKAT_ID";
	rs = stmt.executeQuery(sql); 
	while(rs.next()){
		String id = rs.getString("FZKAT_ID");
		String name = rs.getString("FZKAT_Name");
		String preis = rs.getString("TAR_STD");
		System.out.println("Nr: " + id+ " Category: "+name + " ("+preis+"sFr./h)" );      
		
    } 
	// Resultset schließen
    rs.close(); 

    // Statement schließen
    stmt.close(); 
    */
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
     
    public static void getCategories() {
		try{
			//TODO Check if duplicating the initializing of con in each method can by eliminated
			con = DriverManager.getConnection("jdbc:hsqldb:file:home; hsqldb.lock_file=false; shutdown=true", "root", "" ); 		     
			Statement stmt = con.createStatement(); 
			String sql = "SELECT f.FZKAT_ID, f.FZKAT_Name, t.TAR_STD  FROM mr_fzkat as f INNER JOIN mr_tarife as t ON t.FZKat_ID = f.FZKAT_ID";
			rs = stmt.executeQuery(sql); 
			while(rs.next()){
				String id = rs.getString("FZKAT_ID");
				String name = rs.getString("FZKAT_Name");
				String preis = rs.getString("TAR_STD");
				 System.out.println("Nr: " + id+ " Category: "+name + " ("+preis+"sFr./h)" );    
		    } 
		    rs.close(); 
		    stmt.close(); 
		    }
		catch(Exception ex){
			System.out.println("Error: "+ ex);
		}
	}
    
	
    public Car getCarDetails(int id) {
    	String name = "null";
    	double stdTar = 0.0;
		double kmTar = 0.0;
		Car car = new Car();
		try{
			con = DriverManager.getConnection("jdbc:hsqldb:file:home; hsqldb.lock_file=false;shutdown=true", "root", "" ); 
			Statement stmt = con.createStatement(); 
			String sql = "SELECT f.FZKAT_Name, t.TAR_STD, t.TAR_KM FROM mr_fzkat as f INNER JOIN mr_tarife as t ON t.FZKat_ID = f.FZKAT_ID WHERE f.FZKAT_ID = "+id; 
			rs = stmt.executeQuery(sql); 
			while(rs.next()){
				name = rs.getString("FZKAT_Name");
				stdTar = Double.parseDouble(rs.getString("TAR_STD"));
				kmTar = Double.parseDouble(rs.getString("TAR_KM")); 				
			}
			car = new Car(id,name, stdTar, kmTar);
		    rs.close(); 
		    stmt.close(); 		    
		} 
		catch(Exception ex){
			System.out.println("Error: "+ex);
		}
		return car;
	}
	
    public static String[] getCategoryList() {
		try{
			//TODO Check if duplicating the initializing of con in each method can by eliminated
			con = DriverManager.getConnection("jdbc:hsqldb:file:home; hsqldb.lock_file=false; shutdown=true", "root", "" ); 		     
			Statement stmt = con.createStatement(); 
			String sql = "SELECT FZKAT_Name FROM mr_fzkat";
			rs = stmt.executeQuery(sql); 
			categoryList= new String[9]; //TODO Generate method that evalutes nr. of categories			
			int i = 0;	
			while (rs.next()){					
				categoryList[i] = rs.getString("FZKAT_Name");
			i++;
			}
			 
			 
		    rs.close(); 
		    stmt.close(); 
		    
		    }
		catch(Exception ex){
			System.out.println("Error: "+ ex);
		}
		return categoryList; 
	}
    	 
}