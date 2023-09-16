package de.lv1871.kata.gameoflife.view.lanterna;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import de.lv1871.kata.gameoflife.GameOfLife;
import de.lv1871.kata.gameoflife.GameOfLifeException;
import de.lv1871.kata.gameoflife.view.GameOfLifeView;

import java.io.IOException;
import java.util.List;

public class LanternaView implements GameOfLifeView {

    private final GameOfLife gameOfLife;
    private final Terminal terminal;
    private long delayMillis = 500;

    public LanternaView(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
        terminal = initializeTerminalForGame();
    }

    private Terminal initializeTerminalForGame() {
        if (gameOfLife == null) {
            throw new GameOfLifeException("GameOfLife must not be null");
        }
        if (gameOfLife.getRows() <= 0 || gameOfLife.getColumns() <= 0) {
            throw new GameOfLifeException("GameOfLife must have at least one row and one column");
        }
        return createTerminal();
    }

    private Terminal createTerminal() {
        TerminalSize size = new TerminalSize(gameOfLife.getColumns() * 2 - 1, gameOfLife.getRows());
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        terminalFactory.setInitialTerminalSize(size);
        Terminal terminal;
        try {
            terminal = terminalFactory.createTerminal();
            terminal.setCursorVisible(false);
            terminal.setForegroundColor(TextColor.ANSI.GREEN);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return terminal;
    }

    @Override
    public void drawField() {
        List<String> fieldLines = GameOfLifeView.getFieldLines(gameOfLife.getField());
        int row = 0;
        try {
            for (String fieldLine : fieldLines) {
                terminal.setCursorPosition(0, row++);
                terminal.putString(fieldLine);
            }
            terminal.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        delay();
    }

    @Override
    public void playGame() {
        try {
            while (gameOfLife.stillRunning()) {
                this.drawField();
                gameOfLife.evolute();
            }
            terminal.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long getDelayMillis() {
        return delayMillis;
    }

    void setDelayMillis(long delayMillis) {
        this.delayMillis = delayMillis;
    }
}
