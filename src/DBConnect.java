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
			String query = "SELECT * from mr_fzkat";
			rs = st.executeQuery(query);
			while(rs.next()){
				String id = rs.getString("FZKAT_ID");
				String name = rs.getString("FZKAT_Name");
				System.out.println("Nr: " + id+ " Category: "+name);
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
