package day0727;

import javax.swing.tree.TreeNode;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liu yicheng
 * @date 2021/7/27 - 9:59
 * 671. 二叉树中第二小的节点
 */
public class Test01 {

    /* dfs */
    public int findSecondMinimumValue(Node root) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        dfs(root, set);
        if (set.size() < 2) return -1;
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

    void dfs(Node root, Set<Integer> set) {
        if (root == null) return;
        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }


}
class Node {

    int val;
    Node left;
    Node right;

    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
