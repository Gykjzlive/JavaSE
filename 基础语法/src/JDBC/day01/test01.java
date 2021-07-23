package JDBC.day01;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/6/16 7:38
 */

public class test01 {
    public static void main(String[] args) {

    }
    @Test
    public void jdbcCon() throws SQLException {
        Driver driver=new com.mysql.jdbc.Driver();
        String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","032425");
        Connection conn=driver.connect(url,info);
        System.out.println(conn);
    }
    @Test
    public void jdbcCon2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        Class clazz=Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver) clazz.getDeclaredConstructor().newInstance();
        String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
        Properties info=new Properties();
        info.setProperty("user","root" +
                "+");
        info.setProperty("password","032425");
        Connection conn=driver.connect(url,info);
        System.out.println(conn);
    }

    @Test
    public void jdbcCon3() throws IllegalAccessException, InstantiationException, ClassNotFoundException, SQLException {
        Class clazz=Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver) clazz.newInstance();
        String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","032425");
        DriverManager.registerDriver(driver);
        Connection coon =DriverManager.getConnection(url,info);
        System.out.println(coon);
    }
    @Test
    public void jdbcCon4() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","032425");
        Connection coon=DriverManager.getConnection(url,info);
        System.out.println(coon);
    }
    @Test
    public void jdbcCon5() throws IOException, ClassNotFoundException, SQLException {
        //读取配置文件
        InputStream is = test01.class.getClassLoader().getResourceAsStream("JDBC\\day01\\jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String url=properties.getProperty("url");
        String driverClass=properties.getProperty("driverClass");
        //加载驱动类
        Class.forName(driverClass);
        //获取连接
        Connection con=DriverManager.getConnection(url,user,password);
        System.out.println(con);
    }
}

