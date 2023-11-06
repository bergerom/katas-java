package katas.java.minesweeper;

import katas.java.minesweeper.display.ConsoleIO;
import katas.java.minesweeper.grid.CurrentGrid;
import katas.java.minesweeper.grid.Grid;
import katas.java.minesweeper.grid.Position;

import java.io.IOException;
import java.util.HashSet;

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
        consoleIO.displayGameGrid(gameGrid.getRevealedCells());

        // Game loop
        while (gameGrid.getRevealedCells().size() + grid.getNbBombs() != grid.getNbCells()) {
            // Ask for next move
            Position position = getNextMove(consoleIO);

            try {
                // Apply next move
                gameGrid = gameGrid.getNewGrid(position, grid);
                consoleIO.displayGameGrid(gameGrid.getRevealedCells());
            } catch (EndOfGameException e) {
                // Game lost
                consoleIO.displayGameGrid(new HashSet<>(grid.getCells()));
                consoleIO.displayLooseMessage(gameGrid.getRevealedCells().size());
                return;
            }
        }

        // Win
        consoleIO.displayWinMessage();
    }

    private Position getNextMove(ConsoleIO consoleIO) throws IOException {
        Position position = null;
        boolean positionWithinBounds = true;

        do {
            // Ask for next move
            position = consoleIO.takeUserInput();
            try {
                grid.getCellAt(position);
            } catch (CellOutOfBoundException cob) {
                consoleIO.displayIncorrectPositionMessage(position);
                positionWithinBounds = false;
            }
        } while (!positionWithinBounds);

        return position;
    }


}
