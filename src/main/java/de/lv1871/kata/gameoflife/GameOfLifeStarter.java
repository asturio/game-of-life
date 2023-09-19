package de.lv1871.kata.gameoflife;

import de.lv1871.kata.gameoflife.view.GameOfLifeView;
import de.lv1871.kata.gameoflife.view.cli.CliView;
import de.lv1871.kata.gameoflife.view.lanterna.LanternaView;
import java.util.Random;

public class GameOfLifeStarter {

    private static final boolean USE_LANTERNA = true;

    public static void main(String[] args) {
        short[][] field = generateField(args);
        GameOfLife gameOfLife = new Lv1871GameOfLife(field); // Replace with your implementation
        GameOfLifeView view;
        if (USE_LANTERNA) {
            view = new LanternaView(gameOfLife);
        } else {
            view = new CliView(gameOfLife, System.out);
        }
        view.playGame();
    }

    private static short[][] generateField(String[] args) {
        int rows = 20;
        int columns = 40;
        if (args != null && args.length == 2) {
            rows = Integer.parseInt(args[0]);
            columns = Integer.parseInt(args[1]);
        }
        short[][] field;
        if (rows > 0 && columns > 0) {
            field = new short[rows][columns];
        } else {
            field = new short[20][40];
        }
        Random random = new Random(System.nanoTime());

        for (int row = 0; row < field.length; row++) {
            for (int column = 0; column < field[0].length; column++) {
                field[row][column] = (short) (random.nextInt(10) > 7 ? 1 : 0);
            }
        }

        return field;

    }
}
