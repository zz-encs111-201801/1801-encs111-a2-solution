package q5_expression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Q5 Expression")
class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void case1() {
        assertEquals(2, solution.evaluate("2"));
    }

    @Test
    void case2() {
        assertEquals(20, solution.evaluate("20"));
    }

    @Test
    void case3() {
        assertEquals(3, solution.evaluate("2 + 1"));
    }

    @Test
    void case4() {
        assertEquals(1, solution.evaluate("5 - 3 - 1"));
    }

    @Test
    void case5() {
        assertEquals(11, solution.evaluate("5 * 2 + 1"));
    }

    @Test
    void case6() {
        assertEquals(7, solution.evaluate("5 + 2 * 1"));
    }

    @Test
    void case7() {
        assertEquals(6, solution.evaluate("2 + 2 * 1 * 2"));
    }

    @Test
    void case8() {
        assertEquals(8, solution.evaluate("2 + 2 * 1 * 2 + 2"));
    }

    @Test
    void case9() {
        assertEquals(10, solution.evaluate("2 + 2 * 1 * 2 + 2 * 2"));
    }

    @Test
    void case10() {
        assertEquals(11, solution.evaluate("2 * 2 + 1 + 2 * 2 + 2"));
    }


    @Test
    void case11() {
        assertEquals(11, solution.evaluate("2 *2 + 1 + 2* 2+2"));
    }
}