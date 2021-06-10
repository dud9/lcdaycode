package day0610;

/**
 * @author liu yicheng
 * @date 2021/6/10 - 18:58
 */
/* 69. x 的平方根 */
public class Test02 {

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l < r) {
            // 考虑溢出
            int mid = l + (r - l) / 2;
            if (mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return ans;
    }
}
