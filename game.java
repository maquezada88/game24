import org.javatuples.Quartet;
import org.javatuples.Triplet;
import org.javatuples.Pair;
import java.util.*;
class game extends numberSeries
{
	
	static int difficulty;
	static Quartet<Integer, Integer, Integer, Integer> nums;
	static Triplet<Integer, Integer, Integer> tripNums;
	static Pair<Integer, Integer> pairNums;
	static int num1;
	static int num2;
	static char op ;
	static int result;
	

	public static void main(String args[]) 
	{
		Character[] operators = {'+', '-', '*', '/'};
		String expression;

		System.out.println("Welcome to 24.");
		System.out.println("Choose level of difficulty!");
		System.out.println("1 = easy");
		System.out.println("2 = medium");
		System.out.println("3 = hard");

		Scanner input = new Scanner(System.in);    //System.in is a standard input stream
		difficulty = input.nextInt();  
		
		if(  difficulty > 3 || difficulty < 1) //Make sure user input is valid.
		{
			while( difficulty > 3 || difficulty <1)
			{
				System.out.println( difficulty + " : Is not a supported option. Try again.");
				difficulty = input.nextInt();
			}
		}
		
		
		//skip remaining line
		input.nextLine();
		
		//get list depending on difficulty
		if(difficulty == 1)
			nums = easy(1);
		else if (difficulty == 2)
			nums = med(1);
		else
			nums = hard(1);
		
		usage(nums);

		//Get string expression input.
		expression = input.nextLine();
		System.out.println(expression);
		convertInput(expression);
		
		
		//make sure input has numbers and valid operators
		while(! isExpressionValid(expression, operators) || ! isQuartetInputValid(nums, num1, num2))
		{
			System.out.println("Invalid expression. Try again.");
			expression = input.nextLine();
			convertInput(expression);
		}
		
		result = calc(num1, num2, op);		
		System.out.println("result:\t"+result);
		
		tripNums = convertToTriplet(tripNums, nums, num1, num2, op);
		
		usage(tripNums);
		
		//Get string expression input.
		expression = input.nextLine();
		System.out.println(expression);
		convertInput(expression);
		
		while( ! isExpressionValid(expression, operators) || ! isTripletInputValid(tripNums, num1, num2))
		{
			System.out.println("Invalid expression. Try again.");
			expression = input.nextLine();
			convertInput(expression);
		}
		
		result = calc(num1, num2, op);		
		System.out.println("result:\t"+result);
		
		pairNums = convertToPair(pairNums, tripNums, num1, num2, op);
		
		usage(pairNums);
		
		input.close();
	}
	
}
