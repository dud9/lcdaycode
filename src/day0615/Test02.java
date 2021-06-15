package day0615;

/**
 * @author liu yicheng
 * @date 2021/6/15 - 19:52
 * 1281. 整数的各位积和之差
 */
public class Test02 {

    public int subtractProductAndSum(int n) {
        int sum = 0, mul = 1;
        while (n != 0) {
            sum += (n % 10);
            mul *= (n % 10);
            n /= 10;
        }
        return mul - sum;
    }

    public static void main(String[] args) {
        System.out.println(new Test02().subtractProductAndSum(234));
    }
}
