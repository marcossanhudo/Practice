import java.util.HashMap;

public class Statistician {

	public static double[] data = new double[0];
	public static boolean dataHasBeenSorted = false;

	public static void main(String args[]) throws Exception {
		if (args.length == 0)
			throw new Exception("Inform the numbers you want to analyse on the command line.");
		parseArguments(args);
		System.out.println("Sample size (n): " + args.length);
		System.out.println("Amplitude (R): " + amplitude());
		System.out.println("\tHighest: " + highest());
		System.out.println("\tLowest: " + lowest());
		System.out.println("Arithmetic average (x̄): " + arithmeticAverage());
		System.out.println("Median (Md): " + median());
		System.out.println("Mode (Mo): " + mode());
		System.out.println("Sample variance (s²): " + sampleVariance());
		//System.out.println("Sample standard deviation (s): " + standardDeviation());
		//System.out.println();
	}

	public static void parseArguments(String args[]){
		for (String entry: args)
			pushToData(Double.parseDouble(entry));
	}

	public static boolean pushToData(double entry){
		int dataLength = data.length;
		double[] aux = new double[dataLength + 1];
		if (dataLength > 0)
			for (int index = 0; index < dataLength; index++)
				aux[index] = data[index];
		aux[dataLength] = entry;
		data = aux;
		return true;
	}

	public static double highest(){
		return highest(data);
	}
	public static double highest(double[] set){
		double highest = set[0];
		for (double check: set)
			if (check > highest) highest = check;
		return highest;
	}

	public static double lowest(){
		return lowest(data);
	}
	public static double lowest(double[] set){
		double lowest = set[0];
		for (double check: set)
			if (check < lowest) lowest = check;
		return lowest;
	}

	public static double amplitude(){
		return amplitude(data);
	}
	public static double amplitude(double[] set){
		return highest(set) - lowest(set);
	}

	public static double arithmeticAverage(){
		return arithmeticAverage(data);
	}
	public static double arithmeticAverage(double[] set){
		double numerator = 0;
		for (double entry: set)
			numerator += entry;
		int denominator = set.length;
		return numerator / denominator;
	}

	public static double mode(){
		return mode(data);
	}
	public static double mode(double[] set){
		int setLength = set.length;
		HashMap<Double, Integer> quantities = new HashMap<>();

		for (int index = 0; index < setLength; index++){
			if (quantities.containsKey(new Double(set[index])))
				quantities.put(set[index], quantities.get(new Double(set[index])) + 1);
			else quantities.put(set[index], 1);
		}
		
		double mode = set[0];
		for (double datum: set)
			if (quantities.get(datum) > quantities.get(mode)) mode = datum;
		
		return mode;
	}

	public static double median(){
		return median(data);
	}
	public static double median(double[] set){
		int setLength = set.length;
		if (setLength % 2 == 0){
			double[] setMiddle = {set[setLength / 2], set[setLength / 2 + 1]};
			return arithmeticAverage(setMiddle);
		} else
			return set[setLength / 2];
	}

	public static double sampleVariance(){
		return sampleVariance(data);
	}
	public static double sampleVariance(double[] set){
		double variance = 0;
		double arithmeticAverage = arithmeticAverage();
		double setLength = set.length;
		for (int index = 0; index < setLength; index++){
			variance += exponentiation(set[index] - arithmeticAverage, 2);
		}
		variance /= setLength - 1;
		return variance;
	}

	public static double exponentiation(double base, double exponent){
		if (base == 0) return 0;
		if (exponent == 0) return 1;
		for (int iteration = 1; iteration < exponent; iteration++){
			base *= base;
		}
		return base;
	}
	/*public static double radiciation(double base, double root){
		
	}
	public static double factorisation(double toFactor){
		int factor = 2;
		if (number % factor == 0) {
			number 
		}
		else factor = nextPrime(factor);
	}
	public static int nextPrime(int currentNumber){
		for (int test = currentNumber; ; test++){
			for (int previousNumber = 2; previousNumber < test; previousNumber++)
				if (test % previousNumber == 0) break;
			return test;
		}
	}

	public static double standardDeviation(){
		return standardDeviation(data);
	}
	public static double standardDeviation(double[] set){
		return 0;
	}

	public static double[] inAscending(){
		
	}
	public static double[] inDescending(){

	}
	public static void sortAscending(){
		data = inAscending();
	}
	public static void sortDescending(){
		data = inDescending();
	}*/

}