package JDBC.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/7/20 11:58
 */
public class TransactionTest {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql1="update user_table set balance=balance-100 where user=?";
            update(conn,sql1,"AA");
            String sql2="update user_table set balance=balance+100 where user=?";
            update(conn,sql2,"BB");
            System.out.println("修改成功");
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            conn.close();
        }
    }
    public static int update(Connection conn,String sql,Object... args) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        try {
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ps.close();
        }
        return 0;
    }
}
