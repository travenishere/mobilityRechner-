/**
 * Calculates basic tascs 
 * @author Michael Yoseph
 *
 */

import java.util.*;
import java.sql.Connection;
import java.text.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Calculator {
	private LocalDateTime startDateTime; 
	private LocalDateTime endDateTime; 
	private double timeAmount;  
	public static double hrPrice;
	private double kmAmount;
	public static double kmPrice;  
	private static DBConnect connect; 
	
	/*
	 * Creates new Calculator 
	 */
	public Calculator(){
		connect = new DBConnect();
		startDateTime = null; 
		endDateTime = null;
		hrPrice = 0.00;
		kmPrice = 0.00;
		kmAmount = 5.5; //Will later on be set correctly, as for now fixed.
		
		}
	
	/**
	 * Sets Start- and Endtime from Userinput. 
	 */	
	public String readInput (String scannerInput){
		Scanner scanner = new Scanner(System.in); 
		String scannerOutput = "";
		System.out.println(scannerInput.toUpperCase() + " \nEnter Date and Time in the form of \"08.01.2017 12:30\" presse Enter and continue with \"q\" ");
		while(true){
			String s = scanner.nextLine();
			if(s.equals("q")) break; 
			scannerOutput = s; 
		}
		//scanner.close();
		return scannerOutput;
	}
	
	/**
	 * Sets Category and tarifs
	 */
	public void chooseCategory (){
		Scanner scanner = new Scanner(System.in);
		String scannerOutput = "";
		System.out.println("CHOOSE CATEGORY");
		System.out.println("Please enter the number of the desired category then press Enter and q to continue");
		connect.getCategories();
		while(true){
			String s = scanner.nextLine();
			if (s.equals("q")) break;
			scannerOutput = s;
			//scanner.close();
			hrPrice = connect.getStdTarif(s);
			kmPrice = connect.getKmTarif(s);
		}
	}
	
	/**
	 * Parses a String input of the form "08.10.2017 13:00" into the LocalDateTime 
	 */
	public LocalDateTime parseStringToDateformat(String strDate){ 	
		LocalDateTime localDate = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		localDate = LocalDateTime.parse(strDate, formatter);
		return localDate; 		
	}

	
	public static void main (String args[]){
		Calculator c1 = new Calculator();
		c1.startDateTime = c1.parseStringToDateformat(c1.readInput("starting reservation")); 
		c1.endDateTime = c1.parseStringToDateformat(c1.readInput("ending reservation")); 
		c1.chooseCategory();
		c1.timeAmount = (Duration.between(c1.startDateTime, c1.endDateTime).toMinutes()/60.00);
		System.out.println("TIME COSTS \n Duration: " + c1.timeAmount +" h"+ "\n Tarif: "+hrPrice+" sFr."+"\n Total: " + c1.timeAmount* hrPrice+" sFr." );
		System.out.println("KM COSTS \n Km: " + c1.kmAmount + "\n Tarif: "+kmPrice+" sFr.\n Total: " + c1.kmAmount* kmPrice+" sFr." );
		System.out.println("TOTAL COSTS: "+(c1.timeAmount* hrPrice + c1.kmAmount* kmPrice+" sFr." )); 
		
	}
}
