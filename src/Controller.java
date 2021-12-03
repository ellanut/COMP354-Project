import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Stage stage;
    private Parent root;

    String userInput;
    String errorMessage;
    String result;

    @FXML
    private TextArea editor;
    @FXML
    private Label errorGUI;
    @FXML
    private Button runButton;
    @FXML
    private Button tipButton;
    @FXML
    private TextArea instructions;
    @FXML
    private Label resultMessage;

    // Open Tips Window to provide tips to the User
    @FXML
    void openTips(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("tips_window.fxml"));
         root = (Parent) loader.load();
         stage = new Stage();
         stage.setTitle("Calculator Notebook - Tips");
         stage.setScene(new Scene(root));
         stage.show();
    }

    // Run the command written in the editor by the user
    public void run(ActionEvent event) throws IOException{
        userInput = editor.getText();   // get text and store it in variable userInput
        System.out.println("Here's what you typed: " + userInput);


        errorGUI.setText(errorMessage); // display error message to user
        resultMessage.setText(result); //display result to user 
    }


}
