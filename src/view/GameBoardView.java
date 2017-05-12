package view;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import model.Field;
import model.GameBoard;

public class GameBoardView extends Pane {

	public GameBoardView(GameBoard model) {
		model.registrate(this);
		this.createFields(model);
	}

	private void createFields(GameBoard model) {
		int i = 0;
		for (Field field : model.getFields()) {
			Label b1 = createNewButton(field.getType());
			b1.relocate(i * 100, 0);
			i++;
			this.getChildren().add(b1);
		}
	}

	private Label createNewButton(String text) {
		Label b1 = new Label();
		b1.setPrefSize(100, 150);
		b1.setText(text);
		b1.setStyle("-fx-border-color: black; -fx-alignment: center ;");
		return b1;
	}

	public void modelChanged(GameBoard model) {

	}

	public void update(String[] text) {
		if(text != null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(text[0]);
			alert.setHeaderText(text[1]);
			alert.setContentText(text[2]);
			alert.showAndWait();
		}
	}
}