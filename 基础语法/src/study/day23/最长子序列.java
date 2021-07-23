package study.day23;

import java.util.Scanner;

/**
 我们称一个字符串 S 包含字符串 T 是指 T 是 S 的一个子序列，即可以从
 字符串 S 中抽出若干个字符，它们按原来的顺序组合成一个新的字符串与 T 完
 全一样。
 给定两个字符串 S 和 T，请问 T 中从第一个字符开始最长连续多少个字符
 被 S 包含？
 【输入格式】
 输入两行，每行一个字符串。第一行的字符串为 S，第二行的字符串为 T。
 两个字符串均非空而且只包含大写英文字母。
 【输出格式】
 输出一个整数，表示答案。
 【样例输入】
 ABCDEABCD
 AABZ
 【样例输出】
 3
 */
public class 最长子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a=scanner.nextLine();
        String b=scanner.nextLine();
        int [][] flag=new int[a.length()+1][b.length()+1];
        for (int i = 0; i <=a.length() ; i++) {
            for (int j = 0; j <=b.length() ; j++) {
                if(i==0||j==0){
                    flag[i][j]=0;
                }else if (a.charAt(i-1)==b.charAt(j-1)){
                    flag[i][j]=flag[i-1][j-1]+1;
                }else {
                    flag[i][j]=Math.max(flag[i-1][j],flag[i][j-1]);
                }
            }
        }
        System.out.println(flag[a.length()][b.length()]);
    }
}
