package JDBC.day01;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/8 17:19
 */
public class UsuallyQuery {
    public static void main(String[] args) throws Exception {
        System.out.println(Customers.class);
        String sql="select id,name,email,birth from customers where id=?";
        Customers cust = getInstance(Customers.class, sql, 18);
        System.out.println(cust);
        String sql2="select order_id id,order_name name,order_date 'date' from orders where order_id=?";
        Orders orders = getInstance(Orders.class, sql2, 2);
        System.out.println(orders);
    }
    public static  <Item>Item getInstance(Class<Item> itemClass,String sql,Object... args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i <args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()){
                Item item = itemClass.newInstance();
                for (int i = 0; i <rsmd.getColumnCount() ; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);
                    Field field = itemClass.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(item,columnValue);
                }
                return item;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        rs.close();
        ps.close();
        conn.close();
        return null;
    }
}
