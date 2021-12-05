import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Calculator extends Application
{
	// Called when JavaFX Application is started
	@Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(Calculator.class.getResource("calculator_notebook_with_history.fxml"));
		Parent root = loader.load(); // Load FXML file of UI
		Controller controller = loader.getController();
        Scene scene = new Scene(root);

		scene.setOnKeyPressed(event -> {
			switch (event.getCode()) {
				case ENTER:
					controller.runEnter();
			}
		});

        primaryStage.setTitle("Calculator Notebook");
        primaryStage.setScene(scene);
        primaryStage.show(); // Make the application visible in a window
    }

	public static void main(String[] args)
	{
        launch(args); // launch the JavaFX runtime and application

//		Comment Line 25, and Uncomment the method to run the test case of the corresponding Component.
//		Editor.test_case_1();
//		Editor.test_case_2();
//		Translator.test_case_1();
//		Translator.test_case_2();
//		Translator.test_case_3();
//		MathClass.addition_test_case();
//		MathClass.subtraction_test_case();
//		MathClass.multiplication_test_case();
//		MathClass.division_test_case();
//		MathClass.power_test_case();
//		integration_test_1();
// 		integration_test_2();
		
	}

	//Integration test between editor and translator
	public static void integration_test_1()
	{
		Editor editor = new Editor();
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList = editor.takeInput("subtract 5 from 2 loop 2 times");
		String output_editor = Arrays.toString(arrayList.toArray());
		System.out.println("Output from editor: " + output_editor);
		System.out.println("SHOULD BE: \"Output from editor: [subtract, 5, from, 2, loop, 2, times]\"");
		MathClass math = new MathClass();
		Translator translator = new Translator(math);
		translator.translate(arrayList);
	}
	
	//Integration test between Translator and MathClass
	public static void integration_test_2()
	{
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("add", "5", "to", "6", "loop", "2", "times"));
		MathClass math = new MathClass();
		Translator translator = new Translator(math);
		String result = translator.translate(arrayList);
		String arithmetic_op = translator.getArithmetic_op();
		float inputOne = translator.getInputOne();
		float inputTwo = translator.getInputTwo();
		int numberOfLoops = translator.getNumberOfLoops();
		System.out.println("Output from translator: " + arithmetic_op + ", " + inputOne + ", " + inputTwo + ", " + numberOfLoops);
		System.out.println("SHOULD BE: \"Output from translator: add, 5.0, 6.0, 2.0\"");
		System.out.println("Output from MathClass: " + result);
		System.out.println("SHOULD BE: \"Output from MathClass: 16.0\"");
	}

}
