package day0704;

import annotion.Simple;

/**
 * @author liu yicheng
 * @date 2021/7/4 - 12:05
 * 645. 错误的集合
 */
public class Test01 {
    @Simple
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 1];
        for (int i : nums) temp[i]++;
        int[] ans = new int[2];
        for (int i = 1; i <= n; i++) {
            if (temp[i] == 0) ans[1] = i;
            if (temp[i] == 2) ans[0] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Test01().findErrorNums(new int[]{1, 2, 2, 4}));
    }

}
