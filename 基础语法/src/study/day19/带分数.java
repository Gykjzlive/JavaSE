package study.day19;

import java.util.Scanner;
/*
题目描述：
100  可以表示为带分数的形式：100  =  3  +  69258  /  714。
还可以表示为：100  =  82  +  3546  /  197。
注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
类似这样的带分数，100  有  11  种表示法。
输入：
从标准输入读入一个正整数N  (N< 1000*1000)
输出：
程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
注意：不要求输出每个表示，只统计有多少表示法！
样例输入：
100
样例输出：
11
 */

public class 带分数 {
    static int N, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int data[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        f(data, 0);
        System.out.println(count);
    }

    private static void f(int[] n, int a) {
        if (a == 9) {
            print(n);
        }
        for (int i = a; i < n.length; i++) {
            int temp = n[a];
            n[a] = n[i];
            n[i] = temp;
            f(n, a + 1);
            temp = n[a];
            n[a] = n[i];
            n[i] = temp;
        }
    }

    private static void print(int[] n) {
        for (int i = 1; i < 8; i++) {
            int num = check(n, 0, i);
            if (num >= N) {
                continue;
            }
            for (int j = i + 1; j <= 8; j++) {
                int num1 = check(n, i, j);
                int num2 = check(n, j, n.length);
                if (num1 % num2 == 0 && num + (num1 / num2) == N) {
                    count++;
                }
            }
        }
    }

    private static int check(int[] n, int start, int end) {
        int sum = 0;
        int data = 1;
        for (int i = end - 1; i >= start; i--) {
            sum += n[i] * data;
            data *= 10;
        }
        return sum;
    }
}