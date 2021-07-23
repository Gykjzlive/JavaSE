package study.day19;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/23 17:49
 */
public class 日期问题 {
    /**
     * 小明正在整理一批历史文献。这些历史文献中出现了很多日期。小明知道这些日期都在1960年1月1日至2059年12月31日。令小明头疼的是，这些日期采用的格式非常不统一，有采用年/月/日的，有采用月/日/年的，还有采用日/月/年的。更加麻烦的是，年份也都省略了前两位，使得文献上的一个日期，存在很多可能的日期与其对应。
     * 比如02/03/04，可能是2002年03月04日、2004年02月03日或2004年03月02日。
     * 给出一个文献上的日期，你能帮助小明判断有哪些可能的日期对其对应吗？
     * 【输入格式】
     * 一个日期，格式是"AA/BB/CC"。 (0 ≤ A, B, C ≤ 9)
     * 【输入格式】
     * 输出若干个不相同的日期，每个日期一行，格式是"yyyy-MM-dd"。多个日期按从早到晚排列。
     * 【样例输入】
     * 02/03/04
     * 【样例输出】
     * 2002-03-04
     * 2004-02-03
     * 2004-03-02
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        int[] array = new int[3];
        String[] c = a.split("/");
        String[] d = new String[3];
        for (int i = 0; i < 3; i++) {
            array[i] = Integer.parseInt(c[i]);
        }
        int count = 0;
        if (array[0] >= 60 || array[2] >= 60) {
            if (array[0] >= 60) {
                System.out.println("19" + array[0] + "-" + (array[1] < 10 ? "0" + array[1] : "" + array[1]) + "-" + (array[2] < 10 ? "0" + array[2] : "" + array[2]));
            } else if (array[2] >= 60) {
                d[0] = "19" + array[2] + "-" + (array[0] < 10 ? "0" + array[0] : "" + array[0]) + "-" + (array[1] < 10 ? "0" + array[1] : "" + array[1]);
                d[1] = "19" + array[2] + "-" + (array[1] < 10 ? "0" + array[1] : "" + array[1]) + "-" + (array[0] < 10 ? "0" + array[0] : "" + array[0]);
                count = 2;
            }
        } else {
            d[0] = "20" + (array[0] < 10 ? "0" + array[0] : array[0]) + "-" + (array[1] < 10 ? "0" + array[1] : "" + array[1]) + "-" + (array[2] < 10 ? "0" + array[2] : "" + array[2]);
            d[1] = "20" + (array[2] < 10 ? "0" + array[2] : array[2]) + "-" + (array[1] < 10 ? "0" + array[1] : "" + array[1]) + "-" + (array[0] < 10 ? "0" + array[0] : "" + array[0]);
            d[2] = "20" + (array[2] < 10 ? "0" + array[2] : array[2]) + "-" + (array[0] < 10 ? "0" + array[0] : "" + array[0]) + "-" + (array[1] < 10 ? "0" + array[1] : "" + array[1]);
        }
        System.out.println(d[0].compareTo(d[1]));
    }
}
