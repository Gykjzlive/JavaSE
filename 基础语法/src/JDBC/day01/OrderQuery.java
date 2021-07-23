package JDBC.day01;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/4 15:39
 */
public class OrderQuery {
    public static void main(String[] args) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql="select order_id id,order_name name,order_date 'date' from orders";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd= rs.getMetaData();
        while(rs.next()){
            Orders orders=new Orders();
            for (int i = 0; i <rsmd.getColumnCount() ; i++) {
                Object columnValue = rs.getObject(i + 1);
                String columnName = rsmd.getColumnLabel(i + 1);
                Field field = Orders.class.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(orders,columnValue);
            }
            System.out.println(orders);
        }
        rs.close();
        ps.close();
        conn.close();
    }
}
