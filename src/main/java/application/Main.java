package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			
			Scene scene = new Scene(root);		
			primaryStage.setTitle("Animal game");
			/*Text text = new Text();
			text.setText("Think about an animal");
			text.setX(50);
			text.setY(50);
			root.getChildren().add(text);
			primaryStage.setWidth(275);
			primaryStage.setHeight(125);
			primaryStage.setResizable(false);*/
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
