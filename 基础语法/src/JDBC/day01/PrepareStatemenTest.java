package JDBC.day01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/6/18 23:02
 */
public class PrepareStatemenTest {
    public static  void testUpdate() throws Exception {
        //获取数据库连接
        Connection conn=JDBCUtils.getConnection();
        //预编译sql语句
        String sql="update customers set name=? where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        //填充占位符
        ps.setString(1,"贝多芬");
        ps.setInt(2,18);
        //执行
        ps.execute();
        //关闭资源
        JDBCUtils.closeResource(conn,ps);
    }
    public static void testDelete() throws Exception {
        Connection conn = JDBCUtils.getConnection();

        String sql="delete from customers where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1,19);

        ps.execute();

        JDBCUtils.closeResource(conn,ps);
    }

    public static void usualOperate(String sql,Object... args) throws Exception {
        Connection conn = JDBCUtils.getConnection();

        PreparedStatement ps = conn.prepareStatement(sql);

        for (int i = 0; i <args.length ; i++) {
            ps.setObject(i+1,args[i]);
        }

        ps.execute();

        JDBCUtils.closeResource(conn,ps);
    }

    public static void main(String[] args) throws Exception {
        String sql="insert into customers(name,email,birth) values(?,?,?)";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date=simpleDateFormat.parse("2021-6-19");
//        usualOperate(sql,"李加加","ljj@qq.com",new Date(date.getTime()));
//        usualOperate("update customers set name=? where id=?","寇金忠",18);
        usualOperate("delete from customers where id=?",20);
    }
}
