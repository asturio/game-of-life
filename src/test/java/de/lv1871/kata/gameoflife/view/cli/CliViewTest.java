package de.lv1871.kata.gameoflife.view.cli;

import de.lv1871.kata.gameoflife.GameOfLife;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CliViewTest {
    @Mock
    private GameOfLife gameOfLife;

    @Test
    void constructor() {
        CliView view = new CliView(null, null);
        view.setDelayMillis(3);
        assertThat(view).isNotNull();
    }

    @Test
    void drawField() {
        // given
        when(gameOfLife.getField()).thenReturn(new short[][]{{0}});
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        CliView view = new CliView(gameOfLife, new PrintStream(outContent));
        view.setDelayMillis(0);
        // when
        view.drawField();
        // then
        assertThat(outContent.toString()).isEqualTo(
                """
                        +-+
                        | |
                        +-+
                        ===
                        """);
    }

    @Test
    void playGame()  {
        // given
        when(gameOfLife.getField()).thenReturn(new short[][]{{0}});
        when(gameOfLife.stillRunning()).thenReturn(true, false);
        CliView view = new CliView(gameOfLife, System.out);
        view.setDelayMillis(0);
        // then
        assertThatNoException().isThrownBy(view::playGame);
    }

}
