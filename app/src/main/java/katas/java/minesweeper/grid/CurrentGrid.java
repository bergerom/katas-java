package katas.java.minesweeper.grid;

import katas.java.minesweeper.CellOutOfBoundException;
import katas.java.minesweeper.EndOfGameException;

import java.util.ArrayList;
import java.util.List;

public class CurrentGrid {
    List<Cell> revealed = new ArrayList<>();

    public CurrentGrid getNewGrid(Position clickedOnCell, Grid grid) throws EndOfGameException, CellOutOfBoundException {
        Cell cell = grid.getCellAt(clickedOnCell);
        if (cell.isABomb()) {
            throw new EndOfGameException("You stepped on a mine. End of game, bro !");
        }
        return null;
    }

    private ArrayList<Cell> revealNewCells(Cell clickedOnCell) {
        return null;
    }
}
