package study.day19;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/23 10:24
 */
public class 纸牌三角形 {
    /**
     * A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
     * 下图就是一种排法（如有对齐问题，参看p1.png）。
     *       A
     *      9 6
     *     4   8
     *    3 7 5 2
     * 这样的排法可能会有很多。
     * 如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？
     * 请你计算并提交该数字。          答案：144
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(f(a, 0) / 6);
    }

    private static int f(int[] a, int index) {
        int count = 0;
        if (index == a.length) {
            if (check(a)) {
                return 1;
            } else {
                return 0;
            }
        }
        for (int i = index; i < a.length; i++) {
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
            count += f(a, index + 1);
            temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
        return count;
    }

    private static boolean check(int[] a) {
        if (a[0] + a[1] + a[3] + a[5] == a[5] + a[6] + a[7] + a[8] && a[5] + a[6] + a[7] + a[8] == a[0] + a[2] + a[4] + a[8]) {
            return true;
        }
        return false;
    }

}
