package main.java.de.uulm.sp.oop.exercises.e05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {
private static  Pair<Double, String> pair;
    @BeforeEach
    void setUp() {
       pair = new Pair<>(12.00, "Test_Test");
    }

    @Test
    void getFirst() {
        assertEquals(12.00, pair.getFirst());
    }

    @Test
    void getSecond() {
        assertEquals("Test_Test", pair.getSecond());
    }

    @Test
    void testToString() {
        assertEquals("12.0 / Test_Test", pair.toString());
    }

    @Test
    void testEquals() {
        Pair<Double, String> p1 = new Pair<>(12.00, "Test_Test");
        Pair<Double, String> p2 = new Pair<>(13.00, "Test_Test");
        Pair<Double, Integer> p3 = new Pair<>(12.00, 12);

        assertEquals(true, pair.equals(p1));
        assertEquals(false, pair.equals(p2));
        assertEquals(false, pair.equals(p3));

    }

    @Test
    void compareTo() {
        Pair<Double, String> p1 = new Pair<>(12.00, "Test_Test");
        Pair<Double, String> p2 = new Pair<>(13.00, "Test_Test");
        Pair<Double, String> p3 = new Pair<>(12.00, "Hallöle");

        assertEquals(0, pair.compareTo(p1));
        assertEquals(pair.getFirst().compareTo(p2.getFirst()), pair.compareTo(p2));
        assertEquals(pair.getSecond().compareTo(p3.getSecond()),pair.compareTo(p3));
    }
}