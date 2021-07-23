package study.day20;

import java.util.Scanner;

/**
 * 给定三个整数数组
 * A = [A1, A2, ... AN],
 * B = [B1, B2, ... BN],
 * C = [C1, C2, ... CN]，
 * <p>
 * 请你统计有多少个三元组(i, j, k) 满足：
 * 1. 1 <= i, j, k <= N
 * 2. Ai < Bj < Ck
 * <p>
 * 【输入格式】
 * 第一行包含一个整数N。
 * 第二行包含N个整数A1, A2, ... AN。
 * 第三行包含N个整数B1, B2, ... BN。
 * 第四行包含N个整数C1, C2, ... CN。
 * <p>
 * 对于30%的数据，1 <= N <= 100
 * 对于60%的数据，1 <= N <= 1000
 * 对于100%的数据，1 <= N <= 100000 0 <= Ai, Bi, Ci <= 100000
 * 【输出格式】
 * 一个整数表示答案
 * 【输入样例】
 * 3
 * 1 1 1
 * 2 2 2
 * 3 3 3
 * 【输出样例】
 * 27
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 */
public class 递增三元组 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    a[j] = s.nextInt();
                } else if (i == 1) {
                    b[j] = s.nextInt();
                } else {
                    c[j] = s.nextInt();
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a_count = 0;
            for (int j = 0; j < n; j++) {
                if (b[i] > a[j]) {
                    a_count++;
                }
            }
            int c_count = 0;
            for (int j = 0; j < n; j++) {
                if (b[i] < c[j]) {
                    c_count++;
                }
            }
            sum += a_count * c_count;
        }
        System.out.println(sum);
    }
}
