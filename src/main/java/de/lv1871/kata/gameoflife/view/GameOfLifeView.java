package de.lv1871.kata.gameoflife.view;

import java.util.ArrayList;
import java.util.List;

public interface GameOfLifeView {

    @SuppressWarnings("UnnecessaryUnicodeEscape")
    String LIVE = "\u25a0"; // "■"
    String DEAD = " ";

    static List<String> getFieldLines(short[][] shortsField) {
        List<String> result = new ArrayList<>();
        if (shortsField == null) {
            return result;
        }
        for (short[] row : shortsField) {
            StringBuilder line = new StringBuilder();
            for (short cell : row) {
                if (!line.isEmpty()) {
                    line.append(" ");
                }
                line.append(cell != 0 ? LIVE : DEAD);
            }
            result.add(line.toString());
        }
        return result;
    }

    default void delay() {
        try {
            Thread.sleep(getDelayMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void drawField();

    void playGame();

    long getDelayMillis();
}
