//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法


package com.zhaopinchao.leetcode.editor.cn;

import java.util.*;

public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
        char[][] board = {{'o', 'a', 'a', 'n'}, {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oat", "oath", "pea", "eat", "rain"};
        System.out.println(solution.findWords(board, words));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findWords(char[][] board, String[] words) {

            //首先构建字典树
            Trie trie = new Trie();
            HashSet<String> set = new HashSet<>();
            for (String word : words) {
                if (set.add(word)) {
                    trie.insert(word);
                }
            }
            List<String> result = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    boolean b = trie.root.containsKey(board[i][j]);
                    if (b) {
                        //开始递归
                        dfs(board, trie.root, result, i, j);
                    }
                }
            }

            return result;
        }

        private void dfs(char[][] board, Trie.TrieNode root, List<String> result, int row, int col) {
            char c = board[row][col];
            Trie.TrieNode node = root.get(c);
            if (node.word != null) {
                result.add(node.word);
                node.word = null;
            }

            board[row][col] = '#';
            int[] rowOffset = {-1, 0, 1, 0};
            int[] colOffset = {0, 1, 0, -1};

            for (int i = 0; i < 4; ++i) {
                int newRow = row + rowOffset[i];
                int newCol = col + colOffset[i];
                if (newRow < 0 || newRow >= board.length || newCol < 0
                        || newCol >= board[0].length) {
                    continue;
                }
                if (node.containsKey(board[newRow][newCol])) {
                    dfs(board, node, result, newRow, newCol);
                }
            }

            board[row][col] = c;

            System.out.println(c + " rol = " + row + ", col = " + col);
            if (node.isEmpty()) {
                root.remove(c);
            }
        }

        class Trie {

            private TrieNode root;

            /**
             * Initialize your data structure here.
             */
            public Trie() {
                root = new TrieNode().root();
            }

            /**
             * Inserts a word into the trie.
             */
            public void insert(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!node.containsKey(c)) {
                        node.put(c);
                    }
                    node = node.get(c);
                }
                node.isEnd = true;
                node.word = word;
            }

            /**
             * Returns if the word is in the trie.
             */
            public boolean search(String word) {
                TrieNode node = searchPrefix(word);
                return node != null && node.isEnd;
            }

            /**
             * Returns if there is any word in the trie that starts with the given prefix.
             */
            public boolean startsWith(String prefix) {
                return searchPrefix(prefix) != null;
            }

            private TrieNode searchPrefix(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!node.containsKey(c)) {
                        return null;
                    }
                    node = node.get(c);
                }
                return node;
            }

            private class TrieNode {
                //子节点
                private Map<Character, TrieNode> link = new HashMap<>();
                //是否是end
                private boolean isEnd;

                private String word;

                private TrieNode() {
                }

                private boolean containsKey(char c) {
                    return link.get(c) != null;
                }

                private TrieNode get(char c) {
                    return link.get(c);
                }

                private void put(char c) {
                    link.put(c, new TrieNode());
                }

                private void remove(char c) {
                    link.remove(c);
                }

                private boolean isEmpty() {
                    return link.isEmpty();
                }

                private TrieNode root() {
                    TrieNode trieNode = new TrieNode();
                    trieNode.isEnd = true;
                    return trieNode;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}