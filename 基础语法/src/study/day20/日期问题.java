package study.day20;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 小明正在整理一批历史文献。这些历史文献中出现了很多日期。小明知道这些日期都在1960年1月1日至2059年12月31日。令小明头疼的是，这些日期采用的格式非常不统一，有采用年/月/日的，有采用月/日/年的，还有采用日/月/年的。更加麻烦的是，年份也都省略了前两位，使得文献上的一个日期，存在很多可能的日期与其对应。
 * <p>
 * 比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。
 * <p>
 * 给出一个文献上的日期，你能帮助小明判断有哪些可能的日期对其对应吗？
 * <p>
 * 输入
 * ----
 * 一个日期，格式是"AA/BB/CC"。  (0 <= A, B, C <= 9)
 * <p>
 * 输入
 * ----
 * 输出若干个不相同的日期，每个日期一行，格式是"yyyy-MM-dd"。多个日期按从早到晚排列。
 * <p>
 * 样例输入
 * ----
 * 02/03/04
 * <p>
 * 样例输出
 * ----
 * 2002-03-04
 * 2004-02-03
 * 2004-03-02
 */
public class 日期问题 {
    public static void main(String[] args) {
        Set set = new TreeSet();
        Scanner s = new Scanner(System.in);
        String data = s.next();
        String[] a = data.split("/");
        int[] b = new int[3];
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.parseInt(a[i]);
        }
        if (b[0] <= 59) {
            f(b[0], b[1], b[2]);
            f(b[2], b[0], b[1]);
            f(b[2], b[1], b[0]);
        } else {
            f(b[0], b[1], b[2]);
        }
    }

    private static void f(int num1, int num2, int num3) {
        int a = num1;
        int b = num2;
        int c = num3;
        String a_str = "";
        String b_str = "";
        String c_str = "";
        if (a <= 59) {
            a_str = len(a) == 1 ? "200" + a : "20" + a;
        } else {
            a_str = "19" + a;
        }
        b_str = len(b) == 1 ? "0" + b : "" + b;
        c_str = len(c) == 1 ? "0" + c : "" + c;
        System.out.println(a_str + "-" + b_str + "-" + c_str);
    }

    private static int len(int a) {
        if (a < 10) {
            return 1;
        }
        return len(a / 10) + 1;
    }
}
