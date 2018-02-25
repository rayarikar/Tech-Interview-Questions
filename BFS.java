/**
Each method describes the unique problem it is trying to solve
**/
class BFS {
    
    // Write breadth-first search in a matrix
    static void BFSOnMatrix(String[][] inputMatrix) {
        printMatrix(inputMatrix);
        System.out.println("SearchGraph output: \n");
        for (int row = 0; row < inputMatrix.length; row++) {
            for (int col = 0; col < inputMatrix[0].length; col++) {
                System.out.print(" " + inputMatrix[row][col]);
            }
        }
    }
    
    static void printMatrix(String[][] input) {
        System.out.println("\nMatrix:\n");
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(" " + input[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]) {
        String[][] input = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                input[i][j] = i + "" + j;
            }
        }
    
        System.out.println("breadth-first search in a matrix");
        BFSOnMatrix(input);    
    }
}