import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFibonacci {
    @Test
    public void returnsFibonacciNumbers() {
        assertEquals(1, Fibonacci.get(0));
        assertEquals(1, Fibonacci.get(1));
        assertEquals(2, Fibonacci.get(2));
        assertEquals(3, Fibonacci.get(3));
        assertEquals(5, Fibonacci.get(4));
        assertEquals(8, Fibonacci.get(5));
        assertEquals(13, Fibonacci.get(6));
    }
}
