package day0613;

/**
 * @author liu yicheng
 * @date 2021/6/13 - 2:28
 */
/* 278. 第一个错误的版本 */
public class Test01 {
    // 二分查找
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    boolean isBadVersion(int version) {
        return true;
    }

}
