package day0615;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu yicheng
 * @date 2021/6/15 - 22:13
 */
public class Test04 {
    public String getVal(String key, String str) {

        char[] encKey = enc(key);
        StringBuilder ans = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c < 97) {
                char t = encKey[c + 22 - 97];
                ans.append(t - 22);
            }
            else {
                ans.append(encKey[c - 97]);
            }
        }
        return ans.toString();
    }

    // 返回小写的密码数组
    public char[] enc(String key) {
        int n = key.length();
        char[] encKey = new char[26];
        List<Character> list = new ArrayList<>();
        char[] c = key.toCharArray();
        for (char x : c) {
            if (!list.contains(x)) list.add(x);
        }
        for (int i = 97; i <= 122; i ++) {
            if (!list.contains((char) i)) list.add((char) i);
        }
        for (int i = 0; i < 26; i ++) {
            encKey[i] = list.get(i);
        }
        return encKey;
    }

    public static void main(String[] args) {
        System.out.println(new Test04().getVal("nihao", "ni"));
    }
}
