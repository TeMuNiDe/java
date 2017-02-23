package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class Maincontr {
	@FXML
	private Label lbl;
	public void genr(ActionEvent event){
		Random r = new Random();
		int o = r.nextInt(50) + 1;
		lbl.setText(Integer.toString(o));
		//System.out.println(Integer.toString(o));
		
	}

}
