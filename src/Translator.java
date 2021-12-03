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
	
	public float translate(ArrayList<String> stringArray)
	{
		
		try 
		{
			arithmetic_op = stringArray.get(0);
			inputOne = Float.parseFloat(stringArray.get(1));
			inputTwo = Float.parseFloat(stringArray.get(3));
		}
		catch (NumberFormatException e)
		{
			System.out.print("The 2nd and 4th input need to be numbers.");
			return Float.NaN;
		}
		
		if (stringArray.size() == 7)
		{
			try
			{
				numberOfLoops = Integer.parseInt(stringArray.get(5));
			}
			catch (NumberFormatException e)
			{
				System.out.print("The number of loops needs to be a number.");
				return Float.NaN;
			}
			if (numberOfLoops <= 0) 
			{
	            System.out.println ("Error: Input for the loop must be a positive integer.");
	            return Float.NaN;
	        }
			if (!(stringArray.get(4).equals("loop") && stringArray.get(6).equals("times")))
			{
				System.out.println ("Error: Invalid syntax for the loop.");
				return Float.NaN;
			}
		}
		
		if (arithmetic_op.equals("divide") && inputTwo == 0)
		{
			System.out.println ("Error: Cannot divide by 0.");
			return Float.NaN;
		}
		
		
		if (arithmetic_op.equals("divide") || arithmetic_op.equals("power"))
		{
			inputOne_loop = (int) (inputTwo*numberOfLoops);
		}
		else
		{
			inputOne_loop = (int) (inputOne*numberOfLoops);
		}
		
		if (arithmetic_op.equals("add") && stringArray.get(2).equals("to"))
			return math.doAddition(inputOne_loop, inputTwo);
		else if (arithmetic_op.equals("subtract") && stringArray.get(2).equals("from"))
			return math.doSubtraction(inputOne_loop, inputTwo);
		else if (arithmetic_op.equals("multiply") && stringArray.get(2).equals("by"))
			return math.doMultiplication(inputOne_loop, inputTwo);
		else if (arithmetic_op.equals("divide") && stringArray.get(2).equals("by"))
			return math.doDivision(inputOne, inputOne_loop);
		else if (arithmetic_op.equals("power") && stringArray.get(2).equals("to"))
			return math.doPower(inputOne,inputOne_loop);
		else
		{
			System.out.println("Error: Invalid syntax.");
			return Float.NaN;
		}
	}
	
	//Test for Divison by 0
	public static void test_case_1()
	{
		MathClass math = new MathClass();
		Translator translator = new Translator(math);
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("divide", "5", "by", "0"));
		translator.translate(arrayList);
		System.out.println("Output should be: \"Error: Cannot divide by 0.\"");
	}
	
	//Testing for non-positive numbers for loops in the input.
	public static void test_case_2()
	{
		MathClass math = new MathClass();
		Translator translator = new Translator(math);
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("divide", "5", "by", "2", "loop", "-2", "times"));
		translator.translate(arrayList);
		System.out.println("Output should be: \"Error: Input for the loop must be a positive integer.\"");
	}

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
