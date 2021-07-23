package study.day20;

import java.util.Scanner;

/**
 * 如图p1.pgn所示的螺旋折线经过平面上所有整点恰好一次。
 * 对于整点(X, Y)，我们定义它到原点的距离dis(X, Y)是从原点到(X, Y)的螺旋折线段的长度。
 * <p>
 * 例如dis(0, 1)=3, dis(-2, -1)=9
 * <p>
 * 给出整点坐标(X, Y)，你能计算出dis(X, Y)吗？
 * <p>
 * 【输入格式】
 * X和Y
 * <p>
 * 对于40%的数据，-1000 <= X, Y <= 1000
 * 对于70%的数据，-100000 <= X， Y <= 100000
 * 对于100%的数据, -1000000000 <= X, Y <= 1000000000
 * <p>
 * 【输出格式】
 * 输出dis(X, Y)
 * <p>
 * <p>
 * 【输入样例】
 * 0 1
 * <p>
 * 【输出样例】
 * 3
 */
public class 螺旋折线 {
    static long[] array;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = 0, y = 0;
        x = s.nextInt();
        y = s.nextInt();
        array = new long[1001];
        for (int i = 1; i < array.length; i++) {
            if (i == 1) {
                array[i] = i * 8;
            } else {
                array[i] = i * 8 + array[i - 1];
            }
        }
        System.out.println(dis(x, y));
    }

    private static int dis(int x, int y) {

        return 0;
    }
}
