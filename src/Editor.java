
import java.util.ArrayList;
import java.util.Arrays;


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

	// THIS THINGY LOOKS USELESS '-' PLEASE DOUBLE CHECK
	public ArrayList<String> Read(String userInput) {

		words2 = new ArrayList<String>();

		setUserInput(userInput);
		String line = getUserInput();
		String [] words = line.split(" "); // split the user's input and store each word in an array
	
		words2 = new ArrayList<>(Arrays.asList(words)); 

		return words2;		
	}

	// TEST CASE METHOD: Splits the input into words and store each word in an Array List
	public ArrayList<String> takeInput(String input) {
		
		String line = input;
		String[] words = line.split(" ");
		words2 = new ArrayList<>(Arrays.asList(words));		
		return words2;		
	}
	
	// Reads the test case and display if the number of words (input) is correct or not 
	public void Read_Test_Cases() {
			words = getUserInput().split(" ");			
		        if(words.length == 4 || words.length == 7) {
		        	System.out.println("Correct, the input is: " + getUserInput());  
		        }
		        else
		            System.out.println("Wrong, the input is: " + getUserInput());	
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
}
