package day0727;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liu yicheng
 * @date 2021/7/27 - 13:15
 */
public class BFS {

    /* bfs */
    public int findSecondMinimumValue(Node root) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        bfs(root, set);
        if (set.size() < 2) return -1;
        /* 寻找次小值 */
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i : set) {
            if (i <= first) {
                second = first;
                first = i;
            } else if (i <= second) {
                second = i;
            }
        }
        return second;
    }

    void bfs(Node root, Set<Integer> set) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.addLast(root);
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            set.add(cur.val);
            if (cur.left != null) {
                dq.addLast(cur.left);
                dq.addLast(cur.right);
            }
        }
    }
}

