package day0623;

import annotion.Simple;

import java.util.*;

/**
 * @author liu yicheng
 * @date 2021/6/23 - 13:20
 * 20. 有效的括号
 */
public class Test02 {

    @Simple
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                dq.add(c);
            } else { // 如果是右括号, 就弹出最后的元素进行比较
                if (dq.isEmpty()) return false;
                char t = dq.pollLast();
                if (map.get(c) != t) return false;
            }
        }
        return dq.isEmpty() ? true : false;
    }
}
