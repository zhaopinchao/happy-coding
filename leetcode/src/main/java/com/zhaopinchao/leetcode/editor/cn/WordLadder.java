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
//        int length = solution.ladderLength("ymain", "oecij", Arrays.asList("ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"));
//        System.out.println(length);
//        System.out.println("==================================");
        int length1 = solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(length1);
//        System.out.println("==================================");
//        int length2 = solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "tog", "cog"));
//        System.out.println(length2);
//        System.out.println("==================================");
//        int length3 = solution.ladderLength("dog", "cog", Arrays.asList("hot", "dot", "dog", "lot", "cog"));
//        System.out.println(length3);
//        System.out.println("==================================");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双向 BFS
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || wordList.size() == 0) return 0;
            //字典存map集合
            Map<String, Boolean> dis = new HashMap<>(wordList.size());
            for (int i = 0; i < wordList.size(); i++) {
                dis.put(wordList.get(i), false);
            }
            if(!dis.containsKey(endWord)) return 0;
            int res = 1;
            Set<String> begin = new HashSet<>();
            begin.add(beginWord);
            Set<String> end = new HashSet<>();
            end.add(endWord);
            while (!begin.isEmpty()) {
                if (begin.size() > end.size()) {
                    Set<String> temp = begin;
                    begin = end;
                    end = temp;
                }
                res++;
                Set<String> set = new HashSet<>();
                for (String string : begin) {
                    char[] chars = string.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        char c = chars[i];
                        for (char j = 'a'; j <= 'z'; j++) {
                            if(j == c) continue;
                            chars[i] = j;
                            String s = String.valueOf(chars);
                            if(end.contains(s)) {
                                //如果end集合包含了这个串,那么说明双向bfs相撞了,可以返回结果了
                                return res;
                            }
                            if (dis.containsKey(s) && !dis.get(s)) {
                                dis.put(s, true);
                                set.add(s);
                            }
                        }
                        chars[i] = c;
                    }
                }
                begin = set;
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}