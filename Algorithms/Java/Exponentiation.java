public class Exponentiation {

	public static void main(String[] args){
		double base = Double.parseDouble(args[0]);
		double exponent = Double.parseDouble(args[1]);
		double result = 1;

		if (exponent > 0)
			for (int iteration = 0; iteration < exponent; iteration++)
				result *= base;
		else if (exponent < 0)
			for (int iteration = 0; iteration > exponent; iteration--)
				result /= base;

		System.out.println(result);
	}

}