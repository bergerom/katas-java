package katas.java.matrixrotate;


public class MatrixRotate {
    public static void rotate(int[][] matrix) throws Exception {
        int n = matrix.length;
        int topLeft;

        int leftCol = 0;
        int rightCol = n - 1;
        int topRow = leftCol;
        int bottomRow = rightCol;

        for(int depth = 0; depth < n/2; depth++) {
            for (int i = 0; i < n - 1; i++) {

                topRow = leftCol;
                bottomRow = rightCol;

                topLeft = matrix[topRow][leftCol + i];

                matrix[topRow][leftCol + i] = matrix[bottomRow - i][leftCol];

                matrix[bottomRow - i][leftCol] = matrix[bottomRow][rightCol - i];

                matrix[bottomRow][rightCol - i] = matrix[topRow+i][rightCol];

                matrix[topRow+i][rightCol] = topLeft;

            }
            leftCol++;
            rightCol--;
        }
    }

    public static void switchAndPrint(int i0, int j0, int i1, int j1, int[][] matrix) {
        System.out.println(String.format("Replacing %s with %s", matrix[i0][j0], matrix[i1][j1]));
        matrix[i0][j0] = matrix[i1][j1];
    }
}
