package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ctrl {
 long crp = 0;
 long k = 0;
 long or = 0;
 
 
	 @FXML
	 TextField iptxt,opn,opk;
	 
	 @FXML
	 Label orig,crypted;
	 @FXML
	 public void genrt(ActionEvent event){
		 if(!iptxt.getText().isEmpty())
		 {
		crp = Writetotextfile.gen(Long.parseLong(iptxt.getText()));
		 crypted.setText(Long.toString(crp));
		}
	 }
	 @FXML
	 public void find(ActionEvent event){
crp = Long.parseLong(opn.getText());
k = Long.parseLong(opk.getText());
or = crp/k;
orig.setText(Long.toString(or));
	 }
}