package day0609;

/**
 * @author liu yicheng
 * @date 2021/6/9 - 19:46
 */

import java.util.HashMap;
import java.util.Map;

/** 1160. 拼写单词 **/
public class Test02 {

    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for (String s : words) {
            if (s.length() > chars.length()) continue;
            Map<Character, Integer> cur = new HashMap<>();
            for (char c : s.toCharArray()) cur.put(c, cur.getOrDefault(c, 0) + 1);
            if (check(map, cur))  ans += s.length();
        }
        return ans;
    }

    private boolean check(Map<Character, Integer> map, Map<Character, Integer> cur) {
        if (cur.size() > map.size()) return false;
        for (Character c : cur.keySet()) {
            if(!map.containsKey(c)) return false;
            if (cur.get(c) > map.get(c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] data = new String[] {"cat","bt","hat","tree"};
        System.out.println(new Test02().countCharacters(data, "atach"));
    }
}
