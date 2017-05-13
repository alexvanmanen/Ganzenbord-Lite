package model.field;

import model.GameBoard;
import model.Pawn;

public class Einde extends Field {

	public Einde(){
		this.name = "Einde";
	}
	
	public String[] execute(GameBoard gameBoard, Pawn pawn){
		String[] text = {"Spel gewonnen!", "Gefeliciteerd, Je hebt het einde bereikt.", "Het spel is afgelopen"};
		return text;
	}
	
}
