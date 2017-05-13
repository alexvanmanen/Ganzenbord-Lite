package model.field;

import model.GameBoard;
import model.Pawn;

public class Standard extends Field {

	public Standard(String name){
		this.name = name;
	}
	
	public String[] execute(GameBoard gameBoard, Pawn pawn) {
		// Don't do anything
		return null;
	}

}
