package katas.java.minesweeper.game.display;

import katas.java.minesweeper.game.exceptions.CellOutOfBoundException;
import katas.java.minesweeper.game.grid.Cell;
import katas.java.minesweeper.game.grid.Grid;
import katas.java.minesweeper.game.grid.Position;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GraphicIO implements GameIO {

    private final Grid grid;
    private Frame frame;

    private HashMap<Cell, Button> positionCells = new HashMap<>();

    private Position lastPositionClicked;

    public GraphicIO(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void displayGameGrid(Set<Cell> onlyDisplay) throws CellOutOfBoundException, IOException {
        if (positionCells.isEmpty()) {
            initGraphicGrid();
        } else {
            updateGraphicGrid(onlyDisplay);
        }
    }

    private void initGraphicGrid() throws CellOutOfBoundException {
        int nbRows = grid.getRowLength();
        int nbCells = grid.getNbCells();

        frame = new Frame();
        frame.setTitle("Minesweeper");
        frame.setSize(300, 300);

        frame.setLayout(new GridLayout(grid.getRowLength(), grid.getRowLength()));
        for (int i = 0; i < nbCells; i++) {
            Cell cell = grid.getCellFromIndex(i);

            Button button = new Button();
            button.setLabel("?");
            button.setActionCommand(getPositionStr(cell.getPosition()));
            button.addActionListener(new ButtonClickListener());

            frame.add(button);
            positionCells.put(cell, button);
        }
        frame.pack();
        frame.setVisible(true);
    }

    private void updateGraphicGrid(Set<Cell> onlyDisplay) {
        positionCells.forEach((cell, btn) -> {
            if (onlyDisplay.contains(cell)) {
                btn.setLabel(cell.toString());
                btn.setFont(new Font("Dialog", Font.BOLD, 20));
            }
        });
    }

    public static String getPositionStr(Position position) {
        return position.row() + "," + position.col();
    }

    public static Position parsePositionStr(String str) {
        return new Position(Integer.parseInt(str.substring(0, 1)),
                Integer.parseInt(str.substring(2, 3)));
    }

    @Override
    public void displayGameGrid() throws CellOutOfBoundException, IOException {
        HashSet<Cell> allCells = new HashSet<>(this.grid.getCells());
        displayGameGrid(allCells);
    }

    @Override
    public Position takeUserInput() throws IOException {
        while (lastPositionClicked == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Position position = lastPositionClicked;
        lastPositionClicked = null;
        return position;
    }

    @Override
    public void displayWinMessage() throws IOException {

    }

    @Override
    public void displayLooseMessage(int score) throws IOException {

    }

    @Override
    public void displayIncorrectPositionMessage(Position position) throws IOException {

    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            lastPositionClicked = parsePositionStr(command);
        }
    }
}
