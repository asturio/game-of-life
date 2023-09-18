package de.lv1871.kata.gameoflife;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    public static Stream<Arguments> evoluteCenterCell() {
        return Stream.of(
                // center dead cell with 3 neighbors should be alive
                Arguments.of(new short[][]{
                        {0, 0, 0},
                        {1, 0, 0},
                        {0, 1, 1}}, 1),
                // center live cell with 2 neighbors should be alive
                Arguments.of(new short[][]{
                        {0, 0, 0},
                        {1, 1, 0},
                        {0, 0, 1}}, 1),
                // center live cell with 3 neighbors should be alive
                Arguments.of(new short[][]{
                        {0, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}}, 1),
                // center live cell with 1 neighbor should be dead
                Arguments.of(new short[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 1}}, 0),
                // center live cell with 4 neighbors should be dead
                Arguments.of(new short[][]{
                        {1, 1, 1},
                        {0, 1, 0},
                        {1, 0, 0}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("evoluteCenterCell")
    @Disabled("Remove this line when you are ready to run this test")
    void evolute_shouldChangeCenterCell(short[][] field, short expected) {
        // given
        GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // when
        gameOfLife.evolute();
        // then
        assertThat(gameOfLife.getField()[1][1]).isEqualTo(expected);
    }

}
