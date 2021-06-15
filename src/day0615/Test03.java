package day0615;

/**
 * @author liu yicheng
 * @date 2021/6/15 - 20:02
 * 1668. 最大重复子字符串
 */
public class Test03 {
    /* 理解题意,就是求sequence中对多有多少连续的word*/
    public int maxRepeating(String sequence, String word) {
        if (!sequence.contains(word)) return 0;
        int m = sequence.length(), n = word.length();
        int k = 1;
        String s = word + word;
        while ((k + 1) * n <= m && sequence.contains(s)) {
            s += word;
            k ++;
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(new Test03().maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba",
                "aaaba"));
    }
}
