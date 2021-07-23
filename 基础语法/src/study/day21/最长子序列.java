package study.day21;

import java.util.Scanner;

/**
 我们称一个字符串 S 包含字符串 T 是指 T 是 S 的一个子序列，即可以从字符串 S 中抽出若干个字符，它们按原来的顺序组合成一个新的字符串与 T 完全一样。
 给定两个字符串 S 和 T，请问 T 中从第一个字符开始最长连续多少个字符被 S 包含？
 Input：
 ABCDEABCD
 AABZ

 Output：
 3
 */
public class 最长子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a=scanner.next();
        String b=scanner.next();
        int [][] data=new int[a.length()+1][b.length()+1];
        for (int i = 0; i <=a.length(); i++) {
            for (int j = 0; j <=b.length() ; j++) {
                if (i==0||j==0){
                    data[i][j]=0;
                }else if (a.charAt(i-1)==b.charAt(j-1)){
                    data[i][j]=data[i-1][j-1]+1;
                }else {
                    data[i][j]=Math.max(data[i-1][j],data[i][j-1]);
                }
            }
        }
        System.out.println(data[a.length()][b.length()]);
    }
}
