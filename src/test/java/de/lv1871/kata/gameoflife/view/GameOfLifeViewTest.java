package de.lv1871.kata.gameoflife.view;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class GameOfLifeViewTest {
    @Test
    void nullField() {
        // when
        List<String> lines = GameOfLifeView.getFieldLines(null);
        // then
        assertThat(lines).isEmpty();
    }

    @Test
    void noSpaceField() {
        // when
        List<String> lines = GameOfLifeView.getFieldLines(new short[0][0]);
        // then
        assertThat(lines).isEmpty();
    }

    @Test
    void emptyShortField() {
        // given
        short[][] shortsField = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        // when
        List<String> lines = GameOfLifeView.getFieldLines(shortsField);
        // then
        assertThat(lines).containsExactly("     ", "     ", "     ");
    }

    @Test
    void shortFieldWithOneCell() {
        // given
        short[][] shortsField = {{0, 0, 1}, {0, 0, 0}, {0, 0, 0}};
        // when
        List<String> lines = GameOfLifeView.getFieldLines(shortsField);
        // then
        assertThat(lines).containsExactly("    " + GameOfLifeView.LIVE, "     ", "     ");
    }

    @Test
    void delay() {
        // given
        GameOfLifeView view = Mockito.spy(GameOfLifeView.class);
        when(view.getDelayMillis()).thenReturn(15L);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // when
        Future<Void> future = executorService.submit(() -> {
            view.delay();
            return null;
        });
        // then
        assertThat(future).succeedsWithin(Duration.ofMillis(50));
    }
}
