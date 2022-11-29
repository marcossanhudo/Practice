package Sorting;

public class Compare {

	public double lowest(double[] array){
		double lowest = array[0];
		for (double check: array)
			if (check < lowest) lowest = check;
		return lowest;
	}
	public double highest(double[] array){
		double highest = array[0];
		for (double check: array)
			if (check > highest) highest = check;
		return highest;
	}

}