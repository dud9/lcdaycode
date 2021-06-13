package day0613;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu yicheng
 * @date 2021/6/13 - 9:48
 */
/* 1189. “气球” 的最大数量 */
public class Test02 {
    public int maxNumberOfBalloons(String text) {
        int[] c = new int[26];
        for (char i : text.toCharArray()) {
            c[i - 'a']++;
        }
        c['l' - 'a'] /= 2;
        c['o' - 'a'] /= 2;
        int max = Integer.MAX_VALUE;
        for (char i : "balon".toCharArray()) {
            if (c[i - 'a'] < max) max = c[i - 'a'];
        }
        return max;
    }
}
