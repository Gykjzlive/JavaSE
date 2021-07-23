package JDBC.day01;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/6/16 11:34
 */
public class PrepareStatemenInsert {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
        Connection con= null;
        PreparedStatement ps = null;
        try {
            InputStream resourceAsStream = PrepareStatemenInsert.class.getClassLoader().getResourceAsStream("JDBC\\day01\\jdbc.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            String url=properties.getProperty("url");
            String user=properties.getProperty("user");
            String password=properties.getProperty("password");
            String driverClass=properties.getProperty("driverClass");

            Class.forName(driverClass);

            con = DriverManager.getConnection(url,user,password);
//          System.out.println(con);

            String sql="insert into customers(name,email,birth)values(?,?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(1,"哪吒");
            ps.setString(2,"nezha@qq.com");
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date=simpleDateFormat.parse("2021-6-17");
            ps.setDate(3,new Date(date.getTime()));

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
}
