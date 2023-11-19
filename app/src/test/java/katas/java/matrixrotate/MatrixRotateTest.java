package katas.java.matrixrotate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixRotateTest {
    /**
     * (0) (1)
     * (2) (3)
     */
    int[][] twoTwoMatrix = new int[][]{new int[]{0, 1}, new int[]{2, 3}};

    /**
     * (0) (1) (2) (3)
     * (4) (5) (6) (8)
     * (8) (9) (10) (11)
     * (12) (13) (14) (15)
     */
    int[][] fourfourMatrix = new int[][]{new int[]{0, 1, 2, 3},
            new int[]{4, 5, 6, 8},
            new int[]{8, 9, 10, 11},
            new int[]{12, 13, 14, 15}};

    @Test
    public void testPrint() {
        for (int i = 0; i < twoTwoMatrix.length; i++) {
            for (int j = 0; j < twoTwoMatrix.length; j++) {
                System.out.print(twoTwoMatrix[i][j]);
            }
            System.out.println("\n");
        }
    }

    /**
     * (2) (0)
     * (3) (1)
     */
    @Test
    public void testRotate2x2Matrix() throws Exception {

        int[][] expectedMatrix = new int[][]{new int[]{2, 0}, new int[]{3, 1}};
        MatrixRotate.rotate(twoTwoMatrix);
        Assertions.assertArrayEquals(expectedMatrix, twoTwoMatrix);
    }

    /**
     * (12) (8) (4) (0)
     * (13) (9) (5) (1)
     * (14) (10) (6) (2)
     * (15) (11) (8) (3)
     */
    @Test
    public void testRotate4x4Matrix() throws Exception {

        int[][] expectedMatrix = new int[][]{new int[]{12, 8, 4, 0},
                new int[]{13, 9, 5, 1},
                new int[]{14, 10, 6, 2},
                new int[]{15, 11, 7, 3}};
        MatrixRotate.rotate(fourfourMatrix);
        Assertions.assertEquals(expectedMatrix, fourfourMatrix);
    }
}
