package de.lv1871.kata.gameoflife;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameOfLifeTest {


    public static Stream<Arguments> evoluteCenterCell() {
        short DEAD = 0;
        short ALIVE = 1;
        return Stream.of(
                // 1. Any live cell with fewer than two live neighbours dies,
                // as if by underpopulation.
                of(new short[][]{
                        {0, 0, 0},
                        {0, ALIVE, 0},
                        {0, 0, 1}}, DEAD),
                // 2. Any live cell with two or three live neighbours lives
                // on to the next generation.
                of(new short[][]{// (2a) live cell with 2 neighbors stays alive
                        {0, 0, 0},
                        {1, ALIVE, 0},
                        {0, 0, 1}}, ALIVE),
                of(new short[][]{// (2b) live cell with 3 neighbors stays alive
                        {0, 1, 0},
                        {1, ALIVE, 0},
                        {0, 0, 1}}, ALIVE),
                // 3. Any live cell with more than three live neighbours dies, as if by overpopulation.
                of(new short[][]{
                        {1, 1, 1},
                        {0, ALIVE, 0},
                        {1, 0, 0}}, DEAD),
                // 4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
                of(new short[][]{
                        {0, 0, 0},
                        {1, DEAD, 0},
                        {0, 1, 1}}, ALIVE));
    }


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

    @ParameterizedTest
    @MethodSource("evoluteCenterCell")
    void evolute_shouldChangeCenterCell(short[][] field, short expected) {
        // given
        GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // when
        gameOfLife.evolute();
        // then
        assertThat(gameOfLife.getField()[1][1]).isEqualTo(expected);
    }

}
