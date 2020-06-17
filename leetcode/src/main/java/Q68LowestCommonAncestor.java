/**
 * @author: zhaopc@tuya.com
 * @date: 2020-06-04 23:30
 * @description
 */
public class Q68LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        return root;
    }

}
