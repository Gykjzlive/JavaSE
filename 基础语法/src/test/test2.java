package test;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/4/12 11:14
 */
public class test2 {
    public static void main(String[] args) {
        int n = f("jtrhabcd", "baadabcabcd");
        System.out.println(n);
    }

    private static int f(String a, String b) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int[][] n = new int[s1.length + 1][s2.length + 1];
        int max = 0;
        for (int i = 1; i < s1.length + 1; i++) {
            for (int j = 1; j < s2.length + 1; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    n[i][j] = n[i - 1][j - 1] + 1;
                    if (n[i][j] > max) {
                        max = n[i][j];
                    }
                }
            }
        }
        return max;
    }
}
