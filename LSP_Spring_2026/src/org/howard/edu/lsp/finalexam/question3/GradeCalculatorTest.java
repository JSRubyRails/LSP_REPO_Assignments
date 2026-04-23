package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    GradeCalculator calc = new GradeCalculator();

    // 1. Test average()
    @Test
    public void testAverageNormal() {
        assertEquals(80.0, calc.average(70, 80, 90), 0.001);
    }

    // 2. Test letterGrade()
    @Test
    public void testLetterGradeB() {
        assertEquals("B", calc.letterGrade(85.0));
    }

    // 3. Test isPassing()
    @Test
    public void testIsPassingTrue() {
        assertTrue(calc.isPassing(75.0));
    }

    // 4a. Boundary: exactly 60 is passing
    @Test
    public void testBoundaryExactly60IsPassing() {
        assertTrue(calc.isPassing(60.0));
    }

    // 4b. Boundary: exactly 90 is an A
    @Test
    public void testBoundaryExactly90IsA() {
        assertEquals("A", calc.letterGrade(90.0));
    }

    // 5a. Exception: score below 0
    @Test
    public void testExceptionScoreBelowZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(-1, 50, 50));
    }

    // 5b. Exception: score above 100
    @Test
    public void testExceptionScoreAbove100() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(50, 101, 50));
    }
}