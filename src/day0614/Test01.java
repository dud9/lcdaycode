package day0614;

/**
 * @author liu yicheng
 * @date 2021/6/14 - 0:17
 */
/* 374. 猜数字大小 */
public class Test01 {
    int target = 6;
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            // 防止溢出
            int mid = lo + (hi - lo) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == - 1) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    int guess(int num) {
        return num == target ? 0 : num > target ? 1 : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Test01().guessNumber(10));
    }
}
