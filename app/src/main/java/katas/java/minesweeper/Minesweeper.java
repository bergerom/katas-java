package katas.java.minesweeper;

import katas.java.minesweeper.grid.Grid;

import java.io.IOException;

import static katas.java.minesweeper.grid.Grid.createRandomGrid;

public class Minesweeper {

    public static void main(String[] args) throws InvalidInputException, CellOutOfBoundException, IOException {
        Grid grid = createRandomGrid();
        Game game = new Game(grid);
        game.gameLoop();
    }
}
