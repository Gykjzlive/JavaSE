package study.day19;

import java.util.Scanner;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/25 10:31
 */
public class 分巧克力 {
    /**
     * 儿童节那天有K位小朋友到小明家做客。小明拿出了珍藏的巧克力招待小朋友们。
     * 小明一共有N块巧克力，其中第i块是Hi x Wi的方格组成的长方形。
     *  为了公平起见，小明需要从这 N 块巧克力中切出K块巧克力分给小朋友们。切出的巧克力需要满足：
     *     1. 形状是正方形，边长是整数  
     *     2. 大小相同  
     * 例如一块6x5的巧克力可以切出6块2x2的巧克力或者2块3x3的巧克力。
     * 当然小朋友们都希望得到的巧克力尽可能大，你能帮小Hi计算出最大的边长是多少么？
     * 输入
     * 第一行包含两个整数N和K。(1 <= N, K <= 100000)  
     * 以下N行每行包含两个整数Hi和Wi。(1 <= Hi, Wi <= 100000) 
     * 输入保证每位小朋友至少能获得一块1x1的巧克力。   
     * 输出
     * 输出切出的正方形巧克力最大可能的边长。
     * 样例输入：
     * 2 10  
     * 6 5  
     * 5 6  
     * 样例输出：
     * 2
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[][] a = new int[n][2];
        int max_area = 0;
        for (int i = 0; i < n; i++) {
            a[i][0] = s.nextInt();
            a[i][1] = s.nextInt();
            max_area += a[i][0] * a[i][1] / k;
        }
        int max_Len = (int) Math.sqrt(max_area);
        int count = 0;
        for (int i = max_Len; i >= 1; i--) {
            count = 0;
            for (int j = 0; j < n; j++) {
                count += (a[j][0] / max_Len) * (a[j][1] / max_Len);
            }
            if (count >= k) {
                System.out.println(max_Len);
                break;
            }
        }
    }
}
