package study.day23;


import java.util.Scanner;

/**
 ****T.
 ****..
 *****.
 *****.
 **S...
 */
public class 迷宫 {

    static boolean [][] flag=new boolean[5][6];
    static int [][] direction={{1,0},{0,-1},{-1,0},{0,1}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char data[][] =new char[5][6];
        for (int i = 0; i <5; i++) {
            data[i]=scanner.nextLine().toCharArray();
        }
        for (int i = 0; i <data.length ; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == 'T') {
                    dfs(i,j,data);
                }
            }
        }
        for (int i = 0; i <data.length ; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean dfs(int i, int j, char[][] data) {
        if (data[i][j]=='S'){
            return true;
        }
        flag[i][j]=true;
        data[i][j]='+';
        for (int k = 0; k <direction.length ; k++) {
            int li=i+direction[k][0];
            int lj=j+direction[k][1];
            if (li>=0&&li<5&&lj>=0&&lj<6&&!flag[li][lj]&&data[li][lj]!='*'){
                if (dfs(li,lj,data)){
                    return true;
                }
            }
        }
        flag[i][j]=false;
        data[i][j]='.';
        return false;
    }
}
