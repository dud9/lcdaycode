package day0629;

import annotion.Simple;

/**
 * @author liu yicheng
 * @date 2021/6/30 - 19:56
 */
public class Test02 {

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
