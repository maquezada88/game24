import java.util.*;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

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
	
	int calc1(int op1, int op2, String op)
	{
		int result = 0;
		
		switch(op)
		{
			case "+":
				result = op1 + op2;
				break;
			case "-":
				result = op1 - op2;
				break;
			case "/":
				result = op1 / op2;
				break;
				
			case "*":
				result = op1 * op2;
				break;
			default:
				System.out.println("Incorrect operator.");
				break;
		}
		
		
		return result;
	}
	
	static Triplet removeNum(int val, Quartet nums)
	{
		Triplet<Integer, Integer, Integer> trips;
		int counter;
		System.out.println("REMOVE MOETHOD");
		
			if( (Integer)val == nums.getValue0())
				trips = nums.removeFrom0();
			else if( (Integer)val == nums.getValue1())
				trips = nums.removeFrom1();
			else if( (Integer)val == nums.getValue2())
				trips = nums.removeFrom2();
			else
				trips = nums.removeFrom3();
			
			return trips;
				
	}
	
	
	
	
}
