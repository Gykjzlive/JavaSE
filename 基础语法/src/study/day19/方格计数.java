package study.day19;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/26 22:32
 */
public class 方格计数 {
    /**
     * 在二维平面上有无数个1x1的小方格。
     * 我们以某个小方格的一个顶点为圆心画一个半径为1000的圆。
     * 你能计算出这个圆里有多少个完整的小方格吗？
     */
    public static void main(String[] args) {
        int r = 1000;
        int count = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                if ((i * i) + (j * j) <= r * r) {
                    count++;
                }
            }
        }
        System.out.println(count * 4);
    }
}
