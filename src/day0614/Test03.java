package day0614;

/**
 * @author liu yicheng
 * @date 2021/6/14 - 10:56
 */
/* 1185. 一周中的第几天 */
public class Test03 {

    // 普通解法
    /*
        由常识可知, 1971年1月1日为星期五, 所以可以以它为基点来计算
     */
    public String dayOfTheWeek(int day, int month, int year) {
        int[] mons = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] sum = new int[13];
        for (int i = 1; i <= 12; i++) sum[i] = sum[i - 1] + mons[i - 1];
        // 需要减去1971年1月1日这天
        int days = (year - 1971) * 365 + sum[month - 1] + day - 1;
        for (int i = 1971; i <= year; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                if (i < year || (year == i && month > 2)) {
                    days ++;
                }
            }
        }
        String[] week = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        int idx = (6 + days) % 7;
        return week[idx];
    }

    /* 公式解法 */
    public String dayOfTheWeek2(int day, int month, int year) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Test03().dayOfTheWeek2(31, 8, 2019));
        System.out.println(new Test03().dayOfTheWeek(31, 8, 2019));
    }
}
