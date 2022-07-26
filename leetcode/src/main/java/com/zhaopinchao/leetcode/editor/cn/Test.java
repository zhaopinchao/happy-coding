package com.zhaopinchao.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhaopc
 * @date 2022/7/13 17:01
 */
public class Test {

    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        pushDeque(root, deque);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            if (node.left != null && node.left.val == 0 && node.left.left == null && node.left.right == null) {
                node.left = null;
            }
            if (node.right != null && node.right.val == 0 && node.right.left == null && node.right.right == null) {
                node.right = null;
            }
        }
        return root;
    }


    private void pushDeque(TreeNode node, Deque<TreeNode> deque) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        deque.push(node);
        pushDeque(node.left, deque);
        pushDeque(node.right, deque);
    }



    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

