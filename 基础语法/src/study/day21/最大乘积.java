package study.day21;

/**
 把 1~9 这9个数字分成两组，中间插入乘号，
 有的时候，它们的乘积也只包含1~9这9个数字，而且每个数字只出现1次。

 比如：
 984672 * 351 = 345619872
 98751 * 3462 = 341875962
 9 * 87146325 = 784316925
 ...

 符合这种规律的算式还有很多，请你计算在所有这些算式中，乘积最大是多少？

 注意，需要提交的是一个整数，表示那个最大的积，不要填写任何多余的内容。
 （只提交乘积，不要提交整个算式）
 */
public class 最大乘积 {
    static int min=Integer.MIN_VALUE;
    public static void main(String[] args) {
        int [] data =new int[]{1,2,3,4,5,6,7,8,9};
        dfs(data,0);
        System.out.println(min);
    }

    private static void dfs(int[] data, int i) {
        if (i==data.length){
            int max=check(data);
            if (max>min){
                min=max;
            }
            return;
        }
        for (int j = i; j <data.length ; j++) {
            int temp=data[i];
            data[i]=data[j];
            data[j]=temp;
            dfs(data,i+1);
            temp=data[i];
            data[i]=data[j];
            data[j]=temp;
        }
    }

    private static int check(int[] data) {
        for (int i = 0; i <data.length-1; i++) {
            int num1=operate(0,i,data);
            int num2=operate(i+1,data.length-1,data);
            if (checkTwo(num1,num2)){
                return  num1*num2;
            }
        }
        return 0;
    }

    private static boolean checkTwo(int num1, int num2) {
        int [] flag=new int[10];
        int data=num1*num2;
        String s=String.valueOf(data);
        for (int i = 0; i <s.length() ; i++) {
            int a=s.charAt(i)-'0';
            if(a==0)return false;
            if (flag[a]==0){
                flag[a]++;
            }else {
                return false;
            }
        }
        return true;
    }

    private static int operate(int i, int j,int[] data) {
        String s="";
        for (int k = i; k <=j ; k++) {
            s+=data[k];
        }
        return Integer.parseInt(s);
    }
}
