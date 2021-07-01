package day0629;

import annotion.Simple;

/**
 * @author liu yicheng
 * @date 2021/6/29 - 19:49
 */
public class Test01 {

    @Simple
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
