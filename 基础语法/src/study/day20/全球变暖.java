package study.day20;

import java.util.Scanner;

/**
 * 你有一张某海域NxN像素的照片，"."表示海洋、"#"表示陆地，如下所示：
 * <p>
 * .......
 * .##....
 * .##....
 * ....##.
 * ..####.
 * ...###.
 * .......
 * <p>
 * 其中"上下左右"四个方向上连在一起的一片陆地组成一座岛屿。例如上图就有2座岛屿。
 * <p>
 * 由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，它就会被淹没。
 * <p>
 * 例如上图中的海域未来会变成如下样子：
 * <p>
 * .......
 * .......
 * .......
 * .......
 * ....#..
 * .......
 * .......
 * <p>
 * 请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。
 * <p>
 * 【输入格式】
 * 第一行包含一个整数N。  (1 <= N <= 1000)
 * 以下N行N列代表一张海域照片。
 * <p>
 * 照片保证第1行、第1列、第N行、第N列的像素都是海洋。
 * <p>
 * 【输出格式】
 * 一个整数表示答案。
 * <p>
 * 【输入样例】
 * 7
 * .......
 * .##....
 * .##....
 * ....##.
 * ..####.
 * ...###.
 * .......
 * <p>
 * 【输出样例】
 * 1
 */
public class 全球变暖 {
    static int n;
    static int live;
    static int[][] array;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        array = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = s.next();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '#') {
                    array[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (array[i][j] == 1) {
                    live++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(live);
    }

    private static void dfs(int i, int j) {
        array[i][j] = 2;//表示已搜
        if (array[i - 1][j] != 0 && array[i + 1][j] != 0 && array[i][j - 1] != 0 && array[i][j + 1] != 0) {
            live--;
            check(i, j);
            return;
        }
        if (array[i + 1][j] == 1) dfs(i + 1, j);
        if (array[i - 1][j] == 1) dfs(i - 1, j);
        if (array[i][j - 1] == 1) dfs(i, j - 1);
        if (array[i][j + 1] == 1) dfs(i, j + 1);
    }

    private static void check(int i, int j) {
        dfs2(i, j);
    }

    private static void dfs2(int i, int j) {
        if (array[i][j] == 0) {
            return;
        }
        array[i][j] = 0;
        if (array[i + 1][j] != 0) dfs2(i + 1, j);
        if (array[i - 1][j] != 0) dfs2(i - 1, j);
        if (array[i][j - 1] != 0) dfs2(i, j - 1);
        if (array[i][j + 1] != 0) dfs2(i, j + 1);
    }
}
