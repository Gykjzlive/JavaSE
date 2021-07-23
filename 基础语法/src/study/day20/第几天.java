package study.day20;

import java.util.Calendar;

/**
 * 2000年的1月1日，是那一年的第1天。
 * 那么，2000年的5月4日，是那一年的第几天？
 */
public class 第几天 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH, 4);
        calendar.set(Calendar.DAY_OF_MONTH, 4);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

    }
}
