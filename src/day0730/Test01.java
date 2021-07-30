package day0730;

import annotion.Simple;

/**
 * @author liu yicheng
 * @date 2021/7/30 - 22:19
 * 171. Excel 表列序号
 */
public class Test01 {

    @Simple
    public int titleToNumber(String columnTitle) {
        char[] ch = columnTitle.toCharArray();
        int n = ch.length;
        int t = 1, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += (ch[i] - 'A' + 1) * t;
            t *= 26;
        }
        return ans;
    }
}
