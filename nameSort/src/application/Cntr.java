package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import application.Sortn;

public class Cntr {
	@FXML
	private TextField ip1;
	@FXML
	private TextField ip2;
	@FXML
	private TextField ip3;
	@FXML
	private TextField ip4;
	@FXML
	private TextField ip5;
	@FXML
private Label op1;	
	@FXML
private Label op2;	
	@FXML
private Label op3;	
	@FXML
private Label op4;	
	@FXML
private Label op5;	
	
	@FXML
	private Label oplbl;
 public void sort(ActionEvent event) throws Exception{
		String[] ip = new String[5];
		String[] op = new String[5];
		
		ip[0] = ip1.getText();
		ip[1] = ip2.getText();
		ip[2] = ip3.getText();
		ip[3] = ip4.getText();
		ip[4] = ip5.getText();
		
		op = Sortn.sorting(ip);
		
		oplbl.setText("sorted list :");
	  op1.setText(op[0]);
	  op2.setText(op[1]);
	  op3.setText(op[2]);
	  op4.setText(op[3]);
	  op5.setText(op[4]);
	}
}
