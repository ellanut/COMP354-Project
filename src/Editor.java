
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Editor implements editJob{
	private String userInput;
	private String[] words;
	private ArrayList<String> words2;
	
	public ArrayList<String> getWords2() {
		return words2;
	}

	public void setWords2(ArrayList<String> words2) {
		this.words2 = words2;
	}

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}
	
	public Editor() {
	}

	public Editor(String userInput) {
		setUserInput(userInput);
	}


	public String getUserInput() {
		return userInput;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	public ArrayList<String> Read() {
		System.out.println("Please input a valid order");

		words2 = new ArrayList<String>();
		while(true){
			Scanner s = new Scanner (System.in);
			String s2 = s.nextLine();
			setUserInput(s2);
			String line = getUserInput();
			String [] words = line.split(" ");
			
		        if(words.length == 4 || words.length == 7) {
		        	words2 = new ArrayList<>(Arrays.asList(words));
		            break;
		        }
		        else
		            System.out.println("wrong number of inputs, try again");
		    }		
		return words2;		
	}

	public ArrayList<String> takeInput(String input) {
		
		String line = input;
		String[] words = line.split(" ");
		words2 = new ArrayList<>(Arrays.asList(words));		
		return words2;		
	}
	
	public void Read_Test_Cases() {
			words = getUserInput().split(" ");			
		        if(words.length == 4 || words.length == 7) {
		        	System.out.println("correct, the input is: " + getUserInput());  
		        }
		        else
		            System.out.println("wrong, the input is: " + getUserInput());	
	}
	
	//Checks that the number of inputs is correct.
	public static void test_case_1()
	{
		String test1 = "add 4 to 7 loop 5 times";
		Editor t2 = new Editor(test1);
		t2.Read_Test_Cases();
		System.out.println("The output should be: \"correct, the input is: add 4 to 7 loop 5 times\"");
		
		String test2 = "add 4 to 7 loop 5";
		Editor t3 = new Editor(test2);
		t3.Read_Test_Cases();
		System.out.println("The output should be: \"wrong, the input is: add 4 to 7 loop 5\"");
	}
	
	//Checks that the words are split correctly.
	public static void test_case_2()
	{
		String test2 = "add 4 to 7 loop 5 times";
		Editor t2 = new Editor(test2);
		t2.Read_Test_Cases();
		System.out.println(Arrays.toString(t2.words));
		System.out.println("The output should be: \"[add, 4, to, 7, loop, 5, times]\"");
	}
	
//	public static void test_case_3()
//	{
//		String test3 = "add 4 to 7 loop 5 times";
//		Editor t3 = new Editor(test3);
//		t3.Read();
//		String in = t3.getUserInput();
//		if (in.equals(""))
//			System.out.println("No input was read.");
//		else
//			System.out.println("Input " + in + " was read.");
//	}
}
