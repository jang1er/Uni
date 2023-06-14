package main.java.de.uulm.sp.oop.exercises.e05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SokobanTest {
    private static char[][] sokoban;
    private static Sokoban game;
    @BeforeEach
    void setUp() {
        sokoban = new char[7][];
        sokoban[0] = "#######".toCharArray();
        sokoban[1] = "#.....#".toCharArray();
        sokoban[2] = "#..$..#".toCharArray();
        sokoban[3] = "#.$@$.#".toCharArray();
        sokoban[4] = "#..$..#".toCharArray();
        sokoban[5] = "#.....#".toCharArray();
        sokoban[6] = "#######".toCharArray();

        game = new Sokoban();
    }

    @Test
    void findPlayer() {
        assertEquals(new Pair<>(3,3), game.findPlayer(sokoban));
    }

    @Test
    void move() {
        String correctBoard = "#######\n#..$..#\n#.....#\n#.$.@.#\n#..$$.#\n#.....#\n#######";
        game.moveNorth(sokoban);
        game.moveEast(sokoban);
        game.moveSouth(sokoban);
        assertEquals(correctBoard, game.sokobanToString(sokoban));
    }
}