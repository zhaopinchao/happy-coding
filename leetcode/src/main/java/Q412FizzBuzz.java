import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-28 22:44
 * @description
 */
public class Q412FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
                continue;
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
