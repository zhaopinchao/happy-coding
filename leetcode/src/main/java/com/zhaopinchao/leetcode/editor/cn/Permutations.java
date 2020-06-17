//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


package com.zhaopinchao.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length == 0) {
                return res;
            }
            boolean[] visited = new boolean[nums.length];
            Deque<Integer> deque = new ArrayDeque<>();
            dfs(res, nums, nums.length, deque, visited);
            return res;
        }

        private void dfs(List<List<Integer>> res, int[] nums, int len, Deque<Integer> deque, boolean[] visited) {
            //终结条件
            if (deque.size() == len - 1) {
                res.add(new ArrayList<>(deque));
                return;
            }

            //process
            for (int i = 0; i < len; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                deque.add(nums[i]);
                dfs(res, nums, len, deque, visited);
                visited[i] = false;
                deque.remove(nums[i]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}