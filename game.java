import org.javatuples.Quartet;
import java.util.*;
class HelloWorld extends numberSeries
{
	static int difficulty;
	static Quartet<Integer, Integer, Integer, Integer> nums;

	public static void main(String args[]) 
	{
		System.out.println("Welcome to 24.");
		System.out.println("Choose level of difficulty!");
		System.out.println("1 = easy");
		System.out.println("2 = medium");
		System.out.println("3 = hard");

		Scanner input = new Scanner(System.in);    //System.in is a standard input stream
		int difficulty = input.nextInt();  
		
		if(  difficulty > 3 || difficulty < 1) //Make sure user input is correct.
		{
			while( difficulty > 3 || difficulty <1)
			{
				System.out.println( difficulty + ": Is not a supported option. Try again");
				difficulty = input.nextInt();
			}
		}
		
		
		//get list depending on difficulty
		if(difficulty == 1)
			nums = easy(1);
		else if (difficulty == 2)
			nums = med(1);
		else
			nums = hard(1);
		
		System.out.println("List of numbers available to use:");
		System.out.println(nums);
		
		
	}
	
}