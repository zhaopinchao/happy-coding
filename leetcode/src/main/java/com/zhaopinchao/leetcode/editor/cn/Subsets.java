//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法


package com.zhaopinchao.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        for (List<Integer> subset : subsets) {
            for (Integer integer : subset) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length == 0) {
                return result;
            }
            dfs(result, new ArrayList<>(), nums, 0);
            return result;
        }

        private void dfs(List<List<Integer>> result, ArrayList<Integer> integers, int[] nums, int index) {
            // 终结条件
            if (index == nums.length) {
                result.add(new ArrayList<>(integers));
                return;
            }
            //逻辑
            //不选择某个数
            dfs(result, integers, nums, index + 1);
            integers.add(nums[index]);
            //选择某个数
            dfs(result, integers, nums, index + 1);
            //reverse 状态
            integers.remove(integers.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}