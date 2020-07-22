//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划


package com.zhaopinchao.leetcode.editor.cn;

public class UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
        int[][] obstacleGrid = new int[][]{{0, 0}, {1, 1}, {0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m = obstacleGrid.length;
            if (m == 0) {
                return 0;
            }
            int n = obstacleGrid[0].length;
            if (n == 0) {
                return 0;
            }
            if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
                return 0;
            }
            if (m == 1 || n == 1) {
                boolean flag = false;
                for (int i = 0; i < obstacleGrid.length; i++) {
                    for (int j = 0; j < obstacleGrid[0].length; j++) {
                        if (obstacleGrid[i][j] == 1) {
                            flag = true;
                        }
                    }
                }
                if (flag) {
                    return 0;
                } else {
                    return 1;
                }
            }
            int[][] memo = new int[m][n];
            boolean flaga = false;
            for (int a = m - 1; a >= 0; a--) {
                if(obstacleGrid[a][n - 1] == 1) {
                    flaga = true;
                }
                memo[a][n - 1] = flaga ? 0 : 1;
            }
            boolean flagb = false;
            for (int b = 0; b < n; b++) {
                if(obstacleGrid[m - 1][b] == 1) {
                    flagb = true;
                }
                memo[m - 1][b] = flagb ? 0 : 1;
            }
            for (int i = m - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    if (obstacleGrid[i][j] == 1) {
                        memo[i][j] = 0;
                    } else {
                        memo[i][j] = memo[i + 1][j] + memo[i][j + 1];
                    }
                }
            }
            return memo[0][1] + memo[1][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}