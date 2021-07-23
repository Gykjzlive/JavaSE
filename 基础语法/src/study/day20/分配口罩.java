package study.day20;

/**
 * 某市市长获得了若干批口罩，给定每批口罩的数量，
 * 市长要把口罩分配给市内的 2 所医院，由于物流限制，每一批口罩只能全部分配给其中一家医院。
 * 市长希望 2 所医院获得的口罩总数之差越小越好。 请你计算这个差最小是多少？
 * 答案提交
 * 这是一道结果填空题，你只需要算出结果后提交即可。
 * 本题的结果为一个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class 分配口罩 {
    static long l = Long.MAX_VALUE;
    static long num[] = {9090400, 8499400, 5926800, 8547000, 4958200,
            4422600, 5751200, 4175600, 6309600, 5865200,
            6604400, 4635000, 10663400, 8087200, 4554000
    };

    public static void main(String[] args) {
        f(0, 0, 0);
        System.out.println(l);
    }

    private static void f(int index, long num1, long num2) {
        if (index == num.length) {
            l = Math.abs(num1 - num2) < l ? Math.abs(num1 - num2) : l;
            return;
        }
        f(index + 1, num1 + num[index], num2);
        f(index + 1, num1, num2 + num[index]);
    }
}
