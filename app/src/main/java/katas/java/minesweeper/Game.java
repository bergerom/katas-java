package katas.java.minesweeper;

import katas.java.minesweeper.display.ConsoleIO;
import katas.java.minesweeper.grid.CurrentGrid;
import katas.java.minesweeper.grid.Grid;
import katas.java.minesweeper.grid.Position;

import java.io.IOException;

public class Game {
    Grid grid; // Immutable starting grid

    CurrentGrid gameGrid; // The grid representing the state of the game, one grid is generated each turn


    public Game(Grid grid) {
        this.grid = grid;
        this.gameGrid = new CurrentGrid();
    }

    public void gameLoop() throws CellOutOfBoundException, IOException {

        // InitGridAndDisplay
        ConsoleIO consoleIO = new ConsoleIO(grid, System.in, System.out);
        consoleIO.displayGameGrid(gameGrid);

        while (gameGrid.getRevealedCells().size() + grid.getNbBombs() != grid.getNbCells()) {
            // Ask for next move
            Position position = consoleIO.takeUserInput();
            try {
                gameGrid = gameGrid.getNewGrid(position, grid);
            } catch (EndOfGameException e) {
                System.out.println("-------- You stepped on a mine, end of game ! --------");
                consoleIO.displayLooseMessage();
            }
            consoleIO.displayGameGrid(gameGrid);
        }
        System.out.println("Bravo, you win !!");
        consoleIO.displayGameGrid(gameGrid); // TODO : display full grid
    }


}
