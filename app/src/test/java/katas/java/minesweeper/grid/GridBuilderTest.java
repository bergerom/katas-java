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
        String gridInput = " |- - - - - -|\n" +
                " |o o o o o o|\n" +
                " |o o o o o o|\n" +
                " |o o x x o o|\n" +
                " |o o o o o o|\n" +
                " |o o o o o x|\n" +
                " |o o o x o x|\n" +
                " |- - - - - -|";

        Grid actualGrid = new Grid.Builder()
                .initFromAsciiGrid(gridInput)
                .initializeCellValues()
                .build();

        String expectedGrid = " |- - - - - -|\n" +
                " |o o o o o o|\n" +
                " |o 1 2 2 1 o|\n" +
                " |o 1 x x 1 o|\n" +
                " |o 1 2 2 2 1|\n" +
                " |o o 1 1 3 x|\n" +
                " |o o 1 x 3 x|\n" +
                " |- - - - - -|";
        Assertions.assertEquals(expectedGrid, actualGrid.displayGameGrid());
    }
}