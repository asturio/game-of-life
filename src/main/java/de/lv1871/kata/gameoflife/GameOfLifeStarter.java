package de.lv1871.kata.gameoflife;

import de.lv1871.kata.gameoflife.view.GameOfLifeView;
import de.lv1871.kata.gameoflife.view.cli.CliView;
import de.lv1871.kata.gameoflife.view.lanterna.LanternaView;

public class GameOfLifeStarter {

    private static final boolean USE_LANTERNA = true;

    public static void main(String[] args) {
        short[][] field = generateField(args);
        // Replace with your implementation
        GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        GameOfLifeView view = USE_LANTERNA ? new LanternaView(gameOfLife)
                : new CliView(gameOfLife, System.out);
        view.playGame();
    }

    static short[][] generateField(String... args) {
        int rows = 20;
        int columns = 40;
        if (args != null && args.length == 2) {
            rows = Integer.parseInt(args[0]);
            columns = Integer.parseInt(args[1]);
        }
        return GameOfLife.generateRandomField(rows, columns);
    }

}
