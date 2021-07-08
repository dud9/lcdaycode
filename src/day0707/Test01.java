package day0707;

/**
 * @author liu yicheng
 * @date 2021/7/7 - 10:47
 * 1711. 大餐计数
 * 超时
 */
public class Test01 {
    int MOD = (int) 1e9+7;
    public int countPairs(int[] deliciousness) {
        int n = deliciousness.length, ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = deliciousness[i], b = deliciousness[j];
                long c = a + b;
                if (check(c)) ans++;
            }
        }
        return ans % MOD;
    }

    private boolean check(long t) {
        return t == 0 ? false : t == (t & -t) ? true : false;
    }

    public static void main(String[] args) {
        int[] data = {2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,
                0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468};
        System.out.println(new Test01().countPairs(data));
    }
}
