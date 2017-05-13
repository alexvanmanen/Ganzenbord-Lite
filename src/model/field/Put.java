package model.field;

import model.GameBoard;
import model.Pawn;

public class Put extends Field {

	public Put(){
		this.name = "Put";
	}
	
	public String[] execute(GameBoard gameBoard, Pawn pawn) {
		String[] text = { "In de put.", "Je bent in de put gekomen.", "Je gaat terug naar start." };
		pawn.setField(gameBoard.getFirstField());
		return text;
	}
}
