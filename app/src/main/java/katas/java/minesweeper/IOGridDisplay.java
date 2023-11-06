package katas.java.minesweeper;

import katas.java.minesweeper.grid.Cell;

import java.util.List;

public interface IOGridDisplay {
    String displayGameGrid() throws CellOutOfBoundException;

    String displayGameGrid(List<Cell> onlyDisplay) throws CellOutOfBoundException;
}
