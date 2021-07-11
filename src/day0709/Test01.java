package day0709;

import annotion.Simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu yicheng
 * @date 2021/7/9 - 14:49
 * 面试题 17.10. 主要元素
 */
public class Test01 {

    @Simple
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
           map.put(num, map.getOrDefault(num, 0) + 1);
           if (map.get(num) > n / 2) return num;
        }
        return -1;
    }

    // 摩尔投票
    /*
     *
     * 摩尔投票 ：在集合中寻找可能存在的多数元素，这一元素在输入的序列重复出现并占到了序列元素的一半以上；
     * 在第一遍遍历之后应该再进行一个遍历以统计第一次算法遍历的结果出现次数，确定其是否为众数；
     * 如果一个序列中没有占到多数的元素，那么第一次的结果就可能是无效的随机元素。
     * 换句话说，每次将两个不同的元素进行「抵消」，如果最后有元素剩余，则「可能」为元素个数大于总数一半的那个。
     */
    public int majorityElement2(int[] nums) {
        int n = nums.length;
        int x = -1, cnt = 0;
        for (int i : nums) {
            if (cnt == 0) {
                x = i;
                cnt = 1;
            } else {
                cnt += i == x ? 1 : -1;
            }
        }
        cnt = 0;
        for (int i : nums) if (x == i) cnt++;
        return (cnt > n / 2) ? x : -1;
    }
}
