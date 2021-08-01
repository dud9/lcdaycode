package day0801;

import java.util.PriorityQueue;

/**
 * @author liu yicheng
 * @date 2021/8/1 - 16:00
 */
public class Test02 {
    /* 在使用优先队列的情况下，加上二分来统计每行的战力 */
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
           if (a[0] != b[0]) return b[0] - a[0];
           return b[1] - a[1];
        });
        for (int i = 0; i < n; i++) {
            int l = 0, r = mat[i].length - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (mat[i][mid] >= 1) l = mid;
                else r = mid - 1;
            }
            int cur = mat[i][r] >= 1 ? r + 1 : r;
            if (pq.size() == k && pq.peek()[0] > cur) pq.poll();
            if (pq.size() < k) pq.add(new int[] {cur, i});
        }
        int[] ans = new int[k];
        int t = k - 1;
        while (!pq.isEmpty()) {
            ans[t--] = pq.poll()[1];
        }
        return ans;

    }

    public static void main(String[] args) {
        int[][] t = new int[1][1];
        t[0] = new int[] {2,3,4};
        t[1] = new int[] {2,4};
        for (int[] ints : t) {
            System.out.println(ints.length);
        }
    }
}
