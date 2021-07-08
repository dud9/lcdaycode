package day0708;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu yicheng
 * @date 2021/7/8 - 11:16
 * 930. 和相同的二元子数组
 */
public class Test01 {

    public int numSubarraysWithSum(int[] nums, int t) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            int r = sum[i + 1], l = r - t;
            ans += map.getOrDefault(l, 0);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return ans;
    }
}
