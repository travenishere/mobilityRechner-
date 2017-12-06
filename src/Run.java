import java.time.Duration;

public class Run {
	
	public static void main(String[] args) {
		
		Calculator c1 = new Calculator();
		
		// TODO implement functions within the Class Calculator for the following functionalities
		
		
		// start date time
		LocalDateTime startDateTime = c1.parseStringToDateformat(c1.readInput("starting reservation")); 
		c1.startDateTime = startDateTime;
		
		// end date time
		LocalDateTime endDateTime= c1.parseStringToDateformat(c1.readInput("ending reservation"));
		c1.endDateTime =  endDatetime;
		
		// choose category
		c1.chooseCategory();
		
		// calculate hours
		c1.timeAmount = (Duration.between(c1.startDateTime, c1.endDateTime).toMinutes()/60.00);
		
		
		// print to console
		System.out.println("TIME COSTS \n Duration: " + c1.timeAmount +" h"+ "\n Tarif: "+hrPrice+" sFr."+"\n Total: " + c1.timeAmount* hrPrice+" sFr." );
		System.out.println("KM COSTS \n Km: " + c1.kmAmount + "\n Tarif: "+kmPrice+" sFr.\n Total: " + c1.kmAmount* kmPrice+" sFr." );
		System.out.println("TOTAL COSTS: "+(c1.timeAmount* hrPrice + c1.kmAmount* kmPrice+" sFr." )); 
		
	}
	
}
