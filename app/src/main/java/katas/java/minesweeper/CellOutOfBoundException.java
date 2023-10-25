package katas.java.minesweeper;

import katas.java.minesweeper.grid.Position;

public class CellOutOfBoundException extends Exception{
    public CellOutOfBoundException(String message) {
        super(message);
    }
}
