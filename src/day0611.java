import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liu yicheng
 * @date 2021/6/11 - 20:01
 */
/* 279. 完全平方数 */
public class day0611 {

    /* dp */
    int INF = 0x3f3f3f3f;
    public int numSquares(int n) {
        // 首先找出所有小于等于 n 的所有完全平方数
        List<Integer> list = new ArrayList<>();
        int x = 1;
        while (x * x <= n) {
            list.add(x * x);
            x++;
        }
        int m = list.size();
        int[][] f = new int[m + 1][n + 1];
        // 考虑第一个平方数
        int t = list.get(0);
        for (int i = 0; i <= n; i++) {
            int k = i / t;
            if (k * t == i) {
                f[0][i] = k;
            }
            else {
                f[0][i] = INF;
            }
        }
        for (int i = 1; i < m; i++) {
            int cur = list.get(i);
            for (int j = 0; j <= n; j++) {
                // 不使用第 i 个平方数
                f[i][j] = f[i - 1][j];
                if (j >= cur) {
                    for (int k = 1; k * cur <= j; k++) {
                        if (f[i - 1][j - k * cur] != INF) {
                            f[i][j] = Math.min(f[i][j], f[i - 1][j - k * cur] + k);
                        }
                    }
                }
            }
        }
        return f[m - 1][n];
    }

    /* 一维优化 */
    public int numSquares2(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            int x = i * i;
            for (int j = x; j <= n; j++) {
                f[j] = Math.min(f[j], f[j - x] + 1);
            }
        }
        return f[n];
    }
}

