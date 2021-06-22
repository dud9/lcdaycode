package day0622;

import annotion.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liu yicheng
 * @date 2021/6/22 - 12:11
 * 剑指 Offer 38. 字符串的排列
 */
public class Test01 {
    int N = 10;  // s 的长度不超过 10
    boolean[] isChoosed = new boolean[N];
    Set<String> set = new HashSet<>();
    @Medium
    public String[] permutation(String s) {
        Arrays.fill(isChoosed, false);
        char[] ch = s.toCharArray();
        dfs(ch, 0, "");
        int n = set.size();
        String[] ans = new String[n];
        int idx = 0;
        for (String str : set) ans[idx++] = str;
        return ans;
    }

    /*
     *  ch s的字符数组
     *  u  当前下标
     *  cur 当前拼接成的字符串
     */
    void dfs(char[] ch, int u, String cur) {
        // 结束条件
        int n = ch.length;
        if (u == n) {
            set.add(cur);
            return;
        }
        // 选择字符添加到 cur 中
        for (int i = 0; i < n; i++) {
            if (!isChoosed[i]) {   // 如果没有选择过
                isChoosed[i] = true;
                dfs(ch, u + 1, cur + String.valueOf(ch[i]));
                System.out.println(cur);
                isChoosed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String test = "ansd";
        System.out.println(new Test01().permutation(test));
    }
}
