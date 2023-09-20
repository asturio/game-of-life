package de.lv1871.kata.gameoflife;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameOfLifeStarterTest {

    @Test
    void generateField_withNull_shouldReturnDefaultField() {
        short[][] shorts = GameOfLifeStarter.generateField();
        assertThat(shorts.length).isEqualTo(20);
        assertThat(shorts[0].length).isEqualTo(40);
    }

    @Test
    void generateField_withOneParameter_shouldReturnDefaultField() {
        short[][] shorts = GameOfLifeStarter.generateField("10");
        assertThat(shorts.length).isEqualTo(20);
        assertThat(shorts[0].length).isEqualTo(40);
    }

    @Test
    void generateField_withTwoParameter_shouldReturnCustomField() {
        short[][] shorts = GameOfLifeStarter.generateField("3", "5");
        assertThat(shorts.length).isEqualTo(3);
        assertThat(shorts[0].length).isEqualTo(5);
    }
}