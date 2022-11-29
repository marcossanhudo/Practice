/*
	English (United States) version first.
	Versão portuguesa (Brasil) mais abaixo.
	Version française (France) ci-dessous.
	
	English (United States)
		This algorithm will try to solve a given incomplete sudoku problem,
	using the backtracking paradigm.
		Backtracking is a strategy where, given that the decisions of an algorithm
	can be represented as branches in a tree, an algorithm iterates through branches of decisions,
	and discards each branch it finds to be incapable of solving the given problem.
	The search performed by this algorithm can be classified as "Depth-First Search" (abbreviated "DFS"),
	because the algorithm analyzes each branch, as close to finishing the branch as possible;
	if that branch is finished -- or, in the case of backtracking, discarded --,
	the algorithm will analyze all remaining branches, ordered by their closest shared ancestor.
		Here, backtracking will try to solve the sudoku puzzle, space by space,
	by trying every possible digit, but only proceding if that digit can, according to the rules of the puzzle,
	be inserted in that space; if, after that insertion, the algorithm finds out
	that there's no digit that can be inserted while respecting the rules,
	the algorithm will discard that insertion, in favor of a next one. If no insertion is able
	to give a correct answer, the sudoku problem is unsolvable (or the algorithm is poorly written).
		This problem will use Java's primitive int type, which does not support null or empty values.
	Therefore, the int 0 will represent a slot's emptiness.
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sudoku {

	public static final int lineLength = 9;
	public static int[][] board = new int[lineLength][lineLength];
	public static int possibleSolutions = 0;

	public static void main(String args[]) throws FileNotFoundException {
		generateBoard(args[0]);
		for (int number = 1; number <= lineLength; number++){
			nextSlot(number, 0, 0);
		}
	}
	
	public static boolean nextSlot(int number, int x, int y){
		if (board[x][y] == 0){
			if (canInsert(number, x, y)) {
				board[x][y] = number;
	
				if (x < lineLength - 1){
					for (int nextNumber = 1; nextNumber <= lineLength; nextNumber++)
						nextSlot(nextNumber, x + 1, y);		// If there's a following slot on the same row, try it;
				} else if (y < lineLength - 1){
					for (int nextNumber = 1; nextNumber <= lineLength; nextNumber++)
						nextSlot(nextNumber, 0, y + 1);		// otherwise, if there's a following row, try it;
				} else {
					possibleSolutions++;
					System.out.print("\n\nSolution #" + possibleSolutions);
					printBoard();
				}

				board[x][y] = 0;				

			} else return false;			
		} else {
			if (x < lineLength - 1){
				for (int nextNumber = 1; nextNumber <= lineLength; nextNumber++)
					nextSlot(nextNumber, x + 1, y);			// If there's a following slot on the same row, try it;
			} else if (y < lineLength - 1){
				for (int nextNumber = 1; nextNumber <= lineLength; nextNumber++)
					nextSlot(nextNumber, 0, y + 1);			// otherwise, if there's a following row, try it;
			} else {
				possibleSolutions++;
				System.out.println("\nSolution #" + possibleSolutions);
				printBoard();
			}
		}
		return true;
	}

	public static void printBoard(){
		for (int row = 0; row < lineLength; row++){
			System.out.println();
			for (int column = 0; column < lineLength; column++)
				System.out.print(board[row][column] + " ");
		}
	}

	public static boolean canInsert(int number, int x, int y){
		for (int slotInRow = 0; slotInRow < lineLength; slotInRow++)
			if (board[slotInRow][y] == number
				&& slotInRow != x)
				return false;

		for (int slotInColumn = 0; slotInColumn < lineLength; slotInColumn++)
			if (board[x][slotInColumn] == number
				&& slotInColumn != y)
				return false;

		for (int slotInRow = x / 3 * 3; slotInRow <= x / 3 * 3 + 2 ; slotInRow++)			// Dividing by a number, and then multiplying the result by that same number,
			for (int slotInColumn = y / 3 * 3; slotInColumn <= x / 3 * 3 + 2; slotInColumn++)	// would normally be a waste of effort; in this case, it isn't,
				if (board[slotInRow][slotInColumn] == number					// because, in Java, the division of an int discards the remainder found.
					&& x != slotInRow							// This way, dividing x or y by 3 will return the first index of their respective quadrants.
					&& y != slotInColumn)							// Adding 2 gets the final index of the same quadrant.
					return false;								// Note that this method wouldn't work with if the division was mathematically correct.

		return true;		
	}

	public static void generateBoard(String puzzleFilePath) throws FileNotFoundException {
		File sudokuFile = new File(puzzleFilePath);
		try (Scanner scanner = new Scanner(sudokuFile)){
			int row = 0;
			while (scanner.hasNextLine()){
				String[] nextLineStrings = scanner.nextLine().split(" ");
				for (int column = 0; column < lineLength; column++)
					board[row][column] = Integer.parseInt(nextLineStrings[column]);
				row++;
			}
		} catch (FileNotFoundException e){
			throw e;
		}
	}
		
}
/*
	Português (Brasil)
		Este algoritmo tentará resolver um dado problema incompleto de Sudoku,
	usando o paradigma de backtracking.
		Backtracking é uma estratégia, onde, dado que as decisões de um algoritmo
	podem ser representadas como ramos de uma árvore, um algoritmo itera sobre ramos de decisões,
	e descarta cada ramo que ele descobre ser incapaz de resolver o dado problema.
	A pesquisa desempenhada por este algoritmo pode ser classificada como "Depth-First Search" (abreviado "DFS"; traduzível como "Busca em Profundidade"),
	porque o algoritmo analisa cada ramo, o mais próximo possível de terminá-lo;
	se esse ramo for terminado -- ou, no caso do backtracking, descartado --,
	o algoritmo analisará todos os ramos pendentes, na ordem do mais próximo ancestral comum.
		Aqui, o backtracking tentará resolver o sudoku, espaço por espaço,
	tentando todo dígito possível, mas apenas prosseguindo se esse dígito puder, de acordo com as regras do jogo,
	ser inserso nesse espaço; se, depois desta inserção, o algoritmo descobrir
	que não há dígito que possa ser inserso com respeito às regras,
	o algoritmo descartará essa inserção, em favor de uma próxima. Se nenhuna inserção é capaz
	de dar uma resposta correta, o problema de sudoku é insolucionável (ou o algoritmo é mal escrito).
		Este algoritmo utilizará o tipo primitivo int do Java, que não oferece valores nulos ou vazios.
	Logo, o int 0 representará a vaziedade de um espaço.
*/
