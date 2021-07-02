package day0701;

import com.sun.xml.internal.ws.message.source.PayloadSourceMessage;

/**
 * @author liu yicheng
 * @date 2021/7/1 - 16:34
 */
public class Test03 {

    public int f(int n) {
        int ans = 1;
        while (n > 1) {
            ans *= n;
            n--;
        }
        return ans;
    }

    public int f2(int n) {
        return n == 1 ? 1 : f2(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(new Test03().f2(3));
    }
}
