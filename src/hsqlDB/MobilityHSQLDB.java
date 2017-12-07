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
      con = DriverManager.getConnection(  
              "jdbc:hsqldb:file:home; shutdown=true", "root", "" ); 
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
      */
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
			 con = DriverManager.getConnection(  
		              "jdbc:hsqldb:file:home; shutdown=true", "root", "" ); 
		     
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
		    }
		catch(Exception ex){
			System.out.println("Error: "+ ex);
		}
	}
	// TODO Fix for HSQL
	public double getStdTarif(String id) {
		double stdTar = 0.0;
		try{
			String query = "Select TAR_STD from mr_tarife where mr_tarife.FZKat_ID = "+id; 
			rs = st.executeQuery(query);
			while(rs.next()){
				stdTar = Double.parseDouble(rs.getString("TAR_STD")); 				
			}
		} catch(Exception ex){
			System.out.println("Error: "+ex);
		}
		return stdTar;
	}
	// TODO Fix for HSQL
	public double getKmTarif(String id) {
		double kmTar = 0.0;
		try{
			String query = "Select TAR_KM from mr_tarife where mr_tarife.FZKat_ID = "+id; 
			rs = st.executeQuery(query);
			while(rs.next()){
				kmTar = Double.parseDouble(rs.getString("TAR_KM")); 				
			}
		} catch(Exception ex){
			System.out.println("Error: "+ex);
		}
		return kmTar;
	}
	 
}