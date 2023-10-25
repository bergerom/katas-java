package katas.java.minesweeper.grid;

import katas.java.minesweeper.CellOutOfBoundException;
import katas.java.minesweeper.IOGridDisplay;
import katas.java.minesweeper.InvalidInputException;
import katas.java.minesweeper.InvalidStateException;

import java.util.Arrays;
import java.util.List;

public class Grid implements IOGridDisplay {
    protected InternalGrid cells; // TODO : make an internal grid class with getCellAt, getPositionFromCell

    private Grid(Builder builder) {
        this.cells = builder.grid.cells;
    }

    public Grid() {
    }

    public static Grid createGrid(Integer nbCells) throws InvalidStateException {
        return createGrid(nbCells, null);
    }

    public static Grid createGrid(Integer nbCells, List<Position> bombCells) throws InvalidStateException {
        Builder builder = new Builder();
        builder.setGridSize(nbCells);
        if (bombCells != null) {
            builder.initFromBombPosition(bombCells);
        }
        builder.initializeCellValues();
        return builder.build();
    }

    // TODO : refactor into InternalGrid class with proper tests !
    public Cell getCellAt(Position position) throws CellOutOfBoundException {
        return cells.getCellAt(position)
                .orElseThrow(() -> {
                    String excMsg = String.format("Cell at position (%s,%s) is outside of grid.",
                            position.row(), position.col());
                    return new CellOutOfBoundException(excMsg);
                });
    }

    @Override
    public String displayGameGrid() throws CellOutOfBoundException {
        StringBuilder result = new StringBuilder();
        int rowLength = this.cells.getRowLength();
        result.append(generateBlankLine(rowLength)).append("\n");

        for (int row = 0; row < rowLength; row++) {
            result.append("|");
            for (int col = 0; col < rowLength; col++) {
                int index = row * rowLength + col;
                Cell cell = getCellAt(cells.getPositionFromIndex(index));
                result.append(cell.toString());
                if (col != rowLength - 1) {
                    result.append(" ");
                }
            }
            result.append("|\n");
        }

        return result
                .append(generateBlankLine(this.cells.getRowLength()))
                .toString();
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

    static class Builder {

        private Grid grid;

        public Builder() {
            grid = new Grid();
        }

        Builder setGridSize(int nbCells) throws InvalidStateException {
            if (squareRootIsWhole(nbCells)) {
                throw new InvalidStateException();
            }
            grid.cells = new InternalGrid(nbCells);
            return this;
        }

        private static boolean squareRootIsWhole(int number) {
            return Math.ceil(Math.sqrt(number)) != Math.sqrt(number);
        }


        Builder initFromBombPosition(List<Position> bombCells) {

            int rowLength = grid.cells.getRowLength();

            for (int row = 0; row < rowLength; row++) {
                for (int col = 0; col < rowLength; col++) {
                    Position position = new Position(col, row);
                    boolean isABomb = bombCells.contains(position);

                    int index = row * rowLength + col;
                    grid.cells.addElement(new Cell(grid.cells.getPositionFromIndex(index), isABomb));

                }
            }
            return this;
        }

        Builder initFromAsciiGrid(String gridInput) throws InvalidInputException {
            // TODO : verify allowed characters for grid first
            List<String> lines = Arrays
                    .stream(gridInput.split("\n")).toList();
            int nbLines = lines.size();
            if (nbLines < 2) {
                throw new InvalidInputException();
            }

            int lineLength = lines.get(0).length();
            allLinesHaveSameLength(lines, lineLength);

            List<CellType> lineCells = lines
                    .subList(1, nbLines)
                    .stream()
                    .flatMapToInt(String::chars)
                    .mapToObj(c -> (char) c)
                    .map(Object::toString)
                    .filter(c -> CellType.fromString(c) != null)
                    .map(CellType::fromString)
                    .toList();

            int nbCellsGridInput = lineCells.size();
            grid.cells = new InternalGrid(nbCellsGridInput);

            for (int index = 0; index < nbCellsGridInput; index++) {
                CellType character = lineCells.get(index);
                switch (character) {
                    case EMPTY:
                        grid.cells.addElement(new Cell(grid.cells.getPositionFromIndex(index), false));
                        break;
                    case BOMB:
                        grid.cells.addElement(new Cell(grid.cells.getPositionFromIndex(index), true));
                        break;
                    default:
                        // pass
                }
            }
            return this;
        }

        private static void allLinesHaveSameLength(List<String> lines, int lineLength) throws InvalidInputException {
            if (lines.stream().anyMatch(l -> l.length() != lineLength))
                throw new InvalidInputException();
        }


        Builder initializeCellValues() {
            for (Cell cell : grid.cells.getBombCells()) {
                for (Cell nextToBomb : grid.cells.getAdjacentCells(cell.getPosition())) {
                    nextToBomb.numberBombsAdj += 1;
                }
            }
            return this;
        }

        Grid build() {
            return new Grid(this);
        }
    }
}
