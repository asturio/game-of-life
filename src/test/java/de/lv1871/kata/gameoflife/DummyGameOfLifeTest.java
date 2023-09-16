package de.lv1871.kata.gameoflife;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.junit.jupiter.api.Assertions.*;

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
        // Evolute twice
        game.evolute();
        assertThat(game.getField()).isEqualTo(game.shortsField1);

    }

    @Test
    void stillRunning() {
        for (int i = 0; i < 9; i++) {
            assertThat(game.stillRunning()).isTrue();
        }
        assertThat(game.stillRunning()).isFalse();
    }
}
