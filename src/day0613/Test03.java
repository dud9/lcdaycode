package day0613;

/**
 * @author liu yicheng
 * @date 2021/6/13 - 10:08
 */
/* 1252. 奇数值单元格的数目 */
public class Test03 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] f = new int[m][n];
        for (int[] i : indices) {
            int x = i[0], y = i[1];
            for (int j = 0; j < f[x].length; j++) f[x][j]++;
            for (int[] k : f) k[y]++;
        }
        int ans = 0;
        for (int[] x : f) {
            for (int y : x) {
                if ((y & 1) == 1) ans ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] t = new int[][] {{0,1},{1,1}};
        System.out.println(new Test03().oddCells(2, 3, t));
    }
}
