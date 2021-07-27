package day0712;

/**
 * @author liu yicheng
 * @date 2021/7/12 - 21:45
 * 275. H 指数 II
 */
public class Test02 {


    public int hIndex(int[] cs) {
        int n = cs.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (cs[mid] >= n - mid) r = mid;
            else l = mid + 1;
        }
        return cs[r] >= n - r ? n - r : 0;
    }

}
