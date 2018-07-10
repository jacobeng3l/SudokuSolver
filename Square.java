import java.util.Iterator;
import java.util.LinkedList;

/**
 * Represents one Square of a sudoku board with added functionality. 
 * @author Jacob Engelbrecht
 * @since 2018-07-06
 * @version 0.9
 */
public class Square {
	// Each square is made of nine numbers 
	private Number one = new Number(); 
	private Number two = new Number(); 
	private Number three = new Number();
	private Number four = new Number(); 
	private Number five = new Number(); 
	private Number six = new Number(); 
	private Number seven = new Number(); 
	private Number eight = new Number();
	private Number nine = new Number(); 
	
	private LinkedList<Number> nums = new LinkedList<>(); 
	
	// Empty constructor 
	public Square() {
		nums.add(one);
		nums.add(two);
		nums.add(three);
		nums.add(four);
		nums.add(five);
		nums.add(six);
		nums.add(seven);
		nums.add(eight);
		nums.add(nine);
	}
	
	// Constructor with known values 
	public Square(LinkedList<Integer> values) {
		if(values.size() % 2 == 0) {
			Iterator<Integer> iter = values.iterator(); 
			while(iter.hasNext()) {
				int location = iter.next(); 
				switch (location) {
					case 1: one.setNumber(iter.next());
							one.setGiven(true);
							break;
					case 2: two.setNumber(iter.next());
							two.setGiven(true);
							break;
					case 3: three.setNumber(iter.next());
							three.setGiven(true);
							break;	
					case 4: four.setNumber(iter.next());
							four.setGiven(true);
							break;
					case 5: five.setNumber(iter.next());
							five.setGiven(true);
							break;
					case 6: six.setNumber(iter.next());
							six.setGiven(true);
							break;
					case 7: seven.setNumber(iter.next());
							seven.setGiven(true);
							break;
					case 8: eight.setNumber(iter.next());
							eight.setGiven(true);
							break;
					case 9: nine.setNumber(iter.next());
							nine.setGiven(true);
							break;
					default: iter.next();		
				}
			}
		}
		nums.add(one);
		nums.add(two);
		nums.add(three);
		nums.add(four);
		nums.add(five);
		nums.add(six);
		nums.add(seven);
		nums.add(eight);
		nums.add(nine);
	}
	
	/**
	 * This is a multifacited method to change any number with relative ease in the square 
	 * @param location which of the nine locations would you like to set
	 * @param value what is the value which you wan to set at the location
	 */
	public void set(int location, int value) {
		switch (location) {
			case 1: one.setNumber(value);
					break;
			case 2: two.setNumber(value);
					break;
			case 3: three.setNumber(value);
					break;	
			case 4: four.setNumber(value);
					break;
			case 5: five.setNumber(value);
					break;
			case 6: six.setNumber(value);
					break;
			case 7: seven.setNumber(value);
					break;
			case 8: eight.setNumber(value);
					break;
			case 9: nine.setNumber(value);
					break;
		}
	}
	
	public Number[] getTopRow() {
		return new Number[] {one, two, three}; 
	}
	
	public Number[] getMidRow() {
		return new Number[] {four, five, six}; 
	}
	
	public Number[] getBottomRow() {
		return new Number[] {seven, eight, nine}; 
	}
	
	public Number[] getFirstCol() {
		return new Number[] {one, four, seven}; 
	}
	
	public Number[] getMidCol() {
		return new Number[] {two, five, eight}; 
	}
	
	public Number[] getThirdCol() {
		return new Number[] {three, six, nine}; 
	}
	
	public LinkedList<Integer> getKnown() {
		LinkedList<Integer> known = new LinkedList<>(); 
		for(Number current : nums)
			if(current.getNumber() != null)
				known.add(current.getNumber()); 
		return known; 
	}
	
	public Number getNum(int number) {
		return nums.get(number);
	}
	
}
