package JDBC.day01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/6/22 23:00
 */
public class CustomersQuery {
    public static void main(String[] args) throws Exception {
        Connection conn=JDBCUtils.getConnection();
        String sql="select id,name,email,birth from customers";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            int id=resultSet.getInt(1);
            String name=resultSet.getString(2);
            String email=resultSet.getString(3);
            Date birth=resultSet.getDate(4);
            Customers cs = new Customers(id, name, email, birth);
            System.out.println(cs);
        }
        resultSet.close();
        ps.close();
        conn.close();
    }
}
