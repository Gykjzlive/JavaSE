package JDBC.day01;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/6/17 11:47
 */
public class JDBCUtils {
    /**
     * 获取数据库连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        //获取基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBC\\day01\\jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);
        String url=properties.getProperty("url");
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String driverClass=properties.getProperty("driverClass");

        //加载驱动类
        Class.forName(driverClass);

        //获取连接(使用驱动管理类进行获取连接)
        Connection conn= DriverManager.getConnection(url,user,password);
        return conn;
    };
    public static void closeResource(Connection con, PreparedStatement ps){
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
