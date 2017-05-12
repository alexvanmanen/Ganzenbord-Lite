package controller;
import model.Dice;
import model.GameBoard;
import model.Pawn;

public class GameController {

	private GameBoard gameboard; 
	private Pawn pawn;
	private Dice dice;
	
	public GameController(GameBoard gameBoard, Dice dice, Pawn pawn) {
		this.dice = dice;
		this.gameboard = gameBoard;
		this.pawn = pawn;
		pawn.setField(gameboard.getFirstField());
	}
	
	public void execute(){
		dice.roll();
		int diceValue = dice.getNumberOfDots();
		gameboard.movePawn(pawn, diceValue);
	}
	
	
}
