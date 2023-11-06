package katas.java.minesweeper.display;

import katas.java.minesweeper.CellOutOfBoundException;
import katas.java.minesweeper.grid.CurrentGrid;
import katas.java.minesweeper.grid.Position;

import java.io.IOException;

public interface GameIO {

    // InitGridAndDisplay
    void displayGameGrid(CurrentGrid currentGrid) throws CellOutOfBoundException, IOException;

    // Ask for next move
    Position takeUserInput();

    // Display win message
    void displayWinMessage();

    // Display loose message
    void displayLooseMessage();

}
