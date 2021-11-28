package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class NewAnimalController {
	@FXML
	TextField textArea;
	@FXML
	Label questionLable;
	private BNode memoryNode;
	private BNode broot;
	private Parent root;
	private String question = "Which animal did you think?";
	private String answer;
	private int questionAmount = 0;
	
	public void addAnimal(ActionEvent event) throws IOException {
		answer = textArea.getText();
		if(questionAmount == 0) {
			question = "The " + answer + " ________ but the " + memoryNode.value + " doesn't";
			questionLable.setText(question);
			questionAmount++;
			memoryNode.right = new BNode(answer);
			memoryNode.left = new BNode(memoryNode.value);
		}else {
			memoryNode.value = answer;
			//go back to Game controller
			returnChangedNode(memoryNode, event);
		}
		textArea.clear();
	}

	public void addBlank(ActionEvent event) {
		answer = "";
		if(questionAmount == 0) {
			question = "The " + answer + " ________ but the " + memoryNode.value + " doesn't";
			questionLable.setText(question);
			questionAmount++;
			memoryNode.right = new BNode(answer);
			memoryNode.left = new BNode(memoryNode.value);
		}else {
			memoryNode.value = answer;
		}
		questionAmount++;
	}
	
	private void returnChangedNode(BNode newNode, ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Guessing.fxml"));
		root = loader.load();
		GameController gameController = loader.getController();
		gameController.AddNewNode(newNode, event, broot);
	}
	
	public void initializeMemoryNode(BNode oldNode, BNode broot){
		memoryNode =  oldNode;
		this.broot = broot;
	}
}
