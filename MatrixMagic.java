/**
Given a matrix, mark all the rows and columns of each 0 in the matrix
**/
import java.util.*;

class MatrixMagic {

public Stack getZeroPositions(int[][] input) {
	Stack zeroPosStack = new Stack();
	System.out.println("Matrix is: \n");
	for (int row = 0; row < input.length; row++) {
		for (int col = 0; col < input.length; col++) {
			System.out.print(input[row][col] + " ");
			if (input[row][col] == 0) {
				zeroPosStack.push(row + "," + col);	
			}
		}
		System.out.println();
	}
	return zeroPosStack;
}

public void zeroAllRowsAndColsForZeroPos(int[][] input) {
	Stack zeroPosStack = getZeroPositions(input);
	while (zeroPosStack.size() != 0) {
		String[] splitArray = zeroPosStack.pop().toString().split(",");
		int row = Integer.parseInt(splitArray[0]);
		int col = Integer.parseInt(splitArray[1]);
		input = zeroRowColForGivenPos(input, row, col);
	}
	Stack ignoreStack = getZeroPositions(input);
}

private int[][] zeroRowColForGivenPos(int[][] input, int inputRow, int inputCol) {
	// zero for a given row
	for (int col = 0; col < input.length; col++) {
		input[inputRow][col] = 0;
	}
	// zero for a given col
	for (int row = 0; row < input.length; row++) {
		input[row][inputCol] = 0;
	}
	return input;
}

public static void main(String args[]) {
	MatrixMagic mm = new MatrixMagic();

	int[][] input = {{1,1,0}, {0,1,1}, {1,1,1}};
	
	Stack zeroPosStack = mm.getZeroPositions(input);
	System.out.println("Positions of 0s in (row,col): \n");
        while (zeroPosStack.size() != 0) {
                System.out.println(zeroPosStack.pop());
        }

	mm.zeroAllRowsAndColsForZeroPos(input);
}
}
