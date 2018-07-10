import java.util.Iterator;
import java.util.LinkedList; 

/**
 * Holds the complete representation of a sudoku board 
 * @author Jacob Engelbrecht
 * @since 2018-07-06
 * @version 0.9
 */
public class Board {
	
	private final int boardSize = 3; 
	
	//Each Board is made of nine squares 
	private Square TopLeft = new Square();
	private Square TopMid = new Square();
	private Square TopRight = new Square();
	private Square MidLeft = new Square();
	private Square Center = new Square(); 
	private Square MidRight = new Square(); 
	private Square BottomLeft = new Square(); 
	private Square BottomMid = new Square();
	private Square BottomRight = new Square();
	
	// Constructor for empty board (good for future fx usage)
	public Board() {
		;
	}
	
	// Constructor for population with known data in form of Linked List of Linked List 
	public Board(LinkedList<LinkedList<Integer>> values) {
		if(values.size() % 2 == 0) {
			Iterator<LinkedList<Integer>> iter = values.iterator(); 
			while(iter.hasNext()) {
				int location = iter.next().get(0); 
				switch (location) {
					case 1: setTopLeft(new Square(iter.next()));
							break;
					case 2: setTopMid(new Square(iter.next()));
							break;
					case 3: setTopRight(new Square(iter.next()));
							break;	
					case 4: setMidLeft(new Square(iter.next()));
							break;
					case 5: setCenter(new Square(iter.next()));
							break;
					case 6: setMidRight(new Square(iter.next()));
							break;
					case 7: setBottomLeft(new Square(iter.next()));
							break;
					case 8: setBottomMid(new Square(iter.next()));
							break;
					case 9: setBottomRight(new Square(iter.next()));
							break;
					default: iter.next();		
				}
			}
		}
	}

	public Square getTopLeft() {
		return TopLeft;
	}

	public void setTopLeft(Square topLeft) {
		TopLeft = topLeft;
	}

	public Square getTopMid() {
		return TopMid;
	}

	public void setTopMid(Square topMid) {
		TopMid = topMid;
	}

	public Square getTopRight() {
		return TopRight;
	}

	public void setTopRight(Square topRight) {
		TopRight = topRight;
	}

	public Square getMidLeft() {
		return MidLeft;
	}

	public void setMidLeft(Square midLeft) {
		MidLeft = midLeft;
	}

	public Square getCenter() {
		return Center;
	}

	public void setCenter(Square center) {
		Center = center;
	}

	public Square getMidRight() {
		return MidRight;
	}

	public void setMidRight(Square midRight) {
		MidRight = midRight;
	}

	public Square getBottomLeft() {
		return BottomLeft;
	}

	public void setBottomLeft(Square bottomLeft) {
		BottomLeft = bottomLeft;
	}

	public Square getBottomMid() {
		return BottomMid;
	}

	public void setBottomMid(Square bottomMid) {
		BottomMid = bottomMid;
	}

	public Square getBottomRight() {
		return BottomRight;
	}

	public void setBottomRight(Square bottomRight) {
		BottomRight = bottomRight;
	}
	
	/**
	 * Simplifies the process of finding all the Integer values in a given row 
	 * @param row the row number which the Integer values are desired
	 * @return the integers in an array form of any row 
	 */
	public Integer[] getRow(int row) {
		row += 1;
		Integer[] nums = new Integer[getBoardSize() * getBoardSize()];
		Square one; 
		Square two; 
		Square three; 
		if(row <= 3) {
			one = getTopLeft();
			two = getTopMid(); 
			three = getTopRight(); 
		}
		else if(row <= 6) { 
			one = getMidLeft();
			two = getCenter(); 
			three = getMidRight(); 
		}
		else {
			one = getBottomLeft();
			two = getBottomMid(); 
			three = getBottomRight(); 
		}
		switch(row % 3) {
			case 1: Number[] test = one.getTopRow();
					for(int i = 0; i < 3; i++) {
						nums[i] = test[i].getNumber();
					}
					Number[] test2 = two.getTopRow();
					for(int i = 3; i < 6; i++) {
						nums[i] = test2[i - 3].getNumber();
					}
					Number[] test3 = three.getTopRow();
					for(int i = 6; i < 9; i++) {
						nums[i] = test3[i - 6].getNumber();
					}
					break; 
			case 2: Number[] testi = one.getMidRow();
					for(int i = 0; i < 3; i++) {
						nums[i] = testi[i].getNumber();
					}
					Number[] testi2 = two.getMidRow();
					for(int i = 3; i < 6; i++) {
						nums[i] = testi2[i - 3].getNumber();
					}
					Number[] testi3 = three.getMidRow();
					for(int i = 6; i < 9; i++) {
						nums[i] = testi3[i - 6].getNumber();
					}
					break; 
			case 0: Number[] testb = one.getBottomRow();
					for(int i = 0; i < 3; i++) {
						nums[i] = testb[i].getNumber();
					}
					Number[] testb2 = two.getBottomRow();
					for(int i = 3; i < 6; i++) {
						nums[i] = testb2[i - 3].getNumber();
					}
					Number[] testb3 = three.getBottomRow();
					for(int i = 6; i < 9; i++) {
						nums[i] = testb3[i - 6].getNumber();
					}
					break;
		}
		return nums;
	}

	public LinkedList<Integer> getRowNums(int row){
		Integer[] nums = getRow(row); 
		LinkedList<Integer> rowNums = new LinkedList<>(); 
		for(Integer num : nums)
			if(num != null)
				rowNums.add(num); 
		return rowNums; 
	}
	
	
	public Integer[] getCol(int col) {
		col += 1; 
		Integer[] nums = new Integer[getBoardSize() * getBoardSize()];
		Square one; 
		Square two; 
		Square three; 
		if(col <= 3) {
			one = getTopLeft();
			two = getMidLeft(); 
			three = getBottomLeft(); 
		}
		else if(col <= 6) { 
			one = getTopMid();
			two = getCenter(); 
			three = getBottomMid(); 
		}
		else {
			one = getTopRight();
			two = getMidRight(); 
			three = getBottomRight(); 
		}
		switch(col % 3) {
			case 1: Number[] test = one.getFirstCol();
					for(int i = 0; i < 3; i++) {
						nums[i] = test[i].getNumber();
					}
					Number[] test2 = two.getFirstCol();
					for(int i = 3; i < 6; i++) {
						nums[i] = test2[i - 3].getNumber();
					}
					Number[] test3 = three.getFirstCol();
					for(int i = 6; i < 9; i++) {
						nums[i] = test3[i - 6].getNumber();
					}
					break; 
			case 2: Number[] testi = one.getMidCol();
					for(int i = 0; i < 3; i++) {
						nums[i] = testi[i].getNumber();
					}
					Number[] testi2 = two.getMidCol();
					for(int i = 3; i < 6; i++) {
						nums[i] = testi2[i - 3].getNumber();
					}
					Number[] testi3 = three.getMidCol();
					for(int i = 6; i < 9; i++) {
						nums[i] = testi3[i - 6].getNumber();
					}
					break; 
			case 0: Number[] testb = one.getThirdCol();
					for(int i = 0; i < 3; i++) {
						nums[i] = testb[i].getNumber();
					}
					Number[] testb2 = two.getThirdCol();
					for(int i = 3; i < 6; i++) {
						nums[i] = testb2[i - 3].getNumber();
					}
					Number[] testb3 = three.getThirdCol();
					for(int i = 6; i < 9; i++) {
						nums[i] = testb3[i - 6].getNumber();
					}
					break;
		}
		return nums;
	}

	public LinkedList<Integer> getColNums(int col){
		Integer[] nums = getCol(col); 
		LinkedList<Integer> colNums = new LinkedList<>(); 
		for(Integer num : nums)
			if(num != null)
				colNums.add(num); 
		return colNums; 
	}

	/**
	 * Simple console visualization of a sudoku board  
	 */
	public void print() {
		int box = 0;
		for(int i = 0; i < 36; i++) {
			if(i % 4 == 0) {
				for(int j = 0; j < 73; j++)
					System.out.print("-");
				System.out.println("");
				}
			else {
				if(i % 2 == 0) {
					Integer[] nums = getRow(box); 
					for(int k = 0; k < 9; k++) {
						if(nums[k] != null)
							System.out.print("|   " + nums[k] + "   ");
						else
							System.out.print("|\t");							
					}
					System.out.println("|");
					box++; 
				}
				else {
					for(int k = 0; k < 9; k++)
						System.out.print("|\t");
					System.out.println("|");
				}
			}
		}
		for(int j = 0; j < 73; j++)
			System.out.print("-");
		System.out.println();		
	}

	public int getBoardSize() {
		return boardSize;
	}
	
	public int getNumUnits() {
		return boardSize * boardSize * boardSize * boardSize; 
	}
	
	public Square getSquare(int location) {
		Square current; 
		if(location < (getBoardSize() * getBoardSize() * getBoardSize())) {
			if(location % 9 < 3)
				current = getTopLeft(); 
			else if (location % 9 < 6)
				current = getTopMid(); 
			else
				current = getTopRight(); 
		}
		else if(location < (getBoardSize() * getBoardSize() * getBoardSize() * 2)) {
			if(location % 9 < 3)
				current = getMidLeft(); 
			else if (location % 9 < 6)
				current = getCenter(); 
			else
				current = getMidRight(); 
		}
		else {
			if(location % 9 < 3)
				current = getBottomLeft(); 
			else if (location % 9 < 6)
				current = getBottomMid(); 
			else
				current = getBottomRight(); 
		}
		return current; 
	}
	
	public Number getNumber(int location) {
		Number current; 
		Square square = getSquare(location); 
		if(location % 3 == 0) {
			if((location / 9) % 3 == 0) 
				current = square.getNum(0);
			else if((location / 9) % 3 == 1) 
				current = square.getNum(3);
			else 
				current = square.getNum(6);
		}
		else if(location % 3 == 1) {
			if((location / 9) % 3 == 0) 
				current = square.getNum(1);
			else if((location / 9) % 3 == 1) 
				current = square.getNum(4);
			else 
				current = square.getNum(7);
		}
		else {
			if((location / 9) % 3 == 0) 
				current = square.getNum(2);
			else if((location / 9) % 3 == 1) 
				current = square.getNum(5);
			else 
				current = square.getNum(8);
		}
		return current; 
	}
	
}
