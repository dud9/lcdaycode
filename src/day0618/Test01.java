package day0618;

import annotion.Hard;

/**
 * @author liu yicheng
 * @date 2021/6/18 - 21:19
 * 483. 最小好进制
 */
public class Test01 {

    @Hard
    /*
    * k 介于  2 ~ n - 1之间
    * k进制的长度 最长为 k = 2 的时候   lnk / ln2
    *            最短为 k = n - 1的时候    == 2
    *
    * 要想k最小  len得最大
    *
    * */
    public String smallestGoodBase(String s) {
        long n = Long.parseLong(s);
        int len = (int) (Math.log(n) / Math.log(2) + 1);
        for (int i = len; i >= 3; i--) {
            long l = 2, r = n - 1;
            while (l < r) {
                long mid = (l + r) >> 1;
                if (check(mid, len, n) >= 0) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (check(r, i, n) == 0) return String.valueOf(r);
        }
        return String.valueOf(n - 1);
    }

    public int check(long k, int len, long n) {
        long ans = 1;
        for (int i = 1; i < len; i++) {
            if (ans * k + 1 > n) return 1;
            ans = ans * k + 1;
        }
        if (ans - n == 0) return 0;
        return ans - n > 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Test01().smallestGoodBase("13"));
    }
}


