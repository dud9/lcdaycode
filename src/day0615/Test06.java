package day0615;

import java.util.*;

/**
 * @author liu yicheng
 * @date 2021/6/15 - 22:45
 */
public class Test06 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int n = input.length;
        if (k > n || k <= 0) return new ArrayList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (x, y) -> y - x);
        for (int i = 0; i < k; i++) pq.add(input[i]);
        for (int i = k; i < n; i++) {
            int cur = input[i];
            if (pq.peek() > cur) {
                pq.poll();
                pq.add(cur);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) ans.add(pq.poll());
        Collections.reverse(ans);
        return ans;
    }
}
