/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-18 11:00
 * @description
 */
public class Q152MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = max(nums[i], max(mx * nums[i], mn * nums[i]));
            min = min(nums[i], min(mn * nums[i], mx * nums[i]));
            res = max(res, max);
        }
        return res;
    }

    public int maxProduct1(int[] nums) {
        int res = nums[0];
        for (int i = 1, max = nums[0], min = nums[0]; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = max(nums[i], max * nums[i]);
            min = min(nums[i], min * nums[i]);
            res = max(res, max);
        }
        return res;
    }

    public int maxProduct2(int[] nums) {
        int n = nums.length, res = nums[0], l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            l = (l == 0 ? 1 : l) * nums[i];
            r = (r == 0 ? 1 : r) * nums[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }
}
