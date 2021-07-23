package study.day19;

import java.util.Calendar;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/22 22:48
 */
public class 高僧斗法 {
    /**
     * 问题描述
     * 　　古时丧葬活动中经常请高僧做法事。仪式结束后，有时会有“高僧斗法”的趣味节目，以舒缓压抑的气氛。
     * 　　节目大略步骤为：先用粮食（一般是稻米）在地上“画”出若干级台阶（表示N级浮屠）。又有若干小和尚随机地“站”在某个台阶上。最高一级台阶必须站人，其它任意。(如图1所示)
     * 　　两位参加游戏的法师分别指挥某个小和尚向上走任意多级的台阶，但会被站在高级台阶上的小和尚阻挡，不能越过。两个小和尚也不能站在同一台阶，也不能向低级台阶移动。
     * 　　两法师轮流发出指令，最后所有小和尚必然会都挤在高段台阶，再也不能向上移动。轮到哪个法师指挥时无法继续移动，则游戏结束，该法师认输。
     * 　　对于已知的台阶数和小和尚的分布位置，请你计算先发指令的法师该如何决策才能保证胜出。
     * 输入格式
     * 　　输入数据为一行用空格分开的N个整数，表示小和尚的位置。台阶序号从1算起，所以最后一个小和尚的位置即是台阶的总数。（N<100, 台阶总数<1000）
     * 输出格式
     * 　　输出为一行用空格分开的两个整数: A B, 表示把A位置的小和尚移动到B位置。若有多个解，输出A值较小的解，若无解则输出-1。
     * 样例输入
     * 1 5 9
     * 样例输出
     * 1 4
     * 样例输入
     * 1 5 8 10
     * 样例输出
     * 1 3
     */
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        for (int year = 1999; year < 10000; year += 100) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, 11);
            calendar.set(Calendar.DAY_OF_MONTH, 31);
            if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
                System.out.println(year);
                break;
            }
        }
    }
}
