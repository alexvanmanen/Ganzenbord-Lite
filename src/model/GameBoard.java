package model;
import java.util.LinkedList;
import java.util.List;

import view.GameBoardView;

public class GameBoard {

	List<Field> fields = new LinkedList<Field>();
	private GameBoardView view;

	public GameBoard() {
		for (int i = 0; i < 10; i++) {
			Field field = new Field();
			fields.add(i, field);
			field.setType(Integer.toString(i));
		}
		fields.get(0).setType("Start");
		fields.get(4).setType("Burg");
		fields.get(7).setType("Put");
		fields.get(9).setType("Einde");
	}

	public Field getFirstField() {
		return fields.get(0);
	}

	public Field getLastField() {
		return fields.get(9);
	}

	public void movePawn(Pawn pawn, int numberOfSteps) {
		this.relocatePawn(pawn, numberOfSteps);
		int newLocation = this.getCurrentLocation(pawn);
		String[] text = null;

		if (newLocation == 9) {
			pawn.setField(this.getLastField());
			text = new String[3];
			text[0] = "Spel gewonnen!";
			text[1] = "Gefeliciteerd, Je hebt het einde bereikt.";
			text[2] = "Het spel is afgelopen";
		} else if (newLocation == 4) {
			text = new String[3];
			text[0] = "Burg";
			text[1] = "Je bent op de brug beland!";
			text[2] = "Je gaat naar plaats 6.";
			this.movePawn(pawn, 2);
		} else if (newLocation == 7) {
			text = new String[3];
			text[0] = "In de put.";
			text[1] = "Je bent in de put gekomen.";
			text[2] = "Je gaat terug naar start.";
			pawn.setField(this.getFirstField());
		}
		this.view.update(text);
	}

	public int getCurrentLocation(Pawn pawn) {
		return fields.indexOf(pawn.getField());
	}

	public void relocatePawn(Pawn pawn, int numberOfSteps) {
		int currentLocation = this.getCurrentLocation(pawn);
		int newLocation = currentLocation + numberOfSteps;
		if (newLocation > fields.size() - 1) {
			newLocation = fields.size() - 1;
		}
		pawn.setField(fields.get(newLocation));

	}

	public List<Field> getFields() {
		return fields;
	}

	public void registrate(GameBoardView view) {
		this.view = view;

	}

}
