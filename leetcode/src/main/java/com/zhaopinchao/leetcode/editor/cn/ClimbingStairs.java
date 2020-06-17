//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


package com.zhaopinchao.leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }
            //直接递归会超时,n-1 和 n-2 其实每次都算过的, 这里用双指针
//            return climbStairs(n - 1) + climbStairs(n - 2);
            int pre2 = 1, pre1 = 2, cur = 0;
            for (int i = 3; i <= n; i++) {
                int temp = cur;
                cur = pre1 + pre2;
                pre2 = pre1;
                pre1 = temp;
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}