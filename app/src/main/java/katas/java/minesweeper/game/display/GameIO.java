package katas.java.minesweeper.game.display;

import katas.java.minesweeper.game.exceptions.CellOutOfBoundException;
import katas.java.minesweeper.game.grid.Cell;
import katas.java.minesweeper.game.grid.Position;

import java.io.IOException;
import java.util.Set;

public interface GameIO {

    void displayGameGrid(Set<Cell> onlyDisplay) throws CellOutOfBoundException, IOException;

    void displayGameGrid() throws CellOutOfBoundException, IOException;

    Position takeUserInput() throws IOException;

    void displayWinMessage() throws IOException;

    void displayLooseMessage(int score) throws IOException;
}
