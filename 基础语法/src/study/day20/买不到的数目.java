package study.day20;


import java.util.Scanner;

/**
 * 题目描述
 * 小明开了一家糖果店。他别出心裁：把水果糖包成4颗一包和7颗一包的两种。糖果不能拆包卖。
 * 小朋友来买糖的时候，他就用这两种包装来组合。当然有些糖果数目是无法组合出来的，比如要买  10  颗糖。
 * 你可以用计算机测试一下，在这种包装情况下，最大不能买到的数量是17。大于17的任何数字都可以用4和7组合出来。
 * 本题的要求就是在已知两个包装的数量时，求最大不能组合出的数字。
 * 输入
 * 两个正整数，表示每种包装中糖的颗数(都不多于1000)
 * 输出
 * 一个正整数，表示最大不能买到的糖数
 * 样例输入
 * 4 7
 * 样例输出
 * 17
 */
public class 买不到的数目 {
    static int min;
    static int[] array;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, m, max;
        n = s.nextInt();
        m = s.nextInt();
        min = n <= m ? n : m;
        max = n * m;
        array = new int[max];
        f(n, m, max);
    }

    private static int lookInto() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                count++;
                if (count >= min) {
                    return i - min;
                }
            } else {
                count = 0;
            }
        }
        return -1;
    }

    private static void f(int n, int m, int max) {

        for (int i = 0; i * n < max; i++) {
            for (int j = 0; i * n + j * m < max; j++) {
                array[(i * n) + (j * m)] = 1;
            }
        }
        System.out.println(lookInto());
    }
}
