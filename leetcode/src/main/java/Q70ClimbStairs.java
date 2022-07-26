import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaopc
 * @date 2020-06-02 08:08
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Q70ClimbStairs {

    /**
     * f(n) = f(n - 1) + f(n - 2)   n > 2
     * f(1) = 1
     * f(2) = 2
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int pre1;
        if (map.containsKey(n - 1)) {
            pre1 = map.get(n - 1);
        } else {
            pre1 = climbStairs(n - 1);
            map.put(n - 1, pre1);
        }
        int pre2;
        if (map.containsKey(n - 2)) {
            pre2 = map.get(n - 2);
        } else {
            pre2 = climbStairs(n - 2);
            map.put(n - 2, pre2);
        }
        return pre1 + pre2;
    }

    public int climbStairs2(int n) {
        int pre = 1, curr = 2, res = 1;
        for (int i = 2; i < n; i++) {
            res = curr + pre;
            pre = curr;
            curr = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Q70ClimbStairs q = new Q70ClimbStairs();
        int res = q.climbStairs2(10);
        System.out.println(res);
    }
}
