package day0701;

/**
 * @author liu yicheng
 * @date 2021/7/1 - 17:30
 */
public class Test06 {

    public static void main(String[] args) {
         new Test06().print("he say hello");
    }

    public void print(String s) {
        String[] res = s.split(" ");
        int n = res.length - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 0; i--) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb.toString().substring(0, sb.lastIndexOf(" ")));
    }

    public void print2() {

    }
}
