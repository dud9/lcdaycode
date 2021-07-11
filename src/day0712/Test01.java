package day0712;

import annotion.Medium;

/**
 * @author liu yicheng
 * @date 2021/7/12 - 7:07
 * 274. H 指数
 */
public class Test01 {

    @Medium
    public int hIndex(int[] ci) {
        int n = ci.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(ci, mid)) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    boolean check(int[] ci, int mid) {
        int ans = 0;
        for (int i : ci) if (i >= mid) ans++;
        return ans >= mid;
    }
}
