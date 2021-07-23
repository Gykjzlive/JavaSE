package study.day20;

import java.util.Scanner;

/**
 * 小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有N种蒸笼，其中第i种蒸笼恰好能放Ai个包子。每种蒸笼都有非常多笼，可以认为是无限笼。
 * <p>
 * 每当有顾客想买X个包子，卖包子的大叔就会迅速选出若干笼包子来，使得这若干笼中恰好一共有X个包子。比如一共有3种蒸笼，分别能放3、4和5个包子。
 * 当顾客想买11个包子时，大叔就会选2笼3个的再加1笼5个的（也可能选出1笼3个的再加2笼4个的）。
 * <p>
 * 当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有3种蒸笼，分别能放4、5和6个包子。而顾客想买7个包子时，大叔就凑不出来了。
 * <p>
 * 小明想知道一共有多少种数目是包子大叔凑不出来的。
 * <p>
 * 输入
 * ----
 * 第一行包含一个整数N。(1 <= N <= 100)
 * 以下N行每行包含一个整数Ai。(1 <= Ai <= 100)
 * <p>
 * 输出
 * ----
 * 一个整数代表答案。如果凑不出的数目有无限多个，输出INF。
 * <p>
 * 例如，
 * 输入：
 * 2
 * 4
 * 5
 * 程序应该输出：
 * 6
 * 再例如，
 * 输入：
 * 2
 * 4
 * 6
 * 程序应该输出：
 * INF
 * <p>
 * 样例解释：
 * 对于样例1，凑不出的数目包括：1, 2, 3, 6, 7, 11。
 * 对于样例2，所有奇数都凑不出来，所以有无限多个。
 * <p>
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 */
public class 包子凑数 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n + 1];
        boolean[] dp = new boolean[10000];
        dp[0] = true;
        int g = 0;
        for (int i = 1; i <= n; i++) {
            array[i] = s.nextInt();
            if (i == 1) {
                g = array[i];
            } else {
                g = gcd(array[i], g);
            }
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] && j + array[i] < dp.length) {
                    dp[j + array[i]] = true;
                }
            }
        }
        if (g != 1) {
            System.out.println("INF");
            return;
        }
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            if (!dp[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
