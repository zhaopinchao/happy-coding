import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-19 19:33
 * @description
 */
public class Q680ValidPalindrome {

    public boolean validPalindrome(String s) {
        int i = -1, j = s.length();
        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(i, j + 1, s) || isPalindrome(i - 1, j, s);
            }
        }
        return true;
    }

    private boolean isPalindrome(int i, int j, String s) {
        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Q680ValidPalindrome q = new Q680ValidPalindrome();
        System.out.println(q.validPalindrome("abc"));
    }
}
