package study.day19;

import java.util.Scanner;
/*
输入：6
输出：
5+1
4+2+2 4+2+1+1
3+3 3+2+1 3+1+1+1
2+2+2 2+2+1+1 2+1+1+1+1
1+1+1+1+1+1
 */

public class 数的加法划分 {
    public static void main(String[] args) {
        System.out.println("输入一个1到10的数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        f(n, data, 0);
    }

    private static void f(int n, int[] data, int a) {
        if (n <= 0) {
            for (int j = 0; j < a; j++) {
                if (data[j] == 0) break;
                System.out.print(data[j] + " ");
            }
            System.out.println();
        }
        for (int i = n; i > 0; i--) {
            if (a > 0 && i > data[a - 1]) continue;
            data[a] = i;
            f(n - i, data, a + 1);
        }
    }
}
