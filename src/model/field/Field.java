package model.field;

import java.util.ArrayList;
import java.util.List;

import model.GameBoard;
import model.Pawn;

public abstract class Field {

	private List<Pawn> pawns = new ArrayList<Pawn>();
	protected String name = null;
	
	
	public abstract String[] execute(GameBoard gameBoard, Pawn pawn);
	
	public void addPawn(Pawn pawn){
		pawns.add(pawn);
	}
	
	public void removePawn(Pawn pawn){
		pawns.remove(pawn);
	}
	
	public List<Pawn> getPawns(){
		return pawns;
	}

	public String getName() {
		return name;
	}
	
}
