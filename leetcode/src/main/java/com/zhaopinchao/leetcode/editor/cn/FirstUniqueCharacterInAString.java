//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 233 👎 0


package com.zhaopinchao.leetcode.editor.cn;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            if (s.length() == 0) return -1;
            int[] countArray = new int[26];
            for (int i = 0; i < s.length(); i++) {
                countArray[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (countArray[index] == 1) return i;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}