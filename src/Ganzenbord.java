import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/*
 * As you can see this code violates multiple SOLID principles.
 * Among others SRP (Single Responsibility Principle). 
 * This version of the code has many responsibilities like:
 * <li>
 *  <uL>Generating a grafical user interface</ul>
 *  <uL>Rolling the dice</ul>
 *  <uL>Determine where the pawn should be put after the dice rolled</ul>
 *  <uL>What should happen when the pawn ends up on the bridge, in the well or on the last spot on the board</ul>
 * </li>
 */
public class Ganzenbord extends Application {

	private Circle pawn;
	private int pawnLocation = 40;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();

		createField(pane);

		Button dice = new Button();
		dice.setPrefSize(100, 100);
		dice.setText("?");
		dice.setStyle("-fx-border-color: white;");
		dice.setOnAction(this::handleDiceAction);
		dice.relocate(200, 200);
		pane.getChildren().add(dice);

		pawn = createCircle(Color.RED);
		pawn.relocate(40, 10);
		pane.getChildren().add(pawn);

		Scene scene = new Scene(pane, 1000, 400);
		primaryStage.setTitle("Ganzebord Lite");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void createField(Pane pane) {
		for (int i = 0; i < 10; i++) {
			String text = Integer.toString(i);
			if (i == 0) {
				text = "Start";
			} else if (i == 4) {
				text = "Brug";
			} else if (i == 7) {
				text = "Put";
			} else if (i == 9) {
				text = "Einde";
			}

			Label b1 = createNewButton(text);
			b1.relocate(i * 100, 0);
			pane.getChildren().add(b1);
		}

		// Button b2 = createNewButton("Dobbelsteen");
		// b2.relocate(100, 0);
		// Button b3 = createNewButton("Kerkhof");
		// b3.relocate(200, 0);
		// Button b4 = createNewButton("Einde");
		// b4.relocate(300, 0);

		// pane.getChildren().add(b2);
		// pane.getChildren().add(b3);
		// pane.getChildren().add(b4);
	}

	private Circle createCircle(Color color) {
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

	private Label createNewButton(String text) {
		Label b1 = new Label();
		b1.setPrefSize(100, 150);
		b1.setText(text);

		b1.setStyle("-fx-border-color: black; -fx-alignment: center ;");
		// b1.setOnAction(this::handleButtonAction);
		return b1;
	}

	private void handleButtonAction(ActionEvent event) {
		// Button was clicked, do something...
		System.out.println("hallo");
	}

	private void handleDiceAction(ActionEvent event) {
		// Button was clicked, do something...

		Random random = new Random();
		Button b = (Button) event.getSource();
		int thrownValue = random.nextInt(3) + 1;
		b.setText(Integer.toString(thrownValue));
		pawnLocation = pawnLocation + thrownValue * 100;
		if (pawnLocation >= 940) {
			pawnLocation = 940;
			pawn.relocate(pawnLocation, 10);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Spel gewonnen");
			alert.setHeaderText("Gefeliciteerd!");
			alert.setContentText("Je hebt het einde bereikt. Het spel is afgelopen.");
			alert.showAndWait();
		} else if (pawnLocation == 440) {
			pawn.relocate(pawnLocation, 10);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Burg");
			alert.setHeaderText("Je bent op de brug beland!");
			alert.setContentText("Je gaat naar plaats 6.");
			alert.showAndWait();
			pawnLocation = 640;

		} else if (pawnLocation == 740) {
			pawn.relocate(pawnLocation, 10);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("In de put");
			alert.setHeaderText("Je bent in de put gekomen!");
			alert.setContentText("Je gaat terug naar start.");
			alert.showAndWait();
			pawnLocation = 40;

		}
		pawn.relocate(pawnLocation, 10);

	}

}
