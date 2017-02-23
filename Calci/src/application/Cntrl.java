package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Cntrl {
Modal mod = new Modal();
	@FXML
	private Label ans;
	private long number1 = 0;
	private String op = "";
	private boolean start = true;	
	
	
public void nmbr(ActionEvent event){
	if(start)
	{
		ans.setText("");
		start = false;
	}
		String value = ((Button)event.getSource()).getText();
		ans.setText(ans.getText() + value);
	}
	public void oper(ActionEvent event){
		
		String value = ((Button)event.getSource()).getText();
		if(!value.equals("=")){
			if(!op.isEmpty()){
				return;
			}
			op = value;
			number1 = Long.parseLong(ans.getText());
			ans.setText("");
			
		}
		else{
			if(op.isEmpty()){
				return;
			}
			Long number2 = Long.parseLong(ans.getText());
			 float opt = mod.calc(number1,number2,op);
			 ans.setText(String.valueOf(opt));
			 op = "";
			 start = true;
		}
		
		
	}
	

}
