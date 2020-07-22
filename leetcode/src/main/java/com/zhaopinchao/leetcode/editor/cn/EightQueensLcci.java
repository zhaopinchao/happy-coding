//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法


package com.zhaopinchao.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class EightQueensLcci {
    public static void main(String[] args) {
        Solution solution = new EightQueensLcci().new Solution();
        System.out.println(solution.solveNQueens(4));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        //初始化网格
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        //占位
        solve(grid, 0, res);
        return res;
    }

    private void solve(char[][] grid, int row, List<List<String>> res) {
        if (row == grid.length) {
            List<String> subResult = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < grid[i].length; j++) {
                    s.append(grid[i][j]);
                }
                subResult.add(s.toString());
            }
            res.add(subResult);
            return;
        }

        for (int col = 0; col < grid[row].length; col++) {
            if (check(grid, row, col)) {
                grid[row][col] = 'Q';
                solve(grid, row + 1, res);
                grid[row][col] = '.';
            }
        }

    }

    private boolean check(char[][] grid, int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i + j == row + col || i - j == row - col || i == row || j == col) {
                    if (grid[i][j] == 'Q') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}