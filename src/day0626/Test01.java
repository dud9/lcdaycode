package day0626;

import java.util.*;

/**
 * @author liu yicheng
 * @date 2021/6/26 - 8:51
 */
public class Test01 {

    /*
     *  可以使用双向 BFS
     *  一个向后搜索 一个向前搜索
     *   若是 重合 则为最短距离
     *   与 昨天的 题目 一样的解题思路
     *
     *   需要将 二维 转换成 一维
     *   idx = 3 * x + y
     *   x = idx / 3
     *   y = idx % 3
     *   x 为 「横坐标」 y 为 「纵坐标」
     */

    String s, t;
    public int slidingPuzzle(int[][] board) {
        t = "123450";
        s = "";
        int n = board.length;
        // 转换成字符串
        for (int i = 0; i < n; i++) {
            int m = board[i].length;
            for (int j = 0; j < m; j++) {
                s += board[i][j];
            }
        }
        if (Objects.equals(s, t)) return 0;
        int ans = bfs();
        return ans;
    }

    int bfs() {
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        d1.addLast(s);
        m1.put(s, 0);
        d2.addLast(t);
        m2.put(t,0);

        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            if (d1.size() <= d2.size()) {
                t = update(d1, m1, m2);
            } else {
                t = update(d2, m2, m1);
            }
            if (t != -1) return t;
        }
        return -1;
    }

    int update(Deque<String> dq, Map<String, Integer> cur, Map<String, Integer> other) {
        String poll = dq.pollFirst();
        char[] ch = poll.toCharArray();
        int step = cur.get(poll);

        // 找到 '0' 所在的位置
        int idx = poll.indexOf('0');
        int x = idx / 3;
        int y = idx % 3;

        // 交换 -3  -1 +1 +3 代表 上下左右 交换
        // 需要判断 idx 是否有意义
        for (int j = -3; j <= 3; j += 2) {
            int t = idx + j;
            // 防止 3 -> 4 这种情况 x + 1, y 也 + 1, x, y 一次只能有一个加减一
            int dx = t / 3, dy = t % 3;
            if (dx != x && dy != y) continue;
            if (t > 5 || t < 0) continue; // idx 不合法

            // idx 和 t 所在的字符进行交换
            char[] clone = ch.clone();
            clone[idx] ^= clone[t];
            clone[t] ^= clone[idx];
            clone[idx] ^= clone[t];

            String str = String.valueOf(clone);

            if (cur.containsKey(str)) continue;

            if (other.containsKey(str)) {
                return step + other.get(str) + 1;
            } else {
                dq.addLast(str);
                cur.put(str, step + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] data = new int[][] {{3,2,4},{1,5,0}};
        System.out.println(new Test01().slidingPuzzle(data));
    }
}
