package katas.java.minesweeper;

import katas.java.minesweeper.grid.Grid;
import katas.java.minesweeper.grid.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static katas.java.minesweeper.grid.Grid.createGrid;

public class GridIOTest {
    @Test
    public void displaySimpleGameGridTest() throws CellOutOfBoundException, InvalidInputException {
        List<Position> bombs = List.of(new Position(0, 0), new Position(1, 1));
        Grid grid = createGrid(4, bombs);
        String expectedDisplay = "|- -|\n|x 2|\n|2 x|\n|- -|";
        Assertions.assertEquals(expectedDisplay, grid.displayGameGrid());
    }

    @Test
    public void randomGridInputInitAndDisplayTest() throws CellOutOfBoundException, InvalidInputException {
        // TODO : this test is useless, but the random part should be used for generating a random grid
        Random random = new Random();
        int rowLength = random.nextInt(3,10);
        int nbCells = rowLength * rowLength;

        int nbBombs = random.nextInt(rowLength);
        Set<Position> bombs = new HashSet<>();
        while (bombs.size() < nbBombs) {
            int row = random.nextInt(rowLength);
            int col = random.nextInt(rowLength);
            bombs.add(new Position(row, col));
        }

        Grid grid = createGrid(nbCells, bombs.stream().toList());
        String expectedDisplay = grid.displayGameGrid();
        System.out.println(expectedDisplay);
        //Assertions.assertEquals(expectedDisplay, grid.displayGameGrid());
    }
}
