package study.day20;


import java.util.*;

/**
 * “饱了么”外卖系统中维护着 N 家外卖店，编号 1 ∼ N。每家外卖店都有
 * 一个优先级，初始时 (0 时刻) 优先级都为 0。
 * 每经过 1 个时间单位，如果外卖店没有订单，则优先级会减少 1，最低减
 * 到 0；而如果外卖店有订单，则优先级不减反加，每有一单优先级加 2。
 * 如果某家外卖店某时刻优先级大于 5，则会被系统加入优先缓存中；如果
 * 优先级小于等于 3，则会被清除出优先缓存。
 * 给定 T 时刻以内的 M 条订单信息，请你计算 T 时刻时有多少外卖店在优
 * 先缓存中。
 * <p>
 * 第一行包含 3 个整数 N、M 和 T。
 * 以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到
 * 一个订单。
 * 输入:
 * 2 6 6
 * 1 1
 * 5 2
 * 3 1
 * 6 2
 * 2 1
 * 6 2
 * 【样例输出】
 * 1
 */
public class 外卖店优先级 {
    public static void main(String[] args) {
        int n, m, t;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        t = s.nextInt();
        int[] score = new int[n + 1];
        int[][] data = new int[t + 1][n + 1];
        boolean[] flag = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int ts = s.nextInt();
            int id = s.nextInt();
            data[ts][id]++;
        }
        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= n; j++) {
                if (data[i][j] == 0) {
                    if (score[j] > 0) {
                        score[j]--;
                    }
                } else {
                    score[j] += data[i][j] * 2;
                }
                if (score[j] > 5) {
                    flag[j] = true;
                } else if (score[j] <= 3) {
                    flag[j] = false;
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (flag[i] == true) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
