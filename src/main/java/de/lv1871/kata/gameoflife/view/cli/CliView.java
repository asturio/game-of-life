package de.lv1871.kata.gameoflife.view.cli;

import de.lv1871.kata.gameoflife.GameOfLife;
import de.lv1871.kata.gameoflife.view.GameOfLifeView;

import java.io.PrintStream;
import java.util.List;

public class CliView implements GameOfLifeView {

    private final GameOfLife gameOfLife;
    private final PrintStream printStream;

    public CliView(GameOfLife gameOfLife, PrintStream printStream) {
        this.gameOfLife = gameOfLife;
        this.printStream = printStream;
    }

    @Override
    public void drawField() {
        List<String> lines = GameOfLifeView.getFieldLines(gameOfLife.getField());
        drawBorder();
        for (String line : lines) {
            printStream.println("|" + line + "|");
        }
        drawBorder();
        drawSeparator();
        delay();
    }

    private void drawBorder() {
        StringBuilder builder = new StringBuilder();
        builder.append("+");
        int cols = gameOfLife.getField()[0].length * 2 - 1;
        builder.append("-".repeat(Math.max(0, cols)));
        builder.append("+");
        printStream.println(builder);
    }

    private void drawSeparator() {
        int cols = gameOfLife.getField()[0].length * 2 + 1;
        printStream.println("=".repeat(cols));
    }

    @Override
    public void playGame() {
        while (gameOfLife.stillRunning()) {
            this.drawField();
            gameOfLife.evolute();
        }
    }

    @Override
    public long getDelayMillis() {
        return 500;
    }
}
