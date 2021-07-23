package study.day16;
//数组查找

import java.util.Scanner;
import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int array[] = {23, 64, 3, 82, 343, 34, 65, 75};
        int n, m, i, p = 0;
        n = 0;
        m = array.length - 1;
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
        //冒泡排序
//        for(int k=0;k<array.length-1;k++){
//            for(int j=0;j<array.length-1;j++){
//                if(array[j]>array[j+1]){
//                    p=array[j];
//                    array[j]=array[j+1];
//                    array[j+1]=p;
//                }
//            }
//        }
//        System.out.println("冒泡排序:");
//        for (int i1 : array) {
//            System.out.print(i1+" ");
//        }
        //选择排序
//        for(int k=0;k<array.length-1;k++){
//            for(int j=k+1;j<array.length;j++){
//                if(array[k]>array[j]){
//                    p=array[k];
//                    array[k]=array[j];
//                    array[j]=p;
//                }
//            }
//        }
        System.out.println("选择排序:");

        for (int i1 : array) {
            System.out.print(i1 + " ");
        }
        System.out.println();
        while (n <= m) {
            i = (n + m) / 2;
            if (a == array[i]) {
                System.out.println("二分查找，索引在第" + i + "个位置");
                break;
            }
            if (a > array[i]) {
                n = i + 1;
            }
            if (a < array[i]) {
                m = i - 1;
            }
        }
    }
}
