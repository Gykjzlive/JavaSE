package study.day19;

import java.util.Arrays;
import java.util.Scanner;

public class 金额查错 {
    /*
     * 某财务部门结账时发现总金额不对头。很可能是从明细上漏掉了某1笔或几笔。
     * 如果已知明细账目清单，能通过编程找到漏掉的是哪1笔或几笔吗？
     * 如果有多种可能，则输出所有可能的情况。
     * 我们规定：用户输入的第一行是：有错的总金额。
     * 接下来是一个整数n，表示下面将要输入的明细账目的条数。
     * 再接下来是n行整数，分别表示每笔账目的金额。
     *
     * 要求程序输出：所有可能漏掉的金额组合。每个情况1行。金额按照从小到大排列，中间用空格分开。
     * 比如：
     * 用户输入：
    6
    5
    3
    2
    4
    3
    1
    表明：有错的总金额是6；明细共有5笔。
    此时，程序应该输出：
        1 3 3
        1 2 4
        3 4
        为了方便，不妨假设所有的金额都是整数；每笔金额不超过1000，金额的明细条数不超过100。
     */
    static int q;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int money = s.nextInt();
        int n = s.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = s.nextInt();
        }
        Arrays.sort(data);
        int sum = 0;
        for (int datum : data) {
            sum += datum;
        }
        q = sum - money;
        int array[] = new int[n];
        f(0, data, array, 0);
    }

    private static void f(int cur, int[] data, int[] array, int index) {
        if (cur > q) return;
        if (cur == q) {
            for (int i = 0; i < index; i++) {
                if (array[i] == 1) {
                    System.out.print(data[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        if (index >= data.length) return;
        array[index] = 0;
        f(cur, data, array, index + 1);
        array[index] = 1;
        f(cur + data[index], data, array, index + 1);
        array[index] = 0;
    }


}
