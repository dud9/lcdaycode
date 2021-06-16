package day0616;

import day0615.Test05;

/**
 * @author liu yicheng
 * @date 2021/6/16 - 7:27
 * 877. 石子游戏
 */
public class Test01 {
    /*
    * 分析:
    *       每次拿一个,比大小
    *       我只需要计算亚历克斯的n/2次  看总和是否超过 sum/2
    *       注意每次从头或者尾取;
    *       可以使用双指针
    * */
    public boolean stoneGame(int[] p) {
        int n = p.length, k = n >> 1, sum = 0;
        for (int i : p) sum += i;
        int l = 0, r = n - 1;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            // 亚历克斯选
            if (p[l] >= p[r]) {
                ans += p[l];
                l++;
            } else {
                ans += p[r];
                r--;
            }
            // 李每次选小的
            if (p[l] <= p[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans > (sum / 2);
    }

    public static void main(String[] args) {
        int[] data = {3,4,20,10,4,2,2,6,12,2,14,11,19,19,10,1,6,9,6,15};
        System.out.println(new Test01().stoneGame(data));
    }
}
