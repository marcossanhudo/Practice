public class Statistician {

	public static double[] data;

	public static void main(String args[]){
		parseArguments(args);
	}

	public static void parseArguments(String args[]){
		for (String entry: args)
			pushToData(Double.parseDouble(entry));
	}

	public static boolean pushToData(double entry){
		double[] aux = new double[data.length];
		for (int index = 0; index < data.length; index++)
			aux[index] = data[index];
		aux[data.length] = entry;
		data = aux;
		return true;
	}

	public static double highest(){
		double highest = data[0];
		for (double check: data)
			if (check > highest) highest = check;
		return highest;
	}

	public static double lowest(){
		double lowest = data[0];
		for (double check: data)
			if (check < lowest) lowest = check;
		return lowest;
	}

	public static double amplitude(){
		return highest() - lowest();
	}

	public static double average(){
		double numerator = 0;
		for (double entry: data)
			numerator += entry;
		int denominator = data.length;
		return numerator / denominator;
	}

	public static double mode(){
		
	}

	public static double mean(){
		sortAscending();
	}

	public static void sortAscending(){}
	public static void sortDescending(){}

}