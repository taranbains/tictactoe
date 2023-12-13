
/** 
 * Referee Class
 * Methods for the referee for the tic-tac-toe game and all of its method to control who plays and the winner. 
 * 
 * @author bains
 */
public class Referee {
	private Board theBoard; 
	private Player xPlayer;
	private Player oPlayer; 
	
	/**
	 * Empty constructor. 
	 */
	public void referee() {
		
	}
	
	/**
	 * runTheGame() sets the xPlayer and oPlayer as opponnets and then calls X mark Player 
	 * (X first) and O mark Player to play their moves until game is over.  
	 */
	public void runTheGame() {
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		
		System.out.println("\nReferee started the game...\n");
		this.theBoard.display();
		
		while(this.theBoard.xWins() == false && this.theBoard.oWins() == false && this.theBoard.isFull() == false){
			xPlayer.play();
			if(this.theBoard.xWins() == true) {			// check to see if X put in the 'winning move' and break 
				break;
			}
			oPlayer.play();
		}
		xPlayer.play();									// Play one more time to print winning stats 
	}
	
	/**
	 * setBoard() sets the tic-tac-toe board that has been created 
	 * @param theGame: Board 
	 */
	public void setBoard(Board theGame) {
		this.theBoard = theGame; 
	}
	
	/** 
	 * setoPlayer sets the O mark Player
	 * @param oPlayer: Player
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}
	
	/** 
	 * xPlayer sets the X mark Player 
	 * @param xPlayer: Player
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer; 
	}

}
