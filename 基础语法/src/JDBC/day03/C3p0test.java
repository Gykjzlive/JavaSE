package JDBC.day03;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/22 17:57
 */
public class C3p0test {
    public static void main(String[] args) throws Exception {
        //方式一:获取c3p0数据库连接池
//        ComboPooledDataSource cpds = new ComboPooledDataSource();
//        cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
//        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&serverTimezone=Asia/Shanghai");
//        cpds.setUser("root");
//        cpds.setPassword("032425");
//        cpds.setInitialPoolSize(10);
//        Connection conn = cpds.getConnection();
//        System.out.println(conn);

        //方式二：通过xml文件获取连接
        ComboPooledDataSource cpds = new ComboPooledDataSource("c3p0");
        Connection conn = cpds.getConnection();
        String sql="insert into customers(name,email,birth)values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,"袁文轩");
        ps.setObject(2,"8743832@qq.com");
        ps.setObject(3,"2012-3-4");
        ps.execute();
        ps.close();
        conn.close();
    }
}
