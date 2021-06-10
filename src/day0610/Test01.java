package day0610;

/**
 * @author liu yicheng
 * @date 2021/6/10 - 18:27
 */
/* 518. 零钱兑换 II */
public class Test01 {
    // dp
    // f[i][j] 表示 前 i 种硬币, 和为 j 的方案数
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        // 初始化
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int cur = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                // 不使用第 i 种硬币
                f[i][j] = f[i - 1][j];
                // 使用
                for (int k = 1; k * cur <= j; k++) {
                    f[i][j] += f[i - 1][j - k * cur];
                }
            }
        }
        return f[n][amount];
    }

    /* 一维 DP*/
    public int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int cur = coins[i - 1];
            for (int j = cur; j <= amount; j++) {
                f[j] += f[j - cur];
            }
        }
        return f[amount];
    }


    public static void main(String[] args) {
        System.out.println(new Test01().change(5, new int[]{1, 2, 5}));
    }
}
