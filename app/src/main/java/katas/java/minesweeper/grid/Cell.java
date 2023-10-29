package katas.java.minesweeper.grid;

import java.util.Objects;

public class Cell {
    public Integer row;
    public Integer col;
    protected CellType cellType;

    protected Integer numberBombsAdj;

    public Cell(Position position, boolean isABomb) {

        this.row = position.row();
        this.col = position.col();

        if (isABomb) {
            this.cellType = CellType.BOMB;
        } else {
            this.cellType = CellType.EMPTY;
        }

        this.numberBombsAdj = 0;
    }

    public Boolean isABomb() {
        return CellType.BOMB.equals(cellType);
    }


    public Position getPosition() {
        return new Position(this.row, this.col);
    }

    @Override
    public String toString() {
        if (this.isABomb()) {
            return CellType.BOMB.getRepresentation();
        } else if (this.numberBombsAdj == 0) {
            return CellType.EMPTY.getRepresentation();
        } else {
            return numberBombsAdj.toString();
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Cell) {
            return Objects.equals(((Cell) other).row, this.row)
                    && Objects.equals(((Cell) other).col, this.col)
                    && Objects.equals(((Cell) other).cellType, this.cellType);
        }
        return false;
    }
}
