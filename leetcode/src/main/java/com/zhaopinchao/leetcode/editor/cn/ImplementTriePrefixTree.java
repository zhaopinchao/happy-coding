//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树


package com.zhaopinchao.leetcode.editor.cn;


public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        // 返回 false
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
        // 返回 true
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        // 返回 true
        System.out.println(trie.search("app"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Trie {

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
            private TrieNode[] link = new TrieNode[26];
            //是否是end
            private boolean isEnd;

            private TrieNode() {
            }

            private boolean containsKey(char c) {
                return link[c - 'a'] != null;
            }

            private TrieNode get(char c) {
                return link[c - 'a'];
            }

            private void put(char c) {
                link[c - 'a'] = new TrieNode();
            }

            private TrieNode root() {
                TrieNode trieNode = new TrieNode();
                trieNode.isEnd = true;
                return trieNode;
            }
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}