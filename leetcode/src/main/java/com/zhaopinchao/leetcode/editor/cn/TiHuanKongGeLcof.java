//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//


package com.zhaopinchao.leetcode.editor.cn;

public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        String s = solution.replaceSpace("");
        System.out.println(s);
        String s1 = solution.replaceSpace("We are happy.");
        System.out.println(s1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                sb.append(c == ' ' ? "%20" : c);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}