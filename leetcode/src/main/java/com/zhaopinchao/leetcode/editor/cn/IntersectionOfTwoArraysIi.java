//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 336 👎 0


package com.zhaopinchao.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        int[] nums11 = {1, 2, 2, 1};
        int[] nums12 = {2, 2};
        solution.intersect(nums11, nums12);


        int[] nums21 = {4, 9, 5};
        int[] nums22 = {9, 4, 9, 8, 4};
        solution.intersect(nums21, nums22);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if (nums1.length == 0 || nums2.length == 0) return new int[0];
            Map<Integer, Integer> map;
            if (nums1.length < nums2.length) {
                map = new HashMap<>(nums1.length);
                initMap(map, nums1);
            } else {
                map = new HashMap<>(nums2.length);
                initMap(map, nums2);
            }
            List<Integer> intersect;
            if (nums1.length < nums2.length) {
                intersect = intersect(map, nums2);
            } else {
                intersect = intersect(map, nums1);
            }
            int[] result = new int[intersect.size()];
            for (int i = 0; i < intersect.size(); i++) {
                result[i] = intersect.get(i);
            }
            return result;
        }

        private void initMap(Map<Integer, Integer> map, int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
        }

        private List<Integer> intersect(Map<Integer, Integer> map, int[] nums) {
            List<Integer> intersect = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i]) && map.get(nums[i]) > 0) {
                    intersect.add(nums[i]);
                    map.put(nums[i], map.get(nums[i]) - 1);
                }
            }
            return intersect;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}