package study.day19;

import java.util.Scanner;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/22 18:48
 */
public class 买不到的数目 {
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
    static int[] array;
    static int min;

    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        n = a * b;
        min = a > b ? b : a;
        array = new int[n];
        f(a, b, n);
    }

    private static void f(int a, int b, int n) {
        for (int i = 0; i <= n / a; i++) {
            for (int j = 0; j <= (n - i * a) / b; j++) {
                if ((i * a) + (j * b) < n) {
                    array[(i * a) + (j * b)] = 1;
                }
            }
        }
        System.out.println(check(a, b));
    }

    private static int check(int a, int b) {
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

}
