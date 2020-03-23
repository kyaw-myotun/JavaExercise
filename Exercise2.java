
import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuestionExercise extends Application {
	static ArrayList<String> question = new ArrayList<String>();
	static ArrayList<String> answer = new ArrayList<String>();
	String result = "";
	int questionNumber = 0;
	int answerNumber = 0;
	int resultCount = 0;
	Text text;
	Text text1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		question.add("What is blah blah?");
		answer.add("book");
		question.add("What is what is ?");
		answer.add("java");
		question.add("Who is she?");
		answer.add("math");
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		text = new Text(question.get(questionNumber));
		text1 = new Text("Result : 0");
		text1.setStyle("-fx-font-size:20px;");
		text.setStyle("-fx-font-size:20px;");
		GridPane gp = new GridPane();

		gp.setVgap(40);
		gp.addRow(0, text);

		List<Character> data = getAnswer();
		System.out.println(data.size());
		FlowPane flowpane = new FlowPane(10, 10);
		flowpane.setStyle("-fx-border: black");
		flowpane.setHgap(10);
		flowpane.setVgap(10);
		flowpane.setMinWidth(600);
		flowpane.setMinHeight(150);

//		flowpane.setVgap();
		for (int i = 0; i < data.size(); i++) {
			Button b = new Button(data.get(i) + "");
			b.setMinSize(100, 50);
			b.setCursor(Cursor.OPEN_HAND);

			b.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> mouseEvent(e));
			// gp.add(b, i, 1);
			flowpane.getChildren().add(b);
		}
		gp.addRow(1, flowpane);
		gp.addRow(3, text1);
		Scene sc = new Scene(gp, 600, 400);
		primaryStage.setResizable(false);
		primaryStage.setScene(sc);
		primaryStage.show();

	}

	public List<Character> getAnswer() {
		String answerdata = "";

		for (String a : answer)
			answerdata += a;

		List<Character> characters = new ArrayList<Character>();
		for (char c : answerdata.toCharArray()) {
			characters.add(c);
		}

		while (characters.size() < 20) {
			characters.add((char) (Math.random() * 26 + (int) 'a'));

		}

		Collections.shuffle(characters);
		return characters;
	}

	public void mouseEvent(MouseEvent event) {
		Button button = (Button) event.getSource();

		button.setDisable(true);

		System.out.println(button.getText());
		if (isRight(button.getText())) {
			System.out.println(result + "" + answer.get(answerNumber));

			if (result.equals(answer.get(answerNumber))) {
				resultCount++;

			}
			text1.setText(String.format("Result : %d", resultCount));
			result = "";
			answerNumber++;
			questionNumber++;
			if (answerNumber >= question.size()) {
				text.setText("Thank You");
				answerNumber = 0;
				questionNumber = 0;
				Alert alt = new Alert(AlertType.CONFIRMATION, "Do You Want To QUick?", ButtonType.YES,
						ButtonType.CANCEL);

				alt.showAndWait();
				if (alt.getResult() == ButtonType.YES) {
					System.exit(0);
				} else {
					
				}
			} else {
				text.setText(question.get(questionNumber));
			}

		} else {

		}
	}

	public boolean isRight(String data) {

		result += data;

		String checkString = answer.get(answerNumber);
		System.out.println(result.length() + "" + checkString.length());
		if (result.length() == checkString.length() || result == checkString) {

			return true;

		} else {
			return false;
		}
	}

}
