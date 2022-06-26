import java.util.*;
import org.javatuples.Quartet;
import org.javatuples.Triplet;
import org.javatuples.Pair;

class numberSeries {
	
	@SuppressWarnings("rawtypes")
	public static Quartet easy(int numOfSeries){
		
		Quartet<Integer, Integer, Integer, Integer> q1 = new Quartet<Integer, Integer, Integer, Integer>(8,6,2,2);
		Quartet<Integer, Integer, Integer, Integer> q2 = new Quartet<Integer, Integer, Integer, Integer>(4,5,2,2);
		Quartet<Integer, Integer, Integer, Integer> q3 = new Quartet<Integer, Integer, Integer, Integer>(8,4,4,2);
		Quartet<Integer, Integer, Integer, Integer> q4 = new Quartet<Integer, Integer, Integer, Integer>(8,8,7,1);
		
		Map<Integer, Quartet<Integer, Integer, Integer, Integer>> easySeries = new HashMap<>();

		easySeries.put(1, q1);
		easySeries.put(2, q2);
		easySeries.put(3,  q3);
		easySeries.put(4,  q4);
		
		for(Integer key: easySeries.keySet() ) {
			if(key == numOfSeries) 
				return easySeries.get(key);
			else
				System.out.println("Series not found:\t" + numOfSeries);
		}

		return null;
	}
	
	public static Quartet med(int numOfSeries){
		
		Quartet<Integer, Integer, Integer, Integer> q1 = new Quartet<Integer, Integer, Integer, Integer>(2,8,4,7);
		Quartet<Integer, Integer, Integer, Integer> q2 = new Quartet<Integer, Integer, Integer, Integer>(2,6,4,7);
		Quartet<Integer, Integer, Integer, Integer> q3 = new Quartet<Integer, Integer, Integer, Integer>(2,6,6,5);
		//Quartet<Integer, Integer, Integer, Integer> q4 = new Quartet<Integer, Integer, Integer, Integer>(8,8,7,1);
		
		Map<Integer, Quartet<Integer, Integer, Integer, Integer>> easySeries = new HashMap<>();

		easySeries.put(1, q1);
		easySeries.put(2, q2);
		easySeries.put(3,  q3);
		//easySeries.put(4,  q4);
		
		for(Integer key: easySeries.keySet() ) {
			if(key == numOfSeries) 
				return easySeries.get(key);
			else
				System.out.println("Series not found:\t" + numOfSeries);
		}

		return null;
	}
	
	public static Quartet hard(int numOfSeries){
		
		Quartet<Integer, Integer, Integer, Integer> q1 = new Quartet<Integer, Integer, Integer, Integer>(1,8,4,5);
		Quartet<Integer, Integer, Integer, Integer> q2 = new Quartet<Integer, Integer, Integer, Integer>(2,9,7,8);
		Quartet<Integer, Integer, Integer, Integer> q3 = new Quartet<Integer, Integer, Integer, Integer>(2,7,3,6);
		//Quartet<Integer, Integer, Integer, Integer> q4 = new Quartet<Integer, Integer, Integer, Integer>(8,8,7,1);
		
		Map<Integer, Quartet<Integer, Integer, Integer, Integer>> easySeries = new HashMap<>();

		easySeries.put(1, q1);
		easySeries.put(2, q2);
		easySeries.put(3,  q3);
		//easySeries.put(4,  q4);
		
		for(Integer key: easySeries.keySet() ) {
			if(key == numOfSeries) 
				return easySeries.get(key);
			else
				System.out.println("Series not found:\t" + numOfSeries);
		}

		return null;
	}
	
	static int calc(int op1, int op2, char op)
	{
		int result = 0;
		
		switch(op)
		{
			case '+':
				result = op1 + op2;
				break;
			case '-':
				result = op1 - op2;
				break;
			case '/':
				result = op1 / op2;
				break;
				
			case '*':
				result = op1 * op2;
				break;
			default:
				System.out.println("Incorrect operator.");
				break;
		}
		
		
		return result;
	}
	
	//check expression is numbers and valid operators
	//fails if number is double digit
	static boolean isExpressionValid(String expression, Character[] operators)
	{
		
		List<Character> charList = new ArrayList<>(Arrays.asList(operators));
		
		if( Character.isDigit(expression.replaceAll(" ", "").charAt(0)) && Character.isDigit(expression.replaceAll(" ", "").charAt(2))
				&& charList.contains(expression.replaceAll(" ", "").charAt(1)))
			return true;
		
			
		return false;
	}
	
	//check number inputs are in valid choices.
	static boolean isQuartetInputValid(Quartet nums, int num1, int num2)
	{
		Triplet<Integer, Integer, Integer> temp;
		
		if(! nums.contains((Integer)num1)) 
		{
			System.out.println("Number1 "+num1+" is not valid.");
			return false;
		}
		else 
		{
			if( (Integer)num1 == nums.getValue0())
				temp = nums.removeFrom0();
			else if( (Integer)num1 == nums.getValue1())
				temp = nums.removeFrom1();
			else if( (Integer)num1 == nums.getValue2())
				temp = nums.removeFrom2();
			else
				temp = nums.removeFrom3();
		}
		
		if(! temp.contains((Integer)num2)) 
		{
			System.out.println("Number2 "+num2+" is not valid.");
			return false;
		}
		
		return true;
	}
	
	//check number inputs are in valid choices.
	static boolean isTripletInputValid(Triplet nums, int num1, int num2)
	{
		Pair<Integer, Integer> temp;
		
		if(! nums.contains((Integer)num1)) 
		{
			System.out.println("Number1 "+num1+" is not valid.");
			return false;
		}
		else 
		{
			if( (Integer)num1 == nums.getValue0())
				temp = nums.removeFrom0();
			else if( (Integer)num1 == nums.getValue1())
				temp = nums.removeFrom1();
			else
				temp = nums.removeFrom2();
		}
		
		if(! temp.contains((Integer)num2)) 
		{
			System.out.println("Number2 "+num2+" is not valid.");
			return false;
		}
		
		return true;
	}
	
	static Triplet convertToTriplet(Triplet trip, Quartet nums, Integer num1, Integer num2, char op)
	{
		Triplet<Integer, Integer, Integer> temp;
		int result = calc(num1, num2, op);
		
		//remove num1 and create temporary triplet
		if( (Integer)num1 == nums.getValue0())
			temp = nums.removeFrom0();
		else if( (Integer)num1 == nums.getValue1())
			temp = nums.removeFrom1();
		else if( (Integer)num1 == nums.getValue2())
			temp = nums.removeFrom2();
		else
			temp = nums.removeFrom3();
		
		//remove num2 from temporary triplet and add result
		if( (Integer)num2 == temp.getValue0())
			trip = temp.removeFrom0().add((Integer)result);
		else if( (Integer)num2 == temp.getValue1())
			trip = temp.removeFrom1().add((Integer)result);
		else
			trip = temp.removeFrom2().add((Integer)result);
		
		return trip;
	}
	
	static Pair convertToPair(Pair pair, Triplet nums, Integer num1, Integer num2, char op)
	{
		Pair< Integer, Integer> temp;
		int result = calc(num1, num2, op);
		
		//remove num1 and create temporary triplet
		if( (Integer)num1 == nums.getValue0())
			temp = nums.removeFrom0();
		else if( (Integer)num1 == nums.getValue1())
			temp = nums.removeFrom1();
		else
			temp = nums.removeFrom2();
		
		//remove num2 from temporary triplet and add result
		if( (Integer)num2 == temp.getValue0())
			pair = temp.removeFrom0().add((Integer)result);
		else
			pair = temp.removeFrom1().add((Integer)result);
		
		return pair;
	}
	
	//converts the arithmetic string input from user
	//into num1 num2 and op
	static void convertInput(String expression)
	{
		String input = expression.replaceAll(" ", "");
		game.num1 = Character.getNumericValue(input.charAt(0));
		game.num2 = Character.getNumericValue(input.charAt(2));
		game.op = input.charAt(1);
		
	}
	
	static void usage(Object obj)
	{
		
		System.out.println("Use addition, subtraction, division, or multiplication to get the sum of 24!");
		System.out.println("List of numbers available to use:");
		System.out.println(obj);
		System.out.println("Enter an expression.");
	}
	
}
