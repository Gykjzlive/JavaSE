package study.day19;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/4/5 22:39
 */
public class 数列求值 {
    /**
     * 给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。求 第 20190324 项的最后 4 位数字。
     * 【答案提交】
     * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一 个 4 位整数（提示：答案的千位不为 0），在提交答案时只填写这个整数，填写 多余的内容将无法得分。
     */
    public static void main(String[] args) {
        long[] l = new long[20190324];
        l[0] = 1;
        l[1] = 1;
        l[2] = 1;
        for (int i = 3; i < 20190324; i++) {
            l[i] = l[i - 1] + l[i - 2] + l[i - 3];
            if (l[i] > 10000) {
                l[i] %= 10000;
            }
        }
        System.out.println(l[20190323]);
    }
}
