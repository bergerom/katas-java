package katas.java.minesweeper.grid;

import katas.java.minesweeper.CellOutOfBoundException;
import katas.java.minesweeper.EndOfGameException;

import java.util.*;

public class CurrentGrid {

    private final List<Cell> revealed;

    public CurrentGrid() {
        this.revealed = Collections.emptyList();
    }

    public CurrentGrid(List<Cell> revealed) {
        this.revealed = revealed;
    }

    public CurrentGrid getNewGrid(Position clickedOnCell, Grid grid) throws EndOfGameException, CellOutOfBoundException {
        Cell cell = grid.getCellAt(clickedOnCell);
        if (cell.isABomb()) {
            throw new EndOfGameException("You stepped on a mine. End of game, bro !");
        }

        List<Cell> revealed = revealNewCells(cell, grid);

        return new CurrentGrid(revealed);
    }

    private List<Cell> revealNewCells(Cell clickedOnCell, Grid grid) {
        List<Cell> revealed = new ArrayList<>();
        revealNewCells(clickedOnCell, revealed, grid);
        return revealed;
    }

    private void revealNewCells(Cell cellToCheck, List<Cell> revealed, Grid grid) {
        System.out.println(cellToCheck.toString() + "(" + cellToCheck.row + ", " + cellToCheck.col + ")");
        if (cellToCheck.isABomb()) {
            return;
        } else if (cellToCheck.numberBombsAdj > 0) {
            revealed.add(cellToCheck);
            return;
        } else {
            revealed.add(cellToCheck);
        }


        for (MoveDirection moveDirection : MoveDirection.values()) {
            System.out.println(" ---> " + moveDirection.name());
            grid.getAdjacentCell(cellToCheck, moveDirection)
                    .ifPresent(cell -> {
                        if (!revealed.contains(cell)) {
                            revealNewCells(cell, revealed, grid);
                        }
                    });
        }
    }

    public List<Cell> getRevealedCells() {
        return this.revealed;
    }
}
