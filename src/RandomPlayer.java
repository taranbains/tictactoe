
/**
 * RandomPlayer Class
 * Extends the Player class and picks spots on the board at random.. 
 * 
 * @author bains
 */
public class RandomPlayer extends Player{
	public RandomPlayer(String name, char mark) {
		super(name, mark);
	}
	
	/** Method makeMove() just chooses a spot on the board at random, and if its empty, 
	 * places the mark. 
	 */
	@Override
	public void makeMove() {
		int row;
		int col;
		
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
