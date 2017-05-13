package model;
import java.util.LinkedList;
import java.util.List;

import model.field.Brug;
import model.field.Einde;
import model.field.Field;
import model.field.Put;
import model.field.Standard;
import model.field.Start;
import view.GameBoardView;

public class GameBoard {

	List<Field> fields = new LinkedList<Field>();
	private GameBoardView view;

	public GameBoard() {
		for (int i = 0; i < 10; i++) {
			Field field = new Standard(Integer.toString(i));
			fields.add(i, field);
			
		}
		fields.set(0, new Start());
		fields.set(4, new Brug());
		fields.set(7, new Put());
		fields.set(9, new Einde());
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
		String[] text = pawn.getField().execute(this, pawn);
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
