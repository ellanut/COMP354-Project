import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

    private Stage stage;
    private Parent root;

    String userInput;
    String errorMessage;
    String result;

    @FXML
    private TextArea editorGUI;
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
    @FXML
    private TextArea history;
    

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
    public void run(MouseEvent event) throws IOException{
        errorMessage = " "; // initialize errorMessage every time the run button is used
        userInput = editorGUI.getText();   // get text and store it in variable userInput
        history.appendText(userInput + "\n"); // append user's input in the history Text Area

        // System.out.println("Here's what you typed: " + userInput);

        Editor editor = new Editor();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = editor.Read(userInput); 

        String line = userInput;
        String [] words = line.split(" "); // split the user's input and store each word in an array
        
        // check if user input is 4 or 7 words
        if(words.length == 4 || words.length == 7) {     
            MathClass math = new MathClass();  
            Translator translator = new Translator(math);   
            result = translator.translate(arrayList); // store the result of the arithmetic operation in result variable

            // check if variable result returns an Error message
            if(result.contains("Error")) {
                errorMessage = result;  // set errorMessage to that error message
                result = "NaN"; // set result to String "NaN"
            }
        }
        // if user input is not 4 or 7 words, ask the user to try again.
        else {
            errorMessage = "Error: Wrong number of inputs, try again.";
            result = "NaN";
        }
        
        errorGUI.setText(errorMessage); // display error message to user
        resultMessage.setText(result); //display result to user 
    }

    public void runEnter() {
        errorMessage = " "; // initialize errorMessage every time the run button is used
        userInput = editorGUI.getText();   // get text and store it in variable userInput
        history.appendText(userInput + "\n"); // append user's input in the history Text Area

        // System.out.println("Here's what you typed: " + userInput);

        Editor editor = new Editor();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList = editor.Read(userInput); 

        String line = userInput;
        String [] words = line.split(" "); // split the user's input and store each word in an array
        
        // check if user input is 4 or 7 words
        if(words.length == 4 || words.length == 7) {     
            MathClass math = new MathClass();  
            Translator translator = new Translator(math);   
            result = translator.translate(arrayList); // store the result of the arithmetic operation in result variable

            // check if variable result returns an Error message
            if(result.contains("Error")) {
                errorMessage = result;  // set errorMessage to that error message
                result = "NaN"; // set result to String "NaN"
            }
        }
        // if user input is not 4 or 7 words, ask the user to try again.
        else {
            errorMessage = "Error: Wrong number of inputs, try again.";
            result = "NaN";
        }
        
        errorGUI.setText(errorMessage); // display error message to user
        resultMessage.setText(result); //display result to user 
    }
}