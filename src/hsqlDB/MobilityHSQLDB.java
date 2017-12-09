package hsqlDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class MobilityHSQLDB {
	private Connection con; 
	private Statement st;
	private ResultSet rs;
	

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
     
    public void getCategories() {
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
    
	public double getStdTarif(int id) {
		double stdTar = 0.0;
		try{
			con = DriverManager.getConnection("jdbc:hsqldb:file:home; hsqldb.lock_file=false;shutdown=true", "root", "" ); 
			Statement stmt = con.createStatement(); 
			String sql = "Select TAR_STD from mr_tarife where mr_tarife.FZKAT_ID = "+id; 
			rs = stmt.executeQuery(sql); 
			while(rs.next()){
				stdTar = Double.parseDouble(rs.getString("TAR_STD")); 				
			}
		    rs.close(); 
		    stmt.close(); 
		} 
		catch(Exception ex){
			System.out.println("Error: "+ex);
		}
		return stdTar;
	}
	
	public double getKmTarif(int id) {		
		double kmTar = 0.0;
		try{
			con = DriverManager.getConnection("jdbc:hsqldb:file:home;  hsqldb.lock_file=false;shutdown=true", "root", "" ); 
			Statement stmt = con.createStatement(); 
			String sql = "Select TAR_KM from mr_tarife where mr_tarife.FZKAT_ID = "+id; 
			rs = st.executeQuery(sql);
			while(rs.next()){
				kmTar = Double.parseDouble(rs.getString("TAR_KM")); 				
			}
		    rs.close(); 
		    stmt.close(); 
		} 
		catch(Exception ex){
			System.out.println("Error: "+ex);
		}
		return kmTar;
	}
	 
}