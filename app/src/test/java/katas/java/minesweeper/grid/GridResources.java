package katas.java.minesweeper.grid;

public class GridResources {

    public static String invalidCharacterGrid() {
        return """
                |- -|
                |* 2|
                |2 *|
                |- -|""";
    }

    public static String complexGridOne() {
        return """
                |- - - - -|
                |1 2 2 1 o|
                |1 x x 1 o|
                |1 2 2 2 1|
                |o 1 1 3 x|
                |o 1 x 3 x|
                |- - - - -|""";
    }

    public static String complexGridTwo() {
        return """
                |- - - - -|
                |o 1 x 1 o|
                |1 2 2 1 o|
                |1 x 1 o o|
                |1 1 1 o o|
                |o o o o o|
                |- - - - -|""";
    }

}
