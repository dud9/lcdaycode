package day0614;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liu yicheng
 * @date 2021/6/14 - 18:30
 * 1200. 最小绝对差
 */
public class Test04 {

    // 思路:
    /*
        审题,每个元素不一样
        所以可以先排个序,最小绝对差,必然是相邻两个值的差最小
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, min = Integer.MAX_VALUE;
        int[] minus = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int t = Math.abs(arr[i] - arr[i - 1]);
            minus[i] = t;
            min = Math.min(min, t);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (minus[i] == min) {
                List<Integer> list = new ArrayList<>();
                Collections.addAll(list, arr[i - 1], arr[i]);
                ans.add(list);
            }
        }
        return ans;
    }
}
