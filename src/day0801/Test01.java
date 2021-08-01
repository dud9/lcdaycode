package day0801;

import annotion.Simple;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author liu yicheng
 * @date 2021/8/1 - 15:37
 * 1337. 矩阵中战斗力最弱的 K 行
 */
public class Test01 {
    class Node {
        int idx;
        int val;
        Node (int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    @Simple
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int n = mat.length;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = 0;
            int[] ns = mat[i];
            for (int t : ns) {
                if (t == 0) break;
                num++;
            }
            list.add(new Node(i, num));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(k, (n1, n2) -> {
           if (n1.val == n2.val) return n1.idx - n2.idx;
           else return n1.val - n2.val;
        });
        for (Node node : list) pq.add(node);
        int l = 0;
        while (l < k && !pq.isEmpty()) {
            ans[l++] = pq.poll().idx;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] data = new int[][] {{1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}};
        System.out.println(new Test01().kWeakestRows(data, 3));
    }
}
