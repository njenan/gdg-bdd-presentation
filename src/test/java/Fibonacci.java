/**
 * Created by kiddynamo on 5/10/17.
 */
public class Fibonacci {
    public static int get(int index) {
        if (index < 3) {
            return 1;
        } else {
            return get(index - 1) + get(index - 2);
        }
    }
}
