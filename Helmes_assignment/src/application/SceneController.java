package application;

import java.io.IOException;
import application.BNode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneController {
	@FXML
	private Button logoutButton;
	@FXML 
	private AnchorPane scenePane;
	@FXML
	Label guessingText;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private BNode initialTree;
	
	public void exitGame(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) scenePane.getScene().getWindow();
		stage.close();
	}
	
	public void switchToGuessingScene(ActionEvent event) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Guessing.fxml"));
		root = loader.load();
		GameController gameController = loader.getController();
		BNode node = initialTree;
		if(null == initialTree) {
			node = new BNode("The animal you tought lives in the water?");
			node.right = new BNode("Shark");
			node.left = new BNode("Moneky");
		}
		gameController.initializeGame(node);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void setBTree(BNode newNode) {
		this.initialTree = newNode;
	}
	
	

}
