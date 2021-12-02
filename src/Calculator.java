import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator 
{
	public static void main(String[] argv)
	{

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
		integration_test_2();
		
		
		
		
		String choice = "";
		do {
			Editor editor = new Editor();
			ArrayList<String> arrayList = new ArrayList<>();
			arrayList = editor.Read();
			MathClass math = new MathClass();
			Translator translator = new Translator(math);
			System.out.println(translator.translate(arrayList));
			
			System.out.println("Do you want to go again?");
			Scanner in = new Scanner(System.in);
			choice = in.next();
		} while (choice.equals("yes"));
	}
	
	public static void integration_test_1()
	{
		//Integration test between editor and translator
		Editor editor = new Editor();
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList = editor.takeInput("subtrat 5 from 2 loop 2 times");
		String output_editor = Arrays.toString(arrayList.toArray());
		System.out.println("Output from editor: " + output_editor);
		System.out.println("SHOULD BE: \"Output from editor: [subtrat, 5, from, 2, loop, 2, times]\"");
		MathClass math = new MathClass();
		Translator translator = new Translator(math);
		translator.translate(arrayList);
	}
	
	public static void integration_test_2()
	{
		//Integration test between Translator and MathClass
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("add", "5", "to", "6", "loop", "2", "times"));
		MathClass math = new MathClass();
		Translator translator = new Translator(math);
		float result = translator.translate(arrayList);
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
