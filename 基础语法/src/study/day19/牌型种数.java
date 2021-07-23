package study.day19;

public class 牌型种数 {
    /*
    小明被劫持到X赌城，被迫与其他3人玩牌。
    一副扑克牌（去掉大小王牌，共52张），均匀发给4个人，每个人13张。
    这时，小明脑子里突然冒出一个问题：
    如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢？
    请填写该整数，不要填写任何多余的内容或说明文字
     */
    static int count = 0;//方法二定义的计数器

    public static void main(String[] args) {
        //方法一：暴力枚举
        /*
        int [] a=new int [13];
        int count=0;
        for(a[0] = 0 ; a[0] < 5 ; a[0]++)
            for(a[1] = 0 ; a[1] < 5 ; a[1]++)
                for(a[2] = 0 ; a[2] < 5 ; a[2]++)
                    for(a[3] = 0 ; a[3] < 5 ; a[3]++)
                        for(a[4] = 0 ; a[4] < 5 ; a[4]++)
                            for(a[5] = 0 ; a[5] < 5 ; a[5]++)
                                for(a[6] = 0 ; a[6] < 5 ; a[6]++)
                                    for(a[7] = 0 ; a[7] < 5 ; a[7]++)
                                        for(a[8] = 0 ; a[8] < 5 ; a[8]++)
                                            for(a[9] = 0 ; a[9] < 5 ; a[9]++)
                                                for(a[10] = 0 ; a[10] < 5 ; a[10]++)
                                                    for(a[11] = 0 ; a[11] < 5 ; a[11]++)
                                                        for(a[12] = 0 ; a[12] < 5 ; a[12]++) {
                                                            if(a[0]+a[1]+a[2]+a[3]+a[4]+a[5]+a[6]+a[7]+a[8]+a[9]+a[10]+a[11]+a[12]==13) {
                                                                count++;
                                                            }
                                                        }
        System.out.println(count);

         */
        //方法二：递归 每种牌的数量有0，1，2，3，4五种情况，利用这点进行递归运算
        f(0, 0);
        System.out.println(count);
    }

    /*
     * num为牌的点数，k为手牌数
     */
    private static void f(int num, int k) {
        if (num > 13 || k > 13)
            return;//牌数或点数大于13结束
        if (num == 13 && k == 13) {
            count++;
            return;
        }
        for (int i = 0; i < 5; i++) {
            f(num + 1, k + i);
        }
    }
}
