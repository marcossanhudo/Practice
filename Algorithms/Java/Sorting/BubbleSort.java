package Sorting;

public class BubbleSort {

	public double[] ascending(double[] array){
		for (int iterations = 0; iterations < array.length; iterations++)
			for (int index = 0; index < array.length - 1; index++)
				if (array[index] < array[index + 1]){
					double aux = array[index + 1];
					array[index + 1] = array[index];
					array[index] = aux;
				}
		return array;
	}
	public double[] descending(double[] array){
		for (int iterations = 0; iterations < array.length; iterations++)
			for (int index = 0; index < array.length - 1; index++)
				if (array[index] > array[index + 1]){
					double aux = array[index + 1];
					array[index + 1] = array[index];
					array[index] = aux;
				}
		return array;
	}

}