package day0617;

import java.util.Scanner;

/**
 * @author liu yicheng
 * @date 2021/6/17 - 23:19
 */
public class Test02 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] words = s.split(" ");
        System.out.println(words[words.length - 1].length());
    }
}
