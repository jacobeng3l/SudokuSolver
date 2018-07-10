/**
 * An Integer like class but holds some uncertainty information good for number puzzles 
 * @author Jacob Engelbrecht
 * @since 2018-07-06
 * @version 0.9
 */
public class Number {
	
	// Store the integer if it is known
	private Integer number = null; 
	
	// An array of the nine numbers to keep track of what a given number could be 
	private boolean[] possible = new boolean[9]; 
	
	// Maybe to be used in fx to delineate known numbers ahead of time 
	private boolean wasGiven = false; 
	
	private boolean known = false; 
	
	// Sets number if it is known
	public Number(int number) {
		for(int i = 0; i < possible.length; i++)
			possible[i] = true; 
		this.setNumber(number); 
	}
	
	// Configures the number if nothing is known 
	public Number() {
		for(int i = 0; i < possible.length; i++)
			possible[i] = true; 
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		if(number > 0 && number <= 9) {
			this.number = number;
			this.known = true; 
		}
	}

	public boolean[] getPossible() {
		return possible;
	}

	public void setPossible(boolean[] possible) {
		this.possible = possible;
	}
	
	public void setGiven(boolean wasGiven) {
		this.wasGiven = wasGiven; 
		this.known = wasGiven; 
	}
	
	public boolean getGiven() {
		return wasGiven;
	}
	
	public boolean getKnown() {
		return known; 
	}

}
