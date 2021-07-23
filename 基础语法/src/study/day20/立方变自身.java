package study.day20;

/**
 * 观察下面的现象,某个数字的立方，按位累加仍然等于自身。
 * 1^3 = 1
 * 8^3  = 512    5+1+2=8
 * 17^3 = 4913   4+9+1+3=17
 * ...
 * <p>
 * 请你计算包括1,8,17在内，符合这个性质的正整数一共有多少个？
 * <p>
 * 请填写该数字，不要填写任何多余的内容或说明性的文字。
 */
public class 立方变自身 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            long data = i * i * i;
            long sum = 0;
            while (data > 0) {
                sum += data % 10;
                data /= 10;
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
