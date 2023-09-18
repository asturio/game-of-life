package de.lv1871.kata.gameoflife;

public class Lv1871GameOfLife implements GameOfLife {
    public Lv1871GameOfLife(short[][] field) {
        if (field == null) {
            throw new IllegalArgumentException("Field may not be null");
        }
        if (field.length == 0 || field[0].length == 0) {
            throw new IllegalArgumentException("Field must have at least one row and one column");
        }

    }

    @Override
    public int getRows() {
        return 0;
    }

    @Override
    public int getColumns() {
        return 0;
    }

    @Override
    public short[][] getField() {
        return new short[0][];
    }

    @Override
    public void evolute() {
        // not implemented

    }

    @Override
    public boolean stillRunning() {
        return false;
    }
}
