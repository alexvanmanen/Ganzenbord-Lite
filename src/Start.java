import controller.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Dice;
import model.GameBoard;
import model.Pawn;
import view.DiceView;
import view.GameBoardView;
import view.PawnView;

public class Start extends Application {

	@Override
	public void start(Stage primaryStage) {
		GameBoard gameBoard = new GameBoard();
		Dice dice = new Dice(3);
		Pawn pawn = new Pawn();
		GameController gameController = new GameController(gameBoard, dice, pawn);
	
		Pane pane = new Pane();
		pane.getChildren().add(new GameBoardView(gameBoard));
		pane.getChildren().add(new DiceView(dice, gameController));
		pane.getChildren().add(new PawnView(pawn, gameBoard));

		Scene scene = new Scene(pane, 1000, 400);
		primaryStage.setTitle("Ganzebord Lite");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
