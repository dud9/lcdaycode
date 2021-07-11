package day0711;

import annotion.Medium;

/**
 * @author liu yicheng
 * @date 2021/7/11 - 14:14
 * 274. H 指数
 */
public class Test01 {


    int[] c;
    @Medium
    public int hIndex(int[] ci) {
        c = ci;
        int n = ci.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    boolean check (int t) {
        int ans = 0;
        for (int i : c) if (i >= t) ans++;
        return ans >= t;
    }

}
