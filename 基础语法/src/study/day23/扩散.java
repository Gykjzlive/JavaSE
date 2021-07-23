package study.day23;

import java.util.LinkedList;
import java.util.List;

/**
 小蓝在一张无限大的特殊画布上作画。
 这张画布可以看成一个方格图，每个格子可以用一个二维的整数坐标表示。
 小蓝在画布上首先点了一下几个点：(0, 0), (2020, 11), (11, 14), (2000, 2000)。
 只有这几个格子上有黑色，其它位置都是白色的。
 每过一分钟，黑色就会扩散一点。具体的，如果一个格子里面是黑色，它
 就会扩散到上、下、左、右四个相邻的格子中，使得这四个格子也变成黑色
 （如果原来就是黑色，则还是黑色）。

 请问，经过 2020 分钟后，画布上有多少个格子是黑色的。
 */
public class 扩散 {
    static int count=4;
    static int[][] direction=new int[][]{{1,0},{0,-1},{-1,0},{0,1}};
    static boolean[][] flag=new boolean[8000][8000];
    public static void main(String[] args) {
        LinkedList<index> data=new LinkedList<>();
        data.add(new index(3000,3000,0));
        data.add(new index(5020,3011,0));
        data.add(new index(3011,3014,0));
        data.add(new index(5000,5000,0));
        flag[3000][3000]=true;
        flag[5020][3011]=true;
        flag[3011][3014]=true;
        flag[5000][5000]=true;
        while(!data.isEmpty()){
            index a=data.poll();
            int x=a.x;
            int y=a.y;
            int time=a.time;
            if (time==2020){
                System.out.println(1);
                continue;
            }
            for (int i = 0; i <direction.length; i++) {
                int lx=x+direction[i][0];
                int ly=y+direction[i][1];
                if (!flag[lx][ly]){
                    data.add(new index(lx,ly,time+1));
                    flag[lx][ly]=true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
class index{
    int x;
    int y;
    int time;

    public index(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}