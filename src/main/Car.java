package main;

import java.util.Scanner;

import hsqlDB.MobilityHSQLDB;

public class Car {
	private static int id;
	private static String name;
	private static double hrPrice;
	private static double kmPrice;
	
	private static MobilityHSQLDB connect;
	
	public Car() {
		connect = new MobilityHSQLDB();
	}
	
	public Car(int id, String name, double hrPrice, double kmPrice) {
		connect = new MobilityHSQLDB();
		this.id = id; 
		this.name = name; 
		this.hrPrice = hrPrice;
		this.kmPrice = kmPrice; 
	}
	
	public Car (int id){
		connect.getCarDetails(id);
	}

	/**
	 * Sets Category
	 */
	public static int chooseCategory(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("CHOOSE CATEGORY");
		System.out.println("Please enter the number of the desired category then press Enter and q to continue");
		connect.getCategories();
		while(true){
			String s = scanner.nextLine();
			if (s.equals("q")) break;
			id = Integer.parseInt(s);
			//scanner.close(); 				
		}
		return id;
	}

	/**
	 * @return the id
	 */
	public static int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the hrPrice
	 */
	public static double getHrPrice() {
		return hrPrice;
	}

	/**
	 * @return the kmPrice
	 */
	public static double getKmPrice() {
		return kmPrice;
	}
	
	public static String[] getCategoryNames() {
		return connect.getCategoryList();
	}
}
