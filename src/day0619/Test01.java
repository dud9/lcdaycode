package day0619;

import annotion.Medium;

import java.beans.beancontext.BeanContext;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liu yicheng
 * @date 2021/6/19 - 11:05
 * 1239. 串联字符串的最大长度
 */
 public class Test01 {

    int ans = 0;
    int n = 0; // 不重复的字符串的个数
    int[] hash;
    public int maxLength(List<String> _ws) {
        // 去除包含重复字符的字符串 例如"hello"
        Set<Integer> set = new HashSet<>();
        for (String s : _ws) {
            int val = 0;
            for (char c : s.toCharArray()) {
                int t = c - 'a';
                // 将该字符对应的数值向右移,如果为1则说明已经存在相同的字符,应该舍去
                if (((val >> t) & 1) != 0 ) {
                    val = -1;
                    break;
                } else {
                    val |= (1 << t);
                }
            }
            if (val != -1) set.add(val);
        }

        // 特殊情况
        n = set.size();
        if (n == 0) return 0;

        hash = new int[n];
        int left = 0, idx = 1;
        // 存入数组
        for (Integer i : set) {
            hash[idx] = i;
            left |= i;
            idx++;
        }
        // 使用回溯
        dfs(0, 0, left);
        return ans;
    }

    // k  当前下标 cur 当前字母个数即(二进制1的个数)  left 剩余的1
    void dfs (int k, int cur, int left) {

        // 剪枝
        if (get(cur | left) <= ans) return; // 如果使用全部剩下的都小于ans,则可以不用执行剩余的情形
        if (k == n)  {
            ans = Math.max(ans, get(cur));
            return;
        }
        // 在可以使用第k的情况下,加上第k个字符串
        if ((hash[k] & cur) == 0) {
            dfs(k + 1, cur | hash[k], left - (left & hash[k]));
        }
        dfs(k + 1, cur, left);
    }

    Map<Integer, Integer> map = new HashMap<>();
    int get(int x) {
        if (map.containsKey(x)) return map.get(x);
        int num = 0;
        for (int i = x; i != 0; i -= (i & -i)) num++;
        map.put(x, num);
        return num;
    }
}
