package day0701;

import annotion.Simple;

import java.util.*;

/**
 * @author liu yicheng
 * @date 2021/7/1 - 12:02
 * LCP 07. 传递信息
 */
public class Test01 {

    Map<Integer, List<Integer>> r = new HashMap<>();
    int n, k;
    int ans;
    @Simple
    public int numWays(int _n, int[][] re, int _k) {
        int m = re.length;
        n = _n;
        k = _k;
        // 整理数据
        for (int i = 0; i < m; i++) {
            int x = re[i][0], y = re[i][1];
            if (r.containsKey(x)) {
                r.get(x).add(y);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(y);
                r.put(x, list);
            }
        }
        if (!r.containsKey(0)) return 0;
        dfs(0, 0);
        return ans;
    }

    /*
     * cur 当前左标
     * u   当前步数
     * ans 当前方案数
     */

    void dfs(int cur, int u) {
        if (u == k) {
            if (cur == n - 1) ans ++;
            else return;
        }
        if (!r.containsKey(cur)) return ;
        List<Integer> li = r.get(cur);
        int s = 0;
        for (int t : li) dfs(t, u + 1);
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        System.out.println(new Test01().numWays(5, data, 3));
    }
}
