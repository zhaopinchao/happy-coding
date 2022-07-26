/**
 * @author zhaopc
 * @date 2020-05-29 21:31
 * @description
 */
public class Q258AddDigits {

    public int addDigits(int num) {
        int res = num % 10;
        while (num / 10 > 0) {
            res += (num / 10) % 10;
            if (res > 9) {
                res = res - 9;
            }
            num = num / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Q258AddDigits q = new Q258AddDigits();
        System.out.println(q.addDigits(6));
    }
}
