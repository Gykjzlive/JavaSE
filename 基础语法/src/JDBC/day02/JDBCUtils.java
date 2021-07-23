package JDBC.day02;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/20 10:48
 */
public class JDBCUtils {

    public static Connection getConnection() throws Exception{
        //获取基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBC\\day02\\jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);
        String url=properties.getProperty("url");
        String user=properties.getProperty("user");
        String password = properties.getProperty("password");
        String driverClass = properties.getProperty("driverClass");
        //加载驱动类
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
        return  conn;
    }
}
