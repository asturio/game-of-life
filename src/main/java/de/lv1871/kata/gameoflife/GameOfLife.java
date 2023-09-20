package de.lv1871.kata.gameoflife;

import java.util.Random;

public interface GameOfLife {

    static short[][] generateRandomField(int rows, int columns) {
        rows = (rows <= 0) ? 20 : rows;
        columns = (columns <= 0) ? 40 : columns;
        short[][] field = new short[rows][columns];
        Random random = new Random(System.nanoTime());
        for (int row = 0; row < field.length; row++) {
            for (int column = 0; column < field[0].length; column++) {
                field[row][column] = (short) (random.nextInt(10) > 7 ? 1 : 0);
            }
        }
        return field;
    }

    int getRows();

    int getColumns();

    // TODO: Use a more appropriate data type
    short[][] getField();

    void evolute();

    boolean stillRunning();

    long getGeneration();

    default double getLifePercentage() {
        return 0;
    }
}
