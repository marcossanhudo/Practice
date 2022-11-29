public class Fibonacci {

	public static void main(String args[]){
		int iterationsToDo = Integer.parseInt(args[0]);

		int previous = 0;
		int secondPrevious = 1;

		for (int iteration = 0; iteration < iterationsToDo; iteration++){
			int aux = previous;
			previous += secondPrevious;
			secondPrevious = aux;
			System.out.print(current + " ");
		}
	}

}