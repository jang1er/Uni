package main.java.de.uulm.sp.oop.exercises.e06;

import main.java.de.uulm.sp.oop.exercises.e06.util.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GradeOverviewTest {
    private GradeOverview grades;
    @BeforeEach
    void setUp() {
        grades = new GradeOverview();
        grades.addTestResult("PI", new Pair<>(2.0 , 6));
        grades.addTestResult("TI", new Pair<>(1.7, 8));
        grades.addTestResult("GDTI", new Pair<>(1.3, 8));
        grades.addTestResult("Mathe1", new Pair<>(3.3, 8));
    }

    @Test
    void currentECTS() {
        assertEquals(30, grades.currentECTS());
    }

    @Test
    void getExamResults() {
        assertEquals(new Pair<Double, Integer>(1.7,8) , grades.getExamResults("TI").get());
    }

    @Test
    void totalGradeAverage() {
        assertEquals(2.08, grades.totalGradeAverage());
    }
}