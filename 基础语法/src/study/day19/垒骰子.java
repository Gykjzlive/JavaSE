package study.day19;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

/*
赌圣atm晚年迷恋上了垒骰子，就是把骰子一个垒在另一个上边，不能歪歪扭扭，要垒成方柱体。
经过长期观察，atm 发现了稳定骰子的奥秘：有些数字的面贴着会互相排斥！
我们先来规范一下骰子：1 的对面是 4，2 的对面是 5，3 的对面是 6。
假设有 m 组互斥现象，每组中的那两个数字的面紧贴在一起，骰子就不能稳定的垒起来。
atm想计算一下有多少种不同的可能的垒骰子方式。
两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同。
由于方案数可能过多，请输出模 10^9 + 7 的结果。
不要小看了 atm 的骰子数量哦～
「输入格式」
第一行两个整数 n m
n表示骰子数目
接下来 m 行，每行两个整数 a b ，表示 a 和 b 数字不能紧贴在一起。
「输出格式」
一行一个数，表示答案模 10^9 + 7 的结果。
「样例输入」
2 1
1 2
「样例输出」
544
「数据范围」
对于 30% 的数据：n <= 5
对于 60% 的数据：n <= 100
对于 100% 的数据：0 < n <= 10^9, m <= 36
 */
public class 垒骰子 {
    static int opposite[] = new int[7];//每个点的反面
    static boolean conflict[][] = new boolean[7][7];//冲突的点数，如果为true则冲突
    static long count;//计数
    static final long data = 1000000007;

    public static void main(String[] args) {
        opposite[1] = 4;
        opposite[2] = 5;
        opposite[3] = 6;
        opposite[4] = 1;
        opposite[5] = 2;
        opposite[6] = 3;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {//给冲突数组赋值
            int a = s.nextInt();
            int b = s.nextInt();
            conflict[a][b] = true;
            conflict[b][a] = true;
        }
        for (int i = 1; i <= 6; i++) {//1-6点，把当前点数的反面放入递归
            count = (count + f(opposite[i], n - 1)) % data;
        }
        System.out.println(count);
    }

    private static long f(int scroes, int n) {
        if (n == 0) {
            return 4;//（两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同）每层侧面都有四个
        }
        long ans = 0;
        for (int i = 1; i <= 6; i++) {
            if (conflict[scroes][i]) {
                continue;
            }
            ans = (ans + f(opposite[i], n - 1)) % data;
        }
        return (4 * ans) % data;
    }
}
