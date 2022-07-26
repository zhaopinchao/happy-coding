import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaopc
 * @date 2020-05-17 09:01
 * @description
 */
public class Q210FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        TreeNode treeNode = new TreeNode(prerequisites[0][1], prerequisites[0][0]);
        for (int i = 1; i < prerequisites.length; i++) {
            treeNode.add(prerequisites[i][1], prerequisites[i][0]);
        }
        List<Integer> intArray = treeNode.intArray(treeNode);
        int[] res = new int[intArray.size()];
        for (int i = 0; i < intArray.size(); i++) {
            res[i] = intArray.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses = 4;
        Q210FindOrder findOrder = new Q210FindOrder();
        System.out.println(findOrder.findOrder(numCourses,prerequisites));
    }

    private static class TreeNode {
        int val;
        TreeNode next;
        TreeNode temp = null;
        boolean tempFlag = false;
        TreeNode tempNext = null;
        boolean tempNextFlag = false;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode next) {
            this.val = val;
            this.next = next;
        }

        public TreeNode(int val, int next) {
            this.val = val;
            this.next = new TreeNode(next);
        }

        private void add(int pre, int next) {
            list(pre, next);
            if (temp == null && tempNext == null) {
                add(this, pre, next);
                return;
            }
            if (temp != null && tempNext == null) {
                TreeNode second = temp.next;
                TreeNode nextNode = new TreeNode(next);
                temp.next = nextNode;
                nextNode.next = second;
                return;
            }
        }

        private void add(TreeNode treeNode, int pre, int next) {
            if (treeNode.next == null) {
                treeNode.next = new TreeNode(pre);
                treeNode.next.next = new TreeNode(next);
                return;
            }
        }

        private void list(int pre, int next) {
            list(this, pre, next);
        }

        private void list(TreeNode treeNode, int pre, int next) {
            if (treeNode == null) {
                return;
            }
            if (treeNode.val == pre && !tempFlag) {
                temp = treeNode;
                tempFlag = true;
            }
            if (treeNode.next != null) {
                if (treeNode.next.val == next) {
                    tempNext = treeNode.next;
                    tempNextFlag = true;
                }
                if (tempFlag && tempNextFlag) {
                    return;
                } else {
                    list(treeNode.next.next, pre, next);
                }
            }
        }

        public List<Integer> intArray(TreeNode node) {
            List<Integer> array = new ArrayList<>();
            intArray(array, node);
            System.out.println(array);
            return array;
        }

        public void intArray(List<Integer> array, TreeNode node) {
            if (node != null) {
                array.add(node.val);
                intArray(array, node.next);
            }
        }
    }
}
