package study.day20;

/**
 * 求1个整数的第k位数字有很多种方法。
 * 以下的方法就是一种。
 * 对于题目中的测试数据，应该打印5。
 */
public class 取位数 {
    static int len(int x) {
        if (x < 10) return 1;
        return len(x / 10) + 1;
    }

    // 取x的第k位数字
    static int f(int x, int k) {
        if (len(x) - k == 0) return x % 10;
        return f(x / 10, k);  //填空
    }

    public static void main(String[] args) {
//        int x = 23513;
        int x = 964536;
        //System.out.println(len(x));
        System.out.println(f(x, 3));
    }
}
