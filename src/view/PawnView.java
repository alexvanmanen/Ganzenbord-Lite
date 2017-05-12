package view;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.GameBoard;
import model.Pawn;

public class PawnView extends Pane {

	private GameBoard gameBoard;
	private Circle pawnCircle;
	
	public PawnView(Pawn model, GameBoard gameBoard){
		this.gameBoard = gameBoard;
		model.registrate(this);
		pawnCircle = createPawn(Color.RED);
		pawnCircle.relocate(40, 10);
		this.getChildren().add(pawnCircle);

	}

	public void update(Pawn pawn) {
		int currentLocation = gameBoard.getCurrentLocation(pawn);
		pawnCircle.relocate(40+ currentLocation*100, 10);
	}
	
	private Circle createPawn(Color color) {
		DropShadow ds1 = new DropShadow();
		ds1.setOffsetY(4.0);
		Circle c = new Circle();
		c.setEffect(ds1);
		c.setCenterX(50.0);
		c.setCenterY(50.0);
		c.setRadius(15.0);
		c.setFill(color);
		c.setCache(true);
		return c;
	}
}
