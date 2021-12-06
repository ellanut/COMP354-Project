import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application
{
	// Called when JavaFX Application is started
	@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Calculator.class.getResource("calculator_notebook_with_history.fxml")); // Load FXML file of UI
        Scene scene = new Scene(root);
        primaryStage.setTitle("Calculator Notebook");
        primaryStage.setScene(scene);	 
        primaryStage.show(); // Make the application visible in a window
    }

	public static void main(String[] args)
	{
        launch(args); // launch the JavaFX runtime and application

		// Comment Line 24, and Uncomment the method to run the test case of the corresponding Component.
		// Editor.test_case_1();
		// Editor.test_case_2();
		// Translator.test_case_1();
		// Translator.test_case_2();
		// Translator.test_case_3();
		// MathClass.addition_test_case();
		// MathClass.subtraction_test_case();
		// MathClass.multiplication_test_case();
		// MathClass.division_test_case();
		// MathClass.power_test_case();
		// integration_test_1();
		// integration_test_2();
	}

	// INTEGRATION TEST CASE 1 between Editor and Translator: Ensuring that the output from Editor is sent to the Translator correctly
	public static void integration_test_1()
	{
		String testString = "subtract 5 from 2 loop 2 times";
		System.out.println("INTEGRATION TEST CASE 1 between Editor and Translator. \n");
		System.out.println("INPUT: " + testString);
		Editor editor = new Editor();
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList = editor.takeInput(testString);
		String output_editor = Arrays.toString(arrayList.toArray());
		System.out.println("OUTPUT: Output from editor: " + output_editor);
		System.out.println("EXPECTED OUTPUT: \"Output from editor: [subtract, 5, from, 2, loop, 2, times]\" \n");
		MathClass math = new MathClass();
		Translator translator = new Translator(math);
		translator.translate(arrayList);
	}
	
	// INTEGRATION TEST CASE 2 between Translator and MathClass: Translated output is sent to the MathClass; the correct arithmetic operation must be chosen by the MathClass
	public static void integration_test_2()
	{
		String[] testString2 = {"add", "5", "to", "6", "loop", "2", "times"};
		System.out.println("INTEGRATION TEST CASE 2 between Translator and MathClass");
		System.out.println("INPUT: " + Arrays.toString(testString2));
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(testString2));
		MathClass math = new MathClass();
		Translator translator = new Translator(math);
		String result = translator.translate(arrayList);
		String arithmetic_op = translator.getArithmetic_op();
		float inputOne = translator.getInputOne();
		float inputTwo = translator.getInputTwo();
		int numberOfLoops = translator.getNumberOfLoops();
		System.out.println("OUTPUT from Translator: " + arithmetic_op + ", " + inputOne + ", " + inputTwo + ", " + numberOfLoops);
		System.out.println("EXPECTED OUTPUT: \"Output from translator: add, 5.0, 6.0, 2.0\" \n");
		System.out.println("OUTPUT from MathClass: " + result);
		System.out.println("EXPECTED OUTPUT: \"Output from MathClass: 16.0\" \n");
	}

}
