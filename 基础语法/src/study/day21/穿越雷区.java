package study.day21;

import java.util.Scanner;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/5/7 10:08
 */
public class 穿越雷区 {
    static int n;
    static char[][] chars;
    static int [][] direction={{-1,0},{0,-1},{1,0},{0,1}};
    static  boolean[][] flag;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        chars=new char[n][n];
        flag=new boolean[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                chars[i][j]=scanner.next().charAt(0);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
               if(chars[i][j]=='A'){
                  dfs(i,j,'0',0);
               }
            }
        }
        System.out.println(min);
    }

    private static void dfs(int i, int j, char c, int count) {
        if(chars[i][j]=='B'){
            if(count<min){
                min=count;
            }
            return;
        }
        flag[i][j]=true;
        for (int k = 0; k <4 ; k++) {
            int li=i+direction[k][0];
            int lj=j+direction[k][1];
            if(li>=0&&li<n&&lj>=0&&lj<n&&flag[li][lj]==false&&chars[li][lj]!=c){
                dfs(li,lj,chars[li][lj],count+1);
            }
        }
        flag[i][j]=false;
    }

}
