package main;
import java.time.Duration;
import java.time.LocalDateTime;

public class Run {
	
	public static void main(String[] args) {
		
		Calculator c1 = new Calculator();
		Car car = new Car();
		
		// TODO implement functions within the Class Calculator for the following functionalities
		
		
	    
		// start date time
		c1.setStartDateTime(c1.readInput("starting reservation"));
				
		
		// end date time
		c1.setEndDateTime(c1.readInput("ending reservation"));
				
		
		// set car by choosing a category
		car = new Car(Car.chooseCategory());
		
		
		// calculate hours
		c1.calculateHours();
		
		
		// print to console
		c1.printOutResult();
		
	}
	
}
