package de.lv1871.kata.gameoflife;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DummyGameOfLifeTest {

    private DummyGameOfLife game;

    @BeforeEach
    void setUp() {
        game = new DummyGameOfLife();
    }

    @Test
    void getRows() {
        assertThat(game.getRows()).isEqualTo(7);
    }

    @Test
    void getColumns() {
        assertThat(game.getColumns()).isEqualTo(7);
    }

    @Test
    void getField() {
        assertThat(game.getField()).isEqualTo(game.shortsField1);
    }

    @Test
    void evolute() {
        assumeThat(game.getField()).isEqualTo(game.shortsField1);
        // Evolute once
        game.evolute();
        assertThat(game.getField()).isEqualTo(game.shortsField2);
        assertThat(game.getGeneration()).isEqualTo(1);
        // Evolute twice
        game.evolute();
        assertThat(game.getField()).isEqualTo(game.shortsField1);
        assertThat(game.getGeneration()).isEqualTo(2);
    }

    @Test
    void stillRunning() {
        for (int i = 0; i < 9; i++) {
            game.evolute();
            assertThat(game.stillRunning()).as("i = " + i).isTrue();
            assertThat(game.getGeneration()).isEqualTo(i + 1);
        }
        game.evolute();
        assertThat(game.stillRunning()).isFalse();
        assertThat(game.getGeneration()).isEqualTo(10);
    }

    @Test
    void getLifePercentage() {
        assertThat(game.getLifePercentage()).isEqualTo(0);
    }
}
