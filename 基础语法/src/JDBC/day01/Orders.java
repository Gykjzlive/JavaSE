package JDBC.day01;

import java.sql.Date;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/4 15:49
 */
public class Orders {
    private int id;
    private String name;
    private Date date;


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + date + '\'' +
                '}';
    }
}
