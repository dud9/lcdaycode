package day0623;

import annotion.Simple;

/**
 * @author liu yicheng
 * @date 2021/6/23 - 13:48
 * 806. 写字符串需要的行数
 */
public class Test03 {

    @Simple
    public int[] numberOfLines(int[] w, String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int sum = 0, lines = 1;
        for (int i = 0; i < n; i++) {
            int idx = ch[i] - 'a';
            if (sum + w[idx] > 100) {
                lines++;
                sum = w[idx];
            } else {
                sum += w[idx];
            }
        }
        return new int[] {lines, sum};
    }
}


