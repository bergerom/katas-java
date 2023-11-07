package katas.java.minesweeper.game.exceptions;

public class CellOutOfBoundException extends Exception{
    public CellOutOfBoundException(String message) {
        super(message);
    }
}
