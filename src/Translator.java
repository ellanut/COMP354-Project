import java.util.ArrayList;
import java.util.Arrays;

public class Translator implements translateJob
{
	private MathClass math;
	private String arithmetic_op = "";
	private float inputOne = 0;
	private float inputTwo = 0;
	private int numberOfLoops = 1;
	private int inputOne_loop = 0;
	
	public MathClass getMath() {
		return math;
	}

	public void setMath(MathClass math) {
		this.math = math;
	}

	public String getArithmetic_op() {
		return arithmetic_op;
	}

	public void setArithmetic_op(String arithmetic_op) {
		this.arithmetic_op = arithmetic_op;
	}

	public float getInputOne() {
		return inputOne;
	}

	public void setInputOne(float inputOne) {
		this.inputOne = inputOne;
	}

	public float getInputTwo() {
		return inputTwo;
	}

	public void setInputTwo(float inputTwo) {
		this.inputTwo = inputTwo;
	}

	public int getNumberOfLoops() {
		return numberOfLoops;
	}

	public void setNumberOfLoops(int numberOfLoops) {
		this.numberOfLoops = numberOfLoops;
	}

	public int getInputOne_loop() {
		return inputOne_loop;
	}

	public void setInputOne_loop(int inputOne_loop) {
		this.inputOne_loop = inputOne_loop;
	}

	public Translator(MathClass math)
	{
		this.math = math;
	}

	// Converts the user's input into the numeral result 
	public String translate(ArrayList<String> stringArray)
	{
		// Checks if the 2nd and 4th word is a number
		try 
		{
			arithmetic_op = stringArray.get(0);
			inputOne = Float.parseFloat(stringArray.get(1));
			inputTwo = Float.parseFloat(stringArray.get(3));
		}
		catch (Exception e)
		{
			String message = "Error: The 2nd and 4th input need to be numbers.";
			return message;
		}
		
		// Condition where the user input must be of 7 words
		if (stringArray.size() == 7)
		{
			try
			{
				numberOfLoops = Integer.parseInt(stringArray.get(5)); // gets the number of loop from the user input
			}
			// Prints an error message if the 5th words isn't a number
			catch (Exception e)
			{
				String message = "Error: The number of loops needs to be a number.";
				return message;
			}
			// Prints an error if the number is a negative number
			if (numberOfLoops <= 0) 
			{
				String message = "Error: Input for the loop must be a positive integer.";
				return message;

	        }
			// Prints an error if the syntax isn't valid to execute the loop function
			if (!(stringArray.get(4).equals("loop") && stringArray.get(6).equals("times")))
			{
				String message = "Error: Invalid syntax for the loop.";
				return message;
			}
		}
		
		// Prints an error if user tries to divide by 0
		if (arithmetic_op.equals("divide") && inputTwo == 0)
		{
			String message = "Error: Cannot divide by 0.";
			return message;
		}
		
		// Checks if the first word is "divide" or "power", execute the correct looping
		if (arithmetic_op.equals("divide") || arithmetic_op.equals("power"))
		{
			inputOne_loop = (int) (inputTwo*numberOfLoops);
		}
		else
		{
			inputOne_loop = (int) (inputOne*numberOfLoops);
		}
		// Checks for the 1st word and 3rd word to execute the correct operation
		if (arithmetic_op.equals("add") && stringArray.get(2).equals("to"))
			return Float.toString(math.doAddition(inputOne_loop, inputTwo));	

		else if (arithmetic_op.equals("subtract") && stringArray.get(2).equals("from"))
			return Float.toString(math.doSubtraction(inputOne_loop, inputTwo));

		else if (arithmetic_op.equals("multiply") && stringArray.get(2).equals("by"))
			return Float.toString(math.doMultiplication(inputOne_loop, inputTwo));

		else if (arithmetic_op.equals("divide") && stringArray.get(2).equals("by"))
			return Float.toString(math.doDivision(inputOne_loop, inputTwo));

		else if (arithmetic_op.equals("power") && stringArray.get(2).equals("to"))
			return Float.toString(math.doPower(inputOne, inputOne_loop));

		else
		{
			String message = "Error: Invalid syntax.";
			return message;
		}
	}
	
	// Test Case for dividing by 0
	public static void test_case_1()
	{
		MathClass math = new MathClass();
		Translator translator = new Translator(math);
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("divide", "5", "by", "0"));
		translator.translate(arrayList);
		System.out.println("Output should be: \"Error: Cannot divide by 0.\"");
	}
	
	// Test case for non-positive numbers for loops in the input.
	public static void test_case_2()
	{
		MathClass math = new MathClass();
		Translator translator = new Translator(math);
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("divide", "5", "by", "2", "loop", "-2", "times"));
		translator.translate(arrayList);
		System.out.println("Output should be: \"Error: Input for the loop must be a positive integer.\"");
	}

	// Test case that checks that the first word from the user input is read correctly
	public static void test_case_3()
	{
		MathClass math = new MathClass();
		Translator translator = new Translator(math);
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("divide", "5", "by", "2", "loop", "2", "times"));
		translator.translate(arrayList);
		String operation = translator.arithmetic_op;
		System.out.println("Operation: " + operation);
		System.out.println("Output should be: \"Operation: divide\"");
	}
}
