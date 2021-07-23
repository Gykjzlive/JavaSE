package study.day21;

/**
 小蓝有一条玩具蛇,一共有 16 节,上面标着数字 1 至 16。每一节都是一个正方形的形状。相邻的两节可以成直线或者成 90 度角。
 小蓝还有一个 4 × 4 的方格盒子,用于存放玩具蛇,盒子的方格上依次标着字母 A 到 P 共 16 个字母。
 小蓝可以折叠自己的玩具蛇放到盒子里面。他发现,有很多种方案可以将玩具蛇放进去。
 下图给出了两种方案:



 请帮小蓝计算一下,总共有多少种不同的方案。如果两个方案中,存在玩具蛇的某一节放在了盒子的不同格子里,则认为是不同的方案。

 */
public class 玩具蛇 {
    static int[][] direction={{-1,0},{0,-1},{1,0},{0,1}};
    static boolean[][] flag=new boolean[4][4];
    static int count;
    public static void main(String[] args) {
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {
                flag[i][j]=true;
                dfs(i,j,1);
                flag[i][j]=false;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int i, int j, int len) {
        if(len==16){
            count++;
            return;
        }
        for (int k = 0; k <direction.length ; k++) {
            int li=i+direction[k][0];
            int lj=j+direction[k][1];
            if(li>=0&&li<4&&lj>=0&&lj<4&&!flag[li][lj]){
                flag[li][lj]=true;
                dfs(li,lj,len+1);
                flag[li][lj]=false;
            }
        }
    }
}
