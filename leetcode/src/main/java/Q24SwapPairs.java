import com.zhaopinchao.leetcode.editor.cn.ListNode;

/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-21 22:54
 * @description
 */
public class Q24SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode nextN = next.next;
        next.next = head;
        head.next = nextN;
        swap(nextN);
        return next;
    }

    private void swap(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        ListNode next = node.next;
        ListNode nextN = next.next;
        next.next = node;
        node.next = nextN;
        swap(nextN);
    }

    public static void main(String[] args) {
        Q24SwapPairs q = new Q24SwapPairs();
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        q.swapPairs(head);
        System.out.println("");
    }
}
