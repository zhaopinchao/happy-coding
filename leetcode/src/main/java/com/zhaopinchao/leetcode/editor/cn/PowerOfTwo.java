//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学


package com.zhaopinchao.leetcode.editor.cn;

public class PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new PowerOfTwo().new Solution();
//        System.out.println(solution.isPowerOfTwo(5));
//        System.out.println(solution.isPowerOfTwo(6));
//        System.out.println(solution.isPowerOfTwo(7));
//        System.out.println(solution.isPowerOfTwo(8));
//        System.out.println(solution.isPowerOfTwo(18));

        int num = 808201;
        long left = 2, right = num >> 1, mid;
        while(left <= right) {
            mid = left + ((right - left) >> 1);
            System.out.println("mid = " + mid);
            long temp = mid * mid;
            if(temp == num)  {
                System.out.println("temp == num");
                return;
            }
            if(temp > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("not");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return (n & (n - 1)) == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//
//        mid = 202050
//        mid = 101024
//        mid = 50511
//        mid = 25255
//        mid = 12627
//        mid = 6313
//        mid = 3156
//        mid = 1577
//        mid = 788


