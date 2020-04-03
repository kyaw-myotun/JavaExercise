import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TextColor extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	TextArea textarea;
	TextField tf;
	TextFlow tflow;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		textarea = new TextArea();
		
		textarea.setMinHeight(600);
		
		ToggleGroup tg = new ToggleGroup();
		RadioButton rb = new RadioButton("RED");
		rb.setToggleGroup(tg);
		RadioButton rb1 = new RadioButton("Green");
		rb1.setToggleGroup(tg);
		RadioButton rb2 = new RadioButton("Blue");
		rb2.setToggleGroup(tg);
		tf = new TextField();
		textarea.setStyle("-fx-font-size:30px");

		tf.setStyle("-fx-font-size:40px");
		tf.setMinHeight(100);
		tf.setMinWidth(500);

		rb.setOnAction(e -> changeRed(e));
		rb1.setOnAction(e -> changeGreen(e));
		rb2.setOnAction(e -> changeBlue(e));
		VBox vb = new VBox(100);
		vb.setPadding(new Insets(40, 0, 0, 100));

		vb.getChildren().addAll(rb, rb1, rb2, tf);
		GridPane gp = new GridPane();

		gp.setPadding(new Insets(20, 20, 20, 20));
		gp.add(textarea, 0, 0);
		gp.add(vb, 1, 0);

		Scene sc = new Scene(gp, 1280, 800);
		primaryStage.setScene(sc);
		primaryStage.show();
	}

	private Object changeBlue(ActionEvent e) {
		// TODO Auto-generated method stub
		findText(textarea.getText(), "blue");
		return null;
	}

	private Object changeGreen(ActionEvent e) {
		// TODO Auto-generated method stub
		findText(textarea.getText(), "green");
		return null;
	}

	private Object changeRed(ActionEvent e) {
		// TODO Auto-generated method stub
		findText(textarea.getText(), "red");
		return null;
	}

	public void findText(String text, String color) {
		System.out.println(text);

		Pattern p = Pattern.compile(tf.getText());
		Matcher m = p.matcher(text);
		textarea.setStyle("-fx-highlight-text-fill:  "+color+";-fx-font-size:30px");
		while (m.find()) {
		
			textarea.selectRange(m.start(), m.end());
			
		
			
		
			
			
			
		}

	}

}
