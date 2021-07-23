package study.day23;

/**
 小蓝有一条玩具蛇,一共有 16 节,上面标着数字 1 至 16。每一节都是一个正方形的形状。相邻的两节可以成直线或者成 90 度角。
 小蓝还有一个 4 × 4 的方格盒子,用于存放玩具蛇,盒子的方格上依次标着字母 A 到 P 共 16 个字母。
 小蓝可以折叠自己的玩具蛇放到盒子里面。他发现,有很多种方案可以将玩具蛇放进去。
 下图给出了两种方案:



 请帮小蓝计算一下,总共有多少种不同的方案。如果两个方案中,存在玩具蛇的某一节放在了盒子的不同格子里,则认为是不同的方案。
 */
public class 玩具蛇 {
    static int count;
    static int [][]direction={{1,0},{0,-1},{-1,0},{0,1}};
    static boolean [][] flag=new boolean[4][4];
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <4 ; j++) {
                flag[i][j]=true;
                dfs(i,j,1);
                flag[i][j]=false;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int i, int j, int cur) {
        if (cur==16){
            count++;
            return;
        }
        int lx,ly;
        for (int k = 0; k < direction.length; k++) {
            lx=i+direction[k][0];
            ly=j+direction[k][1];
            if (lx>=0&&lx<4&&ly>=0&&ly<4&&!flag[lx][ly]){
                flag[lx][ly]=true;
                dfs(lx,ly,cur+1);
                flag[lx][ly]=false;
            }
        }
    }
}
