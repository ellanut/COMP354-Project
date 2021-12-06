public class MathClass implements PerformMathOperations{
    private String desiredOperation;
    private float inputOne;
    private float inputTwo;
    private int numberOfLoops;
    private float result;

    public String getDesiredOperation() {
		return desiredOperation;
	}
	public void setDesiredOperation(String desiredOperation) {
		this.desiredOperation = desiredOperation;
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
	public float getResult() {
		return result;
	}
	public void setResult(float result) {
		this.result = result;
	}
	
	// Gives the result of adding the two numbers together
	@Override
    public float doAddition(float num1,float num2) {
        float AdditionResult = num1+num2;
        return AdditionResult;
    }
	// Gives the result of subtracting the first number to the second
    @Override
    public float doSubtraction(float num1,float num2) {
        float SubtructionResult= num2-num1;
        return SubtructionResult;
    }
	// Gives the result of multiplying both numbers together
    @Override
    public float doMultiplication(float num1,float num2) {
        float MultiplicationResult = num1*num2;
        return MultiplicationResult;
    }
	// Gives the result of dividing the second number from the first
    @Override
    public float doDivision(float num1,float num2) {
        float DivisionResult = num1/num2;
        return DivisionResult;
    }
	// Gives the result of the first number to the power of the second number
    @Override
    public float doPower(float inputOne,int power) {
        float PowerResult =  (float) Math.pow(inputOne,power);
        return PowerResult;
    }
    

	// Test cases variables
	static int numTest1 = 5;
	static int numTest2 = 3;

	// MATHCLASS TEST CASE 1: Checks if the addition arithmetic operation works.
    public static void addition_test_case()
    {
		System.out.println("MATHCLASS TEST CASE 1: Checks if the addition arithmetic operation works.");
    	MathClass math = new MathClass();
    	float result = math.doAddition(numTest1, numTest2);
		System.out.println("INPUT: " + numTest1 + " & " + numTest2);
    	System.out.println("OUTPUT: " + result);
    	System.out.println("EXPECTED OUTPUT: \"8.0\" \n");
    }
    
	// MATHCLASS TEST CASE 2: Checks if the subtraction arithmetic operation works.
    public static void subtraction_test_case()
    {
		System.out.println("MATHCLASS TEST CASE 2: Checks if the subtraction arithmetic operation works.");
    	MathClass math = new MathClass();
    	float result = math.doSubtraction(numTest1, numTest2);
		System.out.println("INPUT: " + numTest1 + " & " + numTest2);
    	System.out.println("OUTPUT: " + result);
    	System.out.println("EXPECTED OUTPUT: \"-2.0\" \n");
    }
	// MATHCLASS TEST CASE 3: Checks if the multiplication arithmetic operation works.
    public static void multiplication_test_case()
    {
		System.out.println("MATHCLASS TEST CASE 3: Checks if the multiplication arithmetic operation works.");
    	MathClass math = new MathClass();
    	float result = math.doMultiplication(numTest1, numTest2);
		System.out.println("INPUT: " + numTest1 + " & " + numTest2);
    	System.out.println("OUTPUT: " + result);
    	System.out.println("EXPECTED OUTPUT: \"15.0\" \n");
    }    

	// MATHCLASS TEST CASE 4: Checks if the division arithmetic operation works.
    public static void division_test_case()
    {
		System.out.println("MATHCLASS TEST CASE 4: Checks if the division arithmetic operation works.");
    	MathClass math = new MathClass();
    	float result = math.doDivision(numTest1, numTest2);
		System.out.println("INPUT: " + numTest1 + " & " + numTest2);
    	System.out.println("OUTPUT: " + result);
    	System.out.println("EXPECTED OUTPUT: \"1.6666666\" \n");
    }
    
	// MATHCLASS TEST CASE 5: Checks if the power arithmetic operation works.
    public static void power_test_case()
    {
		System.out.println("MATHCLASS TEST CASE 5: Checks if the power arithmetic operation works.");
    	MathClass math = new MathClass();
    	float result = math.doPower(numTest1, numTest2);
		System.out.println("INPUT: " + numTest1 + " & " + numTest2);
    	System.out.println("OUTPUT: " + result);
    	System.out.println("EXPECTED OUTPUT: \"125.0\" \n");
    }
    
}