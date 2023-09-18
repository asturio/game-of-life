package de.lv1871.kata.gameoflife;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameOfLifeTest {
    @Test
    void nullField_shouldThrowIllegalArgumentException() {
        // given
        short[][] field = null;
        // then
        // Replace the implementation, with your implementation
        assertThatThrownBy(() -> new Lv1871GameOfLife(field))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Field may not be null");
    }

    @Test
    void emptyField_shouldThrowIllegalArgumentException() {
        // given
        short[][] field = new short[0][0];
        // then
        // Replace the implementation, with your implementation
        assertThatThrownBy(() -> new Lv1871GameOfLife(field))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Field must have at least one row and one column");
    }


}
