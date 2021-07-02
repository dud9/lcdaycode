package day0701;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu yicheng
 * @date 2021/7/1 - 16:52
 */
public class Test04 {

    public static void main(String[] args) {
        System.out.println(new Test04().find("add222dsaaads21"));
    }

    public char find(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (!map.containsKey(c)) map.put(c, 1);
            else {
                int num = map.get(c);
                int m = c - 'a', n = c - 'A';
                if (num == 2 && (m >= 0 && m <= 25) || (n >= 0 && n <= 25)) {
                    return c;
                }
                map.put(c, num + 1);
            }
        }
        return '0';
    }


}
