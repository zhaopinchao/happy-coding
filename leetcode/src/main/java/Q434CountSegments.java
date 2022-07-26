/**
 * @author zhaopc
 * @date 2020-05-29 21:47
 * @description
 */
public class Q434CountSegments {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ' && s.charAt(i) != ' ') {
                count++;
            }
        }
        if (s.length() > 0 && s.charAt(0) != ' ') {
            count++;
        }
        return count;
    }
}
