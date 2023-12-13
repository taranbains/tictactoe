import java.util.Scanner;

/** 
 * Player Class
 * Player for tic-tac-toe and all of its methods to make a move on the board. 
 * 
 * @author bains 
 */
public class Player implements Constants{
		
	private String name;
	private char mark;
	private Player opponent; 
	private Board theBoard;

	Scanner input = new Scanner(System.in);					// create an object of Scanner to read user input
	
	/** 
	 * Constructor assigns the name the mark (X or O)
	 * @param name: String
	 * @param mark: mark
	 */
	public Player(String name, char mark) {
		this.name = name;
		this.mark = mark; 
	}
	
	/** 
	 * getName() returns the name of the Player 
	 * @return name: String
	 */
	public String getName() {
		return this.name;
	}
	
	/** 
	 * getMark() returns the Mark (X or O) of the Player
	 * @return mark: char
	 */
	public char getMark() {
		return this.mark; 
	}
	
	/** 
	 * setBoard sets the Board object (created in Game) 
	 * @param board: Board
	 */
	public void setBoard(Board board){
		this.theBoard = board;
	}
	
	/** 
	 * setOpponenet() sets the Player's opponent 
	 * @param oppositePlayer: Player
	 */
	public void setOpponent(Player oppositePlayer) {
		this.opponent = oppositePlayer; 
	}
	
	/** 
	 * play() will ensure Board is not full and nobody has won yet so a Player can play a move
	 */
	public void play(){
		// ensure can make a move first  
		if(this.theBoard.xWins() == true || this.theBoard.oWins() == true || this.theBoard.isFull() == true)	{
			if (this.theBoard.xWins() == true && this.mark == LETTER_X){
				System.out.println("GAME OVER. " + this.name + " is the winner.");
			}
			else if (this.theBoard.oWins() == true && this.mark == LETTER_O){
				System.out.println("GAME OVER. " + this.name + " is the winner.");
			}
			
			else if (this.theBoard.isFull() == true) {
				System.out.println("GAME OVER. It is a tie.");			
			}
		
			else {
				System.out.println("GAME OVER. " + this.opponent.getName() + " is the winner.");
			}
		}
		
		// if we can make a move, call the function  
		else{
			makeMove();										// make move 
			this.theBoard.display(); 						// display board after making move 
		}
		
	}
	
	/**
	 * makeMove() reads the user/player input for row and column to place their mark on the Board 
	 */
	public void makeMove() {
		int row;
		int col;
		
		System.out.print(this.name + ", what row do you want to place your next " + this.mark + "? ");
		row = input.nextInt();
		System.out.print(this.name + ", what column do you want to place your next " + this.mark + "? ");
		col = input.nextInt();
		
		// Ensure the spot is empty to place a character 
		while(this.theBoard.getMark(row, col) != SPACE_CHAR) {
			System.out.println("This spot is already taken, please choose another available spot.");
			
			System.out.print(this.name + ", what row do you want to place your next " + this.mark + "? ");
			row = input.nextInt();
			System.out.print(this.name + ", what column do you want to place your next " + this.mark + "? ");
			col = input.nextInt();
		}
		
		this.theBoard.addMark(row, col, this.mark);	
	}

}

