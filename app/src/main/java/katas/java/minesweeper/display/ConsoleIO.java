package katas.java.minesweeper.display;

import katas.java.minesweeper.CellOutOfBoundException;
import katas.java.minesweeper.grid.Cell;
import katas.java.minesweeper.grid.Grid;
import katas.java.minesweeper.grid.Position;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;

public class ConsoleIO implements GameIO {

    private final Grid grid;

    private final InputStream inputStream;
    private final OutputStream outputStream;

    public ConsoleIO(Grid grid, InputStream inputStream, OutputStream outputStream) {
        this.grid = grid;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public void displayGameGrid(Set<Cell> onlyDisplay) throws CellOutOfBoundException, IOException {

        StringBuilder result = new StringBuilder();
        int rowLength = this.grid.getRowLength(); // We assume the grid is square
        result.append(generateBlankLine(rowLength)).append("\n");

        for (int row = 0; row < rowLength; row++) {
            result.append("|");
            for (int col = 0; col < rowLength; col++) {
                int index = row * rowLength + col;
                Cell cell = grid.getCellAt(grid.getPositionFromIndex(index));
                result.append(onlyDisplay.contains(cell) ? cell.toString() : "?");
                if (col != rowLength - 1) {
                    result.append(" ");
                }
            }
            result.append("|\n");
        }

        String gameGrid = result
                .append(generateBlankLine(rowLength))
                .toString();

        this.outputStream.write(gameGrid.getBytes(StandardCharsets.UTF_8));
    }

    private String generateBlankLine(int length) {
        StringBuilder blankLine = new StringBuilder("|");
        for (int i = 0; i < length; i++) {
            blankLine.append("-");
            if (i != length - 1)
                blankLine.append(" ");
        }
        blankLine.append("|");
        return blankLine.toString();
    }

    @Override
    public Position takeUserInput() throws IOException {
        Scanner scanner = new Scanner(this.inputStream);

        writeToOutputStream("\nPlease choose the next cell you want to explore (row, col):\n");
        while (!scanner.hasNext("[0-9],[0-9]")) {
            writeToOutputStream("Wrong input format.\n");
            writeToOutputStream("Please choose the next cell you want to explore (row, col):\n");
            scanner.nextLine();
        }

        String[] positionInput = scanner.next().split(",");

        return new Position(Integer.parseInt(positionInput[0]),
                Integer.parseInt(positionInput[1]));
    }

    @Override
    public void displayWinMessage() throws IOException {
        writeToOutputStream("Bravo, you win !!\n");
    }

    @Override
    public void displayLooseMessage(int score) throws IOException {
        String msg = String.format("\nYou stepped on a bomb, end of game. Score : %s\n", score);
        writeToOutputStream(msg);
    }

    public void displayIncorrectPositionMessage(Position position) throws IOException {
        String errMsg = String.format("Position (%s,%s) is outside the grid.\n",
                position.row(), position.col());
        writeToOutputStream(errMsg);
    }

    private void writeToOutputStream(String message) throws IOException {
        this.outputStream.write(message.getBytes(StandardCharsets.UTF_8));
    }
}
