package day0608;

/**
 * @author liu yicheng
 * @date 2021/6/8 - 20:57
 */
public class Test01 {

    /* 剑指 Offer 39. 数组中出现次数超过一半的数字 */
    public int majorityElement(int[] nums) {
        int votes = 0, x = 0;
        for (int i : nums) {
            if (votes == 0) x = i;
            votes += i == x ? 1 : -1;
        }
        return x;
    }

}
