package study.day17;

public class test01 {
    public static void main(String[] args) {
        for (hhh h : hhh.values()) {
            for (hhh h2 : hhh.values()) {
                if (h != h2) {
                    System.out.print(h + "" + h2 + " ");
                }
            }
            System.out.println();
        }
    }
}

enum hhh {
    a, b, c, d, e, f
}