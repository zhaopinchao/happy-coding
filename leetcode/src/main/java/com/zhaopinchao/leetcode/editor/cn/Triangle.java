//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 539 👎 0


package com.zhaopinchao.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Triangle {
    //[[-1],[3,2],[-3,1,-1]]
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l1 = Arrays.asList(2);
        triangle.add(l1);
        List<Integer> l2 = Arrays.asList(3, 4);
        triangle.add(l2);
        List<Integer> l3 = Arrays.asList(6, 5, 7);
        triangle.add(l3);
        List<Integer> l4 = Arrays.asList(4, 1, 8, 3);
        triangle.add(l4);
        System.out.println(solution.minimumTotal(triangle));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n];
            // n = 0:  dp[0] = dp[0] + c[i][0]
            // n = i: dp[n] = dp[n-1] + c[i][j]
            // n ~ (0, i): dp[n] = min(dp[n], dp[n-1]) + c[i][j]
            for (int i = 0; i < n; i++) {
                for (int j = i; j >= 0; j--) {
                    if (j == 0) {
                        dp[j] = dp[0] + triangle.get(i).get(0);
                    } else if (j == i) {
                        dp[j] = dp[j - 1] + triangle.get(i).get(j);
                    } else {
                        dp[j] = Integer.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < dp.length; i++) {
                res = Integer.min(res, dp[i]);
            }
            return res;
        }

        public int minimumTotal1(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < triangle.size(); i++) {
                dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
                for (int j = 1; j < i; j++) {
                    dp[i][j] = Integer.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
                dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
            }
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < dp[n - 1].length; i++) {
                res = Integer.min(dp[n - 1][i], res);
            }
            return res;
        }
//
//
//        int min = Integer.MAX_VALUE;
//
//        public int minimumTotal2(List<List<Integer>> triangle) {
//            dfs(0, 0, triangle.get(0).get(0), triangle);
//            return min;
//        }
//
//        private void dfs(int level, int index, int cur, List<List<Integer>> triangle) {
//            if (level == triangle.size() - 1) {
//                min = Integer.min(min, cur);
//                return;
//            }
//            List<Integer> list = triangle.get(level + 1);
//            if (index + 1 < list.size()) {
//                dfs(level + 1, index + 1, cur + list.get(index + 1), triangle);
//            }
//            if (index < list.size()) {
//                dfs(level + 1, index, cur + list.get(index), triangle);
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}