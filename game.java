import org.javatuples.Quartet;
import org.javatuples.Triplet;
import java.util.*;
class game extends numberSeries
{
	
	static int difficulty;
	static Quartet<Integer, Integer, Integer, Integer> nums;
	static Triplet<Integer, Integer, Integer> tripNums;
	static int num1;
	static int num2;
	static char op ;
	

	public static void main(String args[]) 
	{
		
		int temp;
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
		
		System.out.println("Use addition, subtraction, division, or multiplication to get the sum of 24!");
		System.out.println("List of numbers available to use:");
		System.out.println(nums);
		System.out.println("Enter an expression.");

		//Get string expression input.
		expression = input.nextLine();
		System.out.println(expression);
		
		
		//make sure input is valid
		if( ! isExpressionValid(expression, operators))
			while(! isExpressionValid(expression, operators))
			{
				System.out.println("Invalid expression. Try again.");
				expression = input.nextLine();
			}
		
		convertInput(expression);
			
	}
	
}
