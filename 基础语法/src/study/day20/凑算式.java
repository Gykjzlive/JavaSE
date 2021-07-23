package study.day20;

/**
 * B      DEF
 * A + --- + ------- = 10
 * C      GHI
 * （如果显示有问题，可以参见【图1.jpg】）
 * 这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。
 * 比如：
 * 6+8/3+952/714 就是一种解法，
 * 5+3/1+972/486 是另一种解法。
 * <p>
 * 这个算式一共有多少种解法？
 */
public class 凑算式 {
    static int count;

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        f(a, 0);
        System.out.println(count);
    }

    private static void f(int[] a, int index) {
        if (index == a.length) {
            if (checkArray(a)) {
                count++;
                return;
            }
            return;
        }
        if (index > a.length) return;
        for (int i = index; i < a.length; i++) {
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
            f(a, index + 1);
            temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }

    private static boolean checkArray(int[] array) {
//              B      DEF
//        A + --- + ------- = 10
//              C      GHI
        int a = array[0];
        int b = array[1];
        int c = array[2];
        int num1 = array[3] * 100 + array[4] * 10 + array[5];
        int num2 = array[6] * 100 + array[7] * 10 + array[8];
        if (a + ((b * num2 + num1 * c) / (c * num2)) == 10 && ((b * num2 + num1 * c) % (c * num2) == 0)) {
            return true;
        }
        return false;
    }
}
