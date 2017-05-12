package model;

import java.util.ArrayList;
import java.util.List;

public class Field {

	private List<Pawn> pawns = new ArrayList<Pawn>();
	
	private String type;
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public void addPawn(Pawn pawn){
		pawns.add(pawn);
	}
	
	public void removePawn(Pawn pawn){
		pawns.remove(pawn);
	}
	
	public List<Pawn> getPawns(){
		return pawns;
	}
	
}
