package day0711;

/**
 * @author liu yicheng
 * @date 2021/7/11 - 18:56
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Test02 {

    public int[] searchRange(int[] ns, int t) {
        int[] ans = {-1, -1};
        int n = ns.length;
        if (n == 0) return ans;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (ns[mid] >= t) r = mid;
            else l = mid + 1;
        }
        if (ns[l] != t) {
            return ans;
        } else {
            ans[0] = l;
            l = 0; r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (ns[mid] <= t) l = mid;
                else r = mid - 1;
            }
            ans[1] = r;
            return ans;
        }
    }
}
