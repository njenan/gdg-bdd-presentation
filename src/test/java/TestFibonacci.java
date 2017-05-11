import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFibonacci {
    @Test
    public void returnsFirstFibonacciNumber() {
        assertEquals(1, Fibonacci.get(1));
    }
}
