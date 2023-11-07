package katas.java.minesweeper;

import katas.java.minesweeper.game.display.ConsoleIO;
import katas.java.minesweeper.game.display.GameIO;
import katas.java.minesweeper.game.display.GraphicIO;
import katas.java.minesweeper.game.exceptions.CellOutOfBoundException;
import katas.java.minesweeper.game.Game;
import katas.java.minesweeper.game.exceptions.InvalidInputException;
import katas.java.minesweeper.game.grid.Grid;
import org.apache.commons.cli.*;

import java.io.IOException;

import static katas.java.minesweeper.game.grid.Grid.createRandomGrid;

public class Minesweeper {

    public static void main(String[] args) throws InvalidInputException, CellOutOfBoundException, IOException {

        Options options = new Options();
        options.addOption("g", "graphic", false, "Enable graphical interface");
        CommandLineParser parser = new DefaultParser();
        boolean isGraphic = false;
        try {
            CommandLine cmd = parser.parse(options, args);
            isGraphic = cmd.hasOption("graphic");

        } catch (ParseException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }

        Grid grid = createRandomGrid();
        GameIO gameIO = getIOInterface(isGraphic, grid);
        Game game = new Game(grid, gameIO);
        game.gameLoop();
    }

    private static GameIO getIOInterface(boolean isGraphic, Grid grid) {
        if (isGraphic) {
            return new GraphicIO(grid);
        }
        return new ConsoleIO(grid, System.in, System.out);
    }
}
