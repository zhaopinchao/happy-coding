//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


package com.zhaopinchao.leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'},};
        System.out.println(solution.numIslands(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int result = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        grid[i][j] = '0';
                        dfs(grid, i, j);
                        result++;
                    }
                }
            }
            return result;
        }

        private void dfs(char[][] grid, int row, int col) {
            int[] a = {-1, 1, 0, 0};
            int[] b = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int newRow = row + a[i];
                int newCol = col + b[i];
                if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[newRow].length) {
                    continue;
                }
                if (grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0';
                    dfs(grid, newRow, newCol);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}