package study.day20;

/**
 * 给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。求
 * 第 20190324 项的最后 4 位数字。
 */
public class 数列求值 {
    public static void main(String[] args) {
        long array[] = new long[20190324];
        for (int i = 0; i < 20190324; i++) {
            if (i == 0 || i == 1 || i == 2) {
                array[i] = 1;
            } else {
                array[i] = (array[i - 1] + array[i - 2] + array[i - 3]) % 10000;
            }
        }
        System.out.println(array[20190323]);
    }
}
