package database;
import java.sql.*;

public class DBConnect {
	private Connection con; 
	private Statement st;
	private ResultSet rs;

	
	public DBConnect(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobilityrechner","root","");
			st = con.createStatement();
			
		}catch(Exception ex){
			System.out.println("Error: "+ex);
		}
		
	}
	
	public void getCategories() {
		try{
			String query = "SELECT f.FZKAT_ID, f.FZKAT_Name, t.TAR_STD  FROM mr_fzkat as f INNER JOIN mr_tarife as t ON t.FZKat_ID = f.FZKAT_ID";
			rs = st.executeQuery(query);
			while(rs.next()){
				String id = rs.getString("FZKAT_ID");
				String name = rs.getString("FZKAT_Name");
				String preis = rs.getString("TAR_STD");
				System.out.println("Nr: " + id+ " Category: "+name + " ("+preis+"sFr./h)" );
			}
		}catch(Exception ex){
			System.out.println("Error: "+ ex);
		}
	}
	
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
