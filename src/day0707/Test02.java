package day0707;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu yicheng
 * @date 2021/7/7 - 11:17
 */
public class Test02 {

    int mod = (int)1e9+7;
    int max = 1 << 22;
    public int countPairs(int[] ds) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int x : ds) {
            for (int i = 1; i < max; i <<= 1) {
                int t = i - x;
                if (map.containsKey(t)) {
                    ans += map.get(t);
                    if (ans >= mod) ans -= mod;
                }
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = {2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,
                0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468};
        System.out.println(new Test02().countPairs(data));
    }
}
