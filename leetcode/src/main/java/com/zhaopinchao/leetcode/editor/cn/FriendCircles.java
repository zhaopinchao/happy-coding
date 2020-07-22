//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 示例 1: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出: 2 
//说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回2。
// 
//
// 示例 2: 
//
// 
//输入: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出: 1
//说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
// 
//
// 注意： 
//
// 
// N 在[1,200]的范围内。 
// 对于所有学生，有M[i][i] = 1。 
// 如果有M[i][j] = 1，则有M[j][i] = 1。 
// 
// Related Topics 深度优先搜索 并查集


package com.zhaopinchao.leetcode.editor.cn;

public class FriendCircles {
    public static void main(String[] args) {
        Solution solution = new FriendCircles().new Solution();
        int[][] m = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(solution.findCircleNum(m));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] M) {
            int result = 0;
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[i].length; j++) {
                    if (M[i][j] == 1) {
                        dfs(M, i, j);
                        result++;
                    }
                }
            }
            return result;
        }

        private void dfs(int[][] M, int row, int col) {
            int[] a = {0, 0, 1, -1};
            int[] b = {1, -1, 0, 0};
            M[row][col] = 0;
            for (int i = 0; i < 4; i++) {
                int newRow = row + a[i];
                int newCol = col + b[i];
                if (newRow < 0 || newRow >= M.length || newCol < 0 || newCol >= M[newRow].length) {
                    continue;
                }
                if (M[newRow][newCol] == 1) {
                    dfs(M, newRow, newCol);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

