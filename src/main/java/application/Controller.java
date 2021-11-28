package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
	@FXML
	private String text;
	public void ok(ActionEvent e) {
		System.out.println("OK");
	}
	public void cancel(ActionEvent e) {
		System.out.println("Cancel");
	}
}
