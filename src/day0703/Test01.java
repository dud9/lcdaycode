package day0703;

import annotion.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author liu yicheng
 * @date 2021/7/3 - 12:19
 * 451. 根据字符出现频率排序
 */
public class Test01 {

    @Medium
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int n = s.length();
        PriorityQueue<Map.Entry> pq = new PriorityQueue<>(n, (x, y) -> (int) y.getValue() - (int) x.getValue());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry poll = pq.poll();
            char a = (char) poll.getKey();
            int b = (int) poll.getValue();
            for (int i = 0; i < b; i++) sb.append(a);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Test01().frequencySort("trrasrrss"));
    }

    class Solution {
        public String frequencySort(String s) {
            int[][] cnts = new int[128][2];
            char[] cs = s.toCharArray();
            for (int i = 0; i < 128; i++) cnts[i][0] = i;
            for (char c : cs) cnts[c][1]++;
            Arrays.sort(cnts, (a, b)->{
                if (a[1] != b[1]) return b[1] - a[1];
                return a[0] - b[0];
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 128; i++) {
                char c = (char)cnts[i][0];
                int k = cnts[i][1];
                while (k-- > 0) sb.append(c);
            }
            return sb.toString();
        }
    }
    class Node {
        char c;
        int v;
        Node(char _c, int _v) {
            c = _c; v = _v;
        }
    }
    public String frequencySort2(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Node> q = new PriorityQueue<>((a,b)->{
            if (b.v != a.v) return b.v - a.v;
            return a.c - b.c;
        });
        for (char c : map.keySet()) {
            q.add(new Node(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int k = poll.v;
            while (k-- > 0) sb.append(poll.c);
        }
        return sb.toString();
    }

}
