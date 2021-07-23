package study.day19;

import java.util.Scanner;

public class 地宫取宝 {
    /*
题目描述
 X国王有一个地宫宝库。是  n  x  m  个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签。地宫的入口在左上角，出口在右下角。
小明被带到地宫的入口，国王要求他只能向右或向下行走。走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它（当然，也可以不拿）。
当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝贝就可以送给小明。请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这k件宝贝。
输入
输入一行3个整数，用空格分开：n  m  k  (1< =n,m< =50,  1< =k< =12)
接下来有  n  行数据，每行有  m  个整数  Ci  (0< =Ci< =12)代表这个格子上的宝物的价值
输出
要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对  1000000007  取模的结果。
样例输入
2 3 2
1 2 3
2 1 5
样例输出
14
     */
    static int data[][];
    static long array[][][][] = new long[51][51][14][13];
    static int n, m, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                for (int l = 0; l < 14; l++) {
                    for (int o = 0; o < 12; o++) {
                        array[i][j][l][o] = -1;
                    }
                }
            }
        }
        long count = f(0, 0, -1, 0);
        System.out.println(count);
    }

    private static long f(int a, int b, int max, int c) {
        if (array[a][b][max + 1][c] != -1) return array[a][b][max + 1][c];
        if (a >= n || b >= m || c > k) return 0;
        int cur = data[a][b];
        int count = 0;
        if (a == n - 1 && b == m - 1) {
            if (c == k || c == k - 1 && cur > max) {
                return 1;
            }
        }
        if (cur > max) {
            count += f(a + 1, b, cur, c + 1);
            count += f(a, b + 1, cur, c + 1);
        }
        count += f(a + 1, b, max, c);
        count += f(a, b + 1, max, c);
        array[a][b][max + 1][c] = count % 1000000007;
        return count % 1000000007;
    }
}
