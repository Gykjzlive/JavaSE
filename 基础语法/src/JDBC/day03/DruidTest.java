package JDBC.day03;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/22 23:18
 */
public class DruidTest {
    public static DataSource source;
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBC\\day03\\druid.properties");
        pro.load(is);
        source = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = source.getConnection();
        String sql="insert into customers(name,email,birth)values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,"李欧气");
        ps.setObject(2,"09382848@qq.com");
        ps.setObject(3,"2022-1-2");
        ps.execute();
    }
}
