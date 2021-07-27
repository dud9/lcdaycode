package day0727;

import javax.swing.tree.TreeNode;

/**
 * @author liu yicheng
 * @date 2021/7/27 - 13:26
 * 优化
 */
public class Better {

    int ans = -1;
    public int findSecondMinimumValue(Node root) {
        dfs(root, root.val);
        return ans;
    }

    void dfs(Node root, int cur) {
        if (root == null) return;
        if (root.val != cur) {
            if (ans == -1) ans = root.val;
            else ans = Math.min(ans, root.val);
            return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}
