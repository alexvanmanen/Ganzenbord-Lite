package view;
import controller.GameController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import model.Dice;

public class DiceView extends Pane {

	private GameController controller;
	private Button dice = new Button();
	
	public DiceView(Dice model, GameController controller) {
		model.registrate(this);
		this.controller = controller;
		
		dice.setPrefSize(100, 100);
		dice.setText("?");
		dice.setStyle("-fx-border-color: white;");
		dice.setOnAction(this::handleDiceAction);
		dice.relocate(200, 200);
		this.getChildren().add(dice);

	}

	private void handleDiceAction(ActionEvent event) {
		controller.execute();
	}

	public void update(int numberOfDots) {
		dice.setText(Integer.toString(numberOfDots));
		
	}

}
