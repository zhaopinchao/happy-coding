
/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-30 15:19
 * @description
 */
public class Q104MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        return dfs(root, 1);
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    private int dfs(TreeNode node, int dept) {
        if (node == null) {
            return dept;
        }
        if (node.left != null || node.right != null) {
            dept++;
        }
        int leftMax = dfs(node.left, dept);
        int rightMax = dfs(node.right, dept);
        if (leftMax > rightMax) {
            return leftMax;
        } else {
            return rightMax;
        }
    }
}
