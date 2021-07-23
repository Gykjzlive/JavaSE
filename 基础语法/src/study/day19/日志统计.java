package study.day19;

import java.util.Scanner;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/30 18:21
 */
public class 日志统计 {
    /**
     * 小明维护着一个程序员论坛。现在他收集了一份"点赞"日志，日志共有N行。其中每一行的格式是：
     * ts id
     * 表示在ts时刻编号id的帖子收到一个"赞"。
     * 现在小明想统计有哪些帖子曾经是"热帖"。如果一个帖子曾在任意一个长度为D的时间段内收到不少于K个赞，小明就认为这个帖子曾是"热帖"。
     * 具体来说，如果存在某个时刻T满足该帖在[T, T+D)这段时间内(注意是左闭右开区间)收到不少于K个赞，该帖就曾是"热帖"。
     * 给定日志，请你帮助小明统计出所有曾是"热帖"的帖子编号。
     * 【输入格式】
     * 第一行包含三个整数N、D和K。
     * 以下N行每行一条日志，包含两个整数ts和id。
     * 对于50%的数据，1 <= K <= N <= 1000
     * 对于100%的数据，1 <= K <= N <= 100000 0 <= ts <= 100000 0 <= id <= 100000
     * 【输出格式】
     * 按从小到大的顺序输出热帖id。每个id一行。
     * 【输入样例】
     * 7 10 2
     * 0 1
     * 0 10
     * 10 10
     * 10 1
     * 9 1
     * 100 3
     * 100 3
     * 【输出样例】
     * 1
     * 3
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int D = s.nextInt();
        int K = s.nextInt();
        int[][] a = new int[N][2];
        int[][] b = new int[100000][3];
        for (int i = 0; i < a.length; i++) {//0放时间段，1放ID
            a[i][0] = s.nextInt();
            a[i][1] = s.nextInt();
        }
        for (int i = 0; i < 100000; i++) {//0放时间段，1放ID,2放点赞次数
            b[i][0] = -1;
            b[i][1] = i;
        }
        for (int i = 0; i < a.length; i++) {
            int id = a[i][1];
            if (b[id][0] == -1) {
                b[id][0] = a[i][0];
            }
            if (Math.abs(a[i][0] - b[id][0]) >= D) {
                break;
            }
            b[id][2] += 1;
            if (b[id][2] == K) {
                System.out.println(id);
            }
        }
    }
}
