package katas.java.minesweeper.display;

import katas.java.minesweeper.CellOutOfBoundException;
import katas.java.minesweeper.grid.Cell;
import katas.java.minesweeper.grid.Position;

import java.io.IOException;
import java.util.Set;

public interface GameIO {

    void displayGameGrid(Set<Cell> onlyDisplay) throws CellOutOfBoundException, IOException;

    Position takeUserInput() throws IOException;

    void displayWinMessage() throws IOException;

    void displayLooseMessage(int score) throws IOException;
}
