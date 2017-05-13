package model;
import model.field.Field;
import view.PawnView;

public class Pawn {

	private Field field;
	private PawnView view;

	public void setField(Field field) {
		this.field = field;
		this.notifyObservers();
	}

	public Field getField() {
		return field;
	}

	public void notifyObservers() {
		if (view != null) {
			view.update(this);
		}
	}

	public void registrate(PawnView view) {
		this.view = view;
	}
}
