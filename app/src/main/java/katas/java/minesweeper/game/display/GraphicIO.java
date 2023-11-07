package katas.java.minesweeper.game.display;

import katas.java.minesweeper.game.exceptions.CellOutOfBoundException;
import katas.java.minesweeper.game.grid.Cell;
import katas.java.minesweeper.game.grid.Position;

import java.io.IOException;
import java.util.Set;

public class GraphicIO implements GameIO{
    @Override
    public void displayGameGrid(Set<Cell> onlyDisplay) throws CellOutOfBoundException, IOException {

    }

    @Override
    public void displayGameGrid() throws CellOutOfBoundException, IOException {

    }

    @Override
    public Position takeUserInput() throws IOException {
        return null;
    }

    @Override
    public void displayWinMessage() throws IOException {

    }

    @Override
    public void displayLooseMessage(int score) throws IOException {

    }
}
