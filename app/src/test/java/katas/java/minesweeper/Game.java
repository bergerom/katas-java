package katas.java.minesweeper;

import katas.java.minesweeper.grid.CurrentGrid;
import katas.java.minesweeper.grid.Grid;
import katas.java.minesweeper.grid.Position;

public class Game {
    Grid grid; // Immutable starting grid

    CurrentGrid gameGrid; // The grid representing the state of the game, one grid is generated each turn

    public Game(Grid grid) {
        this.grid = grid;
        this.gameGrid = new CurrentGrid();
    }

    public void initGame() throws CellOutOfBoundException {
        System.out.println(grid.displayGameGrid());
        System.out.println("Please choose the next cell you want to explore (row, col): ");
    }

    public void nextMove(Position position) throws EndOfGameException, CellOutOfBoundException {
        gameGrid = gameGrid.getNewGrid(position, this.grid);
    }
}
