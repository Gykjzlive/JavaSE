package study.day8;

public class test01 {
    public static void main(String[] args) {
        int i = 1, j = 1;
        while (true) {
            j = 1;
            while (true) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
                j++;
                if (j > i) {
                    break;
                }
            }
            i++;
            System.out.println();
            if (i > 9) {
                break;
            }
        }
    }
}
