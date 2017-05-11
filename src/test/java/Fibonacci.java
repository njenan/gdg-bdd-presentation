
public class Fibonacci {
    public static int get(int i) {
        if (i < 2) {
            return 1;
        } else {
            return Fibonacci.get(i - 1) + Fibonacci.get(i - 2);
        }
    }
}
