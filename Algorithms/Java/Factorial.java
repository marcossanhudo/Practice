public class Factorial {

	public static void main(String args[]){
		int getFactorialOf = Integer.parseInt(args[0]);
		int result = 1;

		for (int multiplier = 1; multiplier <= getFactorialOf; multiplier++){
			result *= multiplier;
		}

		System.out.println(result);
	}

}