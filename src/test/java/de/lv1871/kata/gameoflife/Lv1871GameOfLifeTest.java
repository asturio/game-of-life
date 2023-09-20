package de.lv1871.kata.gameoflife;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class Lv1871GameOfLifeTest {

    @Test
    void countNeighbours_shouldReturnZeroForEmptyField() {
        // given
        short[][] field = new short[][]{{0}};
        Lv1871GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // then
        assertThat(gameOfLife.countLiveNeighbours(0, 0)).isEqualTo(0);
    }

    @Test
    void countNeighbours_shouldThrowExceptionForNegativeRow() {
        // given
        short[][] field = new short[][]{{0}};
        Lv1871GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // then
        assertThatThrownBy(() -> gameOfLife.countLiveNeighbours(-1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Row must be between 0 and 0");
    }

    @Test
    void countNeighbours_shouldThrowExceptionForTooBigRow() {
        // given
        short[][] field = new short[][]{{0}};
        Lv1871GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // then
        assertThatThrownBy(() -> gameOfLife.countLiveNeighbours(1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Row must be between 0 and 0");
    }

    @Test
    void countNeighbours_shouldThrowExceptionForNegativeColumn() {
        // given
        short[][] field = new short[][]{{0}};
        Lv1871GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // then
        assertThatThrownBy(() -> gameOfLife.countLiveNeighbours(0, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Column must be between 0 and 0");
    }

    @Test
    void countNeighbours_shouldThrowExceptionForTooBigColumn() {
        // given
        short[][] field = new short[][]{{0}};
        Lv1871GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // then
        assertThatThrownBy(() -> gameOfLife.countLiveNeighbours(0, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Column must be between 0 and 0");
    }


    @ParameterizedTest
    @MethodSource("field5x5Source")
    void countNeighbours_shouldReturnCorrectCountFor5x5Field(short[][] wrapper, long expected) {

        // given
        Lv1871GameOfLife gameOfLife = new Lv1871GameOfLife(wrapper);
        // then check the center cell
        assertThat(gameOfLife.countLiveNeighbours(2, 2)).isEqualTo(expected);
    }

    public static Stream<Arguments> field5x5Source() {
        return Stream
                .of(
                        of(new short[][]{{1, 1, 1, 1, 1},
                                {1, 1, 0, 0, 1},
                                {1, 0, 1, 0, 1},
                                {1, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1}}, 1L),
                        of(new short[][]{{1, 1, 1, 1, 1},
                                {1, 1, 1, 0, 1},
                                {1, 0, 1, 0, 1},
                                {1, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1}}, 2L),
                        of(new short[][]{{1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 0, 1, 0, 1},
                                {1, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1}}, 3L),
                        of(new short[][]{{1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 0, 1},
                                {1, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1}}, 4L),
                        of(new short[][]{{1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1}}, 5L),
                        of(new short[][]{{1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 1, 0, 0, 1},
                                {1, 1, 1, 1, 1}}, 6L),
                        of(new short[][]{{1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 0, 1},
                                {1, 1, 1, 1, 1}}, 7L),
                        of(new short[][]{{1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1}}, 8L)
                );
    }

    @Test
    void lifePercentage_shouldReturnZeroForEmptyField() {
        // given
        short[][] field = new short[][]{{0}};
        Lv1871GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // then
        assertThat(gameOfLife.getLifePercentage()).isEqualTo(0);
    }

    @Test
    void lifePercentage_shouldReturnOneForOneLifeField() {
        // given
        short[][] field = new short[][]{{1}};
        Lv1871GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // then
        assertThat(gameOfLife.getLifePercentage()).isEqualTo(100);
    }

    @Test
    void lifePercentage_shouldReturn40Percent() {
        // given
        short[][] field = new short[][]{{0, 1, 0, 1, 0}};
        Lv1871GameOfLife gameOfLife = new Lv1871GameOfLife(field);
        // then
        assertThat(gameOfLife.getLifePercentage()).isEqualTo(40);
    }


}

