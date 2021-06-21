package day0621;

import annotion.Simple;
import com.sun.xml.internal.ws.api.ha.HaInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liu yicheng
 * @date 2021/6/21 - 12:37
 * 401. 二进制手表
 */
public class Test01 {

    static Map<Integer, List<String>> map = new HashMap<>();

    static {
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 59; j++) {
                int m = getNums(i), n = getNums(j);
                int tot = m + n;
                List<String> l = map.getOrDefault(tot, new ArrayList<>());
                l.add(i + ":" + (j <= 9 ? "0" + j : j));
                map.put(tot, l);
            }
        }
    }

    static int getNums(int x) {
        int ans = 0;
        for (int i = x; i != 0; i -= lowbit(i)) ans++;
        return ans;
    }
    static int lowbit(int x) {
        return x & -x;
    }
    @Simple
    public List<String> readBinaryWatch(int t) {
        return Test01.map.getOrDefault(t, new ArrayList<>());
    }
}
