package study.day21;

/**
 我国古籍很早就记载着

 2 9 4
 7 5 3
 6 1 8

 这是一个三阶幻方。每行每列以及对角线上的数字相加都相等。

 下面考虑一个相反的问题。
 可不可以用 1~9 的数字填入九宫格。
 使得：每行每列每个对角线上的数字和都互不相等呢？


 这应该能做到。
 比如：
 9 1 2
 8 4 3
 7 5 6

 你的任务是搜索所有的三阶反幻方。并统计出一共有多少种。
 旋转或镜像算同一种。

 比如：
 9 1 2
 8 4 3
 7 5 6

 7 8 9
 5 4 1
 6 3 2

 2 1 9
 3 4 8
 6 5 7

 等都算作同一种情况。

 请提交三阶反幻方一共多少种。这是一个整数，不要填写任何多余内容。
 */
public class 反幻方 {
    static int count;
    public static void main(String[] args) {
        int [] data={1,2,3,4,5,6,7,8,9};
        f(data,0);
        System.out.println(count/8);
    }

    private static void f(int[] data, int index) {
        if(index==data.length){
            if(check(data)){
                count++;
            }
            return;
        }
        for (int i = index; i <data.length ; i++) {
            int temp=data[index];
            data[index]=data[i];
            data[i]=temp;
            f(data,index+1);
            temp=data[index];
            data[index]=data[i];
            data[i]=temp;
        }
    }
//        9 1 2     0 1 2
//        8 4 3     3 4 5
//        7 5 6     6 7 8
    private static boolean check(int[] data) {
        int a[]=new int[8];
        a[0]=data[0]+data[1]+data[2];
        a[1]=data[3]+data[4]+data[5];
        a[2]=data[8]+data[7]+data[6];
        a[3]=data[0]+data[3]+data[6];
        a[4]=data[1]+data[4]+data[7];
        a[5]=data[2]+data[5]+data[8];
        a[6]=data[0]+data[4]+data[8];
        a[7]=data[2]+data[4]+data[6];
        for (int i = 0; i <a.length ; i++) {
            for (int j = i+1; j <a.length; j++) {
                if (a[i]==a[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
