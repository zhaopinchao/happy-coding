//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索


package com.zhaopinchao.leetcode.editor.cn;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            return dfs(root, null, null);
        }

        private boolean dfs(TreeNode node, Integer left, Integer right) {
            // 二叉搜索树定义: 所有左子树都小于根, 所有右子树都大于根, 中序遍历
            // 右子树全部大于左子树, 左子树全部小于右子树
            if (node == null) {
                return true;
            }
            if(left != null && node.val >= left){
                return false;
            }
            if(right != null && node.val <= right){
                return false;
            }
            if(!dfs(node.left, node.val, right)) {
                return false;
            }
            if(!dfs(node.right, left, node.val)){
                return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}