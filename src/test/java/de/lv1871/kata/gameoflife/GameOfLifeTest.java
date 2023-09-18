package de.lv1871.kata.gameoflife;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameOfLifeTest {

    @SuppressWarnings("DataFlowIssue")
    @Test
    void nullField_shouldThrowIllegalArgumentException() {
        // then
        // Replace the implementation, with your implementation
        assertThatThrownBy(() -> new Lv1871GameOfLife(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Field may not be null");
    }

    @Test
    void emptyField_shouldThrowIllegalArgumentException() {
        // then
        // Replace the implementation, with your implementation
        assertThatThrownBy(() -> new Lv1871GameOfLife(new short[0][0]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Field must have at least one row and one column");
    }

    @Test
    void oneSimpleDeadCell_shouldInitializeCorrectly() {
        // given
        short[][] field = new short[][]{{0}};
        GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // then
        assertThat(gameOfLife.getField()).isEqualTo(field);
        assertThat(gameOfLife.getRows()).isEqualTo(1);
        assertThat(gameOfLife.getColumns()).isEqualTo(1);
    }

    // Test that stillRunning is false if there is no life
    @Test
    void stillRunning_shouldReturnFalseIfNoLife() {
        // given
        short[][] field = new short[][]{{0}};
        GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // then
        assertThat(gameOfLife.stillRunning()).isEqualTo(false);
    }

   @Test
   void stillRunning_shouldReturnTrueIfLife() {
       // given
       short[][] field = new short[][]{{1}};
       GameOfLife gameOfLife = new Lv1871GameOfLife(field);
       // then
       assertThat(gameOfLife.stillRunning()).isEqualTo(true);
   }

}
