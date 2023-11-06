package katas.java.minesweeper.display;

import katas.java.minesweeper.CellOutOfBoundException;
import katas.java.minesweeper.grid.Cell;
import katas.java.minesweeper.grid.CurrentGrid;
import katas.java.minesweeper.grid.Grid;
import katas.java.minesweeper.grid.Position;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

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
    public void displayGameGrid(CurrentGrid currentGrid) throws CellOutOfBoundException, IOException {
        List<Cell> onlyDisplay = currentGrid.getRevealedCells();

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
    public Position takeUserInput() {
        Scanner scanner = new Scanner(this.inputStream);

        System.out.println("Please choose the next cell you want to explore (row, col): ");
        while (!scanner.hasNext("[0-9],[0-9]")) {
            System.out.println("Wrong input format.");
        }

        String[] positionInput = scanner.next().split(",");

        return new Position(Integer.parseInt(positionInput[0]),
                Integer.parseInt(positionInput[1]));
    }

    @Override
    public void displayWinMessage() {

    }

    @Override
    public void displayLooseMessage() {

    }
}
