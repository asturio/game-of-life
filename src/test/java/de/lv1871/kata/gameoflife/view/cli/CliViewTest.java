package de.lv1871.kata.gameoflife.view.cli;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.Mockito.when;

import de.lv1871.kata.gameoflife.GameOfLife;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        String actual = outContent.toString().replaceAll("\r", "");
        String expected = """
                +-+
                | |
                +-+
                == Generation 0
                """;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void playGame() {
        // given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        when(gameOfLife.getField()).thenReturn(new short[][]{{0}});
        when(gameOfLife.stillRunning()).thenReturn(true, false);
        CliView view = new CliView(gameOfLife, new PrintStream(outContent));
        view.setDelayMillis(0);
        // then
        assertThatNoException().isThrownBy(view::playGame);
    }

}
