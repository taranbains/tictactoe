
/**
 * BlockingPlayer Class
 * Extends the Player class and searches the Board to block the opponent, otherwise picks a random spot. 
 * 
 * @author bains
 */
public class BlockingPlayer extends Player{
	public BlockingPlayer(String name, char mark) {
		super(name, mark);
	}
	
	/** Method makeMove() reviews each spot on the board, starting at 0,0 to see if it can block the opponent, 
	 * else picks a spot at random.
	 */
	@Override
	public void makeMove() {
		int row = 0;
		int col = 0;
		boolean answer = false;
		
		for(row = 0; row <= 2; row++) {									// loops to check the whole board to see if need to block 
			for(col = 0; col <= 2; col++) {
				if(super.theBoard.getMark(row, col) != SPACE_CHAR) {
					continue; 
				}
				else{
					answer = testForBlocking(row, col);
				}
				if (answer == true) break;
			}
			if (answer == true) break;
		}
		
		if(answer == true) {
			super.theBoard.addMark(row, col, mark);
		}
		
		else { 															// else pick a spot at random on the board 
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
	
	/** Method testForBlocking() places the opponents mark on the specific row on the board and checks 
	 * to see if they would win with that location. 
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
