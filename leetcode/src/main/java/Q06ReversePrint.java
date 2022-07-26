import com.zhaopinchao.leetcode.editor.cn.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhaopc
 * @date 2020-06-03 22:22
 * @description
 */
public class  Q06ReversePrint {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(head, deque);
        int[] res = new int[deque.size()];
        int index = 0;
        while (!deque.isEmpty()) {
            res[index++] = deque.pollFirst();
        }
        return res;
    }

    private void dfs(ListNode node, Deque<Integer> deque) {
        if (node == null) {
            return;
        }
        deque.addFirst(node.val);
        dfs(node.next, deque);
    }
}
