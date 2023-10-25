package katas.java.minesweeper.grid;

public enum CellType {
    EMPTY("o"),
    BOMB("x");

    private final String cellAscii;

    CellType(String cellAscii) {
        this.cellAscii = cellAscii;
    }

    public static CellType fromString(String character) {
        for (CellType c : CellType.values()) {
            if (c.cellAscii.equals(character)) {
                return c;
            }
        }
        return null;
    }

    public String getRepresentation() {
        return cellAscii;
    }

}
