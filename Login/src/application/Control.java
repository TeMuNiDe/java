package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Control {
	@FXML
	private Label stat;
	
	@FXML 
	private TextField user;
	
	@FXML 
	private PasswordField pswd;
	 @FXML 
	 private  int err = 2;
	 
	
	public void login(ActionEvent event) throws Exception{
		if(user.getText().equals("haary")&&pswd.getText().equals("varma")){
			stat.setText("Login success");
			Stage primaryStage = new Stage();
			Parent root  = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		
		}else{
			stat.setText("incorrect username or password");
			pswd.setText("");
			if(err == 0){
				
				
				Stage primaryStage = new Stage();
				Parent root  = FXMLLoader.load(getClass().getResource("/application/Fuck.fxml"));
				Scene scene = new Scene(root,400,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			}else{
				stat.setText(" incorrect username or password \n attempts left :" + err);
				err--;
			}
		}
		
		
	}
	
	

}
