package study.day21;

import java.util.Scanner;

/**
 L 星球上的生物由蛋蓝质组成,每一种蛋蓝质由一类称为蓝肽的物资首尾连接成一条长链后折叠而成。
 生物学家小乔正在研究 L 星球上的蛋蓝质。她拿到两个蛋蓝质的蓝肽序列,想通过这两条蓝肽序列的共同特点来分析两种蛋蓝质的相似性。
 具体的,一个蓝肽可以使用 1 至 5 个英文字母表示,其中第一个字母大写,后面的字母小写。一个蛋蓝质的蓝肽序列可以用蓝肽的表示顺序拼接而成。
 在一条蓝肽序列中,如果选取其中的一些位置,把这些位置的蓝肽取出,并按照它们在原序列中的位置摆放,则称为这条蓝肽的一个子序列。蓝肽的子序列不一定在原序列中是连续的,中间可能间隔着一些未被取出的蓝肽。
 如果第一条蓝肽序列可以取出一个子序列与第二条蓝肽序列中取出的某个子序列相等,则称为一个公共蓝肽子序列。
 给定两条蓝肽序列,找出他们最长的那个公共蓝肽子序列的长度。
 【输入格式】
 输入两行,每行包含一个字符串,表示一个蓝肽序列。字符串中间没有空格等分隔字符。
 【输出格式】
 输出一个整数,表示最长的那个公共蓝肽子序列的长度。
 【样例输入】
 LanQiaoBei
 LanTaiXiaoQiao
 【样例输出】
 2
 【样例说明】
 最长的公共蓝肽子序列为 LanQiao,共两个蓝肽。
 */
public class 蓝肽子序列 {
    static int [][] ans;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a=scanner.nextLine();
        String b=scanner.nextLine();
        String[] arrayOne=stringsArray(a);
        String[] arrayTwo=stringsArray(b);
        ans=new int[arrayOne.length+1][arrayTwo.length+1];
        for (int i = 0; i <=arrayOne.length; i++) {
            for (int j = 0; j <=arrayTwo.length; j++) {
                if (i==0||j==0){
                    ans[i][j]=0;
                }else if (arrayOne[i-1].equals(arrayTwo[j-1])){
                    ans[i][j]=ans[i-1][j-1]+1;
                }else {
                    ans[i][j]=Math.max(ans[i-1][j],ans[i][j-1]);
                }
            }
        }
        System.out.println(ans[arrayOne.length][arrayTwo.length]);
    }
    public static String[] stringsArray(String a){
        String [] arr=new String[1000];
        int start=0;
        int count=0;
        for (int i = 0; i <a.length() ; i++) {
            if (i==a.length()-1){
                arr[count++]=a.substring(start);
            }
            if(Character.isUpperCase(a.charAt(i))){
                arr[count++]=a.substring(start,i);
                start=i;
            }
        }
        String [] array=new String[count];
        for (int i = 0; i <array.length ; i++) {
            array[i]=arr[i];
        }
        return array;
    }
}
