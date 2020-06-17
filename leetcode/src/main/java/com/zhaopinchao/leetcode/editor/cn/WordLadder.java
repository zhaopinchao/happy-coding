//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


package com.zhaopinchao.leetcode.editor.cn;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        int length = solution.ladderLength("ymain", "oecij", Arrays.asList("ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"));
        System.out.println(length);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || wordList.size() == 0) {
                return 0;
            }
            Set<String> set = new HashSet<>(wordList);
            if (!set.contains(endWord)) {
                return 0;
            }
            set.remove(beginWord);
            int res = 1;
            Set<String> visited = new HashSet<>();
            Deque<String> deque = new ArrayDeque<>();
            deque.addLast(beginWord);
            while (!deque.isEmpty()) {
                int size = deque.size();
                res++;
                for (int i = 0; i < size; i++) {
                    String temp = deque.pollLast();
                    char[] chars = temp.toCharArray();
                    for (int j = 0; j < chars.length; j++) {
                        char origin = chars[j];
                        for (int k = 'a'; k <= 'z'; k++) {
                            if (origin == k) {
                                continue;
                            }
                            chars[j] = (char) k;
                            String newStr = new String(chars);
                            if (newStr.equals(endWord)) {
                                return res;
                            }
                            if (set.contains(newStr) && !visited.contains(newStr)) {
                                deque.addFirst(newStr);
                                visited.add(newStr);
                            }
                        }
                        chars[j] = origin;
                    }
                }
            }
            return 0;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}