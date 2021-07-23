package study.day20;

import java.util.HashSet;
import java.util.Set;

/**
 * 如【图1.jpg】, 有12张连在一起的12生肖的邮票。
 * 现在你要从中剪下5张来，要求必须是连着的。
 * （仅仅连接一个角不算相连）
 * 比如，【图2.jpg】，【图3.jpg】中，粉红色所示部分就是合格的剪取。
 * <p>
 * 请你计算，一共有多少种不同的剪取方法。
 */
public class 剪邮票 {
    static int count;
    static Set<String> set = new HashSet();

    public static void main(String[] args) {
        int a[] = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        f(a, 0);
        System.out.println(count);
    }

    private static void f(int[] a, int index) {
        if (index == a.length) {
            if (!isExist(a) && check(a)) {
                count++;
            }
            return;
        }
        for (int i = index; i < a.length; i++) {
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
            f(a, index + 1);
            temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
    }

    private static boolean isExist(int[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            s += a[i];
        }
        if (!set.contains(s)) {
            set.add(s);
            return false;
        }
        return true;
    }

    private static boolean check(int[] a) {
        int b[][] = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (a[i * 4 + j] == 1) {
                    b[i][j] = 1;
                } else {
                    b[i][j] = 0;
                }
            }
        }
        int cut = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (b[i][j] == 1) {
                    dfs(b, i, j);
                    cut++;
                }
            }
        }
        return cut == 1;
    }

    private static void dfs(int[][] b, int i, int j) {
        b[i][j] = 0;
        if (i - 1 >= 0 && b[i - 1][j] == 1) {
            dfs(b, i - 1, j);
        }
        if (i + 1 <= 2 && b[i + 1][j] == 1) {
            dfs(b, i + 1, j);
        }
        if (j - 1 >= 0 && b[i][j - 1] == 1) {
            dfs(b, i, j - 1);
        }
        if (j + 1 <= 3 && b[i][j + 1] == 1) {
            dfs(b, i, j + 1);
        }
    }
}
