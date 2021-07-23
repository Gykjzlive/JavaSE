package study.day23;

import java.util.Scanner;

/**
 X星的坦克战车很奇怪，它必须交替地穿越正能量辐射区和负能量辐射区才能保持正常运转，否则将报废。
 某坦克需要从A区到B区去（A，B区本身是安全区，没有正能量或负能量特征），怎样走才能路径最短？

 已知的地图是一个方阵，上面用字母标出了A，B区，其它区都标了正号或负号分别表示正负能量辐射区。
 例如：
 A + - + -
 - + - - +
 - + + + -
 + - + - +
 B + - + -

 坦克车只能水平或垂直方向上移动到相邻的区。

 数据格式要求：

 输入第一行是一个整数n，表示方阵的大小， 4<=n<100
 接下来是n行，每行有n个数据，可能是A，B，+，-中的某一个，中间用空格分开。
 A，B都只出现一次。

 要求输出一个整数，表示坦克从A区到B区的最少移动步数。
 如果没有方案，则输出-1

 例如：
 用户输入：
 5
 A + - + -
 - + - - +
 - + + + -
 + - + - +
 B + - + -

 则程序应该输出：
 10

 */
public class 穿越雷区 {
    static int [][] direction={{-1,0},{0,-1},{1,0},{0,1}};
    static boolean[][] flag;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        flag=new boolean[n][n];
        scanner.nextLine();
        String [][] data=new String[5][5];
        for (int i = 0; i <n ; i++) {
            data[i]=scanner.nextLine().split(" ");
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if (data[i][j].equals("A")){
                    bfs(i,j,data,0);
                }
            }
        }
        System.out.println(min);
    }

    private static void bfs(int i, int j, String[][] data,int count) {
        if (data[i][j].equals("B")){
            if (count<min){
                min=count;
            }
            return;
        }
        flag[i][j]=true;
        for (int k = 0; k <direction.length ; k++) {
            int li=i+direction[k][0];
            int lj=j+direction[k][1];
            if (li>=0&&li<data.length&&lj>=0&&lj<data.length&&!data[li][lj].equals(data[i][j])&&!flag[li][lj]){
                bfs(li,lj,data,count+1);
            }
        }
        flag[i][j]=false;
    }
}
