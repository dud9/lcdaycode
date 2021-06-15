package day0615;

/**
 * @author liu yicheng
 * @date 2021/6/15 - 12:52
 */
public class Test01 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            if (arr[j] < arr[i]) return i;
        }
        return -1;
    }

    // 进阶要求O(log(n))的复杂度,必然是使用二分查找
    // 找到最大值即可
    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid - 1] < arr[mid]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
