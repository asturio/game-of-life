package de.lv1871.kata.gameoflife;

public class DummyGameOfLife implements GameOfLife {
    public static final int MAX_GENERATIONS = 10;
    final short[][] shortsField1 = {
        {1, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0},
        {0, 1, 0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 0},
        {0, 1, 0, 0, 0, 0, 0},
    };
    final short[][] shortsField2 = {
        {1, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 1, 1, 0, 0},
        {0, 0, 0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 0, 0},
        {0, 0, 1, 0, 0, 0, 0},
    };

    private short[][] currentField = shortsField1;
    private int generations = 0;

    @Override
    public int getRows() {
        return currentField.length;
    }

    @Override
    public int getColumns() {
        return currentField[0].length;
    }

    @Override
    public short[][] getField() {
        return currentField;
    }

    @Override
    public void evolute() {
        if (currentField == shortsField1) {
            currentField = shortsField2;
        } else {
            currentField = shortsField1;
        }
    }

    @Override
    public boolean stillRunning() {
        generations++;
        return generations < MAX_GENERATIONS;
    }
}
