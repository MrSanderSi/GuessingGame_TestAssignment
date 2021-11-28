package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameController {
	@FXML
	Label guessingText;
	BNode broot;
	BNode memoryNode;
	int tier;
	private Stage stage;
	private Scene scene;
	private Parent proot;
	
	public void displayGuess(BNode node) {
		//if a node is also a leaf then it is a possible answer
		if(isLeaf(node)) {
			String lableText = "Is " + node.value + " the animal you tought";
			guessingText.setText(lableText);
		}else {
			String lableText = "The animal you tought " + node.value + "?";
			guessingText.setText(lableText);
		}
		memoryNode = node;
	}
	
	public void goRight(ActionEvent event) throws IOException {
		if(null == memoryNode.right) {
			//Since right child does not exist the current memoryNodes value is the answer
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EndingScreen.fxml"));
			proot = loader.load();
			GuessedController controller = loader.getController();
			controller.initializeController(broot);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(proot);
			stage.setScene(scene);
			stage.show();
			
		}else {
			displayGuess(memoryNode.right);
		}
		
	}
	
	public void goLeft(ActionEvent event) throws IOException {
		if(null == memoryNode.left) {
			//New animal needs to be created
			FXMLLoader loader = new FXMLLoader(getClass().getResource("NewAnimal.fxml"));
			proot = loader.load();
			NewAnimalController controller = loader.getController();
			controller.initializeMemoryNode(memoryNode, broot);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(proot);
			stage.setScene(scene);
			stage.show();		
		}
		else {
			displayGuess(memoryNode.left);
		}
		
	}
	
	public void initializeGame(BNode node) {
		broot = node;
		memoryNode = node;
		guessingText.setText(broot.value);
	}
	
	public BNode getRoot() {
		return broot;
	}
	
	public void AddNewNode(BNode newNode, ActionEvent event, BNode broot) throws IOException {
		memoryNode = newNode;
		this.broot = broot;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		proot = loader.load();
		SceneController controller = loader.getController();
		controller.setBTree(broot);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(proot);
		stage.setScene(scene);
		stage.show();
	}
	
	public BNode getMemoryNode() {
		return memoryNode;
	}
	
	private boolean isLeaf(BNode node) {
		if(null != node.value) {
			if(null == node.left) {
				if(null == node.right) {
					return true;
				}
			}
		}
		return false;
	}
	
}
