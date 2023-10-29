package katas.java.minesweeper;

import katas.java.minesweeper.grid.Cell;
import katas.java.minesweeper.grid.Grid;
import katas.java.minesweeper.grid.GridResources;
import katas.java.minesweeper.grid.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static katas.java.minesweeper.grid.Grid.createGrid;


public class GridTest {
    @Test
    public void gridMustBeSquare() {
        try {
            Grid squareGrid = createGrid(25, new ArrayList<>());
        } catch (InvalidInputException e) {
            // Should not arrive here
            throw new RuntimeException(e);
        }

        Assertions.assertThrows(InvalidStateException.class, () -> {
            createGrid(54, new ArrayList<>());
        });
    }

    @Test
    public void getCellAtTest() throws CellOutOfBoundException, InvalidInputException {
        Grid grid = createGrid(25, new ArrayList<>());
        Cell cell_0_0 = grid.getCellAt(new Position(0, 0));
        Assertions.assertEquals(0, cell_0_0.col);
        Assertions.assertEquals(0, cell_0_0.row);


        Cell cell_1_2 = grid.getCellAt(new Position(1, 2));
        Assertions.assertEquals(1, cell_1_2.row);
        Assertions.assertEquals(2, cell_1_2.col);

        Cell cell_2_1 = grid.getCellAt(new Position(2, 1));
        Assertions.assertEquals(2, cell_2_1.row);
        Assertions.assertEquals(1, cell_2_1.col);

        Cell cell_4_4 = grid.getCellAt(new Position(4, 4));
        Assertions.assertEquals(4, cell_4_4.row);
        Assertions.assertEquals(4, cell_4_4.col);

        Assertions.assertThrows(CellOutOfBoundException.class, () -> {
            Cell cell_out_of_bound = grid.getCellAt(new Position(6, 6));
        });

    }

    @Test
    public void gridContainsOnlyAllowedCharacters() {

        Assertions.assertThrows(InvalidInputException.class, () -> {
            createGrid(GridResources.invalidCharacterGrid().replaceAll("[0-9]", "o"));
        });
    }

    @Test
    public void initComplexGameGridTest() throws CellOutOfBoundException, InvalidInputException {

        String gridAfterInit = GridResources.complexGridOne();
        String gridBeforeInit = gridAfterInit.replaceAll("[0-9]", "o");
        Grid grid = createGrid(gridBeforeInit);

        Assertions.assertEquals(gridAfterInit, grid.displayGameGrid());
    }
}
