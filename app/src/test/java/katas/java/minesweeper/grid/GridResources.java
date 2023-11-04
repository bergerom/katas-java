package katas.java.minesweeper.grid;

public class GridResources {

    public static String invalidCharacterGrid() {
        return """
                |- -|
                |* 2|
                |2 *|
                |- -|""";
    }

    public static String complexGridOneRevealed() {
        return """
                |- - - - -|
                |1 2 2 1 o|
                |1 x x 1 o|
                |1 2 2 2 1|
                |o 1 1 3 x|
                |o 1 x 3 x|
                |- - - - -|""";
    }

    public static String complexGridOneHidden() {
        return complexGridOneRevealed().replaceAll("[0-9]", "o");
    }

    public static String complexGridTwoReavealed() {
        return """
                |- - - - -|
                |o 1 x 1 o|
                |1 2 2 1 o|
                |1 x 1 o o|
                |1 1 1 o o|
                |o o o o o|
                |- - - - -|""";
    }

    public static String complexGridTwoHidden() {
        return complexGridTwoReavealed().replaceAll("[0-9]", "o");
    }

}
