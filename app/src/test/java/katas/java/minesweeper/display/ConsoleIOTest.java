package katas.java.minesweeper.display;

import katas.java.minesweeper.CellOutOfBoundException;
import katas.java.minesweeper.EndOfGameException;
import katas.java.minesweeper.InvalidInputException;
import katas.java.minesweeper.grid.CurrentGrid;
import katas.java.minesweeper.grid.Grid;
import katas.java.minesweeper.grid.GridResources;
import katas.java.minesweeper.grid.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static katas.java.minesweeper.grid.Grid.createGrid;

class ConsoleIOTest {


    @Test
    public void displaySimpleGameGridTest() throws CellOutOfBoundException, InvalidInputException, EndOfGameException, IOException {
        Grid grid = createGrid(GridResources.complexGridTwoNoHints());

        CurrentGrid currentGrid = new CurrentGrid();
        currentGrid = currentGrid.getNewGrid(new Position(4, 4), grid);

        String expectedDisplay = GridResources.complexGridTwoHiddenCells();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ConsoleIO consoleIO = new ConsoleIO(grid, null, outputStream);
        consoleIO.displayGameGrid(currentGrid.getRevealedCells());

        Assertions.assertEquals(expectedDisplay, outputStream.toString());
    }


    @Test
    void takeUserInput() throws IOException {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream("4,4".getBytes(StandardCharsets.UTF_8))) {
            ConsoleIO consoleIO = new ConsoleIO(new Grid(), inputStream, null);
            Assertions.assertEquals(new Position(4, 4), consoleIO.takeUserInput());
        }
    }

}