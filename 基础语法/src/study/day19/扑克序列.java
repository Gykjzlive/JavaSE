package study.day19;

import java.util.Set;
import java.util.TreeSet;

public class 扑克序列 {
    static Set set = new TreeSet<String>();

    public static void main(String[] args) {
        char[] data = {'A', 'A', '2', '2', '3', '3', '4', '4'};
        f(data, 0);
        int i = 0;
        String s[] = new String[set.size()];
        for (Object o : set) {
            s[i] = o.toString();
            i++;
        }
        String min = s[0];
        for (int j = 0; j < s.length; j++) {
            if (min.compareTo(s[j]) > 0) {
                min = s[j];
            }
        }
        System.out.println(min);
    }

    private static void f(char[] n, int a) {
        if (a >= n.length) {
            check(n);
        }
        for (int i = a; i < n.length; i++) {
            char temp;
            temp = n[a];
            n[a] = n[i];
            n[i] = temp;
            f(n, a + 1);
            temp = n[a];
            n[a] = n[i];
            n[i] = temp;
        }
    }

    private static void check(char[] n) {
        String s = new String(n);
        int a = s.lastIndexOf("A") - s.indexOf("A");
        int b = s.lastIndexOf("2") - s.indexOf("2");
        int c = s.lastIndexOf("3") - s.indexOf("3");
        int d = s.lastIndexOf("4") - s.indexOf("4");
        if (a == 2 && b == 3 && c == 4 && d == 5) {
            set.add(s);
        }
    }
}
