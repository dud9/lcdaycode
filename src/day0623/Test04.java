package day0623;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

/**
 * @author liu yicheng
 * @date 2021/6/23 - 13:56
 * 217. 存在重复元素
 */
public class Test04 {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) return false;
            map.put(n, 1);
        }
        return true;
    }
}


