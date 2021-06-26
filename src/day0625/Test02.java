package day0625;

import java.util.*;

/**
 * @author liu yicheng
 * @date 2021/6/26 - 15:48
 */
public class Test02 {
    // 存放死亡数字
    Set<String> set;
    public int openLock(String[] ds, String target) {
        // 双向 bfs 定义 「起点」和「终点」
        String s = "0000", t = target;
        if (Objects.equals(t, s)) return 0;

        set = new HashSet<>();
        for (String d : ds) set.add(d);
        if (set.contains(t)) return -1;

        // 定义两个队列 分别 从头 和 从尾 开始寻找
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        d1.addLast(s);
        d2.addLast(t);
        // 存放到达该字符串,需要的步数
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        m1.put(s, 0);
        m2.put(t, 0);
        int ans = bfs(d1, d2, m1, m2);
        return ans;
    }

    int bfs(Deque<String> d1, Deque<String> d2, Map<String, Integer> m1, Map<String, Integer> m2) {

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
        int step = cur.get(poll);
        char[] ch = poll.toCharArray();

        // 翻转哪个字符
        for (int i = 0; i < 4; i++) {
            // 正向 转 还是 反向 转
            for (int j = -1; j <= 1; j++) {
                if (j == 0) continue;

                int origin = ch[i] - '0';
                int next = (origin + j) % 10;
                if (next == -1) next = 9;

                char[] clone = ch.clone();
                clone[i] = (char) (next + '0');

                String str = String.valueOf(clone);

                if (set.contains(str)) continue;
                if (cur.containsKey(str)) continue;

                if (other.containsKey(str)) {
                    return step + other.get(str) + 1;
                } else {
                    dq.addLast(str);
                    cur.put(str, step + 1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] ds = {"0201","0101","0102","1212","2002"};
        System.out.println(new Test02().openLock(ds, "0202"));
    }
}
