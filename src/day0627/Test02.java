package day0627;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liu yicheng
 * @date 2021/6/27 - 12:37
 */
public class Test02 {

    int n;
    int[] nums;
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        nums = new int[n * n + 1];

        if (board[0][0] != -1) return -1;
        boolean isRight = true;
        // 二维 转换成 一维
        for (int i = n - 1, idx = 1; i >= 0; i--) {
            for (int j = isRight ? 0 : n - 1; isRight ? j < n : j >= 0; j += isRight ? 1 : -1) {
                nums[idx++] = board[i][j];
            }
            isRight = !isRight;
        }

        int ans = bfs();
        return ans;
    }

    int bfs() {
        Deque<Integer> dq = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        dq.addLast(1);
        map.put(1, 0);

        while (!dq.isEmpty()) {
            int poll = dq.pollFirst();
            int step = map.get(poll);
            if (poll == n * n) return step;

            for (int i = 1; i <= 6; i++) {
                int cp = poll + i;
                if (cp <= 0 || cp > n * n) continue;
                if (nums[cp] != -1) cp = nums[cp];
                if (map.containsKey(cp)) continue;
                dq.addLast(cp);
                map.put(cp, step + 1);
            }
        }
        return -1;
    }
}
