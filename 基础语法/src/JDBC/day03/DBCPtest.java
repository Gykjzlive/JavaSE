package JDBC.day03;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/22 22:18
 */
public class DBCPtest {
    public static void main(String[] args) throws Exception {
        //方式一
//        BasicDataSource source=new BasicDataSource();
//        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        source.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&serverTimezone=Asia/Shanghai");
//        source.setUsername("root");
//        source.setPassword("032425");
//        source.setInitialSize(10);
//        source.setMaxActive(10);
//        Connection conn = source.getConnection();
//        System.out.println(conn);
        //方式二，使用配置文件
        Properties properties = new Properties();
        //方式一 :系统的类加载器
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBC\\day03\\dbcp.properties");
        //方式二
        FileInputStream fis = new FileInputStream(new File("D:\\JavaSE\\基础语法\\src\\JDBC\\day03\\dbcp.properties"));
        properties.load(fis);
        DataSource source = BasicDataSourceFactory.createDataSource(properties);
        Connection conn = source.getConnection();
        String sql="insert into customers(name,email,birth)values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,"李加加");
        ps.setObject(2,"8230582@qq.com");
        ps.setObject(3,"2012-5-3");
        ps.execute();
        ps.close();
        conn.close();

    }
}
