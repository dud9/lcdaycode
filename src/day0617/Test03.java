package day0617;

import java.util.Scanner;

/**
 * @author liu yicheng
 * @date 2021/6/17 - 23:26
 */
public class Test03 {

    public static void main(String[] args) {
        int i = 0;
        String str = null;
        Character ch = null;
        while (i < 2) {
            Scanner scan = new Scanner(System.in);
            if (i == 0) {
                 str = scan.nextLine();
            } else {
                ch = scan.next().charAt(0);
            }
        }
        if (str == null || ch == null) return;
        int ans = 0, n = str.length();
        for (int j = 0; j < n; j++) {
            if (ch.equals(str.charAt(j))) ans++;
        }
        System.out.println(ans);
    }
}
