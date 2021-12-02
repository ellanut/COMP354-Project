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
	@Override
    public float doAddition(float num1,float num2) {
        float AdditionResult = num1+num2;
        return AdditionResult;
    }
    @Override
    public float doSubtraction(float num1,float num2) {
        float SubtructionResult= num1-num2;
        return SubtructionResult;
    }
    @Override
    public float doMultiplication(float num1,float num2) {
        float MultiplicationResult = num1*num2;
        return MultiplicationResult;
    }
    @Override
    public float doDivision(float num1,float num2) {
        float DivisionResult = num1/num2;
        return DivisionResult;
    }

    @Override
    public float doPower(float inputOne,int power) {
        float PowerResult =  (float) Math.pow(inputOne,power);
        return PowerResult;
    }
    
    public static void addition_test_case()
    {
    	MathClass math = new MathClass();
    	float result = math.doAddition(5, 3);
    	System.out.println("Result: " + result);
    	System.out.println("Output should be: \"Result: 8.0\"");
    }
    
    public static void subtraction_test_case()
    {
    	MathClass math = new MathClass();
    	float result = math.doSubtraction(5, 3);
    	System.out.println("Result: " + result);
    	System.out.println("Output should be: \"Result: 2.0\"");
    }
    
    public static void division_test_case()
    {
    	MathClass math = new MathClass();
    	float result = math.doDivision(5, 2);
    	System.out.println("Result: " + result);
    	System.out.println("Output should be: \"Result: 2.5\"");
    }
    
    public static void multiplication_test_case()
    {
    	MathClass math = new MathClass();
    	float result = math.doMultiplication(5, 3);
    	System.out.println("Result: " + result);
    	System.out.println("Output should be: \"Result: 15.0\"");
    }
    
    public static void power_test_case()
    {
    	MathClass math = new MathClass();
    	float result = math.doPower(5, 3);
    	System.out.println("Result: " + result);
    	System.out.println("Output should be: \"Result: 125.0\"");
    }
    
}