package day0624;

import annotion.Hard;

/**
 * @author liu yicheng
 * @date 2021/6/24 - 13:35
 * 149. 直线上最多的点数
 */
public class Test01 {

    @Hard
    public int maxPoints(int[][] points) {
        int n = points.length;
        int max = 1;
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int num = 2;
                int x2 = points[j][0], y2 = points[j][1];
                for (int k = j + 1; k < n; k++) {
                    int x3 = points[k][0], y3 = points[k][1];
                    int s1 = (y3 - y1) * (x3 - x2), s2 = (y3 - y2) * (x3 - x2);
                    if (s1 == s2) num ++;
                }
                max = Math.max(max, num);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        new Test01().maxPoints(new int[][]{{1,0}, {0,0}});
    }
}
