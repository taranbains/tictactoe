
/**
 * SmartPlayer Class
 * Extends the Player class and first tests to see if they can win, if not they test to see 
 * if they need to block, otherwise they pick a spot on the board at random.  
 * 
 * @author bains
 */

public class SmartPlayer extends Player{
	
	public SmartPlayer(String name, char mark) {
		super(name, mark);
	}
	
	/** Method makeMove()
	 * Goes through the Board one space at a time, starting from corner 0,0 to determine what 
	 * kind of move to make, a winning move, blocking move or random move. 
	 */
	@Override
	public void makeMove() {
		int row = 0;
		int col = 0;
		boolean answer = false;
		
		for(row = 0; row <= 2; row++) {										// for loop checking all the spots on the board
			for(col = 0; col <= 2; col++) {
				if(super.theBoard.getMark(row, col) != SPACE_CHAR) {
					continue; 
				}
				else{
					answer = testForWinning(row, col);
					if (answer == true) break;
					answer = testForBlocking(row, col);
				}
				if (answer == true) break;
			}
			if (answer == true) break;
		}
		
		if(answer == true) {
			super.theBoard.addMark(row, col, mark);
		}
		
		else {																// else we make a random move 
			RandomGenerator randomGen = new RandomGenerator();
			
			row = randomGen.discrete(0,2);
			col = randomGen.discrete(0,2);
			
			while(super.theBoard.getMark(row, col) != SPACE_CHAR) {
				row = randomGen.discrete(0,2);
				col = randomGen.discrete(0,2);
			}
			super.theBoard.addMark(row, col, this.getMark());
		}
		
	}
	
	/** Tests a certain position on the Board to see if its a winning move and returns 
	 * true if it is, else false. 
	 * @param row: int
	 * @param col: int
	 * @return true or false
	 */
	boolean testForWinning(int row, int col) {		
		super.theBoard.testMark(row, col, this.mark);
		
		if(super.theBoard.checkWinner(this.mark) == 1) {
			super.theBoard.testMark(row, col, SPACE_CHAR);
			return true;
		}
		
		super.theBoard.testMark(row, col, SPACE_CHAR);
		return false; 
	}
	
	/** Tests a certain position on the Board to see if it needs to be blocked, 
	 * and returns a true if its is, else false. 
	 * @param row: int
	 * @param col: int
	 * @return true or false 
	 */
	boolean testForBlocking(int row, int col) {
		char oppMark = super.opponent.getMark(); 
	
		super.theBoard.testMark(row, col, oppMark);
		
		if(super.theBoard.checkWinner(oppMark) == 1) {
			super.theBoard.testMark(row, col, SPACE_CHAR);
			return true;
		}
		
		super.theBoard.testMark(row, col, SPACE_CHAR);
		return false; 
	}
}
