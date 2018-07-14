/**
 * An Integer like class but holds some uncertainty information good for number puzzles 
 * @author Jacob Engelbrecht
 * @since 2018-07-06
 * @version 0.9
 */
public class Number {
	
	// The size of the board, as determined by the Board Class 
	private int size; 
	
	// Store the integer if it is known
	private Integer number = null; 
	
	// An array of the nine numbers to keep track of what a given number could be 
	private boolean[] possible; 
	
	// Maybe to be used in fx to delineate known numbers ahead of time 
	private boolean wasGiven = false; 
	
	// Whether of not the values is known 
	private boolean known = false; 
	
	// Whether or not the values is a temporary guess when attempting to find the solution 
	private boolean guess = false; 
	
	/**
	 * Configures a given number element 
	 * @param size The size of the board 
	 */
	public Number(int size) {
		this.size = size; 
		this.possible = new boolean[size * size];
		for(int i = 0; i < possible.length; i++)
			possible[i] = true; 
	}
	
	/**
	 * Configures a given number element when the values of the number is known 
	 * @param size The size of the board 
	 * @param num The values of the cell 
	 */
		public Number(int size, int num) {
			this.size = size; 
			this.possible = new boolean[size * size];
			for(int i = 0; i < possible.length; i++)
				possible[i] = true; 
			number = num; 
			wasGiven = true; 
		}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		if(number > 0 && number <= size * size) {
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

	public boolean isGuess() {
		return guess;
	}

	public void setGuess(boolean guess) {
		this.guess = guess;
	}
	
	public String toString() {
		return number.toString(); 
	}

}
