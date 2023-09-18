package de.lv1871.kata.gameoflife.view.lanterna;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import de.lv1871.kata.gameoflife.GameOfLife;
import de.lv1871.kata.gameoflife.GameOfLifeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class LanternaViewTest {

    @Mock
    private GameOfLife gameOfLife;

    @BeforeEach
    void setUp() {

    }

    @Test
    void constructorWithNullArguments() {
        assertThatThrownBy(() -> new LanternaView(null))
                .isInstanceOf(GameOfLifeException.class)
                .hasMessage("GameOfLife must not be null");
    }

    @Test
    void drawField() {
        // given
        when(gameOfLife.getRows()).thenReturn(1);
        when(gameOfLife.getColumns()).thenReturn(1);
        when(gameOfLife.getField()).thenReturn(new short[1][1]);
        // when
        LanternaView view = new LanternaView(gameOfLife);
        view.setDelayMillis(0);
        // then
        assertThatNoException().isThrownBy(view::drawField);
    }

    @Test
    void playGame() {
        // given
        when(gameOfLife.getRows()).thenReturn(1);
        when(gameOfLife.getColumns()).thenReturn(1);
        when(gameOfLife.stillRunning()).thenReturn(true, false);
        LanternaView view = new LanternaView(gameOfLife);
        view.setDelayMillis(0);
        assertThatNoException().isThrownBy(view::playGame);
    }

    @Test
    void getDelayMillis() {
        when(gameOfLife.getRows()).thenReturn(1);
        when(gameOfLife.getColumns()).thenReturn(1);
        LanternaView view = new LanternaView(gameOfLife);
        view.setDelayMillis(200);

        assertThat(view.getDelayMillis()).isBetween(0L, 400L);
    }

    @Test
    void noBoardException() {
        assertThatThrownBy(() ->
                new LanternaView(gameOfLife))
                .isInstanceOf(GameOfLifeException.class)
                .hasMessageContaining("GameOfLife must have at least one row and one column");
    }

}
