import java.util.Iterator;
import java.util.LinkedList;

/**
 * Represents one Square of a sudoku board with added functionality. 
 * @author Jacob Engelbrecht
 * @since 2018-07-06
 * @version 0.9
 */
public class Square {
	
	// Stores the size of the board, arrives from Board 
	private int size;
	
	// Stores all the numbers in the board in the form of a 1D array 
	private LinkedList<Number> nums = new LinkedList<>(); 
	
	/**
	 * The Constructor for a generic number with no given unique qualities 
	 * @param size The size of the board which is being used 
	 */
	public Square(int size) {
		this.size = size; 
		for(int x = 0; x < (size * size); x++)
			nums.add(new Number(this.size));
	}
	
	/**
	 * The constuctor if the square is to be populated with values 
	 * @param size The size of the board which the square is being used 
	 * @param values The values in the form of a linked list which contain the location and values of any given cells 
	 */
	public Square(int size, LinkedList<Integer> values) {
		this.size = size; 
		for(int x = 0; x < (size * size); x++)
			nums.add(new Number(this.size));
		if(values.size() % 2 == 0) {
			Iterator<Integer> iter = values.iterator(); 
			while(iter.hasNext()) {
				int location = iter.next(); 
				if(location > (nums.size() + 1))
					iter.next();
				else {
					nums.get(location - 1).setNumber(iter.next());
					nums.get(location - 1).setGiven(true);
				}
			}
		}
	}
	
	/**
	 * This is a multifacited method to change any number with relative ease in the square 
	 * @param location which of the nine locations would you like to set
	 * @param value what is the value which you wan to set at the location
	 */
	public void set(int location, int value) {
		if(location <= (nums.size() + 1))
			nums.get(location - 1).setNumber(value);
	}
	
	/**
	 * Returns all numbers in a given row of the Square
	 * @param row The row which is to be returned
	 * @return ALL number elements inside of the requested row 
	 */
	public Number[] getRow(int row) {
		Number[] array = new Number[size]; 
		if(row < size) {
			int i = 0;
			for(int x = (row * size); x < ((row + 1) * size); x++)
				array[i++] = nums.get(x); 
		}
		return array; 
	}
	
	/**
	 * Returns all numbers in a given Column of the Square 
	 * @param col THe column whose element are to be returned 
	 * @return ALL number elements who exist inside the column 
	 */
	public Number[] getCol(int col) {
		Number[] array = new Number[size]; 
		if(col < size) {
			int inc = 0; 
			for(int x = 0; x < nums.size(); x++)
				if(x % size == col)
					array[inc++] = nums.get(x); 
		}
		return array; 
	}
	
	/**
	 * Returns the values inside the square which are known to some level of certainty 
	 * @return Integer representations of the known values in the Square 
	 */
	public LinkedList<Integer> getKnown() {
		LinkedList<Integer> known = new LinkedList<>(); 
		for(Number current : nums)
			if(current.getNumber() != null)
				known.add(current.getNumber()); 
		return known; 
	}
	
	/**
	 * Returns the Number element at a given cell location 
	 * @param number The cell location inside of the Square 
	 * @return The Number element at the given location inside of the Square 
	 */
	public Number getNum(int number) {
		return nums.get(number);
	}
	
	/**
	 * Takes a linked list like that of the two input constructor and completely reformats the Square 
	 * @param values The values which will be used to populate the Square 
	 */
	public void update(LinkedList<Integer> values) {
		nums.clear();
		for(int x = 0; x < (size * size); x++)
			nums.add(new Number(this.size));
		if(values.size() % 2 == 0) {
			Iterator<Integer> iter = values.iterator(); 
			while(iter.hasNext()) {
				int location = iter.next(); 
				if(location > (nums.size() + 1))
					iter.next();
				else {
					nums.get(location - 1).setNumber(iter.next());
					nums.get(location - 1).setGiven(true);
				}
			}
		}
	}
	
}
