package day0727;

import javax.swing.tree.TreeNode;

/**
 * @author liu yicheng
 * @date 2021/7/27 - 9:59
 * 671. 二叉树中第二小的节点
 */
public class Test01 {

    public int findSecondMinimumValue(Node root) {
        int ans = 0;
        return 0;
    }


}
class Node {

    int val;
    TreeNode left;
    TreeNode right;

    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
