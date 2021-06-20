package day0620;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liu yicheng
 * @date 2021/6/20 - 17:36
 * 1600. 皇位继承顺序
 */
public class Test01 {

}

class ThroneInheritance {

    String King;
    List<String> curOrder;
    Map<String, Integer> death = new HashMap<>();
    Map<String, List<String>> map = new HashMap();

    public ThroneInheritance(String kingName) {
        this.King = kingName;
        this.death.put(kingName, 0);
    }

    public void birth(String parentName, String childName) {
        if (map.containsKey(parentName)) {
            List<String> l = map.get(parentName);
            l.add(childName);
            map.put(parentName, l);
        } else {
            List<String> l = new ArrayList<>();
            l.add(childName);
            map.put(parentName, l);
        }
        death.put(childName, 0);
    }

    public void death(String name) {
        death.put(name, 1);
    }

    public List<String> getInheritanceOrder() {
        curOrder = new ArrayList<>();
        if (death.get(King) == 0) {
            curOrder.add(King);
        }
        dfs(King);
        return curOrder;
    }

    void dfs(String cur) {
        if (!map.containsKey(cur)) return;
        List<String> ch = map.get(cur);
        int n = ch.size();
        for (int i = 0; i < n; i++) {
            String name = ch.get(i);
            if (death.get(name) == 0) {
                curOrder.add(name);
            }
            dfs(name);
        }
    }
}
