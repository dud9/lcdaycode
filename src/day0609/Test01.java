package day0609;

/**
 * @author liu yicheng
 * @date 2021/6/9 - 19:05
 */
/** 879. 盈利计划 **/
public class Test01 {


    /**
     * dp
     * f[i][j][k] 表示前 i 份工作,使用员工数不超过 j,利润不低于 k 的方案数
     **/
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // dfs 爆搜超时~~~
        //return dfs(n, minProfit, group, profit,0,0,0);
        int m = group.length, mod = (int) (1e9+7);
        long[][][] f = new long[m + 1][n + 1][minProfit + 1];
        // 初始化
        // 不选择工作,无论使用多少员工,利润都为0,方案数为1
        for (int i = 0; i <= n; i++) f[0][i][0] = 1;
        for (int i = 1; i <= m; i++) {
            int a = group[i - 1], b = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    // 不完成第 i 份工作
                    f[i][j][k] = f[i - 1][j][k];
                    if (j >= a) {
                        int u = Math.max(k - b, 0);
                        f[i][j][k] += f[i - 1][j - a][u];
                        f[i][j][k] %= mod;
                    }
                }
            }
        }
        return (int) f[m][n][minProfit];
    }

    // 可以使用dfs爆搜,但是超时.

    /**
     * cur--- 当前下标
     * curG --- 当前使用的员工数
     * curP --- 当前的利润
     */
    private int dfs(int n, int minProfit, int[] group, int[] profit, int cur, int curG, int curP) {
        if (cur == group.length) return curG <= n && curP >= minProfit ? 1 : 0;
        if (curG > n) return 0;
        // 完成第 i 份工作
        int lo = dfs(n, minProfit, group, profit, cur + 1, curG + group[cur], curP + profit[cur]);
        // 不完成第 i 份工作
        int hi = dfs(n, minProfit, group, profit, cur + 1, curG, curP);
        return lo + hi;
    }
}
