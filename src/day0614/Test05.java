package day0614;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liu yicheng
 * @date 2021/6/14 - 18:56
 * 1207. 独一无二的出现次数
 */
public class Test05 {
    // 思路:
    /*
        使用哈希表统计每个数字出现的次数,再比较次数有没有重复
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        // 使用Set来比较有没有重复
        Set<Integer> set = new HashSet<>();
        for (Integer v : map.values()) set.add(v);
        return map.size() == set.size();
    }
}
