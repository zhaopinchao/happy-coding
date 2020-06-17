//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法


package com.zhaopinchao.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> strings = solution.generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();

            dfs(res, n, 0, 0, "");
            return res;
        }

        StringBuilder s = new StringBuilder();

        private void dfs(List<String> res, int n, int left, int right, String s) {
            // terminator
            if (right == n) {
                res.add(s);
                return;
            }

            //process
            if (left < n) {
                dfs(res, n, left + 1, right, s + "(");
            }
            if (right < n && right < left) {
                dfs(res, n, left, right + 1, s + ")");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}