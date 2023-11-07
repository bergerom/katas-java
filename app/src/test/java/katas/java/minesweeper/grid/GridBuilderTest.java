package katas.java.minesweeper.grid;

import katas.java.minesweeper.game.exceptions.CellOutOfBoundException;
import katas.java.minesweeper.game.exceptions.InvalidInputException;
import katas.java.minesweeper.game.exceptions.InvalidStateException;
import katas.java.minesweeper.game.grid.Grid;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class GridBuilderTest {

    @Test
    public void initFromGridTest() throws InvalidInputException, CellOutOfBoundException, IOException {
        String expectedGrid = "|- -|\n|x o|\n|o x|\n|- -|";

        Grid actualGrid = new Grid.Builder()
                .initFromAsciiGrid(expectedGrid)
                .build();

        GridTestUtils.verifyGridEquals(actualGrid, expectedGrid);
    }

    @Test
    void initializeCellValues() throws InvalidInputException, InvalidStateException, CellOutOfBoundException, IOException {
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

        GridTestUtils.verifyGridEquals(actualGrid, expectedGrid);
    }


}