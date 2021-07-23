package study.day21;

import java.util.Scanner;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/5/4 15:29
 */
public class 迷宫 {
    /*
    ****T.
    ****..
    *****.
    *****.
    **S...
     */
    static String[][] strings;
    static boolean[][] flag=new boolean[5][6];
    static int[][] direction={{-1,0},{0,-1},{1,0},{0,1}};
    public static void main(String[] args) {
        strings= new String[5][6];
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i <5 ; i++) {
            String s=scanner.nextLine();
            char[] chars=s.toCharArray();
            for (int j = 0; j <6 ; j++) {
                strings[i][j]=String.valueOf(chars[j]);
            }
        }
        for (int i = 0; i<5; i++) {
            for (int j = 0; j <6 ; j++) {
                if(strings[i][j].equals("T")){
                    dfs(i,j);
                }
            }
        }
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <6 ; j++) {
                System.out.print(strings[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean dfs(int i, int j) {
        if(strings[i][j].equals("S")){
            return true;
        }
        flag[i][j]=true;
        strings[i][j]="m";
        for (int k = 0; k <4 ; k++) {
            int ti=i+direction[k][0];
            int tj=j+direction[k][1];
            if(ti>=0&&ti<strings.length&&tj>=0&&tj<strings[0].length&&!strings[ti][tj].equals("*")&&!flag[ti][tj]){
                if(dfs(ti,tj)){
                    return true;
                }
            }
        }
        flag[i][j]=false;
        strings[i][j]=".";
        return false;
    }
}
