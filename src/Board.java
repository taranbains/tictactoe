//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 

/** Class Board 
 * 
 * Includes all the methods for the board including:
 *  - what characters go where in the board 
 *  - printing board in a nice format to the terminal 
 *  - checking if X or O is the winner
 *  - checking if the board is full  
 *  
 * @author bains
 */
public class Board implements Constants {
	private char theBoard[][];
	private int markCount; 						// how many marks (X or O) have been put down 

	/** 
	 * Board() Constructor
	 * Initializes a 2d array theBoard    
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][]; 				// array has 3 rows 
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];			// each array has a length of 3 
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR; 	// array initially all empty spaces 
		}
	}
	
	/** 
	 * Method getMark() returns the value inside a specific spot on the board 
	 * @param row: int
	 * @param col: int
	 * @return theBoard[row][col]: char
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/** 
	 * Method isFull() returns a true to false depending on if their have been 
	 * 9 marks placed on the board. 
	 * @return True or False
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/** 
	 * Method xWins() returns true or false if X has won or not.
	 * @return True or False
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/** 
	 * Method oWins() returns true or false if O has won or not. 
	 * @return True or False 
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/** 
	 * Method display()
	 * Displays theBoard in a nice easy to visualize format.  
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/** 
	 * Method addMark() adds a character (X or O) to a spot on theBoard
	 * @param row: int
	 * @param col: int
	 * @param mark: char
	 */
	public void addMark(int row, int col, char mark) {
		theBoard[row][col] = mark;
		markCount++;
	}

	/** Method testMark() is similar to addMark() where it adds a character to a spot on theBoard
	 * but does not increase the mark count because its used as a 'test'
	 * @param row: int
	 * @param col: int
	 * @param mark: char
	 */
	public void testMark(int row, int col, char mark) {
		theBoard[row][col] = mark;
	}
	
	/** 
	 * Method clear() clears theBoard and specifies all the values in the 2D
	 * array to be a space. 
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/** 
	 * Method checkWinner() reviews all possible combinations of wins on the tic-tac-toe 
	 * board for a given mark (X or O), and returns the result as an integer (win = 1, else = 0) 
	 * @param mark: char
	 * @return result: int
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;
		
		// check each row to see if the specific mark (X or O) has all 3 spots 
		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)	// each column in a given row 
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		// check each column to see if the specific mark (X or O) has all 3 spots 
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)	// each row in a given column 
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}
		
		// check the diagonal from top left corner to bottom right corner, [0][0] --> [1][1] --> [2][2]
		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		
		// checks opposite diagonal from top right corner to bottom left, [0][2] --> [1][1] --> [2][0]
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/** 
	 * Method displayColumnHeaders() displays column Headers 
	 * to the terminal in a nice format 
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/** 
	 * Method addHyphens() creates a line to separate the rows 
	 * in the terminal to make the tic-tac-toe board look nice  
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/** 
	 * Method addSpaces() adds spaces to the tic-tac-toe board game in the 
	 * terminal so that the X's and O's are centered nicely 
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
