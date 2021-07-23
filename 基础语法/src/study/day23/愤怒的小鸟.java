package study.day23;

/**
 X星球愤怒的小鸟喜欢撞火车！

 一根平直的铁轨上两火车间相距 1000 米
 两火车 （不妨称A和B） 以时速 10米/秒 相对行驶。

 愤怒的小鸟从A车出发，时速50米/秒，撞向B车，
 然后返回去撞A车，再返回去撞B车，如此往复....
 两火车在相距1米处停车。

 问：这期间愤怒的小鸟撞 B 车多少次？
 */
public class 愤怒的小鸟 {
    static double A=0,B=1000,Bird=0;
    static  boolean flag=true;
    static int count;
    public static void main(String[] args) {
        while (B-A>1){
            if (flag){
                double time=(B-A)/60;
                A+=10*time;
                B-=10*time;
                Bird+=50*time;
                count++;
                flag=false;
            }else {
                double time=(B-A)/60;
                A+=10*time;
                B-=10*time;
                Bird-=50*time;
                flag=true;
            }
        }
        System.out.println(count);
    }
}
