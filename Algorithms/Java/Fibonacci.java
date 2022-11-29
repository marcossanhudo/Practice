public class Fibonacci {

	public static void main(String args[]){
		int iterationsToDo = Integer.parseInt(args[0]);

		int current = 0;
		int previous = 0;
		int secondPrevious = 1;

		for (int iteration = 0; iteration < iterationsToDo; iteration++){
			current = previous + secondPrevious;
			secondPrevious = previous;
			previous = current;
			System.out.print(current + " ");
		}
	}

}