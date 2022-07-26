import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author zhaopc
 * @date 2020-05-26 23:01
 * @description
 */
public class Q239MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int maxIndex = 0;
        deque.addFirst(maxIndex);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums[maxIndex]) {
                while (!deque.isEmpty()) {
                    deque.pollFirst();
                }
                maxIndex = i;
                deque.addFirst(i);
            } else {
                if (!deque.isEmpty() && deque.getFirst() == i - k) {
                    deque.removeFirst();
                }
                while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                    deque.removeLast();
                }
                deque.addLast(i);
            }
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.getFirst()];
            }

        }
        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    public static void main(String[] args) {
        Q239MaxSlidingWindow q = new Q239MaxSlidingWindow();
        int[] nums = new int[]{9,10,9,-7,-4,-8,2,-6};
        int k = 5;
        int[] res = q.maxSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
