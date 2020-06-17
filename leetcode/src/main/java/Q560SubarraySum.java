import java.util.HashMap;

/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-15 23:06
 * @description
 */
public class Q560SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Q560SubarraySum q = new Q560SubarraySum();
        int[] nums = new int[]{-92, -63, 75, -86, -58, 22, 31, -16, -66, -67, 420};
        int k = 100;
        System.out.println(q.subarraySum(nums, k));
    }
}
