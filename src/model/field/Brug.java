package model.field;

import model.GameBoard;
import model.Pawn;

public class Brug extends Field {

	public Brug(){
		this.name = "Brug";
	}
	
	public String[] execute(GameBoard gameBoard, Pawn pawn) {
		String[] text = {"Burg", "Je bent op de brug beland!", "Je gaat naar plaats 6."};
		gameBoard.movePawn(pawn, 2);
		return text;
	}
}
