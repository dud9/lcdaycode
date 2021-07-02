package day0702;

import java.util.Arrays;

/**
 * @author liu yicheng
 * @date 2021/7/2 - 10:38
 * 1833. 雪糕的最大数量
 */
public class Test01 {


    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (coins >= costs[i]) {
                ans++;
                coins -= costs[i];
            } else {
                break;
            }
        }
        return ans;
    }
}
