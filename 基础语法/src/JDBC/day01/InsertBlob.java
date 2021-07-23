package JDBC.day01;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/16 23:06
 */
public class InsertBlob {
    @Test
    public void queryBlob() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql="select id,name,email,birth,photo from customers where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,21);
        ResultSet res = ps.executeQuery();
        while (res.next()){
            int id=res.getInt("id");
            String name = res.getString("name");
            String email = res.getString("email");
            Date birth = res.getDate("birth");
            Customers customers = new Customers(id, name, email, birth);
            System.out.println(customers);
            Blob photo = res.getBlob("photo");
            InputStream is = photo.getBinaryStream();
            FileOutputStream fos = new FileOutputStream("D:\\JavaSE\\基础语法\\src\\JDBC\\day01\\2.png");
            byte[] bytes = new byte[1024];
            int len;
            while((len=is.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
            fos.close();
            is.close();
        }
        res.close();
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream is = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql="insert into customers(name,email,birth,photo) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,"孙天炮");
            ps.setObject(2,"stp@qq.com");
            ps.setObject(3,"2013-3-2");
            is = new FileInputStream(new File("D:\\JavaSE\\基础语法\\src\\JDBC\\day01\\1.png"));
            ps.setBlob(4,is);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        is.close();
        ps.close();
        conn.close();
    }
}
