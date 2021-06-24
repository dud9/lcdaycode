package day0623;

import annotion.Hard;

import java.util.*;

/**
 * @author liu yicheng
 * @date 2021/6/23 - 14:00
 * 32. 最长有效括号
 */
public class Test05 {

    @Hard
    public int longestValidParentheses(String s) {
        char[] ch = s.toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        int ans = 0;
        int max = 0;
        for (char c : ch) {
            if (c == '(') {
                if (!dq.isEmpty()) {
                    if (dq.peek() == '(') {
                        ans = Math.max(ans, max);
                        max = 0;
                    }
                }
                dq.add(c);
            } else {
                if (!dq.isEmpty()) {
                    int t = dq.peek();
                    if (t != '(') {
                        ans = Math.max(ans, max);
                        max = 0;
                    } else {
                        dq.add(c);
                        max += 2;
                        ans = Math.max(ans, max);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1,5,7};
        Arrays.sort(a);
        for (int i : a) {
            System.out.println(i);
        }

    }

    static void change(Integer i) {
        i += 1;
    }

    static void change1(String i) {
        i += 1;
    }
}
