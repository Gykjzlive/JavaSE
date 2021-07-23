package study.day20;

/**
 * 我们以某个小方格的一个顶点为圆心画一个半径为1000的圆。
 * 你能计算出这个圆里有多少个完整的小方格吗？
 */
public class 方格计数 {
    static int r = 1000;

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= r; j++) {
                if (i * i + j * j <= r * r) {
                    count++;
                }
            }
        }
        System.out.println(count * 4);
    }
}
