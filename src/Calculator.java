/**
 * Calculates basic tascs 
 * @author Michael Yoseph
 *
 */

import java.util.*;

import database.DBConnect;

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
	
	// TODO
	public void setStartDateTime() {
		startDateTime = parseStringToDateformat(readInput("Start time")); 
		
		
	}
	
	// TODO
	public void setEndDateTime() {
		endDateTime = parseStringToDateformat(readInput("End time"));		
	}
	
	
	public LocalDateTime getStartDateTime() {
		return startDateDime;
	}
	
	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}
	
	// TODO
	public void calculateHours() {
		timeAmount = (Duration.between(startDateTime, endDateTime).toMinutes()/60.00);
	}
	
	
	// Prints output
	public void printOutResult(){
	System.out.println("TIME COSTS \n Duration: " + timeAmount +" h"+ "\n Tarif: "+hrPrice+" sFr/h."+"\n Total: " + timeAmount* hrPrice+" sFr." );
	System.out.println("KM COSTS \n Km: " + kmAmount + "\n Tarif: "+kmPrice+" sFr./km \n Total: " + kmAmount* kmPrice+" sFr." );
	System.out.println("TOTAL COSTS: "+(timeAmount* hrPrice + kmAmount* kmPrice+" sFr." )); 
	}
}
