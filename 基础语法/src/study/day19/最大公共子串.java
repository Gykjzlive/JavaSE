package study.day19;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/4/9 22:12
 */
public class 最大公共子串 {
    public static void main(String[] args) {
        String s1 = "ajhfieoqfhqfhello";
        String s2 = "jdsfiohellodgdsgspiejfenwfj";
        System.out.println(f(s1, s2));
    }

    private static String f(String s1, String s2) {
        String max_str = s1.length() >= s2.length() ? s1 : s2;
        String min_str = s1.length() < s2.length() ? s1 : s2;
        for (int i = 0; i < min_str.length(); i++) {
            for (int low = 0, hid = min_str.length() - i; low < hid && hid <= min_str.length(); low++, hid++) {
                if (max_str.contains(min_str.substring(low, hid))) {
                    return min_str.substring(low, hid);
                }
            }
        }
        return null;
    }
}
