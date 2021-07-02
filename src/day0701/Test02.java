package day0701;

import java.util.*;

/**
 * @author liu yicheng
 * @date 2021/7/1 - 14:19
 * LCP 07. 传递信息
 */
public class Test02 {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    public int numWays(int n, int[][] re, int k) {
        for (int i = 0; i < re.length; i++) {
            int a = re[i][0], b = re[i][1];
            Set<Integer> s = map.getOrDefault(a, new HashSet<>());
            s.add(b);
            map.put(a, s);
        }
        int ans = bfs(n, k);
        return ans;
    }

    int bfs(int n, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(0);
        while (!dq.isEmpty() && k-- > 0) {
            int size = dq.size();
            while (size-- > 0) {
                int poll = dq.pollFirst();
                if (!map.containsKey(poll)) continue;
                Set<Integer> set = map.get(poll);
                for (Integer t : set) {
                    dq.addLast(t);
                }
            }
        }
        int ans = 0;
        while (!dq.isEmpty()) {
            int t = dq.pollFirst();
            if (t == n - 1) ans ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        System.out.println(new Test02().numWays(5, data, 3));
    }
}
