package katas.java.minesweeper;

import katas.java.minesweeper.grid.CurrentGrid;
import katas.java.minesweeper.grid.Grid;
import katas.java.minesweeper.grid.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static katas.java.minesweeper.grid.Grid.createGrid;
import static org.junit.jupiter.api.Assertions.*;

public class MinesweeperIntegrationTest {
    // TODO : - init cells
    // TODO : - expand blank region
    // TODO : - set cells values
    @Test
    public void veryUnluckyPlayer() throws InvalidStateException {
        Position firstMove = new Position(1, 1);

        List<Position> bombCells = List.of(firstMove, new Position(2, 2));
        Grid grid = createGrid(25, bombCells);
        CurrentGrid currentGrid = new CurrentGrid();

        Exception exception = assertThrows(EndOfGameException.class, () -> {
            currentGrid.getNewGrid(firstMove, grid);
        });

        assertEquals(exception.getMessage(), "You stepped on a mine. End of game, bro !");
    }


}
