package de.lv1871.kata.gameoflife;

public interface GameOfLife {
    int getRows();
    int getColumns();

    // TODO: Use a more appropriate data type
    short[][] getField();

    void evolute();

    boolean stillRunning();
}
