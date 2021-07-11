package day0710;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liu yicheng
 * @date 2021/7/11 - 14:13
 */
public class Test01 {

    class Node {
        String k, v;
        int t;
        Node(String _k, String _v, int _t) {
            k = _k;
            v = _v;
            t = _t;
        }
    }

    Map<String, List<Node>> map = new HashMap<>();
    public void set(String key, String value, int timestamp) {
        List<Node> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Node(key, value, timestamp));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<Node> list = map.getOrDefault(key, new ArrayList<>());
        if (list.isEmpty()) return "";
        int n = list.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (list.get(mid).t <= timestamp) l = mid;
            else r = mid - 1;
        }
        return list.get(r).t <= timestamp ? list.get(r).v : "";
    }

}
