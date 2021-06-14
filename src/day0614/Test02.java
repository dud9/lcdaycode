package day0614;

/**
 * @author liu yicheng
 * @date 2021/6/14 - 10:06
 */
/* 1154. 一年中的第几天 */
public class Test02 {
    public int dayOfYear(String date) {
        int[] mons = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(date.substring(0, date.indexOf('-')));
        int month = Integer.parseInt(date.substring(date.indexOf('-') + 1, date.lastIndexOf('-')));
        int days = Integer.parseInt(date.substring(date.lastIndexOf('-') + 1));
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            mons[1] = 29;
        }
        // 计算前缀和
        int[] sum = new int[13];
        for (int i = 1; i <= 12; i++) sum[i] = sum[i - 1] +  mons[i - 1];
        return sum[month - 1] + days;
    }

    public static void main(String[] args) {
        System.out.println(new Test02().dayOfYear("2019-01-09"));
    }
}
