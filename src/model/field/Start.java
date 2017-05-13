package model.field;

import model.GameBoard;
import model.Pawn;

public class Start extends Field {

	public Start(){
		this.name = "Start";
	}
	
	public String[] execute(GameBoard gameBoard, Pawn pawn) {
		// do nothing
		return null;
	}

}
