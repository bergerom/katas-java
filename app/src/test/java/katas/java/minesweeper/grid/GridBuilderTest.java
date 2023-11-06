package katas.java.minesweeper.grid;

import katas.java.minesweeper.CellOutOfBoundException;
import katas.java.minesweeper.InvalidInputException;
import katas.java.minesweeper.InvalidStateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static katas.java.minesweeper.grid.Grid.createGrid;

class GridBuilderTest {

    @Test
    public void initFromGridTest() throws InvalidInputException, InvalidStateException, CellOutOfBoundException {
        String gridStr = "|- -|\n|x o|\n|o x|\n|- -|";

        Grid grid = new Grid.Builder()
                .initFromAsciiGrid(gridStr)
                .build();

        Assertions.assertEquals(gridStr, grid.displayGameGrid());
    }

    @Test
    void initializeCellValues() throws InvalidInputException, InvalidStateException, CellOutOfBoundException {
        String gridInput = """
                 |- - - - - -|
                 |o o o o o o|
                 |o o o o o o|
                 |o o x x o o|
                 |o o o o o o|
                 |o o o o o x|
                 |o o o x o x|
                 |- - - - - -|\
                """;

        Grid actualGrid = new Grid.Builder()
                .initFromAsciiGrid(gridInput)
                .initializeCellValues()
                .build();

        String expectedGrid = """
                 |- - - - - -|
                 |o o o o o o|
                 |o 1 2 2 1 o|
                 |o 1 x x 1 o|
                 |o 1 2 2 2 1|
                 |o o 1 1 3 x|
                 |o o 1 x 3 x|
                 |- - - - - -|""";
        Assertions.assertEquals(expectedGrid.trim(), actualGrid.displayGameGrid().trim());
    }
}