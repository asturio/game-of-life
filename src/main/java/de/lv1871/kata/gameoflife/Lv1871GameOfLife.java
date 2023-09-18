package de.lv1871.kata.gameoflife;

public class Lv1871GameOfLife implements GameOfLife {

    private final short[][] field;

    public Lv1871GameOfLife(short[][] field) {
        if (field == null) {
            throw new IllegalArgumentException("Field may not be null");
        }
        if (field.length == 0 || field[0].length == 0) {
            throw new IllegalArgumentException("Field must have at least one row and one column");
        }
        this.field = field;

    }

    @Override
    public int getRows() {
        return getField().length;
    }

    @Override
    public int getColumns() {
        return getField()[0].length;
    }

    @Override
    public short[][] getField() {
        return field;
    }

    @Override
    public void evolute() {
        // not implemented

    }

    @Override
    public boolean stillRunning() {
        for (short[] row : field) {
            for (short cell : row) {
                if (cell == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int countLiveNeighbours(int row, int column) {
        if (row < 0 || row >= getRows()) {
            throw new IllegalArgumentException("Row must be between 0 and " + (getRows() - 1));
        }
        if (column < 0 || column >= getColumns()) {
            throw new IllegalArgumentException(
                    "Column must be between 0 and " + (getColumns() - 1));
        }
        int lives = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (isInBounds(i, j) && !(i == row && j == column)) {
                    lives += getField()[i][j];
                }
            }
        }

        return lives;
    }

    private boolean isInBounds(int row, int column) {
        return row >= 0 && row < getRows()
                && column >= 0 && column < getColumns();
    }
}
