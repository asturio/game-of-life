package de.lv1871.kata.gameoflife;

import de.lv1871.kata.gameoflife.view.GameOfLifeView;
import de.lv1871.kata.gameoflife.view.cli.CliView;
import de.lv1871.kata.gameoflife.view.lanterna.LanternaView;

public class GameOfLifeStarter {
    private static final boolean USE_LANTERNA = false;

    public static void main(String[] args) {
        GameOfLife gameOfLife = new DummyGameOfLife(); // Replace with your implementation
        GameOfLifeView view;
        if (USE_LANTERNA) {
            view = new LanternaView(gameOfLife);
        } else {
            view = new CliView(gameOfLife, System.out);
        }
        view.playGame();
    }
}
