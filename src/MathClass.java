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
    
	// Test case that checks if the addition operation works
    public static void addition_test_case()
    {
    	MathClass math = new MathClass();
    	float result = math.doAddition(5, 3);
    	System.out.println("Result: " + result);
    	System.out.println("Output should be: \"Result: 8.0\"");
    }
    
	// Test case that checks if the subtraction operation works
    public static void subtraction_test_case()
    {
    	MathClass math = new MathClass();
    	float result = math.doSubtraction(5, 3);
    	System.out.println("Result: " + result);
    	System.out.println("Output should be: \"Result: 2.0\"");
    }
    
	// Test case that checks if the division operation works
    public static void division_test_case()
    {
    	MathClass math = new MathClass();
    	float result = math.doDivision(5, 2);
    	System.out.println("Result: " + result);
    	System.out.println("Output should be: \"Result: 2.5\"");
    }
    
	// Test case that checks if the multiplication operation works
    public static void multiplication_test_case()
    {
    	MathClass math = new MathClass();
    	float result = math.doMultiplication(5, 3);
    	System.out.println("Result: " + result);
    	System.out.println("Output should be: \"Result: 15.0\"");
    }
    
	// Test case that checks if the power operation works
    public static void power_test_case()
    {
    	MathClass math = new MathClass();
    	float result = math.doPower(5, 3);
    	System.out.println("Result: " + result);
    	System.out.println("Output should be: \"Result: 125.0\"");
    }
    
}