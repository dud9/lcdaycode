package day0616;

/**
 * @author liu yicheng
 * @date 2021/6/16 - 7:34
 * 5. 最长回文子串
 */
public class Test02 {
    /*
    *  Q? 什么是回文串
    *  A: 正着读或者倒着读都表示同一个字符串,它是对称的
    * */
    // DP
    // f[i][j]表示第i个字符到第j个字符是否为回文串
    public String longestPalindrome(String s) {
        int n = s.length();
        // 长度为1,必为回文串,直接返回
        if (n < 2) return s;
        boolean[][] f = new boolean[n][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            f[i][i] = true;
        }
        
        // 记录最长的子串长度和起始位置
        int max = 1, begin = 0;
        // L 为子串长度
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n; i++) {
                // L = j - i + 1
                int j = L + i - 1;  // 右边界
                if (j > n) break;
                if(s.charAt(i) != s.charAt(j)) { // 左右边界不相等,必然不是回文串
                    f[i][j] = false;
                } else {
                    // 是否为  'aa'或者'aba' 即j - i <= 2
                    if (j - i < 3) {
                        f[i][j] = true;
                    } else {
                        f[i][j] = f[i + 1][j - 1];
                    }
                }

                if (f[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}
