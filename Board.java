import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList; 

/**
 * Holds the complete representation of a sudoku board 
 * @author Jacob Engelbrecht
 * @since 2018-07-06
 * @version 0.9
 */
public class Board {
	
	// THE DEFINITION OF THE SIDE OF THE BOARD, THIS PROGRAM IS SCALABLE 
	private int boardSize = 3; 
	
	// Holds the squares which each board is made of, note not stored in a 2D array 
	private ArrayList<Square> board = new ArrayList<>(boardSize * boardSize); 
	
	/**
	 *  Constructor for empty board (good for future fx usage)
	 */
	public Board() {
		for(int x = 0; x < (boardSize * boardSize); x++)
			board.add(new Square(boardSize));
	}
	
	/**
	 * Constructor for population with known data in form of Linked List of Linked List 
	 * @param values A Linked List of Linked List Integers where one index is an index of the square the next is the index of the square. 
	 */
	public Board(LinkedList<LinkedList<Integer>> values) {
		for(int x = 0; x < (boardSize * boardSize); x++)
			board.add(new Square(boardSize));
		if(values.size() % 2 == 0) {
			Iterator<LinkedList<Integer>> iter = values.iterator(); 
			while(iter.hasNext()) {
				int location = iter.next().get(0); 
				if(location <= boardSize * boardSize && location > 0)
					board.get(location - 1).update(iter.next());
				else
					iter.next();
			}
		}
	}

	/**
	 * Simplifies the process of finding all the Integer values in a given row 
	 * @param row the row number which the Integer values are desired
	 * @return the integers in an array form of any row 
	 */
	public Integer[] getRow(int row) {
		Integer[] nums = new Integer[boardSize * boardSize];
		if(row < (boardSize * boardSize)) {
			int i = 0;
			for(int x = (row / boardSize) * boardSize; x < ((row + boardSize) / boardSize) * boardSize; x++)
				for(int z = 0; z < boardSize; z++)
					nums[i++] = board.get(x).getRow(row % boardSize)[z].getNumber(); 
		}
		return nums;
	}

	/**
	 * Returns only the occupied numbers of a given Row (excluding null values)
	 * @param row The row to which extract the values from
	 * @return The integer values in any row of the Sudoku 
	 */
	public LinkedList<Integer> getRowNums(int row){
		Integer[] nums = getRow(row); 
		LinkedList<Integer> rowNums = new LinkedList<>(); 
		for(Integer num : nums)
			if(num != null)
				rowNums.add(num); 
		return rowNums; 
	}
	
	/**
	 * Simplifies the process of finding all the Integer values in a given column 
	 * @param col The column which is going to be searched 
	 * @return This will return EVERY integer in the column, including that of null values 
	 */
	public Integer[] getCol(int col) {
		Integer[] nums = new Integer[boardSize * boardSize];
		if(col < (boardSize * boardSize)) {
			int i = 0;
			for(int x = col / boardSize; x < boardSize * boardSize; x += boardSize)
				for(int z = 0; z < boardSize; z++)
					nums[i++] = board.get(x).getCol(col % boardSize)[z].getNumber(); 
		}
		return nums;
	}

	/**
	 * Returns only the integers present in a column, rejecting the null values
	 * @param col The column which is to be searched
	 * @return The integer values in any column of the Sudoku 
	 */
	public LinkedList<Integer> getColNums(int col){
		Integer[] nums = getCol(col); 
		LinkedList<Integer> colNums = new LinkedList<>(); 
		for(Integer num : nums)
			if(num != null)
				colNums.add(num); 
		return colNums; 
	}

	/**
	 * Simple console visualization of a sudoku board in consul 
	 */
	public void print() {
		int box = 0;
		for(int i = 0; i < (4 * boardSize * boardSize); i++) {
			if(i % 4 == 0) {
				for(int j = 0; j < (8 * boardSize * boardSize); j++)
					System.out.print("-");
				System.out.println("");
				}
			else {
				if(i % 2 == 0) {
					Integer[] nums = getRow(box); 
					for(int k = 0; k < (boardSize * boardSize); k++) {
						if(nums[k] != null)
							System.out.print("|   " + nums[k] + "   ");
						else
							System.out.print("|\t");							
					}
					System.out.println("|");
					box++; 
				}
				else {
					for(int k = 0; k < (boardSize * boardSize); k++)
						System.out.print("|\t");
					System.out.println("|");
				}
			}
		}
		for(int j = 0; j < 73; j++)
			System.out.print("-");
		System.out.println();		
	}

	/**
	 * Returns board size
	 * @return Board Size 
	 */
	public int getBoardSize() {
		return boardSize;
	}
	
	/**
	 * Returns the total number of cells that exist in a given Sudoku 
	 * @return Total number of cells. 
	 */
	public int getNumUnits() {
		return boardSize * boardSize * boardSize * boardSize; 
	}
	
	/**
	 * Returns the square which any given cell is located inside. 
	 * @param location The location of the cell 
	 * @return The square which contains that cell 
	 */
	public Square getSquare(int location) {
		int region = location / (boardSize * boardSize * boardSize); 
		int side = (location / boardSize) % boardSize; 
		Square square = board.get((boardSize * region) + side); 
		return square; 
	}
	
	/**
	 * Returns the number at any cell of the Sudoku 
	 * @param location The location of the cell on the board 
	 * @return The Number representation of the cell 
	 */
	public Number getNumber(int location) {
		Number current; 
		int region = location / (boardSize * boardSize * boardSize); 
		int side = (location / boardSize) % boardSize; 
		Square square = board.get((boardSize * region) + side); 
		int num = location - (region * boardSize * boardSize * boardSize); 
		int mod = num % boardSize; 
		int oth = num / (boardSize * boardSize); 
		int fin = mod + (boardSize * oth); 
		current = square.getNum(fin);
		return current; 
	}
	
}
