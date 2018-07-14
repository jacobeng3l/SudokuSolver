import java.util.LinkedList;

/**
 * A class which creates, populates, and solves a sudoku board puzzle. 
 * @author Jacob Engelbrecht 
 * @since 2018-07-06
 * @version 0.9
 */
public class Game {
	
	// Stores the instance of the game 
	private static Board game; 
	
	// Stores the size of the game board as set in the Board class, used of solving 
	private static int size; 
	
	// Value used for tracking progress towards solutions 
	private static int unknown = Integer.MAX_VALUE; 
	
	/**
	 * The method that is run to populate and solve a puzzle 
	 * @param args Arguments are not used currently 
	 */
	public static void main(String... args) {
//		game = new Board(buildBoard()); 
		game = new Board();
		size = game.getBoardSize(); 
		game.print(); 
		System.out.println("\n------------------------------------------------------------------------------------\n");
		solve(); 
		game.print();
		System.out.println("Game Complete");
	}
/*
	// populates the sudoku board (to be replaced by UI hopefully)
		private static LinkedList<LinkedList<Integer>> buildBoard() {
			LinkedList<LinkedList<Integer>> input = new LinkedList<>(); 
			
			LinkedList<Integer> quadrant2 = new LinkedList<>();
			quadrant2.add(2); 
			LinkedList<Integer> values2 = new LinkedList<>();
			Integer[] test2 = new Integer[] {1, 7, 2, 8, 3, 1, 5, 9};
			for(Integer in : test2)
				values2.add(in);
			input.add(quadrant2);
			input.add(values2); 
			
			LinkedList<Integer> quadrant3 = new LinkedList<>();
			quadrant3.add(3); 
			LinkedList<Integer> values3 = new LinkedList<>();
			Integer[] test3 = new Integer[] {1, 2, 7, 4, 8, 8,};
			for(Integer in : test3)
				values3.add(in);
			input.add(quadrant3);
			input.add(values3); 
			
			LinkedList<Integer> quadrant4 = new LinkedList<>();
			quadrant4.add(4); 
			LinkedList<Integer> values4 = new LinkedList<>();
			Integer[] test4 = new Integer[] {1, 8, 2, 9, 4, 6, 7, 7};
			for(Integer in : test4)
				values4.add(in);
			input.add(quadrant4);
			input.add(values4); 
			
			LinkedList<Integer> quadrant5 = new LinkedList<>();
			quadrant5.add(5); 
			LinkedList<Integer> values5 = new LinkedList<>();
			Integer[] test5 = new Integer[] {8, 4, 9, 6};
			for(Integer in : test5)
				values5.add(in);
			input.add(quadrant5);
			input.add(values5); 
			
			LinkedList<Integer> quadrant6 = new LinkedList<>();
			quadrant6.add(6); 
			LinkedList<Integer> values6 = new LinkedList<>();
			Integer[] test6 = new Integer[] {3, 4, 4, 1};
			for(Integer in : test6)
				values6.add(in);
			input.add(quadrant6);
			input.add(values6); 
			
			LinkedList<Integer> quadrant7 = new LinkedList<>();
			quadrant7.add(7); 
			LinkedList<Integer> values7 = new LinkedList<>();
			Integer[] test7 = new Integer[] {2, 5, 3, 3, 8, 4};
			for(Integer in : test7)
				values7.add(in);
			input.add(quadrant7);
			input.add(values7); 
			
			LinkedList<Integer> quadrant8 = new LinkedList<>();
			quadrant8.add(8); 
			LinkedList<Integer> values8 = new LinkedList<>();
			Integer[] test8 = new Integer[] {2, 6, 3, 7, 8, 2};
			for(Integer in : test8)
				values8.add(in);
			input.add(quadrant8);
			input.add(values8); 
			
			LinkedList<Integer> quadrant9 = new LinkedList<>();
			quadrant9.add(9); 
			LinkedList<Integer> values9 = new LinkedList<>();
			Integer[] test9 = new Integer[] {1, 9, 8, 1, 9, 3};
			for(Integer in : test9)
				values9.add(in);
			input.add(quadrant9);
			input.add(values9); 
			
			return input; 
		}
	
	
	// populates the sudoku board (to be replaced by UI hopefully)
	private static LinkedList<LinkedList<Integer>> buildBoard() {
		LinkedList<LinkedList<Integer>> input = new LinkedList<>(); 
		
		LinkedList<Integer> quadrant1 = new LinkedList<>();
		quadrant1.add(1); 
		LinkedList<Integer> values1 = new LinkedList<>();
		Integer[] test1 = new Integer[] {4, 6, 5, 8, 7, 1, 8, 9};
		for(Integer in : test1)
			values1.add(in);
		input.add(quadrant1);
		input.add(values1); 
		
		LinkedList<Integer> quadrant2 = new LinkedList<>();
		quadrant2.add(2); 
		LinkedList<Integer> values2 = new LinkedList<>();
		Integer[] test2 = new Integer[] {1, 2, 2, 6, 5, 7, 9, 4};
		for(Integer in : test2)
			values2.add(in);
		input.add(quadrant2);
		input.add(values2); 
		
		LinkedList<Integer> quadrant3 = new LinkedList<>();
		quadrant3.add(3); 
		LinkedList<Integer> values3 = new LinkedList<>();
		Integer[] test3 = new Integer[] {1, 7, 3, 1, 5, 9, 7, 5};
		for(Integer in : test3)
			values3.add(in);
		input.add(quadrant3);
		input.add(values3); 
		
		LinkedList<Integer> quadrant4 = new LinkedList<>();
		quadrant4.add(4); 
		LinkedList<Integer> values4 = new LinkedList<>();
		Integer[] test4 = new Integer[] {1, 8, 2, 2, 6, 4, 8, 5};
		for(Integer in : test4)
			values4.add(in);
		input.add(quadrant4);
		input.add(values4); 
		
		LinkedList<Integer> quadrant5 = new LinkedList<>();
		quadrant5.add(5); 
		LinkedList<Integer> values5 = new LinkedList<>();
		Integer[] test5 = new Integer[] {1, 1, 4, 6, 6, 2, 9, 3};
		for(Integer in : test5)
			values5.add(in);
		input.add(quadrant5);
		input.add(values5); 
		
		LinkedList<Integer> quadrant6 = new LinkedList<>();
		quadrant6.add(6); 
		LinkedList<Integer> values6 = new LinkedList<>();
		Integer[] test6 = new Integer[] {2, 4, 4, 9, 8, 2, 9, 8};
		for(Integer in : test6)
			values6.add(in);
		input.add(quadrant6);
		input.add(values6); 
		
		LinkedList<Integer> quadrant7 = new LinkedList<>();
		quadrant7.add(7); 
		LinkedList<Integer> values7 = new LinkedList<>();
		Integer[] test7 = new Integer[] {3, 9, 5, 4, 7, 7, 9, 3};
		for(Integer in : test7)
			values7.add(in);
		input.add(quadrant7);
		input.add(values7); 
		
		LinkedList<Integer> quadrant8 = new LinkedList<>();
		quadrant8.add(8); 
		LinkedList<Integer> values8 = new LinkedList<>();
		Integer[] test8 = new Integer[] {1, 3, 5, 5, 8, 1, 9, 8};
		for(Integer in : test8)
			values8.add(in);
		input.add(quadrant8);
		input.add(values8); 
		
		LinkedList<Integer> quadrant9 = new LinkedList<>();
		quadrant9.add(9); 
		LinkedList<Integer> values9 = new LinkedList<>();
		Integer[] test9 = new Integer[] {2, 7, 3, 4, 5, 3, 6, 6};
		for(Integer in : test9)
			values9.add(in);
		input.add(quadrant9);
		input.add(values9); 
		
		return input; 
	}
*/
	

	/**
	 * Takes the generic instance of the sudoku board and attempts to solve it if possible. 
	 */
	private static void solve() {
		while (unknown != 0) {
//		for(int x = 0; x < 9; x++) {
//			game.print();
			int prevUnknown = unknown; 
			unknown = 0;
			for(int pos = 0; pos < game.getNumUnits(); pos++) {
				if(!game.getNumber(pos).getKnown()) {
					updateNumber(pos); 
				}
			}
			if (prevUnknown == unknown) {
				// Here is where the logic for guessing to solve will go 
				System.out.println("ERRRR");
				break; 
			}
		}
	}

	/**
	 * Checks the Row, Column, and Square in hopes of narrowing the possible values of a given cell. 
	 * @param pos The position of the current cell being inspected. 
	 */
	private static void updateNumber(int pos) {
		Number num = game.getNumber(pos); 
		LinkedList<Integer> col = game.getColNums(pos % (size * size));
		LinkedList<Integer> row = game.getRowNums(pos / (size * size)); 
		LinkedList<Integer> sqr = game.getSquare(pos).getKnown(); 
		for(Integer cur : col) {
			boolean[] bools = num.getPossible();
			bools[cur - 1] = false; 
			num.setPossible(bools);
		}
		for(Integer cur : row) {
			boolean[] bools = num.getPossible();
			bools[cur - 1] = false; 
			num.setPossible(bools);
		}
		for(Integer cur : sqr) {
			boolean[] bools = num.getPossible();
			bools[cur - 1] = false; 
			num.setPossible(bools);
		}
		int count = 0; 
		int posNum = 0;
		boolean[] bools = num.getPossible(); 
		for(int i = 0; i < bools.length; i++) {
			if(bools[i]) {
				count++; 
				posNum = i + 1; 
			}
		}
		if (count == 1)
			num.setNumber(posNum);
		else
			unknown++; 
	}

}
