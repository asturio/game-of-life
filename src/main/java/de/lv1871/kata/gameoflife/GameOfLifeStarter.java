package de.lv1871.kata.gameoflife;

import de.lv1871.kata.gameoflife.view.GameOfLifeView;
import de.lv1871.kata.gameoflife.view.lanterna.LanternaView;

public class GameOfLifeStarter {
    public static void main(String[] args) {
        GameOfLife gameOfLife = new DummyGameOfLife(); // Replace with your implementation
        GameOfLifeView view = new LanternaView(gameOfLife); // Or use LanternaView or CliView
        view.playGame();
    }
}
