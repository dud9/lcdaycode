package day0623;

import annotion.Simple;

/**
 * @author liu yicheng
 * @date 2021/6/23 - 13:17
 *
 * 剑指 Offer 15. 二进制中1的个数
 */
public class Test01 {

    // you need to treat n as an unsigned value
    @Simple
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = n; i != 0; i -= (i & -i)) ans++;
        return ans;
    }
}
