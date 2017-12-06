package main;
import java.time.LocalDateTime;

/**
 * 
 * method to save start and end date and time
 * and to calculate hours in between
 *
 */
public class TimePeriod {
	
	private LocalDateTime start; 
	private LocalDateTime end; 
	private double hours;  
	
	/**
	 * 
	 */
	public TimePeriod() {
		
	}
	
	/**
	 * 
	 * @param starttime
	 * @param endtime
	 */
	public TimePeriod(final LocalDateTime start, final LocalDateTime end) {
		this.start = start;
		this.end = end;
		calculateHours();
	}
	
	/**
	 * 
	 */
	private void calculateHours() {
		
		// TODO
		
	}
	
	/**
	 * 
	 * @param starttime
	 */
	public void setStart(final LocalDateTime start) {
		this.start = start;
		calculateHours();
	}
	
	/**
	 * 
	 * @param endtime
	 */
	public void setEnd(final LocalDateTime end) {
		this.end = end;
		calculateHours();
	}
	
	/**
	 * 
	 * @return starttime
	 */
	public LocalDateTime getStart() {
		return start;
	}
	
	/**
	 * 
	 * @return endtime
	 */
	public LocalDateTime getEnd() {
		return end;
	}

}
