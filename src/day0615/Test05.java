package day0615;

/**
 * @author liu yicheng
 * @date 2021/6/15 - 22:38
 */
public class Test05 {


    public int search (int[] nums, int target) {
        // write code here
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Test05().search(new int[]{1,2,4,4,5},4));
    }

}
