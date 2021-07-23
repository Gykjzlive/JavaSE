package study.day19;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/29 22:14
 */
public class 递增三元组 {
    /**
     * 给定三个整数数组
     * A = [A1, A2, ... AN],
     * B = [B1, B2, ... BN],
     * C = [C1, C2, ... CN]，
     * 请你统计有多少个三元组(i, j, k) 满足：
     * 1. 1 <= i, j, k <= N  
     * 2. Ai < Bj < Ck  
     * 【输入格式】
     * 第一行包含一个整数N。
     * 第二行包含N个整数A1, A2, ... AN。
     * 第三行包含N个整数B1, B2, ... BN。
     * 第四行包含N个整数C1, C2, ... CN。
     * 对于30%的数据，1 <= N <= 100  
     * 对于60%的数据，1 <= N <= 1000
     * 对于100%的数据，1 <= N <= 100000 0 <= Ai, Bi, Ci <= 100000
     * 【输出格式】
     * 一个整数表示答案
     * 【样例输入】
     * 3
     * 1 1 1
     * 2 2 2
     * 3 3 3
     * 【样例输出】
     * 27
     */
    static int N;
    static long count;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        int a[] = new int[N];
        int b[] = new int[N];
        int c[] = new int[N];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0) {
                    a[j] = s.nextInt();
                } else if (i == 1) {
                    b[j] = s.nextInt();
                } else if (i == 2) {
                    c[j] = s.nextInt();
                }
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        for (int i = 0; i < b.length; i++) {
            int q = 0, p = 0;
            while (q < a.length && a[q] < b[i]) {
                q++;
            }
            while (p < c.length && c[p] > b[i]) {
                p++;
            }

            count += q * p;
        }
        System.out.println(count);
    }


}
