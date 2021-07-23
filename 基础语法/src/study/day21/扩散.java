package study.day21;

import java.util.LinkedList;

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
    static int [][] direction={{-1,0},{0,-1},{1,0},{0,1}};
    static int [][] flag=new int[8000][8000];
    static long count=4;
    public static void main(String[] args) {
        LinkedList<index> linkedList=new LinkedList<index>();
        linkedList.add(new index(3000,3000,0));
        linkedList.add(new index(5020,3011,0));
        linkedList.add(new index(3011,3014,0));
        linkedList.add(new index(5000,5000,0));
        flag[3000][3000]=1;
        flag[5020][3011]=1;
        flag[3011][3014]=1;
        flag[5000][5000]=1;
        while(!linkedList.isEmpty()){
            index data=linkedList.poll();
            int x=data.x;
            int y=data.y;
            int time=data.time;
            if (time==2020){
                break;
            }
            for (int i = 0; i < direction.length; i++) {
                int lx=x+direction[i][0];
                int ly=y+direction[i][1];
                if(flag[lx][ly]==0){
                    linkedList.add(new index(lx,ly,time+1));
                    flag[lx][ly]=1;
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
