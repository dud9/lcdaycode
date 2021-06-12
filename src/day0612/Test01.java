package day0612;

import java.util.Arrays;

/**
 * @author liu yicheng
 * @date 2021/6/12 - 13:13
 */
/* 1449. 数位成本和为目标值的最大数字 */
public class Test01 {

    /*
        理解题意:
        即每次从1~9里选一个数位,使得凑成的值最大,并且所有数位的价值总和为target
        DP :
        f[i][j] 前i个数位中价值为j的的最大数值
        状态转移方程为:
            f[i][j] = Math.max(f[i - 1][j], f[i -1][j - k * cur] + k * i)
     */
    public String largestNumber(int[] cost, int t) {
        int[] f = new int[t + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        f[0] = 0;
        for (int i = 1; i <= 9; i++) {
            int u = cost[i - 1];
            for (int j = u; j <= t; j++) {
                f[j] = Math.max(f[j], f[j - u] + 1);
            }
        }
        if (f[t] < 0) return "0";
        String ans = "";
        for (int i = 9, j = t; i >= 1; i--) {
            int u = cost[i - 1];
            while (j >= u && f[j] == f[j - u] + 1) {
                ans += String.valueOf(i);
                j -= u;
            }
        }
        return ans;
    }
}
