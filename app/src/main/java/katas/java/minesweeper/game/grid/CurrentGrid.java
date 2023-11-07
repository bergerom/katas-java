package katas.java.minesweeper.game.grid;

import katas.java.minesweeper.game.exceptions.CellOutOfBoundException;
import katas.java.minesweeper.game.exceptions.EndOfGameException;

import java.util.*;

public class CurrentGrid {

    private final Set<Cell> revealed;

    public CurrentGrid() {
        this.revealed = Collections.emptySet();
    }

    public CurrentGrid(Set<Cell> revealed) {
        this.revealed = revealed;
    }

    public CurrentGrid getNewGrid(Position clickedOnCell, Grid grid) throws EndOfGameException, CellOutOfBoundException {
        Cell cell = grid.getCellAt(clickedOnCell);

        if (revealed.contains(cell)) {
            return this;
        }

        if (cell.isABomb()) {
            throw new EndOfGameException("You stepped on a mine. End of game, bro !");
        }

        Set<Cell> nextTurnRevealed = revealNewCells(cell, grid);
        nextTurnRevealed.addAll(revealed);
        return new CurrentGrid(nextTurnRevealed);
    }

    private Set<Cell> revealNewCells(Cell clickedOnCell, Grid grid) {
        Set<Cell> revealed = new HashSet<>();
        revealNewCells(clickedOnCell, revealed, grid);
        return revealed;
    }

    private void revealNewCells(Cell cellToCheck, Set<Cell> revealed, Grid grid) {
        //System.out.println(cellToCheck.toString() + "(" + cellToCheck.row + ", " + cellToCheck.col + ")");
        if (cellToCheck.isABomb()) {
            return;
        } else if (cellToCheck.numberBombsAdj > 0) {
            revealed.add(cellToCheck);
            return;
        } else {
            revealed.add(cellToCheck);
        }


        for (MoveDirection moveDirection : MoveDirection.values()) {
            //System.out.println(" ---> " + moveDirection.name());
            grid.cells.getAdjacentCell(cellToCheck, moveDirection)
                    .ifPresent(cell -> {
                        if (!revealed.contains(cell)) {
                            revealNewCells(cell, revealed, grid);
                        }
                    });
        }
    }

    public Set<Cell> getRevealedCells() {
        return this.revealed;
    }
}
